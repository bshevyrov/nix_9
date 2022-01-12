package ua.com.alevel.veiw.controller;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.facade.StudentFacade;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;
import ua.com.alevel.veiw.dto.response.StudentResponseDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/students")
public class StudentController extends AbstractController {
    private final StudentFacade studentFacade;

    private final CourseFacade courseFacade;

    public StudentController(StudentFacade studentFacade, CourseFacade courseFacade) {
        this.studentFacade = studentFacade;
        this.courseFacade = courseFacade;
    }

    @GetMapping()
    public String fil(WebRequest request, ModelMap model) {

        HeaderName[] columnNames = getColumnNames();
        PageDataResponse<StudentResponseDto> response = studentFacade.findAll(request);
        response.initPaginationState(response.getCurrentPage());
        List<AbstractController.HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("createUrl", "/students/all");
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All Students");
        model.addAttribute("allowCreate", true);
        model.addAttribute("createNewItemUrl", "/students/new");
        return "/pages/student/student_all";
    }

    @GetMapping("/all")
    public String getAll(WebRequest request, Model model) {
        return "redirect:/students";
    }

    @PostMapping("/all")
    public ModelAndView findAll(WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        return new ModelAndView("redirect:/students", model);
    }

    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        model.addAttribute("studentRequestDto", new StudentRequestDto());
        model.addAttribute("courses", courseFacade.findAll().stream().distinct().collect(Collectors.toList()));
        return "pages/student/student_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute StudentRequestDto studentRequestDto, Model model) {
        studentFacade.create(studentRequestDto);
        return "redirect:/students";
    }

    @GetMapping(path = {"/course/{id}"})
    public String getAllByStudentId(@PathVariable("id") Long id, Model model) {
//TODO validate
        model.addAttribute("students", studentFacade.findAllByCourseId(id));
        model.addAttribute("courseId", id);
        return "/pages/student/student_all";

    }

    @GetMapping(path = {"/course"})
    public String getAllByStudentId(@RequestParam("type") String type, Model model) {
//TODO validate
        model.addAttribute("students", studentFacade.findAllByCourseType(CourseType.valueOf(type)));
        return "/pages/student/student_all";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        studentFacade.delete(id);
        return "redirect:/students";
    }

    @GetMapping("/detail/{id}")
    public String getDetail(@PathVariable("id") Long id, Model model) {

        StudentResponseDto studentDto = studentFacade.findById(id);
        model.addAttribute("student", studentDto);


        return "/pages/student/student_detail";
    }

    private HeaderName[] getColumnNamesDetail() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Id", "id", "id"),
                new HeaderName("First Name", "firstName", "first_name"),
                new HeaderName("Last Name", "lastName", "last_name"),
                new HeaderName("E-mail", "email", "email"),
                new HeaderName("Phone", "phone", "phone"),
                new HeaderName("Create Date", "createDate", "create_date"),
                new HeaderName("Courses", "createDate", "create_date"),
                new HeaderName("Delete", null, null),
                new HeaderName("update", null, null)
        };
    }


    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Id", "id", "id"),
                new HeaderName("First Name", "firstName", "first_name"),
                new HeaderName("Last Name", "lastName", "last_name"),
                new HeaderName("E-mail", "email", "email"),
                new HeaderName("Phone", "phone", "phone"),
                new HeaderName("Create Date", "createDate", "create_date"),
                new HeaderName("Delete", null, null),
                new HeaderName("update", null, null)
        };
    }


}
