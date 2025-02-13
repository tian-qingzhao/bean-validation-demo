package com.tqz.bean.validation.controller.v1;

import com.tqz.bean.validation.api.ValidatorUtils;
import com.tqz.bean.validation.dto.v1.UserDTO;
import com.tqz.bean.validation.springboot.v1.AddGroup;
import com.tqz.bean.validation.springboot.v1.EditGroup;
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
@RequestMapping("/v1/user")
public class UserControllerV1 {

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

    /**
     * 使用 Bean Validation Api 校验参数.
     *
     * <p>这里使用了 {@link Validated#value()} 属性的groups分组功能，
     * 想要使每个字段上的 Bean Validation 注解生效的话，每个属性上面的 Bean Validation 注解都需要添加该 groups 分组对应的接口.
     * 例如：{@link UserDTO} 每个属性的 Bean Validation 注解都需要添加 groups 属性为 {@link AddGroup} 才可以.
     */
    @PostMapping("add2")
    public String add2(@RequestBody UserDTO dto) {
        ValidatorUtils.validate(dto, AddGroup.class);

        log.info("用户的参数：{}", dto);
        return "添加成功";
    }

    /**
     * Spring Boot 环境中使用 Bean Validation groups功能分组校验参数.
     *
     * <p>这里使用了 {@link Validated#value()} 属性的groups分组功能，
     * 想要使每个字段上的 Bean Validation 注解生效的话，每个属性上面的 Bean Validation 注解都需要添加该 groups 分组对应的接口.
     * 例如：{@link UserDTO} 每个属性的 Bean Validation 注解都需要添加 groups 属性为 {@link EditGroup} 才可以.
     */
    @PostMapping("edit")
    public String edit(@Validated(EditGroup.class) @RequestBody UserDTO dto) {
        log.info("用户的参数：{}", dto);
        return "添加成功";
    }

    /**
     * 测试 Bean Validation groups分组多个的场景.
     *
     * <p>测试证明，{@link Validated#value()} 属性存在多个groups的时候，都会生效，
     * 也就是需要每个groups的规则都满足才允许通过.
     * 在本示例中， {@link UserDTO#getId()} 属性在添加时候一定不能有值，在修改的时候一定不能为空，
     * 所以这里id有值和无值都校验不通过.
     */
    @PostMapping("test-multi-group")
    public String testMultiGroup(@Validated({AddGroup.class, EditGroup.class}) @RequestBody UserDTO dto) {
        log.info("用户的参数：{}", dto);
        return "添加成功";
    }
}
