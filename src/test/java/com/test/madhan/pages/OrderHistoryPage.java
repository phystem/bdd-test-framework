package com.test.madhan.pages;

import com.codeborne.selenide.SelenideElement;
import com.test.madhan.model.OrderData;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class OrderHistoryPage {

    private final SelenideElement orderDetailBlock = $("#block-order-detail");
    private final SelenideElement orderDetailTable = $("#order-detail-content");
    private final String productNameLabel = "tbody .item .bold";
    private final String productQtyLabel = "tbody .item .return_quantity";
    private final String orderTotalLabel = ".totalprice .price";

    public OrderHistoryPage selectOrder(String orderReference) {
        $$("#order-list td.history_link>a")
                .shouldHave(sizeGreaterThanOrEqual(1))
                .filter(text(orderReference))
                .first().click();
        return this;
    }

    public void verifyOrder(OrderData orderData) {
        orderDetailBlock.should(visible);
        SelenideElement orderDetailTableElement = orderDetailTable.scrollIntoView(true);
        orderDetailTableElement.$(productNameLabel).shouldHave(text(orderData.getProductName()));
        orderDetailTableElement.$(productQtyLabel).shouldHave(text(orderData.getProductQuantity()));
        orderDetailTableElement.$(orderTotalLabel).shouldHave(text(orderData.getOrderTotal()));
    }
}
