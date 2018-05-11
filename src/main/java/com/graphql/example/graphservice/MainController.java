package com.graphql.example.graphservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.graphql.example.graphservice.model.PdConsultant;

import graphql.ExecutionResult;
import graphql.GraphQL;

@RestController
public class MainController {

	@Autowired
	private GraphQlHandler graphQL;

	
	@PostMapping(value = "/graphql/")
	  public ResponseEntity<PdConsultant> index(@RequestBody String body) {
	    GraphQL graph = graphQL.query();
	    ExecutionResult result = graph.execute(body);
	    //return ResponseEntity.ok(result.getData().toString());
	    return new ResponseEntity<>((result.getData()), HttpStatus.OK);
	  }
	
	
	private GraphQlHandler.RequestData parseInput(String input) {
	    GsonBuilder gsonBuilder = new GsonBuilder();

	    Gson gson = gsonBuilder.create();

	    return gson.fromJson(input, GraphQlHandler.RequestData.class);
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
