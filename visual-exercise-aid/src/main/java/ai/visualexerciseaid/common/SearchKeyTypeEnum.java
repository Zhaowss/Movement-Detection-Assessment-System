package ai.visualexerciseaid.common;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public enum SearchKeyTypeEnum {

    ID, USERNAME, ROLE, NAME, USERID, SUBJECTID;

    public static final Map<String, SearchKeyTypeEnum> map = new HashMap<String, SearchKeyTypeEnum>() {{
        put("id", ID);
        put("username", USERNAME);
        put("role", ROLE);
        put("name", NAME);
        put("user_id", USERID);
        put("subject_id", SUBJECTID);
    }};

    public static SearchKeyTypeEnum getSearchKeyEnum(String key) {
        return map.get(key);
    }

}