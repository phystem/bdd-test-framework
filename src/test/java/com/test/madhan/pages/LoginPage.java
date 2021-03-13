package com.test.madhan.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class LoginPage {

    private final SelenideElement emailTextBox = $("#email");
    private final SelenideElement passwordTextBox = $("#passwd");
    private final SelenideElement submitButton = $("#SubmitLogin");

    public LoginPage() {
        assertEquals("Verifying page tile", "Login - My Store", title());
    }

    public MyAccountPage login(String email, String password) {
        $(emailTextBox).val(email);
        $(passwordTextBox).val(password);
        $(submitButton).click();
        return new MyAccountPage();
    }
}
