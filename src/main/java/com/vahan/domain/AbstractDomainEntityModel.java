package com.vahan.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by vahan on 12/24/16.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class AbstractDomainEntityModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid", nullable = false, unique = true, updatable = false)
    private final String uuid;

    @Column(name = "created", nullable = false)
    private Date created;

    @Column(name = "removed")
    private Date removed;

    @Column(name = "updated", nullable = false)
    private Date updated;


    /*Constructor*/
    public AbstractDomainEntityModel() {
        setCreated(new Date());
        setUpdated(getCreated());

        uuid = UUID.randomUUID().toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getRemoved() {
        return removed;
    }

    public void setRemoved(Date removed) {
        this.removed = removed;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
