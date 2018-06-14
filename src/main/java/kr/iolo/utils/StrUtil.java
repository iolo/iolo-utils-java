package kr.iolo.utils;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.function.Supplier;

/**
 * {@link String} 유틸리티 모음.
 *
 * @author iolo
 */
public class StrUtil {

    public static final String EMPTY = "";

    public static boolean isEmpty(String s) {
        return s == null || s.isEmpty();
    }

    @NotNull
    public static String nvl(String s) {
        return s != null ? s : EMPTY;
    }

    @NotNull
    public static String nvl(String s, @NotNull String defaultValue) {
        //Optional.ofNullable(s).orElse(defaultValue);
        return s != null ? s : defaultValue;
    }

    @NotNull
    public static String nvl(String s, @NotNull Supplier<String> defaultValueSupplier) {
        //notNull(Optional.ofNullable(s).orElseGet(defaultValueSupplier));
        return s != null ? s : nvl(defaultValueSupplier.get());
    }

    @NotNull
    public static Optional<Long> toLong(String s) {
        try {
            return Optional.of(Long.valueOf(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static long toLong(String s, Supplier<Long> defaultSupplier) {
        return toLong(s).orElseGet(defaultSupplier);
    }

    public static long toLong(String s, long defaultValue) {
        //return toLong(s).orElse(defaultValue);
        try {
            return Long.valueOf(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @NotNull
    public static Optional<Integer> toInt(String s) {
        try {
            return Optional.of(Integer.valueOf(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static int toInt(String s, @NotNull Supplier<Integer> defaultSupplier) {
        return toInt(s).orElseGet(defaultSupplier);
    }

    public static int toInt(String s, int defaultValue) {
        //return toInt(s).orElse(defaultValue);
        try {
            return Integer.valueOf(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @NotNull
    public static Optional<Double> toDouble(String s) {
        try {
            return Optional.of(Double.valueOf(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public static double toDouble(String s, @NotNull Supplier<Double> defaultSupplier) {
        return toDouble(s).orElseGet(defaultSupplier);
    }

    public static double toDouble(String s, double defaultValue) {
        //return toDouble(s).orElse(defaultValue);
        try {
            return Double.valueOf(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @NotNull
    public static Optional<BigDecimal> toBigDecimal(String s) {
        try {
            return Optional.of(new BigDecimal(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @NotNull
    public static BigDecimal toBigDecimal(String s, @NotNull Supplier<BigDecimal> defaultSupplier) {
        return toBigDecimal(s).orElseGet(defaultSupplier);
    }

    @NotNull
    public static BigDecimal toBigDecimal(String s, @NotNull BigDecimal defaultValue) {
        //return toBigDecimal(s).orElse(defaultValue);
        try {
            return new BigDecimal(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    @NotNull
    public static Optional<Boolean> toBoolean(String s) {
        try {
            return Optional.of(Boolean.valueOf(s));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @NotNull
    public static boolean toBoolean(String s, @NotNull Supplier<Boolean> defaultSupplier) {
        return toBoolean(s).orElseGet(defaultSupplier);
    }

    @NotNull
    public static boolean toBoolean(String s, boolean defaultValue) {
        //return toBoolean(s).orElse(defaultValue);
        try {
            return Boolean.valueOf(s);
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
