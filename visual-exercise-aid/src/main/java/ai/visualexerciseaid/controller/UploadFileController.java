package ai.visualexerciseaid.controller;

import ai.visualexerciseaid.common.HttpResult;
import ai.visualexerciseaid.utility.UploadFileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping(value = "/file")
public class UploadFileController {

    @PostMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE)
    public HttpResult upload(@RequestPart(name = "file") MultipartFile file, HttpServletRequest httpServletRequest) throws IOException {

        /*log.info("POST /file/upload");
        log.info(file.toString());

        String fileName = file.getOriginalFilename();
        String uniqueFileName = UploadFileUtils.getUniqueFileName(fileName);
        String localPath = ResourceUtils.getURL("classpath:").getPath() + "static";
        file.transferTo(new File(localPath + File.separator + uniqueFileName));
        String remotePath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" +
                httpServletRequest.getServerPort() + "/static/" + uniqueFileName;*/

        log.info("POST /file/upload");
        log.info(file.toString());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("/yyyy/MM/dd/");
        String format = simpleDateFormat.format(new Date());
        String realPath = httpServletRequest.getServletContext().getRealPath("/upload") + format;

        log.info(realPath);

        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileName = file.getOriginalFilename();
        String uniqueFileName = UploadFileUtils.getUniqueFileName(fileName);
        file.transferTo(new File(folder, uniqueFileName));
        String remotePath = httpServletRequest.getScheme() + "://" + httpServletRequest.getServerName() + ":" + httpServletRequest.getServerPort() + "/static/upload" + format + uniqueFileName;

        log.info(remotePath);

        return HttpResult.ok("上传成功", remotePath);
    }

}