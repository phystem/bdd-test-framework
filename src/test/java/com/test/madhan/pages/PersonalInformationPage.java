package com.test.madhan.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInformationPage {

    private final SelenideElement firstNameTextBox = $("#firstname");
    private final SelenideElement currentPassword = $("#old_passwd");
    private final SelenideElement saveDetails = $(byName("submitIdentity"));
    private final SelenideElement successMessage = $("p.alert-success");

    public PersonalInformationPage setFirstName(String firstName) {
        firstNameTextBox.val(firstName);
        return this;
    }

    public void saveDetails(String currentPassword) {
        this.currentPassword.val(currentPassword);
        saveDetails.click();
        successMessage.shouldBe(visible)
                .shouldHave(text("Your personal information has been successfully updated"));
    }
}
