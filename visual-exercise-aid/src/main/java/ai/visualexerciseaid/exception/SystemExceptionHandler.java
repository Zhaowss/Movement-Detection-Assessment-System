package ai.visualexerciseaid.exception;

import ai.visualexerciseaid.common.HttpResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class SystemExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public HttpResult errorHandler(Exception e) {

        log.error("服务器内部错误: " + e.getMessage());

        return HttpResult.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

}
