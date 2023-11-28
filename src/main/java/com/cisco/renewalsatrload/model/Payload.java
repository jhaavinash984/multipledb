package com.cisco.renewalsatrload.model;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;

import lombok.Data;

@Data
public class Payload {
	
	SyncOpptyHeader opptyHeader;
	public Payload(SyncOpptyHeader item) {
		super();
		this.opptyHeader = item;
	}
	
	public Payload() {
		
	}
	
	
}
