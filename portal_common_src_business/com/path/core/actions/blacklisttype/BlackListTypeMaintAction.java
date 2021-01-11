package com.path.core.actions.blacklisttype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.blacklistsource.BlackListSourceConstant;
import com.path.bo.core.blacklisttype.BlackListTypeBO;
import com.path.bo.core.blacklisttype.BlackListTypeConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.blacklisttype.BlackListTypeCO;
import com.path.vo.core.blacklisttype.BlackListTypeSC;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * BlackListTypeMaintAction.java used to
 */
public class BlackListTypeMaintAction extends RetailBaseAction
{

	private BlackListTypeBO blackListTypeBO;
	private List<SelectCO> revisionBasisDropDown = new ArrayList<SelectCO>();
	private BlackListTypeCO blackListTypeCO = new BlackListTypeCO();
	private BlackListTypeSC blackListTypeSC = new BlackListTypeSC();
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

			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));

			if (BigDecimal.ZERO.equals(blackListTypeCO.getDualParam()) && (CoreCommonConstants.CRUD_CANCEL.equals(blackListTypeCO.getIvCrud())
					|| CoreCommonConstants.CRUD_APPROVE.equals(blackListTypeCO.getIvCrud())
					|| CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(blackListTypeCO.getIvCrud()))) // added by nour: add condition when dual param flag is unchecked 
			{
				throw new BOException(MessageCodes.DUAL_PARAM_NOT_CHECKED);
			}
			blackListTypeCO = blackListTypeBO.initializeData(blackListTypeCO);
			setAdditionalScreenParams(blackListTypeCO.getBuisnessElement());

			set_searchGridId("blackListTypeListGridTbl_Id");
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
			initList();
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "blackListTypeList";
	}

	public String initList()
	{
		try
		{

			SelectSC selSC = new SelectSC(BlackListTypeConstant.revisionBasisList);

			setRevisionBasisDropDown(returnLOV(selSC));

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}
		return SUCCESS;

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
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));
			blackListTypeSC.setDualParam(blackListTypeCO.getDualParam());

			// load data
			blackListTypeCO = blackListTypeBO.returnBlackListType(blackListTypeSC);
			getAdditionalScreenParams().putAll(blackListTypeCO.getScreenParam());
			fillSessionCO();
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));
			initList();
			if (blackListTypeCO.getDualParam().equals(BigDecimal.ONE) && (CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())
					&& CoreCommonConstants.STATUS_APPROVED.equals(blackListTypeCO.getMosBlackListTypeVO().getENTITY_STATUS()))
					|| (CoreCommonConstants.CRUD_APPROVE.equals(getIv_crud())) || (CoreCommonConstants.CRUD_CANCEL.equals(getIv_crud()))
					|| ((BlackListTypeConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud()))
							&& (StringUtil.isEmptyString(blackListTypeCO.getMosBlackListTypeVO().getENTITY_STATUS())))
					|| (CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud())
							&& CoreCommonConstants.STATUS_DELETED.equals(blackListTypeCO.getMosBlackListTypeVO().getENTITY_STATUS())))
			{
				set_recReadOnly("true");
			}

			fillSessionCO();

			applyRetrieveAudit(AuditConstant.BLACK_LIST_TYPE_KEY_REF, blackListTypeCO.getMosBlackListTypeVO(), blackListTypeCO);
			AuditRefCO refCO = initAuditRefCO();
			refCO.setTrxNbr(getAuditTrxNbr());
			applyChangesHighlights(refCO);

		}

		catch (Exception ex)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}
		return "blackListTypeMaint";
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
		return "blackListTypeMaint";
	}

	/**
	 * Save
	 **/

	public String saveBlackListType() throws BaseException
	{
		try
		{
			fillSessionCO();
			fillSessionVariables();
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));

			// smart
			blackListTypeCO.setSmartCOList(smartCOList);

			// audit
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.CREATED);
			refCO.setKeyRef(AuditConstant.BLACK_LIST_TYPE_KEY_REF);
			blackListTypeCO.setAuditRefCO(refCO);

			blackListTypeCO = blackListTypeBO.saveBlackListType(blackListTypeCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String updateBlackListType() throws BaseException, com.path.lib.common.exception.BaseException
	{
		try
		{

			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setKeyRef(AuditConstant.BLACK_LIST_TYPE_KEY_REF);
			refCO.setTrxNbr(getAuditTrxNbr());
			fillSessionVariables();

			// smart
			blackListTypeCO.setSmartCOList(smartCOList);

			blackListTypeCO.setAuditRefCO(refCO);
			blackListTypeCO.setAuditObj(returnAuditObject(blackListTypeCO.getClass()));

			fillSessionCO();
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));

			blackListTypeCO = blackListTypeBO.updateBlackListType(blackListTypeCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}

		return SUCCESS;
	}

	public String deleteRecord() throws BaseException
	{
		try
		{

			NumberUtil.resetEmptyValues(blackListTypeCO);
			fillSessionCO();
			fillSessionVariables();
			blackListTypeCO.setDelete(BigDecimal.ONE);
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_TYPE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListTypeCO.setAuditRefCO(refCO);
			blackListTypeCO.setAuditObj(returnAuditObject(blackListTypeCO.getClass()));

			blackListTypeBO.deleteRecord(blackListTypeCO, refCO);

		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}

		return SUCCESS;
	}

	public String approveBlackListType() throws BaseException
	{
		try
		{
			NumberUtil.resetEmptyValues(blackListTypeCO);
			fillSessionCO();
			fillSessionVariables();

			blackListTypeCO.setMethod(BigDecimal.ONE);
			// smart
			blackListTypeCO.setSmartCOList(smartCOList);

			// CALL AUDIT FOR APPROVE.
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_TYPE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListTypeCO.setAuditRefCO(refCO);
			blackListTypeCO.setAuditObj(returnAuditObject(blackListTypeCO.getClass()));
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));

			if (BigDecimal.ONE.equals(blackListTypeCO.getDualParam()))
			{

				blackListTypeCO = blackListTypeBO.deleteBlackListType(blackListTypeCO);
			}
			blackListTypeCO = blackListTypeBO.approveBlackListType(blackListTypeCO);

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
		{

			SessionCO sessionCO = returnSessionObject();
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.BLACK_LIST_TYPE_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			blackListTypeCO.setAuditRefCO(refCO);
			blackListTypeCO.setAuditObj(returnAuditObject(blackListTypeCO.getClass()));
			blackListTypeCO.getMosBlackListTypeVO().setCOMP_CODE(sessionCO.getCompanyCode());
			fillSessionCO();
			blackListTypeCO.getMosBlackListTypeVO().setCODE(blackListTypeCO.getMosBlackListTypeVO().getCODE());
			blackListTypeCO.setDualParam(blackListTypeBO.getDualParam(blackListTypeCO));
			blackListTypeCO.setIvCrud(getIv_crud());
			blackListTypeCO.setMethod(CoreCommonConstants.TWO);

			blackListTypeCO = blackListTypeBO.deleteBlackListType(blackListTypeCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String dependencyByCode() throws JSONException
	{
		try
		{
			fillSessionCO();

			if (NumberUtil.isEmptyDecimal(blackListTypeCO.getMosBlackListTypeVO().getCODE()))
			{
				blackListTypeCO = new BlackListTypeCO();
			}
			else
			{
				blackListTypeCO = blackListTypeBO.returnDepByCode(blackListTypeCO);

			}

		}
		catch (Exception e)
		{
			blackListTypeCO.getMosBlackListTypeVO().setCODE(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	public String dependencyByRevisionBasis() throws JSONException
	{
		try
		{

			if (blackListTypeCO.getMosBlackListTypeVO().getREVISION_BASIS() == null)
			{
				blackListTypeCO = new BlackListTypeCO();
			}
			else
			{
				blackListTypeCO = blackListTypeBO.returnDepRevBasis(blackListTypeCO);

			}

		}
		catch (Exception e)
		{
			blackListTypeCO.getMosBlackListTypeVO().setREVISION_BASIS(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	/**
	 * fill variables in CO
	 */
	public void fillSessionCO() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		blackListTypeCO.getMosBlackListTypeVO().setCOMP_CODE(sessionCO.getCompanyCode());
		blackListTypeCO.setBranch(sessionCO.getBranchCode());
		blackListTypeCO.setAppName(sessionCO.getCurrentAppName());
		blackListTypeCO.setLanguage(sessionCO.getLanguage());
		blackListTypeCO.setOpt(get_pageRef());
		blackListTypeCO.setLoginUserId(sessionCO.getUserName());
		blackListTypeCO.setIvCrud(getIv_crud());
		blackListTypeCO.setProgRef(get_pageRef());
		blackListTypeCO.setRunningDate(sessionCO.getRunningDateRET());

	}

	/**
	 * fill variables
	 */
	public void fillSessionVariables() throws BaseException
	{
		SessionCO sessionCO = returnSessionObject();
		blackListTypeSC.setCompCode(sessionCO.getCompanyCode());
		blackListTypeSC.setLanguage(sessionCO.getLanguage());
		blackListTypeSC.setAppName(sessionCO.getCurrentAppName());
		blackListTypeSC.setProgRef(get_pageRef());
		blackListTypeSC.setIvCrud(getIv_crud());
		blackListTypeSC.setRunningDate(sessionCO.getRunningDateRET());
		blackListTypeSC.setLovTypeId(BlackListSourceConstant.LOV_TYPE);
		blackListTypeSC.setIsRTLDir(sessionCO.getIsRTLDir());

	}

	public void setBlackListTypeBO(BlackListTypeBO blackListTypeBO)
	{
		this.blackListTypeBO = blackListTypeBO;
	}

	public BlackListTypeCO getBlackListTypeCO()
	{
		return blackListTypeCO;
	}

	public void setBlackListTypeCO(BlackListTypeCO blackListTypeCO)
	{
		this.blackListTypeCO = blackListTypeCO;
	}

	public BlackListTypeSC getBlackListTypeSC()
	{
		return blackListTypeSC;
	}

	public void setBlackListTypeSC(BlackListTypeSC blackListTypeSC)
	{
		this.blackListTypeSC = blackListTypeSC;
	}

	public List<SelectCO> getRevisionBasisDropDown()
	{
		return revisionBasisDropDown;
	}

	public void setRevisionBasisDropDown(List<SelectCO> revisionBasisDropDown)
	{
		this.revisionBasisDropDown = revisionBasisDropDown;
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
