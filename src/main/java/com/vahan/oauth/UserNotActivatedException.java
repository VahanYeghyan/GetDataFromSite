package com.vahan.oauth;

/**
 * Created by vahan on 2/2/17.
 */
import org.springframework.security.core.AuthenticationException;

public class UserNotActivatedException extends AuthenticationException {

    public UserNotActivatedException(String msg, Throwable t) {
        super(msg, t);
    }

    public UserNotActivatedException(String msg) {
        super(msg);
    }
}
