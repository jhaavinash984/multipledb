package com.cisco.renewalsatrload.entity.primarydb;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Data
@Entity
@Table(name="SYNC_OPPTY_HEADER_ATRV2")
public class SyncOpptyHeader implements Serializable {
	
	private static final long serialVersionUID = 1234567L;
	@Id
	@Column(name="SOURCE_OPPORTUNITY_ID")
	private String sourceOpportunityId;
	@Column(name="OPPORTUNITY_NAME")
	private String opportunityName;
	@Column(name="OPPORTUNITY_TYPE")
	private String opportunityType;
	@Column(name="SAVM_GROUP_ID")
	private String savmGroupId;
	@Column(name="SFDC_ACCOUNT_ID")
	private String sfdcAccountId;
	@Column(name="CLOSE_DATE")
	private Date closeDate;
	@Column(name="BUSINESS_ENTITY")
	private String businessEntity;
	@Column(name="FISCAL_QUARTER")
	private String fiscalQuarter;
	@Column(name="CONTRACT_START_DATE")
	private String contractStartDate;
	@Column(name="CONTRACT_END_DATE")
	private Date contractEndDate;
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;
	@Column(name="PARTNER_1")
	private String partner1;
	@Column(name="PARTNER_2")
	private String partner2;
	@Column(name="PARTNER_3")
	private String partner3;
	@Column(name="CURRENCY_CODE")
	private String currencyCode;
	@Column(name="STATUS")
	private String status;
	@Column(name="OWNER_ID")
	private String ownerId;
	@Column(name="STAGENAME")
	private String stagename;
	@Column(name="POSITION__C")
	private String positionC;
	@Column(name="OPPORTUNITY_STATUS__C")
	private String opportunityStatusC;
	@Column(name="FORECAST_STATUS__C")
	private String forecastStatusC;
	@Column(name="PARTNER_REQUIRED__C")
	private String partnerRequiredC;
	@Column(name="INSTALLED_BASE__C")
	private String installedBaseC;
	@Column(name="SERVICE_SOURCE__C")
	private String serviceSourceC;
	@Column(name="DATA_SOURCE_NAME__C")
	private String dataSourceNameC;
	@Column(name="OPPORTUNITY_ID")
	private String opportunityId;
	@Column(name="PROCESSED")
	private String processed;
	@Column(name="SUCCESS_FLAG")
	private String successFlag;
	@Column(name="ERROR_FLAG")
	private String errorFlag;
	@Column(name="PRIOR_SO_CLOB")
	@Lob
	private String priorSoClob;
	@Column(name="PRIOR_CONTRACT_CLOB")
	@Lob
	private String priorContractClob;
	@Column(name="PROCESSING_COMPLETE")
	private String processingComplete;
	@Column(name="SALESFORCE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date salesforceUpdateTime;
	@Column(name="ORACLE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date oracleUpdateTime;
	@Column(name="OPPORTUNITY_CUST_SEGMENT")
	private String opportunityCustSegment;
	@Column(name="OPPORTUNITY_BOOKED_C")
	private String opportunityBookedC;
	@Column(name="OPPORTUNITY_CATEGORY")
	private String opportunityCategory;
	@Column(name="OPPTY_BOOKED_FLAG")
	private String opptyBookedFlag;
	@Column(name="SYNC_TYPE")
	private String syncType;
	@Column(name="HQ_ID")
	private String hqId;
	@Column(name="PARTY_ID")
	private String partyId;
	@Column(name="IS_SFC")
	private String isSfc;
	@Column(name="OPPTY_EXPIRED_FLAG")
	private String opptyExpiredFlag;
	@Column(name="ACQUISITION_SOURCE")
	private String acquisitionSource;
	@Column(name="TERRITORY_ID")
	private String territoryId;
	@Column(name="CR_PARTY_ID")
	private String crPartyId;
	@Column(name="SFDC_STAGE")
	private String sfdcStage;
	@Column(name="LAST_IB_REFRESH_FLAG")
	private String lastIbRefreshFlag;
	@Column(name="SFDC_OPP_ID")
	private String sfdcOppId;
	@Column(name="SALESORDER_OR_WEBORDER_ID")
	@Lob
	private String salesorderOrWeborderId;
	@Column(name="OPPORTUNITY_MANAGER_C")
	private String opportunityManagerC;
	@Column(name="RENEWAL_DUE_DATE")
	private String renewalDueDate;
	@Column(name="DESCRIPTION")
	@Lob
	private String description;
	@Column(name="DIRECT_RENEW_OWNERSHIPFLAG__C")
	private String directRenewOwnershipflagC;
	@Column(name="EARLIEST_ASSET_EXP_DATE")
	private Date earliestAssetExpDate;
	@Column(name="CLOSED_FLAG")
	private String closedFlag;
	@Column(name="TOP_DISTR_PARTNER1")
	private String topDistrPartner1;
	@Column(name="TOP_DISTR_PARTNER2")
	private String topDistrPartner2;
	@Column(name="TOP_DISTR_PARTNER3")
	private String topDistrPartner3;
	@Column(name="ALC_TO_EA_MIGRATION_STATUS")
	private String alcToEaMigrationStatus;
	@Column(name="SUM_ATR")
	private Integer sumAtr;
	@Column(name="AUTO_RENEWAL_CATEGORY")
	private String autoRenewalCategory;
	@Column(name="SUBSCRIPTION_STATUS")
	private String subscriptionStatus;
	@Column(name="SALES_LEVEL")
	private String salesLevel;
	@Column(name="JOB_ID")
	private String jobId;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,mappedBy="syncOpptyHeader")
	@JsonProperty("OpportunityLineItems")
	private List<SyncOpptyDetails> opportunityLineItems;
	@JsonManagedReference
	@OneToMany(fetch = FetchType.EAGER,mappedBy="syncOpptyHeader")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SyncOpptyPartners> partnerHeader;
	

}
