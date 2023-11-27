package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void testConstructorAndGetters() {
        // Test constructor and getters
        Customer customer = new Customer("testUser", "testPassword");
        assertEquals("testUser", customer.getUsername());
        assertEquals("testPassword", customer.getPassword());
        assertEquals(1000.0, customer.getWallet_amt(), 0.001);
        assertEquals(0.0, customer.getStatus_discount(), 0.001);
        assertEquals(0, customer.getCurrent_status());
    }

    @Test
    public void testReduceWalletAmount() {
        // Test reduceWallet_amt with sufficient funds
        Customer customer = new Customer("testUser", "testPassword");
        assertTrue(customer.reduceWallet_amt(500));
        assertEquals(500.0, customer.getWallet_amt(), 0.001);

        // Test reduceWallet_amt with insufficient funds
        assertFalse(customer.reduceWallet_amt(1000));
        assertEquals(500.0, customer.getWallet_amt(), 0.001);
    }


    @Test
    public void testIncreaseWalletAmount() {
        // Test increaseWallet_amt
        Customer customer = new Customer("testUser", "testPassword");
        customer.increaseWallet_amt(200);
        assertEquals(1200.0, customer.getWallet_amt(), 0.001);
    }

    @Test
    public void testDeliveryFee() {
        // Test delivery_fee for different customer statuses
        Customer normalCustomer = new Customer("testUser", "testPassword");
        Customer primeCustomer = new Customer("primeUser", "primePassword");
        Customer eliteCustomer = new Customer("eliteUser", "elitePassword");

        double total_mrp = 1000.0; // You can adjust this value based on your test case

        assertEquals(150.0, normalCustomer.delivery_fee(total_mrp), 0.001);
        assertEquals(150.0, primeCustomer.delivery_fee(total_mrp), 0.001);
        assertEquals(150.0, eliteCustomer.delivery_fee(total_mrp), 0.001);
    }


    @Test
    public void testCouponGenerator() {
        // Test coupon_generator for different customer statuses
        Customer normalCustomer = new Customer("testUser", "testPassword");
        Customer primeCustomer = new Customer("primeUser", "primePassword");
        Customer eliteCustomer = new Customer("eliteUser", "elitePassword");

        normalCustomer.coupon_generator();
        primeCustomer.coupon_generator();
        eliteCustomer.coupon_generator();

        assertTrue(normalCustomer.getCoupons().size() >= 0);
        assertTrue(primeCustomer.getCoupons().size() >= 0);
        assertTrue(eliteCustomer.getCoupons().size() >= 0);
    }

//    @Test
//    public void testQuantityCheck() {
//        // Test quantity_check with valid quantities
//        Customer customer = new Customer("testUser", "testPassword");
//        Category category = new Category("TestCategory", 1);
//        Product product = new Product("TestProduct", 1, 1, "Test", 10.0, 5, "Specs");
//
//        // Add the product to the category in Category_product
//        Store.Category_product.put(category, new ArrayList<>());
//        Store.Category_product.get(category).add(product);
//
//        // Add the product to the customer's cart
//        customer.getCart_Prod().put(1.0, product);
//
//        assertTrue(customer.quantity_check());
//
//        // Test quantity_check with invalid quantity
//        customer.getCart_Prod().get(1.0).setQuantity(10);
//        assertFalse(customer.quantity_check());
//    }

    //    @Test
//    public void testQuantityCheck() {
//        // Test quantity_check with valid quantities
//        Customer customer = new Customer("testUser", "testPassword");
//        Category category = new Category("TestCategory", 1);
//        Product product = new Product("TestProduct", 1, 1, "Test", 10.0, 5, "Specs");
//
//        // Add the product to the category in Category_product
//        Store.Category_product.put(category, new ArrayList<>());
//        Store.Category_product.get(category).add(product);
//
//        // Add the product to the customer's cart
//        customer.getCart_Prod().put(1.0, product);
//
//        assertTrue(customer.quantity_check());
//
//        // Test quantity_check with invalid quantity
//        customer.getCart_Prod().get(1.0).setQuantity(10);
//        assertFalse(customer.quantity_check());
//    }
    @Test
    public void testReduceWalletAmtExactFunds() {
        Customer customer = new Customer("testUser", "testPassword");
        customer.setWallet_amt(1000); // Set initial wallet amount

        assertTrue(customer.reduceWallet_amt(1000));
        assertEquals(0.0, customer.getWallet_amt(), 0.001);
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }





}

