package com.vahan.web.pages;

import com.vahan.service.UserService;
import com.vahan.web.domain.UserPageModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by vahan on 12/24/16.
 */
public class HomePage extends WebPage {

    private UserPageModel userPageModel;

    @SpringBean
    UserService userService;

    public HomePage(PageParameters parameters) {
        super(parameters);
        add(new Label("hello", "hello"));

        userPageModel = new UserPageModel();

        Form<Void> form = new Form<Void>("form");
        add(form);

        TextField usernameTextField = new TextField("username", new PropertyModel(userPageModel, "username"));

        PasswordTextField passwordTextField = new PasswordTextField("password", new PropertyModel<>(userPageModel, "password"));

        Button button = new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();

                userService.saveUser(userPageModel);

            }
        };

        form.add(usernameTextField);
        form.add(passwordTextField);
        form.add(button);
    }

}
