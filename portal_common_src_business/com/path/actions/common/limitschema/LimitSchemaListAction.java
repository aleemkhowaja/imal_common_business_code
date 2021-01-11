/**
 * 
 */
package com.path.actions.common.limitschema;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.limitschema.LimitSchemaBO;
import com.path.bo.common.limitschema.LimitSchemaConstant;
import com.path.bo.core.account.AccountsConstant;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.LIMIT_SCHEMAVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.limitschema.LimitSchemaCO;
import com.path.vo.common.limitschema.LimitSchemaSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.core.csmfom.FomCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * LimitSchemaListAction.java used to
 */
public class LimitSchemaListAction extends GridBaseAction
{
    private LimitSchemaBO limitSchemaBO; 
    private LimitSchemaSC limitSchemaSC = new LimitSchemaSC();
    private LimitSchemaCO limitSchemaCO = new LimitSchemaCO();
    private String limitSchemaGridJson;
    private BigDecimal cifSubNo;
    private BigDecimal branchCode;
    private BigDecimal compCode; 
    private BigDecimal baseCyDecPoint; 
    private String groupComboList ="";
    private boolean showToolBar;
    private String enforceSignLimit;
    private String accountType;
    private String status;
    private String openMode;
    private List<LimitSchemaCO> limitSchemaCOList;
    private CoreCommonServiceBO coreCommonServiceBO;

    private String cifStatus;

	/**
     * Method will return the  limitschema.jsp which contain the limit schema grid in the in form tag
     * @return String
     */
    public String populateLimitSchemaPopup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    cifSubNo = limitSchemaSC.getCifSubNo();
	    branchCode = limitSchemaSC.getBranchCode();
	    compCode = limitSchemaSC.getCompCode();
	    baseCyDecPoint = sessionCO.getBaseCurrDecPoint();
	    
	    //Rania 801289 - Copied from Hasan Bug#566067 - BMOUPI170480 20/09/2017
	    limitSchemaCO.setCtsTellerVO(sessionCO.getCtsTellerVO());

	    try
	    {
		if("FOM".equals(limitSchemaCO.getFromWhere()))
		{
		    limitSchemaCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
		    limitSchemaCO.setCrud(getIv_crud());
		    limitSchemaCO.setCifStatus(cifStatus);
		    limitSchemaCO = limitSchemaBO.initialise(limitSchemaCO);
		 
		    //SUPT190382 - [AUB-Upgrade] Modify Draft CIF
		    if(!limitSchemaCO.getAccesByTeller())
		    {
			set_recReadOnly("true");
		    }
		}
	    }
	    catch(BaseException e)
	    {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	    //End Rania
	    
	    loadGroupComboList();
	    Boolean cifUserAcess = true;
	    // Rakan Makarem- #584327
//	    SessionCO sessionCO = returnSessionObject();
	   // cifUserAcess = coreCommonServiceBO.checkAccesTellerModified(sessionCO.getCtsTellerVO(),
		//    NCifMaintenanceConstant.CIF_LIMIT_SCHEMA);
	  //SUPT190382 - [AUB-Upgrade] Modify Draft CIF
	    cifUserAcess=coreCommonServiceBO.checkIfDataCanModified(sessionCO.getCtsTellerVO(),
		    cifStatus,    getIv_crud(), NCifMaintenanceConstant.CIF_LIMIT_SCHEMA);
	    if(!cifUserAcess)
	    {
		set_recReadOnly("true");
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return "populateLimitSchema";
    }
    
    /**
     * Method will return LimitSchemaList.jsp which contain the limit schema grid
     * @return String
     */
    public String populateLimitSchemaList()
    {
	cifSubNo 	= limitSchemaSC.getCifSubNo();
	branchCode 	= limitSchemaSC.getBranchCode();
	compCode	= limitSchemaSC.getCompCode();
	loadGroupComboList();
//	for accounts 
	if(AccountsConstant.FIXED_ACCOUNT.equals(accountType) || AccountsConstant.GENERAL_ACCOUNT.equals(accountType))
	{
	    try
	    {
		if(!"true".equals(get_recReadOnly()))
		{
		    if(limitSchemaBO.checkIfLimitSchemaIsReadonly(status, getIv_crud(), openMode))
		    {
			set_recReadOnly("true");
		    }
		    else
		    {
			set_recReadOnly("false");
		    }
		}
	    }
	    catch(BaseException e)
	    {
		e.printStackTrace();
	    }
	}
	return "populateLimitSchemaList";
    }
    
    /**
     * Method for setting the parameter called for populating the gid data 
     * @return
     */
    public String loadLimitSchemaGrid()
    {
	try
	{
	    limitSchemaSC.setCurrencyCode(NumberUtil.nullToZero(limitSchemaSC.getCurrencyCode()));
	    limitSchemaSC.setGlCode(NumberUtil.nullToZero(limitSchemaSC.getGlCode()));
	    limitSchemaSC.setSlNo(NumberUtil.nullToZero(limitSchemaSC.getSlNo()));
	    loadLimitSchemaGridData();
	}
	catch(Exception e){
	    handleException(e, null, null);
	}
	return "loadLimitSchema";
    }
    
    /**
     * Method to load the data to the grid
     * @return
     */
    public String loadLimitSchemaGridData()
    {
	try
	{
	    String[] searchCol = {"LINE","LIMIT_AMT","TRX_TYPE","GROUP1","GROUP2","GROUP3","GROUP4","GROUP5","GROUP6","GROUP7","GROUP8","GROUP9",
			"GROUP10","NEVER_EXPIRE","EFFECTIVE_FROM","EFFECTIVE_TO"};
	    SessionCO sessionObject = returnSessionObject();
	    limitSchemaSC.setCompCode(sessionObject.getCompanyCode());
	    limitSchemaSC.setPreferredLanguage(sessionObject.getPreferredLanguage());
	    limitSchemaSC.setSearchCols(searchCol);
	    copyproperties(limitSchemaSC);
	    if(!NumberUtil.isEmptyDecimal(limitSchemaSC.getCifSubNo()) && !NumberUtil.isEmptyDecimal(limitSchemaSC.getBranchCode()))
	    {
		limitSchemaSC.setSectionKey(get_pageRef());
		limitSchemaSC.setCurrAppName(sessionObject.getCurrentAppName());
		// EWBI160091 10/06/2016
		if(NumberUtil.isEmptyDecimal(limitSchemaSC.getCompCodeCif())
			|| NumberUtil.isNumberPositive(limitSchemaSC.getCompCodeCif()))
		{
		    int cpt = limitSchemaBO.checkNegativeComp(limitSchemaSC);
		    if(cpt == 1)
		    {
			limitSchemaSC.setCompCodeCif(limitSchemaSC.getCompCode().negate());
		    }
		}
		
		
		if(checkNbRec(limitSchemaSC))
		{
		    setRecords(limitSchemaBO.returnLimitSchemaListCount(limitSchemaSC));
		}
	
		List<LimitSchemaCO> limitSchemaList  =  limitSchemaBO.returnLimitSchemaList(limitSchemaSC);
		if(limitSchemaList != null && !limitSchemaList.isEmpty()){
		    BigDecimal baseCurrDecPoint = returnSessionObject().getBaseCurrDecPoint();
		    for(LimitSchemaCO limitSchemaCO : limitSchemaList){
//			if((limitSchemaCO.getLimitSchemaVO().getNEVER_EXPIRE() != null) && (limitSchemaCO.getLimitSchemaVO().getNEVER_EXPIRE().compareTo(BigDecimal.ONE)==0))
//			    limitSchemaCO.setNeverExpire("N");
			
			if(null != limitSchemaCO.getLimitSchemaVO().getTRX_TYPE() 
				&& BigDecimal.ZERO.compareTo(limitSchemaCO.getLimitSchemaVO().getTRX_TYPE())==0)
			{
			    limitSchemaCO.setTransactionDesc(getText("All_types_key"));
			}
			limitSchemaCO.setLimitAmtFormat(baseCurrDecPoint);
		    }
		}
		setGridModel(limitSchemaList);    
	    }
	    cifSubNo 	= limitSchemaSC.getCifSubNo();
	    branchCode 	= limitSchemaSC.getBranchCode();
	    compCode	= limitSchemaSC.getCompCode();
	    
	    
	    
	    
	    
	}
	catch(Exception e){
	    handleException(e, null, null);
	}
	return "loadLimitSchema";
    }

    private void prepareAuditObject(LimitSchemaCO limitSchemaCO)
    {
	AuditRefCO refCO = initAuditRefCO();
	refCO.setOperationType(AuditConstant.UPDATE);
	refCO.setKeyRef(AuditConstant.FOM_KEY_REF);
	limitSchemaCO.setAuditRefCO(refCO);
	FomCO fomCO = new FomCO();
	limitSchemaCO.setAuditObj(returnAuditObject(fomCO.getClass()));
    }
    
    /**
     * Method to save the limit schema
     * @return
     */
    @SuppressWarnings("unchecked")
    public String saveLimitSchema()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    BigDecimal companyCode = sessionObject.getCompanyCode();
	    branchCode = limitSchemaSC.getBranchCode();
	    cifSubNo = limitSchemaSC.getCifSubNo();
	    limitSchemaSC.setCompCode(companyCode);
	    String originOptRef = "";
	    String parentRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionObject.getCurrentAppName(), get_pageRef());
		String[] parentOptRef = returnCommonLibBO().returnOptDetailsList(sessionObject.getCurrentAppName(),
			    originOptRef);
		parentRef = parentOptRef[3];
	    }
	    /*
	     * not from accounts screen
	     */
	    if(parentRef == null || (!parentRef.equals("A001") && !parentRef.equals("A002")))
	    {
		limitSchemaSC.setCurrencyCode(BigDecimal.ZERO);
		limitSchemaSC.setGlCode(BigDecimal.ZERO);
		limitSchemaSC.setSlNo(BigDecimal.ZERO);
	    }
	    limitSchemaSC.setPreferredLanguage(sessionObject.getPreferredLanguage());
	    limitSchemaCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    
	    GridUpdates gridData = getGridUpdates(limitSchemaGridJson, LimitSchemaCO.class,true);
	    List<LimitSchemaCO> limitSchemaList = gridData.getLstAllRec();    	    
	    NumberUtil.resetEmptyValues(limitSchemaList);
	    if(null != limitSchemaList && !limitSchemaList.isEmpty()){
		BigDecimal line = BigDecimal.ONE;
		for(LimitSchemaCO limitSchemaCO : limitSchemaList)
		{
		    if(limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_FROM() == null &&
			    limitSchemaCO.getLimitSchemaVO().getEFFECTIVE_TO() == null )
		    {
			limitSchemaCO.getLimitSchemaVO().setNEVER_EXPIRE(BigDecimal.ONE);		
		    }
		    else
		    {
			limitSchemaCO.getLimitSchemaVO().setNEVER_EXPIRE(BigDecimal.ZERO);
		    }
		    
		    /*
		     * from accounts screen
		     */
		    if(parentRef != null && (parentRef.equals("A001") || parentRef.equals("A002")))
		    {
			limitSchemaCO.getLimitSchemaVO().setACC_BR(limitSchemaSC.getBranchCode());
			limitSchemaCO.getLimitSchemaVO().setACC_CIF(limitSchemaSC.getCifSubNo());
			limitSchemaCO.getLimitSchemaVO().setACC_CY(limitSchemaSC.getCurrencyCode());
			limitSchemaCO.getLimitSchemaVO().setACC_GL(limitSchemaSC.getGlCode());
			limitSchemaCO.getLimitSchemaVO().setACC_SL(limitSchemaSC.getSlNo());
		    }
		    else
		    {
			limitSchemaCO.getLimitSchemaVO().setACC_BR(branchCode);
			limitSchemaCO.getLimitSchemaVO().setACC_CIF(cifSubNo);
			limitSchemaCO.getLimitSchemaVO().setACC_CY(BigDecimal.ZERO);
			limitSchemaCO.getLimitSchemaVO().setACC_GL(BigDecimal.ZERO);
			limitSchemaCO.getLimitSchemaVO().setACC_SL(BigDecimal.ZERO);
		    }
		    limitSchemaCO.getLimitSchemaVO().setLINE(line);
		    limitSchemaCO.getLimitSchemaVO().setCOMP_CODE(companyCode);
		    
		    line = line.add(BigDecimal.ONE);
		}
	    }
	    if(limitSchemaSC.isOpenedFromSign())
	    {
		AuditRefCO refCO = initAuditRefCO();
		limitSchemaCO.setAuditRefCO(refCO);
		limitSchemaBO.saveLimitSchemaFromSign(limitSchemaList, false,limitSchemaCO);
	    }
	    else
	    {
		prepareAuditObject(limitSchemaCO);
		limitSchemaCO.setAuditFor("CIF");
		limitSchemaCO = limitSchemaBO.saveLimitSchema(limitSchemaSC,limitSchemaList,limitSchemaCO);
		if(limitSchemaCO != null && limitSchemaCO.getCifVo() != null && FomConstant.FOM_SCREEN_NAME.equals(limitSchemaCO.getFromWhere()))
		{
		    // EWBI160091 (403157)- reset the hidden value
		    limitSchemaCO.getCifVo().setCOMP_CODE( NumberUtil.nullToZero(limitSchemaCO.getCifVo().getCOMP_CODE()));
		}
	    }
	}
	catch (Exception e) {
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method to validate the row for the mandatory and insert the new row
     * @return
     */
    @SuppressWarnings("unchecked")
    public String addNewRow()
    {
	try
	{
	    GridUpdates gridData = getGridUpdates(limitSchemaGridJson, LimitSchemaCO.class,true);
	    List<LimitSchemaCO> limitSchemaList = gridData.getLstAllRec();
	    NumberUtil.resetEmptyValues(limitSchemaList);
	    if(null != limitSchemaList && !limitSchemaList.isEmpty()){
		for(LimitSchemaCO limitSchemaCO : limitSchemaList)
		{		    
		    if(limitSchemaCO.getNeverExpire().equals("N"))
		    {
			limitSchemaCO.getLimitSchemaVO().setNEVER_EXPIRE(BigDecimal.ZERO);
		    }
		    else
		    {
			limitSchemaCO.getLimitSchemaVO().setNEVER_EXPIRE(BigDecimal.ONE);
		    }
		}
		limitSchemaBO.validateAddNewRow(limitSchemaList);
	    }
	    LIMIT_SCHEMAVO limitSchemaVO = limitSchemaCO.getLimitSchemaVO();
		limitSchemaVO.setLINE(new BigDecimal(limitSchemaList.size()+1));
		limitSchemaVO.setNEVER_EXPIRE(BigDecimal.ONE);
		limitSchemaCO.setNeverExpire("Y");
		limitSchemaCO.setUnlimited("Y");
		limitSchemaVO.setTRX_TYPE(BigDecimal.ZERO);
		limitSchemaCO.setTransactionDesc(getText("All_types_key"));
		setCifSubNo(limitSchemaSC.getCifSubNo());
		setBranchCode(limitSchemaSC.getBranchCode());
	}
	catch (Exception e) {
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * Method will validate the effective from date on change event
     * @return
     */
    public String onChangeEffectiveFromDate()
    {
	try
	{
	    limitSchemaBO.onChangeEffectiveFromDate(limitSchemaCO);
	}
	catch (Exception e) {
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_FROM(null);
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_TO(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method will validate the effective To date on change event
     * @return
     */
    public String onChangeEffectiveToDate()
    {
	try
	{
	    limitSchemaBO.onChangeEffectiveToDate(limitSchemaCO);
	}
	catch (Exception e) {
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_FROM(null);
	    limitSchemaCO.getLimitSchemaVO().setEFFECTIVE_TO(null);
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method will check data is in database based on the criteria that set from the lookup (on Copy button click)
     * @return
     */

    public String onCopyButtonClicked()
    {
	try
	{
	    SessionCO sessionObject = returnSessionObject();
	    limitSchemaSC.setCompCode(sessionObject.getCompanyCode());
	    limitSchemaSC.setPreferredLanguage(sessionObject.getPreferredLanguage());
	    
	    if(limitSchemaSC.getCifSubNo()==null 
		    || limitSchemaSC.getBranchCode()==null 
		    || limitSchemaSC.getGlCode() == null 
		    || limitSchemaSC.getCurrencyCode()== null 
		    || limitSchemaSC.getSlNo() == null)
	    {
		throw new BOException(MessageCodes.NO_RECORD_FOUND);
	    }
	    else
	    {
		int limitSchemaListCount = limitSchemaBO.returnLimitSchemaListCount(limitSchemaSC);
		if(limitSchemaListCount <= 0)
		{
		    throw new BOException(MessageCodes.NO_RECORD_FOUND);
		}
	    }
	    
	}
	catch(Exception e){
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    /**
     * Method to set the load the values for combo
     */
    private void loadGroupComboList()
    {
	try
	{
	    SelectSC selSC = new SelectSC(LimitSchemaConstant.LOV_TRANS_ID_LIMIT_SCHEMA);
	    ArrayList<SelectCO> returnLOV = (ArrayList<SelectCO>) returnLOV(selSC);
	    for(SelectCO aSelectCO : returnLOV)
	    {
		String code = aSelectCO.getCode();
		String descValue = aSelectCO.getDescValue();
		groupComboList += code + ":" + descValue + ";";
	    }
	    if(groupComboList.length() > 0)
	    {
		groupComboList = ":;" + groupComboList.substring(0, groupComboList.length() - 1);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
    }

   
    
    public String approveLimitSchemaList(){
    	try {
    		SessionCO  sessionCO   = returnSessionObject();
    		for (LimitSchemaCO limitSchemaCO : limitSchemaCOList)
    		{
		// Hasan EWBI160091 07/06/2016
		if(NumberUtil.isEmptyDecimal(limitSchemaCO.getLimitSchemaVO().getCOMP_CODE()))
		{
	    		limitSchemaCO.getLimitSchemaVO().setCOMP_CODE(sessionCO.getCompanyCode());
		}
    		}
    		limitSchemaBO.approveLimitSchema(limitSchemaCOList);
	} catch (BaseException e) {
		handleException(e, null, null);
	}    

    	return SUCCESS;
    }
    public String rejectLimitSchemaList(){    	
    	try {
		SessionCO  sessionCO   = returnSessionObject();
	    for(LimitSchemaCO limitSchemaCO : limitSchemaCOList)
	    {
		// Hasan EWBI160091 07/06/2016
		if(NumberUtil.isEmptyDecimal(limitSchemaCO.getLimitSchemaVO().getCOMP_CODE()))
		{
		    limitSchemaCO.getLimitSchemaVO().setCOMP_CODE(sessionCO.getCompanyCode());
		}
	    }
	    limitSchemaBO.rejectLimitSchema(limitSchemaCOList);
	}
	catch(BaseException e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    
    
    /**
     * @param limitSchemaBO the limitSchemaBO to set
     */
    public void setLimitSchemaBO(LimitSchemaBO limitSchemaBO)
    {
        this.limitSchemaBO = limitSchemaBO;
    }
    
    /**
     * @return the limitSchemaSC
     */
    @Override
    public Object getModel()
    {
        return limitSchemaSC;
    }

    /**
     * @return the limitSchemaSC
     */
    public LimitSchemaSC getLimitSchemaSC()
    {
        return limitSchemaSC;
    }

    /**
     * @param limitSchemaSC the limitSchemaSC to set
     */
    public void setLimitSchemaSC(LimitSchemaSC limitSchemaSC)
    {
        this.limitSchemaSC = limitSchemaSC;
    }

    /**
     * @return the cifSubNo
     */
    public BigDecimal getCifSubNo()
    {
        return cifSubNo;
    }

    /**
     * @param cifSubNo the cifSubNo to set
     */
    public void setCifSubNo(BigDecimal cifSubNo)
    {
        this.cifSubNo = cifSubNo;
    }

    /**
     * @return the branchCode
     */
    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    /**
     * @param branchCode the branchCode to set
     */
    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
    }

    /**
     * @return the compCode
     */
    public BigDecimal getCompCode()
    {
        return compCode;
    }

    /**
     * @param compCode the compCode to set
     */
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }

    /**
     * @return the limitSchemaGridJson
     */
    public String getLimitSchemaGridJson()
    {
        return limitSchemaGridJson;
    }

    /**
     * @param limitSchemaGridJson the limitSchemaGridJson to set
     */
    public void setLimitSchemaGridJson(String limitSchemaGridJson)
    {
        this.limitSchemaGridJson = limitSchemaGridJson;
    }

    /**
     * @return the limitSchemaCO
     */
    public LimitSchemaCO getLimitSchemaCO()
    {
        return limitSchemaCO;
    }

    /**
     * @param limitSchemaCO the limitSchemaCO to set
     */
    public void setLimitSchemaCO(LimitSchemaCO limitSchemaCO)
    {
        this.limitSchemaCO = limitSchemaCO;
    }

    /**
     * @return the groupComboList
     */
    public String getGroupComboList()
    {
        return groupComboList;
    }

    /**
     * @param groupComboList the groupComboList to set
     */
    public void setGroupComboList(String groupComboList)
    {
        this.groupComboList = groupComboList;
    }


	public void setShowToolBar(boolean showToolBar) {
		this.showToolBar = showToolBar;
	}

	public boolean isShowToolBar() {
		return showToolBar;
	}

    /**
     * @return the enforceSignLimit
     */
    public String getEnforceSignLimit()
    {
        return enforceSignLimit;
    }

    /**
     * @param enforceSignLimit the enforceSignLimit to set
     */
    public void setEnforceSignLimit(String enforceSignLimit)
    {
        this.enforceSignLimit = enforceSignLimit;
    }

    /**
     * @return the accountType
     */
    public String getAccountType()
    {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    /**
     * @return the status
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status)
    {
        this.status = status;
    }

    /**
     * @return the openMode
     */
    public String getOpenMode()
    {
        return openMode;
    }

    /**
     * @param openMode the openMode to set
     */
    public void setOpenMode(String openMode)
    {
        this.openMode = openMode;
    }

    
    public BigDecimal getBaseCyDecPoint()
    {
        return baseCyDecPoint;
    }

    public void setBaseCyDecPoint(BigDecimal baseCyDecPoint)
    {
        this.baseCyDecPoint = baseCyDecPoint;
    }

    public List<LimitSchemaCO> getLimitSchemaCOList() {
		return limitSchemaCOList;
	}

	public void setLimitSchemaCOList(List<LimitSchemaCO> limitSchemaCOList) {
		this.limitSchemaCOList = limitSchemaCOList;
	}

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
	this.coreCommonServiceBO = coreCommonServiceBO;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }
    
    
}
