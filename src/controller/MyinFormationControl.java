package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.servlet.ModelAndView;
import pojo.Information;
import service.CRUD;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MyinFormationControl {
    CRUD crud=new CRUD();


//    /xxxxx?key=value&key=value
    //加信息
    @RequestMapping("/add")
    public ModelAndView add(String name,String pwd,String phone){
        ModelAndView mav=new ModelAndView();
        //插入成共放回true
        if (crud.add(name,pwd,phone)){
            mav.setViewName("forward:/regodic");
        }else {
            mav.setViewName("lose");
        }
        return mav;
    }
    //    /xxxxx?u[0].acc=value&u[1].acc=value

//    {key：valeu ，key:[{key:v,k:v},{},{}]}
//    [{},{},{},{}]
    @RequestMapping("/add1")
//    @ResponseBody
    public ModelAndView add1( Information u){
        ModelAndView mav=new ModelAndView();
//
        mav.addObject("uList",null);
        mav.setViewName("table");
//        转发
//        /jsp/   ssss    .jsp
        //插入成共放回true
//        if (crud.add(name,pwd,phone)){
//            mav.setViewName("forward:/regodic");
//        }else {
//            mav.setViewName("lose");
//        }
//        return mav;
//        req.
        return mav;
    }


    //遍历
    @RequestMapping("/regodic")
    public ModelAndView regodic(){
        ModelAndView mav=new ModelAndView();
        LinkedList ulist=crud.erodic();
        //list中有信息返回table页面  否则发哦失败页面
        if (ulist!=null){

            mav.addObject("ulist",ulist);
            mav.setViewName("table");
            System.out.println(ulist);
        }else {
            mav.setViewName("lose");
        }
        return mav;
    }

    //删除
    @RequestMapping("/delete")
    public ModelAndView delete(String name,String pwd,String phone){
        ModelAndView mav=new ModelAndView();
        //删除成共放回true
        if (crud.delete(name,pwd,phone)){
            mav.setViewName("forward:/regodic");
        }else {
            mav.setViewName("lose");
        }
        return mav;
    }
}
