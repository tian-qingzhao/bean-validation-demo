package com.tqz.bean.validation.api;

import com.tqz.bean.validation.dto.v1.UserDTO;
import com.tqz.bean.validation.springboot.v1.EditGroup;

/**
 * Bean Validation API 测试.
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/2/13 15:41
 */
public class ValidationApiTest {

    public static void main(String[] args) {
        UserDTO dto = new UserDTO();
        dto.setId(1);
        dto.setUsername("abc");
        dto.setPassword("123");
        dto.setSex(1);
        ValidatorUtils.validate(dto, EditGroup.class);

        // 测试证明，多个groups的时候需要每个groups的规则都满足才允许通过
        //  在本示例中， {@link UserDTO#getId()} 属性在添加时候一定不能有值，在修改的时候一定不能为空
        // 所以这里id有值和无值都校验不通过
        // ValidatorUtils.validate(dto, AddGroup.class, EditGroup.class);
    }
}
