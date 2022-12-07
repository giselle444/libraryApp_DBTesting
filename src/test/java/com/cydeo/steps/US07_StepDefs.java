package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.BookPage;
import com.cydeo.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US07_StepDefs extends BasePage {
    String book;

    LoginPage loginPage=new LoginPage();
    BookPage bookPage=new BookPage();

    @Given("I login as a student")
    public void i_login_as_a_student() {
    loginPage.login("student14@library","bL1twuqT");
    }
    @Given("I search book name called {string}")
    public void i_search_book_name_called(String book) {
        bookPage.search.sendKeys(book);


    }
    @When("I click Borrow Book")
    public void i_click_borrow_book() {
        bookPage.editBook(book);


    }
    @Then("verify that book is shown in \"Borrowing Books” page")
    public void verify_that_book_is_shown_in_borrowing_books_page() {


    }
    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

    }

}
