package com.path.vo.core.trxfieldsname;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.csmfom.FOMTrxDetailsCO;

/**
 * 
 * @author Sarah Elhusseini
 *
 */
public class TrxFieldsNameSC extends GridParamsSC
{
    private BigDecimal trxType;
    private BigDecimal lineNbr;
    private BigDecimal cifNo;
    private String cifStatus;
    private String fieldName;
    private String elementName;
    private CTSTELLERVO ctsTellerVO;
    private ArrayList<FOMTrxDetailsCO> fomTrxDetailsListCOs = new ArrayList<FOMTrxDetailsCO>();

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getElementName()
    {
        return elementName;
    }

    public void setElementName(String elementName)
    {
        this.elementName = elementName;
    }

    public BigDecimal getLineNbr()
    {
        return lineNbr;
    }

    public void setLineNbr(BigDecimal lineNbr)
    {
        this.lineNbr = lineNbr;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public ArrayList<FOMTrxDetailsCO> getFomTrxDetailsListCOs()
    {
        return fomTrxDetailsListCOs;
    }

    public void setFomTrxDetailsListCOs(ArrayList<FOMTrxDetailsCO> fomTrxDetailsListCOs)
    {
        this.fomTrxDetailsListCOs = fomTrxDetailsListCOs;
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
    
    
}