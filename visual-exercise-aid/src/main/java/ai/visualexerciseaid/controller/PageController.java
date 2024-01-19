package ai.visualexerciseaid.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@CrossOrigin
@RestController
public class PageController {

    @GetMapping(value = "/")
    public ModelAndView toLogin() {

        log.info("GET /");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/common/login");
        return modelAndView;
    }

    @GetMapping(value = "/toIndex")
    public ModelAndView toIndex() {

        log.info("GET /toIndex");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/common/index");
        return modelAndView;
    }

    @GetMapping(value = "/toError")
    public ModelAndView toError() {

        log.info("GET /toError");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/common/error");
        return modelAndView;
    }

    @GetMapping("/toApi")
    public ModelAndView toApi() {

        log.info("GET /toApi");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/common/api");
        return modelAndView;
    }

    @GetMapping(value = "/toHome")
    public ModelAndView toHome() {

        log.info("GET /toHome");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/common/home");
        return modelAndView;
    }

    @GetMapping(value = "/toIconList")
    public ModelAndView toIconList() {

        log.info("GET /toIconList");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/menu/icon-list");
        return modelAndView;
    }

    @GetMapping("/toMenuManage")
    public ModelAndView toMenuManage() {

        log.info("GET /toMenuManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/menu/menu-manage");
        return modelAndView;
    }

    @GetMapping("/toMenuAdd")
    public ModelAndView toMenuAdd() {

        log.info("GET /toMenuAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/menu/menu-add");
        return modelAndView;
    }

    @GetMapping("/toMenuEdit")
    public ModelAndView toMenuEdit() {

        log.info("GET /toMenuEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/menu/menu-edit");
        return modelAndView;
    }

    @GetMapping("/toDepartmentManage")
    public ModelAndView toDepartmentManage() {

        log.info("GET /toDepartmentManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/department/department-manage");
        return modelAndView;
    }

    @GetMapping("/toDepartmentAdd")
    public ModelAndView toDepartmentAdd() {

        log.info("GET /toDepartmentAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/department/department-add");
        return modelAndView;
    }

    @GetMapping("/toDepartmentEdit")
    public ModelAndView toDepartmentEdit() {

        log.info("GET /toDepartmentEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/department/department-edit");
        return modelAndView;
    }

    @GetMapping("/toUserManage")
    public ModelAndView toUserManage() {

        log.info("GET /toUserManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/user/user-manage");
        return modelAndView;
    }

    @GetMapping("/toUserAdd")
    public ModelAndView toUserAdd() {

        log.info("GET /toUserAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/user/user-add");
        return modelAndView;
    }

    @GetMapping("/toUserEdit")
    public ModelAndView toUserEdit() {

        log.info("GET /toUserEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/user/user-edit");
        return modelAndView;
    }

    @GetMapping("/toSubjectAdd")
    public ModelAndView toSubjectAdd() {

        log.info("GET /toSubjectAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/subject/subject-add");
        return modelAndView;
    }

    @GetMapping("/toSubjectEdit")
    public ModelAndView toSubjectEdit() {

        log.info("GET /toSubjectEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/subject/subject-edit");
        return modelAndView;
    }

    @GetMapping("/toSubjectManage")
    public ModelAndView toSubjectManage() {

        log.info("GET /toSubjectManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/subject/subject-manage");
        return modelAndView;
    }

    @GetMapping("/toSuggestAdd")
    public ModelAndView toSuggestAdd() {

        log.info("GET /toSuggestAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/suggest/suggest-add");
        return modelAndView;
    }

    @GetMapping("/toSuggestEdit")
    public ModelAndView toSuggestEdit() {

        log.info("GET /toSuggestEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/suggest/suggest-edit");
        return modelAndView;
    }

    @GetMapping("/toSuggestManage")
    public ModelAndView toSuggestManage() {

        log.info("GET /toSuggestManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/suggest/suggest-manage");
        return modelAndView;
    }

    @GetMapping("/toSuggestList")
    public ModelAndView toSuggestList() {

        log.info("GET /toSuggestList");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/suggest/suggest-list");
        return modelAndView;
    }

    @GetMapping("/toNoteAdd")
    public ModelAndView toNoteAdd() {

        log.info("GET /toNoteAdd");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/note/note-add");
        return modelAndView;
    }

    @GetMapping("/toNoteEdit")
    public ModelAndView toNoteEdit() {

        log.info("GET /toNoteEdit");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/note/note-edit");
        return modelAndView;
    }

    @GetMapping("/toNoteManage")
    public ModelAndView toNoteManage() {

        log.info("GET /toNoteManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/note/note-manage");
        return modelAndView;
    }

    @GetMapping("/toRecordManage")
    public ModelAndView toRecordManage() {

        log.info("GET /toRecordManage");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/record/record-manage");
        return modelAndView;
    }

    @GetMapping("/toRecordList")
    public ModelAndView toRecordList() {

        log.info("GET /toRecordList");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/record/record-list");
        return modelAndView;
    }

    @GetMapping("/toRecordDetail")
    public ModelAndView toRecordDetail() {

        log.info("GET /toRecordDetail");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/record/record-detail");
        return modelAndView;
    }

    @GetMapping("/toAnalyze")
    public ModelAndView toAnalyze() {

        log.info("GET /toAnalyze");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/analyze/analyze");
        return modelAndView;
    }

    @GetMapping("/toExercise")
    public ModelAndView toExercise() {

        log.info("GET /toExercise");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/exercise/exercise");
        return modelAndView;
    }

    @GetMapping("/toDeepSquat")
    public ModelAndView toDeepSquat() {

        log.info("GET /toDeepSquat");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/exercise/deep-squat");
        return modelAndView;
    }

    @GetMapping("/toPullUp")
    public ModelAndView toPullUp() {

        log.info("GET /toPullUp");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/exercise/pull-up");
        return modelAndView;
    }

    @GetMapping("/toDynamometer")
    public ModelAndView toDynamometer() {

        log.info("GET /toDynamometer");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/exercise/dynamometer");
        return modelAndView;
    }

    @GetMapping("/toRopeClimb")
    public ModelAndView toRopeClimb() {

        log.info("GET /toRopeClimb");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("page/exercise/rope-climb");
        return modelAndView;
    }

}