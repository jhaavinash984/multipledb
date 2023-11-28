package com.cisco.renewalsatrload.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyDetailsRepository;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyHeaderRepository;
import com.cisco.renewalsatrload.service.SyncOpptyService;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyHeader;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyPartners;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyQuarterlyLines;
import com.cisco.renewalsatrload.model.Payload;
import com.cisco.renewalsatrload.model.SyncOpptyDetailsModel;
import com.cisco.renewalsatrload.model.SyncOpptyHeaderModel;
import com.cisco.renewalsatrload.model.SyncOpptyPartnersModel;
import com.cisco.renewalsatrload.model.SyncOpptyQuarterlyLinesModel;
import com.cisco.renewalsatrload.entity.primarydb.SyncOpptyDetails;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyDetailsRepository;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyHeaderRepository;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyPartnersRepository;
import com.cisco.renewalsatrload.repository.primarydb.SyncOpptyQuarterlyLinesRepository;
import com.cisco.renewalsatrload.service.SyncOpptyService;



@Service
public class SyncOpptyServiceImpl implements SyncOpptyService {
	
	@Autowired
	SyncOpptyHeaderRepository syncOpptyHeaderRepo;
	
	@Autowired
	SyncOpptyDetailsRepository syncOpptyDetailsRepo;
	
	@Autowired
	SyncOpptyQuarterlyLinesRepository syncOpptyQuarterlyLinesRepo;
	
	@Autowired
	SyncOpptyPartnersRepository syncOpptyPartnersRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	

	@Override
	public List<SyncOpptyHeaderModel> fetchSyncopptydetails() {
		Page<SyncOpptyHeader> syncOpptyHeaderPage = syncOpptyHeaderRepo.findAll(PageRequest.of(0, 100, Sort.by(Sort.Order.asc("sourceOpportunityId"))));
		List<SyncOpptyHeader> syncOpptyHeaderClct = syncOpptyHeaderPage.getContent();
		List<SyncOpptyHeaderModel> syncOpptyHeaderModelClct = syncOpptyHeaderClct.stream().map(item -> modelMapper.map(item, SyncOpptyHeaderModel.class)).collect(Collectors.toList());
		for(int i =0;i<syncOpptyHeaderModelClct.size();i++){
			SyncOpptyHeaderModel syncOpptyHeaderModel = syncOpptyHeaderModelClct.get(i);
			//List<SyncOpptyDetails> syncOpptyDetailsClct = syncOpptyDetailsRepo.findBySourceOpportunityId(syncOpptyHeaderModelClct.get(i).getSourceOpportunityId());
			List<SyncOpptyDetails> syncOpptyDetailsClct = new ArrayList<>();
			List<SyncOpptyDetailsModel> syncOpptyDetailsModelClct = syncOpptyDetailsClct.stream().map(item -> modelMapper.map(item, SyncOpptyDetailsModel.class)).collect(Collectors.toList());
			for(int j=0;j<syncOpptyDetailsModelClct.size();j++) {
				SyncOpptyDetailsModel syncOpptyDetailsModel = syncOpptyDetailsModelClct.get(j);
				List<SyncOpptyQuarterlyLines> syncOpptyQuarterlyLinesClct = new ArrayList<>();
				//List<SyncOpptyQuarterlyLines> syncOpptyQuarterlyLinesClct = syncOpptyQuarterlyLinesRepo.findBySourceOpportunityLineId(syncOpptyDetailsModel.getSourceOpportunityLineId());
				List<SyncOpptyQuarterlyLinesModel> syncOpptyQuarterlyLinesModelClct = syncOpptyQuarterlyLinesClct.stream().map(item -> modelMapper.map(item, SyncOpptyQuarterlyLinesModel.class)).collect(Collectors.toList());
				syncOpptyDetailsModel.setLineByQuarter(syncOpptyQuarterlyLinesModelClct);
				syncOpptyDetailsModelClct.set(j, syncOpptyDetailsModel);
			}
			syncOpptyHeaderModel.setOpportunityLineItems(syncOpptyDetailsModelClct);
			List<SyncOpptyPartners> syncOpptyPartnersClct = new ArrayList<>();
		//	List<SyncOpptyPartners> syncOpptyPartnersClct = syncOpptyPartnersRepo.findBySourceOpportunityId(syncOpptyHeaderModel.getSourceOpportunityId());
			List<SyncOpptyPartnersModel> syncOpptyPartnersModelClct = syncOpptyPartnersClct.stream().map(item -> modelMapper.map(item, SyncOpptyPartnersModel.class)).collect(Collectors.toList());
			syncOpptyHeaderModel.setPartners(syncOpptyPartnersModelClct);
			syncOpptyHeaderModelClct.set(i,syncOpptyHeaderModel);
		}
		return syncOpptyHeaderModelClct;
		//Page<SyncOpptyDetails> page = syncOpptyDetailsRepo.findAll(PageRequest.of(0, 20, Sort.by(Sort.Order.asc("sourceOpportunityId"))));
       // return page.getContent();
	}

	@Override
	public List<Payload> fetchSyncOpptyHeader() {
		List<String> sourceOpptyIds = Arrays.asList("38362771","38562401","47227021","48982721","48222571");
        List<SyncOpptyHeader> syncOpptyHeaderClct = syncOpptyHeaderRepo.findBySourceOpportunityIdIn(sourceOpptyIds);
        List<Payload> payloads = syncOpptyHeaderClct.stream().map(item -> new Payload(item)).collect(Collectors.toList());
        
        //Page<SyncOpptyHeader> page = syncOpptyHeaderRepo.findAll(PageRequest.of(0, 10, Sort.by(Sort.Order.asc("sourceOpportunityId"))));
        //return page.getContent();
        return payloads;
	}

}
