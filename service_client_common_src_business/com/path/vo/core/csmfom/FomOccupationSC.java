package com.path.vo.core.csmfom;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class FomOccupationSC extends GridParamsSC
{
    private BigDecimal cifNo;
    
    //MODIF BMOI130018 - Joyce Kanazeh
    private BigDecimal lineNo;
    private BigDecimal compCodeCif;
    private String progRef;
    private BigDecimal salVisible;
    private String mainOccupation;
    
    //Added by Mark Ayoub on 02/06/2018 - Needed for cifType mandatory expression
    private BigDecimal cifType;
    //End Mark

    public BigDecimal getSalVisible()
    {
        return salVisible;
    }

    public void setSalVisible(BigDecimal salVisible)
    {
        this.salVisible = salVisible;
    }

    public String getProgRef()
    {
        return progRef;
    }

    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }
    
    //END MODIF

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    /**
     * @return the lineNo
     */
    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    /**
     * @param lineNo the lineNo to set
     */
    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }
    
    // MODIF BMOI130018

    public String getMainOccupation()
    {
        return mainOccupation;
    }

    public void setMainOccupation(String mainOccupation)
    {
        this.mainOccupation = mainOccupation;
    }

    public BigDecimal getCifType()
    {
        return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
        this.cifType = cifType;
    }
    
    // End modif
    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }
    
    
}
