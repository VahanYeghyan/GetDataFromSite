package com.vahan.web.pages;

import com.vahan.domain.Bank;
import com.vahan.domain.Currency;
import com.vahan.service.BankService;
import com.vahan.service.CurrencyService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.ArrayList;

/**
 * Created by vahan on 12/25/16.
 */
public class AdminPage extends WebPage {

    @SpringBean
    private BankService bankService;

    @SpringBean
    private CurrencyService currencyService;

    private Bank bank;

    private Currency currency;

    public AdminPage() {
        bank = new Bank();
        currency = new Currency();
    }


    @Override
    protected void onInitialize() {
        super.onInitialize();
        initialize();
    }

    private void initialize() {

        Button currenciesCreateButton = new Button("createCurrencies") {
            @Override
            public void onSubmit() {
                super.onSubmit();
                currencyService.saveCurrencies();
            }
        };
        add(currenciesCreateButton);

        Form<Void> bankNameForm = new Form<>("bankNameForm");
        add(bankNameForm);

        TextField bankNameTextField = new TextField("bankName", new PropertyModel(bank, "name"));
        bankNameForm.add(bankNameTextField);

        Button submitButton = new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();

                bankService.saveBank(bank);
            }
        };
        bankNameForm.add(submitButton);


        Form<Void> availableCurrenciesForm = new Form<>("availableCurrencies");

        final CheckGroup<Currency> group = new CheckGroup<>("group", new ArrayList<Currency>());
        availableCurrenciesForm.add(group);
        group.add(new CheckGroupSelector("groupselector"));
        ListView<Currency> currencies = new ListView<Currency>("currencies", currencyService.loadCurrencies()) {

            @Override
            protected void populateItem(ListItem<Currency> item) {
                item.add(new Check<>("checkbox", item.getModel()));
                item.add(new Label("name", new PropertyModel<>(item.getDefaultModel(), "name")));
            }
        };

        currencies.setReuseItems(true);
        group.add(currencies);

        //select of bank names
        ChoiceRenderer<Bank> bankChoiceRenderer = new ChoiceRenderer<>("name");
        DropDownChoice<Bank> bankDropDownChoice = new DropDownChoice<>("bankDropDownChoice", new Model<>(), bankService.loadBankList(), bankChoiceRenderer);
        availableCurrenciesForm.add(bankDropDownChoice);

        Button button = new Button("availableCurrenciesSubmit") {
            @Override
            public void onSubmit() {
                super.onSubmit();


                currencyService.fillList(group.getModelObject());

                bankService.saveCurrenciesToBanks(bankDropDownChoice.getModelObject(),currencyService.getList());
            }
        };
        availableCurrenciesForm.add(button);
        add(availableCurrenciesForm);

       add(new Link<Currency>("xxx") {
           @Override
           public void onClick() {
               /*for(Currency currencies : currencyService.getList()){

               }*/

           }
       });

    }
}
