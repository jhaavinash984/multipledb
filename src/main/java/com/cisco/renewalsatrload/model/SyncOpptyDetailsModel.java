package com.cisco.renewalsatrload.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class SyncOpptyDetailsModel {
	
	
	private String sourceOpportunityLineId;
	
	private String sourceOpportunityId;

	private String mix;
	
	private String productFamily;
	
	private String serviceLevel;

	private String businessEntity;
	
	private String priorTerm;
	
	private String priorSo;
	
	private String priorContract;
	
	private Calendar updateDateTime;

	private String currencyisocode;

	private String productFamilyC;
	
	private String dfProductFamilyName;
	
	private String pricebookentryid;
	
	private String processedFlag;
	
	private String errorFlag;
	
	private String dfServiceLevelName;
	
	private String successFlag;
	
	private String opportunityLineId;

	private String attritionReasonCode;

	private String processingComplete;
	
	private Date salesforceUpdateTime;

	private Date oracleUpdateTime;

	private String productFamilyDescription;
	
	private String serviceLevelDescription;
	
	private String serviceCategory;
	
	private String qualificationStatus;
	
	private String asArchName;
	
	private String asServiceOfferName;

	private String asTechName;

	private String syncType;
	
	private String remainingAtr;

	private String allocServiceGroup;
	
	private String priorTcv;
	
	private String priorAtr;

	private String fieldAtr;
	
	private String quotedTcv;
	
	private String expiredAtr;
	
	private String ldosAtr;
	
	private String bookedTcv;

	private String bookedAcv;
	
	private String acvFlag;
	
	private String prodServDesc;
	
	private String sfdcServiceCategory;
	
	private String reProcess;
	
	private String sfdcOppLineId;
	
	private String stagename;
	
	private String sfdcStage;
	
	private String opptyBookedFlag;
	
	private String opportunityId;
	
	private String headerSuccess;
	
	private Date headerUpdateTime;
	
	private String dataSourceNameC;

	private String dfOppId;
	
	private String forecastedAttrition;
	
	private String attritionReasonUi;
	
	private String closedFlag;
	
	private String dfPidMappingLogicCode;

	private String pidMappingId;

	private Date earliestAssetExpDate;

	private String autoRenewalCategory;
	
	private String subscriptionStatus;
	
	private String jobId;
	
	private String headerJobId;
	
	private List<SyncOpptyQuarterlyLinesModel> lineByQuarter;

}
