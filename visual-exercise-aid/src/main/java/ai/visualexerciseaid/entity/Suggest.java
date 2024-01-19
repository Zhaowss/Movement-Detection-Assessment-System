package ai.visualexerciseaid.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "Suggest对象", description = "训练建议")
public class Suggest extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户编号（外键）")
    private Long userId;

    @ApiModelProperty(value = "科目编号（外键）")
    private Long subjectId;

    @ApiModelProperty(value = "训练时长")
    private String duration;

    @ApiModelProperty(value = "训练强度")
    private String strength;

    @ApiModelProperty(value = "建议时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime suggestTime;

}