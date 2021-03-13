package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ShippingPage {

    private final SelenideElement agreeToTerms = $("#uniform-cgv");

    private final SelenideElement proceedToCheckout = $("button[name='processCarrier']");

    public PaymentMethodPage proceedToCheckout() {
        agreeToTerms.shouldBe(visible).click();
        proceedToCheckout.click();
        return new PaymentMethodPage();
    }

}
