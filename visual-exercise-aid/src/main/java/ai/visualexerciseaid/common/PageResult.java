package ai.visualexerciseaid.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult {

    private int code;

    private String msg;

    private long count;

    private List<?> data;

}