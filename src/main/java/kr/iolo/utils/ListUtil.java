package kr.iolo.utils;

import java.util.*;

/**
 * {@link List} 유틸리티 모음.
 *
 * @author iolo
 */
public class ListUtil {

    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    /**
     * 초간단 {@link List} 빌더.
     *
     * @param <T> 값 타입
     */
    public static class ListBuilder<T> {
        private final List<T> list = new ArrayList<>();

        public ListBuilder<T> add(T value) {
            list.add(value);
            return this;
        }

        public ListBuilder<T> addAll(Collection<T> other) {
            list.addAll(other);
            return this;
        }

        @SafeVarargs
        public final ListBuilder<T> addAll(T... values) {
            if (values != null) {
                Collections.addAll(list, values);
            }
            return this;
        }

        public List<T> build() {
            return new ArrayList<>(list);
        }

        public List<T> buildImmutable() {
            return Collections.unmodifiableList(list);
        }
    }

    public static <T> ListBuilder<T> builder() {//Class<T> valueType) {
        return new ListBuilder<>();
    }

    /**
     * 하나 이상의 값을 가진 {@link ArrayList} 생성.
     * <p>
     * {@link Collections#singletonList(Object)}과 달리 mutable 리스트를 생성.
     *
     * @param values 값 목록
     * @param <T>    값 타입
     * @return {@link ArrayList} 인스턴스
     * @see Collections#singletonList(Object)
     * @see Arrays#asList(Object[])
     */
    @SafeVarargs
    public static <T> List<T> of(T... values) {
        final List<T> list = new ArrayList<>();
        if (values != null) {
            Collections.addAll(list, values);
        }
        return list;
    }
}
