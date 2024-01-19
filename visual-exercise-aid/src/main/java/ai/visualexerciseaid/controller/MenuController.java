package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.common.PageResult;
import ai.visualexerciseaid.common.SearchKeyTypeEnum;
import ai.visualexerciseaid.entity.Menu;
import ai.visualexerciseaid.entity.User;
import ai.visualexerciseaid.entity.UserMenu;
import ai.visualexerciseaid.service.MenuService;
import ai.visualexerciseaid.service.UserMenuService;
import ai.visualexerciseaid.service.UserService;
import ai.visualexerciseaid.utility.TreeUtils;
import ai.visualexerciseaid.vo.MenuVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    @Autowired
    UserMenuService userMenuService;

    @ApiOperation(value = "查询用户菜单")
    @GetMapping("/query/{id}")
    public Map<String, Object> query(@PathVariable(name = "id") Long id) {

        log.info("GET /menu/query");

        User user = userService.getById(id);
        Map<String, Object> map = new HashMap<>(16);
        Map<String, Object> home = new HashMap<>(16);
        Map<String, Object> logo = new HashMap<>(16);
        List<Menu> menuList = menuService.query(user.getId());
        List<MenuVo> menuInfo = new ArrayList<>();
        for (Menu menu : menuList) {
            MenuVo menuVo = new MenuVo();
            menuVo.setId(menu.getId());
            menuVo.setPid(menu.getPid());
            menuVo.setHref(menu.getHref());
            menuVo.setTitle(menu.getTitle());
            menuVo.setIcon(menu.getIcon());
            menuVo.setTarget(menu.getTarget());
            menuInfo.add(menuVo);
        }
        map.put("menuInfo", TreeUtils.toTree(menuInfo, 0L));
        home.put("title", "系统首页");
        home.put("href", "toHome");
        map.put("homeInfo", home);
        logo.put("title", "视觉训练辅助");
        logo.put("image", "static/layuimini/images/logo.png");
        logo.put("href", "");
        map.put("logoInfo", logo);

        return map;
    }

    @ApiOperation(value = "插入信息")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody Menu menu) {

        log.info("POST /menu/save");
        log.info(menu.toString());

        menuService.save(menu);
        UserMenu userMenu = new UserMenu();
        userMenu.setMenuId(menu.getId());
        userMenu.setRole(menu.getRole());
        userMenuService.save(userMenu);

        return HttpResult.ok("保存成功");
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/remove/{id}")
    public HttpResult removeById(@PathVariable(name = "id") Long id) {

        log.info("DELETE /menu/remove/" + id);
        log.info("id = " + id);

        QueryWrapper<UserMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("menu_id", id);
        userMenuService.remove(queryWrapper);
        menuService.removeById(id);

        return HttpResult.ok("删除成功");
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public HttpResult updateById(@RequestBody Menu menu) {

        log.info("PUT /menu/update");
        log.info(menu.toString());

        menuService.updateById(menu);

        return HttpResult.ok("更新成功");
    }

    @ApiOperation(value = "分页条件查询所有信息")
    @GetMapping(value = "/list")
    public PageResult list(@RequestParam(name = "page", required = false) Long page, @RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "key", required = false) String key, @RequestParam(name = "value", required = false) String value) {

        log.info("GET /menu/list");
        log.info("page = " + page + ", limit = " + limit + ", key = " + key + ", value = " + value);

        if (page != null) {
            QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
            if (key != null) {
                SearchKeyTypeEnum searchKeyTypeEnum = SearchKeyTypeEnum.getSearchKeyEnum(key);
                switch (searchKeyTypeEnum) {
                    case ID:
                        queryWrapper.eq("id", value);
                        break;
                    default:
                        break;
                }
            }
            IPage<Menu> iPage = new Page<>(page, limit);
            return new PageResult(200, "查询成功", menuService.page(iPage, queryWrapper).getTotal(), menuService.page(iPage, queryWrapper).getRecords());
        } else {
            return new PageResult(200, "查询成功", menuService.count(), menuService.list());
        }
    }

}