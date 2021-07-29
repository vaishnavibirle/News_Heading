package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.pages.Login;
import com.blz.selenium.pages.News_Page;
import org.testng.annotations.Test;

public class News_Headings_Test extends BaseClass {

    @Test
    public void login_test() throws InterruptedException {
        Login login = new Login(driver);
        login.login();
    }

    @Test
    public void news_headings_test() throws InterruptedException {
        Login login = new Login(driver);
        login.login();
        News_Page news_page = new News_Page(driver);
        news_page.new_headings();
    }
}
