package com.test.madhan.pages;

import com.codeborne.selenide.SelenideElement;
import com.test.madhan.pages.shoppingcart.SummaryPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class CategoryPage {

    private final SelenideElement productContainer = $(".product_list .product-container");
    private final SelenideElement addToCartButton = $("a[title='Add to cart']");
    private final SelenideElement proceedToCheckout = $("a.btn[title='Proceed to checkout']");

    public CategoryPage(String categoryName) {
        assertEquals("Verifying page tile", categoryName + " - My Store", title());
    }

    public CategoryPage addProductToCart() {
        productContainer.shouldBe(visible).hover();
        addToCartButton.should(visible).click();
        return this;
    }

    public SummaryPage proceedToCheckout() {
        proceedToCheckout.should(visible).click();
        return new SummaryPage();
    }
}
