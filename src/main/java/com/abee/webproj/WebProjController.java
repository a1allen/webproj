package com.abee.webproj;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebProjController {

    @GetMapping("/stats")
    public String home() {
        Memory memory = SystemStats.getMemory();
        return "stats";
    }
}