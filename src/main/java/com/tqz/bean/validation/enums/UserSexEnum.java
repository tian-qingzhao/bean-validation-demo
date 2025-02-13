package com.tqz.bean.validation.enums;

import com.tqz.bean.validation.springboot.v2.ArrayValuable;
import lombok.Getter;

import java.util.Arrays;

/**
 * 用户性别枚举类.
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/2/13 13:41
 */
@Getter
public enum UserSexEnum implements ArrayValuable<Integer> {

    MAN(1, "男"),

    WOMAN(2, "女");

    private final Integer value;

    private final String desc;

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(UserSexEnum::getValue).toArray(Integer[]::new);

    UserSexEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    @Override
    public Integer[] array() {
        return ARRAYS;
    }
}
