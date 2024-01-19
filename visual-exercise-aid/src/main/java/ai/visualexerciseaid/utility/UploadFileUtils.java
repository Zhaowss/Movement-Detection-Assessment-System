package ai.visualexerciseaid.utility;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class UploadFileUtils {

    public static String getUniqueFileName(String fileName) {
        String suffix = "";
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        if (fileName != null) {
            suffix = fileName.substring(fileName.lastIndexOf("."));
        }
        return DateUtil.today() + "-" + uuid + suffix;
    }

}