package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PaymentMethodPage {

    private final SelenideElement bankWireButton = $(".bankwire");

    public PaymentSummaryPage payByBankWire() {
        bankWireButton.shouldBe(visible).click();
        return new PaymentSummaryPage();
    }

}
