package com.tqz.bean.validation.vo;

import lombok.Data;

/**
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/2/13 15:10
 */
@Data
public class R<T> {

    private int code;

    private String msg;

    private T data;

    public static <T> R<T> ok(T data) {
        R<T> r = new R<T>();
        r.setCode(200);
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail(String msg) {
        R<T> r = new R<T>();
        r.setCode(500);
        r.setMsg(msg);
        return r;
    }
}
