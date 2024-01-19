package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Record;
import ai.visualexerciseaid.mapper.RecordMapper;
import ai.visualexerciseaid.service.RecordService;
import ai.visualexerciseaid.vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Resource
    RecordMapper recordMapper;

    @Override
    public IPage<RecordVo> listRecord(IPage<RecordVo> page, Wrapper<RecordVo> wrapper) {
        return recordMapper.listRecord(page, wrapper);
    }

}