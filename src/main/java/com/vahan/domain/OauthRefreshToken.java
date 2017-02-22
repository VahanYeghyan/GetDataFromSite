package com.vahan.domain;

/**
 * Created by vahan on 2/2/17.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken implements Serializable {

    private static final long serialVersionUID = 632759132130413163L;

    /*Properties*/
    @Id
    @Column(name = "token_id")
    private String tokenId;

    @Column(name = "token")
    private byte[] token;

    @Column(name = "authentication")
    private byte[] authentication;

    /*Getters and setter*/
    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(final String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(final byte[] token) {
        this.token = token;
    }

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(final byte[] authentication) {
        this.authentication = authentication;
    }


}