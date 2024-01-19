package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Subject;
import ai.visualexerciseaid.mapper.SubjectMapper;
import ai.visualexerciseaid.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {
}