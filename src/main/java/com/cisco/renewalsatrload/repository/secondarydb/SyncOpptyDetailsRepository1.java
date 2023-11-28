package com.cisco.renewalsatrload.repository.secondarydb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;
import com.cisco.renewalsatrload.entity.secondarydb.SyncOpptyDetails1;

@Repository
public interface SyncOpptyDetailsRepository1 extends JpaRepository<SyncOpptyDetails1,String> {

}
