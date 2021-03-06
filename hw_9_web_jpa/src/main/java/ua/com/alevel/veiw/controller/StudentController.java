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
import ua.com.alevel.persistence.entity.Course;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.StudentRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
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
        List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
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
    public String CreateNewHall(@ModelAttribute StudentRequestDto studentRequestDto,
                                @RequestParam List<Long> checkedCourses,
                                Model model) {
        if (studentRequestDto.getId() > 0) {
            studentFacade.update(studentRequestDto);
            List<CourseResponseDto> courses = courseFacade.findAll();
            for (CourseResponseDto cours : courses) {
                long studentId= studentRequestDto.getId();
                long courseId = cours.getId();
                studentFacade.deleteCourseStudent(courseId,studentId);
            }
        } else {
            studentFacade.create(studentRequestDto);
        }
        for (Long l : checkedCourses) {
            long studentId=studentFacade.findByEmail(studentRequestDto.getEmail()).getId();
            long courseId = l;
            studentFacade.createCourseStudent(courseId,studentId);
        }

        return "redirect:/students";
    }

    @GetMapping("/update/{id}")
    public String CreateNewHall(@PathVariable long id, Model model) {
        StudentRequestDto studentRequestDto = new StudentRequestDto();
        studentRequestDto.setId(id);
        model.addAttribute("studentRequestDto", studentRequestDto);
        model.addAttribute("courses", courseFacade.findAll().stream().distinct().collect(Collectors.toList()));
        return "pages/student/student_new";
    }

    @GetMapping(path = {"/course/{id}"})
    public String getAllByStudentId(@PathVariable("id") Long id, Model model, WebRequest request) {
        HeaderName[] columnNames = getColumnNames();
                PageDataResponse<StudentResponseDto> response = studentFacade.findAllByCourseId(id, request);
        response.initPaginationState(response.getCurrentPage());
        List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All students of Course " + courseFacade.findById(id).getName());
        return "/pages/student/student_all";
    }

    @PostMapping("/course/{id}")
    public ModelAndView findAllS(@PathVariable("id") Long id, WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap.size());
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        System.out.println(model.size());
        return new ModelAndView("redirect:/students/course/"+id, model);
    }

    @GetMapping(path = {"/course"})
    public String getAllByStudentId(@RequestParam("type") String type, Model model) {
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
        List<CourseResponseDto> courseResponseDtoList = courseFacade.findAllByStudentId(id);
        model.addAttribute("student", studentDto);
        model.addAttribute("courses", courseResponseDtoList);
        return "/pages/student/student_detail";
    }

    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("Id", "id", "id"),
                new HeaderName("First Name", "first_name", "firstName"),
                new HeaderName("Last Name", "last_name", "lastName"),
                new HeaderName("E-mail", "email", "email"),
                new HeaderName("Phone", "phone", "phone"),
                new HeaderName("Create Date", "create_date", "createDate"),
                new HeaderName("Delete", null, null),
                new HeaderName("update", null, null)
        };
    }
}

