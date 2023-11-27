package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CategoryTest {

    @Test
    public void testGetCategoryName() {
        // Create a Category instance with a specific name and id
        Category category = new Category("Electronics", 1);

        // Call the getCategory_name method and assert the expected output
        assertEquals("Electronics", category.getCategory_name());
    }

    @Test
    public void testGetCategoryId() {
        // Create a Category instance with a specific name and id
        Category category = new Category("Clothing", 2);

        // Call the getCategory_id method and assert the expected output
        assertEquals(2, category.getCategory_id());
    }

    @Test
    public void testPrintCategory() {
        // Create a Category instance with a specific name and id
        Category category = new Category("Books", 3);

        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the printCategory method
        category.printCategory();

        // Restore the original System.out
        PrintStream originalSystemOut = null;
        System.setOut(originalSystemOut);

        // Check if the printed output matches the expected output
        String actualOutput = outContent.toString().trim();
        assertTrue(actualOutput.contains("Category name: Books"));
        assertTrue(actualOutput.contains("Category Id: 3"));
    }
}

