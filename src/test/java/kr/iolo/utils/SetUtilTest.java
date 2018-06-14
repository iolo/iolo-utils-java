package kr.iolo.utils;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class SetUtilTest {
    @Test
    public void test_isEmpty() {
        assertTrue("null is empty", SetUtil.isEmpty(null));
        assertTrue("empty", SetUtil.isEmpty(new HashSet()));
        assertTrue("empty", SetUtil.isEmpty(SetUtil.of()));
    }

    @Test
    public void test_of() {
        Set<String> set = SetUtil.of("one", "two");
        assertEquals(2, set.size());
        assertTrue(set.contains("one"));
        assertTrue(set.contains("two"));
        set.add("nine");
        assertTrue("mutable", set.contains("nine"));
        assertTrue("empty", SetUtil.of().isEmpty());
        assertEquals("null value", 1, SetUtil.of((Object)null).size());
        assertEquals("null values", 1, SetUtil.of(null, null).size());
    }
}
