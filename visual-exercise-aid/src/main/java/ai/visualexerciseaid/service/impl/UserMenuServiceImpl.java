package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.UserMenu;
import ai.visualexerciseaid.mapper.UserMenuMapper;
import ai.visualexerciseaid.service.UserMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserMenuServiceImpl extends ServiceImpl<UserMenuMapper, UserMenu> implements UserMenuService {
}