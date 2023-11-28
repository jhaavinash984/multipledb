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
@Table(name="SYNC_OPPORTUNITY_PARTNERS_ATRV2")
public class SyncOpptyPartners implements Serializable{
	
	private static final long serialVersionUID = 1234567L;
	
	@Id
	@Column(name="ROWID")
	@JsonIgnore
	String rowid;
	@ManyToOne
	@JoinColumn(name="SOURCE_OPPORTUNITY_ID", nullable=false)
	@NotFound(action=NotFoundAction.IGNORE)
	@JsonBackReference
	private SyncOpptyHeader syncOpptyHeader;
	@Column(name="PARTNER_BEC_ID")
	private String partnerBecId;
	@Column(name="PARTNER_PRIOR_ATR")
	private String partnerPriorAtr;
	@Column(name="PROCESSED")
	private String processed;
	@Column(name="SUCCESS_FLAG")
	private String successFlag;
	@Column(name="ERROR_FLAG")
	private String errorFlag;
	@Column(name="SALESFORCE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date salesforceUpdateTime;
	@Column(name="ORACLE_UPDATE_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date oracleUpdateTime;
	@Column(name="TRANSACTION_ID")
	private String transactionId;
	@Column(name="DF_TRANS_ID")
	private String dfTransId;
	@Column(name="UPDATE_DATE_TIME")
	private Date updateDateTime;
	@Column(name="OPPORTUNITY_ID")
	private String opportunityId;
	@Column(name="PARTNER_BOOKED_ATR")
	private String partnerBookedAtr;
	
	@Override
    public String toString() {
        return "SyncOpptyPartners [rowid=" + rowid + ", SyncOpptyHeaderEntityId="
                + syncOpptyHeader.getSourceOpportunityId() + "]";
    }

}
