package kr.iolo.utils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class DateUtil {
    /**
     * Instant 에서 ZonedDateTime 으로 변환한다. (UTC)
     *
     * @param source 변환 할 Instant
     * @return 변환 된 ZonedDateTime (변환 실패 시 null)
     */
    public static ZonedDateTime toZonedDateTime(Instant source) {
        return toZonedDateTime(source, null);
    }

    /**
     * Instant 에서 ZonedDateTime 으로 변환한다. (UTC)
     *
     * @param source      변환 할 Instant
     * @param defaultTime 에러 발생 시 반환할 기본 값
     * @return 변환된 ZonedDateTime
     */
    public static ZonedDateTime toZonedDateTime(Instant source, ZonedDateTime defaultTime) {
        try {
            if (source == null) return defaultTime;
            return source.atZone(ZoneOffset.UTC);
        } catch (Exception e) {
            return defaultTime;
        }
    }

    /**
     * 문자열을 ZonedDateTime 형태로 변경한다.
     * 기본적으로 `ISO-8601` 형식이 아닐경우 Exception 이 발생할것입니다.
     *
     * @param source 변환 할 Instant
     * @return 변환된 ZonedDateTime (변환 실패 시 null)
     */
    public static ZonedDateTime parse(String source) {
        return parse(source, null);
    }

    /**
     * 문자열을 ZonedDateTime 형태로 변경한다.
     * 기본적으로 `ISO-8601` 형식이 아닐경우 Exception 이 발생할것입니다.
     *
     * @param source      변환 할 Instant
     * @param defaultTime 에러 발생 시 반환할 기본 값
     * @return 변환된 ZonedDateTime
     */
    public static ZonedDateTime parse(String source, ZonedDateTime defaultTime) {
        try {
            if (source == null) return defaultTime;
            return ZonedDateTime.parse(source);
        } catch (Exception e) {
            return defaultTime;
        }
    }
}
