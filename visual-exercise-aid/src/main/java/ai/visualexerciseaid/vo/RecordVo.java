package ai.visualexerciseaid.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.time.LocalDateTime;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RecordVo对象", description = "训练记录网页展示")
public class RecordVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号（主键）")
    private Long id;

    @ApiModelProperty(value = "用户编号（外键）")
    private Long userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "科目编号（外键）")
    private Long subjectId;

    @ApiModelProperty(value = "科目名称")
    private String subjectName;

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