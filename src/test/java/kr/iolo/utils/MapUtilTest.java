package kr.iolo.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class MapUtilTest {
    @Test
    public void test_isEmpty() {
        assertTrue("null is empty", MapUtil.isEmpty(null));
        assertTrue("empty", MapUtil.isEmpty(new HashMap()));
        assertTrue("empty", MapUtil.isEmpty(MapUtil.of()));
    }

    @Test
    public void test_단일키값쌍() {
        Map<String, Integer> map = MapUtil.of("one", 1);
        assertEquals(1, map.size());
        assertEquals((Integer) 1, map.get("one"));
        map.put("nine", 9);
        assertEquals("mutable", (Integer) 9, map.get("nine"));
        assertNotNull("null value", MapUtil.of("key", null));
        assertNotNull("null key", MapUtil.of(null, "value"));
        try {
            MapUtil.of(null, null);
            fail("null key and null value");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void test_키배열값배열() {
        Map<String, Integer> map = MapUtil.of(new String[]{"one", "two", "three"}, new Integer[]{1, 2, 3});
        assertEquals(3, map.size());
        assertEquals((Integer) 1, map.get("one"));
        assertEquals((Integer) 2, map.get("two"));
        assertEquals((Integer) 3, map.get("three"));
        map.put("nine", 9);
        assertEquals("mutable", (Integer) 9, map.get("nine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_키배열값배열_짝이맞아야함() {
        MapUtil.of(new String[]{"one", "two", "three"}, new Integer[]{1, 2});
    }

    @Test(expected = ClassCastException.class)
    public void test_키배열값배열_타입이맞아야함() {
        MapUtil.of(new String[]{"one", "two", "three"}, (Integer[]) (new Object[]{1, 2, "ERROR"}));
    }

    @Test
    public void test_키값쌍배열() {
        Map<String, Integer> map = MapUtil.of(String.class, Integer.class, "one", 1, "two", 2, "three", 3);
        assertEquals(3, map.size());
        assertEquals((Integer) 1, map.get("one"));
        assertEquals((Integer) 2, map.get("two"));
        assertEquals((Integer) 3, map.get("three"));
        map.put("nine", 9);
        assertEquals("mutable", (Integer) 9, map.get("nine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_키값쌍배열_짝이_맞아야함() {
        MapUtil.of(String.class, Integer.class, "one", 1, "two", 2, "three");
    }

    @Test(expected = ClassCastException.class)
    public void test_키값쌍배열_타입이_맞아야함() {
        MapUtil.of(String.class, Integer.class, "one", 1, "two", 2, "three", "ERROR");
    }

    @Test
    public void test_키값쌍2차원배열() {
        Map<String, Integer> map = MapUtil.of(String.class, Integer.class, new Object[][]{{"one", 1}, {"two", 2}, {"three", 3}});
        assertEquals(3, map.size());
        assertEquals((Integer) 1, map.get("one"));
        assertEquals((Integer) 2, map.get("two"));
        assertEquals((Integer) 3, map.get("three"));
        map.put("nine", 9);
        assertEquals("mutable", (Integer) 9, map.get("nine"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_키값쌍2차원배열_안쪽배열크기는2_모자라도안됨() {
        MapUtil.of(String.class, Integer.class, new Object[][]{{"one", 1}, {"two", 2}, {"three"}});
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_키값쌍2차원배열_안쪽배열크기는2_남아도안됨() {
        MapUtil.of(String.class, Integer.class, new Object[][]{{"one", 1}, {"two", 2}, {"three", 3, "ERROR"}});
    }

    @Test(expected = ClassCastException.class)
    public void test_키값쌍2차원배열_타입이_맞아야함() {
        MapUtil.of(String.class, Integer.class, new Object[][]{{"one", 1}, {"two", 2}, {"three", "ERROR"}});
    }
}
