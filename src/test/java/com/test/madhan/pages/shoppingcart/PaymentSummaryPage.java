package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class PaymentSummaryPage {

    private final SelenideElement confirmOrderButton = $x("//button[./span[text()='I confirm my order']]");

    public OrderConfirmationPage confirmOrder() {
        confirmOrderButton.click();
        return new OrderConfirmationPage();
    }
}
