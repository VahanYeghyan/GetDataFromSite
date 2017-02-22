package com.vahan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vahan on 12/20/16.
 */
@Entity
@Table(name = "bank")
public class Bank extends AbstractDomainEntityModel implements Serializable {


    @Column(name = "bank_name", nullable = false, unique = true)
    private String name;

    @ManyToMany
    @JoinTable(name = "bank_currency",
            joinColumns = @JoinColumn(name = "bank_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_id"))
    private Set<Currency> currencies;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bank")
    private Set<Rate> rates = new HashSet<>();


    public Bank() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }

    public Set<Rate> getRates() {
        return rates;
    }

    public void setRates(Set<Rate> rates) {
        this.rates = rates;
    }
}
