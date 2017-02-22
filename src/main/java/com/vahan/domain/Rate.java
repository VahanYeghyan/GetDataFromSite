package com.vahan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by vahan on 12/21/16.
 */
@Entity
@Table(name = "rate")
public class Rate extends AbstractDomainEntityModel implements Serializable {

    @Column
    private BigDecimal sell;

    @Column
    private BigDecimal buy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_name")
    private Bank bank;

    @ManyToMany
    @JoinTable(name = "rate_currency",
            joinColumns = @JoinColumn(name = "rate_id"),
            inverseJoinColumns = @JoinColumn(name = "currency_id"))

    private Set<Currency> currencies;

    public Rate() {
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Set<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Set<Currency> currencies) {
        this.currencies = currencies;
    }
}
