package ai.visualexerciseaid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "MenuVo对象", description = "菜单网页展示")
public class MenuVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号（主键）")
    private Long id;

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

    @ApiModelProperty(value = "子菜单列表")
    private List<MenuVo> child;

}