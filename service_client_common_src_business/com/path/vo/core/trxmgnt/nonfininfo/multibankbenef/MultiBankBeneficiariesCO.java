package com.path.vo.core.trxmgnt.nonfininfo.multibankbenef;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRS_EXTENDEDVO;
import com.path.dbmaps.vo.CTS_NON_FIN_INFOVO;
import com.path.dbmaps.vo.CTS_NON_FIN_INFO_ALERTVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.trxmgnt.nonfininfo.morebenef.TrxMgntMoreBenefCO;

public class MultiBankBeneficiariesCO extends RetailBaseVO
{
    CTS_NON_FIN_INFOVO ctsNonFinInfoVO = new CTS_NON_FIN_INFOVO();
    CTS_NON_FIN_INFO_ALERTVO ctsNonFinInfoAlertVO =  new CTS_NON_FIN_INFO_ALERTVO();
    CTSTRSVO ctstrsVO = new CTSTRSVO();
    CTSTRS_EXTENDEDVO ctstrsExtendedVO = new CTSTRS_EXTENDEDVO();
    private BigDecimal totalAmount;
    private BigDecimal trsNo;
    private BigDecimal multiTrsNo;
    private BigDecimal trxType;
    private List<TrxMgntMoreBenefCO> ctstrsBENEFDETVOs = new ArrayList<TrxMgntMoreBenefCO>();
    private List<TrxMgntMoreBenefCO> ctstrsBenefDetAlertVOs = new ArrayList<TrxMgntMoreBenefCO>();
    private BigDecimal lineNo;
    private BigDecimal existinglineNo;
    private String emptyMoreBenef;
    
    public CTS_NON_FIN_INFOVO getCtsNonFinInfoVO()
    {
	return ctsNonFinInfoVO;
    }

    public void setCtsNonFinInfoVO(CTS_NON_FIN_INFOVO ctsNonFinInfoVO)
    {
	this.ctsNonFinInfoVO = ctsNonFinInfoVO;
    }
    
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
	this.ctstrsVO = ctstrsVO;
    }

    public CTSTRSVO getCtstrsVO()
    {
	return ctstrsVO;
    }
    
    public void setCtstrsExtendedVO(CTSTRS_EXTENDEDVO ctstrsExtendedVO)
    {
	this.ctstrsExtendedVO = ctstrsExtendedVO;
    }

    public CTSTRS_EXTENDEDVO getCtstrsExtendedVO()
    {
	return ctstrsExtendedVO;
    }
    
    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public CTS_NON_FIN_INFO_ALERTVO getCtsNonFinInfoAlertVO()
    {
        return ctsNonFinInfoAlertVO;
    }

    public void setCtsNonFinInfoAlertVO(CTS_NON_FIN_INFO_ALERTVO ctsNonFinInfoAlertVO)
    {
        this.ctsNonFinInfoAlertVO = ctsNonFinInfoAlertVO;
    }
    
    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }
    
    public BigDecimal getMultiTrsNo()
    {
        return multiTrsNo;
    }

    public void setMultiTrsNo(BigDecimal multiTrsNo)
    {
        this.multiTrsNo = multiTrsNo;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public List<TrxMgntMoreBenefCO> getCtstrsBENEFDETVOs()
    {
        return ctstrsBENEFDETVOs;
    }

    public void setCtstrsBENEFDETVOs(List<TrxMgntMoreBenefCO> ctstrsBENEFDETVOs)
    {
        this.ctstrsBENEFDETVOs = ctstrsBENEFDETVOs;
    }

    public List<TrxMgntMoreBenefCO> getCtstrsBenefDetAlertVOs()
    {
        return ctstrsBenefDetAlertVOs;
    }

    public void setCtstrsBenefDetAlertVOs(List<TrxMgntMoreBenefCO> ctstrsBenefDetAlertVOs)
    {
        this.ctstrsBenefDetAlertVOs = ctstrsBenefDetAlertVOs;
    }

    public BigDecimal getLineNo()
    {
        return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
        this.lineNo = lineNo;
    }

    public BigDecimal getExistinglineNo()
    {
        return existinglineNo;
    }

    public void setExistinglineNo(BigDecimal existinglineNo)
    {
        this.existinglineNo = existinglineNo;
    }

    public String getEmptyMoreBenef()
    {
	return emptyMoreBenef;
    }

    public void setEmptyMoreBenef(String emptyMoreBenef)
    {
	this.emptyMoreBenef = emptyMoreBenef;
    }
}