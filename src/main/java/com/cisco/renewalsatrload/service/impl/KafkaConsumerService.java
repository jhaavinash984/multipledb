package com.cisco.renewalsatrload.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import com.cisco.renewalsatrload.constant.Constant;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;
import com.cisco.renewalsatrload.entity.secondarydb.SyncOpptyDetails1;
import com.cisco.renewalsatrload.model.Payload;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyDetailsRepository;
import com.cisco.renewalsatrload.repository.secondarydb.SyncOpptyDetailsRepository1;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.*;

@Component
public class KafkaConsumerService {
	
	@Autowired
	SyncOpptyDetailsRepository1 syncOpptyDetailsRepo1;
	
	/*@KafkaListener(
		    groupId = Constant.group1,
		    containerFactory = "syncOpptyDetailsKafkaListenerContainerFactory",
		    topicPartitions = @TopicPartition(
		      topic = Constant.topic1,
		      partitionOffsets = { @PartitionOffset(
		        partition = "1", 
		        initialOffset = "0") }))
	public void listen(SyncOpptyDetails syncOpptyDetails) {
		Gson gson = new Gson();
		String jsonString = gson.toJson(syncOpptyDetails);

		SyncOpptyDetails1 syncOpptyDetails1 = gson.fromJson(jsonString, SyncOpptyDetails1.class);
		System.out.print("Data :: ");
	    System.out.print(syncOpptyDetails);
	    syncOpptyDetailsRepo1.save(syncOpptyDetails1);
	    System.out.print("\n");
	}*/
	@KafkaListener(topics=Constant.topic1, groupId = Constant.group1,containerFactory = "syncOpptyDetailsKafkaListenerContainerFactory")
	public void listen(Payload payload) {
		System.out.println("payload :: "+payload);
		System.out.println("\n");
   }

}
