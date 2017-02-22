package com.vahan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

/**
 * Created by vahan on 12/21/16.
 */

@SpringBootApplication
public class BankApplication {
    public static void main(String[] args)throws Exception {
        SpringApplication.run(BankApplication.class,args);
    }
}
