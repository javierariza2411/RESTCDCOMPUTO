package com.cdcomputo.cdcomputo;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class CdComputoController {

    @RequestMapping("/buscarArticulos")
    public ResponseEntity<String> buscarArticulos() throws UnsupportedEncodingException {

    String pWareHouse = "001";
        String pDate = "2019-10-30";
        final String URI = "http://3.225.134.78:8000/services/inventory/getExistencesByWarehouseAndDate?Pwarehouse=" + pWareHouse + "&Pdate=" + pDate;
        final String TYPE = "Basic ";
        final String encoding = Base64.getEncoder().encodeToString("admin:password".getBytes("UTF-8"));


        RestTemplate plantilla = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", TYPE + encoding);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("Access-Control-Allow-Origin", "*");

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<String> result= plantilla.exchange(URI, HttpMethod.GET, entity, String.class);

            
        
        return result;
                
           
        }
}
    


