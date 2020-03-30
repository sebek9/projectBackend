package com.kodilla.bankApp.client;

import com.kodilla.bankApp.domain.NbpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



@Component
public class NbpClient {

    @Value("${nbp.api.endoint.prod}")
    private String nbpApiEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    public List<NbpDto> getExchangeRates() {

        NbpDto[] nbpResponse = restTemplate.getForObject(
                nbpApiEndpoint,
                NbpDto[].class);
    if (nbpResponse !=null){
        return Arrays.asList(nbpResponse);
    }
    return new ArrayList<>();
    }
}
