package com.meetsky.pages;

import com.meetsky.utilities.ConfigurationReader;
import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    public FilesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "user")
    public WebElement usernameButton;

    @FindBy(id = "password")
    public WebElement passwordButton;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//a[@aria-label='Files']")
    public WebElement filesLink;

    @FindBy(xpath = "(//a[@data-action='menu'])[1]")
    public WebElement threeDotsOfFile;

    //@FindBy(xpath = "(//span[@class='icon icon-more'])[2]/../../preceding-sibling::span/span[@class='innernametext']")
    //public WebElement fileName;

    @FindBy(xpath = "//span[.='Add to favourites']")
    public WebElement addToFavOption;

    @FindBy(xpath = "//span[@class='icon icon-starred']")
    public WebElement starIcon;

    @FindBy(xpath = "//a[text()='Favourites']")
    public WebElement favFolderButton;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> favFolders;

    @FindBy(xpath = "//span[.='Rename']")
    public WebElement renameOption;

    @FindBy(xpath = "//tr[@class='ui-droppable appear mouseOver']")
    public WebElement renameBox;

    @FindBy(xpath = "//*[@id=\"fileList\"]/tr[1]/td[2]/a")
    public WebElement fileName;

    @FindBy(xpath = "//span[@class='icon icon-details']")
    public WebElement detailOption;

    @FindBy(id = "comments")
    public WebElement commentBtn;

    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone, : for emoji autocompletion …']")
    public WebElement commentBox;

    @FindBy(xpath = "(//button[@aria-label='Actions'])[2]")
    public WebElement commentThreeDots;

    @FindBy(xpath = "//span[.='Delete comment']")
    public WebElement deleteCommentOption;

    @FindBy(xpath = "//button[@class='toast-undo-button']")
    public WebElement commentDeletedMessage;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("meetsky.url"));
        usernameButton.sendKeys(ConfigurationReader.getProperty("meetsky.username"));
        passwordButton.sendKeys(ConfigurationReader.getProperty("meetsky.password"));
        loginButton.click();
    }

}
