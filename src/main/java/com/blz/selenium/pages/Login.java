package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends BaseClass {

    @FindBy(xpath = "//a[normalize-space()='login']")
    WebElement login_btn;

    @FindBy(xpath = "//body[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]")
    WebElement username;

    @FindBy(xpath = "//body[1]/form[1]/table[1]/tbody[1]/tr[2]/td[2]/input[1]")
    WebElement password;

    @FindBy(xpath = "//input[@value='login']")
    WebElement login_to_account;

    @FindBy(xpath = "//a[normalize-space()='Hacker News']")
    WebElement hacker_news_btn;


    public Login(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void login() throws InterruptedException {
        login_btn.click();
        Thread.sleep(2000);
        username.sendKeys("vaishnavibirle");
        Thread.sleep(100);
        password.sendKeys("1234567890");
        Thread.sleep(200);
        login_to_account.click();
        Thread.sleep(1000);
        hacker_news_btn.click();
        Thread.sleep(2000);
    }

}
