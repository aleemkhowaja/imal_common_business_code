package com.path.core.actions.scoringcontrolrecord;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.criteria.CriteriaConstant;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordBO;
import com.path.bo.core.scoringcontrolrecord.ScoringControlRecordConstant;
import com.path.dbmaps.vo.AML_CIFCONTROL_RECORD_SCOREVO;
import com.path.expression.common.PBFunc.BaseException;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.smart.SmartCO;
import com.path.vo.core.scoringcontrolrecord.ScoringControlRecordCO;
import net.sf.json.JSONException;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * ScoringControlRecordMaintAction.java used to
 */
public class ScoringControlRecordMaintAction extends BaseAction
{

	private ScoringControlRecordBO scoringControlRecordBO;

	private ScoringControlRecordCO scoringControlRecordCO = new ScoringControlRecordCO();

	private ArrayList<SmartCO> smartCOList;
	private String allControlRecordDetailsData;
	private String updatedListControlRecord;
	private String _dualParam;
	private List<SelectCO> riskActionList = new ArrayList<SelectCO>();
	private Boolean _popupBtnAddFlag = true;
	private Boolean _popupBtnDelFlag = true;
	private List<SelectCO> scoringCalcCriteriaList = new ArrayList<SelectCO>(); //by bilal for TP#987360
	   
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
			
			scoringControlRecordCO.setDualParam(scoringControlRecordBO.getDualParam(scoringControlRecordCO));
			BigDecimal dualParam = scoringControlRecordCO.getDualParam(); //by bilal for BUG#973477
			//Added by bilal for TP#954712
			if((BigDecimal.ZERO.equals(dualParam) || dualParam == null)) //by bilal for BUG#973477
			{
				set_dualParam("false");
			}
			else
			{
				set_dualParam("true");
			}
			
			//Added by bilal for TP#954712
			if ((BigDecimal.ZERO.equals(dualParam) || dualParam == null) //by bilal for BUG#973477
					&& (CoreCommonConstants.CRUD_APPROVE.equals(scoringControlRecordCO.getIvCrud())
							|| CoreCommonConstants.CRUD_UPDATE_AFTER_APPROVE.equals(scoringControlRecordCO.getIvCrud())
							|| CoreCommonConstants.CRUD_CANCEL.equals(scoringControlRecordCO.getIvCrud())))
			{
				throw new BOException(MessageCodes.DUAL_PARAM_NOT_CHECKED);
			}

			// show audit button
			set_enableAudit(true);
			set_showSmartInfoBtn("true");
			fillSessionCO();
			//added by bilal for TP#987360
			SelectSC selectSC = new SelectSC(ScoringControlRecordConstant.PROFILING_BASED_ON_LOV_TYPE);
			scoringCalcCriteriaList = returnLOV(selectSC);
			//end bilal
			// load data from DB and call visibility method 
			
			//by bilal for bug#973477, using as return status only, will be change name function later
			scoringControlRecordCO = scoringControlRecordBO.loadData(scoringControlRecordCO);
			
			//by bilal for TP#987360
			if(ConstantsCommon.ONE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.TRUE);
			}
			else if(ConstantsCommon.ZERO.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.FALSE);
			}
			//end bilal
			
			//by bilal for BUG#954712, add checking on dual param 
			 if(BigDecimal.ONE.equals(dualParam) && ((CoreCommonConstants.CRUD_MAINTENANCE.equals(getIv_crud()) //by bilal for BUG#973477
					    && CoreCommonConstants.STATUS_APPROVED.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getSTATUS()))
					    || (CoreCommonConstants.CRUD_APPROVE.equals(getIv_crud()))
					    || (CoreCommonConstants.CRUD_CANCEL.equals(getIv_crud()))
					    || ((ScoringControlRecordConstant.CRUD_UPDATE_AFTER_AUTHORIZE.equals(getIv_crud()))
						    && (StringUtil.isEmptyString(scoringControlRecordCO.getAmlCifControlScoreVO().getSTATUS())))))
				    {
					set_recReadOnly("true");
				    }
			 
			//by bilal for TP#987360
			 AML_CIFCONTROL_RECORD_SCOREVO amlCifControlVO = new AML_CIFCONTROL_RECORD_SCOREVO();
			if(scoringControlRecordCO.getAmlCifControlScoreVO().getCOMP_CODE() != null)
			{
				amlCifControlVO = scoringControlRecordCO.getAmlCifControlScoreVO(); 
				if(amlCifControlVO.getCOMP_CODE().compareTo(BigDecimal.ZERO) > 0)
				{
					amlCifControlVO.setCOMP_CODE(CoreCommonConstants.MINUS_ONE.multiply(amlCifControlVO.getCOMP_CODE()));
				}
			}
			
			applyRetrieveAudit(AuditConstant.CONTROL_RECORD_KEY_REF, amlCifControlVO, scoringControlRecordCO);
			//commented by bilal for TP#987360
//			AuditRefCO refCO = initAuditRefCO();
//			refCO.setTrxNbr(getAuditTrxNbr());
		}
		catch (

			Exception ex
		)
		{
			handleException(ex, null, null);
			return ERROR_ACTION;
		}

		return "scoringControlRecordMaint";
	}

	public String dependencyByFromScore() throws JSONException
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();

			if (NumberUtil.isEmptyDecimal(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getFROM_SCORE()))
			{
				scoringControlRecordCO = new ScoringControlRecordCO();
			}
			else
			{
				fillSessionCO();
				scoringControlRecordCO = scoringControlRecordBO.dependencyByFromScore(scoringControlRecordCO);

			}

		}
		catch (Exception e)
		{
			scoringControlRecordCO.getCifControlDefineScoreRangeVO().setFROM_SCORE(null);
			scoringControlRecordCO.getCifControlDefineScoreRangeVO().setTO_SCORE(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	public String dependencyByToScore() throws JSONException
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();

			if (NumberUtil.isEmptyDecimal(scoringControlRecordCO.getCifControlDefineScoreRangeVO().getTO_SCORE()))
			{
				//scoringControlRecordCO = new ScoringControlRecordCO();
				scoringControlRecordCO.getCifControlDefineScoreRangeVO().setTO_SCORE(null);
			}
			else
			{
				fillSessionCO();
				scoringControlRecordCO = scoringControlRecordBO.dependencyByToScore(scoringControlRecordCO);

			}

		}
		catch (Exception e)
		{
			scoringControlRecordCO.getCifControlDefineScoreRangeVO().setTO_SCORE(null);
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	public String save() throws BaseException
	{
		GridUpdates gridData;
		try
		{
			fillSessionCO();

			// smart
			scoringControlRecordCO.setSmartCOList(smartCOList);
			scoringControlRecordCO.setDualParam(scoringControlRecordBO.getDualParam(scoringControlRecordCO));

			// audit
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.CREATED);
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			scoringControlRecordCO.setAuditRefCO(refCO);
			if (StringUtil.isNotEmpty(getAllControlRecordDetailsData()))
			{
				gridData = getGridUpdates(getAllControlRecordDetailsData(), ScoringControlRecordCO.class, true);
				scoringControlRecordCO.setAllControlRecordDetailsData(gridData.getLstAllRec());
			}
			
			//by bilal for TP#987360
			if(ConstantsCommon.TRUE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.ONE);
			}
			else if(ConstantsCommon.FALSE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.ZERO);
			}
			//end bilal

			scoringControlRecordCO = scoringControlRecordBO.saveNew(scoringControlRecordCO);
		}
		catch (Exception ex)
		{
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String updateScoringControlRecord() throws BaseException, DAOException, com.path.lib.common.exception.BaseException
	{
		try {
			AuditRefCO refCO = initAuditRefCO();
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			refCO.setTrxNbr(getAuditTrxNbr());
			// smart
			scoringControlRecordCO.setSmartCOList(smartCOList);

			scoringControlRecordCO.setAuditRefCO(refCO);
			scoringControlRecordCO.setAuditObj(returnAuditObject(scoringControlRecordCO.getClass()));

			fillSessionCO();

			scoringControlRecordCO.setDualParam(scoringControlRecordBO.getDualParam(scoringControlRecordCO));
			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam())) {
				if (StringUtil.isNotEmpty(getUpdatedListControlRecord())) {
					GridUpdates gridData = getGridUpdates(getUpdatedListControlRecord(), ScoringControlRecordCO.class,
							false);
					GridUpdates gridAllData = getGridUpdates(getAllControlRecordDetailsData(),
							ScoringControlRecordCO.class, true);
					scoringControlRecordCO.setUpdatedListControlRecord(gridData.getLstModify());
					scoringControlRecordCO.setAllControlRecordDetailsData(gridAllData.getLstAllRec());
				} else {
					GridUpdates gridAllData = getGridUpdates(getAllControlRecordDetailsData(),
							ScoringControlRecordCO.class, true);
					scoringControlRecordCO.setAllControlRecordDetailsData(gridAllData.getLstAllRec());

				}

			} else {
				if (StringUtil.isNotEmpty(getUpdatedListControlRecord())) {
					GridUpdates gridData = getGridUpdates(getUpdatedListControlRecord(), ScoringControlRecordCO.class,
							false);
					GridUpdates gridAllData = getGridUpdates(getAllControlRecordDetailsData(),
							ScoringControlRecordCO.class, true);
					scoringControlRecordCO.setUpdatedListControlRecord(gridData.getLstModify());
					scoringControlRecordCO.setAllControlRecordDetailsData(gridAllData.getLstAllRec());
				}

			}
			
			//by bilal for TP#987360
			if(ConstantsCommon.TRUE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.ONE);
			}
			else if(ConstantsCommon.FALSE.equals(scoringControlRecordCO.getAmlCifControlScoreVO().getRETAIN_HIGHEST_SCORE_YN()))
			{
				scoringControlRecordCO.getAmlCifControlScoreVO().setRETAIN_HIGHEST_SCORE_YN(ConstantsCommon.ZERO);
			}
			//end bilal

			scoringControlRecordCO = scoringControlRecordBO.saveNew(scoringControlRecordCO);

		} catch (Exception ex) {
			handleException(ex, null, null);
		}
		return SUCCESS;
	}

	public String approveScoringControlRecord() throws BaseException
	{
		try
		{
			NumberUtil.resetEmptyValues(scoringControlRecordCO);
			fillSessionCO();
			scoringControlRecordCO.setMethod(BigDecimal.ONE);

			scoringControlRecordCO.setDualParam(scoringControlRecordBO.getDualParam(scoringControlRecordCO));

			// smart
			scoringControlRecordCO.setSmartCOList(smartCOList);

			// CALL AUDIT FOR APPROVE.
			AuditRefCO refCO = initAuditRefCO();
			refCO.setKeyRef(AuditConstant.CONTROL_RECORD_KEY_REF);
			refCO.setOperationType(AuditConstant.UPDATE);
			refCO.setTrxNbr(getAuditTrxNbr());
			scoringControlRecordCO.setAuditRefCO(refCO);
			scoringControlRecordCO.setAuditObj(returnAuditObject(scoringControlRecordCO.getClass()));

			if (StringUtil.isNotEmpty(getAllControlRecordDetailsData()))
			{

				GridUpdates gridAllData = getGridUpdates(getAllControlRecordDetailsData(), ScoringControlRecordCO.class, true);
				scoringControlRecordCO.setAllControlRecordDetailsData(gridAllData.getLstAllRec());
			}

			if (BigDecimal.ONE.equals(scoringControlRecordCO.getDualParam()))
			{

				scoringControlRecordCO = scoringControlRecordBO.deleteScoringControlRecord(scoringControlRecordCO);
			}

			scoringControlRecordCO = scoringControlRecordBO.approveScoringControlRecord(scoringControlRecordCO);

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
			GridUpdates gridData;

			SessionCO sessionCO = returnSessionObject();
			scoringControlRecordCO.getCifControlDefineScoreRangeVO().setCOMP_CODE(sessionCO.getCompanyCode());
			fillSessionCO();
			scoringControlRecordCO.setDualParam(scoringControlRecordBO.getDualParam(scoringControlRecordCO));
			scoringControlRecordCO.setIvCrud(getIv_crud());
			scoringControlRecordCO.setMethod(CoreCommonConstants.TWO);
			if (StringUtil.isNotEmpty(getAllControlRecordDetailsData()))
			{
				gridData = getGridUpdates(getAllControlRecordDetailsData(), ScoringControlRecordCO.class, true);
				scoringControlRecordCO.setAllControlRecordDetailsData(gridData.getLstAllRec());
			}
			scoringControlRecordCO = scoringControlRecordBO.deleteScoringControlRecord(scoringControlRecordCO);
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
		scoringControlRecordCO.getCifControlDefineScoreRangeVO().setCOMP_CODE(sessionCO.getCompanyCode());
		scoringControlRecordCO.getAmlCifControlScoreVO().setCOMP_CODE(sessionCO.getCompanyCode());//by bilal for TP#987360
		scoringControlRecordCO.setLanguage(sessionCO.getLanguage());
		scoringControlRecordCO.setLoginUserId(sessionCO.getUserName());
		scoringControlRecordCO.setProgRef(get_pageRef());
		scoringControlRecordCO.setOpt(get_pageRef());
		scoringControlRecordCO.setAppName(sessionCO.getCurrentAppName());
		scoringControlRecordCO.setRunningDate(sessionCO.getRunningDateRET());
		scoringControlRecordCO.setLovTypeId(ScoringControlRecordConstant.LOV_TYPE);
		scoringControlRecordCO.setIsRTLDir(sessionCO.getIsRTLDir());
		scoringControlRecordCO.setIvCrud(getIv_crud());
		scoringControlRecordCO.setLoginBraCode(sessionCO.getBranchCode());
		scoringControlRecordCO.setRunningDate(sessionCO.getRunningDateRET());
		scoringControlRecordCO.setIsRTLDir(sessionCO.getIsRTLDir());

	}

	public String loadriskList() throws BaseException
    {
	try
	{
	    SelectSC selSC = new SelectSC(ScoringControlRecordConstant.CASE_SEVERITY_LOV_TYPE);
	    selSC.setOrderCriteria(ConstantsCommon.LOV_ORDER_BY_SPECIFIC_ORDER);
	    riskActionList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
	
	public void setScoringControlRecordBO(ScoringControlRecordBO scoringControlRecordBO)
	{
		this.scoringControlRecordBO = scoringControlRecordBO;

	}

	public ScoringControlRecordCO getScoringControlRecordCO()
	{
		return scoringControlRecordCO;
	}

	public void setScoringControlRecordCO(ScoringControlRecordCO scoringControlRecordCO)
	{
		this.scoringControlRecordCO = scoringControlRecordCO;
	}

	public ArrayList<SmartCO> getSmartCOList()
	{
		return smartCOList;
	}

	public void setSmartCOList(ArrayList<SmartCO> smartCOList)
	{
		this.smartCOList = smartCOList;
	}

	public String getAllControlRecordDetailsData()
	{
		return allControlRecordDetailsData;
	}

	public void setAllControlRecordDetailsData(String allControlRecordDetailsData)
	{
		this.allControlRecordDetailsData = allControlRecordDetailsData;
	}

	public String getUpdatedListControlRecord()
	{
		return updatedListControlRecord;
	}

	public void setUpdatedListControlRecord(String updatedListControlRecord)
	{
		this.updatedListControlRecord = updatedListControlRecord;
	}

	public ScoringControlRecordBO getScoringControlRecordBO()
	{
		return scoringControlRecordBO;
	}

	public String get_dualParam() {
		return _dualParam;
	}

	public void set_dualParam(String _dualParam) {
		this._dualParam = _dualParam;
	}

	
	public List<SelectCO> getRiskActionList()
	{
		return riskActionList;
	}

	
	public void setRiskActionList(List<SelectCO> riskActionList)
	{
		this.riskActionList = riskActionList;
	}

	
	public Boolean get_popupBtnAddFlag()
	{
		return _popupBtnAddFlag;
	}

	
	public void set_popupBtnAddFlag(Boolean _popupBtnAddFlag)
	{
		this._popupBtnAddFlag = _popupBtnAddFlag;
	}

	
	public Boolean get_popupBtnDelFlag()
	{
		return _popupBtnDelFlag;
	}

	
	public void set_popupBtnDelFlag(Boolean _popupBtnDelFlag)
	{
		this._popupBtnDelFlag = _popupBtnDelFlag;
	}

	public List<SelectCO> getScoringCalcCriteriaList() {
		return scoringCalcCriteriaList;
	}

	public void setScoringCalcCriteriaList(List<SelectCO> scoringCalcCriteriaList) {
		this.scoringCalcCriteriaList = scoringCalcCriteriaList;
	}

}
