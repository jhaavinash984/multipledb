package com.cisco.renewalsatrload.repository.primarydb;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;

@Repository
public interface SyncOpptyHeaderRepository extends JpaRepository<SyncOpptyHeader,String> {
	
	List<SyncOpptyHeader> findBySourceOpportunityIdIn(List<String> sourceOpportunityIds);

}
