package dev.taehoyoon.controllerthymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SampleController {
    private static final Logger logger = LoggerFactory.getLogger(SampleController.class);

    @GetMapping("/sample-thyme")
    public ModelAndView sampleThyme() {
        logger.info("in sample thyme");
        ModelAndView modelAndView = new ModelAndView();
        List<SamplePayload> profiles = new ArrayList<>();
        profiles.add(new SamplePayload("taeho", 25, "students"));
        profiles.add(new SamplePayload("ahyoung", 25, "students"));
        profiles.add(new SamplePayload("hyundong", 26, "students"));
        profiles.add(new SamplePayload("sungho", 24, "students"));

        modelAndView.addObject("profiles", profiles);
        modelAndView.setViewName("view-thyme");
        return modelAndView;
    }
}
