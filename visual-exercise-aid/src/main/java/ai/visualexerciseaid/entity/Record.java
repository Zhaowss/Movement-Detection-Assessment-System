package ai.visualexerciseaid.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Record对象", description = "训练记录")
public class Record extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号（外键）")
    private Long userId;

    @ApiModelProperty(value = "科目编号（外键）")
    private Long subjectId;

    @ApiModelProperty(value = "计划训练动作数量")
    private Integer planCount;

    @ApiModelProperty(value = "实际训练动作数量")
    private Integer actualCount;

    @ApiModelProperty(value = "合格训练动作数量")
    private Integer passCount;

    @ApiModelProperty(value = "训练进度（实际训练动作数量/计划训练动作数量）")
    private Double progress;

    @ApiModelProperty(value = "合格率（合格训练动作数量/实际训练动作数量）")
    private Double passRate;

    @ApiModelProperty(value = "标准度（实际训练动作得分求平均）")
    private Double standard;

    @ApiModelProperty(value = "训练成绩（合格率+标准度/2）")
    private Double score;

    @ApiModelProperty(value = "训练结果（优秀=0，良好=1，合格=2，不合格=3）")
    private Integer result;

    @ApiModelProperty(value = "训练时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime exerciseTime;

}