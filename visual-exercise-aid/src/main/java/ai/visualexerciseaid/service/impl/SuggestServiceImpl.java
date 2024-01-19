package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Suggest;
import ai.visualexerciseaid.mapper.SuggestMapper;
import ai.visualexerciseaid.service.SuggestService;
import ai.visualexerciseaid.vo.SuggestVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class SuggestServiceImpl extends ServiceImpl<SuggestMapper, Suggest> implements SuggestService {

    @Resource
    SuggestMapper suggestMapper;

    @Override
    public IPage<SuggestVo> listSuggest(IPage<SuggestVo> page, Wrapper<SuggestVo> wrapper) {
        return suggestMapper.listSuggest(page, wrapper);
    }

}