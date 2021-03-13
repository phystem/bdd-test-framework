package com.test.madhan.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.title;
import static org.junit.Assert.assertEquals;

public class MyAccountPage {

    private final String categoryLink = "ul.menu-content>li>a[title='%s']";
    private final SelenideElement personalInformationButton = $("a[title='Information']");
    private final SelenideElement accountName = $("a.account");

    public MyAccountPage() {
        assertEquals("Verifying page tile", "My account - My Store", title());
    }

    public CategoryPage selectCategory(String categoryName) {
        String categoryLink = String.format(this.categoryLink, categoryName);
        $(categoryLink).should(visible).click();
        return new CategoryPage(categoryName);
    }

    public PersonalInformationPage openPersonalInformation() {
        personalInformationButton.click();
        return new PersonalInformationPage();
    }

    public String getAccountName() {
        return accountName.text();
    }
}
