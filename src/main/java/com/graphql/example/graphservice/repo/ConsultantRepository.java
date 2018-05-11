package com.graphql.example.graphservice.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.graphql.example.graphservice.model.PdConsultant;


@Component
public class ConsultantRepository {

	public ConsultantRepository(){
		PdConsultant consultant1 = new PdConsultant(10L, "Fabian", "Höhn", "", "Consultant", "",
				"+4915160436754", "#4675", "", "fabian.hoehn@soprasteria.com", 4563,
				"fhoehn", 0, 15);
		PdConsultant consultant2 = new PdConsultant(11L, "Frank", "Musterfrank", "", "Senior Consultant", "",
				"+4917299889977", "#5686", "", "frank.csehan@soprasteria.com", 4589,
				"musterfrank", 0, 10);
		
		pdConsultants = new HashMap<>();
		pdConsultants.put("fhoehn", consultant1);
		pdConsultants.put("musterfrank", consultant2);
	}
	private Map<String, PdConsultant> pdConsultants;
	
	
	/**
	 * @param id
	 * @return
	 */
	public PdConsultant getConsultantDetails(String loginName) {
		return pdConsultants.get(loginName);
	}
	

}
