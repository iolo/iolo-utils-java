package kr.iolo.utils;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * {@link Enum} 유틸리티 모음.
 *
 * @author iolo
 */
public class EnumUtil {

    /**
     * 대소문자 구분없이 이름이 일치하는 enum 상수를 얻음.
     *
     * @param type enum 클래스
     * @param name enum 이름
     * @param <T>  enum 타입
     * @return enum 상수
     * @see Enum#valueOf(Class, String)
     */
    @NotNull
    public static <T extends Enum<T>> Optional<T> of(@NotNull Class<T> type, String name) {
        try {
            return Optional.of(T.valueOf(type, name.trim().toUpperCase()));
        } catch (IllegalArgumentException | NullPointerException e) {
            // TODO: 여기서 뭔가 휴스리스틱한 변환을 시도해야 할까?
            return Optional.empty();
        }
    }

    /**
     * 대소문자 구분없이 이름이 일치하는 enum 상수를 얻음.
     *
     * @param name         enum 이름
     * @param defaultValue 일치하는 enum 상수가 없을 때 리턴할 enum 상수
     * @param <T>          enum 타입
     * @return enum 상수
     * @see Enum#valueOf(Class, String)
     */
    @NotNull
    public static <T extends Enum<T>> T of(String name, @NotNull T defaultValue) {
        return of(defaultValue.getDeclaringClass(), name).orElse(defaultValue);
    }

    /**
     * enum 이름 목록을 중복없는 enum 상수 목록으로 변환.
     *
     * @param names enum 이름 목록
     * @param type  enum 클래스
     * @param <T>   enum 타입
     * @return enum 상수 집합
     */
    @NotNull
    public static <T extends Enum<T>> Set<T> setOf(@NotNull Class<T> type, @NotNull Collection<String> names) {
        return names.stream()
                .map(name -> of(type, name))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(toSet());
    }

    /**
     * enum 상수 목록을 중복없는 enum 이름 집합으로 변환.
     *
     * @param enums enum 상수 목록
     * @param <T>   enum 타입
     * @return enum 이름 집합
     */
    @NotNull
    public static <T extends Enum<T>> Set<String> names(@NotNull Collection<T> enums) {
        return enums.stream()
                .map(Enum::name)
                .collect(toSet());
    }

}
