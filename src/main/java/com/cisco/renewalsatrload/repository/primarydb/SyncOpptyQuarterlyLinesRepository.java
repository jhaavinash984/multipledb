package com.cisco.renewalsatrload.repository.primarydb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyQuarterlyLines;

@Repository
public interface SyncOpptyQuarterlyLinesRepository extends JpaRepository<SyncOpptyQuarterlyLines,String>{

	/*
	 * List<SyncOpptyQuarterlyLines> findBySourceOpportunityLineId( String
	 * sourceOpportunityLineId);
	 */

}
