package com.cisco.renewalsatrload.entity.secondarydb;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="SYNC_OPPTY_DETAILS1")
public class SyncOpptyDetails1 {
	
	@Column(name="SOURCE_OPPORTUNITY_ID")
	private String sourceOpportunityId;
	
	@Id
	@Column(name="SOURCE_OPPORTUNITY_LINE_ID")
	private String sourceOpportunityLineId;
	
	@Column(name="MIX")
	private String mix;

}
