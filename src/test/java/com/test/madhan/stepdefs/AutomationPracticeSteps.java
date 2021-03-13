package com.test.madhan.stepdefs;

import com.codeborne.selenide.Configuration;
import com.test.madhan.model.OrderData;
import com.test.madhan.pages.*;
import com.test.madhan.pages.shoppingcart.OrderConfirmationPage;
import com.test.madhan.pages.shoppingcart.SummaryPage;
import io.cucumber.java8.En;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;

public class AutomationPracticeSteps implements En {

    OrderData orderData;

    HomePage homePage;

    String currentPassword;

    MyAccountPage myAccountPage;

    CategoryPage categoryPage;

    SummaryPage summaryPage;

    OrderConfirmationPage orderConfirmationPage;

    String orderReferenceNumber;

    OrderHistoryPage orderHistoryPage;

    PersonalInformationPage personalInformationPage;

    String firstNameToBeUpdated;

    public AutomationPracticeSteps() {

        Before(() -> {
            Configuration.baseUrl = "http://automationpractice.com/index.php";
        });

        initSteps();
    }

    private void initSteps() {
        Given("I login to the application with {string} and {string}", (String userName, String password) -> {
            homePage = new HomePage();
            this.currentPassword = password;
            myAccountPage = homePage.openApp()
                    .goToLogin()
                    .login(userName, password);
        });

        And("^I navigate to \"([^\"]*)\" category$", (String categoryName) -> {
            categoryPage = myAccountPage.selectCategory(categoryName);
        });

        And("^I add the T-shirt to the cart$", () -> {
            categoryPage.addProductToCart();
        });

        And("^I continue to checkout$", () -> {
            summaryPage = categoryPage.proceedToCheckout();
        });

        And("^I increase the product qty$", () -> {
            summaryPage.incrementProductQuantity();
        });

        Then("^I store the order details$", () -> {
            orderData = summaryPage.getOrderData();
        });

        And("^I complete placing the order$", () -> {
            orderConfirmationPage = summaryPage.proceedToCheckout()
                    .proceedToCheckout()
                    .proceedToCheckout()
                    .payByBankWire().confirmOrder();
            orderReferenceNumber = orderConfirmationPage.getOrderReferenceNumber();
        });

        When("^I view the order details in order history$", () -> {
            orderHistoryPage = orderConfirmationPage.backToOrders();
            orderHistoryPage.selectOrder(orderReferenceNumber);
        });

        Then("^the order details should match the stored order$", () -> {
            orderHistoryPage.verifyOrder(orderData);
        });

        And("^I navigate to personal information$", () -> {
            personalInformationPage = myAccountPage.openPersonalInformation();
        });

        When("^I update my firstname$", () -> {
            firstNameToBeUpdated = RandomStringUtils.randomAlphabetic(5).toLowerCase();
            personalInformationPage.setFirstName(firstNameToBeUpdated);
            personalInformationPage.saveDetails(currentPassword);
        });

        Then("^the firstname should be updated$", () -> {
            String accountName = myAccountPage.getAccountName();
            String currentFirstName = accountName.split(" ")[0].toLowerCase();
            Assert.assertEquals(firstNameToBeUpdated, currentFirstName);
        });

        And("^I logout from the application$", () -> {
            homePage.logout();
        });
    }
}
