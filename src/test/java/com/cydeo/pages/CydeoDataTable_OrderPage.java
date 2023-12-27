package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CydeoDataTable_OrderPage extends CydeoDataTable_BasePage {

    public CydeoDataTable_OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;



    @FindBy(name="quantity")
    public WebElement qtyInputBox;

    @FindBy(name="name")
    public WebElement customerNameInputBox;

    @FindBy(name="street")
    public WebElement streetInputBox;

    @FindBy(name="city")
    public WebElement cityInputBox;

    @FindBy(name="state")
    public WebElement stateInputBox;

    @FindBy(name="zip")
    public WebElement zipCodeInputBox;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement visaRadioButton;
    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement mastercardRadioButton;
    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanexpressRadioButton;

    @FindBy(name="card")
    public List<WebElement> cardTypes;

    @FindBy(name="cardNo")
    public WebElement cardNumberInputBox;

    @FindBy(name="cardExp")
    public WebElement cardExpDateInputBox;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement processOrderButton;

    @FindBy(xpath = "//button[.='Calculate']")
    public WebElement calculateButton;



}
