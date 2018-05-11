package com.graphql.example.graphservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.SchemaParser;
import com.coxautodev.graphql.tools.SchemaParserBuilder;
import com.graphql.example.graphservice.resolver.ConsultantMutation;
import com.graphql.example.graphservice.resolver.ConsultantQuery;
import com.graphql.example.graphservice.resolver.Mutation;
import com.graphql.example.graphservice.resolver.Query;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;


@Component
public class GraphQlHandler {

	
	private static final String SCHEMA_LOOKUP = "./graphql/";
	

	private static GraphQLSchema executableSchema;
    private static final String[] SCHEMA_FILES = new String[] {
				"consultant.graphqls",
				"book.graphqls",
				"author.graphqls",
				"category.graphqls"};
	
	
	@Autowired
	private ConsultantQuery queryResolver;
	@Autowired
	private ConsultantMutation mutationResolver;
	
	@Autowired
	private Query query;
	@Autowired
	private Mutation mutation;
	  
	  
  


  @PostConstruct
  private void init() {
    SchemaParserBuilder parser = SchemaParser.newParser();

    parser.files(getSchemaFilePaths());
    parser.resolvers(queryResolver, mutationResolver, query, mutation);
    

    executableSchema = parser.build().makeExecutableSchema();
  }

  

	/**
	 *
	 * @param data
	 * @return
	 */
	public GraphQL query() {
		return GraphQL.newGraphQL(executableSchema).build();
	}
	
	/**
	 *
	 * @param data
	 * @return
	 */
	public ExecutionResult query(RequestData data) {
		ExecutionInput input = ExecutionInput.newExecutionInput()
			.query(data.query)
			.variables(data.variables)
			.build();

		ExecutionResult result = GraphQL.newGraphQL(executableSchema).build().execute(input);

		if (!result.getErrors().isEmpty()) {
			//throwErrors(result);
		}

		return result;
	}
	
	/**
	 *
	 * @return
	 */
	private String[] getSchemaFilePaths() {
		List<String> response = new ArrayList<>();

		String rootPath = SCHEMA_LOOKUP;

		for (String file : SCHEMA_FILES) {
			boolean found = (null != getClass().getClassLoader().getResourceAsStream(rootPath + file));

			if (found) {
				response.add(rootPath + file);
			}
		}

		if (response.isEmpty()) {
			throw new IllegalStateException(String.format("There was no valid schema-file for lookup-path %s found.", rootPath));
		}

		return response.toArray(new String[response.size()]);
	}
	
	public static class RequestData {
		public String query;
		public Map<String, Object> variables;
	}

}
