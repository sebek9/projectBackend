package com.kodilla.bankApp.client;

import com.kodilla.bankApp.domain.NbpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NbpClient {

    @Value("${nbp.api.endoint.prod}")
    private String nbpApiEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public NbpDto getExchange() {

        NbpDto response = restTemplate.getForObject(
                nbpApiEndpoint,
                NbpDto.class);
        return response;
    }
}
