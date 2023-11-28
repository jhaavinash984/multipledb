package com.cisco.renewalsatrload.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class SyncOpptyPartnersModel {
	
	
	private String sourceOpportunityId;
	
	private String partnerBecId;
	
	private String partnerPriorAtr;
	
	private String processed;
	
	private String successFlag;

	private String errorFlag;
	
	private Date salesforceUpdateTime;
	
	private Date oracleUpdateTime;
	
	private String transactionId;
	
	private String dfTransId;
	
	private Date updateDateTime;
	
	private String opportunityId;

	private String partnerBookedAtr;

}
