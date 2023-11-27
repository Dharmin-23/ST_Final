package org.example;

import org.example.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        // Create a test product
        Product testProduct = new Product("TestCategory", 1, 1, "TestProduct", 10.0, 5, "Specs");

        // Test getters
        assertEquals(1, testProduct.getProduct_id(), 0);
        assertEquals("TestProduct", testProduct.getProduct_name());
        assertEquals(10.0, testProduct.getPrice(), 0);
        assertEquals(5, testProduct.getQuantity());
        assertEquals("Specs", testProduct.getSpecifications());
        assertEquals(0, testProduct.getDiscount_normal(), 0);
        assertEquals(0, testProduct.getDiscount_prime(), 0);
        assertEquals(0, testProduct.getDiscount_elite(), 0);

        // Test setters
        testProduct.setProduct_id(2);
        testProduct.setProduct_name("NewProduct");
        testProduct.setPrice(20.0);
        testProduct.setQuantity(10);
        testProduct.setSpecifications("NewSpecs");
        testProduct.setDiscount_normal(5.0);
        testProduct.setDiscount_prime(10.0);
        testProduct.setDiscount_elite(15.0);

        assertEquals(2, testProduct.getProduct_id(), 0);
        assertEquals("NewProduct", testProduct.getProduct_name());
        assertEquals(20.0, testProduct.getPrice(), 0);
        assertEquals(10, testProduct.getQuantity());
        assertEquals("NewSpecs", testProduct.getSpecifications());
        assertEquals(5.0, testProduct.getDiscount_normal(), 0);
        assertEquals(10.0, testProduct.getDiscount_prime(), 0);
        assertEquals(15.0, testProduct.getDiscount_elite(), 0);
    }

    @Test
    public void testPrintProduct() {
        // Create a test product
        Product testProduct = new Product("TestCategory", 1, 1, "TestProduct", 10.0, 5, "Specs");

        // Test the printProduct method
        assertEquals("Product name: TestProduct\n" +
                "Product price per unit: 10.0\n" +
                "Product Id: 1.0\n" +
                "Product Specifications: Specs\n" +
                "Quantity: 5", captureOutput(() -> testProduct.printProduct()));
    }

    @Test
    public void testProductConstructor() {
        // Create a test product
        Product originalProduct = new Product("TestCategory", 1, 1, "TestProduct", 10.0, 5, "Specs");

        // Create a new product using the copy constructor
        Product copiedProduct = new Product(originalProduct, 2);

        // Test if the copied product has the same properties
        assertEquals(originalProduct.getProduct_id(), copiedProduct.getProduct_id(), 0);
        assertEquals(originalProduct.getProduct_name(), copiedProduct.getProduct_name());
        assertEquals(originalProduct.getPrice(), copiedProduct.getPrice(), 0);
        assertEquals(2, copiedProduct.getQuantity());
        assertEquals(originalProduct.getSpecifications(), copiedProduct.getSpecifications());
        assertEquals(originalProduct.getDiscount_normal(), copiedProduct.getDiscount_normal(), 0);
        assertEquals(originalProduct.getDiscount_prime(), copiedProduct.getDiscount_prime(), 0);
        assertEquals(originalProduct.getDiscount_elite(), copiedProduct.getDiscount_elite(), 0);
    }

    // Helper method to capture System.out.println output
    private String captureOutput(Runnable code) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        try {
            code.run();
            return outputStream.toString().trim();
        } finally {
            System.setOut(originalOut);
        }
    }
}

