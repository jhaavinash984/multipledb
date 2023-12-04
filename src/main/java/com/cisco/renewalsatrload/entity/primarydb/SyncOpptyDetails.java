package com.cisco.renewalsatrload.entity.primarydb;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="SYNC_OPPTY_DETAILS_ATRV2")
public class SyncOpptyDetails implements Serializable {
	
	private static final long serialVersionUID = 1234567L;
	
	@Id
	@Column(name="SOURCE_OPPORTUNITY_LINE_ID")
	private String sourceOpportunityLineId;
	@ManyToOne
	@JoinColumn(name="SOURCE_OPPORTUNITY_ID", nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonBackReference
	private SyncOpptyHeader syncOpptyHeader;
	@Column(name="MIX")
	private String mix;
	@Column(name="PRODUCT_FAMILY")
	private String productFamily;
	@Column(name="SERVICE_LEVEL")
	private String serviceLevel;
	@Column(name="BUSINESS_ENTITY")
	private String businessEntity;
	@Column(name="PRIOR_TERM")
	private String priorTerm;
	@Column(name="PRIOR_SO")
	@Lob
	private String priorSo;
	@Column(name="PRIOR_CONTRACT")
	@Lob
	private String priorContract;
	@Column(name="UPDATE_DATE_TIME")
	@Temporal(TemporalType.DATE)
	private Calendar updateDateTime;
	@Column(name="CURRENCYISOCODE")
	private String currencyisocode;
	@Column(name="PRODUCT_FAMILY__C")
	private String productFamilyC;
	@Column(name="DF_PRODUCT_FAMILY_NAME")
	private String DF_PRODUCT_FAMILY_NAME;
	@Column(name="PRICEBOOKENTRYID")
	private String pricebookentryid;
	@Column(name="PROCESSED_FLAG")
	private String processedFlag;
	@Column(name="ERROR_FLAG")
	private String errorFlag;
	@Column(name="DF_SERVICE_LEVEL_NAME")
	private String dfServiceLevelName;
	@Column(name="SUCCESS_FLAG")
	private String successFlag;
	@Column(name="OPPORTUNITY_LINE_ID")
	private String opportunityLineId;
	@Column(name="ATTRITION_REASON_CODE")
	private String attritionReasonCode;
	@Column(name="PROCESSING_COMPLETE")
	private String processingComplete;
	@Column(name="SALESFORCE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date salesforceUpdateTime;
	@Column(name="ORACLE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date oracleUpdateTime;
	@Column(name="PRODUCT_FAMILY_DESCRIPTION")
	private String productFamilyDescription;
	@Column(name="SERVICE_LEVEL_DESCRIPTION")
	private String serviceLevelDescription;
	@Column(name="SERVICE_CATEGORY")
	private String serviceCategory;
	@Column(name="QUALIFICATION_STATUS")
	private String qualificationStatus;
	@Column(name="AS_ARCH_NAME")
	private String asArchName;
	@Column(name="AS_SERVICE_OFFER_NAME")
	private String asServiceOfferName;
	@Column(name="AS_TECH_NAME")
	private String asTechName;
	@Column(name="SYNC_TYPE")
	private String syncType;
	@Column(name="REMAINING_ATR")
	private String remainingAtr;
	@Column(name="ALLOC_SERVICE_GROUP")
	private String allocServiceGroup;
	@Column(name="PRIOR_TCV")
	private String priorTcv;
	@Column(name="PRIOR_ATR")
	private String priorAtr;
	@Column(name="FIELD_ATR")
	private String fieldAtr;
	@Column(name="QUOTED_TCV")
	private String quotedTcv;
	@Column(name="EXPIRED_ATR")
	private String expiredAtr;
	@Column(name="LDOS_ATR")
	private String ldosAtr;
	@Column(name="BOOKED_TCV")
	private String bookedTcv;
	@Column(name="BOOKED_ACV")
	private String bookedAcv;
	@Column(name="ACV_FLAG")
	private String acvFlag;
	@Column(name="PROD_SERV_DESC")
	private String prodServDesc;
	@Column(name="SFDC_SERVICE_CATEGORY")
	private String sfdcServiceCategory;
	@Column(name="RE_PROCESS")
	private String reProcess;
	@Column(name="SFDC_OPP_LINE_ID")
	private String sfdcOppLineId;
	@Column(name="STAGENAME")
	private String stagename;
	@Column(name="SFDC_STAGE")
	private String sfdcStage;
	@Column(name="OPPTY_BOOKED_FLAG")
	private String opptyBookedFlag;
	@Column(name="OPPORTUNITY_ID")
	private String opportunityId;
	@Column(name="HEADER_SUCCESS")
	private String headerSuccess;
	@Column(name="HEADER_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date headerUpdateTime;
	@Column(name="DATA_SOURCE_NAME__C")
	private String dataSourceNameC;
	@Column(name="DF_OPP_ID")
	private String dfOppId;
	@Column(name="FORECASTED_ATTRITION")
	private String forecastedAttrition;
	@Column(name="ATTRITION_REASON_UI")
	private String attritionReasonUi;
	@Column(name="CLOSED_FLAG")
	private String closedFlag;
	@Column(name="DF_PID_MAPPING_LOGIC_CODE")
	private String dfPidMappingLogicCode;
	@Column(name="PID_MAPPING_ID")
	private String pidMappingId;
	@Column(name="EARLIEST_ASSET_EXP_DATE")
	private Date earliestAssetExpDate;
	@Column(name="AUTO_RENEWAL_CATEGORY")
	private String autoRenewalCategory;
	@Column(name="SUBSCRIPTION_STATUS")
	private String subscriptionStatus;
	@Column(name="JOB_ID")
	private String jobId;
	@Column(name="HEADER_JOB_ID")
	private String headerJobId;
	@OneToMany(fetch = FetchType.EAGER,mappedBy="syncOpptyDetails")
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonManagedReference
	@JsonProperty("LineByQuarter")
	private List<SyncOpptyQuarterlyLines> lineByQuarter;
	
	 @Override
    public String toString() {
        return "SyncOpptyDetails [sourceOpportunityLineId=" + sourceOpportunityLineId + ", SyncOpptyHeaderEntityId="
                + syncOpptyHeader.getSourceOpportunityId() + "]";
    }

}
