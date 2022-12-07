package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.BookPage;
import com.cydeo.utility.BrowserUtil;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class US03_StepDefs extends BasePage {
    BookPage bookPage = new BookPage();
    List<String> actualCategories;

    @When("I navigate to {string} page")
    public void i_navigate_to_page(String book) {
        navigateModule(book);
    }
    @When("I take all book categories in UI")
    public void i_take_all_book_categories_in_ui() {
        bookPage.mainCategoryElement.click();
        actualCategories = BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
    }
    @When("I execute query to get book categories")
    public void i_execute_query_to_get_book_categories() {
        DB_Util.runQuery("select name from book_categories");
    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {
        actualCategories.remove(0);
        List<String> expectedCategories = DB_Util.getColumnDataAsList("name");

        assertEquals(expectedCategories, actualCategories);

    }


}
