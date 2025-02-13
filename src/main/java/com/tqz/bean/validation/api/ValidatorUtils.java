package com.tqz.bean.validation.api;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Validator 校验框架工具
 *
 * @author Lion Li
 */
public class ValidatorUtils {

    /**
     * 对给定对象进行参数校验，并根据指定的校验组进行校验
     *
     * @param object 要进行校验的对象
     * @param groups 校验组
     * @throws ConstraintViolationException 如果校验不通过，则抛出参数校验异常
     */
    public static <T> void validate(T object, Class<?>... groups) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> validate = validator.validate(object, groups);
        if (!validate.isEmpty()) {
            List<ConstraintViolation<T>> list = validate.stream().collect(Collectors.toList());
            String messageTemplate = list.get(0).getMessageTemplate();
            throw new ConstraintViolationException(messageTemplate, validate);
        }
    }

}
