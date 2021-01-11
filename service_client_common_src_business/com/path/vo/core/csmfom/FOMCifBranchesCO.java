package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CIF_BRANCHESVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Hasan Youssef
 * 
 *          FOMCifBranchesCO.java used to
 */
public class FOMCifBranchesCO extends RetailBaseVO
{
    private CIF_BRANCHESVO cifBranchesVO = new CIF_BRANCHESVO();
    private String cifStatus;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Date runningDate;
    private BigDecimal compCodeCif;
    private BigDecimal cifNo;
    private String preferredLanguage;
    
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

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public void setCifBranchesVO(CIF_BRANCHESVO cifBranchesVO)
    {
	this.cifBranchesVO = cifBranchesVO;
    }

    public CIF_BRANCHESVO getCifBranchesVO()
    {
	return cifBranchesVO;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public String getPreferredLanguage()
    {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage)
    {
        this.preferredLanguage = preferredLanguage;
    }

}
