package ua.com.alevel.veiw.controller;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import ua.com.alevel.facade.CourseFacade;
import ua.com.alevel.persistence.type.CourseType;
import ua.com.alevel.veiw.dto.request.CourseRequestDto;
import ua.com.alevel.veiw.dto.response.CourseResponseDto;
import ua.com.alevel.veiw.dto.response.PageDataResponse;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/courses")
public class CourseController extends AbstractController {

    private final CourseFacade courseFacade;

    public CourseController(CourseFacade courseFacade) {
        this.courseFacade = courseFacade;
    }

    @GetMapping(path = {"/student/{id}"})
    public String getAllByStudentId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("courses", courseFacade.findAllByStudentId(id));
        model.addAttribute("studentId", id);
        return "/pages/course/course_all";
    }

    @GetMapping("/new")
    public String redirectToNewHallPage(Model model) {
        model.addAttribute("courseRequestDto", new CourseRequestDto());
        model.addAttribute("coursesTypes", CourseType.values());
        return "pages/course/course_new";
    }

    @PostMapping("/new")
    public String CreateNewHall(@ModelAttribute CourseRequestDto courseRequestDto, Model model) {
        if (courseRequestDto.getId() > 0) {
            courseFacade.update(courseRequestDto);
        } else {
            courseFacade.create(courseRequestDto);
        }
        return "redirect:/courses";
    }

    @GetMapping("/update/{id}")
    public String redirectToNewCoursePage(@PathVariable long id, Model model) {
        CourseRequestDto courseRequestDto = new CourseRequestDto();
        courseRequestDto.setId(id);
        model.addAttribute("courseRequestDto", courseRequestDto);
        model.addAttribute("coursesTypes", CourseType.values());
        return "pages/course/course_new";
    }

    @GetMapping()
    public String getAllStudentSortedBy(Model model, WebRequest webRequest) {
        HeaderName[] columnNames = getColumnNames();
        PageDataResponse<CourseResponseDto> response = courseFacade.findAll(webRequest);
        response.initPaginationState(response.getCurrentPage());
        List<HeaderData> headerDataList = getHeaderDataList(columnNames, response);
        model.addAttribute("headerDataList", headerDataList);
        model.addAttribute("pageData", response);
        model.addAttribute("cardHeader", "All Courses");
        return "/pages/course/course_all";
    }

    @GetMapping("/all")
    public String getAll(WebRequest request, Model model) {
        return "redirect:/courses";
    }

    @PostMapping("/all")
    public ModelAndView findAll(WebRequest request, ModelMap model) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            parameterMap.forEach(model::addAttribute);
        }
        return new ModelAndView("redirect:/courses", model);
    }

    @GetMapping("/delete/{id}")
    public String getDetail(@PathVariable("id") Long id, Model model) {
        courseFacade.delete(id);
        return "redirect:/courses";
    }

    @GetMapping("/detail/{id}")
    public String getDelete(@PathVariable("id") Long id, Model model) {
        CourseResponseDto response = courseFacade.findById(id);
        model.addAttribute("course", response);
        return "/pages/course/course_detail";
    }

    private HeaderName[] getColumnNames() {
        return new HeaderName[]{
                new HeaderName("#", null, null),
                new HeaderName("id", "id", "id"),
                new HeaderName("name", "Name", "name"),
                new HeaderName("description", "description", "description"),
                new HeaderName("course type", "course_type", "courseType"),
                new HeaderName("delete", null, null),
                new HeaderName("update", null, null)
        };
    }
}