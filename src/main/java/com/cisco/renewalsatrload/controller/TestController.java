package com.cisco.renewalsatrload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cisco.renewalsatrload.constant.Constant;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;
import com.cisco.renewalsatrload.model.Payload;
import com.cisco.renewalsatrload.model.SyncOpptyHeaderModel;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyDetailsRepository;
import com.cisco.renewalsatrload.service.SyncOpptyService;

@RestController
@EnableTransactionManagement
public class TestController {
	
	@Autowired
	SyncOpptyService syncOpptyService;
	
	@Autowired
	private KafkaTemplate<String, Payload> kafkaTemplate;

	@GetMapping(value="/test")
	public String testing(){
		return "It Is Testing";
	}
	
	@GetMapping(value="/testDeatils")
	public List<SyncOpptyHeaderModel> getDeatails(){
		System.out.println("Controller enter");
		List<SyncOpptyHeaderModel> syncOpptyHeaderModelClct = syncOpptyService.fetchSyncopptydetails();
		for(SyncOpptyHeaderModel syncOpptyHeaderModel :syncOpptyHeaderModelClct ) {
			//kafkaTemplate.send(Constant.topic1,syncOpptyHeaderModel);
			//kafkaTemplate.send(Constant.topic1,1,"syncOpptyDetails",syncOpptyDetails);
		}
		//sendData(syncopptydetailsClct);
		System.out.println("Data "+syncOpptyHeaderModelClct);
		return syncOpptyHeaderModelClct;
	}
	
	@GetMapping(value="/testHeaders")
	public List<Payload> getHeaders(){
		System.out.println("Controller enter");
		List<Payload> syncOpptyHeaderClct = syncOpptyService.fetchSyncOpptyHeader();
		for(Payload payload : syncOpptyHeaderClct) {
		//	kafkaTemplate.send(Constant.topic1,payload);
			//kafkaTemplate.send(Constant.topic1,1,"syncOpptyDetails",syncOpptyDetails);
		}
		System.out.println("Data "+syncOpptyHeaderClct);
		return syncOpptyHeaderClct;
	}
	
	/*void sendData(List<SyncOpptyDetails> syncopptydetailsClct) {
		for(SyncOpptyDetails syncOpptyDetails : syncopptydetailsClct) {
			kafkaTemplate.send(Constant.topic1,syncOpptyDetails);	
		}
	}**/
	
	
	

}
