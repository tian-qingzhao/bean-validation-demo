package com.tqz.bean.validation.dto.v2;

import com.tqz.bean.validation.enums.UserSexEnum;
import com.tqz.bean.validation.springboot.v1.AddGroup;
import com.tqz.bean.validation.springboot.v1.EditGroup;
import com.tqz.bean.validation.springboot.v1.EnumPattern;
import com.tqz.bean.validation.springboot.v2.InEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 用户添加的参数对象.
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/2/13 13:38
 */
@Data
public class UserDTO {

    @Null(message = "id不能有值", groups = AddGroup.class)
    @NotNull(message = "id不能为空", groups = EditGroup.class)
    private Integer id;

    @NotBlank(message = "姓名不能为空", groups = {AddGroup.class, EditGroup.class})
    private String username;

    @NotBlank(message = "密码不能为空", groups = {AddGroup.class, EditGroup.class})
    private String password;

    @InEnum(value = UserSexEnum.class, groups = {AddGroup.class, EditGroup.class})
    private Integer sex;
}
