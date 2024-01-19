package ai.visualexerciseaid.service.impl;

import ai.visualexerciseaid.entity.Note;
import ai.visualexerciseaid.mapper.NoteMapper;
import ai.visualexerciseaid.service.NoteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoteServiceImpl extends ServiceImpl<NoteMapper, Note> implements NoteService {
}