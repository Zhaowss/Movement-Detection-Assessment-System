package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.common.PageResult;
import ai.visualexerciseaid.common.SearchKeyTypeEnum;
import ai.visualexerciseaid.entity.Record;
import ai.visualexerciseaid.service.RecordService;
import ai.visualexerciseaid.vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/record")
public class RecordController extends BaseController {

    @Autowired
    RecordService recordService;

    @ApiOperation(value = "插入信息")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody Record record) {

        log.info("POST /record/save");
        log.info(record.toString());

        return HttpResult.ok("保存成功", recordService.save(record));
    }

    @ApiOperation(value = "删除信息")
    @DeleteMapping(value = "/remove/{id}")
    public HttpResult removeById(@PathVariable(name = "id") Long id) {

        log.info("DELETE /record/remove/" + id);
        log.info("id = " + id);

        return HttpResult.ok("删除成功", recordService.removeById(id));
    }

    @ApiOperation(value = "更新信息")
    @PutMapping(value = "/update")
    public HttpResult updateById(@RequestBody Record record) {

        log.info("PUT /record/update");
        log.info(record.toString());

        return HttpResult.ok("更新成功", recordService.updateById(record));
    }

    @ApiOperation(value = "查询一条信息")
    @GetMapping(value = "/get/{id}")
    public HttpResult getById(@PathVariable(name = "id") Long id) {

        log.info("GET /record/get/" + id);
        log.info("id = " + id);

        return HttpResult.ok("查询成功", recordService.getById(id));
    }

    @ApiOperation(value = "分页条件查询所有信息")
    @GetMapping(value = "/list")
    public PageResult list(@RequestParam(name = "page", required = false) Long page, @RequestParam(name = "limit", required = false) Long limit, @RequestParam(name = "key", required = false) String key, @RequestParam(name = "value", required = false) String value) {

        log.info("GET /record/list");
        log.info("page = " + page + ", limit = " + limit + ", key = " + key + ", value = " + value);

        if (page != null) {
            QueryWrapper<RecordVo> queryWrapper = new QueryWrapper<>();
            if (key != null) {
                SearchKeyTypeEnum searchKeyTypeEnum = SearchKeyTypeEnum.getSearchKeyEnum(key);
                switch (searchKeyTypeEnum) {
                    case ID:
                        queryWrapper.eq("r.id", value);
                        break;
                    case USERID:
                        queryWrapper.eq("r.user_id", value);
                        break;
                    default:
                        break;
                }
            }
            IPage<RecordVo> iPage = new Page<>(page, limit);
            return new PageResult(200, "查询成功", recordService.listRecord(iPage, queryWrapper).getTotal(), recordService.listRecord(iPage, queryWrapper).getRecords());
        } else {
            return new PageResult(200, "查询成功", recordService.count(), recordService.list());
        }
    }

    @ApiOperation(value = "统计信息")
    @GetMapping(value = "/stat")
    public HttpResult stat(@RequestParam(name = "userId") String userId, @RequestParam(name = "subjectId") String subjectId, @RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime) {

        log.info("GET /record/stat");
        log.info("userId = " + userId + ", subjectId = " + subjectId + ", startTime = " + startTime + ", endTime = " + endTime);

        QueryWrapper<Record> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", Long.valueOf(userId));
        queryWrapper.eq("subject_id", Long.valueOf(subjectId));
        queryWrapper.between("exercise_time", startTime, endTime);

        return HttpResult.ok("查询成功", recordService.list(queryWrapper));
    }

}