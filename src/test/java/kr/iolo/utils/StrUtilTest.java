package kr.iolo.utils;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class StrUtilTest {
    @Test
    public void test_isEmpty() {
        assertTrue(StrUtil.isEmpty(null));
        assertTrue(StrUtil.isEmpty(""));
        assertFalse(StrUtil.isEmpty("  "));
        assertFalse(StrUtil.isEmpty("hello"));
        assertFalse(StrUtil.isEmpty("hello  "));
        assertFalse(StrUtil.isEmpty("  hello  "));
    }

    @Test
    public void test_nvl() {
        assertEquals("", StrUtil.nvl(null));
        assertEquals("", StrUtil.nvl(""));
        assertEquals("hello", StrUtil.nvl("hello"));
        assertEquals("hello", StrUtil.nvl(null, "hello"));
        assertEquals("hello", StrUtil.nvl(null, () -> "hello"));
        assertEquals("", StrUtil.nvl(null, () -> null));
    }

    @Test
    public void test_toLong() {
        assertEquals(123L, StrUtil.toLong("123", 456));
        assertEquals(456L, StrUtil.toLong("**error**", 456));
        assertEquals(456L, StrUtil.toLong(null, 456));
        assertEquals(123L, StrUtil.toLong("123", () -> 456L));
        assertEquals(456L, StrUtil.toLong("**error**", () -> 456L));
        assertEquals(456L, StrUtil.toLong(null, () -> 456L));
    }

    @Test
    public void test_toInt() {
        assertEquals(123, StrUtil.toInt("123", 456));
        assertEquals(456, StrUtil.toInt("**error**", 456));
        assertEquals(456, StrUtil.toInt(null, 456));
        assertEquals(123, StrUtil.toInt("123", () -> 456));
        assertEquals(456, StrUtil.toInt("**error**", () -> 456));
        assertEquals(456, StrUtil.toInt(null, () -> 456));
    }

    @Test
    public void test_toDouble() {
        assertEquals(.123, StrUtil.toDouble(".123", .456), .0001);
        assertEquals(.456, StrUtil.toDouble("**error**", .456), .0001);
        assertEquals(.456, StrUtil.toDouble(null, .456), .0001);
        assertEquals(.123, StrUtil.toDouble(".123", () -> .456), .0001);
        assertEquals(.456, StrUtil.toDouble("**error**", () -> .456), .0001);
        assertEquals(.456, StrUtil.toDouble(null, () -> .456), .0001);
    }

    @Test
    public void test_toBigDecimal() {
        assertEquals(BigDecimal.valueOf(.123), StrUtil.toBigDecimal(".123", BigDecimal.valueOf(.456)));
        assertEquals(BigDecimal.valueOf(.456), StrUtil.toBigDecimal("**error**", BigDecimal.valueOf(.456)));
        assertEquals(BigDecimal.valueOf(.456), StrUtil.toBigDecimal(null, BigDecimal.valueOf(.456)));
        assertEquals(BigDecimal.valueOf(.123), StrUtil.toBigDecimal(".123", () -> BigDecimal.valueOf(.456)));
        assertEquals(BigDecimal.valueOf(.456), StrUtil.toBigDecimal("**error**", () -> BigDecimal.valueOf(.456)));
        assertEquals(BigDecimal.valueOf(.456), StrUtil.toBigDecimal(null, () -> BigDecimal.valueOf(.456)));
    }

    @Test
    public void test_toBoolean() {
        assertEquals(true, StrUtil.toBoolean("true", false));
        assertEquals(false, StrUtil.toBoolean("**error**", false));
        assertEquals(false, StrUtil.toBoolean(null, false));
        assertEquals(true, StrUtil.toBoolean("true", () -> false));
        assertEquals(false, StrUtil.toBoolean("**error**", () -> false));
        assertEquals(false, StrUtil.toBoolean(null, () -> false));
    }
}
