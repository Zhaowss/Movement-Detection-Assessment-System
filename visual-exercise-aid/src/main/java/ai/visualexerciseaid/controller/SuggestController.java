package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.common.PageResult;
import ai.visualexerciseaid.common.SearchKeyTypeEnum;
import ai.visualexerciseaid.entity.Suggest;
import ai.visualexerciseaid.service.SuggestService;
import ai.visualexerciseaid.vo.SuggestVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/suggest")
public class SuggestController extends BaseController {
    @Autowired
    SuggestService suggestService;

    @ApiOperation(value = "插入信息")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody Suggest suggest) {

        log.info("POST /suggest/save");
        log.info(suggest.toString());

        return HttpResult.ok("保存成功", suggestService.save(suggest));
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/remove/{id}")
    public HttpResult removeById(@PathVariable(name = "id") Long id) {

        log.info("DELETE /suggest/remove/" + id);
        log.info("id = " + id);

        return HttpResult.ok("删除成功", suggestService.removeById(id));
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public HttpResult updateById(@RequestBody Suggest suggest) {

        log.info("PUT /suggest/update");
        log.info(suggest.toString());

        return HttpResult.ok("更新成功", suggestService.updateById(suggest));
    }

    @ApiOperation(value = "查询一条信息")
    @GetMapping(value = "/get/{id}")
    public HttpResult getById(@PathVariable(name = "id") Long id) {

        log.info("GET /suggest/get/" + id);
        log.info("id = " + id);

        return HttpResult.ok("查询成功", suggestService.getById(id));
    }

    @ApiOperation(value = "分页条件查询所有信息")
    @GetMapping(value = "/list")
    public PageResult list(@RequestParam(name = "page", required = false) Long page, @RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "key", required = false) String key, @RequestParam(name = "value", required = false) String value) {

        log.info("GET /suggest/list");
        log.info("page = " + page + ", limit = " + limit + ", key = " + key + ", value = " + value);

        if (page != null) {
            QueryWrapper<SuggestVo> queryWrapper = new QueryWrapper<>();
            if (key != null) {
                SearchKeyTypeEnum searchKeyTypeEnum = SearchKeyTypeEnum.getSearchKeyEnum(key);
                switch (searchKeyTypeEnum) {
                    case ID:
                        queryWrapper.eq("sug.id", value);
                        break;
                    case USERID:
                        queryWrapper.eq("sug.user_id", value);
                        break;
                    default:
                        break;
                }
            }
            IPage<SuggestVo> iPage = new Page<>(page, limit);
            return new PageResult(200, "查询成功", suggestService.listSuggest(iPage, queryWrapper).getTotal(), suggestService.listSuggest(iPage, queryWrapper).getRecords());
        } else {
            return new PageResult(200, "查询成功", suggestService.count(), suggestService.list());
        }
    }

}