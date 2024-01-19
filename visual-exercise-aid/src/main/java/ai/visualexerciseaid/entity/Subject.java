package ai.visualexerciseaid.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Subject对象", description = "训练科目")
public class Subject extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "标准动作文本提示")
    private String prompt;

    @ApiModelProperty(value = "标准动作视频路径")
    private String video;

}