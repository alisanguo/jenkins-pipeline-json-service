package com.alisanguo.service;

public interface PipelineService {

    String toJson(String jenkinsfile);

    String toJenkinsfile(String json);
}
