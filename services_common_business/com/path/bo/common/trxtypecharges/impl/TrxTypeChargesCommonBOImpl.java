package com.path.bo.common.trxtypecharges.impl;

import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.trxtypecharges.TrxTypeChargesCommonBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.dao.common.trxtypecharges.TrxTypeChargesCommonDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTRXTYPE_CHARGESVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonCO;
import com.path.vo.common.trxtypecharges.TrxTypeChargesCommonSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.csmfom.FomCO;

public class TrxTypeChargesCommonBOImpl extends RetailBaseBO implements TrxTypeChargesCommonBO
{
    TrxTypeChargesCommonDAO trxTypeChargesDAO;
    private CoreCommonServiceBO coreCommonServiceBO;

    
    @Override
    public List getTrxTypeChargesList(TrxTypeChargesCommonSC criteria) throws BaseException
    {
	return trxTypeChargesDAO.getTrxTypeChargesList(criteria);
    }

    
    @Override
    public int getTrxTypeChargesListCount(TrxTypeChargesCommonSC criteria) throws BaseException
    {
	return trxTypeChargesDAO.getTrxTypeChargesListCount(criteria);
    }
   
	
    //ADDED BY JIHAD IN ORDER TO SVE UPDATE DELETED DETAILS OF CHARGE
    public CIFVO updateTrxTypeChargeDetail(List<TrxTypeChargesCommonCO> lst,TrxTypeChargesCommonCO trxTypeChargesCommonCO) throws BaseException
    {	
	CIFVO cifVo = new CIFVO();
	CTSTRXTYPE_CHARGESVO trxtypeVO = new CTSTRXTYPE_CHARGESVO();

	Integer AccessDescriptionNumber = NCifMaintenanceConstant.TRANSACTION_TYPE_CHARGES;
	boolean checkAcess = false;

	cifVo.setCIF_NO(trxTypeChargesCommonCO.getCIF_NO());
	cifVo.setCOMP_CODE(trxTypeChargesCommonCO.getCOMP_CODE());
	
	/*
	 * In case Date Updated is null - Reda - 03/09/2019 - #882594 - ABEI190540 - Issue in FOM Trx Type Charges
	 */
	//id:931814 Details:Error appears upon trying to save on FOM - Trx Type Charges
	if(cifVo.getDATE_UPDATED() == null)
	{
	    cifVo.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(trxTypeChargesCommonCO.getRunningDate()));
	}
	//id:931814 Details:Error appears upon trying to save on FOM - Trx Type Charges
	cifVo.setSTATUS(trxTypeChargesCommonCO.getCifStatus());
	// Falha IDB190066 - CIF Status Changed to Inactive When Updating
	// Signature Details
	cifVo.setMODIFIED_BY(trxTypeChargesCommonCO.getAuditRefCO().getUserID());
	cifVo.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(trxTypeChargesCommonCO.getRunningDate()));
	// Falha IDB190066 - CIF Status Changed to Inactive When Updating
	// Signature Details
		
	coreCommonServiceBO.updateMainCifData(cifVo, trxTypeChargesCommonCO.getCif_UpdateDate());
	String crud = trxTypeChargesCommonCO.getIv_crud();
	if("true".equals(trxTypeChargesCommonCO.getCheckApprovedByAccess()))
	{
	    crud = trxTypeChargesCommonCO.getIv_crud() + "-" + trxTypeChargesCommonCO.getCOMP_CODE() + "-"
		    + trxTypeChargesCommonCO.getCIF_NO();
	}
	checkAcess = coreCommonServiceBO.checkIfDataCanModified(trxTypeChargesCommonCO.getCtsTellerVO(),
		trxTypeChargesCommonCO.getCifStatus(), crud, AccessDescriptionNumber);
	if(checkAcess)
	{
	    // checkDataPolicyTreatment(lst , trxTypeChargesCommonCO );	
	    TrxTypeChargesCommonSC trxTypeChargesSC = new TrxTypeChargesCommonSC();
	    trxTypeChargesSC.setCompCode(trxTypeChargesCommonCO.getCOMP_CODE());
	    trxTypeChargesSC.setCompCodeCif(trxTypeChargesCommonCO.getCompCodeCif());//Hasan EWBI160091 08/06/2016
	    trxTypeChargesSC.setCifNo(trxTypeChargesCommonCO.getCIF_NO());
	    trxTypeChargesSC.setEntityType("C");
	    trxTypeChargesSC.setNbRec(-1);
	    List<TrxTypeChargesCommonCO> oldLstCO = trxTypeChargesDAO.getTrxTypeChargesList(trxTypeChargesSC);
		  
		// you must delete all the child and the existing limits 
		trxTypeChargesDAO.deleteTrxtypeChargesDetail(trxTypeChargesSC);

		List<CTSTRXTYPE_CHARGESVO> oldLstVO = new ArrayList<CTSTRXTYPE_CHARGESVO>();
		List<CTSTRXTYPE_CHARGESVO> newLstVO = new ArrayList<CTSTRXTYPE_CHARGESVO>();
		if(null != oldLstCO && oldLstCO.isEmpty())
		{
		    oldLstVO.add(new CTSTRXTYPE_CHARGESVO());
		}
		if(null != lst && lst.isEmpty())
		{
		    newLstVO.add(new CTSTRXTYPE_CHARGESVO());
		}
		for (TrxTypeChargesCommonCO trxTypeChargesCO : oldLstCO)
		{
		    //trxtypeVO.setCOMP_CODE(trxTypeChargesCommonCO.getCOMP_CODE());
		    trxtypeVO.setCOMP_CODE(trxTypeChargesCommonCO.getCompCodeCif());//Hasan EWBI160091 08/06/2016
		    trxtypeVO.setTRXTYPE_CODE(trxTypeChargesCO.getTRXTYPE_CODE());
		    trxtypeVO.setENTITY_TYPE(FomConstant.ENTITY_TYPE_CHARGE);
		    trxtypeVO.setENTITY_CODE(trxTypeChargesCommonCO.getCIF_NO());
		    trxtypeVO.setCHARGE_CODE(trxTypeChargesCO.getCHARGE_CODE());
		    trxtypeVO.setCHARGES_CY_POLICY(trxTypeChargesCO.getCHARGES_CY_POLICY());
		    trxtypeVO.setCASH_ACCOUNT(trxTypeChargesCO.getCASH_ACCOUNT());
		    oldLstVO.add(trxtypeVO);
		}
			
		//COMP_CODE, TRXTYPE_CODE, ENTITY_TYPE, ENTITY_CODE, CHARGE_CODE, CHARGES_CY_POLICY, CASH_ACCOUNT			    
		for (TrxTypeChargesCommonCO trxTypeChargesCO : lst)
		{
		    //trxtypeVO.setCOMP_CODE(trxTypeChargesCommonCO.getCOMP_CODE());
		    trxtypeVO.setCOMP_CODE(trxTypeChargesCommonCO.getCompCodeCif());//Hasan EWBI160091 08/06/2016
		    trxtypeVO.setTRXTYPE_CODE(trxTypeChargesCO.getTRXTYPE_CODE());
		    trxtypeVO.setENTITY_TYPE(FomConstant.ENTITY_TYPE_CHARGE);
		    trxtypeVO.setENTITY_CODE(trxTypeChargesCommonCO.getCIF_NO());
		    trxtypeVO.setCHARGE_CODE(trxTypeChargesCO.getCHARGE_CODE());
		    trxtypeVO.setCHARGES_CY_POLICY(trxTypeChargesCO.getCHARGES_CY_POLICY());
		    trxtypeVO.setCASH_ACCOUNT(trxTypeChargesCO.getCASH_ACCOUNT());						  
		    // trxtypeVO.setchargeCODE(trxTypeChargesCO.getCHARGE_CODE());
		    genericDAO.insert(trxtypeVO);
		    newLstVO.add(trxtypeVO);

		}
		
		auditBO.callAudit(cifVo, coreCommonServiceBO.returnCifAbs(cifVo), trxTypeChargesCommonCO.getAuditRefCO());
		auditBO.callAudit(oldLstVO, newLstVO, trxTypeChargesCommonCO.getAuditRefCO());
		auditBO.insertAudit(trxTypeChargesCommonCO.getAuditRefCO());
		
	    // Hasan EWBI160091 06/06/2016
	    CifSC cifSC = new CifSC();
	    cifSC.setCompCode(trxTypeChargesCommonCO.getCOMP_CODE());
	    cifSC.setCif_no(cifVo.getCIF_NO());
	    cifSC.setCifAlertStatus(FomConstant.CIF_ALERT_STATUS_S);
	    cifSC.setFlag(null);
	    cifSC = coreCommonServiceBO.callCifUpdate(cifSC);
	    if(cifSC != null && !NumberUtil.isEmptyDecimal(cifSC.getCompCodeCif()))
	    {
	    	cifVo.setCOMP_CODE(cifSC.getCompCodeCif());
	    }
	}
	return cifVo;
    }
   
    
    public TrxTypeChargesCommonCO initialiseOnModeNew(TrxTypeChargesCommonCO trxTypeChargesCO, FomCO fomCO)throws BaseException
    {
	/*
	 * If ivCrud = R or CIF not Draft
	 */
	if(trxTypeChargesCO.getIv_crud().equalsIgnoreCase("R") && !coreCommonServiceBO.checkCifIsDraft(fomCO))
	{
	    // Checking to get whether Teller has Access
	    Integer AccessDescriptionNumber = NCifMaintenanceConstant.TRANSACTION_TYPE_CHARGES;
	    String crud = trxTypeChargesCO.getIv_crud();
	    if("true".equals(trxTypeChargesCO.getCheckApprovedByAccess()))
	    {
		crud = trxTypeChargesCO.getIv_crud() + "-" + trxTypeChargesCO.getCOMP_CODE() + "-"
			+ trxTypeChargesCO.getCIF_NO();
	    } 
	    boolean checkAcess = coreCommonServiceBO.checkIfDataCanModified(trxTypeChargesCO.getCtsTellerVO(),
		    trxTypeChargesCO.getCifStatus(), crud, AccessDescriptionNumber);

	    trxTypeChargesCO.setAccesByTeller(checkAcess);

	}
	return trxTypeChargesCO;
    }
	
    
    public TrxTypeChargesCommonDAO getTrxTypeChargesDAO()
    {
	return trxTypeChargesDAO;
    }

    
    public void setTrxTypeChargesDAO(TrxTypeChargesCommonDAO trxTypeChargesDAO)
    {
	this.trxTypeChargesDAO = trxTypeChargesDAO;
    }

    @Override
    public int checkNegativeComp(TrxTypeChargesCommonSC trxTypeChargesCommonSC) throws BaseException
    {
	CifSC criteria = new CifSC();
	criteria.setCompCode(trxTypeChargesCommonSC.getCompCode());
	criteria.setCif_no(trxTypeChargesCommonSC.getCifNo());
	criteria.setSectionKey(trxTypeChargesCommonSC.getSectionKey());
	criteria.setCurrAppName(trxTypeChargesCommonSC.getCurrAppName());
	return coreCommonServiceBO.checkNegativeComp(criteria);
    }

    public CoreCommonServiceBO getCoreCommonServiceBO()
    {
        return coreCommonServiceBO;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
}
