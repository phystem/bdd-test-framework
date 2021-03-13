package com.test.madhan.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class HomePage {

    private final SelenideElement loginLink = $("a.login");
    private final SelenideElement logOutLink = $(".logout");

    public HomePage openApp() {
        open("/");
        assertEquals("Verifying page tile", "My Store", title());
        return this;
    }

    public LoginPage goToLogin() {
        loginLink.click();
        return new LoginPage();
    }

    public void logout() {
        logOutLink.shouldBe(visible).click();
    }
}
