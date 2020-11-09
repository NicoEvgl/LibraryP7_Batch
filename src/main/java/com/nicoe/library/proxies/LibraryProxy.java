package com.nicoe.library.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "LibraryP7_API", url = "localhost:9090")
public interface LibraryProxy {

    @GetMapping("/delaysList")
    List<String> listMail();
}
