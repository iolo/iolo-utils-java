package kr.iolo.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;

import static org.junit.Assert.*;

public class EnumUtilTest {
    enum TestEnum {
        FOO, BAR, BAZ, QUX
    }

    @Test
    public void test_of_withType() {
        assertEquals(TestEnum.FOO, EnumUtil.of(TestEnum.class, "foo").get());
        assertEquals(TestEnum.FOO, EnumUtil.of(TestEnum.class, "FOO").get());
        assertEquals(TestEnum.FOO, EnumUtil.of(TestEnum.class, "Foo").get());
        assertEquals(TestEnum.BAR, EnumUtil.of(TestEnum.class, "  bar  ").get());
        assertEquals(TestEnum.BAR, EnumUtil.of(TestEnum.class, "  BAR  ").get());
        assertEquals(TestEnum.BAR, EnumUtil.of(TestEnum.class, "  Bar  ").get());
        assertFalse(EnumUtil.of(TestEnum.class, "__unknown__").isPresent());
        assertFalse(EnumUtil.of(TestEnum.class, "").isPresent());
        assertFalse(EnumUtil.of(TestEnum.class, null).isPresent());
    }

    @Test
    public void test_of_withDefault() {
        assertEquals(TestEnum.FOO, EnumUtil.of("foo", TestEnum.QUX));
        assertEquals(TestEnum.FOO, EnumUtil.of("FOO", TestEnum.QUX));
        assertEquals(TestEnum.FOO, EnumUtil.of("Foo", TestEnum.QUX));
        assertEquals(TestEnum.BAR, EnumUtil.of("  bar  ", TestEnum.QUX));
        assertEquals(TestEnum.BAR, EnumUtil.of("  BAR  ", TestEnum.QUX));
        assertEquals(TestEnum.BAR, EnumUtil.of("  Bar  ", TestEnum.QUX));
        assertEquals(TestEnum.BAZ, EnumUtil.of("__unknown__", TestEnum.BAZ));
        assertEquals(TestEnum.BAZ, EnumUtil.of("", TestEnum.BAZ));
        assertEquals(TestEnum.BAZ, EnumUtil.of(null, TestEnum.BAZ));
    }

    @Test
    public void test_setOf() {
        assertEquals(EnumSet.allOf(TestEnum.class), EnumUtil.setOf(TestEnum.class, Arrays.asList("foo", "bar", "baz", "qux")));
        assertEquals(EnumSet.allOf(TestEnum.class), EnumUtil.setOf(TestEnum.class, Arrays.asList("FOO", "Bar", "  baz  ", "  Qux  ", "__unknown__")));
        assertEquals(EnumSet.noneOf(TestEnum.class), EnumUtil.setOf(TestEnum.class, Collections.emptyList()));
        assertTrue(EnumUtil.setOf(TestEnum.class, Collections.emptyList()).isEmpty());
    }

    @Test
    public void test_names() {
        assertTrue(EnumUtil.names(EnumSet.allOf(TestEnum.class)).containsAll(Arrays.asList("FOO", "BAR", "BAZ", "QUX")));
        assertTrue(EnumUtil.names(EnumSet.of(TestEnum.FOO, TestEnum.BAR)).contains("FOO"));
        assertTrue(EnumUtil.names(EnumSet.of(TestEnum.FOO, TestEnum.BAR)).contains("BAR"));
        assertFalse(EnumUtil.names(EnumSet.of(TestEnum.FOO, TestEnum.BAR)).contains("BAZ"));
        assertFalse(EnumUtil.names(EnumSet.of(TestEnum.FOO, TestEnum.BAR)).contains("QUX"));
        assertTrue(EnumUtil.names(EnumSet.noneOf(TestEnum.class)).isEmpty());
    }
}
