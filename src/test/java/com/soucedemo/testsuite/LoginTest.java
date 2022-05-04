package com.soucedemo.testsuite;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends Utility {

    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldLoginSuccessfullyWithValid() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        String expectedErrorMessage = "PRODUCTS";
        String actualErrorMessage = loginPage.getproductMessage();
        org.testng.Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");


    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage () {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginBtn();
        List<WebElement> products = driver.findElements(By.className("inventory_item"));
        System.out.println("Items displayed : " + products.size());
        for (WebElement element : products)
            Assert.assertEquals(true, element.isDisplayed());
    }
}

