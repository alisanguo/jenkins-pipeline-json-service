package com.alisanguo.controller;

import com.alisanguo.service.PipelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value="/pipeline")
public class PipelineController {

    @Autowired
    private PipelineService pipelineService;

    @PostMapping("/toJson")
    public String toJson(String jenkinsfile) {
        return pipelineService.toJson(jenkinsfile);
    }
}
