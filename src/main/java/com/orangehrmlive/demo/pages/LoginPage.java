package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage extends Utility {

    By loginFieldText = By.xpath("//input[@placeholder='Username']");
    By passwordTextField = By.xpath("//input[@type='password']");

    By clickOnLoginButton = By.xpath("//button[@type='submit']");

    By verifyLogoHRM = By.xpath("//img[@src='/web/images/ohrm_branding.png?v=1683010990518']");

    By verifyDashboardText = By.xpath("//h6[normalize-space()='Dashboard']");

    By clickOnUser = By.xpath("//img[@class='oxd-userdropdown-img']");

    By clickOnLogoutButton = By.xpath("//a[contains(text(),'Logout')]");

    By loginText = By.xpath("//h5[@class = 'oxd-text oxd-text--h5 orangehrm-login-title']");


    public void enterLoginFieldText (String UserName){
        sendTextToElement(loginFieldText,UserName);
    }

    public void enterPasswordFieldText (String Password){
        sendTextToElement(passwordTextField,Password);
    }

    public void clickOnTheLoginButton (){
        clickOnElement(clickOnLoginButton);
    }

    public void verifyHRMLogo(){
        boolean verifyLogo = driver.findElement(verifyLogoHRM).isDisplayed();
        Assert.assertTrue(verifyLogo,"Logo Not Displayed");
    }

    public void verifyDashText () {
        Assert.assertEquals("Dashboard",getTextFromElement(verifyDashboardText),"not matching element");
    }

    public void clickOnUserProfile (){
        clickOnElement(clickOnUser);
    }

    public void clickOnLogout(){
        mouseHoverToElementAndClick(clickOnLogoutButton);
    }

    public String getLoginPanelText(){
        return getTextFromElement(loginText);
    }


}
