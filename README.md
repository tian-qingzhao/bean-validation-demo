1.如果 `@Validated` 注解使用了groups分组的功能，那么校验的参数对象上每个 Bean Validation 注解都需要指定该
groups 对应的接口类名.

2. `@Validated` 注解属性存在多个groups的时候，都会生效，也就是需要每个groups的规则都满足才允许通过.
