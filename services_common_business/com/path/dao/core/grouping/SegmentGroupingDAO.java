package com.path.dao.core.grouping;

import java.util.List;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.grouping.SegmentGroupingCO;
import com.path.vo.core.grouping.SegmentGroupingSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingDAO.java used to
 */
public interface SegmentGroupingDAO
{

	public int returnSegmentGroupingListCount(SegmentGroupingSC criteria) throws DAOException;

	public List returnSegmentGroupingList(SegmentGroupingSC criteria) throws DAOException;
	
	public int returnSegmentGroupCount(SegmentGroupingSC criteria) throws DAOException;
	
	public int returnPriorityCountByCompany(SegmentGroupingSC criteria) throws DAOException;
	
	public int checkGroupDateUpdated(SegmentGroupingSC criteria) throws DAOException;
	
	public int returnGroupCountBySegment(SegmentGroupingSC criteria) throws DAOException;
	
	public SegmentGroupingCO returnSegmentGroupingForm(SegmentGroupingSC criteria) throws DAOException;
	
	public int returnSegmentGroupingLookupCount(GridParamsSC criteria) throws DAOException;
	
	public List returnSegmentGroupingLookup(GridParamsSC criteria) throws DAOException;
}
