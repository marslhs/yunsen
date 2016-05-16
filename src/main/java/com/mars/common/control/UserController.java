package com.mars.common.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/user"})
public class UserController
{
  @RequestMapping(value={"/info/{pid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public ModelAndView toIndex(@PathVariable String pid, HttpServletRequest request, HttpServletResponse response)
  {
    Map<String, Object> map = new HashMap<String, Object>();
    
    map.put("name", pid);
    map.put("pro", "pro");
    
    ModelAndView mav = new ModelAndView("list", map);
    
    return mav;
  }
  
  @RequestMapping({"/hello"})
  public String hello()
  {
    return "hello";
  }
  
  @ResponseBody
  @RequestMapping({"/list"})
  public List<String> list(ModelMap modelMap)
  {
    List<String> list = new ArrayList<String>();
    list.add("test");
    list.add("test1");
    list.add("test2");
    list.add("tes3t");
    return list;
  }
}