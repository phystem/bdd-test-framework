package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AddressPage {

    private final SelenideElement proceedToCheckout = $("button[name='processAddress']");

    public ShippingPage proceedToCheckout() {
        proceedToCheckout.should(visible).click();
        return new ShippingPage();
    }
}
