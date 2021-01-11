/**
 * 
 */
package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIF_LEGAL_STATUS_DOCUMENTSVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: EliasAoun
 * 
 *          FOMRequiredDocCO.java used to
 */
public class FOMRequiredDocCO extends RetailBaseVO
{
    CIF_LEGAL_STATUS_DOCUMENTSVO cifLegalStatusDocVO = new CIF_LEGAL_STATUS_DOCUMENTSVO();
    List<FOMRequiredDocCO> requiredDocLst = new ArrayList<FOMRequiredDocCO>();
    private BigDecimal compCodeCif;
    
    

    public CIF_LEGAL_STATUS_DOCUMENTSVO getCifLegalStatusDocVO()
    {
	return cifLegalStatusDocVO;
    }

    public void setCifLegalStatusDocVO(CIF_LEGAL_STATUS_DOCUMENTSVO cifLegalStatusDocVO)
    {
	this.cifLegalStatusDocVO = cifLegalStatusDocVO;
    }

    public List<FOMRequiredDocCO> getRequiredDocLst()
    {
	return requiredDocLst;
    }

    public void setRequiredDocLst(List<FOMRequiredDocCO> requiredDocLst)
    {
	this.requiredDocLst = requiredDocLst;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

}
