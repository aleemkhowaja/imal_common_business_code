/**
 * 
 */
package com.path.vo.common.reasoncharges;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSREASONS_CHARGESVOKey;
import com.path.dbmaps.vo.CTSTELLERVO;

public class ReasonChargesCommonCO extends CTSREASONS_CHARGESVOKey implements Serializable
{
    private String REASON_NAME;
    private String CHARGE_NAME;
    private String VISIBLE_ROW;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private BigDecimal CIF_NO;
    private BigDecimal cifType;
    private BigDecimal COMP_CODE;
    private Boolean accesByTeller = true;
    private Date runningDate;
    private String screenName;
    private String checkApprovedByAccess;
    
    public final String getCheckApprovedByAccess()
    {
        return checkApprovedByAccess;
    }

    public final void setCheckApprovedByAccess(String checkApprovedByAccess)
    {
        this.checkApprovedByAccess = checkApprovedByAccess;
    }

    public String getREASON_NAME()
    {
	return REASON_NAME;
    }

    public void setREASON_NAME(String rEASONNAME)
    {
	REASON_NAME = rEASONNAME;
    }

    public String getCHARGE_NAME()
    {
	return CHARGE_NAME;
    }

    public void setCHARGE_NAME(String cHARGENAME)
    {
	CHARGE_NAME = cHARGENAME;
    }

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

    public BigDecimal getCIF_NO()
    {
	return CIF_NO;
    }

    public void setCIF_NO(BigDecimal cIFNO)
    {
	CIF_NO = cIFNO;
    }

    public BigDecimal getCOMP_CODE()
    {
	return COMP_CODE;
    }

    public void setCOMP_CODE(BigDecimal cOMPCODE)
    {
	COMP_CODE = cOMPCODE;
    }

    public String getVISIBLE_ROW()
    {
	return VISIBLE_ROW;
    }

    public void setVISIBLE_ROW(String vISIBLEROW)
    {
	VISIBLE_ROW = vISIBLEROW;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }

    public Date getRunningDate()
    {
        return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
        this.runningDate = runningDate;
    }

    public String getScreenName()
    {
        return screenName;
    }

    public void setScreenName(String screenName)
    {
        this.screenName = screenName;
    }

}
