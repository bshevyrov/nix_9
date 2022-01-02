package ua.com.alevel.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ModelAndView defaultErrorHandler(EntityNotFoundException exception) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("showMessage", true);
        modelAndView.addObject("errorMessage", exception.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
