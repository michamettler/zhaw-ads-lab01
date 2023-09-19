package ch.zhaw.ads;

import ch.zhaw.ads.solutions.ListStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ADS1_2_test {
    ListStack stack;

    @BeforeEach
    public void setUp() {
        stack = new ListStack();
    }

    @Test
    public void testPush1() {
        stack.push("A");
        Object o = stack.pop();
        assertEquals("A", o);
    }

    @Test
    public void testPush2() {
        stack.push("A");
        stack.push("B");
        assertEquals("B", stack.pop());
        assertEquals("A", stack.pop());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("A");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsFull() {
        assertFalse(stack.isFull());
    }

    @Test
    public void testEmptyPop() {
        assertNull(stack.pop());
    }
}