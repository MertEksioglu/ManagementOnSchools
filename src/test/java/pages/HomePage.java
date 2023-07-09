package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//a[@href='/register']")
    public WebElement registerHome;
    @FindBy(xpath = "//a[@href='/login']")
    public WebElement loginHome;
    @FindBy(xpath = "//button[@aria-controls='offcanvasNavbar-expand-false']")
    public WebElement Menubutton;
    @FindBy(xpath = "//a[text()='Guest User']")
    public WebElement guestuserlink;

    @FindBy(xpath = "//h5[text()='Guest User List']")
    public WebElement guestlisttext;





}
