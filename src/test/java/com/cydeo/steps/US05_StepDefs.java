package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US05_StepDefs extends BasePage {

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
       DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "    inner  join books b on bb.book_id = b.id\n" +
                "    inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc");


    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String genre) {
     String mostPopularGenre= DB_Util.getFirstRowFirstColumn();
        System.out.println("mostPopularGenre = " + mostPopularGenre); //It is action and Adventure
        //bc we put the row in descending order, the most popular genre is the first row which we can obtain by using
        //DB_Util.getFirstRowFirstColumn();

    }
}
