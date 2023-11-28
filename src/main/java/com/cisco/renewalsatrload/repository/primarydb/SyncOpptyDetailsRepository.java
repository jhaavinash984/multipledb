package com.cisco.renewalsatrload.repository.primarydb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;

@Repository
public interface SyncOpptyDetailsRepository extends JpaRepository<SyncOpptyDetails,String> {

	//List<SyncOpptyDetails> findBySourceOpportunityId(String sourceOpportunityId);

}
