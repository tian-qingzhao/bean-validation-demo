package com.tqz.bean.validation.controller.v2;

import com.tqz.bean.validation.dto.v2.UserDTO;
import com.tqz.bean.validation.springboot.v1.AddGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制器.
 *
 * @author <a href="https://github.com/tian-qingzhao">tianqingzhao</a>
 * @since 2025/2/13 13:47
 */
@Slf4j
@RestController
@RequestMapping("/v2/user")
public class UserControllerV2 {

    /**
     * Spring Boot 环境中使用 {@link Validated} 注解校验参数.
     *
     * <p>这里使用了 {@link Validated#value()} 属性的groups分组功能，
     * 想要使每个字段上的 Bean Validation 注解生效的话，每个属性上面的 Bean Validation 注解都需要添加该 groups 分组对应的接口.
     * 例如：{@link UserDTO} 每个属性的 Bean Validation 注解都需要添加 groups 属性为 {@link AddGroup} 才可以.
     */
    @PostMapping("add")
    public String add(@Validated(AddGroup.class) @RequestBody UserDTO dto) {
        log.info("用户的参数：{}", dto);
        return "添加成功";
    }

}
