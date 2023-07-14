package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest extends BaseTest {

    LoginPage loginPage = new LoginPage();
    AdminPage adminPage = new AdminPage();
    HomePage homePage = new HomePage();
    ViewSystemUserPage viewSystemUserPage = new ViewSystemUserPage();
    AddUserPage addUserPage = new AddUserPage();


    @Test
    public void adminShouldAddUserSuccessfully() throws InterruptedException {
        loginPage.enterLoginFieldText("Admin");
        loginPage.enterPasswordFieldText("admin123");
        loginPage.clickOnTheLoginButton();
        // acceptAlert();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        viewSystemUserPage.clickOnAddButton();
        Assert.assertEquals(addUserPage.getAddUserText(), "Add User");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.enterEmployeeName("Ananya Dash");
        addUserPage.enterUsername("iamdash");
        addUserPage.selectStatusDisableFromDropDown();
        addUserPage.enterPassword("Anaya@666");
        addUserPage.enterConfirmPassword("Anaya@666");
        addUserPage.clickOnSaveButton();
//          Assert.assertEquals("Successfully Saved");

    }

    @Test
    public void searchTheUserCreatedAndVerifyIt() throws InterruptedException {
        loginPage.enterLoginFieldText("Admin");
        loginPage.enterPasswordFieldText("admin123");
        loginPage.clickOnTheLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("Admin");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();
        Assert.assertEquals(viewSystemUserPage.getResultListText(), "Admin");
    }

    @Test
    public void verifyThatAdminShouldDeleteTheUserSuccessfully() throws InterruptedException {

        loginPage.enterLoginFieldText("Admin");
        loginPage.enterPasswordFieldText("admin123");
        loginPage.clickOnTheLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("Admin");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();
        Assert.assertEquals(viewSystemUserPage.getResultListText(), "Admin");
        viewSystemUserPage.clickOnCheckbox();
        viewSystemUserPage.clickOnDeleteButton();
        // switchToAlert();
        //System.out.println(getTextFromAlert());
        Thread.sleep(2000);
        //acceptAlert();
        //Assert.assertEquals(getTextFromElement(),"Successfully Deleted");
    }

    @Test
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() throws InterruptedException {
        loginPage.enterLoginFieldText("Admin");
        loginPage.enterPasswordFieldText("admin123");
        loginPage.clickOnTheLoginButton();
        homePage.clickOnAdminLink();
        Assert.assertEquals(viewSystemUserPage.getSystemUsersText(), "System Users");
        addUserPage.enterUsername("Admin");
        addUserPage.selectUserRoleAdminFromDropDown();
        addUserPage.selectStatusEnableFromDropDown();
        viewSystemUserPage.clickOnSearchButton();
//        Assert.assertEquals(getTextFromElement(),"No Records Found");

    }

}
