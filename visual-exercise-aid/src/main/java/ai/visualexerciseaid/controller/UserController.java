package ai.visualexerciseaid.controller;


import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.common.PageResult;
import ai.visualexerciseaid.common.SearchKeyTypeEnum;
import ai.visualexerciseaid.entity.User;
import ai.visualexerciseaid.service.UserService;
import ai.visualexerciseaid.vo.UserVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "登录系统")
    @PostMapping(value = "/login")
    public HttpResult login(@RequestBody JSONObject jsonObject) {

        log.info("POST /user/login");
        log.info(jsonObject.toJSONString());

        String name = jsonObject.getString("name");
        String password = jsonObject.getString("password");
        Integer role = Integer.parseInt(jsonObject.getString("role"));

        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("password", password);
        params.put("role", role);
        User user = userService.getOne(new QueryWrapper<User>().allEq(params));
        if (user != null) {
            return HttpResult.ok("登录成功", user);
        } else {
            return HttpResult.error("登录失败，请检查账号/密码/角色");
        }
    }

    @ApiOperation(value = "插入信息")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody User user) {

        log.info("POST /user/save");
        log.info(user.toString());

        return HttpResult.ok("保存成功", userService.save(user));
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/remove/{id}")
    public HttpResult removeById(@PathVariable(name = "id") Long id) {

        log.info("DELETE /user/remove/" + id);
        log.info("id = " + id);

        return HttpResult.ok("删除成功", userService.removeById(id));
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public HttpResult updateById(@RequestBody User user) {

        log.info("PUT /user/update");
        log.info(user.toString());

        return HttpResult.ok("更新成功", userService.updateById(user));
    }

    @ApiOperation(value = "分页条件查询所有信息")
    @GetMapping(value = "/list")
    public PageResult list(@RequestParam(name = "page", required = false) Long page, @RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "key", required = false) String key, @RequestParam(name = "value", required = false) String value) {

        log.info("GET /user/list");
        log.info("page = " + page + ", limit = " + limit + ", key = " + key + ", value = " + value);

        if (page != null) {
            QueryWrapper<UserVo> queryWrapper = new QueryWrapper<>();
            if (key != null) {
                SearchKeyTypeEnum searchKeyTypeEnum = SearchKeyTypeEnum.getSearchKeyEnum(key);
                switch (searchKeyTypeEnum) {
                    case ID:
                        queryWrapper.eq("u.id", value);
                        break;
                    default:
                        break;
                }
            }
            IPage<UserVo> iPage = new Page<>(page, limit);
            return new PageResult(200, "查询成功", userService.listUser(iPage, queryWrapper).getTotal(), userService.listUser(iPage, queryWrapper).getRecords());
        } else {
            return new PageResult(200, "查询成功", userService.count(), userService.list());
        }
    }

    @ApiOperation(value = "统计信息")
    @GetMapping(value = "/count")
    public HttpResult count() {

        log.info("GET /user/count");

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("role", 1);

        return HttpResult.ok("统计成功", userService.count(queryWrapper));
    }

}