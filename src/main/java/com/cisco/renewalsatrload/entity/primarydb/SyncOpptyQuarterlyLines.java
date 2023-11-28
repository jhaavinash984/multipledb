package com.cisco.renewalsatrload.entity.primarydb;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="SYNC_OPPORTUNITY_QUARTERLY_LINES_ATRV2")
public class SyncOpptyQuarterlyLines implements Serializable {
	
	private static final long serialVersionUID = 1234567L;
	
	@Id
	@Column(name="ROWID")
	@JsonIgnore
	String rowid;
	//@Id
	//@Column(name="SOURCE_OPPORTUNITY_LINE_ID")
	@ManyToOne
	@JoinColumn(name="SOURCE_OPPORTUNITY_LINE_ID", nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonBackReference
	private SyncOpptyDetails syncOpptyDetails;
	@Column(name="FISCAL_QUARTER")
	private String fiscalQuarter;
	@Column(name="CONTRACT_END_DATE")
	private Date contractEndDate;
	@Column(name="OPPORTUNITY_AMT")
	private String opportunityAmt;
	@Column(name="AVAILABLE_TO_RENEW_AMT")
	private String availableToRenewAmt;
	@Column(name="PRIOR_TERM")
	private String priorTerm;
	@Column(name="UPDATE_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTimestamp;
	@Column(name="PROCESSED_FLAG")
	private String processedFlag;
	@Column(name="SALESFORCE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date salesforceUpdateTime;
	@Column(name="ORACLE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date oracleUpdateTime;
	@Column(name="ERROR_FLAG")
	private String errorFlag;
	@Column(name="SUCCESS_FLAG")
	private String successFlag;
	
	@Override
    public String toString() {
        return "SyncOpptyQuarterlyLines [rowid=" + rowid + ", SyncOpptyDetailsEntityId="
                + syncOpptyDetails.getSourceOpportunityLineId() + "]";
    }

}
