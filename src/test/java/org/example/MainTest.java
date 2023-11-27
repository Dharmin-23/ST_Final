package org.example;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.*;

public class MainTest {

    private PrintStream originalSystemOut;
    private ByteArrayOutputStream outputStream;
    private static final String OUTPUT_FILE = "test_output.txt";


    void setfileUp() {
        // Save the original System.out
        originalSystemOut = System.out;

        // Redirect System.out to a ByteArrayOutputStream
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    void tearDown() {
        // Restore the original System.out after each test
        System.setOut(originalSystemOut);

        // Save the captured output to a file
        try (FileWriter writer = new FileWriter(OUTPUT_FILE)) {
            writer.write(outputStream.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testExitFunctionality() {
        // Prepare user input for the welcome method to select "Exit"
        String input = "5\n";  // Simulate user entering "5" for Exit

        // Use System.setIn to redirect System.in to the provided input
        InputStream originalSystemIn = System.in; // Store the original System.in
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
//
        // Redirect System.out to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
//
        // Call the method you want to test (in this case, the welcome method)
        try (Scanner scanner = new Scanner(System.in)) {
            Main.main(new String[]{});
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Restore the original System.in after the test
            System.setIn(originalSystemIn);
        }
        String actualoutput = outContent.toString().trim();
//        setfileUp();
//        System.out.println(actualoutput);
//        tearDown();
//        // Add assertions based on the expected behavior
//        // For example, check if the correct output is generated when exiting
        assertTrue(actualoutput.contains("Check exit"));
    }

    //Add more test methods for other functionalities in the Main class
    @Test
    public void testSearchExitContact() {
        // Arrange
        String input = "5\n";  // Simulate user entering contact information and then exiting
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String expectedMenu = "WELCOME TO FLIPZON:\n" +
                "   1) Enter as Admin\n" +
                "   2) Explore the Product Catalog\n" +
                "   3) Show Available Deals\n" +
                "   4) Enter as Customer\n" +
                "   5) Exit the Application\n" +
                "5\n" +
                "Check exit";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        // Act
        Main.main(new String[]{});

        // Assert
//        String expectedOutput = "Application terminating...\n";
        String actualOutput = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualOutput);
//        tearDown();
        assertEquals(expectedMenu, actualOutput);
        // Add more assertions based on your application's behavior
    }
//    @Test
//    public void testAdminPriviligesAddCategory(){
//        String input = "1\n Vidur\n 2021364\n 7\n 5\n";
//        InputStream originalSystemIn = System.in; // Store the original System.in
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//        String expectedMenu = "WELCOME TO FLIPZON:\n" +
//                "   1) Enter as Admin\n" +
//                "   2) Explore the Product Catalog\n" +
//                "   3) Show Available Deals\n" +
//                "   4) Enter as Customer\n" +
//                "   5) Exit the Application\n" +
//                "1\n" +
//                "Dear Admin,\n" +
//                "Username: Password: Not the authorized admin!!! \n" +
//                "WELCOME TO FLIPZON:\n" +
//                "   1) Enter as Admin\n" +
//                "   2) Explore the Product Catalog\n" +
//                "   3) Show Available Deals\n" +
//                "   4) Enter as Customer\n" +
//                "   5) Exit the Application\n" +
//                "7";
//
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(outputStream));
//        // Act
//        try (Scanner scanner = new Scanner(System.in)) {
//            Main.main(new String[]{});
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            // Restore the original System.in after the test
//            System.setIn(originalSystemIn);
//        }
//        // Assert
//        // String expectedOutput = "Application terminating...\n";
//        String actualOutput = outputStream.toString().trim();
//        setfileUp();
//        System.out.println(actualOutput);
//        tearDown();
//        assertFalse(actualOutput.contains(expectedMenu));
//    }
}
