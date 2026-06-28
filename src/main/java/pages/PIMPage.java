package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage extends BasePage {

    // Navigation
    private final By PIMMenu = By.cssSelector("a[href*='viewPimModule']");
    private final By addEmployeeBtn = By.cssSelector(".oxd-topbar-body-nav li:nth-child(3) a");
    private final By empListBtn     = By.cssSelector("a[href*='viewEmployeeList']");

    // Add Employee Form
    private final By firstName  = By.cssSelector("input[name='firstName']");
    private final By middleName = By.cssSelector("input[name='middleName']");
    private final By lastName   = By.cssSelector("input[name='lastName']");
    private final By saveBtn    = By.cssSelector("button.orangehrm-left-space");

    // Search
    private final By empIDField   = By.cssSelector("form.oxd-form .oxd-grid-item:nth-child(2) input");
    private final By empNameField = By.cssSelector("[placeholder='Type for hints...']");
    private final By searchBtn    = By.cssSelector("button[type='submit']");

    // Table Actions
    private final By editBtn          = By.cssSelector(".oxd-table-card .oxd-table-cell:nth-child(9) button .bi-pencil-fill");
    private final By deleteBtn        = By.cssSelector(".oxd-table-body .oxd-table-card .oxd-table-cell:nth-child(9) button:nth-child(2) i");
    private final By deleteConfirmBtn = By.cssSelector(".oxd-button--label-danger");

    // Error
    private final By errorMsg = By.cssSelector(".oxd-input-field-error-message");
    private By PIMPage;

    public PIMPage(WebDriver driver) {
        super(driver);
    }
    public void goToPIM() {
        click(PIMMenu);

    }
    // ── Navigation ──
    public void goToAddEmployee() {
        click(addEmployeeBtn);
    }

    public void goToEmployeeList() {
        click(empListBtn);
    }

    // ── Add Employee ──
    public void addEmployee(String first, String last) {
        goToAddEmployee();
        type(firstName, first);
        type(lastName, last);
        click(saveBtn);
    }

    public void addEmployeeWithMiddleName(String first, String middle, String last) {
        goToAddEmployee();
        type(firstName, first);
        type(middleName, middle);
        type(lastName, last);
        click(saveBtn);
    }

    // ── Search ──
    public void searchByID(String id) {
        type(empIDField, id);
        click(searchBtn);
    }

    public void searchByName(String name) {
        type(empNameField, name);
        click(searchBtn);
    }

    // ── Edit ──
    public void clickEdit() {
        click(editBtn);
    }

    public void editMiddleName(String name) {
        type(middleName, name);
        click(saveBtn);
    }

    public void editLastName(String name) {
        type(lastName, name);
        click(saveBtn);
    }

    // ── Delete ──
    public void deleteEmployee() {
        click(deleteBtn);
        click(deleteConfirmBtn);
    }

    // ── Validation ──
    public boolean isErrorDisplayed() {
        return isDisplayed(errorMsg);
    }
}