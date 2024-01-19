package ai.visualexerciseaid.mapper;

import ai.visualexerciseaid.entity.Record;
import ai.visualexerciseaid.vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface RecordMapper extends BaseMapper<Record> {

    @Select("SELECT r.*, u.name AS user_name, s.name AS subject_name " +
            "FROM ((record AS r LEFT JOIN `user` AS u ON r.user_id = u.id) LEFT JOIN subject AS s ON r.subject_id = s.id) " +
            "${ew.customSqlSegment}")
    IPage<RecordVo> listRecord(IPage<RecordVo> page, @Param(Constants.WRAPPER) Wrapper<RecordVo> wrapper);

}