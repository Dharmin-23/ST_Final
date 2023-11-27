//package org.example;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
//
//import static org.junit.Assert.*;
//
//public class AdminTest {
//
//    private final InputStream originalSystemIn = System.in;
//    private ByteArrayInputStream testIn;
//
//    @Before
//    public void setUp() {
//        // Set up a default input stream
//        testIn = new ByteArrayInputStream("".getBytes());
//        System.setIn(testIn);
//    }
//
//    @After
//    public void tearDown() {
//        // Restore the original input stream after each test
//        System.setIn(originalSystemIn);
//    }
//
//    @Test
//    public void testAddCategory_Success() {
//        // Test adding a category with a unique ID
//        testIn = new ByteArrayInputStream("1\nTestCategory\n".getBytes());
//        System.setIn(testIn);
//
//        Admin admin = new Admin("admin", "admin");
//        admin.add_category();
//
//        assertTrue(Store.category_Search(1));
//    }
//
////    @Test
////    public void testAddCategory_DuplicateID() {
////        // Test adding a category with a duplicate ID
////        testIn = new ByteArrayInputStream("1\nTestCategory\n1\nTestCategory\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////        admin.add_category();
////
////        assertFalse(Store.category_Search(1));
////    }
////
////    @Test
////    public void testAddProduct_Success() {
////        // Test adding a product to an existing category
////        testIn = new ByteArrayInputStream("1\nTestCategory\n1\nTestProduct\n1\n10.0\n5\nSpecs\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////
////        // Add a category first
////        admin.add_category();
////
////        // Add a product to the existing category
////        admin.add_product(new Category("TestCategory", 1));
////
////        assertTrue(Store.product_search(new Category("TestCategory", 1), 1));
////    }
////
////    @Test
////    public void testAddProduct_NonExistingCategory() {
////        // Test adding a product to a non-existing category
////        testIn = new ByteArrayInputStream("1\nTestProduct\n1\n10.0\n5\nSpecs\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////
////        // Attempt to add a product without adding a category first
////        admin.add_product(new Category("NonExistingCategory", 2));
////
////        assertFalse(Store.product_search(new Category("NonExistingCategory", 2), 1));
////    }
////
////    @Test
////    public void testDeleteProduct_Success() {
////        // Test deleting an existing product
////        testIn = new ByteArrayInputStream("1\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////
////        // Add a category and product first
////        testIn = new ByteArrayInputStream("1\nTestCategory\n1\nTestProduct\n1\n10.0\n5\nSpecs\n".getBytes());
////        System.setIn(testIn);
////        admin.add_category();
////        admin.add_product(new Category("TestCategory", 1));
////
////        // Delete the existing product
////        admin.delete_product(new Category("TestCategory", 1));
////
////        assertFalse(Store.product_search(new Category("TestCategory", 1), 1));
////    }
////
////    @Test
////    public void testDeleteProduct_NonExistingProduct() {
////        // Test deleting a non-existing product
////        testIn = new ByteArrayInputStream("2\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////
////        // Add a category first
////        testIn = new ByteArrayInputStream("1\nTestCategory\n".getBytes());
////        System.setIn(testIn);
////        admin.add_category();
////
////        // Attempt to delete a product without adding one
////        admin.delete_product(new Category("TestCategory", 1));
////
////        // Should not prompt again as there's no product with ID 2
////    }
////
////    @Test
////    public void testAddGiveAwayDeal_Success() {
////        // Test adding a give away deal
////        testIn = new ByteArrayInputStream("1\n1\n2\n3\n".getBytes());
////        System.setIn(testIn);
////
////        Admin admin = new Admin("admin", "admin");
////        admin.add_give_away_deal();
////
////        assertTrue(Store.Deals.containsKey(1.0));
////    }
//}
