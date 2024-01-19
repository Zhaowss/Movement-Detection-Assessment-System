package ai.visualexerciseaid.service;

import ai.visualexerciseaid.entity.Suggest;
import ai.visualexerciseaid.vo.SuggestVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

public interface SuggestService extends IService<Suggest> {

    IPage<SuggestVo> listSuggest(IPage<SuggestVo> page, @Param(Constants.WRAPPER) Wrapper<SuggestVo> wrapper);

}