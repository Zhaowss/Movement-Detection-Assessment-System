package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Menu;
import ai.visualexerciseaid.mapper.MenuMapper;
import ai.visualexerciseaid.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Resource
    MenuMapper menuMapper;

    @Override
    public List<Menu> query(@Param("userId") Long userId) {
        return menuMapper.query(userId);
    }

}