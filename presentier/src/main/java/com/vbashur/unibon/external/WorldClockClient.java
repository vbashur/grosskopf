package com.vbashur.unibon.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "clock", url = "http://worldclockapi.com/api/json/utc/")
public interface WorldClockClient {

    @RequestMapping(method = RequestMethod.GET, value = "/now")
    String getTime();
}
