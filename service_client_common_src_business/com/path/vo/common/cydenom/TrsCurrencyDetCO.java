package com.path.vo.common.cydenom;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CTSTELLER_CASH_BALANCE_CY_NOMVO;
import com.path.dbmaps.vo.CTSTRS_CY_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrsCurrencyDetCO extends RetailBaseVO
{
    private CTSTRS_CY_DETVO ctstrsCYDETVO = new CTSTRS_CY_DETVO();
    
    /*
     * for transfer cash
     */
    private CTSTELLER_CASH_BALANCE_CY_NOMVO ctstellerCashBalanceCyNomVO = new CTSTELLER_CASH_BALANCE_CY_NOMVO();
    
    private BigDecimal avail_bills;
    
    private String  cyDenomGridUpdates;
    
    private BigDecimal comp_amt;
    
    private String currencyDesc;
    
    private BigDecimal decimalPoints;
    
    private BigDecimal ORIGINAL_AMOUNT;
    
    private BigDecimal MAX_NUM_OF_BILLS;
    
    private String NOM_DESC;
    
    private BigDecimal rowId;
    
    private String cashInOut;
    
    private String cyDenomKey;
    
    private String warningMessages;
    
    private String cyDetType;
    
    
    public CTSTRS_CY_DETVO getCtstrsCYDETVO()
    {
        return ctstrsCYDETVO;
    }

    public void setCtstrsCYDETVO(CTSTRS_CY_DETVO ctstrsCYDETVO)
    {
        this.ctstrsCYDETVO = ctstrsCYDETVO;
    }

    public BigDecimal getORIGINAL_AMOUNT()
    {
        return ORIGINAL_AMOUNT;
    }

    public void setORIGINAL_AMOUNT(BigDecimal oRIGINALAMOUNT)
    {
        ORIGINAL_AMOUNT = oRIGINALAMOUNT;
    }

    public BigDecimal getMAX_NUM_OF_BILLS()
    {
        return MAX_NUM_OF_BILLS;
    }

    public void setMAX_NUM_OF_BILLS(BigDecimal mAXNUMOFBILLS)
    {
        MAX_NUM_OF_BILLS = mAXNUMOFBILLS;
    }

    public String getNOM_DESC()
    {
        return NOM_DESC;
    }

    public void setNOM_DESC(String nOMDESC)
    {
        NOM_DESC = nOMDESC;
    }

    public String getCurrencyDesc()
    {
        return currencyDesc;
    }

    public void setCurrencyDesc(String currencyDesc)
    {
        this.currencyDesc = currencyDesc;
    }

    public BigDecimal getDecimalPoints()
    {
        return decimalPoints;
    }

    public void setDecimalPoints(BigDecimal decimalPoints)
    {
        this.decimalPoints = decimalPoints;
    }

    public BigDecimal getRowId()
    {
        return rowId;
    }

    public void setRowId(BigDecimal rowId)
    {
        this.rowId = rowId;
    }

    public String getCashInOut()
    {
        return cashInOut;
    }

    public void setCashInOut(String cashInOut)
    {
        this.cashInOut = cashInOut;
    }

    public String getCyDenomKey()
    {
        return cyDenomKey;
    }

    public void setCyDenomKey(String cyDenomKey)
    {
        this.cyDenomKey = cyDenomKey;
    }

    public CTSTELLER_CASH_BALANCE_CY_NOMVO getCtstellerCashBalanceCyNomVO()
    {
        return ctstellerCashBalanceCyNomVO;
    }

    public void setCtstellerCashBalanceCyNomVO(CTSTELLER_CASH_BALANCE_CY_NOMVO ctstellerCashBalanceCyNomVO)
    {
        this.ctstellerCashBalanceCyNomVO = ctstellerCashBalanceCyNomVO;
    }

    public BigDecimal getAvail_bills()
    {
        return avail_bills;
    }

    public void setAvail_bills(BigDecimal availBills)
    {
        avail_bills = availBills;
    }

    public BigDecimal getComp_amt()
    {
        return comp_amt;
    }

    public void setComp_amt(BigDecimal compAmt)
    {
        comp_amt = compAmt;
    }

    public String getCyDenomGridUpdates()
    {
        return cyDenomGridUpdates;
    }

    public void setCyDenomGridUpdates(String cyDenomGridUpdates)
    {
        this.cyDenomGridUpdates = cyDenomGridUpdates;
    }

    public String getWarningMessages()
    {
        return warningMessages;
    }

    public void setWarningMessages(String warningMessages)
    {
        this.warningMessages = warningMessages;
    }

    public String getCyDetType()
    {
        return cyDetType;
    }

    public void setCyDetType(String cyDetType)
    {
        this.cyDetType = cyDetType;
    }

}
