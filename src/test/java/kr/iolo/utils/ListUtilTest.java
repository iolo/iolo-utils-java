package kr.iolo.utils;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilTest {
    @Test
    public void test_isEmpty() {
        assertTrue("null is empty", ListUtil.isEmpty(null));
        assertTrue("empty", ListUtil.isEmpty(new ArrayList()));
        assertTrue("empty", ListUtil.isEmpty(ListUtil.of()));
    }

    @Test
    public void test_of() {
        List<String> list = ListUtil.of("one", "two");
        assertEquals(2, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        list.add("nine");
        assertEquals("mutable", "nine", list.get(2));
        assertNotNull("empty", ListUtil.of());
        assertNotNull("null first arg", ListUtil.of((Object) null));
        assertNotNull("null vararg", ListUtil.of((Object[]) null));
        assertNotNull("null values", ListUtil.of(null, null));
    }
}
