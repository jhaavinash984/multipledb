package com.cisco.renewalsatrload.service;

import java.util.List;

import org.json.JSONArray;

import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;
import com.cisco.renewalsatrload.model.Payload;
import com.cisco.renewalsatrload.model.SyncOpptyHeaderModel;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;

public interface SyncOpptyService {
	
	List<SyncOpptyHeaderModel> fetchSyncopptydetails();
	
	List<Payload> fetchSyncOpptyHeader();
	

}
