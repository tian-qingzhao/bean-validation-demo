package com.tqz.bean.validation.springboot.v2;

/**
 * 可生成 T 数组的接口
 *
 * @author HUIHUI
 */
public interface ArrayValuable<T> {

    /**
     * @return 数组
     */
    T[] array();

} 
