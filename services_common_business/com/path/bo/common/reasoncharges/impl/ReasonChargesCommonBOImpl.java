package com.path.bo.common.reasoncharges.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.bo.common.reasoncharges.ReasonChargesCommonBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.bo.core.common.CoreCommonConstants;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.bo.core.csmfom.FomConstant;
import com.path.bo.core.csmfom.NCifMaintenanceConstant;
import com.path.dao.common.reasoncharges.ReasonChargesCommonDAO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSREASONS_CHARGESVO;
import com.path.dbmaps.vo.CTSREASONS_CHARGESVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.reasoncharges.ReasonChargesCommonCO;
import com.path.vo.common.reasoncharges.ReasonChargesCommonSC;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.csmfom.FomCO;

public class ReasonChargesCommonBOImpl extends RetailBaseBO implements ReasonChargesCommonBO
{
    ReasonChargesCommonDAO reasonChargesDAO;
    private CoreCommonServiceBO coreCommonServiceBO;

    
    @Override
    public List getReasonChargesList(ReasonChargesCommonSC criteria) throws BaseException
    {
	return reasonChargesDAO.getReasonChargesList(criteria);
    }

    
    @Override
    public int getReasonChargesListCount(ReasonChargesCommonSC criteria) throws BaseException
    {
	return reasonChargesDAO.getReasonChargesListCount(criteria);
    }

    
    // ADDED BY JIHAD IN ORDER TO SVE UPDATE DELETED DETAILS OF CHARGE
    public CIFVO updateReasonChargeDetail(List<ReasonChargesCommonCO> lst, ReasonChargesCommonCO reasonChargesCommonCO)
	    throws BaseException
    {

	CIFVO cifVo = new CIFVO();
	CTSREASONS_CHARGESVO reasonChargeVO = new CTSREASONS_CHARGESVO();

	Integer AccessDescriptionNumber = NCifMaintenanceConstant.TRANSACTION_TYPE_CHARGES;
	boolean checkAcess = false;

	cifVo.setCIF_NO(reasonChargesCommonCO.getCIF_NO());
	cifVo.setCOMP_CODE(reasonChargesCommonCO.getCOMP_CODE());
	cifVo.setDATE_UPDATED(commonLibBO.addSystemTimeToDate(reasonChargesCommonCO.getRunningDate()));
	cifVo.setSTATUS(reasonChargesCommonCO.getCifStatus());


	// Falha IDB190066 - CIF Status Changed to Inactive When Updating
	// Signature Details
	cifVo.setMODIFIED_BY(reasonChargesCommonCO.getAuditRefCO().getUserID());
	cifVo.setDATE_MODIFIED(commonLibBO.addSystemTimeToDate(reasonChargesCommonCO.getRunningDate()));
	// Falha IDB190066 - CIF Status Changed to Inactive When Updating
	// Signature Details
	//if(null != reasonChargesCommonCO.getCif_UpdateDate())
	//{
	    coreCommonServiceBO.updateMainCifData(cifVo, reasonChargesCommonCO.getCif_UpdateDate());
	//}
	String crud = reasonChargesCommonCO.getIv_crud();
	if("true".equals(reasonChargesCommonCO.getCheckApprovedByAccess()))
	{
	    crud = reasonChargesCommonCO.getIv_crud()+"-"+reasonChargesCommonCO.getCOMP_CODE()+"-"+reasonChargesCommonCO.getCIF_NO();
	}
	checkAcess = coreCommonServiceBO.checkIfDataCanModified(reasonChargesCommonCO.getCtsTellerVO(),
		reasonChargesCommonCO.getCifStatus(), crud, AccessDescriptionNumber);

	if(checkAcess)
	{
	    ReasonChargesCommonSC reasonChargesSC = new ReasonChargesCommonSC();
	    reasonChargesSC.setCompCode(reasonChargesCommonCO.getCOMP_CODE());
	    reasonChargesSC.setCompCodeCif(reasonChargesCommonCO.getCOMP_CODE());//Hasan EWBI160091 16/06/2016
	    reasonChargesSC.setShowCharge(FomConstant.SHOW_CHARGE_ON);
	    reasonChargesSC.setCifNo(reasonChargesCommonCO.getCIF_NO());
	    reasonChargesSC.setCiftype(reasonChargesCommonCO.getCifType());
	    reasonChargesSC.setNbRec(-1);
	    reasonChargesSC.setScreenName(reasonChargesCommonCO.getScreenName());
	    List<ReasonChargesCommonCO> oldLstCO = reasonChargesDAO.getReasonChargesList(reasonChargesSC);

	    // you must delete all the child and the existing limits
	    reasonChargesSC.setEntityType(FomConstant.ENTITY_TYPE_CHARGE);
	    reasonChargesDAO.deleteReasonchargesList(reasonChargesSC);

	    List<CTSREASONS_CHARGESVOKey> oldLstVO = new ArrayList<CTSREASONS_CHARGESVOKey>();
	    List<CTSREASONS_CHARGESVOKey> newLstVO = new ArrayList<CTSREASONS_CHARGESVOKey>();
	    if(null != oldLstCO && oldLstCO.isEmpty())
	    {
		oldLstVO.add(new CTSREASONS_CHARGESVOKey());
	    }
	    if(null != lst && lst.isEmpty())
	    {
		newLstVO.add(new CTSREASONS_CHARGESVOKey());
	    }
	    for(ReasonChargesCommonCO reasonChargesCO : oldLstCO)
	    {
		reasonChargeVO.setCOMP_CODE(reasonChargesCommonCO.getCOMP_CODE());
		reasonChargeVO.setREASON_CODE(reasonChargesCO.getREASON_CODE());
		reasonChargeVO.setENTITY_TYPE(reasonChargesCO.getENTITY_TYPE());
		reasonChargeVO.setENTITY_CODE(reasonChargesCO.getCIF_NO());
		reasonChargeVO.setCHARGE_CODE(reasonChargesCO.getCHARGE_CODE());
		oldLstVO.add(reasonChargeVO);
	    }

	    BigDecimal lineNo = BigDecimal.ONE;
	    for(ReasonChargesCommonCO reasonChargesCO : lst)
	    {
		reasonChargeVO.setCOMP_CODE(reasonChargesCommonCO.getCOMP_CODE());
		reasonChargeVO.setREASON_CODE(reasonChargesCO.getREASON_CODE());
		reasonChargeVO.setENTITY_TYPE(FomConstant.ENTITY_TYPE_CHARGE);
		reasonChargeVO.setENTITY_CODE(reasonChargesCommonCO.getCIF_NO());
		reasonChargeVO.setCHARGE_CODE(reasonChargesCO.getCHARGE_CODE());
		reasonChargeVO.setLINE_NO(lineNo);
		lineNo = lineNo.add(BigDecimal.ONE);
		newLstVO.add(reasonChargeVO);
		genericDAO.insert(reasonChargeVO);
	    }

	    auditBO.callAudit(cifVo, coreCommonServiceBO.returnCifAbs(cifVo), reasonChargesCommonCO.getAuditRefCO());
	    auditBO.callAudit(oldLstVO, newLstVO, reasonChargesCommonCO.getAuditRefCO());
	    auditBO.insertAudit(reasonChargesCommonCO.getAuditRefCO());

	    // Hasan EWBI160091 16/06/2016
	    if(FomConstant.FOM_SCREEN_NAME.equals(reasonChargesCommonCO.getScreenName()))
	    {
		// Hasan EWBI160091 06/06/2016
		CifSC cifSC = new CifSC();
		cifSC.setCompCode(reasonChargesCommonCO.getCOMP_CODE().abs());
		cifSC.setCif_no(cifVo.getCIF_NO());
		cifSC.setCifAlertStatus(FomConstant.CIF_ALERT_STATUS_S);
		cifSC.setFlag(null);
		cifSC = coreCommonServiceBO.callCifUpdate(cifSC);
		if(cifSC != null && !NumberUtil.isEmptyDecimal(cifSC.getCompCodeCif()))
		{
		    cifVo.setCOMP_CODE(cifSC.getCompCodeCif());
		}
            }
	}
	// }

	return cifVo;

    }
	
    
    public ReasonChargesCommonCO initialiseOnModeNew(ReasonChargesCommonCO reasonChargesCO, FomCO fomCO)
	    throws BaseException
    {
	/* 
	 * If ivCrud = R or CIF not Draft
	 */
	if(reasonChargesCO.getIv_crud().equalsIgnoreCase("R") && !coreCommonServiceBO.checkCifIsDraft(fomCO))
	{
	    // Checking to get whether Teller has Access
	    Integer AccessDescriptionNumber = NCifMaintenanceConstant.VOID_REASON_CHARGES;
	    String crud = reasonChargesCO.getIv_crud();
	    if("true".equals(reasonChargesCO.getCheckApprovedByAccess()))
	    {
		crud = reasonChargesCO.getIv_crud()+"-"+reasonChargesCO.getCOMP_CODE()+"-"+reasonChargesCO.getCIF_NO();
	    }
	    boolean checkAcess = coreCommonServiceBO.checkIfDataCanModified(reasonChargesCO.getCtsTellerVO(),
		    reasonChargesCO.getCifStatus(), crud, AccessDescriptionNumber);

	    reasonChargesCO.setAccesByTeller(checkAcess);

	}
	return reasonChargesCO;
    }

    
    public ReasonChargesCommonDAO getReasonChargesDAO()
    {
	return reasonChargesDAO;
    }

    
    public void setReasonChargesDAO(ReasonChargesCommonDAO reasonChargesDAO)
    {
	this.reasonChargesDAO = reasonChargesDAO;
    }


    @Override
    public int checkNegativeComp(ReasonChargesCommonSC criteria) throws BaseException
    {
	CifSC cifSC = new CifSC();
	cifSC.setCompCode(criteria.getCompCode());
	cifSC.setCif_no(criteria.getCifNo());
	cifSC.setSectionKey(criteria.getSectionKey());
	cifSC.setCurrAppName(criteria.getCurrAppName());
	return coreCommonServiceBO.checkNegativeComp(cifSC);
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
