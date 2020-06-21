package test.java;

import main.java.Range;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    private Range<Integer> range = new Range<>(0, 10);
    private Range<Integer> rangeSame = new Range<>(0, 10);
    private Range<Integer> rangeOutside = new Range<>(-5, -1);
    private Range<Integer> rangeOverlap = new Range<>(-5, 15);

    private Range<String> rangeString = new Range<>("Fokki", "Fokki fokki");
    private Range<String> rangeOverlapString = new Range<>("Fok", "Fokki fokk");

    @Test
    public void testXInsideRange() {
        assertTrue(range.isInside(5));
    }

    @Test
    public void testStringInsideRange() {
        assertTrue(rangeString.isInside("Fokki fo"));
    }

    @Test
    public void testStringOutsideRange() {
        assertFalse(rangeString.isInside("Foppi foppi"));
    }

    @Test
    public void testXOutsideRange() {
        assertFalse(range.isInside(12));
    }

    @Test
    public void testIsOverlap() {
        assertTrue(range.isOverlapping(rangeOverlap));
    }

    @Test
    public void testIsNotOverlap() {
        assertFalse(range.isOverlapping(rangeOutside));
    }

    @Test
    public void testEquals() {
        assertEquals(range, rangeSame);
    }

    @Test
    public void testNotEquals() {
        assertNotEquals(range, rangeOutside);
    }

    @Test
    public void testHashCodeConsistentWithEquals() {
        assertEquals(range.equals(rangeSame), (range.hashCode() == rangeSame.hashCode()));
    }
}