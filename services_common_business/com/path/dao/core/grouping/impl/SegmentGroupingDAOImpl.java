package com.path.dao.core.grouping.impl;

import java.util.List;
import com.path.dao.core.grouping.SegmentGroupingDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.grouping.SegmentGroupingCO;
import com.path.vo.core.grouping.SegmentGroupingSC;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingDAOImpl.java used to
 */
public class SegmentGroupingDAOImpl extends BaseDAO implements SegmentGroupingDAO
{

	/**
	 * Method used to return Count of SegmentGrouping
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws DAOException
	 */
	public int returnSegmentGroupingListCount(SegmentGroupingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "segmentGroupingMapper.resSegmentGroupingListMap");
		return ((Integer) getSqlMap().queryForObject("segmentGroupingMapper.returnSegmentGroupingListCount", criteria)).intValue();
	}

	/**
	 * Method used to return List of SegmentGrouping
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return List Result
	 * @throws DAOException
	 */
	public List returnSegmentGroupingList(SegmentGroupingSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "segmentGroupingMapper.resSegmentGroupingListMap");
		if (criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("segmentGroupingMapper.returnSegmentGroupingList", criteria);
		}
		else
		{
			return getSqlMap().queryForList("segmentGroupingMapper.returnSegmentGroupingList", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}
	}
	
	public int returnSegmentGroupCount(SegmentGroupingSC criteria) throws DAOException
	{
		return ((Integer) getSqlMap().queryForObject("segmentGroupingMapper.returnSegmentGroupCount", criteria)).intValue();
	}
	
	public int returnPriorityCountByCompany(SegmentGroupingSC criteria) throws DAOException
	{
		return ((Integer) getSqlMap().queryForObject("segmentGroupingMapper.returnPriorityCountByCompany", criteria)).intValue();
	}
	public int checkGroupDateUpdated(SegmentGroupingSC criteria) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("segmentGroupingMapper.checkGroupDateUpdated", criteria);
	}
	public int returnGroupCountBySegment(SegmentGroupingSC criteria) throws DAOException
	{
		return (Integer) getSqlMap().queryForObject("segmentGroupingMapper.returnGroupCountBySegment", criteria);
	}
	
	public SegmentGroupingCO returnSegmentGroupingForm(SegmentGroupingSC criteria) throws DAOException
	{
		return (SegmentGroupingCO) getSqlMap().queryForObject("segmentGroupingMapper.returnSegmentGroupingForm", criteria);
	}
	
	public int returnSegmentGroupingLookupCount(GridParamsSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "segmentGroupingMapper.resSegmentGroupingGridListMap");
		return ((Integer) getSqlMap().queryForObject("segmentGroupingMapper.returnSegmentGroupingLookupCount", criteria)).intValue();
	}
	
	public List returnSegmentGroupingLookup(GridParamsSC criteria) throws DAOException
	{
		DAOHelper.fixGridMaps(criteria, getSqlMap(), "segmentGroupingMapper.resSegmentGroupingGridListMap");
		if (criteria.getNbRec() == -1)
		{
			return getSqlMap().queryForList("segmentGroupingMapper.returnSegmentGroupingLookup", criteria);
		}
		else
		{
			return getSqlMap().queryForList("segmentGroupingMapper.returnSegmentGroupingLookup", criteria, criteria.getRecToskip(), criteria.getNbRec());
		}
	}
}
