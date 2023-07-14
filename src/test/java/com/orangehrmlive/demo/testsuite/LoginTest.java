package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void verifyUserShouldLoginSuccessFully() {
//        Enter username
        loginPage.enterLoginFieldText("Admin");
//        Enter password
        loginPage.enterPasswordFieldText("admin123");
//        Click on the Login Button
        loginPage.clickOnTheLoginButton();
//        Verify "Dashboard" Message
        loginPage.verifyDashText();
    }

    @Test
    public void VerifyThatTheLogoDisplayOnLoginPage() {
//        Launch the application
//        Verify Logo is Displayed
        loginPage.verifyHRMLogo();

    }

    @Test
    public void VerifyUserShouldLogOutSuccessFully() {
//        Login to the application
        loginPage.enterLoginFieldText("Admin");
        loginPage.enterPasswordFieldText("admin123");
        loginPage.clickOnTheLoginButton();
//        Click on the User Profile logo
        loginPage.clickOnUserProfile();
//        Mouse hover on the "Logout" and click
        loginPage.clickOnLogout();
//        Verify the text "Login Panel" is displayed
        String expectedLoginText = "Login";
        Assert.assertEquals(loginPage.getLoginPanelText(), expectedLoginText, "Unable to verify text.");

    }

}
