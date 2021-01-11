package com.path.bo.core.grouping;

import java.util.List;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.grouping.SegmentGroupingCO;
import com.path.vo.core.grouping.SegmentGroupingSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingBO.java used to
 */
public interface SegmentGroupingBO
{

	public int returnSegmentGroupingListCount(SegmentGroupingSC criteria) throws BaseException;

	public List returnSegmentGroupingList(SegmentGroupingSC criteria) throws BaseException;

	public SegmentGroupingCO saveNew(SegmentGroupingCO segmentGroupingCO)throws BaseException;

	public void update(SegmentGroupingCO segmentGroupingCO)throws BaseException;

	public void returnSegmentGroupCount(SegmentGroupingSC criteria) throws BaseException;
	
	public void returnPriorityCountByCompany(SegmentGroupingSC criteria) throws BaseException;
	
	public SegmentGroupingCO initialiseData(SegmentGroupingCO segmentGroupingCO, Boolean newRecord) throws BaseException;
	
	public SegmentGroupingCO saveNewGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public SegmentGroupingCO updateGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public void deleteGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public SegmentGroupingCO returnSegmentGroupingForm(SegmentGroupingSC segmentGroupingSC) throws BaseException;
	
	public SegmentGroupingCO approveGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public SegmentGroupingCO rejectGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public SegmentGroupingCO checkGroupDateUpdated(SegmentGroupingCO segmentGroupingCO) throws BaseException;
	
	public int returnSegmentGroupingLookupCount(GridParamsSC criteria) throws BaseException;

	public List returnSegmentGroupingLookup(GridParamsSC criteria) throws BaseException;
}
