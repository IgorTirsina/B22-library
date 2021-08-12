package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.utilities.DBUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class BookTableStepDefs {
    BooksPage booksPage = new BooksPage();


    @Then("book information must match the database for {string}")
    public void bookInformationMustMatchTheDatabaseFor(String book) {
        String myQ = "select name,isbn,author,description from books " +
                "where name = '"+book+"'";
        Map<String, Object> dbData = DBUtils.getRowMap(myQ);

        String actualName = booksPage.bookName.getAttribute("value");
        String actualAuthor = booksPage.author.getAttribute("value");
        String actualISBN = booksPage.isbn.getAttribute("value");
        String actualYear = booksPage.year.getAttribute("value");
        String actualDesc = booksPage.description.getAttribute("value");

        String expectedName = dbData.get("name").toString();
        String expectedAuthor = dbData.get("author").toString();
        String expectedYear = dbData.get("year").toString();
        String expectedISBN = dbData.get("isbn").toString();
        String expectedDesc = dbData.get("description").toString();

        Assert.assertEquals(expectedAuthor, actualAuthor);
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedISBN, actualISBN);
        Assert.assertEquals(expectedYear, actualYear);
        Assert.assertEquals(expectedDesc, actualDesc);

    }


}
