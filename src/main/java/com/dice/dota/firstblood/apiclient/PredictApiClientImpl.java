package com.dice.dota.firstblood.apiclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class PredictApiClientImpl implements PredictApiClient {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper mapper;
    final private Logger logger = LoggerFactory.getLogger(PredictApiClientImpl.class);

    private @Value("${predictModule.protocol}")
    String protocol;
    private @Value("${predictModule.ip}")
    String ip;
    private @Value("${predictModule.port}")
    String port;
    private @Value("${predictModule.api.query}")
    String queryApi;


    @Override
    public String getMatchResult(Map<String, String> matchPreData) {
        try {
            String url = new StringBuilder(protocol).append("://")
                    .append(ip).append(":")
                    .append(port)
                    .append(queryApi).toString();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            String requestJsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matchPreData);
            HttpEntity entity = new HttpEntity(requestJsonStr, headers);
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            if (response.getStatusCode().is2xxSuccessful()==false){
                logger.error("Http error, the code is "+response.getStatusCode().toString());
                return null;
            }
            return response.getBody();
        } catch (Exception e) {
            if (e instanceof JsonProcessingException) {
                logger.error("Jackson transfer map to json string error.");
            }else {
                logger.error("something error occurred.");
            }
        }
        return null;
    }
}
