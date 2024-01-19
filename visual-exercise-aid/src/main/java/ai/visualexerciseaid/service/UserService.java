package ai.visualexerciseaid.service;

import ai.visualexerciseaid.entity.User;
import ai.visualexerciseaid.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<User> {

    IPage<UserVo> listUser(IPage<UserVo> page, @Param(Constants.WRAPPER) Wrapper<UserVo> wrapper);

}