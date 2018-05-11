package com.graphql.example.graphservice;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;
import com.graphql.example.graphservice.model.PdConsultant;

import graphql.ExecutionResult;
import graphql.GraphQL;

@Component("consultantFunction")
public class ConsultantFunction implements Function<String, ResponseEntity<PdConsultant>>{

	
	@Autowired
	private GraphQlHandler graphQL;

	@Override
	public ResponseEntity<PdConsultant> apply(String body) {
		GraphQL graph = graphQL.query();
	    ExecutionResult result = graph.execute(body);
	    //return ResponseEntity.ok(result.getData().toString());
	    return new ResponseEntity<>(result.getData(), HttpStatus.OK);
	}
	
	
	/**
	   * @param result
	   * @return
	   */
	  private String enrichResult(ExecutionResult result) {
	    return new GsonBuilder()
	      .setPrettyPrinting()
	      .serializeNulls()
	      .create()
	      .toJson(result.toSpecification());
	  }

}
