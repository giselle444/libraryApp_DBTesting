package com.cydeo.steps;

import com.cydeo.pages.BasePage;
import com.cydeo.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class US01_StepDefs extends BasePage {
    List<String> listOfId = new ArrayList<>();
    List<String> listOfAllColumns = new ArrayList<>();
    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        DB_Util.createConnection();

    }
    @When("Execute query to get all IDs from users")
    public void execute_query_to_get_all_i_ds_from_users() {

            DB_Util.runQuery("select * from users");
            listOfId = DB_Util.getColumnDataAsList(1);


    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        for (int i = 0; i < listOfId.size(); i++) {
            for (int j = 0; j < listOfId.size(); j++) {
                Assert.assertFalse(listOfId.get(i).equals(listOfId.get(j)) && i !=j);

            }

        }


    }

    @When("Execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery("select * from users;");
        listOfAllColumns=DB_Util.getAllColumnNamesAsList();
        System.out.println("listOfAllColumns = " + listOfAllColumns);
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> dataTable) {
        Assert.assertEquals(dataTable,listOfAllColumns);


    }
}
