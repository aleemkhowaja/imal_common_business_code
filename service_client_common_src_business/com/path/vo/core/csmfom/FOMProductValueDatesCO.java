package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_PRODUCT_VDATEVO;
import com.path.vo.core.common.RetailBaseVO;

/**
 * 
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: Reda Charabaty
 * 
 *          FOMProductValueDatesCO.java used to
 */
public class FOMProductValueDatesCO extends RetailBaseVO
{

    private BigDecimal cifNo;
    private String cifName;

    private CTS_PRODUCT_VDATEVO ctsProductVDateVO = new CTS_PRODUCT_VDATEVO();
    private String entityDesc;

    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String cifStatus;
    
    private Date cif_UpdateDate;
    private BigDecimal lineNo;
    
    
    public String getCifName()
    {
        return cifName;
    }

    public void setCifName(String cifName)
    {
        this.cifName = cifName;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public CTS_PRODUCT_VDATEVO getCtsProductVDateVO()
    {
        return ctsProductVDateVO;
    }

    public void setCtsProductVDateVO(CTS_PRODUCT_VDATEVO ctsProductVDateVO)
    {
        this.ctsProductVDateVO = ctsProductVDateVO;
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

    public String getEntityDesc()
    {
        return entityDesc;
    }

    public void setEntityDesc(String entityDesc)
    {
        this.entityDesc = entityDesc;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
}
