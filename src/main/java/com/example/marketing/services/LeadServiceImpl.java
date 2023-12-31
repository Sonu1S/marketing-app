package com.example.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.marketing.Repository.LeadRepository;
import com.example.marketing.entites.Lead;


@Service
public class LeadServiceImpl implements LeadService { //Tjis is just an ordinary java class
    
	@Autowired
	private LeadRepository leadRepo; //calling Repository
	
	
	@Override
	public void saveLead(Lead lead) {
        leadRepo.save(lead);
		
	}


	@Override
	public List<Lead> listLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
		
	}


	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
	}


	@Override
	public Lead getOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();  //get method convert Optional class to lead Object and return lead
		return lead;
	}

}

