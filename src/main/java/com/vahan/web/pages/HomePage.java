package com.vahan.web.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by vahan on 12/24/16.
 */
public class HomePage extends WebPage {
    public HomePage(PageParameters parameters) {
        super(parameters);
        add(new Label("hello","hello"));
    }

}
