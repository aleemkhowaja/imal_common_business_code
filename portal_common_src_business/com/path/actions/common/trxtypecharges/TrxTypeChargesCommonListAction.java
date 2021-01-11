package com.path.actions.common.trxtypecharges;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.trxtypecharges.TrxTypeChargesCommonBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonCO;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonSC;
import com.path.vo.core.csmfom.FomCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * TrxTypeChargesCommonListAction.java used to
 */
public class TrxTypeChargesCommonListAction extends GridBaseAction
{
	 
    private TrxTypeChargesCommonCO trxTypeChargesCO = new TrxTypeChargesCommonCO();
    private TrxTypeChargesCommonBO trxTypeChargesBO;
    //private ChargesSchemaBO chargesSchemaBO;
    private TrxTypeChargesCommonSC criteria = new TrxTypeChargesCommonSC();
    private BigDecimal cifCode;
    private Boolean _popupBtnFlag = true;
    private Boolean _popupReadOnlyMode = false;
    private List cashAccountList = new ArrayList<SelectCO>();
    private List chargesPolicyList = new ArrayList<SelectCO>();
    private String chargesStr;
    private String chargesSchemaStr;
    private String cifStatus;
    private Date cif_UpdateDate;
    private String latestCifupdateDate;

    public String loadTrxTypeChargesGrid()
	{
	 
	String[] searchCol = { "TRXTYPE_CODE", "TRX_TYPE_NAME", "CHARGE_CODE", "CHARGE_NAME", "CASH_ACCOUNT" };
	try
	{
	    /**
	     * copy the details related to search criteria to the SC
	     */
	    	  
	    criteria.setSearchCols(searchCol);

	    copyproperties(criteria);

	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setCompCodeCif(NumberUtil.nullEmptyToValue(criteria.getCompCodeCif(), criteria.getCompCode()));//Hasan EWBI160091 16/06/2016
	    criteria.setLangCode(returnSessionObject().getLanguage());
	    criteria.setPolicyLovType(new BigDecimal(82));
	    criteria.setCashAccLovType(new BigDecimal(40));
	    
	    //Hasan EWBI160091 10/06/2016
	    if(NumberUtil.isEmptyDecimal(criteria.getCompCodeCif())
		    || NumberUtil.isNumberPositive(criteria.getCompCodeCif()))
	    {
		criteria.setCurrAppName(returnSessionObject().getCurrentAppName());
		int cpt = trxTypeChargesBO.checkNegativeComp(criteria);
		if(cpt == 1)
		{
		    criteria.setCompCodeCif(criteria.getCompCode().negate());
		}
	    }
	    //End Hasan
			
	    /**
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only
	     */
	    if(checkNbRec(criteria))
	    {
		setRecords(trxTypeChargesBO.getTrxTypeChargesListCount(criteria));
	    }

	    /**
	     * return the collection of records
	     */
	    List<TrxTypeChargesCommonCO> trxTypeChargesList = trxTypeChargesBO.getTrxTypeChargesList(criteria);

	    /**
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag
	     */
	    setGridModel(trxTypeChargesList);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in FOM Trx Type Charges List Grid");
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    // Action called when Trx Type Charges button in FOM Screen is clicked
    public String populateTrxTypeChargesPopup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    trxTypeChargesCO.setIv_crud(getIv_crud());
	    trxTypeChargesCO.setCifStatus(getCifStatus());
	    trxTypeChargesCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
	    trxTypeChargesCO.setCOMP_CODE(sessionCO.getCompanyCode());
	    trxTypeChargesCO.setCIF_NO(cifCode);

	    FomCO fomCO = new FomCO();
	    fomCO.getCifVO().setSTATUS(getCifStatus());
	    fomCO.getCifVO().setCIF_NO(cifCode);
			
	    trxTypeChargesCO = trxTypeChargesBO.initialiseOnModeNew(trxTypeChargesCO, fomCO);

	    /*
	     * Check whether to make fields read-only
	     */
	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }
	    if(!(getIv_crud().equalsIgnoreCase("R") && FomConstant.MAINTENANCE_OPT.equalsIgnoreCase(originOptRef)) || !trxTypeChargesCO.getAccesByTeller())
	    {
		set_popupBtnFlag(false);
		set_popupReadOnlyMode(true);
		set_recReadOnly("true");

	    }
	}
	catch(BaseException e)
	{
	    handleException(e, "Error in loading populateTrxTypeChargesPopup", null);
	}
	return "populateTrxTypeChargesPopup";

    }
    
    public String loadCashAccountList()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(40));
	    cashAccountList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public String loadChargesPolicyList()
    {
	try
	{
	    SelectSC selSC = new SelectSC(new BigDecimal(82)); // 82
	    chargesPolicyList = returnLOV(selSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    @Override
    public Object getModel()
    {
	return criteria;
    }

    public TrxTypeChargesCommonCO getTrxTypeChargesCO()
    {
	return trxTypeChargesCO;
    }

    public void setTrxTypeChargesCO(TrxTypeChargesCommonCO trxTypeChargesCO)
    {
	this.trxTypeChargesCO = trxTypeChargesCO;
    }

    public TrxTypeChargesCommonSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(TrxTypeChargesCommonSC criteria)
    {
	this.criteria = criteria;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public Boolean get_popupBtnFlag()
    {
	return _popupBtnFlag;
    }

    public void set_popupBtnFlag(Boolean popupBtnFlag)
    {
	_popupBtnFlag = popupBtnFlag;
    }

    public void setTrxTypeChargesBO(TrxTypeChargesCommonBO trxTypeChargesBO)
    {
	this.trxTypeChargesBO = trxTypeChargesBO;
    }

    public List getCashAccountList()
    {
	return cashAccountList;
    }

    public void setCashAccountList(List cashAccountList)
    {
	this.cashAccountList = cashAccountList;
    }

    public List getChargesPolicyList()
    {
	return chargesPolicyList;
    }

    public void setChargesPolicyList(List chargesPolicyList)
    {
	this.chargesPolicyList = chargesPolicyList;
    }
    
    private void prepareAuditObject(TrxTypeChargesCommonCO trxTypeChargesCommonCO)
    {
	AuditRefCO refCO = initAuditRefCO();
	refCO.setOperationType(AuditConstant.UPDATE);
	refCO.setKeyRef(AuditConstant.FOM_KEY_REF);
	trxTypeChargesCommonCO.setAuditRefCO(refCO);
	FomCO fomCO = new FomCO();
	trxTypeChargesCommonCO.setAuditObj(returnAuditObject(fomCO.getClass()));
    }
    
    public String save()
    {
	try
	{
	    GridUpdates gu = getGridUpdates(chargesStr, TrxTypeChargesCommonCO.class, true);

	    List<TrxTypeChargesCommonCO> trxTypeChargesList = gu.getLstAllRec();
	    TrxTypeChargesCommonCO trxTypeChargesCommonCO = new TrxTypeChargesCommonCO();
	    trxTypeChargesCommonCO.setCIF_NO(getCifCode());
	    trxTypeChargesCommonCO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    trxTypeChargesCommonCO.setCompCodeCif(NumberUtil.nullEmptyToValue(criteria.getCompCodeCif(),returnSessionObject().getCompanyCode()));//Hasan EWBI160091 08/06/2016
	    trxTypeChargesCommonCO.setCif_UpdateDate(getCif_UpdateDate());
	    trxTypeChargesCommonCO.setIv_crud(getIv_crud());
	    trxTypeChargesCommonCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    trxTypeChargesCommonCO.setCifStatus(getCifStatus());
	    trxTypeChargesCommonCO.setCtsTellerVO(returnSessionObject().getCtsTellerVO());
	    trxTypeChargesCommonCO.setCheckApprovedByAccess(trxTypeChargesCO.getCheckApprovedByAccess());
	    prepareAuditObject(trxTypeChargesCommonCO);
	    CIFVO cifVo = trxTypeChargesBO.updateTrxTypeChargeDetail(trxTypeChargesList, trxTypeChargesCommonCO);
	    if(cifVo != null)
	    {
	    	//EWBI160091 (403157)- reset the hidden value
		trxTypeChargesCO.setCompCodeCif( NumberUtil.nullToZero(cifVo.getCOMP_CODE()));
	    }
	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS",Locale.ENGLISH);
	    latestCifupdateDate = df.format(cifVo.getDATE_UPDATED());
	    setCifStatus(cifVo.getSTATUS());
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public String getChargesStr()
    {
	return chargesStr;
    }

    public void setChargesStr(String chargesStr)
    {
	this.chargesStr = chargesStr;
    }

    public String getChargesSchemaStr()
    {
	return chargesSchemaStr;
    }

    public void setChargesSchemaStr(String chargesSchemaStr)
    {
	this.chargesSchemaStr = chargesSchemaStr;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public String getLatestCifupdateDate()
    {
	return latestCifupdateDate;
    }

    public void setLatestCifupdateDate(String latestCifupdateDate)
    {
	this.latestCifupdateDate = latestCifupdateDate;
    }

    public Boolean get_popupReadOnlyMode()
    {
	return _popupReadOnlyMode;
    }

    public void set_popupReadOnlyMode(Boolean popupReadOnlyMode)
    {
	_popupReadOnlyMode = popupReadOnlyMode;
    }

}
