package ai.visualexerciseaid.service;

import ai.visualexerciseaid.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<Menu> query(@Param("userId") Long userId);

}