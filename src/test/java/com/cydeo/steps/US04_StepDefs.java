package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.BookPage;
import com.cydeo.utility.DB_Util;
import com.google.common.collect.Maps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

public class US04_StepDefs extends BasePage {
    BookPage bookPage=new BookPage();


    @When("I open Book {string}")
    public void iOpenBook(String book) {
        bookPage.search.sendKeys(book);
        bookPage.editBook(book);


    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {
        String actualBookName=bookPage.bookName.getAttribute("value");

        String actualAuthorName=bookPage.author.getAttribute("value");

        String actualISBN= bookPage.isbn.getAttribute("value");
        String actualYear=bookPage.year.getAttribute("value");
        String actualDesc=bookPage.description.getAttribute("value");

      DB_Util.runQuery(" select name, isbn, author,description,year from books\n" +
                "where name= '"+bookPage.bookName+"'");

        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        String expectedBookName=bookInfo.get("name");
        String expectedAuthorName=bookInfo.get("author");
        String expectedISBN=bookInfo.get("isbn");
        String expectedYear=bookInfo.get("year");
        String expectedDesc=bookInfo.get("description");

        //compare
        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedISBN,actualISBN);
        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedDesc,actualDesc);


    }
}
