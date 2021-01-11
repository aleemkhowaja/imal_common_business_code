package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_JOINT_ID_DETAILSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class FOMJointIdsCO extends RetailBaseVO
{

//    private BigDecimal CIF_NO;
//    private BigDecimal COMP_CODE;
//    private BigDecimal ID_TYPE_CODE;
//    private String ID_NO;
//    private String ID_TYPE_MAND_YN;    
//    private String ID_CARD_TYPE;
//    private String joinType;
//    private BigDecimal cifTypeCode;

    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private CIF_JOINT_ID_DETAILSVO cifJointIdDetailsVO = new CIF_JOINT_ID_DETAILSVO();  
    private String idTypeDesc;
    
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
   // private BigDecimal BRANCH_CODE;
    private BigDecimal cifTypeCode;
    
    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

   

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

  

   

    public CIF_JOINT_ID_DETAILSVO getCifJointIdDetailsVO()
    {
        return cifJointIdDetailsVO;
    }

    public void setCifJointIdDetailsVO(CIF_JOINT_ID_DETAILSVO cifJointIdDetailsVO)
    {
        this.cifJointIdDetailsVO = cifJointIdDetailsVO;
    }

    public BigDecimal getCifTypeCode()
    {
        return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
        this.cifTypeCode = cifTypeCode;
    }

}