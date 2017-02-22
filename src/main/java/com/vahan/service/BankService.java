package com.vahan.service;

import com.vahan.domain.Bank;
import com.vahan.domain.Currency;
import com.vahan.repository.BankRepository;
import com.vahan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by vahan on 12/25/16.
 */
@Service
public class BankService {



    @Autowired
    BankRepository bankRepository;

    @Autowired
    CurrencyService currencyService;

    List<Bank> bankList = new ArrayList<>();

    public void saveBank(Bank bank){
        Bank bank1 = new Bank();
        bank1.setName(bank.getName());
        bankRepository.save(bank1);
    }

    public List<Bank> loadBankList(){

       return bankRepository.findAll();
    }

    public void saveCurrenciesToBanks(Bank bank, Set<Currency> currencies){
        Bank bank1 = bankRepository.getBankById(bank.getId());
        bank1.setCurrencies(currencies);
        bankRepository.save(bank1);
    }
}
