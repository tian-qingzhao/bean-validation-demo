package com.tqz.bean.validation.springboot.v1;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static cn.hutool.core.util.ReflectUtil.invoke;

/**
 * 自定义枚举校验注解实现
 *
 * @author 秋辞未寒
 * @date 2024-12-09
 */
public class EnumPatternValidator implements ConstraintValidator<EnumPattern, Integer> {

    private EnumPattern annotation;
    ;

    @Override
    public void initialize(EnumPattern annotation) {
        ConstraintValidator.super.initialize(annotation);
        this.annotation = annotation;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null) {
            String fieldName = annotation.fieldName();
            for (Object e : annotation.type().getEnumConstants()) {
                if (value.equals(invokeGetter(e, fieldName))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <E> E invokeGetter(Object obj, String propertyName) {
        Object object = obj;
        for (String name : StringUtils.split(propertyName, ".")) {
            String getterMethodName = "get" + StringUtils.capitalize(name);
            object = invoke(object, getterMethodName);
        }
        return (E) object;
    }

}
