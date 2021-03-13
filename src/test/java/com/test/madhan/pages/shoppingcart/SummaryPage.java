package com.test.madhan.pages.shoppingcart;

import com.codeborne.selenide.SelenideElement;
import com.test.madhan.model.OrderData;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SummaryPage {

    private final SelenideElement pageHeading = $(".page-heading");
    private final SelenideElement addQuantityButton = $(".cart_quantity_button [title='Add']");
    private final SelenideElement productQuantitySummary = $("#summary_products_quantity");

    private final SelenideElement productNameLabel = $(".cart_description .product-name");
    private final SelenideElement productQuantity = $(".cart_quantity_input");
    private final SelenideElement orderTotalText = $("#total_price_container");

    private final SelenideElement proceedToCheckout = $("a.standard-checkout[title='Proceed to checkout']");


    public SummaryPage() {
        pageHeading.shouldHave(text("Shopping-cart summary"));
    }

    public SummaryPage incrementProductQuantity() {
        addQuantityButton.click();
        productQuantitySummary.shouldHave(text("2 Products"));
        return this;
    }

    public OrderData getOrderData() {
        String productName = productNameLabel.text();
        String productQuantity = this.productQuantity.val();
        String orderTotal = orderTotalText.text();
        return OrderData.builder()
                .productName(productName)
                .productQuantity(productQuantity)
                .orderTotal(orderTotal)
                .build();
    }

    public AddressPage proceedToCheckout() {
        proceedToCheckout.should(visible).click();
        return new AddressPage();
    }

}
