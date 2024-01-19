package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.common.PageResult;
import ai.visualexerciseaid.common.SearchKeyTypeEnum;
import ai.visualexerciseaid.entity.Note;
import ai.visualexerciseaid.service.NoteService;
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
@RequestMapping("/note")
public class NoteController extends BaseController {

    @Autowired
    NoteService noteService;

    @ApiOperation(value = "插入信息")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody Note note) {

        log.info("POST /note/save");
        log.info(note.toString());

        return HttpResult.ok("保存成功", noteService.save(note));
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/remove/{id}")
    public HttpResult removeById(@PathVariable(name = "id") Long id) {

        log.info("DELETE /note/remove/" + id);
        log.info("id = " + id);

        return HttpResult.ok("删除成功", noteService.removeById(id));
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public HttpResult updateById(@RequestBody Note note) {

        log.info("PUT /note/update");
        log.info(note.toString());

        return HttpResult.ok("更新成功", noteService.updateById(note));
    }

    @ApiOperation(value = "查询一条信息")
    @GetMapping(value = "/get/{id}")
    public HttpResult getById(@PathVariable(name = "id") Long id) {

        log.info("GET /note/get/" + id);
        log.info("id = " + id);

        return HttpResult.ok("查询成功", noteService.getById(id));
    }

    @ApiOperation(value = "分页条件查询所有信息")
    @GetMapping(value = "/list")
    public PageResult list(@RequestParam(name = "page", required = false) Long page, @RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "key", required = false) String key, @RequestParam(name = "value", required = false) String value) {

        log.info("GET /note/list");
        log.info("page = " + page + ", limit = " + limit + ", key = " + key + ", value = " + value);

        if (page != null) {
            QueryWrapper<Note> queryWrapper = new QueryWrapper<>();
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
            IPage<Note> iPage = new Page<>(page, limit);
            return new PageResult(200, "查询成功", noteService.page(iPage, queryWrapper).getTotal(), noteService.page(iPage, queryWrapper).getRecords());
        } else {
            return new PageResult(200, "查询成功", noteService.count(), noteService.list());
        }
    }

    @ApiOperation(value = "统计信息")
    @GetMapping(value = "/count")
    public HttpResult count() {

        log.info("GET /note/count");

        return HttpResult.ok("统计成功", noteService.count());
    }

}