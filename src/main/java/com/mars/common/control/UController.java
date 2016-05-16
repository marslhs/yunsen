package com.mars.common.control;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UController
{
  @ResponseBody
  @RequestMapping({"/list"})
  public List<String> list(HttpServletRequest request, HttpServletResponse response)
  {
    List<String> list = new ArrayList<String>();
    list.add("test");
    list.add("test1");
    list.add("test2");
    list.add("tes3t");
    list.add(request.toString());
    return list;
  }
}
