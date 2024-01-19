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
@ApiModel(value = "SuggestVo对象", description = "训练建议网页展示")
public class SuggestVo implements Serializable {

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

    @ApiModelProperty(value = "训练时长")
    private String duration;

    @ApiModelProperty(value = "训练强度")
    private String strength;

    @ApiModelProperty(value = "建议时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime suggestTime;

}