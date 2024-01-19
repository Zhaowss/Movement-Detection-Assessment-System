package ai.visualexerciseaid.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "UserMenu对象", description = "用户菜单")
public class UserMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单编号（外键）")
    private Long menuId;

    @ApiModelProperty(value = "角色（管理员=0，客户=1）")
    private Integer role;

}