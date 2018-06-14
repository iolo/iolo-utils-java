package kr.iolo.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * {@link Set} 유틸리티 모음.
 *
 * @author iolo
 */
public class SetUtil {

    public static boolean isEmpty(Set set) {
        return set == null || set.isEmpty();
    }

    /**
     * 초간단 {@link Set} 빌더.
     *
     * @param <T> 값 타입
     */
    public static class SetBuilder<T> {
        private final Set<T> list = new HashSet<>();

        public SetBuilder<T> add(T value) {
            list.add(value);
            return this;
        }

        public SetBuilder<T> addAll(Collection<T> other) {
            list.addAll(other);
            return this;
        }

        @SafeVarargs
        public final SetBuilder<T> addAll(T... values) {
            if (values != null) {
                Collections.addAll(list, values);
            }
            return this;
        }

        public Set<T> build() {
            return list;
        }

        public Set<T> buildImmutable() {
            return Collections.unmodifiableSet(list);
        }
    }

    public static <T> SetBuilder<T> builder() {//Class<T> valueType) {
        return new SetBuilder<>();
    }

    /**
     * 0개 이상의 값을 가진 {@link Set} 생성.
     * <p>
     * {@link Collections#singleton(Object)}과 달리 mutable 집합을 생성.
     *
     * @param values 값 목록
     * @param <T>    값 타입
     * @return {@link Set} 인스턴스
     * @see Collections#singleton(Object)
     */
    @SafeVarargs
    public static <T> Set<T> of(T... values) {
        final Set<T> list = new HashSet<>();
        if (values != null) {
            Collections.addAll(list, values);
        }
        return list;
    }
}
