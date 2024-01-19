package ai.visualexerciseaid.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HttpResult {

    private int code;

    private String msg;

    private Object data;

    public static HttpResult error() {
        return error(500, "未知异常, 请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(500, msg);
    }

    public static HttpResult error(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok() {
        return ok(200, "操作成功");
    }

    public static HttpResult ok(String msg) {
        return ok(200, msg);
    }

    public static HttpResult ok(int code, String msg) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(String msg, Object data) {
        return ok(200, msg, data);
    }

    public static HttpResult ok(Object data) {
        return ok(200, "操作成功", data);
    }

    public static HttpResult ok(int code, String msg, Object data) {
        HttpResult r = new HttpResult();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

}