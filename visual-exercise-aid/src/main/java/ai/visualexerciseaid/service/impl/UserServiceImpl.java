package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.User;
import ai.visualexerciseaid.mapper.UserMapper;
import ai.visualexerciseaid.service.UserService;
import ai.visualexerciseaid.vo.UserVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public IPage<UserVo> listUser(IPage<UserVo> page, Wrapper<UserVo> wrapper) {
        return userMapper.listUser(page, wrapper);
    }

}