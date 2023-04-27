package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.AjaxResult;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.service.IMeetingRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index控制器 111
 */
@Controller

public class IndexController {
  private String prefix = "info/";

  @Autowired
  private IMeetingRegistrationService meetingRegistrationService;
  /**
   * 主页页面
   * @return API response html
   */
  @GetMapping
  public String index() {
    return "indexTo";
  }


  @GetMapping(value = "/test")
  public   String  test() {
    return prefix + "info";

  }
  @GetMapping(value = "/api/sign")
  @ResponseBody
  public AjaxResult sign(String phoneNumber) {
    AjaxResult ajaxResult  = AjaxResult.error();
    try {
    ajaxResult = meetingRegistrationService.sign(phoneNumber);

    }catch (Exception e){
      e.printStackTrace();
    }finally {
      return  ajaxResult;
    }

  }

}
