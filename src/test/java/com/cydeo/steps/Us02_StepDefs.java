package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.DashBoardPage;
import com.cydeo.pages.LoginPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import com.google.protobuf.StringValue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Us02_StepDefs extends BasePage {

    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    String borrowedBooks;


    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {
        loginPage.login("librarian");

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
        BrowserUtil.waitFor(4);
      borrowedBooks=dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("borrowedBooks = " + StringValue.of(borrowedBooks));


    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {
        DB_Util.runQuery("select count(is_returned) from book_borrow where is_returned='0'");
       String actualBorrowedBooks= DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals("Expected Borrowed Books does not match Database ",borrowedBooks,actualBorrowedBooks);

    }

}
