package com.path.core.actions.blacklistcontrolrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordBO;
import com.path.bo.core.blacklistcontrolrecord.BlackListControlRecordConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.blacklistcontrolrecord.BlackListControlRecordCO;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ControlRecordMaintAction.java used to
 */
public class BlackListControlRecordMaintAction extends BaseAction
{

	private BlackListControlRecordBO blackListControlRecordBO;
	private BlackListControlRecordCO controlRecordCO = new BlackListControlRecordCO();
	private List<SelectCO> andOrDropDown = new ArrayList<SelectCO>();
	private ArrayList<SmartCO> smartCOList;

	/**
	 * make a loop on the list names to generate them
	 */

	private List<SelectCO> languagesList = new ArrayList<SelectCO>();

	public List<SelectCO> getLanguagesList()
	{
		return languagesList;
	}

	public void setLanguagesList(List<SelectCO> languagesList)
	{
		this.languagesList = languagesList;
	}

	public String loadControlRecordPage()
	{
		try
		{
			fillSessionCO();

			controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));

			if (BigDecimal.ZERO.equals(controlRecordCO.getDualParam()) && ((CoreCommonConstants.CRUD_CANCEL.equals(controlRecordCO.getIvCrud())) ||
					(CoreCommonConstants.CRUD_APPROVE.equals(controlRecordCO.getIvCrud()))||
					CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(controlRecordCO.getIvCrud())))// added by nour : add condition when the dual param flag is unchecked
			{
				throw new BOException(MessageCodes.DUAL_PARAM_NOT_CHECKED);
			}
			
			if ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())))
			{
				// show audit button
				set_enableAudit(true);
			    set_showSmartInfoBtn("true");

			}
			
			if (getIv_crud().equalsIgnoreCase("P"))
			{
				set_showTrackChngBtn("true");

			}
			
			fillSessionCO();
			// load data from DB and call visibility method

			controlRecordCO = blackListControlRecordBO.loadData(controlRecordCO);
			fillSessionCO();
			getAdditionalScreenParams().putAll(controlRecordCO.getScreenParam());
			controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));
			initList();
			if (controlRecordCO.getDualParam().equals(BigDecimal.ONE)&& ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())
					&& CoreCommonConstants.STATUS_APPROVED.equals(controlRecordCO.getCifControlVO().getENTITY_STATUS()))
					|| (CoreCommonConstants.CRUD_APPROVE.equals(getIv_crud())) || (CoreCommonConstants.CRUD_CANCEL.equals(getIv_crud()))
					|| ((BlackListControlRecordConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud()))
							&& (StringUtil.isEmptyString(controlRecordCO.getCifControlVO().getENTITY_STATUS())))))
			{
				set_recReadOnly("true");
			}
			
			fillSessionCO();

			if (!BlackListControlRecordConstant.ONE.equals(controlRecordCO.getSaveUpdateFlag()) )
			{
				applyRetrieveAudit(AuditConstant.CONTROL_RECORD_KEY_REF, controlRecordCO.getCifControlVO(), controlRecordCO);
			
				AuditRefCO refCO = initAuditRefCO();
			
				refCO.setTrxNbr(getAuditTrxNbr());
				applyChangesHighlights(refCO);

			}
		}
		catch (

			Exception ex
		)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "controlRecordMaint";
	}

	public String initList()
	{
		try
		{

			SelectSC selSC = new SelectSC(BlackListControlRecordConstant.andOnList);

			setAndOrDropDown(returnLOV(selSC));

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;

	}

	public String saveBlackListControlRecord()
	{
		try
		{

			fillSessionCO();
			controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));

			SessionCO sessionCO = returnSessionObject();
			controlRecordCO.getCifControlVO().setCOMP_CODE(sessionCO.getCompanyCode());

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			controlRecordCO.setAuditRefCO(refCO);

			if (BlackListControlRecordConstant.ONE.equals(controlRecordCO.getSaveUpdateFlag())) // on new
			{
				refCO.setOperationType(AuditConstant.CREATED);
				controlRecordCO = blackListControlRecordBO.saveNew(controlRecordCO);
			}
			else
			// retrieve
			{

				refCO.setOperationType(AuditConstant.UPDATE);
				controlRecordCO.setAuditObj(returnAuditObject(controlRecordCO.getClass()));
				refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
				refCO.setTrxNbr(getAuditTrxNbr());
				controlRecordCO.setAuditRefCO(refCO);
				// smart
				controlRecordCO.setSmartCOList(smartCOList);

				controlRecordCO.setAuditRefCO(refCO);

				fillSessionCO();

				controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));

				controlRecordCO = blackListControlRecordBO.updateControlRecord(controlRecordCO);
			}

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String approveControlRecord() throws BaseException
	{
		try
		{
			//NumberUtil.resetEmptyValues(controlRecordCO);
			fillSessionCO();
			controlRecordCO.setMethod(BigDecimal.ONE);

			controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));

			// smart
			controlRecordCO.setSmartCOList(smartCOList);

			// CALL AUDIT FOR APPROVE.
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.UPDATE);
			controlRecordCO.setAuditObj(returnAuditObject(controlRecordCO.getClass()));
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			refCO.setTrxNbr(getAuditTrxNbr());
			controlRecordCO.setAuditRefCO(refCO);

			if (BigDecimal.ONE.equals(controlRecordCO.getDualParam()))
			{

				controlRecordCO = blackListControlRecordBO.deleteControlRecord(controlRecordCO);
			}

			controlRecordCO = blackListControlRecordBO.approveControlRecord(controlRecordCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}
	
	public String dependencyByCriteriaMatch() throws JSONException
	{
		try
		{
			fillSessionCO();
			if (NumberUtil.isEmptyDecimal(controlRecordCO.getCifControlVO().getBLCKL_CRITERIA_MATCH_PERC()))
			{
				controlRecordCO.getCifControlVO().setBLCKL_CRITERIA_MATCH_PERC(null);
			}
			else
			{
				controlRecordCO = blackListControlRecordBO.returnDepCriteriaMatch(controlRecordCO);

			}

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setBLCKL_CRITERIA_MATCH_PERC(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	// added by nour for bug #949789
	public String dependencyByCriteriaMatch1() throws JSONException
	{
		try
		{
			fillSessionCO();
			if (NumberUtil.isEmptyDecimal(controlRecordCO.getCifControlVO().getBLCKL_WALKIN_CRIT_MATCH_PERC()))
			{
				controlRecordCO.getCifControlVO().setBLCKL_WALKIN_CRIT_MATCH_PERC(null);
			}
			else
			{
				controlRecordCO = blackListControlRecordBO.returnDepWalkinCriteriaMatch(controlRecordCO);

			}

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setBLCKL_WALKIN_CRIT_MATCH_PERC(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}


	public String dependencyByNameMatch() throws JSONException
	{
		try
		{
			fillSessionCO();
			if (NumberUtil.isEmptyDecimal(controlRecordCO.getCifControlVO().getBLCKL_NAME_MATCH_PERC()))
			{
				controlRecordCO.getCifControlVO().setBLCKL_NAME_MATCH_PERC(null);
			}
			else
			{
				controlRecordCO = blackListControlRecordBO.returnDepNameMatch(controlRecordCO);

			}

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setBLCKL_NAME_MATCH_PERC(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	
	public String dependencyByApplyBlackList() throws JSONException
	{
		try
		{
			fillSessionCO();
			String andOr= controlRecordCO.getCifControlVO().getAND_OR();
			controlRecordCO = blackListControlRecordBO.returnDepWalkinNameMatch(controlRecordCO);
			getAdditionalScreenParams().putAll(controlRecordCO.getScreenParam());
			controlRecordCO.getCifControlVO().setBLCKL_WALKIN_CRIT_MATCH_PERC(null);
			controlRecordCO.getCifControlVO().setBLCKL_WALKIN_NAME_MATCH_PERC(null);

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setAPPLY_BLKLST_ON_WALKIN_CUST_YN(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	// added by nour for bug #949789
	public String dependencyByAndOr() throws JSONException
	{
		try
		{
			fillSessionCO();
			controlRecordCO = blackListControlRecordBO.returnDepAndOr(controlRecordCO);
			getAdditionalScreenParams().putAll(controlRecordCO.getScreenParam());

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setBLCKL_NAME_MATCH_PERC(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	
	// added by nour for bug #949789
	public String dependencyByNameMatch1() throws JSONException
	{
		try
		{
			fillSessionCO();
			if (NumberUtil.isEmptyDecimal(controlRecordCO.getCifControlVO().getBLCKL_WALKIN_NAME_MATCH_PERC()))
			{
				controlRecordCO.getCifControlVO().setBLCKL_WALKIN_NAME_MATCH_PERC(null);
			}
			else
			{
				controlRecordCO = blackListControlRecordBO.returnDepNameWalkinMatch(controlRecordCO);

			}

		}
		catch (Exception e)
		{
			controlRecordCO.getCifControlVO().setBLCKL_WALKIN_NAME_MATCH_PERC(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}
	
	

	/**
	 * reloads the page on new btn clicked
	 */
	public String reload() throws BaseException
	{
		try
		{
			loadControlRecordPage();
		}
		catch (Exception e)
		{
			handleException(e, null, null);
			return ERROR_ACTION;
		}
		return "controlRecordMaint";
	}

	public String cancel() throws BaseException
	{
		try
		{
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			controlRecordCO.setAuditRefCO(refCO);
			controlRecordCO.setAuditObj(returnAuditObject(controlRecordCO.getClass()));

			SessionCO sessionCO = returnSessionObject();
			controlRecordCO.getCifControlVO().setCOMP_CODE(sessionCO.getCompanyCode());
			fillSessionCO();
			controlRecordCO.setDualParam(blackListControlRecordBO.getDualParam(controlRecordCO));
			controlRecordCO.setIvCrud(getIv_crud());
			controlRecordCO.setMethod(CoreCommonConstants.TWO);

			controlRecordCO = blackListControlRecordBO.deleteControlRecord(controlRecordCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	/**
	 *  
	 */
	/**
	 * fill Variables from Session
	 * 
	 * @throws BaseException
	 */
	public void fillSessionCO() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		controlRecordCO.getCifControlVO().setCOMP_CODE(sessionCO.getCompanyCode());
		controlRecordCO.setLanguage(sessionCO.getLanguage());
		controlRecordCO.setLoginUserId(sessionCO.getUserName());
		controlRecordCO.setProgRef(get_pageRef());
		controlRecordCO.setOpt(get_pageRef());
		controlRecordCO.setAppName(sessionCO.getCurrentAppName());
		controlRecordCO.setRunningDate(sessionCO.getRunningDateRET());
		controlRecordCO.setLovTypeId(BlackListControlRecordConstant.LOV_TYPE);
		controlRecordCO.setIsRTLDir(sessionCO.getIsRTLDir());
		controlRecordCO.setIvCrud(getIv_crud());
		controlRecordCO.setLoginBraCode(sessionCO.getBranchCode());

	}

	public void setBlackListControlRecordBO(BlackListControlRecordBO blackListControlRecordBO)
	{
		this.blackListControlRecordBO = blackListControlRecordBO;
	}

	public BlackListControlRecordCO getControlRecordCO()
	{
		return controlRecordCO;
	}

	public void setControlRecordCO(BlackListControlRecordCO controlRecordCO)
	{
		this.controlRecordCO = controlRecordCO;
	}

	public List<SelectCO> getAndOrDropDown()
	{
		return andOrDropDown;
	}

	public void setAndOrDropDown(List<SelectCO> andOrDropDown)
	{
		this.andOrDropDown = andOrDropDown;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

}
