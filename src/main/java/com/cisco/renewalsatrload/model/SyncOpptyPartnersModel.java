package com.cisco.renewalsatrload.model;

import java.util.Date;


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
