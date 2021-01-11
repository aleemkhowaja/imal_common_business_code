package com.path.bo.core.blacklistcontrolrecord.impl;

import java.math.BigDecimal;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordBO;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.dao.core.blacklistcontrolrecord.BlackListControlRecordDAO;
import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.RequiredFieldsSC;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.audit.TrackPropCO;
import com.path.vo.common.smart.SmartSC;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordCO;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ControlRecordBOImpl.java used to
 */
public class BlackListControlRecordBOImpl extends BaseBO implements BlackListControlRecordBO
{

	BlackListControlRecordDAO blackListControlRecordDAO;

	public BlackListControlRecordCO loadData(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		BigDecimal dualParama= controlRecordCO.getDualParam();
		// load data from db
		controlRecordCO = blackListControlRecordDAO.returnData(controlRecordCO);

		if (controlRecordCO == null)
		{
			controlRecordCO = new BlackListControlRecordCO();
			controlRecordCO.setSaveUpdateFlag(BlackListControlRecordConstant.ONE);
		}
		else
		{
			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_BDATE()))
			{
				controlRecordCO.setBLCKL_BDATE(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_BDATE(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_BNAME()))
			{
				controlRecordCO.setBLCKL_BNAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_BNAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_BPLACE()))
			{
				controlRecordCO.setBLCKL_BPLACE(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_BPLACE(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_COUNTRY()))
			{
				controlRecordCO.setBLCKL_COUNTRY(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_COUNTRY(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_FST_NAME()))
			{
				controlRecordCO.setBLCKL_FST_NAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_FST_NAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_IDNO()))
			{
				controlRecordCO.setBLCKL_IDNO(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_IDNO(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_LAST_NAME()))
			{
				controlRecordCO.setBLCKL_LAST_NAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_LAST_NAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_LEGAL()))
			{
				controlRecordCO.setBLCKL_LEGAL(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_LEGAL(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_LNAME()))
			{
				controlRecordCO.setBLCKL_LNAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_LNAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_MOTHER_FNAME()))
			{
				controlRecordCO.setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_MOTHER_LNAME()))
			{
				controlRecordCO.setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_NATION()))
			{
				controlRecordCO.setBLCKL_NATION(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_NATION(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_REGION()))
			{
				controlRecordCO.setBLCKL_REGION(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_REGION(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_SEC_NAME()))
			{
				controlRecordCO.setBLCKL_SEC_NAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_SEC_NAME(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_THRD_NAME()))
			{
				controlRecordCO.setBLCKL_THRD_NAME(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.getCifControlVO().setBLCKL_THRD_NAME(BlackListControlRecordConstant.UNCHECKED);

			}
			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_REGNO()))
			{
				controlRecordCO.setBLCKL_REGNO(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_REGNO(BlackListControlRecordConstant.UNCHECKED);

			}

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN()))
			{
				controlRecordCO.setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.UNCHECKED);

			}
			//Hala Al Sheikh - BIPL180103
			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getBLCKL_TRX_NONFINANCE_YN()))
			{
				controlRecordCO.setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.CHECKED);
			}
			else
			{
				controlRecordCO.setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.UNCHECKED);
			}

		}
		// added by nour for bug #949789
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(controlRecordCO.getLoginCompCode());
		reqFieldSC.setBranchCode(controlRecordCO.getLoginBraCode());
		reqFieldSC.setProgRef(controlRecordCO.getProgRef());
		reqFieldSC.setAppName(controlRecordCO.getAppName());
		if (controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN()==null || controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.UNCHECKED) )
		{
			
			applyDynScreenDisplay(new String[] { "NameMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
					reqFieldSC);
		}
		
		if (controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN() != null)
		{
			if ((controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED))
					&& controlRecordCO.getCifControlVO().getAND_OR().equals(BlackListControlRecordConstant.AND))
			{

				applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ONE,
						controlRecordCO.getScreenParam(), reqFieldSC);
			}

			else if ((controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED))
					&& (controlRecordCO.getCifControlVO().getAND_OR().equals(BlackListControlRecordConstant.OR)))
			{
				applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
						controlRecordCO.getScreenParam(), reqFieldSC);
			}
			else
			{
				applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
						controlRecordCO.getScreenParam(), reqFieldSC);
			}
		}
		else
		{
			applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					controlRecordCO.getScreenParam(), reqFieldSC);
		}
		 
		// end bug #949789
		if (BigDecimal.ZERO.equals(dualParama)) // added by nour : status is invisible when dual param flag is unchecked
		{
			applyDynScreenDisplay(new String[] { "status_desc" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
					reqFieldSC);
			applyDynScreenDisplay(new String[] { "status_button" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
					reqFieldSC);
			
			
		}
		return controlRecordCO;
	}

	@Override
	public BlackListControlRecordCO saveNew(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		// SMART Save
		AuditRefCO refCO = controlRecordCO.getAuditRefCO();
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(controlRecordCO.getCifControlVO().getCOMP_CODE());
		smartSC.setBranchCode(controlRecordCO.getLoginBraCode());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartSC.setLanguage(controlRecordCO.getLanguage());
		
		NumberUtil.resetEmptyValues(controlRecordCO.getCifControlVO());

		smartBO.validateAndUpdateSmartDetails(controlRecordCO.getSmartCOList(), smartSC, controlRecordCO.getAuditRefCO(), controlRecordCO.getCifControlVO());
		if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(controlRecordCO.getCifControlVO().getCOMP_CODE()));

		}

		else
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(controlRecordCO.getCifControlVO().getCOMP_CODE());
		}
		if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
		{
			controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_ACTIVE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_APPROVED);
	
		}
		controlRecordCO.getCifControlVO().setCREATED_DATE(controlRecordCO.getRunningDate());
		controlRecordCO.getCifControlVO().setCREATED_BY(controlRecordCO.getLoginUserId());

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BDATE()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BDATE(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BDATE(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BPLACE()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BPLACE(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BPLACE(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_COUNTRY()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_COUNTRY(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_COUNTRY(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_FST_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_FST_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_FST_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_IDNO()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_IDNO(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_IDNO(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LAST_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LAST_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LAST_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LEGAL()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LEGAL(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LEGAL(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_MOTHER_FNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_MOTHER_LNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_NATION()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_NATION(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_NATION(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_REGION()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGION(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGION(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_SEC_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_SEC_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_SEC_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_THRD_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_THRD_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_THRD_NAME(BlackListControlRecordConstant.ZERO);

		}
		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_REGNO()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGNO(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGNO(BlackListControlRecordConstant.ZERO);

		}
		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN()))
		{
			controlRecordCO.getCifControlVO().setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.Y);
		}
		else
		{
			controlRecordCO.getCifControlVO().setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.N);

		}

		//Hala Al Sheikh - BIPL180103
		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_TRX_NONFINANCE_YN()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.Y);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.N);

		}
		
		Integer row = genericDAO.insert(controlRecordCO.getCifControlVO());

		// Audit for SAVE
		// audit save

		if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(controlRecordCO.getCifControlVO().getCOMP_CODE()));

		}

		else
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(controlRecordCO.getCifControlVO().getCOMP_CODE());
		}
		
		auditBO.callAudit(null, controlRecordCO.getCifControlVO(), controlRecordCO.getAuditRefCO());

		return controlRecordCO;
	}

	@Override
	public BlackListControlRecordCO updateControlRecord(BlackListControlRecordCO controlRecordCO)
			throws BaseException, com.path.lib.common.exception.BaseException
	{

		// SMART Save
		AuditRefCO refCO = controlRecordCO.getAuditRefCO();
		SmartSC smartSC = new SmartSC();
		smartSC.setAppName(refCO.getAppName());
		smartSC.setCompCode(controlRecordCO.getCifControlVO().getCOMP_CODE());
		smartSC.setBranchCode(controlRecordCO.getLoginBraCode());
		smartSC.setRunningDate(refCO.getRunningDate());
		smartSC.setUserId(refCO.getUserID());
		smartSC.setProgRef(refCO.getProgRef());
		smartSC.setLanguage(controlRecordCO.getLanguage());
		controlRecordCO.setMethod(BigDecimal.ONE);

		smartBO.validateAndUpdateSmartDetails(controlRecordCO.getSmartCOList(), smartSC, controlRecordCO.getAuditRefCO(), controlRecordCO.getCifControlVO());

		//Added By Lina for BUG#949796
		NumberUtil.resetEmptyValues(controlRecordCO.getCifControlVO());
		
		if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(controlRecordCO.getCifControlVO().getCOMP_CODE()));

		}

		else
		{
			controlRecordCO.getCifControlVO().setCOMP_CODE(controlRecordCO.getCifControlVO().getCOMP_CODE());
		}
		if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
		{
		controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_ACTIVE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_APPROVED);

		}
		controlRecordCO.getCifControlVO().setMODIFIED_BY(controlRecordCO.getLoginUserId());
		controlRecordCO.getCifControlVO().setMODIFIED_DATE(commonLibBO.addSystemTimeToDate(controlRecordCO.getRunningDate()));

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BDATE()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BDATE(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BDATE(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_BPLACE()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_BPLACE(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_BPLACE(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_COUNTRY()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_COUNTRY(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_COUNTRY(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_FST_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_FST_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_FST_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_IDNO()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_IDNO(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_IDNO(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LAST_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LAST_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LAST_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LEGAL()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LEGAL(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LEGAL(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_LNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_LNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_LNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_MOTHER_FNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_FNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_MOTHER_LNAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_MOTHER_LNAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_NATION()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_NATION(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_NATION(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_REGION()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGION(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGION(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_SEC_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_SEC_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_SEC_NAME(BlackListControlRecordConstant.ZERO);

		}

		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_THRD_NAME()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_THRD_NAME(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_THRD_NAME(BlackListControlRecordConstant.ZERO);

		}
		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_REGNO()))
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGNO(BlackListControlRecordConstant.ONE);
		}
		else
		{
			controlRecordCO.getCifControlVO().setBLCKL_REGNO(BlackListControlRecordConstant.ZERO);

		}
		if (BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN()))
		{
			controlRecordCO.getCifControlVO().setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.ONE);
		}
		else
		{
		    	controlRecordCO.getCifControlVO().setAPPLY_BLKLST_ON_WALKIN_CUST_YN(BlackListControlRecordConstant.ZERO);

        	}
               	// Hala Al Sheikh - BIPL180103
        	if(BlackListControlRecordConstant.CHECKED.equals(controlRecordCO.getBLCKL_TRX_NONFINANCE_YN()))
        	{
        	    	controlRecordCO.getCifControlVO().setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.Y);
        	}
        	else
        	{
        	    	controlRecordCO.getCifControlVO().setBLCKL_TRX_NONFINANCE_YN(BlackListControlRecordConstant.N);
        
        	}
		if (CoreCommonConstants.CRUD_MAINTENANCE.equals(controlRecordCO.getIvCrud())
				|| (CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(controlRecordCO.getIvCrud())
						&& !controlRecordCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.update(controlRecordCO.getCifControlVO());
			if (row1 == null || row1 < BlackListControlRecordConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

		}

		if ((CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(controlRecordCO.getIvCrud()) && controlRecordCO.getDualParam().equals(BigDecimal.ONE)))
		{
			Integer row1 = genericDAO.insert(controlRecordCO.getCifControlVO());
			if (row1 == null || row1 < BlackListControlRecordConstant.INT_ONE)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}

			if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
			{
				controlRecordCO.getCifControlVO().setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(controlRecordCO.getCifControlVO().getCOMP_CODE()));

			}

			Integer row2 = blackListControlRecordDAO.updateBlackListControlRecord(controlRecordCO);
			if (row2 == null || row1 < 1)
			{
				throw new BOException(MessageCodes.RECORD_CHANGED);
			}
		}

		BlackListControlRecordCO oldControlRecordCO = (BlackListControlRecordCO) controlRecordCO.getAuditObj();

		controlRecordCO.setOldCifControlVO(oldControlRecordCO.getCifControlVO());

		auditBO.callAudit(controlRecordCO.getOldCifControlVO(), controlRecordCO.getCifControlVO(), controlRecordCO.getAuditRefCO());
		auditBO.insertAudit(controlRecordCO.getAuditRefCO());

		TrackPropCO trackPropCO = auditBO.copyAuditProps(controlRecordCO.getAuditRefCO());
		trackPropCO.setCoInstanceName("controlRecordCO");
		trackPropCO.setVoMainPropRef("cifControlVO");
		trackPropCO.setTrackVoMainPropRef(true);
		trackPropCO.setVoPropertiesNames("");
		auditBO.callTrackChanges(oldControlRecordCO, controlRecordCO, trackPropCO);

		return controlRecordCO;
	}

	public BlackListControlRecordCO returnDepNameMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException
	{

		if (controlRecordCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC().intValue() < 0)
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_THAN_ZERO);
		}

		if (controlRecordCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC().compareTo(BlackListControlRecordConstant.MAX_PERC) > 0)
		{
			throw new BOException(MessageCodes.PERCENTAGE_CANNOT_BE_GREATER_THAN_100);

		}
		return controlRecordCO;

	}
	// added by nour for bug #949789
	public BlackListControlRecordCO returnDepNameWalkinMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException
	{

		if (controlRecordCO.getCifControlVO().getBLCKL_WALKIN_NAME_MATCH_PERC().intValue() < 0)
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_THAN_ZERO);
		}

		if (controlRecordCO.getCifControlVO().getBLCKL_WALKIN_NAME_MATCH_PERC().compareTo(BlackListControlRecordConstant.MAX_PERC) > 0)
		{
			throw new BOException(MessageCodes.PERCENTAGE_CANNOT_BE_GREATER_THAN_100);

		}
		return controlRecordCO;

	}

	public BlackListControlRecordCO returnDepCriteriaMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, BOException
	{

		if (controlRecordCO.getCifControlVO().getBLCKL_CRITERIA_MATCH_PERC().intValue() < 0)
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_THAN_ZERO);
		}

		if (controlRecordCO.getCifControlVO().getBLCKL_CRITERIA_MATCH_PERC().compareTo(BlackListControlRecordConstant.MAX_PERC) > 0)
		{
			throw new BOException(MessageCodes.PERCENTAGE_CANNOT_BE_GREATER_THAN_100);

		}
		return controlRecordCO;

	}

	public BlackListControlRecordCO approveControlRecord(BlackListControlRecordCO controlRecordCO)
			throws BaseException, com.path.lib.common.exception.BaseException
	{

		controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_APPROVED);
		controlRecordCO.getCifControlVO().setAPPROVED_BY(controlRecordCO.getLoginUserId());
		controlRecordCO.getCifControlVO().setAPPROVED_DATE(commonLibBO.addSystemTimeToDate(controlRecordCO.getRunningDate()));

		// audit

		int errorCode = 0;

		errorCode = commonLibBO.validateMakerChecker(controlRecordCO.getCifControlVO().getCREATED_BY(), controlRecordCO.getCifControlVO().getMODIFIED_BY(),
				controlRecordCO.getLoginUserId());

		if (errorCode > 0)
		{
			throw new BOException(errorCode);
		}
		controlRecordCO.applyTraceProps(controlRecordCO.getAppName(), controlRecordCO.getLoginUserId(), controlRecordCO.getProgRef());

		Integer row;

		row = blackListControlRecordDAO.approveControlRecord(controlRecordCO);

		if (row == null || row < 1)
		{
			throw new BOException(MessageCodes.RECORD_CHANGED);
		}
		// Update the row
		BlackListControlRecordCO oldCtlRecordCO = (BlackListControlRecordCO) controlRecordCO.getAuditObj();

		controlRecordCO.setOldCifControlVO(controlRecordCO.getCifControlVO());

		oldCtlRecordCO.setOldCifControlVO(oldCtlRecordCO.getCifControlVO());
		auditBO.callAudit(oldCtlRecordCO.getCifControlVO(), controlRecordCO.getCifControlVO(), controlRecordCO.getAuditRefCO());
		auditBO.insertAudit(controlRecordCO.getAuditRefCO());
		// Changes tracking TrackPropCO trackCO
		TrackPropCO trackCO = auditBO.copyAuditProps(controlRecordCO.getAuditRefCO());
		trackCO.setOperationType(AuditConstant.APPROVE); // the newCO shall
		// be null when we use this method upon // approve/reject.
		trackCO.setVoMainPropRef("cifControlVO");
		auditBO.callTrackChanges(oldCtlRecordCO, null, trackCO);

		return controlRecordCO;
	}

	public BlackListControlRecordCO deleteControlRecord(BlackListControlRecordCO controlRecordCO)
			throws BaseException, com.path.lib.common.exception.BaseException
	{
		controlRecordCO.setMethod(controlRecordCO.getMethod());
		controlRecordCO.setDualParam(controlRecordCO.getDualParam());
		BlackListControlRecordSC blackListControlRecordSC = new BlackListControlRecordSC();
		BlackListControlRecordCO newCO = new BlackListControlRecordCO();
		int errorCode = 0;
		if (BigDecimal.ONE.equals(controlRecordCO.getMethod())) // approve
		{
			errorCode = commonLibBO.validateMakerChecker(controlRecordCO.getCifControlVO().getCREATED_BY(), controlRecordCO.getCifControlVO().getMODIFIED_BY(),
					controlRecordCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}

			if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
			{
				blackListControlRecordDAO.deleteControlRecord(controlRecordCO);

			}

			// Update the row
			BlackListControlRecordCO oldControlRecordCO = (BlackListControlRecordCO) controlRecordCO.getAuditObj();

			controlRecordCO.setOldCifControlVO(controlRecordCO.getCifControlVO());

			oldControlRecordCO.setOldCifControlVO(oldControlRecordCO.getCifControlVO());
			auditBO.callAudit(oldControlRecordCO.getCifControlVO(), controlRecordCO.getCifControlVO(), controlRecordCO.getAuditRefCO());
			auditBO.insertAudit(controlRecordCO.getAuditRefCO());
		}
		else
		{
			// Update the row
			CIFCONTROLVO newVO = new CIFCONTROLVO();

			controlRecordCO.setCancelFlag(BigDecimal.ONE);
			newCO = blackListControlRecordDAO.returnData(controlRecordCO);

			newVO = newCO.getCifControlVO();
			BlackListControlRecordCO oldBlackListControlRecordCO = (BlackListControlRecordCO) controlRecordCO.getAuditObj();
			controlRecordCO.setOldCifControlVO(controlRecordCO.getCifControlVO());
			oldBlackListControlRecordCO.setOldCifControlVO(oldBlackListControlRecordCO.getCifControlVO());
			CIFCONTROLVO blackListControlRecordVO = new CIFCONTROLVO();

			blackListControlRecordVO.setCOMP_CODE(controlRecordCO.getLoginCompCode());

			controlRecordCO.getAuditRefCO().setTrxNbr(auditBO.checkAuditKey(blackListControlRecordVO, controlRecordCO.getAuditRefCO()));
			auditBO.callAudit(controlRecordCO.getCifControlVO(), newVO, controlRecordCO.getAuditRefCO());

			errorCode = commonLibBO.validateMakerChecker(controlRecordCO.getCifControlVO().getCREATED_BY(), controlRecordCO.getCifControlVO().getMODIFIED_BY(),
					controlRecordCO.getLoginUserId());

			if (errorCode > 0)
			{
				throw new BOException(errorCode);
			}
			if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
			{
				blackListControlRecordDAO.deleteControlRecord(controlRecordCO);

				// update the status of the positive record
				controlRecordCO.getCifControlVO().setCOMP_CODE(controlRecordCO.getCifControlVO().getCOMP_CODE());
				controlRecordCO.getCifControlVO().setENTITY_STATUS(BlackListControlRecordConstant.STATUS_APPROVED);

				Integer row1 = blackListControlRecordDAO.updateBlackListControlRecord(controlRecordCO);
				if (row1 == null || row1 < 1)
				{
					throw new BOException(MessageCodes.RECORD_CHANGED);
				}

			}
			else
			{
				genericDAO.update(controlRecordCO.getCifControlVO());

			}

			NumberUtil.resetEmptyValues(controlRecordCO.getCifControlVO());
			auditBO.callAudit(((BlackListControlRecordCO) controlRecordCO.getAuditObj()).getCifControlVO(), controlRecordCO.getCifControlVO(),
					controlRecordCO.getAuditRefCO());
			auditBO.insertAudit(controlRecordCO.getAuditRefCO());
		}
		return controlRecordCO;

	}

	public BlackListControlRecordDAO getBlackListControlRecordDAO()
	{
		return blackListControlRecordDAO;
	}

	public void setBlackListControlRecordDAO(BlackListControlRecordDAO blackListControlRecordDAO)
	{
		this.blackListControlRecordDAO = blackListControlRecordDAO;
	}

	@Override
	public BigDecimal getDualParam(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		S_APPVO sAppVO = new S_APPVO();
		sAppVO.setAPP_NAME(controlRecordCO.getAppName());
		return commonLibBO.returnApplicationDetails(sAppVO).getDUAL_PARAM();
	}

	// added by nour for bug #949789	
	public BlackListControlRecordCO returnDepWalkinNameMatch(BlackListControlRecordCO controlRecordCO) throws BaseException, com.path.lib.common.exception.BaseException
	{
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(controlRecordCO.getLoginCompCode());
		reqFieldSC.setBranchCode(controlRecordCO.getLoginBraCode());
		reqFieldSC.setProgRef(controlRecordCO.getProgRef());
		reqFieldSC.setAppName(controlRecordCO.getAppName());
		if(controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED))
		{
			applyDynScreenDisplay(new String[] { "NameMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ONE,
					controlRecordCO.getScreenParam(), reqFieldSC);
		}
		else
		{
			applyDynScreenDisplay(new String[] { "NameMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO,
					controlRecordCO.getScreenParam(), reqFieldSC);
		}
		if (controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED) &&controlRecordCO.getCifControlVO().getAND_OR().equals(BlackListControlRecordConstant.AND))
		{
			applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ONE, controlRecordCO.getScreenParam(),
					reqFieldSC);
			
		}
		else
		{
			applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
					reqFieldSC);
		}

		return controlRecordCO;
	}

	@Override
	public BlackListControlRecordCO returnDepAndOr(BlackListControlRecordCO controlRecordCO)
			throws BaseException, BOException, com.path.lib.common.exception.BaseException
	{
		RequiredFieldsSC reqFieldSC = new RequiredFieldsSC();
		reqFieldSC.setCompCode(controlRecordCO.getLoginCompCode());
		reqFieldSC.setBranchCode(controlRecordCO.getLoginBraCode());
		reqFieldSC.setProgRef(controlRecordCO.getProgRef());
		reqFieldSC.setAppName(controlRecordCO.getAppName());
		if (controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN()!=null)
		{
			if (controlRecordCO.getCifControlVO().getAND_OR().equals(BlackListControlRecordConstant.AND)&& controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED))
			{
				applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ONE, controlRecordCO.getScreenParam(),
						reqFieldSC);
				
			}
			else if (controlRecordCO.getCifControlVO().getAND_OR().equals(BlackListControlRecordConstant.OR)&& controlRecordCO.getAPPLY_BLKLST_ON_WALKIN_CUST_YN().equals(BlackListControlRecordConstant.CHECKED))
			{
				applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
						reqFieldSC);
			}
		}
		else
		{
			applyDynScreenDisplay(new String[] { "criteriaMatch1" }, ConstantsCommon.ACTION_TYPE_VISIBLE, BlackListSourceConstant.ZERO, controlRecordCO.getScreenParam(),
					reqFieldSC);
			
		}
		return controlRecordCO;
	}

	@Override
	public BlackListControlRecordCO returnDepWalkinCriteriaMatch(BlackListControlRecordCO controlRecordCO)
			throws BaseException, BOException, com.path.lib.common.exception.BaseException
	{
		if (controlRecordCO.getCifControlVO().getBLCKL_WALKIN_CRIT_MATCH_PERC().intValue() < 0)
		{
			throw new BOException(MessageCodes.CANNOT_BE_LESS_THAN_ZERO);
		}

		if (controlRecordCO.getCifControlVO().getBLCKL_WALKIN_CRIT_MATCH_PERC().compareTo(BlackListControlRecordConstant.MAX_PERC) > 0)
		{
			throw new BOException(MessageCodes.PERCENTAGE_CANNOT_BE_GREATER_THAN_100);

		}
		return controlRecordCO;
	}
// end bug #949789
}
