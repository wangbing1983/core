package com.exorcist.msa.core.mvc.controller;

import com.hearglobal.msp.util.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestApiController
public class MonitorController {
  public MonitorController() {
  }

  @GetMapping({"/monitor/alive"})
  public Map<String, Object> alive() {
    return AjaxResult.createSuccessMap();
  }

  @GetMapping({"/config/refresh"})
  public void configRefresh(HttpServletRequest request) throws Exception {
    HttpUtil.post("http://" + request.getHeader("host") + "/refresh", "", 5000L);
  }
}
