package ai.visualexerciseaid.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Menu对象", description = "菜单")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "父级编号")
    private Long pid;

    @ApiModelProperty(value = "名称")
    private String title;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "链接")
    private String href;

    @ApiModelProperty(value = "链接打开方式")
    private String target;

    @ApiModelProperty(value = "角色（管理员=0，客户=1）")
    private Integer role;

}