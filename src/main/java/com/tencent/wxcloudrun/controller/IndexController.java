package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * index控制器 111
 */
@Controller

public class IndexController {
  private String prefix = "info/";

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
    return prefix+"info";
  }
}
