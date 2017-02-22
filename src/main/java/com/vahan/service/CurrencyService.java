package com.vahan.service;

import com.vahan.domain.Currency;
import com.vahan.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by vahan on 12/25/16.
 */
@Service
public class CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    private List<Currency> currencyList = new ArrayList<>();

    private Set<Currency> list = new HashSet<>();

    public void saveCurrencies(){
        currencyList.add(new Currency("USD"));
        currencyList.add(new Currency("EUR"));
        currencyList.add(new Currency("RUB"));
        currencyList.add(new Currency("JPY"));

        currencyRepository.save(currencyList);

    }

    public List<Currency> loadCurrencies(){
        return currencyRepository.findAll();
    }

    public void fillList(Collection<Currency> list1){
        list.addAll(list1);
    }

    public Set<Currency> getList() {
        return list;
    }
}
