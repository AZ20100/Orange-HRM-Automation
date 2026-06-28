package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PIMPage;

public class PIMTests extends BaseTest {

    @Test
    public void addEmployeeTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        pim.addEmployee("Zooz", "Swim");
    }

    @Test
    public void addEmployeeWithSpecialCharsTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        pim.addEmployee("zo@!#123z", "swim");
        Assert.assertTrue(pim.isErrorDisplayed(),
                "Error should appear for special characters in name");
    }

    @Test
    public void addEmployeeEmptyFirstNameTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        pim.addEmployee("", "swim");
        Assert.assertTrue(pim.isErrorDisplayed(),
                "Error should appear for empty first name");
    }

    @Test
    public void addEmployeeEmptyLastNameTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
        pim.addEmployee("Zooz", "");
        Assert.assertTrue(pim.isErrorDisplayed(),
                "Error should appear for empty last name");
    }

    @Test
    public void searchByIDTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
//        pim.goToEmployeeList();
        pim.searchByID("0405");
    }

    @Test
    public void searchByNameTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
//        pim.goToEmployeeList();
        pim.searchByName("zo@!#123z");
    }

    @Test
    public void editEmployeeMiddleNameTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
//        pim.goToEmployeeList();
        pim.searchByName("zo@!#123z");
        pim.clickEdit();
        pim.editMiddleName("Updated");
    }

    @Test
    public void editEmployeeEmptyLastNameTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
//        pim.goToEmployeeList();
        pim.searchByName("zo@!#123z");
        pim.clickEdit();
        pim.editLastName("");
        Assert.assertTrue(pim.isErrorDisplayed(),
            "Validation error should appear when the last name is empty.");
    }

    @Test
    public void deleteEmployeeTest() {
        loginAsAdmin();
        PIMPage pim = new PIMPage(driver);
        pim.goToPIM();
//        pim.goToEmployeeList();
        pim.searchByName("zo@!#123z");
        pim.deleteEmployee();
    }
}