package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyControllerException {


    @ExceptionHandler(Exception.class)
    public ModelAndView Exception1(){
        ModelAndView mav=new ModelAndView();
        mav.addObject("nullPointer","换个网络吧");
        mav.setViewName("failure");


        return mav;
    }
}
