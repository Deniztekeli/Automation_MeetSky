package com.meetsky.step_definitions;

import com.meetsky.pages.FilesPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Files_StepDefinitions {

    FilesPage filesPage = new FilesPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
    filesPage.login();
    }
    @Given("the user enters the files menu")
    public void the_user_enters_the_files_menu() {
    filesPage.filesLink.click();
    }
    public static String favFolderName;

    @When("user click three dots of the created file")
    public void user_click_three_dots_of_the_created_file() {
        BrowserUtils.sleep(5);
      //  favFolderName=filesPage.fileName.getText();
        filesPage.threeDotsOfFile.click();
    }
    @When("user select add to favorites link")
    public void user_select_add_to_favorites_link() {
    filesPage.addToFavOption.click();
    }
    @Then("user should see selected file has a star icon")
    public void user_should_see_selected_file_has_a_star_icon() {
        BrowserUtils.sleep(7);
       // filesPage.favFolderButton.click();
        //Assert.assertTrue(filesPage.favFolders.contains(filesPage.fileName));
        Assert.assertTrue(filesPage.starIcon.isDisplayed());
    }

    @When("user select rename and write new name and click enter")
    public void user_select_rename_and_write_new_name_and_click_enter() {
        BrowserUtils.sleep(5);
        filesPage.renameOption.click();

    }
    @Then("user should see new name on the file")
    public void user_should_see_new_name_on_the_file() {
        //BrowserUtils.waitForVisibility(filesPage.renameBox,10);
        String expectedFileName = "changed";
        Actions actions = new Actions(Driver.getDriver());
       // actions.moveToElement(filesPage.renameBox).pause(3).perform();
        actions.sendKeys(expectedFileName+Keys.ENTER).perform();
        BrowserUtils.waitForVisibility(filesPage.fileName,10);

        String actualFileName=filesPage.fileName.getText();

        Assert.assertTrue(actualFileName.contains(expectedFileName) );
    }

    @When("user select rename and write already existing file name and click enter")
    public void user_select_rename_and_write_already_existing_file_name_and_click_enter() {
    String existingFileName=filesPage.renameOption.getText();
        BrowserUtils.sleep(5);

        filesPage.renameOption.click();
    }
    @Then("user should not able to rename with existing file name")
    public void user_should_not_able_to_rename_with_existing_file_name() {
        //BrowserUtils.waitForVisibility(filesPage.renameBox,10);
        String expectedFileName = "Deniz";
        Actions actions = new Actions(Driver.getDriver());
        // actions.moveToElement(filesPage.renameBox).pause(3).perform();
        actions.sendKeys(expectedFileName+Keys.ENTER).perform();
        BrowserUtils.waitForVisibility(filesPage.fileName,10);

        String actualFileName=filesPage.fileName.getText();
        Assert.assertNotEquals(expectedFileName,actualFileName);
       // Assert.assertTrue(actualFileName.contains(expectedFileName) );
   // Assert.assertFalse("It's impossible changing file name with already exisitng file name",filesPage.renameOption.isDisplayed());
    }

    @When("user click on three dots and select details option")
    public void user_click_on_three_dots_and_select_details_option() {
        BrowserUtils.sleep(7);
        filesPage.threeDotsOfFile.click();
        filesPage.detailOption.click();
    }
    @When("user select comments button and type a comment in comment box then click enter")
    public void user_select_comments_button_and_type_a_comment_in_comment_box_then_click_enter() {
    BrowserUtils.sleep(5);
    filesPage.commentBtn.click();
    filesPage.commentBox.sendKeys("Hello");
    }
    @Then("user should see the comment is published")
    public void user_should_see_the_comment_is_published() {
        String expectedComment="Hello";
       Assert.assertEquals(expectedComment,filesPage.commentBox.getText());

    }

    @When("user click three dots of any comment and select delete")
    public void user_click_three_dots_of_any_comment_and_select_delete() {
        BrowserUtils.sleep(7);
        filesPage.commentBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(filesPage.commentThreeDots));
        filesPage.commentThreeDots.click();


    filesPage.deleteCommentOption.click();
    }
    @Then("user should see that comment is deleted")
    public void user_should_see_that_comment_is_deleted() {
        BrowserUtils.sleep(5);
    Assert.assertTrue(filesPage.commentDeletedMessage.isDisplayed());
    }

}
