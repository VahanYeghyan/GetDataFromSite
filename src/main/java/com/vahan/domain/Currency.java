package com.vahan.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vahan on 12/21/16.
 */

@Entity
@Table(name = "currency")
public class Currency extends AbstractDomainEntityModel implements Serializable {


    @Column(name = "currency_name")
    private String name;


    public Currency() {
    }

    public Currency(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
