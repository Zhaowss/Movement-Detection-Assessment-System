package ai.visualexerciseaid.mapper;

import ai.visualexerciseaid.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MenuMapper extends BaseMapper<Menu> {

    @Select("SELECT menu.* " +
            "FROM menu, user_menu " +
            "WHERE menu.id = user_menu.menu_id AND user_menu.role = (SELECT role FROM user WHERE user.id = #{userId})")
    List<Menu> query(@Param("userId") Long userId);

}