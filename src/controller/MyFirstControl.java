package controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.TestUser;

@Controller
public class MyFirstControl {
    TestUser testUser=new TestUser();

    @RequestMapping("/work")//核心处理器
    public ModelAndView work(String acc, String pwd) throws Exception {
        ModelAndView mav=new ModelAndView();

        //获取验证方法的返回结果
        boolean testResult=testUser.testUser(acc,pwd);

        if (testResult){
            System.out.println(acc+"  "+pwd);
            mav.addObject("mark","登陆成功");
            mav.setViewName("success");
        }
        else {
            mav.addObject("mark","登陆失败");
            mav.setViewName("lose");
        }
        return mav;
    }

    @RequestMapping("/redirect")
    public ModelAndView redirect(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("table");
        return mav;
    }




}
