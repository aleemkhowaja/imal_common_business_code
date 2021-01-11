package com.path.bo.core.grouping.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.grouping.SegmentGroupingBO;
import com.path.bo.core.grouping.SegmentGroupingConstant;
import com.path.dao.core.grouping.SegmentGroupingDAO;
import com.path.dbmaps.vo.CTS_SEGMENT_GROUPINGVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.core.grouping.SegmentGroupingCO;
import com.path.vo.core.grouping.SegmentGroupingSC;
import com.path.vo.core.segmentation.CustSegmentationSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * SegmentGroupingBOImpl.java used to
 */
public class SegmentGroupingBOImpl extends BaseBO implements SegmentGroupingBO
{

	SegmentGroupingDAO segmentGroupingDAO;
	private CoreCommonProcedureBO coreCommonProcedureBO;

	/**
	 * Method used to return Count of SegmentGrouping
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return int Result number of Records
	 * @throws BaseException
	 */
	public int returnSegmentGroupingListCount(SegmentGroupingSC criteria) throws BaseException
	{
		return segmentGroupingDAO.returnSegmentGroupingListCount(criteria);
	}

	/**
	 * Method used to return List of SegmentGrouping
	 * 
	 * @param criteria
	 *            Search Criteria Parameter
	 * @return List Result
	 * @throws BaseException
	 */
	public List returnSegmentGroupingList(SegmentGroupingSC criteria) throws BaseException
	{
		return segmentGroupingDAO.returnSegmentGroupingList(criteria);
	}

	public SegmentGroupingCO saveNew(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		AuditRefCO refCO = segmentGroupingCO.getAuditRefCO();
		refCO.setOperationType(AuditConstant.CREATED);
		refCO.setKeyRef(AuditConstant.CTS_SEGMENT_GROUPING_KEY_REF);
		auditBO.callAudit(null, segmentGroupingCO.getCtsSegmentGroupingVO(), refCO);

		return segmentGroupingCO;
	}

	public void update(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingCO oldSegmentGroupingCO = (SegmentGroupingCO) segmentGroupingCO.getAuditObj();
		/*
		 * Update
		 */
		Integer row = genericDAO.update(segmentGroupingCO);

		/*
		 * Record Changed between retrieve and update
		 */
		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		auditBO.callAudit(oldSegmentGroupingCO.getCtsSegmentGroupingVO(), segmentGroupingCO.getCtsSegmentGroupingVO(), segmentGroupingCO.getAuditRefCO());
		auditBO.insertAudit(segmentGroupingCO.getAuditRefCO());

	}

	public void returnSegmentGroupCount(SegmentGroupingSC criteria) throws BaseException
	{
    	    
           if (!NumberUtil.isEmptyDecimal(criteria.getGroupCode()) 
        	    &&  (BigDecimal.ZERO.compareTo(criteria.getGroupCode()) > 0 
        		|| BigDecimal.ZERO.compareTo(criteria.getGroupCode()) == 0 ) )
        	{
        		throw new BOException(MessageCodes.CANNOT_BE_LESS_EQUAL_TO_ZERO);
        	}
            	    
        	int count = segmentGroupingDAO.returnSegmentGroupCount(criteria);
        
        	if (count > 0)
        	{
        		throw new BOException("Duplicate Group Code");
        	}

	}

	public void returnPriorityCountByCompany(SegmentGroupingSC criteria) throws BaseException
	{
		int count = segmentGroupingDAO.returnPriorityCountByCompany(criteria);

		if (count > 0)
		{
			throw new BOException("Duplicate Priority");
		}
	}

	public SegmentGroupingCO initialiseData(SegmentGroupingCO segmentGroupingCO, Boolean newRecord) throws BaseException
	{
		if ("R".equals(segmentGroupingCO.getCrud()) && segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE() == null)
		{
			applyDynScreenDisplay("code", "segmentGroupingCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, "1",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("code", "segmentGroupingCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "segmentGroupingCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_MANDATORY, "1",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "segmentGroupingCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					segmentGroupingCO.getBuisnessElement(), null);

			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);
		}
		else if ("R".equals(segmentGroupingCO.getCrud()))
		{
			applyDynScreenDisplay("code", "segmentGroupingCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "segmentGroupingCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "0",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "0", segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "0", segmentGroupingCO.getBuisnessElement(), null);
		}
		else
		{
			applyDynScreenDisplay("code", "segmentGroupingCO.ctsSegmentVO.SEGMENT_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("segmentDesc", "segmentGroupingCO.ctsSegmentVO.SEGMENT_DESC", ConstantsCommon.ACTION_TYPE_READONLY, "1",
					segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);
			applyDynScreenDisplay("excludeCif", "excludeCif", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);
		}

		applyDynScreenDisplay("trialProcess", "trialProcess", ConstantsCommon.ACTION_TYPE_VISIBLE, "0", segmentGroupingCO.getBuisnessElement(), null);

		return segmentGroupingCO;
	}

	public SegmentGroupingCO saveNewGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingCO baseRecord = new SegmentGroupingCO();

		baseRecord.getCtsSegmentGroupingVO().setCOMP_CODE(segmentGroupingCO.getLoginCompCode());
		baseRecord.getCtsSegmentGroupingVO().setGROUP_CODE(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		baseRecord.getCtsSegmentGroupingVO().setDESCRIPTION(segmentGroupingCO.getCtsSegmentGroupingVO().getDESCRIPTION());
		baseRecord.getCtsSegmentGroupingVO().setPRIORITY(segmentGroupingCO.getCtsSegmentGroupingVO().getPRIORITY());
		baseRecord.getCtsSegmentGroupingVO().setSTATUS(SegmentGroupingConstant.STATUS_ACTIVE);
		baseRecord.getCtsSegmentGroupingVO().setCREATED_BY(segmentGroupingCO.getLoginUserId());
		baseRecord.getCtsSegmentGroupingVO().setCREATED_DATE(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));

		genericDAO.insert(baseRecord.getCtsSegmentGroupingVO());

		if (baseRecord != null)
		{
			segmentGroupingCO.setAuditObj(segmentGroupingCO.getCtsSegmentGroupingVO());
		}

		return segmentGroupingCO;
	}

	public SegmentGroupingCO updateGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingSC temp = new SegmentGroupingSC();
		temp.setCompCode(segmentGroupingCO.getLoginCompCode());
		temp.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		temp.setIvCrud(segmentGroupingCO.getCrud());
		temp.setIsRejected(BigDecimal.ZERO);
		
		NumberUtil.resetEmptyValues(segmentGroupingCO.getCtsSegmentGroupingVO());
		segmentGroupingCO.getCtsSegmentGroupingVO().setCOMP_CODE(segmentGroupingCO.getLoginCompCode());

		CustSegmentationSC custSegmentationSC = new CustSegmentationSC();
		custSegmentationSC.setCompCode(segmentGroupingCO.getLoginCompCode());

		if (segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED() != null)
		{
			segmentGroupingCO = checkGroupDateUpdated(segmentGroupingCO);
		}
		
		coreCommonProcedureBO.runAlertSegmentGrouping(temp);
		
		CTS_SEGMENT_GROUPINGVO updateVO = new CTS_SEGMENT_GROUPINGVO();
		
		updateVO.setCOMP_CODE(segmentGroupingCO.getCtsSegmentGroupingVO().getCOMP_CODE());
		updateVO.setGROUP_CODE(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		updateVO.setDESCRIPTION(segmentGroupingCO.getCtsSegmentGroupingVO().getDESCRIPTION());
		updateVO.setPRIORITY(segmentGroupingCO.getCtsSegmentGroupingVO().getPRIORITY());
		updateVO.setDATE_UPDATED(segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED());
		updateVO.setMODIFIED_BY(segmentGroupingCO.getLoginUserId());
		updateVO.setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
		updateVO.setOLD_STATUS(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS());
		updateVO.setSTATUS("A");
		
		genericDAO.update(updateVO);
		
		return segmentGroupingCO;
	}

	public SegmentGroupingCO checkGroupDateUpdated(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();
		segmentGroupingSC.setCompCode(segmentGroupingCO.getLoginCompCode());
		segmentGroupingSC.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		segmentGroupingSC.setDateUpdated(segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED());

		int count = segmentGroupingDAO.checkGroupDateUpdated(segmentGroupingSC);
		
		if (count == 0)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		return segmentGroupingCO;
	}

	public void deleteGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();
		CTS_SEGMENT_GROUPINGVO deleteVO = new CTS_SEGMENT_GROUPINGVO();
		
		segmentGroupingSC.setCompCode(segmentGroupingCO.getLoginCompCode());
		segmentGroupingSC.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		
		int count = segmentGroupingDAO.returnGroupCountBySegment(segmentGroupingSC);
		
		if(count > 0)
		{
			throw new BOException("Cannot delete. Segments are already linked to this grouping");
		}
		
		deleteVO.setCOMP_CODE(segmentGroupingCO.getLoginCompCode());
		deleteVO.setGROUP_CODE(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		deleteVO.setSTATUS("D");
		deleteVO.setDELETED_BY(segmentGroupingCO.getLoginUserId());
		deleteVO.setDELETED_DATE(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
		
		genericDAO.update(deleteVO);
	}

	public SegmentGroupingCO returnSegmentGroupingForm(SegmentGroupingSC segmentGroupingSC) throws BaseException
	{
		SegmentGroupingCO segmentGroupingCO = segmentGroupingDAO.returnSegmentGroupingForm(segmentGroupingSC);
		
		applyDynScreenDisplay("group_code", "segmentGroupingCO.ctsSegmentGroupingVO.GROUP_CODE", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);
		applyDynScreenDisplay("priority", "segmentGroupingCO.ctsSegmentGroupingVO.PRIORITY", ConstantsCommon.ACTION_TYPE_READONLY, "1", segmentGroupingCO.getBuisnessElement(), null);

		return segmentGroupingCO;
	}
	
	public SegmentGroupingCO approveGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		SegmentGroupingSC temp = new SegmentGroupingSC();
		temp.setCompCode(segmentGroupingCO.getLoginCompCode());
		temp.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
		temp.setIvCrud(segmentGroupingCO.getCrud());
		temp.setIsRejected(BigDecimal.ZERO);
		coreCommonProcedureBO.runAlertSegmentGrouping(temp);

		if (segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED() != null)
		{
			segmentGroupingCO = checkGroupDateUpdated(segmentGroupingCO);
		}
		segmentGroupingCO.getCtsSegmentGroupingVO().setCOMP_CODE(segmentGroupingCO.getLoginCompCode());
		segmentGroupingCO.getCtsSegmentGroupingVO().setOLD_STATUS(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS());
		segmentGroupingCO.getCtsSegmentGroupingVO().setSTATUS(SegmentGroupingConstant.STATUS_APPROVED);
		segmentGroupingCO.getCtsSegmentGroupingVO().setAPPROVED_BY(segmentGroupingCO.getLoginUserId());
		segmentGroupingCO.getCtsSegmentGroupingVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
//		segmentGroupingCO.getCtsSegmentGroupingVO().setDATE_UPDATED(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
		
		genericDAO.update(segmentGroupingCO.getCtsSegmentGroupingVO());
		
		return segmentGroupingCO;
	}
	
	public SegmentGroupingCO rejectGroup(SegmentGroupingCO segmentGroupingCO) throws BaseException
	{
		if ("P".equals(segmentGroupingCO.getCrud()) && SegmentGroupingConstant.STATUS_APPROVED.equals(segmentGroupingCO.getCtsSegmentGroupingVO().getOLD_STATUS()))
		{
			SegmentGroupingSC segmentGroupingSC = new SegmentGroupingSC();
			segmentGroupingSC.setCompCode(segmentGroupingCO.getLoginCompCode());
			segmentGroupingSC.setGroupCode(segmentGroupingCO.getCtsSegmentGroupingVO().getGROUP_CODE());
			segmentGroupingSC.setIvCrud(segmentGroupingCO.getCrud());
			segmentGroupingSC.setIsRejected(BigDecimal.ONE);
			coreCommonProcedureBO.runAlertSegmentGrouping(segmentGroupingSC);
		}
		else if ("P".equals(segmentGroupingCO.getCrud()) && StringUtil.isEmptyString(segmentGroupingCO.getCtsSegmentGroupingVO().getOLD_STATUS()))
		{
			if (segmentGroupingCO.getCtsSegmentGroupingVO().getDATE_UPDATED() != null)
			{
				segmentGroupingCO = checkGroupDateUpdated(segmentGroupingCO);
			}
			segmentGroupingCO.getCtsSegmentGroupingVO().setCOMP_CODE(segmentGroupingCO.getLoginCompCode());
			segmentGroupingCO.getCtsSegmentGroupingVO().setREJECTED_BY(segmentGroupingCO.getLoginUserId());
			segmentGroupingCO.getCtsSegmentGroupingVO().setREJECTED_DATE(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
			segmentGroupingCO.getCtsSegmentGroupingVO().setOLD_STATUS(segmentGroupingCO.getCtsSegmentGroupingVO().getSTATUS());
			segmentGroupingCO.getCtsSegmentGroupingVO().setSTATUS(SegmentGroupingConstant.STATUS_APPROVE_REJECTED);
//			segmentGroupingCO.getCtsSegmentGroupingVO().setDATE_UPDATED(commonLibBO.addSystemTimeToDate(segmentGroupingCO.getRunningDate()));
			
			genericDAO.update(segmentGroupingCO.getCtsSegmentGroupingVO());
		}

		return segmentGroupingCO;	
	
	}

	public int returnSegmentGroupingLookupCount(GridParamsSC criteria) throws BaseException
	{
		return segmentGroupingDAO.returnSegmentGroupingLookupCount(criteria);
	}

	public List returnSegmentGroupingLookup(GridParamsSC criteria) throws BaseException
	{
		return segmentGroupingDAO.returnSegmentGroupingLookup(criteria);
	}
	
	public SegmentGroupingDAO getSegmentGroupingDAO()
	{
		return segmentGroupingDAO;
	}

	public void setSegmentGroupingDAO(SegmentGroupingDAO segmentGroupingDAO)
	{
		this.segmentGroupingDAO = segmentGroupingDAO;
	}

	
	public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO)
	{
		this.coreCommonProcedureBO = coreCommonProcedureBO;
	}
}
