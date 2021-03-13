package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;
import com.test.madhan.pages.OrderHistoryPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class OrderConfirmationPage {

    private final Pattern orderReferencePattern = Pattern.compile(".*order reference (\\w+) in.*");

    private final SelenideElement orderConfirmationBox = $("div.box");

    private final SelenideElement backToOrdersButton = $("[title='Back to orders']");

    public String getOrderReferenceNumber() {
        String orderConfirmationText = orderConfirmationBox.shouldBe(visible).text();
        Matcher matcher = orderReferencePattern.matcher(orderConfirmationText);
        String orderReferenceNumber = null;
        while (matcher.find()) {
            orderReferenceNumber = matcher.group(1);
        }
        return orderReferenceNumber;
    }

    public OrderHistoryPage backToOrders() {
        backToOrdersButton.click();
        return new OrderHistoryPage();
    }
}
