package ai.visualexerciseaid.mapper;

import ai.visualexerciseaid.entity.Suggest;
import ai.visualexerciseaid.vo.SuggestVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface SuggestMapper extends BaseMapper<Suggest> {

    @Select("SELECT sug.*, u.name AS user_name, sub.name AS subject_name " +
            "FROM ((suggest AS sug LEFT JOIN `user` AS u ON sug.user_id = u.id) LEFT JOIN subject AS sub ON sug.subject_id = sub.id) " +
            "${ew.customSqlSegment}")
    IPage<SuggestVo> listSuggest(IPage<SuggestVo> page, @Param(Constants.WRAPPER) Wrapper<SuggestVo> wrapper);

}