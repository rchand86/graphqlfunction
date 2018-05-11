package com.graphql.example.graphservice.handler.aws;

import org.springframework.cloud.function.adapter.aws.SpringBootRequestHandler;
import org.springframework.http.ResponseEntity;

import com.graphql.example.graphservice.model.PdConsultant;

public class ConsultantFunctionHandler extends SpringBootRequestHandler<String, ResponseEntity<PdConsultant>>{

}
