package com.graphql.example.graphservice.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.example.graphservice.model.PdConsultant;
import com.graphql.example.graphservice.repo.ConsultantRepository;

@Component
public class ConsultantQuery implements GraphQLQueryResolver{
	
	@Autowired
	private ConsultantRepository consultantRepository;
	
	public PdConsultant getConsultantDetails(String loginName){
		return consultantRepository.getConsultantDetails(loginName);
	}

}
