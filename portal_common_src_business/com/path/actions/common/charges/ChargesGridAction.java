package com.path.actions.common.charges;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.entitycharges.EntityChargesBO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_CHARGES_ENTITYVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.GridUpdates;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.entitycharges.CtsChargesEntityCO;
import com.path.vo.core.entitycharges.EntityChargesCO;

@SuppressWarnings("unchecked")
public class ChargesGridAction extends GridBaseAction
{
    private EntityChargesCO entityChargesCO = new EntityChargesCO();
    private EntityChargesBO entityChargesBO;
    private String chargesGridJSON;
    private CTS_CHARGES_ENTITYVO ctsChargesEntityVO;
    private CTS_CHARGES_ENTITYVO vatCtsChargesEntityVO;

    @Override
    public Object getModel()
    {
	return entityChargesCO;
    }

    public String loadChargesEntityGrid()
    {
	try
	{
	
	    SessionCO sessionCO = returnSessionObject();

	    entityChargesCO.setLoginCompCode(sessionCO.getCompanyCode());
	    entityChargesCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(NumberUtil.isEmptyDecimal(entityChargesCO.getLoginBraCode()))
	    {
		entityChargesCO.setLoginBraCode(sessionCO.getBranchCode());
	    }
	    entityChargesCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	    entityChargesCO.setRunningDate(sessionCO.getRunningDateRET());
	    entityChargesCO.setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
	    entityChargesCO.setLoginUserId(sessionCO.getUserName());
	    entityChargesCO.setLanguage(sessionCO.getLanguage());
	    if(null == sessionCO.getCtsTellerVO())
	    {
		if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getOriginalAppName()))
		{
		    BigDecimal compCode = sessionCO.getCompanyCode();
		    BigDecimal branchCode = sessionCO.getBranchCode();
		    // String apName = sessionCO.getCurrentAppName();
		    CTSTELLERVO ctsTellerVO = returnCommonLibBO().returnCtsTellerDetails(compCode, branchCode, sessionCO.getUserName());
		    entityChargesCO.setLoginTellerCode(ctsTellerVO.getCODE());
		}
	    }
	    else
	    {
		// fill Teller details
    	    	entityChargesCO.setLoginTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
	    
	    List<CtsChargesEntityCO> entityChargesList;
	    if(entityChargesCO.getIsEmptied())
	    {
//		if("CHQ".equals(entityChargesCO.getEntityType()) 
//			|| "SAF".equals(entityChargesCO.getEntityType())
//			|| CoreCommonConstants.CARDS_MANAGEMENT_ENTITY_TYPE.equals(entityChargesCO.getEntityType())
//			|| "LOS".equals(entityChargesCO.getEntityType())||"CER".equals(entityChargesCO.getEntityType())
//			|| "SMS".equals(entityChargesCO.getEntityType())
//			|| "REQ".equals(entityChargesCO.getEntityType())
//			|| "PAS".equals(entityChargesCO.getEntityType()))
//		{
//		    entityChargesCO = entityChargesBO.calculateUnifiedCharges(entityChargesCO);
//		}
//		else
//		{
//		    entityChargesCO = entityChargesBO.selectCharges(entityChargesCO);   
//		}
		//Rakan Makarem - #509059 Apply the charge hash table to solve the Deadlocks 
		entityChargesCO = entityChargesBO.calculateUnifiedChargesHash(entityChargesCO);
		entityChargesList = entityChargesCO.getCtsChargesEntityCOs();
	    }
	    else
	    {  
	    	entityChargesCO = entityChargesBO.setChargeAcc(entityChargesCO);
	    	entityChargesCO = entityChargesBO.calculateChargeCurrencyDecimalPoints(entityChargesCO);
		entityChargesList = entityChargesBO.retrieveCtsChargesEntityCOList(entityChargesCO);
	    }

	    for(int i = 0; i < entityChargesList.size(); i++)
	    {
		entityChargesList.get(i).setEntityChargeKey(i + 1 + "_" + entityChargesCO.getTypeInd());
		entityChargesList.get(i).setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
		entityChargesList.get(i).setChrgsCurrDecPoint(entityChargesCO.getChargeCurrDecPoint());
	    }

	    setGridModel(entityChargesList);
	    
	    if(!"1".equals(StringUtil.nullToEmpty(entityChargesCO.getAppMultiCharges())))
	    //if(NumberUtil.emptyDecimalToZero(entityChargesCO.getMaxLosDocAmt()).compareTo(BigDecimal.ZERO) <= 0)//Abdo DCR509649 25/04/2017
	    {
		HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
		String parentOpt = returnCommonLibBO().returnOptDetailsList("RET", get_pageRef())[3];
		String PARENT_OPT = "N001";
		if(PARENT_OPT.equals(parentOpt))
		{
		    gridFooterMap.put("chargeDesc", getText("Total_for_one_document_CVFC_key"));
		}
		else
		{
		    gridFooterMap.put("chargeDesc", getText("Total_key"));
		}
		gridFooterMap.put("ctsChargesEntityVO.AMOUNT", entityChargesCO.getTotalAmount());
		gridFooterMap.put("ctsChargesEntityVO.AMOUNT_FC", entityChargesCO.getTotalAmountFc());
		setUserdata(gridFooterMap);
	    }
	    //DASI170045 - Commission on Cheque Deposit
	    if(NumberUtil.emptyDecimalToZero(entityChargesCO.getMaxCerticateAmt()).compareTo(BigDecimal.ZERO) <= 0)//Abdo DCR509649 25/04/2017
	    {
		HashMap<String, Object> gridFooterMap = new HashMap<String, Object>();
		String parentOpt = returnCommonLibBO().returnOptDetailsList("RET", get_pageRef())[3];
		String PARENT_OPT = "P0049";
		if(PARENT_OPT.equals(parentOpt))
		{
		    gridFooterMap.put("chargeDesc", getText("Total_for_one_document_CVFC_key"));
		}
		else
		{
		    gridFooterMap.put("chargeDesc", getText("Total_key"));
		}
		gridFooterMap.put("ctsChargesEntityVO.AMOUNT", entityChargesCO.getTotalAmount());
		gridFooterMap.put("ctsChargesEntityVO.AMOUNT_FC", entityChargesCO.getTotalAmountFc());
		setUserdata(gridFooterMap);
	    }
	    //abir
	    //Rania - Changed due to BMO190043
            if(entityChargesCO.getErrorCode() != null && entityChargesCO.getErrorCode().intValue() != 0 && entityChargesCO.getErrorMsg() != null)
            {
        	set_warning(entityChargesCO.getErrorMsg());
            }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    public String dependencyByAMT()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    entityChargesCO.setLoginBraCode(sessionCO.getBranchCode());
	    entityChargesCO.setLoginCompCode(sessionCO.getCompanyCode());
	    entityChargesCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    if(CoreCommonConstants.CHEQUEBOOK_ENTITY_TYPE.equals(entityChargesCO.getEntityType()))
	    {
		entityChargesCO.setEntityCommand(CoreCommonConstants.CHEQUEBOOK_ENTITY_TYPE);
	    }
	    else
	    {
		entityChargesCO.setEntityCommand("GEN");
	    }
	    CtsChargesEntityCO ctsChargesEntityCO = new CtsChargesEntityCO();
	    ctsChargesEntityCO.setCtsChargesEntityVO(ctsChargesEntityVO);
	    ctsChargesEntityCO.setVatCtsChargesEntityVO(vatCtsChargesEntityVO);
	    ArrayList<CtsChargesEntityCO> ctsChargesEntityCOList = new ArrayList<CtsChargesEntityCO>();
	    ctsChargesEntityCOList.add(ctsChargesEntityCO);
	    entityChargesCO.setCtsChargesEntityCOs(ctsChargesEntityCOList);
	    entityChargesCO.setRunningDate(sessionCO.getRunningDateRET());

	    entityChargesCO.getCtsChargesEntityCOs().get(0).setBaseCurrDecPoint(sessionCO.getBaseCurrDecPoint());
	    
	    
	    entityChargesCO = entityChargesBO.dependencyByAMT(entityChargesCO);
	    
	    entityChargesCO.getCtsChargesEntityCOs().get(0).setChrgsCurrDecPoint(entityChargesCO.getChargeCurrDecPoint());
	    
	}
	catch(BaseException e)
	{
	    log.error(e, "Error in Dependency by amount 	of ChargesGridAction");
	    handleException(e, null, null);
	    return SUCCESS;
	}
	return "dependencyByAmt";
    }

    public String waiveCharges()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    entityChargesCO.setLoginCompCode(sessionCO.getCompanyCode());
	    entityChargesCO.setBaseCurrencyCode(sessionCO.getBaseCurrencyCode());
	    entityChargesCO.setLoginBraCode(sessionCO.getBranchCode());
	    entityChargesCO.setLoginPreferrredLanguage(sessionCO.getPreferredLanguage());
	    entityChargesCO.setRunningDate(sessionCO.getRunningDateRET());
	    
	    if(!"".equals(entityChargesCO.getGridJsonStr()) && !"{\"root\":{}}".equals(entityChargesCO.getGridJsonStr()))
	    {
		GridUpdates gu = getGridUpdates(entityChargesCO.getGridJsonStr(), CtsChargesEntityCO.class, true);
		entityChargesCO.setCtsChargesEntityCOs(gu.getLstAllRec());
	    }
	    
	    entityChargesCO = entityChargesBO.waiveCharges(entityChargesCO);

	}
	catch(BaseException e)
	{
	    log.error(e, "Error in waiveCharges - Charges Action");
	    handleException(e, null, null);
	    return SUCCESS;
	}
	return "dependencyByAmt";
    }

    public void setEntityChargesBO(EntityChargesBO entityChargesBO)
    {
	this.entityChargesBO = entityChargesBO;
    }

    public void setEntityChargesCO(EntityChargesCO entityChargesCO)
    {
	this.entityChargesCO = entityChargesCO;
    }

    public EntityChargesCO getEntityChargesCO()
    {
	return entityChargesCO;
    }

    public void setChargesGridJSON(String chargesGridJSON)
    {
	this.chargesGridJSON = chargesGridJSON;
    }

    public String getChargesGridJSON()
    {
	return chargesGridJSON;
    }

    public void setCtsChargesEntityVO(CTS_CHARGES_ENTITYVO ctsChargesEntityVO)
    {
	this.ctsChargesEntityVO = ctsChargesEntityVO;
    }

    public CTS_CHARGES_ENTITYVO getCtsChargesEntityVO()
    {
	return ctsChargesEntityVO;
    }

    public void setVatCtsChargesEntityVO(CTS_CHARGES_ENTITYVO vatCtsChargesEntityVO)
    {
	this.vatCtsChargesEntityVO = vatCtsChargesEntityVO;
    }

    public CTS_CHARGES_ENTITYVO getVatCtsChargesEntityVO()
    {
	return vatCtsChargesEntityVO;
    }

}
