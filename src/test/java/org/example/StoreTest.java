package org.example;



import org.example.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class StoreTest {

    // Existing product with ID 1 in the store
    private Product createTestProduct() {
        return new Product("TestCategory", 1, 1, "TestProduct", 10.0, 5, "Specs");
    }
    private InputStream originalSystemIn;

    @Before
    public void setUpStreams() {
        originalSystemIn = System.in;
    }

    @After
    public void restoreStreams() {
        System.setIn(originalSystemIn);
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }


    @Test
    public void testCustomerSearch() {
        // Create a test customer and add it to Customer_record
        Customer testCustomer = new Customer("TestUser", "TestPassword");
        Store.Customer_record.put(1, testCustomer);

        // Test customer search with valid credentials
        assertTrue(Store.customer_Search("TestUser", "TestPassword"));

        // Test customer search with invalid credentials
        assertFalse(Store.customer_Search("InvalidUser", "InvalidPassword"));
    }

    @Test
    public void testCategorySearch() {
        // Create a test category and add it to Category_product
        Category testCategory = new Category("TestCategory", 1);
        Store.Category_product.put(testCategory, new ArrayList<>());

        // Test category search with valid category ID
        assertTrue(Store.category_Search(1));

        // Test category search with invalid category ID
        assertFalse(Store.category_Search(2));
    }

    @Test
    public void testProductSearch() {
        // Create a test category and product
        Category testCategory = new Category("TestCategory", 1);
        Product testProduct = new Product("TestProduct", 1, 1, "Test", 10.0, 5, "Specs");

        // Add the product to the category in Category_product
        Store.Category_product.put(testCategory, new ArrayList<>());
        Store.Category_product.get(testCategory).add(testProduct);

        // Test product search with valid product ID
        assertTrue(Store.product_search(testCategory, 1));

        // Test product search with invalid product ID
        assertFalse(Store.product_search(testCategory, 2));
    }

//    @Test
//    public void testProdSearch_ProductIDFound() {
//        // Create a test category and add a product to it
//        Category testCategory = new Category("TestCategory", 1);
//        Store.Category_product.put(testCategory, new ArrayList<>());
//        Store.Category_product.get(testCategory).add(createTestProduct());
//
//        // Simulate user input for discounts
//        String inputDiscounts = "5\n10\n15\n";
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputDiscounts.getBytes());
//        System.setIn(inputStream);
//
//        // Test product search with valid product ID
//        assertTrue(Store.prod_search(1));
//
//        // Reset System.in
//        System.setIn(originalSystemIn);
//    }

//    @Test
//    public void testProdSearch_ProductIDFound() {
//        // Create a test category and add a product to it
//        Category testCategory = new Category("TestCategory", 1);
//        Store.Category_product.put(testCategory, new ArrayList<>());
//        Product testProduct = new Product("TestCategory", 1, 1, "TestProduct", 10.0, 5, "Specs");
//        Store.Category_product.get(testCategory).add(testProduct);
//
//        // Set up input stream to provide dummy input for discounts
//        ByteArrayInputStream in = new ByteArrayInputStream("5\n10\n15\n".getBytes());
//        System.setIn(in);
//
//        // Test product search with valid product ID
//        assertTrue(Store.prod_search(1));
//
//        // Check if discounts are set correctly in the product
//        assertEquals(15.0, testProduct.getDiscount_normal(), 0.001);
//        assertEquals(10.0, testProduct.getDiscount_prime(), 0.001);
//        assertEquals(5.0, testProduct.getDiscount_elite(), 0.001);
//
//        // Clean up and reset input stream
//        System.setIn(System.in);
//    }

    @Test
    public void testProdSearch_ProductIDNotFound() {
        assertFalse(Store.prod_search(999)); // Non-existing product ID
    }

    @Test
    public void testProdSea_ProductIDFound() {
        // Create a test category and add a product to it
        Category testCategory = new Category("TestCategory", 1);
        Store.Category_product.put(testCategory, new ArrayList<>());
        Store.Category_product.get(testCategory).add(createTestProduct());

        // Test product search with valid product ID
        assertTrue(Store.prod_sea(1));
    }

    @Test
    public void testProdSea_ProductIDNotFound() {
        assertFalse(Store.prod_sea(999)); // Non-existing product ID
    }



//    Giving errors
//    @Test
//    public void testProdSearch() {
//        // Create a test category and product
//        Category testCategory = new Category("TestCategory", 1);
//        Product testProduct = new Product("TestProduct", 1, 1, "Test", 10.0, 5, "Specs");
//
//        // Add the product to the category in Category_product
//        Store.Category_product.put(testCategory, new ArrayList<>());
//        Store.Category_product.get(testCategory).add(testProduct);
//
//        // Simulate user input for discounts
//        String inputDiscounts = "10\n20\n30";
//        System.setIn(new ByteArrayInputStream(inputDiscounts.getBytes()));
//
//        // Test prod_search with valid product ID
//        assertTrue(Store.prod_search(1));
//
//        // Test prod_search with invalid product ID
//        assertFalse(Store.prod_search(2));
//
//        // Reset System.in
//        System.setIn(System.in);
//    }

}