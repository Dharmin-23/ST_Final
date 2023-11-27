package org.example;

import org.example.Input;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class InputTest {


    @Test
    public void testUser1() {
        // Test the value of the hardcoded user1 instance
        assertEquals("Vidur", Input.user1.getUsername());
        assertEquals("2021364", Input.user1.getPassword());
    }

    @Test
    public void testUser2() {
        // Test the value of the hardcoded user2 instance
        assertEquals("A", Input.user2.getUsername());
        assertEquals("A", Input.user2.getPassword());
    }

    @Test
    public void testInputNum() {
        // Simulate user input of 42
        String input = "42";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test the input_num method
        assertEquals(42, Input.input_num());
    }

    @Test
    public void testInputAmt() {
        // Simulate user input of 100
        String input = "100";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test the input_amt method
        assertEquals(100, Input.input_amt());
    }

    @Test
    public void testInputString() {
        // Simulate user input of "Test Input"
        String input = "Test Input";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test the input_string method
        assertEquals("Test Input", Input.input_string());
    }

    @Test
    public void testInputSim() {
        // Simulate user input of 5
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test the input_sim method
        assertEquals(5, Input.input_sim());
    }

    @Test
    public void testInputId() {
        // Simulate user input of 3.14
        String input = "3.14";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Test the input_id method
        assertEquals(3.14, Input.input_id(), 0);
    }

    @Test(expected = NoSuchElementException.class)
    public void testInputNumException() {
        // Simulate user input of non-integer
        String input = "abc";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Expecting NoSuchElementException
        Input.input_num();
    }
}

