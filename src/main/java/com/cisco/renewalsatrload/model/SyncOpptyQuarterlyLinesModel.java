package com.cisco.renewalsatrload.model;

import java.util.Date;


import lombok.Data;

@Data
public class SyncOpptyQuarterlyLinesModel {
	
	
	private String sourceOpportunityLineId;
	
	private String fiscalQuarter;

	private Date contractEndDate;

	private String opportunityAmt;
	
	private String availableToRenewAmt;
	
	private String priorTerm;

	private Date updateTimestamp;
	
	private String processedFlag;
	
	private Date salesforceUpdateTime;

	private Date oracleUpdateTime;

	private String errorFlag;

	private String successFlag;

}
