package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Department;
import ai.visualexerciseaid.mapper.DepartmentMapper;
import ai.visualexerciseaid.service.DepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}