package com.path.bo.core.blacklisttype.impl;

import java.math.BigDecimal;
import java.util.List;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.blacklisttype.BlackListTypeBO;
import com.path.bo.core.blacklisttype.BlackListTypeConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dao.core.blacklisttype.BlackListTypeDAO;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
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
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;

public class BlackListTypeBOImpl extends BaseBO implements BlackListTypeBO
{

	private BlackListTypeDAO blackListTypeDAO;

	@Override
	public List blackLstTypeList(BlackListTypeSC criteria) throws BaseException
	{
		return blackListTypeDAO.blackLstTypeList(criteria);
	}

	@Override
	public int blackLstTypeListCount(BlackListTypeSC criteria) throws BaseException
	{
		return blackListTypeDAO.blackLstTypeListCount(criteria);
	}

	@Override
	public MOSBLACKLIST_TYPEVO returnBlackLstTypeById(BlackListTypeSC criteria) throws BaseException
	{
		return (MOSBLACKLIST_TYPEVO) blackListTypeDAO.returnBlackLstTypeById(criteria);
	}

	// added by nour for 885556
	public BlackListTypeCO returnBlackListType(BlackListTypeSC blackListTypeSC) throws BaseException
	{
		BlackListTypeCO blackListTypeCO;
		blackListTypeCO = blackListTypeDAO.returnBlackListType(blackListTypeSC);

		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(blackListTypeCO.getLoginCompCode());
		reqFieldSC.setBranchCode(blackListTypeCO.getLoginBraCode());
		reqFieldSC.setProgRef(blackListTypeCO.getProgRef());
		reqFieldSC.setAppName(blackListTypeCO.getAppName());
		applyDynScreenDisplay(new String[] { "CODE" }, ConstantsCommon.ACTION_TYPE_READONLY, BlackListTypeConstant.ONE, blackListTypeCO.getScreenParam(),
				reqFieldSC);
		applyDynScreenDisplay(new String[] { "BRIEF_NAME_ENG" }, ConstantsCommon.ACTION_TYPE_MANDATORY, BlackListTypeConstant.ONE,
				blackListTypeCO.getScreenParam(), reqFieldSC);
		if (BigDecimal.ZERO.equals(blackListTypeSC.getDualParam())) // added by nour : status is invisible when dual param flag is unchecked
		{
			applyDynScreenDisplay(new String[] { "status_desc" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListTypeConstant.ZERO,
					blackListTypeCO.getScreenParam(), reqFieldSC);
			applyDynScreenDisplay(new String[] { "status_button" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListTypeConstant.ZERO,
					blackListTypeCO.getScreenParam(), reqFieldSC);
		}

		return blackListTypeCO;

	}

	@Override
	public Integer blackListTypeByCount(BlackListTypeSC blackListTypeSC) throws BaseException
	{
		return blackListTypeDAO.blackListTypeByCount(blackListTypeSC);

	}

	@Override
	public List<BlackListTypeCO> blackListTypeByList(BlackListTypeSC blackListTypeSC) throws BaseException
	{
		return blackListTypeDAO.blackListTypeByList(blackListTypeSC);

	}

	@Override
	public BlackListTypeCO initializeData(BlackListTypeCO blackListTypeCO) throws BaseException
	{
		applyDynScreenDisplay("CODE", "blackListTypeCO.mosBlackListTypeVO.CODE", ConstantsCommon.ACTION_TYPE_MANDATORY, BlackListTypeConstant.ONE,
				blackListTypeCO.getBuisnessElement(), null);
		applyDynScreenDisplay("BRIEF_NAME_ENG", "blackListTypeCO.mosBlackListTypeVO.BRIEF_DESC_ENG", ConstantsCommon.ACTION_TYPE_MANDATORY,
				BlackListTypeConstant.ONE, blackListTypeCO.getBuisnessElement(), null);
		if (BigDecimal.ZERO.equals(blackListTypeCO.getDualParam())) // added by nour : status is invisible when dual param flag is unchecked
		{
			applyDynScreenDisplay(new String[] { "status_desc" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListTypeConstant.ZERO,
					blackListTypeCO.getBuisnessElement(), null);
			applyDynScreenDisplay(new String[] { "status_button" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListTypeConstant.ZERO,
					blackListTypeCO.getBuisnessElement(), null);
		}

		return blackListTypeCO;
	}

	@Override
	public BlackListTypeCO saveBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException
	{
		// validate mandatory fields
		validateMandatoryFields(blackListTypeCO);

		// SMART Save
		AuditRefCO refCO = blackListTypeCO.getAuditRefCO();
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
		smartSC.setBranchCode(blackListTypeCO.getBranch());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartSC.setLanguage(blackListTypeCO.getLanguage());

		smartBO.validateAndUpdateSmartDetails(blackListTypeCO.getSmartCOList(), smartSC, blackListTypeCO.getAuditRefCO(),
				blackListTypeCO.getMosBlackListTypeVO());
		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{
			blackListTypeCO.getMosBlackListTypeVO()
					.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE()));

		}

		else
		{
			blackListTypeCO.getMosBlackListTypeVO().setCOMP_CODE(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
		}
		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{

		blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(BlackListTypeConstant.STATUS_ACTIVE);
		}
		else
		{
			blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(BlackListTypeConstant.STATUS_APPROVED);

		}
		blackListTypeCO.getMosBlackListTypeVO().setCREATED_DATE(blackListTypeCO.getRunningDate());
		blackListTypeCO.getMosBlackListTypeVO().setCREATED_BY(blackListTypeCO.getLoginUserId());

		Integer row = genericDAO.insert(blackListTypeCO.getMosBlackListTypeVO());
		if (row == null || row < BlackListTypeConstant.INT_ONE)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{
			blackListTypeCO.getMosBlackListTypeVO()
					.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE()));

		}
		// Audit for SAVE
		// audit save
		NumberUtil.resetEmptyValues(blackListTypeCO.getMosBlackListTypeVO());
		auditBO.callAudit(null, blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getAuditRefCO());

		return blackListTypeCO;
	}

	@Override
	public BlackListTypeCO updateBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException
	{
		BlackListTypeCO oldBlackListTypeCO = (BlackListTypeCO) blackListTypeCO.getAuditObj();
		blackListTypeCO.setOldMosBlackListTypeVO(oldBlackListTypeCO.getMosBlackListTypeVO());

		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{
			blackListTypeCO.getMosBlackListTypeVO()
					.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE()));

		}

		else
		{
			blackListTypeCO.getMosBlackListTypeVO().setCOMP_CODE(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
		}

		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{

		blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(BlackListTypeConstant.STATUS_ACTIVE);
		}
		else
		{
			blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(BlackListTypeConstant.STATUS_APPROVED);

		}

		blackListTypeCO.getMosBlackListTypeVO().setMODIFIED_BY(blackListTypeCO.getLoginUserId());
		blackListTypeCO.getMosBlackListTypeVO().setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(blackListTypeCO.getRunningDate()));

		if (CoreCommonConstants.CRUD_MAINTENANCE.equals(blackListTypeCO.getIvCrud())
				|| (CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListTypeCO.getIvCrud())
						&& !blackListTypeCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.update(blackListTypeCO.getMosBlackListTypeVO());
			if (row1 == null || row1 < BlackListControlRecordConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

		}

		if ((CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListTypeCO.getIvCrud()) && blackListTypeCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.insert(blackListTypeCO.getMosBlackListTypeVO());
			if (row1 == null || row1 < BlackListControlRecordConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
			{
				blackListTypeCO.getMosBlackListTypeVO()
						.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE()));

			}

			Integer row2 = blackListTypeDAO.updateBlackListTypeHeader(blackListTypeCO);
			if (row2 == null || row1 < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
		}

		NumberUtil.resetEmptyValues(blackListTypeCO.getMosBlackListTypeVO());

		auditBO.callAudit(blackListTypeCO.getOldMosBlackListTypeVO(), blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getAuditRefCO());
		auditBO.insertAudit(blackListTypeCO.getAuditRefCO());

		TrackPropCO trackPropCO = auditBO.copyAuditProps(blackListTypeCO.getAuditRefCO());
		trackPropCO.setCoInstanceName("blackListTypeCO");
		trackPropCO.setVoMainPropRef("mosBlackListTypeVO");
		trackPropCO.setTrackVoMainPropRef(true);
		trackPropCO.setVoPropertiesNames("");
		auditBO.callTrackChanges(oldBlackListTypeCO, blackListTypeCO, trackPropCO);
		return blackListTypeCO;
	}

	@Override
	public BlackListTypeCO deleteRecord(BlackListTypeCO blackListTypeCO, AuditRefCO refCO) throws BaseException
	{

		blackListTypeCO.setMethod(blackListTypeCO.getMethod());
		if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
		{

			blackListTypeCO.getMosBlackListTypeVO()
					.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE()));

			if (blackListTypeCO.getDelete().equals(BigDecimal.ONE))
			{
				blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(CoreCommonConstants.STATUS_DELETED);
				blackListTypeCO.getMosBlackListTypeVO().setDELETED_BY(blackListTypeCO.getLoginUserId());
				blackListTypeCO.getMosBlackListTypeVO().setDELETED_DATE(commonLibBO.addSystemTimeToDate(blackListTypeCO.getRunningDate()));
			}

			Integer row = genericDAO.update(blackListTypeCO.getMosBlackListTypeVO());
			if (row == null || row < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
			
			// Update the row
			BlackListTypeCO oldBlackListTypeCO = (BlackListTypeCO) blackListTypeCO.getAuditObj();

			blackListTypeCO.setOldMosBlackListTypeVO(blackListTypeCO.getMosBlackListTypeVO());

			oldBlackListTypeCO.setOldMosBlackListTypeVO(oldBlackListTypeCO.getMosBlackListTypeVO());
			auditBO.callAudit(oldBlackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getAuditRefCO());
			auditBO.insertAudit(blackListTypeCO.getAuditRefCO());

		}
		else
		{
			genericDAO.delete(blackListTypeCO.getMosBlackListTypeVO());
		}
		
		return blackListTypeCO;
	}

	public BlackListTypeCO deleteBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException
	{

		blackListTypeCO.setMethod(blackListTypeCO.getMethod());
		blackListTypeCO.setDualParam(blackListTypeCO.getDualParam());
		BlackListTypeSC blackListTypeSC = new BlackListTypeSC();
		BlackListTypeCO newCO = new BlackListTypeCO();

		if (CoreCommonConstants.TWO.equals(blackListTypeCO.getMethod())) // cancel
		{
			int errorCode = 0;
			// Update the row
			MOSBLACKLIST_TYPEVO newVO = new MOSBLACKLIST_TYPEVO();
			blackListTypeSC.setCompCode(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
			blackListTypeSC.setCode(blackListTypeCO.getMosBlackListTypeVO().getCODE());
			blackListTypeSC.setDualParam(blackListTypeCO.getDualParam());
			blackListTypeSC.setIvCrud(blackListTypeCO.getIvCrud());
			blackListTypeSC.setLanguage(blackListTypeCO.getLanguage());
			blackListTypeSC.setLovTypeId(BlackListTypeConstant.LOV_TYPE);
			blackListTypeSC.setCancelFlag(BigDecimal.ONE);
			newCO = blackListTypeDAO.returnBlackListType(blackListTypeSC);

			newVO = newCO.getMosBlackListTypeVO();
			BlackListTypeCO oldBlackListTypeCO = (BlackListTypeCO) blackListTypeCO.getAuditObj();
			blackListTypeCO.setOldMosBlackListTypeVO(blackListTypeCO.getMosBlackListTypeVO());
			oldBlackListTypeCO.setOldMosBlackListTypeVO(oldBlackListTypeCO.getMosBlackListTypeVO());
			MOSBLACKLIST_TYPEVO blackListTypeVO = new MOSBLACKLIST_TYPEVO();

			blackListTypeVO.setCOMP_CODE(blackListTypeCO.getLoginCompCode());
			blackListTypeVO.setCODE(blackListTypeCO.getCode());

			blackListTypeCO.getAuditRefCO().setTrxNbr(auditBO.checkAuditKey(blackListTypeVO, blackListTypeCO.getAuditRefCO()));
			auditBO.callAudit(blackListTypeCO.getMosBlackListTypeVO(), newVO, blackListTypeCO.getAuditRefCO());

			errorCode = commonLibBO.validateMakerChecker(blackListTypeCO.getMosBlackListTypeVO().getCREATED_BY(),
					blackListTypeCO.getMosBlackListTypeVO().getMODIFIED_BY(), blackListTypeCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}
			if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
			{
				blackListTypeDAO.deleteBlackListType(blackListTypeCO);

				// update the status of the positive record
				blackListTypeCO.getMosBlackListTypeVO().setCOMP_CODE(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
				blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(BlackListSourceConstant.STATUS_APPROVED);

				Integer row1 = blackListTypeDAO.updateBlackListTypeHeader(blackListTypeCO);
				if (row1 == null || row1 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}

			}
			else
			{
				genericDAO.update(blackListTypeCO.getMosBlackListTypeVO());

			}

			NumberUtil.resetEmptyValues(blackListTypeCO.getMosBlackListTypeVO());
			auditBO.callAudit(((BlackListTypeCO) blackListTypeCO.getAuditObj()).getMosBlackListTypeVO(), blackListTypeCO.getMosBlackListTypeVO(),
					blackListTypeCO.getAuditRefCO());
			auditBO.insertAudit(blackListTypeCO.getAuditRefCO());
		}
		else // approve
		{
			int errorCode = 0;

			errorCode = commonLibBO.validateMakerChecker(blackListTypeCO.getMosBlackListTypeVO().getCREATED_BY(),
					blackListTypeCO.getMosBlackListTypeVO().getMODIFIED_BY(), blackListTypeCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
			{
				blackListTypeDAO.deleteBlackListType(blackListTypeCO);

			}
			else
			{
				genericDAO.update(blackListTypeCO.getMosBlackListTypeVO());

			}
			// Update the row
			BlackListTypeCO oldBlackListTypeCO = (BlackListTypeCO) blackListTypeCO.getAuditObj();

			blackListTypeCO.setOldMosBlackListTypeVO(blackListTypeCO.getMosBlackListTypeVO());

			oldBlackListTypeCO.setOldMosBlackListTypeVO(oldBlackListTypeCO.getMosBlackListTypeVO());
			auditBO.callAudit(oldBlackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getAuditRefCO());
			auditBO.insertAudit(blackListTypeCO.getAuditRefCO());
		}
		return blackListTypeCO;
	}

	public BlackListTypeCO approveBlackListType(BlackListTypeCO blackListTypeCO) throws BaseException
	{

		blackListTypeCO.getMosBlackListTypeVO().setENTITY_STATUS(CoreCommonConstants.STATUS_APPROVED);
		blackListTypeCO.getMosBlackListTypeVO().setAPPROVED_BY(blackListTypeCO.getLoginUserId());
		blackListTypeCO.getMosBlackListTypeVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(blackListTypeCO.getRunningDate()));

		int errorCode = 0;

		errorCode = commonLibBO.validateMakerChecker(blackListTypeCO.getMosBlackListTypeVO().getCREATED_BY(),
				blackListTypeCO.getMosBlackListTypeVO().getMODIFIED_BY(), blackListTypeCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}

		blackListTypeCO.applyTraceProps(blackListTypeCO.getAppName(), blackListTypeCO.getLoginUserId(), blackListTypeCO.getProgRef());
		Integer row;

		row = blackListTypeDAO.approveBlackListType(blackListTypeCO);

		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}

		// Update the row
		BlackListTypeCO oldblackListTypeCO = (BlackListTypeCO) blackListTypeCO.getAuditObj();

		blackListTypeCO.setOldMosBlackListTypeVO(blackListTypeCO.getMosBlackListTypeVO());

		oldblackListTypeCO.setOldMosBlackListTypeVO(oldblackListTypeCO.getMosBlackListTypeVO());
		auditBO.callAudit(oldblackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO.getAuditRefCO());
		auditBO.insertAudit(blackListTypeCO.getAuditRefCO());
		// Changes tracking TrackPropCO trackCO
		TrackPropCO trackCO = auditBO.copyAuditProps(blackListTypeCO.getAuditRefCO());
		trackCO.setOperationType(AuditConstant.APPROVE); // the newCO shall
		// be null when we use this method upon // approve/reject.
		trackCO.setVoMainPropRef("mosBlackListTypeVO");
		auditBO.callTrackChanges(oldblackListTypeCO, null, trackCO);

		return blackListTypeCO;
	}

	public BlackListTypeCO returnDepByCode(BlackListTypeCO blackListTypeCO) throws BaseException
	{

		if (blackListTypeCO.getMosBlackListTypeVO().getCODE().intValue() <= 0)
		{
			throw new BOException(MessageCodes.VALUE_CANNOT_BE_EQUAL_OR_LESS_THAN_ZERO);
		}
		else
		{

			int count = blackListTypeDAO.returnCodeDuplicateByCode(blackListTypeCO);

			if (count >= 1)
			{
				throw new BOException(MessageCodes.DUPLICATE_VALUE);

			}

			return blackListTypeCO;
		}

	}

	public BlackListTypeCO returnDepRevBasis(BlackListTypeCO blackListTypeCO) throws BaseException
	{
		if (BlackListTypeConstant.NOT_APPLICABLE.equals(blackListTypeCO.getMosBlackListTypeVO().getREVISION_BASIS()))

		{
			blackListTypeCO.getMosBlackListTypeVO().setREVISION_PERIOD(null);
		}

		else
		{
			blackListTypeCO.getMosBlackListTypeVO()
					.setREVISION_PERIOD(NumberUtil.emptyDecimalToNull(blackListTypeCO.getMosBlackListTypeVO().getREVISION_PERIOD()));
		}

		return blackListTypeCO;

	}

	private void validateMandatoryFields(BlackListTypeCO blackListTypeCO) throws BaseException
	{
		CheckRequiredCO checkRequiredCO = new CheckRequiredCO();
		checkRequiredCO.setCompCode(blackListTypeCO.getMosBlackListTypeVO().getCOMP_CODE());
		checkRequiredCO.setObj_value(blackListTypeCO);
		checkRequiredCO.setOpt(blackListTypeCO.getOpt());
		checkRequiredCO.setLanguage(blackListTypeCO.getLanguage());
		checkRequiredCO.setApp(blackListTypeCO.getAppName());
		checkRequiredCO.applyTraceProps(blackListTypeCO.getTraceAppName(), blackListTypeCO.getTraceUserId(), blackListTypeCO.getTraceProgRef(),
				blackListTypeCO.getHttpSessionIdForLink());

		commonLibBO.checkRequired(checkRequiredCO);
	}

	public BigDecimal getDualParam(BlackListTypeCO blackListTypeCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		S_APPVO sAppVO = new S_APPVO();
		sAppVO.setAPP_NAME(blackListTypeCO.getAppName());
		return commonLibBO.returnApplicationDetails(sAppVO).getDUAL_PARAM();
	}

	public BlackListTypeDAO getBlackListTypeDAO()
	{
		return blackListTypeDAO;
	}

	public void setBlackListTypeDAO(BlackListTypeDAO blackListTypeDAO)
	{
		this.blackListTypeDAO = blackListTypeDAO;
	}


	public BlackListTypeCO returnDepRevPeriod(BlackListTypeCO blackListTypeCO) throws BaseException
	{

		if (blackListTypeCO.getMosBlackListTypeVO().getREVISION_PERIOD().intValue() < 0)
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_THAN_ZERO);
		}

		return blackListTypeCO;

	}

}
