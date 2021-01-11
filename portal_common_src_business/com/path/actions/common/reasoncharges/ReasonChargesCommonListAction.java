package com.path.actions.common.reasoncharges;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.reasoncharges.ReasonChargesCommonBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.dbmaps.vo.CIFVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.reasoncharges.ReasonChargesCommonCO;
import com.path.vo.common.reasoncharges.ReasonChargesCommonSC;
import com.path.vo.core.csmfom.FomCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * ReasonChargesCommonListAction.java used to
 */
public class ReasonChargesCommonListAction extends GridBaseAction
{
	 private ReasonChargesCommonCO reasonChargesCO = new ReasonChargesCommonCO();
	 private ReasonChargesCommonBO reasonChargesBO;
	 private ReasonChargesCommonSC criteria = new ReasonChargesCommonSC();
	 private BigDecimal cifCode;
	 private BigDecimal cif_Type;
	 private Boolean _popupBtnAddFlag = true;
	 private Boolean _popupBtnDelFlag = true;
	 private Boolean _popupReadOnlyMode = false;
	 private String reasonStr;
	 private String cifStatus ;
	 private Date cif_UpdateDate ;
	 private String latestCifupdateDate ;
	 private String callingScreen ;
	
	public String loadReasonChargesGrid()
	{
	      String[] searchCol = {"TRXTYPE_CODE","TRX_TYPE_NAME","CHARGE_CODE","CHARGE_NAME","CASH_ACCOUNT"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
	    	  
		    criteria.setSearchCols(searchCol);

		    copyproperties(criteria);
		        
		    criteria.setCompCode(returnSessionObject().getCompanyCode());
		    criteria.setCompCodeCif(NumberUtil.nullEmptyToValue(criteria.getCompCodeCif(), criteria.getCompCode()));//Hasan EWBI160091 16/06/2016
			//criteria.setCifNo(new BigDecimal(12)) ;
		    
		    //Hasan EWBI160091 10/06/2016
	    if(NumberUtil.isEmptyDecimal(criteria.getCompCodeCif())
		    || NumberUtil.isNumberPositive(criteria.getCompCodeCif()))
	    {
		criteria.setCurrAppName(returnSessionObject().getCurrentAppName());
		int cpt = reasonChargesBO.checkNegativeComp(criteria);
		if(cpt == 1)
		{
		    criteria.setCompCodeCif(criteria.getCompCode().negate());
		}
	    }
		    //End Hasan
			
			/**
			 *  set number of rows to be displayed in the page of grid, and the
			 * total number of records for first time load only
			 */
			if(checkNbRec(criteria))
			{
				setRecords(reasonChargesBO.getReasonChargesListCount(criteria));
			}

			/**
			 *  return the collection of records
			 */
			List<ReasonChargesCommonCO> reasonChargesList = reasonChargesBO.getReasonChargesList(criteria);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(reasonChargesList);
			
			}
		catch(Exception e)
		{
			log.error(e, "Error in FOM Reason Charges List Grid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

    // Action called when Void Charges button in FOM Screen is clicked
    public String populateReasonChargesPopup()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    reasonChargesCO.setIv_crud(getIv_crud());
	    reasonChargesCO.setCifStatus(getCifStatus());
	    reasonChargesCO.setCtsTellerVO(sessionCO.getCtsTellerVO());
	    reasonChargesCO.setCOMP_CODE(sessionCO.getCompanyCode());
	    reasonChargesCO.setCIF_NO(cifCode);

	    FomCO fomCO = new FomCO();
	    fomCO.getCifVO().setSTATUS(getCifStatus());
	    fomCO.getCifVO().setCIF_NO(cifCode);

	    reasonChargesCO = reasonChargesBO.initialiseOnModeNew(reasonChargesCO,fomCO);

	    String originOptRef = "";
	    if(StringUtil.isNotEmpty(get_pageRef()))
	    {
		originOptRef = returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef());
	    }		
	    if((getIv_crud().equalsIgnoreCase("R") && FomConstant.MAINTENANCE_OPT.equalsIgnoreCase(originOptRef)) 
		    && reasonChargesCO.getAccesByTeller()) // check whether to make fields read-only
	    {
		set_popupBtnAddFlag(true);
	    }
	    else
	    {
		set_popupBtnAddFlag(false);
		set_popupBtnDelFlag(false);
		set_popupReadOnlyMode(true);
		set_recReadOnly("true");
	    }
	}
    	catch(BaseException e)
    	{
    		handleException(e, "Error in loading populateReasonChargesPopup", null);
    	}
	return "populateReasonChargesPopup";
    }
    
    @Override
    public Object getModel()
    {
	return criteria;
    }
	
    private void prepareAuditObject(ReasonChargesCommonCO reasonChargesCommonCO)
    {
	AuditRefCO refCO = initAuditRefCO();
	refCO.setOperationType(AuditConstant.UPDATE);
	refCO.setKeyRef(AuditConstant.FOM_KEY_REF);
	reasonChargesCommonCO.setAuditRefCO(refCO);
	FomCO fomCO = new FomCO();
	reasonChargesCommonCO.setAuditObj(returnAuditObject(fomCO.getClass()));
    }
	
    public String save()
    {
	try
	{
	    GridUpdates gu = getGridUpdates(reasonStr, ReasonChargesCommonCO.class, true);

	    List<ReasonChargesCommonCO> reasonChargesList = gu.getLstAllRec();

	    ReasonChargesCommonCO reasonChargesCommonCO = new ReasonChargesCommonCO();
	    reasonChargesCommonCO.setCIF_NO(getCifCode());
	    reasonChargesCommonCO.setCOMP_CODE(NumberUtil.nullEmptyToValue(criteria.getCompCodeCif(),returnSessionObject().getCompanyCode()));//Hasan EWBI160091 08/06/2016
	    reasonChargesCommonCO.setCif_UpdateDate(getCif_UpdateDate());
	    reasonChargesCommonCO.setRunningDate(returnSessionObject().getRunningDateRET());
	    reasonChargesCommonCO.setIv_crud(getIv_crud());
	    reasonChargesCommonCO.setCifStatus(getCifStatus());
	    reasonChargesCommonCO.setCifType(getCif_Type());
	    reasonChargesCommonCO.setCtsTellerVO(returnSessionObject().getCtsTellerVO());
	    reasonChargesCommonCO.setScreenName(getCallingScreen());
	    reasonChargesCommonCO.setCheckApprovedByAccess(reasonChargesCO.getCheckApprovedByAccess());
	    prepareAuditObject(reasonChargesCommonCO);
	    CIFVO cifVo = reasonChargesBO.updateReasonChargeDetail(reasonChargesList, reasonChargesCommonCO);
	    if(cifVo != null)
	    {
	    	//EWBI160091 (403157)- reset the hidden value
		reasonChargesCO.setCOMP_CODE( NumberUtil.nullToZero(cifVo.getCOMP_CODE()));
	    }

	    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss:SSS", Locale.ENGLISH);
	    latestCifupdateDate = df.format(cifVo.getDATE_UPDATED());
	    setCifStatus(cifVo.getSTATUS());
	  
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

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

    public BigDecimal getCif_Type()
    {
	return cif_Type;
    }

    public void setCif_Type(BigDecimal cifType)
    {
	cif_Type = cifType;
    }

    public Boolean get_popupBtnDelFlag()
    {
	return _popupBtnDelFlag;
    }

    public void set_popupBtnDelFlag(Boolean popupBtnDelFlag)
    {
	_popupBtnDelFlag = popupBtnDelFlag;
    }

    public Boolean get_popupBtnAddFlag()
    {
	return _popupBtnAddFlag;
    }

    public void set_popupBtnAddFlag(Boolean popupBtnAddFlag)
    {
	_popupBtnAddFlag = popupBtnAddFlag;
    }

    public String getCallingScreen()
    {
	return callingScreen;
    }

    public void setCallingScreen(String callingScreen)
    {
	this.callingScreen = callingScreen;
    }

    public Boolean get_popupReadOnlyMode()
    {
	return _popupReadOnlyMode;
    }

    public void set_popupReadOnlyMode(Boolean popupReadOnlyMode)
    {
	_popupReadOnlyMode = popupReadOnlyMode;
    }

    public BigDecimal getCifCode()
    {
	return cifCode;
    }

    public void setCifCode(BigDecimal cifCode)
    {
	this.cifCode = cifCode;
    }

    public ReasonChargesCommonCO getReasonChargesCO()
    {
	return reasonChargesCO;
    }

    public void setReasonChargesCO(ReasonChargesCommonCO reasonChargesCO)
    {
	this.reasonChargesCO = reasonChargesCO;
    }

    public ReasonChargesCommonSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(ReasonChargesCommonSC criteria)
    {
	this.criteria = criteria;
    }

    public void setReasonChargesBO(ReasonChargesCommonBO reasonChargesBO)
    {
	this.reasonChargesBO = reasonChargesBO;
    }

    public String getReasonStr()
    {
	return reasonStr;
    }

    public void setReasonStr(String reasonStr)
    {
	this.reasonStr = reasonStr;
    }

}
