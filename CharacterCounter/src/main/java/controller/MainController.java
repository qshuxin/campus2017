package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by qinshuxin on 2017/7/4.
 */
public class MainController {


    @RequestMapping(value = "/")//拦截一切0.0
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public @ResponseBody
    String  helloworld() {
        return "hello";//只会输出一个hello
    }

    @RequestMapping(value="/index1",method=RequestMethod.GET)
    public ModelAndView index2(){
        ModelAndView modelAndView = new ModelAndView("hello");//跳到hello.jsp上去咯
        modelAndView.addObject("name", "xxx");
        return modelAndView;
    }
}
