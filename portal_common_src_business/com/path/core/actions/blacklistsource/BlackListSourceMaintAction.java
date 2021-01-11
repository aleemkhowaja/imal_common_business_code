package com.path.core.actions.blacklistsource;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistsource.BlackListSourceBO;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.blacklistsource.BlackListSourceCO;
import com.path.vo.core.blacklistsource.BlackListSourceSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListSourceMaintAction.java used to
 */
public class BlackListSourceMaintAction extends BaseAction
{

	private BlackListSourceBO blackListSourceBO;
	private BlackListSourceCO blackListSourceCO = new BlackListSourceCO();
	private BlackListSourceSC blackListSourceSC = new BlackListSourceSC();
	private ArrayList<SmartCO> smartCOList;

	/**
	 * make a loop on the list names to generate them
	 */

	private List<SelectCO> languagesList = new ArrayList<SelectCO>();

	public String loadBlackListSourcePage() throws BaseException
	{
		try
		{
			fillSessionCO();

			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));

			if (BigDecimal.ZERO.equals(blackListSourceCO.getDualParam()) && (
					(CoreCommonConstants.CRUD_CANCEL.equals(blackListSourceCO.getIvCrud())||
					(CoreCommonConstants.CRUD_APPROVE.equals(blackListSourceCO.getIvCrud())))||
					(CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListSourceCO.getIvCrud()))))// added by nour: add condition when dual param flag is unchecked 
			{
				throw new BOException(MessageCodes.DUAL_PARAM_NOT_CHECKED);
			}

			blackListSourceCO = blackListSourceBO.initializeData(blackListSourceCO);
			setAdditionalScreenParams(blackListSourceCO.getBuisnessElement());

			set_searchGridId("blackListSourceListGridTbl_Id");
			if ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())))
			{
				set_showNewInfoBtn("true");
				set_enableAudit(true);
				set_showSmartInfoBtn("true");

			}
			if (getIv_crud().equalsIgnoreCase("P"))
			{
				set_showTrackChngBtn("true");

			}
		}
		catch(Exception ex)
		{
		    handleException(ex, null, null);
		    return ERROR_ACTION;
		}
		return "blackListSourceList";
	}

	/**
	 * FILL THE FORM FROM DATABASE (RETREIVE DATA).
	 */
	public String loadRecords()
	{
		try
		{
			fillSessionVariables();
			fillSessionCO();
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));
			blackListSourceSC.setDualParam(blackListSourceCO.getDualParam());

			// load data
			blackListSourceCO = blackListSourceBO.returnBlackListSource(blackListSourceSC);
			fillSessionCO();
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));
			getAdditionalScreenParams().putAll(blackListSourceCO.getScreenParam());
			if (blackListSourceCO.getDualParam().equals(BigDecimal.ONE)&&(CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())
					&& CoreCommonConstants.STATUS_APPROVED.equals(blackListSourceCO.getBlackSourceVO().getENTITY_STATUS()))
					|| (CoreCommonConstants.CRUD_APPROVE.equals(getIv_crud())) || (CoreCommonConstants.CRUD_CANCEL.equals(getIv_crud()))
					|| ((BlackListSourceConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud()))
							&& (StringUtil.isEmptyString(blackListSourceCO.getBlackSourceVO().getENTITY_STATUS())))

			)
			{
				set_recReadOnly("true");
			}

			if (getIv_crud().equalsIgnoreCase(CoreCommonConstants.CRUD_MAINTENANCE)
					&& CoreCommonConstants.STATUS_DELETED.equals(blackListSourceCO.getBlackSourceVO().getENTITY_STATUS()))
			{
				set_recReadOnly("true");
			}
			fillSessionCO();

			applyRetrieveAudit(AuditConstant.BLACK_LIST_SOURCE_KEY_REF, blackListSourceCO.getBlackSourceVO(), blackListSourceCO);
			AuditRefCO refCO = initAuditRefCO();
			refCO.setTrxNbr(getAuditTrxNbr());
			applyChangesHighlights(refCO);

		}

		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "blackListSourceMaint";
	}

	/**
	 * reloads the page on new btn clicked
	 */
	public String reload() throws BaseException
	{
		try
		{
			loadBlackListSourcePage();
		}
		catch (Exception e)
		{
			handleException(e, null, null);
			return ERROR_ACTION;
		}
		return "blackListSourceMaint";
	}

	public String deleteRecord() throws BaseException
	{
		try
		{

			NumberUtil.resetEmptyValues(blackListSourceCO);
			fillSessionCO();
			fillSessionVariables();
			blackListSourceCO.setDelete(BigDecimal.ONE);
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_SOURCE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListSourceCO.setAuditRefCO(refCO);
			blackListSourceCO.setAuditObj(returnAuditObject(blackListSourceCO.getClass()));

			blackListSourceBO.deleteRecord(blackListSourceCO, refCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}

		return SUCCESS;
	}

	public String approveBlackListSource() throws BaseException
	{
		try
		{
			NumberUtil.resetEmptyValues(blackListSourceCO);
			fillSessionCO();
			fillSessionVariables();

			blackListSourceCO.setMethod(BigDecimal.ONE);
			// smart
			blackListSourceCO.setSmartCOList(smartCOList);

			// CALL AUDIT FOR APPROVE.
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_SOURCE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListSourceCO.setAuditRefCO(refCO);
			blackListSourceCO.setAuditObj(returnAuditObject(blackListSourceCO.getClass()));
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));

			if (BigDecimal.ONE.equals(blackListSourceCO.getDualParam()))
			{

				blackListSourceCO = blackListSourceBO.deleteBlackListSource(blackListSourceCO);
			}
			blackListSourceCO = blackListSourceBO.approveBlackListSource(blackListSourceCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String cancel() throws BaseException
	{
		try
		{ // smart
			blackListSourceCO.setSmartCOList(smartCOList);

			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_SOURCE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListSourceCO.setAuditRefCO(refCO);
			blackListSourceCO.setAuditObj(returnAuditObject(blackListSourceCO.getClass()));

			SessionCO sessionCO = returnSessionObject();
			blackListSourceCO.getBlackSourceVO().setCOMP_CODE(sessionCO.getCompanyCode());
			fillSessionCO();
			blackListSourceCO.getBlackSourceVO().setCODE(blackListSourceCO.getBlackSourceVO().getCODE());
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));
			blackListSourceCO.setIvCrud(getIv_crud());
			blackListSourceCO.setMethod(CoreCommonConstants.TWO);

			blackListSourceCO = blackListSourceBO.deleteBlackListSource(blackListSourceCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String dependencyByCifCode() throws JSONException
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();
			fillSessionCO();

			if (NumberUtil.isEmptyDecimal(blackListSourceCO.getBlackSourceVO().getCIF_NO()))
			{
				blackListSourceCO = new BlackListSourceCO();
			}
			else
			{
				blackListSourceCO = blackListSourceBO.returnDepByCifCode(blackListSourceCO);
				

			}

		}
		catch (Exception e)
		{
			blackListSourceCO.getBlackSourceVO().setCIF_NO(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	/**
	 * Save
	 **/

	public String saveBlackListSource() throws BaseException
	{
		try
		{
			fillSessionCO();
			fillSessionVariables();
			blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));

			// smart
			blackListSourceCO.setSmartCOList(smartCOList);
			// audit
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.CREATED);
			refCO.setKeyRef(AuditConstant.BLACK_LIST_SOURCE_KEY_REF);
			blackListSourceCO.setAuditRefCO(refCO);

			blackListSourceCO = blackListSourceBO.saveBlackListSource(blackListSourceCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String updateBlackListSource() throws BaseException, com.path.lib.common.exception.BaseException
	{
       try
       {
		AuditRefCO refCO = initAuditRefCO();
		refCO.setOperationType(AuditConstant.UPDATE);
		refCO.setKeyRef(AuditConstant.BLACK_LIST_SOURCE_KEY_REF);
		refCO.setTrxNbr(getAuditTrxNbr());
		fillSessionVariables();

		// smart
		blackListSourceCO.setSmartCOList(smartCOList);

		blackListSourceCO.setAuditRefCO(refCO);
		blackListSourceCO.setAuditObj(returnAuditObject(blackListSourceCO.getClass()));

		fillSessionCO();
		blackListSourceCO.setDualParam(blackListSourceBO.getDualParam(blackListSourceCO));

		blackListSourceCO = blackListSourceBO.updateBlackListSource(blackListSourceCO);
       }
       catch (Exception ex)
		{
			handleException(ex, null, null);
		}
       
		return SUCCESS;
	}

	/**
	 * fill variables in CO
	 */
	public void fillSessionCO() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		blackListSourceCO.getBlackSourceVO().setCOMP_CODE(sessionCO.getCompanyCode());
		blackListSourceCO.setBranch(sessionCO.getBranchCode());
		blackListSourceCO.setAppName(sessionCO.getCurrentAppName());
		blackListSourceCO.setLanguage(sessionCO.getLanguage());
		blackListSourceCO.setOpt(get_pageRef());
		blackListSourceCO.setLoginUserId(sessionCO.getUserName());
		blackListSourceCO.setIvCrud(getIv_crud());
		blackListSourceCO.setProgRef(get_pageRef());
		blackListSourceCO.setRunningDate(sessionCO.getRunningDateRET());

	}

	/**
	 * fill variables
	 */
	public void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		blackListSourceSC.setCompCode(sessionCO.getCompanyCode());
		blackListSourceSC.setLanguage(sessionCO.getLanguage());
		blackListSourceSC.setAppName(sessionCO.getCurrentAppName());
		blackListSourceSC.setProgRef(get_pageRef());
		blackListSourceSC.setIvCrud(getIv_crud());
		blackListSourceSC.setRunningDate(sessionCO.getRunningDateRET());
		blackListSourceSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);
		blackListSourceSC.setIsRTLDir(sessionCO.getIsRTLDir());

	}

	public void setBlackListSourceBO(BlackListSourceBO blackListSourceBO)
	{
		this.blackListSourceBO = blackListSourceBO;
	}

	public BlackListSourceCO getBlackListSourceCO()
	{
		return blackListSourceCO;
	}

	public void setBlackListSourceCO(BlackListSourceCO blackListSourceCO)
	{
		this.blackListSourceCO = blackListSourceCO;
	}

	public BlackListSourceSC getBlackListSourceSC()
	{
		return blackListSourceSC;
	}

	public void setBlackListSourceSC(BlackListSourceSC blackListSourceSC)
	{
		this.blackListSourceSC = blackListSourceSC;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

	public List<SelectCO> getLanguagesList()
	{
		return languagesList;
	}

	public void setLanguagesList(List<SelectCO> languagesList)
	{
		this.languagesList = languagesList;
	}

}
