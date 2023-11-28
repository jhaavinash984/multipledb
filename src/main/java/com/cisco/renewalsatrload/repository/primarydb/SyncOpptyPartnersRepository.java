package com.cisco.renewalsatrload.repository.primarydb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyPartners;

@Repository
public interface SyncOpptyPartnersRepository extends JpaRepository<SyncOpptyPartners,String>{

	/*
	 * List<SyncOpptyPartners> findBySourceOpportunityId( String
	 * sourceOpportunityId);
	 */
}
