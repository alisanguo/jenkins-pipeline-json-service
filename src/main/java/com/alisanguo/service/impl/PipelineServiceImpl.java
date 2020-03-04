package com.alisanguo.service.impl;

import com.alisanguo.service.PipelineService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class PipelineServiceImpl implements PipelineService {

    private final String jenkinsUrl = "http://47.101.66.118:8080/";

    private final String jenkinsUser = "admin";

    private final String jenkinsPassword = "admin123";


    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String toJson(String jenkinsfile) {
        HttpHeaders httpHeaders = setRestHeaders();
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("jenkinsfile", jenkinsfile);
        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(jenkinsUrl + "/pipeline-model-converter/toJson", HttpMethod.POST, httpEntity, String.class);
        return responseEntity.getBody();
    }

    private HttpHeaders setRestHeaders() {
        String userMsg = jenkinsUser + ":" + jenkinsPassword;
        String base64UserMsg = Base64.encodeBase64String(userMsg.getBytes());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        httpHeaders.add("Authorization", "Basic " + base64UserMsg);
        return httpHeaders;
    }

    @Override
    public String toJenkinsfile(String json) {
        HttpHeaders httpHeaders = setRestHeaders();
        MultiValueMap map = new LinkedMultiValueMap();
        map.put("json", json);
        HttpEntity httpEntity = new HttpEntity(map, httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(jenkinsUrl + "/pipeline-model-converter/toJenkinsfile", HttpMethod.POST, httpEntity, String.class);
        return responseEntity.getBody();
    }
}
