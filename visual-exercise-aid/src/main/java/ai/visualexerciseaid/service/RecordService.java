package ai.visualexerciseaid.service;

import ai.visualexerciseaid.entity.Record;
import ai.visualexerciseaid.vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface RecordService extends IService<Record> {
    
    IPage<RecordVo> listRecord(IPage<RecordVo> page, @Param(Constants.WRAPPER) Wrapper<RecordVo> wrapper);

}