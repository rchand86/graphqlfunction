package com.graphql.example.graphservice.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.example.graphservice.model.PdConsultant;
import com.graphql.example.graphservice.repo.ConsultantRepository;

@Component
public class ConsultantMutation implements GraphQLMutationResolver {

	@Autowired
	private ConsultantRepository consultantRepository;
	
	
	/**
	 * @param message
	 * @return
	 */
	public PdConsultant newConsultant(String name){
		return null;
	}
}
