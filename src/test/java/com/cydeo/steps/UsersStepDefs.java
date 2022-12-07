package com.cydeo.steps;

import com.cydeo.pages.UsersPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

public class UsersStepDefs {

    UsersPage usersPage=new UsersPage();
    String email;

    @When("the user clicks Edit User button")
    public void the_user_clicks_edit_user_button() {
        BrowserUtil.waitFor(2);
        usersPage.editUser.click();

    }
    @When("the user changes user status {string} to {string}")
    public void the_user_changes_user_status_to(String active, String inactive) {
        Select select=new Select(usersPage.statusDropdown);
        select.selectByVisibleText(inactive);
        email=usersPage.email.getAttribute("value");
        System.out.println("email = " + email);
        BrowserUtil.waitFor(2);

    }
    @When("the user clicks save changes button")
    public void the_user_clicks_save_changes_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} message should appear")
    public void message_should_appear(String string) {

    }
    @Then("the users should see same status for related user in database")
    public void the_users_should_see_same_status_for_related_user_in_database() {


    }
    @Then("the user changes current user status {string} to {string}")
    public void the_user_changes_current_user_status_to(String active, String inactive) {

    }
}
