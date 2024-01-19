package ai.visualexerciseaid.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserVo对象", description = "用户网页展示")
public class UserVo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号（主键）")
    private Long id;

    @ApiModelProperty(value = "部门编号（外键）")
    private Long departmentId;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;
    
    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "角色（管理员=0，客户=1）")
    private Integer role;

}