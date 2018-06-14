package kr.iolo.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Map} 유틸리티 모음.
 *
 * @author iolo
 */
public class MapUtil {

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * 초간단 {@link Map} 빌더.
     *
     * @param <K> 키 타입
     * @param <V> 값 타입
     */
    public static class MapBuilder<K, V> {
        private final Map<K, V> map = new HashMap<>();

        public MapBuilder<K, V> put(K key, V value) {
            map.put(key, value);
            return this;
        }

        public MapBuilder<K, V> putAll(Map<K, V> other) {
            if (other != null) {
                map.putAll(other);
            }
            return this;
        }

        public Map<K, V> build() {
            return map;
        }
    }

    public static <K, V> MapBuilder<K, V> builder() {//Class<K> keyType, Class<V> valueType) {
        return new MapBuilder<>();
    }

    /**
     * 빈 {@link HashMap} 생성.
     *
     * @param <K> 키 타입
     * @param <V> 값 타입
     * @return {@link HashMap} 인스턴스
     */
    public static <K, V> Map<K, V> of() {
        return new HashMap<>();
    }

    /**
     * 하나의 키-값 쌍만을 가진 {@link HashMap} 생성.
     * <p>
     * {@link Collections#singletonMap(Object, Object)}과 달리 mutable 맵을 생성.
     *
     * @param key   키
     * @param value 값
     * @param <K>   키 타입
     * @param <V>   값 타입
     * @return {@link HashMap} 인스턴스
     * @see Collections#singletonMap(Object, Object)
     */
    public static <K, V> Map<K, V> of(K key, V value) {
        final Map<K, V> map = new HashMap<>(1);
        map.put(key, value);
        return map;
    }

    /**
     * 여러개의 키-값 쌍만을 가진 {@link HashMap} 생성.
     *
     * @param keys   키 목록
     * @param values 값 목록
     * @param <K>    키 타입
     * @param <V>    값 타입
     * @return {@link HashMap} 인스턴스
     * @throws IllegalArgumentException 키-값 쌍이 짝이 맞지 않음
     */
    public static <K, V> Map<K, V> of(K[] keys, V[] values) {
        final int len = keys.length;
        if (len != values.length) {
            throw new IllegalArgumentException("invalid key-value pairs");
        }
        final Map<K, V> map = new HashMap<>(len);
        for (int i = 0; i < len; i += 1) {
            map.put(keys[i], values[i]);
        }
        return map;
    }

    /**
     * 여러개의 키-값 쌍만을 가진 {@link HashMap} 생성.
     *
     * @param keyType      키 클래스
     * @param valueType    값 클래스
     * @param keyAndValues 키-값 쌍(1차원 배열)
     * @param <K>          키 타입
     * @param <V>          값 타입
     * @return {@link HashMap} 인스턴스
     * @throws IllegalArgumentException 키-값 쌍이 짝이 맞지 않음
     * @throws ClassCastException       키-값 의 타입이 맞지 않음
     */
    public static <K, V> Map<K, V> of(Class<K> keyType, Class<V> valueType, Object... keyAndValues) {
        final int len = keyAndValues.length;
        if (len % 2 != 0) {
            throw new IllegalArgumentException("invalid key-value pairs");
        }
        final Map<K, V> map = new HashMap<>(len / 2);
        for (int i = 0; i < len; i += 2) {
            map.put(keyType.cast(keyAndValues[i]), valueType.cast(keyAndValues[i + 1]));
        }
        return map;
    }

    /**
     * 여러개의 키-값 쌍만을 가진 {@link HashMap} 생성.
     *
     * @param keyType      키 클래스
     * @param valueType    값 클래스
     * @param keyAndValues 키-값 쌍(2차원 배열 형식)
     * @param <K>          키 타입
     * @param <V>          값 타입
     * @return {@link HashMap} 인스턴스
     * @throws IllegalArgumentException 키-값 쌍이 짝이 맞지 않음
     * @throws ClassCastException       키-값 의 타입이 맞지 않음
     */
    public static <K, V> Map<K, V> of(Class<K> keyType, Class<V> valueType, Object[]... keyAndValues) {
        final int len = keyAndValues.length;
        final Map<K, V> map = new HashMap<>(len);
        for (final Object[] keyAndValue : keyAndValues) {
            if (keyAndValue.length != 2) {
                throw new IllegalArgumentException("invalid key-value pairs");
            }
            map.put(keyType.cast(keyAndValue[0]), valueType.cast(keyAndValue[1]));
        }
        return map;
    }

}
