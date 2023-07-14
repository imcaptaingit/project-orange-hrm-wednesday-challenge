package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utilities.Utility;
import org.openqa.selenium.By;

public class DashboardPage extends Utility {

    By verifyDashboardText = By.xpath("//h6[normalize-space()='Dashboard']");

    By clickOnUser = By.xpath("//img[@class='oxd-userdropdown-img']");

    By clickOnLogoutButton = By.xpath("//a[contains(text(),'Logout')]");



    public String getDashboardText(){
        return getTextFromElement(verifyDashboardText);
    }

    public void clickOnUserProfileLogo() throws InterruptedException {
        Thread.sleep(2000);
        clickOnElement(clickOnUser);
    }
    public void mouseHoverOnLogoutAndClick() throws InterruptedException {
        Thread.sleep(2000);
        mouseHoverToElementAndClick(clickOnLogoutButton);
    }
}
