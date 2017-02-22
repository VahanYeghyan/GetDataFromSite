package com.vahan.web.configurer;

import com.vahan.web.WicketApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by vahan on 12/24/16.
 */
public class WarInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WicketApplication.class);
    }
}
