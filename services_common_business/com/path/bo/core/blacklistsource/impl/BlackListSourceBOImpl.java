package com.path.bo.core.blacklistsource.impl;

import java.math.BigDecimal;
import java.util.List;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistsource.BlackListSourceBO;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dao.core.blacklistsource.BlackListSourceDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.MOSBLACKSOURCEVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.CheckRequiredCO;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceBOImpl.java used to
 */
public class BlackListSourceBOImpl extends BaseBO implements BlackListSourceBO
{

	BlackListSourceDAO blackListSourceDAO;

	public BlackListSourceCO returnBlackListSource(BlackListSourceSC blackListSourceSC) throws BaseException
	{
		BlackListSourceCO blackListSourceCO;
		blackListSourceCO = blackListSourceDAO.returnBlackListSource(blackListSourceSC);

		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(blackListSourceCO.getLoginCompCode());
		reqFieldSC.setBranchCode(blackListSourceCO.getLoginBraCode());
		reqFieldSC.setProgRef(blackListSourceCO.getProgRef());
		reqFieldSC.setAppName(blackListSourceCO.getAppName());
		applyDynScreenDisplay(new String[] { "CODE" }, ConstantsCommon.ACTION_TYPE_READONLY, BlackListSourceConstant.ONE, blackListSourceCO.getScreenParam(),
				reqFieldSC);
		applyDynScreenDisplay(new String[] { "BRIEF_DESC_ENG" }, ConstantsCommon.ACTION_TYPE_MANDATORY, BlackListSourceConstant.ONE,
				blackListSourceCO.getScreenParam(), reqFieldSC);
		if (blackListSourceCO != null)
		{
			if (BlackListSourceConstant.ONE.equals(blackListSourceCO.getCENTRAL_BANK()))
			{
				blackListSourceCO.setCENTRAL_BANK(BlackListSourceConstant.CHECKED);
				blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ONE);
			}
			else
			{
				blackListSourceCO.setCENTRAL_BANK(BlackListSourceConstant.UNCHECKED);
				blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ZERO);


			}

		}
		if (BigDecimal.ZERO.equals(blackListSourceSC.getDualParam()))// added by nour : status is invisible when dual param flag is unchecked
		{
			applyDynScreenDisplay(new String[] { "status_desc" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					blackListSourceCO.getScreenParam(), reqFieldSC);
			applyDynScreenDisplay(new String[] { "status_button" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					blackListSourceCO.getScreenParam(), reqFieldSC);
			
		}

		return blackListSourceCO;

	}

	public BlackListSourceCO saveBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException
	{

		// validate mandatory fields
		validateMandatoryFields(blackListSourceCO);

		// SMART Save
		AuditRefCO refCO = blackListSourceCO.getAuditRefCO();
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
		smartSC.setBranchCode(blackListSourceCO.getBranch());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartSC.setLanguage(blackListSourceCO.getLanguage());

		smartBO.validateAndUpdateSmartDetails(blackListSourceCO.getSmartCOList(), smartSC, blackListSourceCO.getAuditRefCO(),
				blackListSourceCO.getBlackSourceVO());
		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListSourceCO.getBlackSourceVO().getCOMP_CODE()));

		}

		else
		{
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
		}
		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{
		blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_ACTIVE);
	
		}
		else
		{
		blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_APPROVED);

		}
		blackListSourceCO.getBlackSourceVO().setCREATED_DATE(blackListSourceCO.getRunningDate());
		blackListSourceCO.getBlackSourceVO().setCREATED_BY(blackListSourceCO.getLoginUserId());

		if (BlackListSourceConstant.CHECKED.equals(blackListSourceCO.getCENTRAL_BANK()))
		{
			blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ONE);
		}
		else
		{
			blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ZERO);

		}
		Integer row = genericDAO.insert(blackListSourceCO.getBlackSourceVO());
		if (row == null || row < BlackListSourceConstant.INT_ONE)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		// Audit for SAVE
		// audit save
		NumberUtil.resetEmptyValues(blackListSourceCO.getBlackSourceVO());
		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListSourceCO.getBlackSourceVO().getCOMP_CODE()));

		}

		auditBO.callAudit(null, blackListSourceCO.getBlackSourceVO(), blackListSourceCO.getAuditRefCO());

		return blackListSourceCO;
	}

	public BlackListSourceCO updateBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException
	{
		BlackListSourceCO oldBlackListSourceCO = (BlackListSourceCO) blackListSourceCO.getAuditObj();
		blackListSourceCO.setOldBlackSourceVO(oldBlackListSourceCO.getBlackSourceVO());
		blackListSourceCO.setMethod(BigDecimal.ONE);
		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListSourceCO.getBlackSourceVO().getCOMP_CODE()));

		}

		else
		{
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
		}

		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{
		blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_ACTIVE);
	
		}
		else
		{
		blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_APPROVED);

		}

		blackListSourceCO.getBlackSourceVO().setMODIFIED_BY(blackListSourceCO.getLoginUserId());
		blackListSourceCO.getBlackSourceVO().setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(blackListSourceCO.getRunningDate()));

		if (BlackListSourceConstant.CHECKED.equals(blackListSourceCO.getCENTRAL_BANK()))
		{
			blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ONE);
		}
		else
		{
			blackListSourceCO.getBlackSourceVO().setCENTRAL_BANK(BlackListSourceConstant.ZERO);

		}

		if (CoreCommonConstants.CRUD_MAINTENANCE.equals(blackListSourceCO.getIvCrud())
				|| (CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListSourceCO.getIvCrud())
						&& !blackListSourceCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.update(blackListSourceCO.getBlackSourceVO());
			if (row1 == null || row1 < BlackListSourceConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

		}

		if ((CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListSourceCO.getIvCrud()) && blackListSourceCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.insert(blackListSourceCO.getBlackSourceVO());
			if (row1 == null || row1 < BlackListSourceConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

			if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
			{
				blackListSourceCO.getBlackSourceVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListSourceCO.getBlackSourceVO().getCOMP_CODE()));

			}

			Integer row2 = blackListSourceDAO.updateBlackListSourceHeader(blackListSourceCO);
			if (row2 == null || row1 < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

		}

		NumberUtil.resetEmptyValues(blackListSourceCO.getBlackSourceVO());

		auditBO.callAudit(blackListSourceCO.getOldBlackSourceVO(), blackListSourceCO.getBlackSourceVO(), blackListSourceCO.getAuditRefCO());
		auditBO.insertAudit(blackListSourceCO.getAuditRefCO());

		TrackPropCO trackPropCO = auditBO.copyAuditProps(blackListSourceCO.getAuditRefCO());
		trackPropCO.setCoInstanceName("blackListSourceCO");
		trackPropCO.setVoMainPropRef("blackSourceVO");
		trackPropCO.setTrackVoMainPropRef(true);
		trackPropCO.setVoPropertiesNames("");
		auditBO.callTrackChanges(oldBlackListSourceCO, blackListSourceCO, trackPropCO);
		return blackListSourceCO;
	}

	private void validateMandatoryFields(BlackListSourceCO blackListSourceCO) throws BaseException
	{
		CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
		checkRequiredCO.setCompCode(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
		checkRequiredCO.setObj_value(blackListSourceCO);
		checkRequiredCO.setOpt(blackListSourceCO.getOpt());
		checkRequiredCO.setLanguage(blackListSourceCO.getLanguage());
		checkRequiredCO.setApp(blackListSourceCO.getAppName());
		checkRequiredCO.applyTraceProps(blackListSourceCO.getTraceAppName(), blackListSourceCO.getTraceUserId(), blackListSourceCO.getTraceProgRef(),
				blackListSourceCO.getHttpSessionIdForLink());

		commonLibBO.checkRequired(checkRequiredCO);
	}

	@Override
	public Integer blackListSourceCount(BlackListSourceSC blackListSourceSC) throws BaseException
	{
		return blackListSourceDAO.blackListSourceCount(blackListSourceSC);

	}

	@Override
	public List<BlackListSourceCO> blackListSourceList(BlackListSourceSC blackListSourceSC) throws BaseException
	{
		return blackListSourceDAO.blackListSourceList(blackListSourceSC);

	}

	@Override
	public BlackListSourceCO deleteRecord(BlackListSourceCO blackListSourceCO, AuditRefCO refCO) throws BaseException
	{
		blackListSourceCO.setMethod(blackListSourceCO.getMethod());
		if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
		{

			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListSourceCO.getBlackSourceVO().getCOMP_CODE()));

			if (blackListSourceCO.getDelete().equals(BigDecimal.ONE))
			{
				blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(CoreCommonConstants.STATUS_DELETED);
				blackListSourceCO.getBlackSourceVO().setDELETED_BY(blackListSourceCO.getLoginUserId());
				blackListSourceCO.getBlackSourceVO().setDELETED_DATE(commonLibBO.addSystemTimeToDate(blackListSourceCO.getRunningDate()));
			}

			Integer row = genericDAO.update(blackListSourceCO.getBlackSourceVO());
			if (row == null || row < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			
			// Update the row
			BlackListSourceCO oldBlackListSourceCO = (BlackListSourceCO) blackListSourceCO.getAuditObj();

			blackListSourceCO.setOldBlackSourceVO(blackListSourceCO.getBlackSourceVO());

			oldBlackListSourceCO.setOldBlackSourceVO(oldBlackListSourceCO.getBlackSourceVO());
			auditBO.callAudit(oldBlackListSourceCO.getBlackSourceVO(), blackListSourceCO.getBlackSourceVO(), blackListSourceCO.getAuditRefCO());
			auditBO.insertAudit(blackListSourceCO.getAuditRefCO());

		}
		else
		{
			 genericDAO.delete(blackListSourceCO.getBlackSourceVO());
		}

		return blackListSourceCO;
	}

	public BlackListSourceCO deleteBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException
	{
		BlackListSourceSC blackListSourceSC = new BlackListSourceSC();
		BlackListSourceCO newCO = new BlackListSourceCO();
		blackListSourceCO.setMethod(blackListSourceCO.getMethod());
		blackListSourceCO.setDualParam(blackListSourceCO.getDualParam());
		if (CoreCommonConstants.TWO.equals(blackListSourceCO.getMethod())) // cancel
		{
			int errorCode = 0;
			// Update the row
			MOSBLACKSOURCEVO mosBlackListSourceVO = new MOSBLACKSOURCEVO();
			blackListSourceSC.setCompCode(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
			blackListSourceSC.setCode(blackListSourceCO.getBlackSourceVO().getCODE());
			blackListSourceSC.setDualParam(blackListSourceCO.getDualParam());
			blackListSourceSC.setIvCrud(blackListSourceCO.getIvCrud());
			blackListSourceSC.setLanguage(blackListSourceCO.getLanguage());
			blackListSourceSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);
			blackListSourceSC.setCancelFlag(BigDecimal.ONE);
			newCO = blackListSourceDAO.returnBlackListSource(blackListSourceSC);

			mosBlackListSourceVO = newCO.getBlackSourceVO();
			BlackListSourceCO oldBlackListSourceCO = (BlackListSourceCO) blackListSourceCO.getAuditObj();
			blackListSourceCO.setOldBlackSourceVO(blackListSourceCO.getBlackSourceVO());
			oldBlackListSourceCO.setOldBlackSourceVO(oldBlackListSourceCO.getBlackSourceVO());
			MOSBLACKSOURCEVO blackListSourceVO = new MOSBLACKSOURCEVO();

			blackListSourceVO.setCOMP_CODE(blackListSourceCO.getLoginCompCode());
			blackListSourceVO.setCODE(blackListSourceCO.getCode());

			blackListSourceCO.getAuditRefCO().setTrxNbr(auditBO.checkAuditKey(blackListSourceVO, blackListSourceCO.getAuditRefCO()));
			auditBO.callAudit(blackListSourceCO.getBlackSourceVO(), mosBlackListSourceVO, blackListSourceCO.getAuditRefCO());

			errorCode = commonLibBO.validateMakerChecker(blackListSourceCO.getBlackSourceVO().getCREATED_BY(),
					blackListSourceCO.getBlackSourceVO().getMODIFIED_BY(), blackListSourceCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}
			if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
			{
				blackListSourceDAO.deleteBlackListSource(blackListSourceCO);

				// update the status of the positive record
				blackListSourceCO.getBlackSourceVO().setCOMP_CODE(blackListSourceCO.getBlackSourceVO().getCOMP_CODE());
				blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_APPROVED);

				Integer row1 = blackListSourceDAO.updateBlackListSourceHeader(blackListSourceCO);
				if (row1 == null || row1 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}

			}
			else
			{
				genericDAO.update(blackListSourceCO.getBlackSourceVO());

			}

			NumberUtil.resetEmptyValues(blackListSourceCO.getBlackSourceVO());
			 auditBO.callAudit(((BlackListSourceCO) blackListSourceCO.getAuditObj()).getBlackSourceVO(), blackListSourceCO.getBlackSourceVO(),
			 blackListSourceCO.getAuditRefCO());
			auditBO.insertAudit(blackListSourceCO.getAuditRefCO());
		}

		else // approve
		{
			int errorCode = 0;
			// Update the row
			BlackListSourceCO oldBlackListSourceCO = (BlackListSourceCO) blackListSourceCO.getAuditObj();

			blackListSourceCO.setOldBlackSourceVO(blackListSourceCO.getBlackSourceVO());

			oldBlackListSourceCO.setOldBlackSourceVO(oldBlackListSourceCO.getBlackSourceVO());
			auditBO.callAudit(oldBlackListSourceCO.getBlackSourceVO(), blackListSourceCO.getBlackSourceVO(), blackListSourceCO.getAuditRefCO());

			errorCode = commonLibBO.validateMakerChecker(blackListSourceCO.getBlackSourceVO().getCREATED_BY(),
					blackListSourceCO.getBlackSourceVO().getMODIFIED_BY(), blackListSourceCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}
			if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
			{
				blackListSourceDAO.deleteBlackListSource(blackListSourceCO);

			}
			else
			{
				genericDAO.update(blackListSourceCO.getBlackSourceVO());

			}

			auditBO.insertAudit(blackListSourceCO.getAuditRefCO());

		}
		return blackListSourceCO;
	}

	public BlackListSourceCO approveBlackListSource(BlackListSourceCO blackListSourceCO) throws BaseException
	{

		blackListSourceCO.getBlackSourceVO().setENTITY_STATUS(CoreCommonConstants.STATUS_APPROVED);
		blackListSourceCO.getBlackSourceVO().setAPPROVED_BY(blackListSourceCO.getLoginUserId());
		blackListSourceCO.getBlackSourceVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(blackListSourceCO.getRunningDate()));

		int errorCode = 0;
		
		

		errorCode = commonLibBO.validateMakerChecker(blackListSourceCO.getBlackSourceVO().getCREATED_BY(),
				blackListSourceCO.getBlackSourceVO().getMODIFIED_BY(), blackListSourceCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}

		blackListSourceCO.applyTraceProps(blackListSourceCO.getAppName(), blackListSourceCO.getLoginUserId(), blackListSourceCO.getProgRef());

		Integer row = blackListSourceDAO.approveBlackListSource(blackListSourceCO);

		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		// Update the row
		BlackListSourceCO oldBlackListSourceCO = (BlackListSourceCO) blackListSourceCO.getAuditObj();

		blackListSourceCO.setOldBlackSourceVO(blackListSourceCO.getBlackSourceVO());

		oldBlackListSourceCO.setOldBlackSourceVO(oldBlackListSourceCO.getBlackSourceVO());
		auditBO.callAudit(oldBlackListSourceCO.getBlackSourceVO(), blackListSourceCO.getBlackSourceVO(), blackListSourceCO.getAuditRefCO());
		auditBO.insertAudit(blackListSourceCO.getAuditRefCO());
		// Changes tracking TrackPropCO trackCO
		TrackPropCO trackCO = auditBO.copyAuditProps(blackListSourceCO.getAuditRefCO());
		trackCO.setOperationType(AuditConstant.APPROVE); // the newCO shall
		// be null when we use this method upon // approve/reject.
		trackCO.setVoMainPropRef("blackSourceVO");
		auditBO.callTrackChanges(oldBlackListSourceCO, null, trackCO);
		return blackListSourceCO;
	}

	@Override
	public BlackListSourceCO returnDepByCifCode(BlackListSourceCO blackListSourceCO) throws BaseException
	{

		if (blackListSourceCO.getBlackSourceVO().getCIF_NO().intValue() < 0)
		{
			throw new BOException(MessageCodes.INVALID_CIF_NUMBER);
		}
		else
		{
			CIFVO blackListSourceVO = new CIFVO();
			blackListSourceVO = blackListSourceDAO.returnCifCode(blackListSourceCO);

			if (blackListSourceVO == null)
			{
				throw new BOException(MessageCodes.INVALID_CIF_NUMBER);

			}
			else
			{
				blackListSourceCO.getBlackSourceVO().setBRIEF_DESC_ENG(blackListSourceVO.getSHORT_NAME_ENG());
				blackListSourceCO.getBlackSourceVO().setBRIEF_DESC_ARAB(blackListSourceVO.getSHORT_NAME_ARAB());
				blackListSourceCO.getBlackSourceVO().setLONG_DESC_ARAB(blackListSourceVO.getLONG_NAME_ARAB());
				blackListSourceCO.getBlackSourceVO().setLONG_DESC_ENG(blackListSourceVO.getLONG_NAME_ENG());
			}

			return blackListSourceCO;
		}
	}

	@Override
	public BlackListSourceCO initializeData(BlackListSourceCO blackListSourceCO) throws BaseException
	{
		applyDynScreenDisplay("CODE", "blackListSourceCO.blackSourceVO.CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, BlackListSourceConstant.ONE,
				blackListSourceCO.getBuisnessElement(), null);
		applyDynScreenDisplay("BRIEF_DESC_ENG", "blackListSourceCO.blackSourceVO.BRIEF_DESC_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,
				BlackListSourceConstant.ONE, blackListSourceCO.getBuisnessElement(), null);
		if (BigDecimal.ZERO.equals(blackListSourceCO.getDualParam()))// added by nour : status is invisible when dual param flag is unchecked
		{
			applyDynScreenDisplay(new String[] { "status_desc" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					blackListSourceCO.getBuisnessElement(), null);
			applyDynScreenDisplay(new String[] { "status_button" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					blackListSourceCO.getBuisnessElement(), null);
		}

		return blackListSourceCO;
	}

	@Override
	public BigDecimal getDualParam(BlackListSourceCO blackListSourceCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		S_APPVO sAppVO = new S_APPVO();
		sAppVO.setAPP_NAME(blackListSourceCO.getAppName());
		return commonLibBO.returnApplicationDetails(sAppVO).getDUAL_PARAM();
	}

	public BlackListSourceDAO getBlackListSourceDAO()
	{
		return blackListSourceDAO;
	}

	public void setBlackListSourceDAO(BlackListSourceDAO blackListSourceDAO)
	{
		this.blackListSourceDAO = blackListSourceDAO;
	}

}
