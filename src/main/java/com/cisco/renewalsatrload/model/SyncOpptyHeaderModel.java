package com.cisco.renewalsatrload.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
public class SyncOpptyHeaderModel {
	
	private String sourceOpportunityId;
	
	private String opportunityName;
	
	private String opportunityType;
	
	private String savmGroupId;

	private String sfdcAccountId;
	
	private Date closeDate;
	
	private String businessEntity;

	private String fiscalQuarter;
	
	private String contractStartDate;
	
	private Date contractEndDate;
	
	private Date updateDateTime;
	
	private String partner1;

	private String partner2;
	
	private String partner3;
	
	private String currencyCode;
	
	private String status;
	
	private String ownerId;

	private String stagename;
	
	private String positionC;
	
	private String opportunityStatusC;
	
	private String forecastStatusC;
	
	private String partnerRequiredC;

	private String installedBaseC;
	
	private String serviceSourceC;
	
	private String dataSourceNameC;
	
	private String opportunityId;
	
	private String processed;

	private String successFlag;

	private String errorFlag;

	private String priorSoClob;
	
	private String priorContractClob;

	private String processingComplete;

	private Date salesforceUpdateTime;
	
	private Date oracleUpdateTime;

	private String opportunityCustSegment;

	private String opportunityBookedC;
	
	private String opportunityCategory;

	private String opptyBookedFlag;
	
	private String syncType;
	
	private String hqId;
	
	private String partyId;

	private String isSfc;

	private String opptyExpiredFlag;
	
	private String acquisitionSource;
	
	private String territoryId;
	
	private String crPartyId;
	
	private String sfdcStage;
	
	private String lastIbRefreshFlag;
	
	private String sfdcOppId;

	private String salesorderOrWeborderId;
	
	private String opportunityManagerC;
	
	private String renewalDueDate;
	
	private String description;
	
	private String directRenewOwnershipflagC;
	
	private Date earliestAssetExpDate;
	
	private String closedFlag;

	private String topDistrPartner1;
	
	private String topDistrPartner2;
	
	private String topDistrPartner3;
	
	private String alcToEaMigrationStatus;
	
	private Integer sumAtr;
	
	private String autoRenewalCategory;
	
	private String subscriptionStatus;
	
	private String salesLevel;
	private String jobId;
	
	private List<SyncOpptyDetailsModel> opportunityLineItems;
	private List<SyncOpptyPartnersModel> partners;

}
