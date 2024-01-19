package ai.visualexerciseaid.mapper;

import ai.visualexerciseaid.entity.User;
import ai.visualexerciseaid.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.*, d.`name` AS department_name " +
            "FROM (`user` AS u LEFT JOIN department AS d ON u.department_id = d.id) " +
            "${ew.customSqlSegment}")
    IPage<UserVo> listUser(IPage<UserVo> page, @Param(Constants.WRAPPER) Wrapper<UserVo> wrapper);

}