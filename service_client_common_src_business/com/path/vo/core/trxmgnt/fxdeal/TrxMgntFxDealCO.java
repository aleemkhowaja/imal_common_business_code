package com.path.vo.core.trxmgnt.fxdeal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTRSVO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.dbmaps.vo.TRSDEALVO;
import com.path.dbmaps.vo.TRS_FX_LINKED_UTILIZATIONVO;
import com.path.dbmaps.vo.TRS_FX_LINKED_UTILIZATION_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntFxDealCO extends RetailBaseVO
{  
   
    private TRSDEALVO trsDealVO = new TRSDEALVO();
    private TRS_FX_LINKED_UTILIZATIONVO trsFxLinkedUtilizationVO = new TRS_FX_LINKED_UTILIZATIONVO();
    private TRS_FX_LINKED_UTILIZATION_DETVO trsFxLinkedUtilizationDetVO = new TRS_FX_LINKED_UTILIZATION_DETVO();
    private String otherCyDesc;
    private BigDecimal otherCyDecPnts;
    private String dealCyDesc;
    private BigDecimal dealCyDecPnts;
    private BigDecimal outstandSold;
    private BigDecimal outstandBought;
    private BigDecimal amount;
    private BigDecimal UTIL_AMOUNT;
    private BigDecimal UTIL_AMOUNT_CV;
    private CTSTRSVO ctstrsVO = new CTSTRSVO();
    private CTSTRXTYPEVO ctstrxtypeVO = new CTSTRXTYPEVO();
    private String trxMgntFxDealGridUpdates;
    private List<TrxMgntFxDealCO> trxMgntFxDealListModified = new ArrayList<TrxMgntFxDealCO>() ; 
    private BigDecimal trsAcAmount;
    private String  forexTypeDesc;
    private BigDecimal finalRate;
    private Boolean noSelection;
    private BigDecimal rowSelected=BigDecimal.ZERO;
 
 
    
    
    
    
    public TRSDEALVO getTrsDealVO()
    {
        return trsDealVO;
    }
    public void setTrsDealVO(TRSDEALVO trsDealVO)
    {
        this.trsDealVO = trsDealVO;
    }
    public TRS_FX_LINKED_UTILIZATIONVO getTrsFxLinkedUtilizationVO()
    {
        return trsFxLinkedUtilizationVO;
    }
    public void setTrsFxLinkedUtilizationVO(TRS_FX_LINKED_UTILIZATIONVO trsFxLinkedUtilizationVO)
    {
        this.trsFxLinkedUtilizationVO = trsFxLinkedUtilizationVO;
    }
    public String getOtherCyDesc()
    {
        return otherCyDesc;
    }
    public void setOtherCyDesc(String otherCyDesc)
    {
        this.otherCyDesc = otherCyDesc;
    }
    public BigDecimal getOtherCyDecPnts()
    {
        return otherCyDecPnts;
    }
    public void setOtherCyDecPnts(BigDecimal otherCyDecPnts)
    {
        this.otherCyDecPnts = otherCyDecPnts;
    }
    public String getDealCyDesc()
    {
        return dealCyDesc;
    }
    public void setDealCyDesc(String dealCyDesc)
    {
        this.dealCyDesc = dealCyDesc;
    }
    public BigDecimal getDealCyDecPnts()
    {
        return dealCyDecPnts;
    }
    public void setDealCyDecPnts(BigDecimal dealCyDecPnts)
    {
        this.dealCyDecPnts = dealCyDecPnts;
    }
    public BigDecimal getOutstandSold()
    {
        return outstandSold;
    }
    public void setOutstandSold(BigDecimal outstandSold)
    {
        this.outstandSold = outstandSold;
    }
    public BigDecimal getOutstandBought()
    {
        return outstandBought;
    }
    public void setOutstandBought(BigDecimal outstandBought)
    {
        this.outstandBought = outstandBought;
    }
    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public BigDecimal getUTIL_AMOUNT()
    {
        return UTIL_AMOUNT;
    }
    public void setUTIL_AMOUNT(BigDecimal uTIL_AMOUNT)
    {
        UTIL_AMOUNT = uTIL_AMOUNT;
    }
    public BigDecimal getUTIL_AMOUNT_CV()
    {
        return UTIL_AMOUNT_CV;
    }
    public void setUTIL_AMOUNT_CV(BigDecimal uTIL_AMOUNT_CV)
    {
        UTIL_AMOUNT_CV = uTIL_AMOUNT_CV;
    }
    public CTSTRSVO getCtstrsVO()
    {
        return ctstrsVO;
    }
    public void setCtstrsVO(CTSTRSVO ctstrsVO)
    {
        this.ctstrsVO = ctstrsVO;
    }
    public CTSTRXTYPEVO getCtstrxtypeVO()
    {
        return ctstrxtypeVO;
    }
    public void setCtstrxtypeVO(CTSTRXTYPEVO ctstrxtypeVO)
    {
        this.ctstrxtypeVO = ctstrxtypeVO;
    }
    public String getTrxMgntFxDealGridUpdates()
    {
        return trxMgntFxDealGridUpdates;
    }
    public void setTrxMgntFxDealGridUpdates(String trxMgntFxDealGridUpdates)
    {
        this.trxMgntFxDealGridUpdates = trxMgntFxDealGridUpdates;
    }
    public List<TrxMgntFxDealCO> getTrxMgntFxDealListModified()
    {
        return trxMgntFxDealListModified;
    }
    public void setTrxMgntFxDealListModified(List<TrxMgntFxDealCO> trxMgntFxDealListModified)
    {
        this.trxMgntFxDealListModified = trxMgntFxDealListModified;
    }
    public BigDecimal getTrsAcAmount()
    {
        return trsAcAmount;
    }
    public void setTrsAcAmount(BigDecimal trsAcAmount)
    {
        this.trsAcAmount = trsAcAmount;
    }
    public String getForexTypeDesc()
    {
        return forexTypeDesc;
    }
    public void setForexTypeDesc(String forexTypeDesc)
    {
        this.forexTypeDesc = forexTypeDesc;
    }
    public BigDecimal getFinalRate()
    {
        return finalRate;
    }
    public void setFinalRate(BigDecimal finalRate)
    {
        this.finalRate = finalRate;
    }
    public Boolean getNoSelection()
    {
        return noSelection;
    }
    public void setNoSelection(Boolean noSelection)
    {
        this.noSelection = noSelection;
    }
    public TRS_FX_LINKED_UTILIZATION_DETVO getTrsFxLinkedUtilizationDetVO()
    {
        return trsFxLinkedUtilizationDetVO;
    }
    public void setTrsFxLinkedUtilizationDetVO(TRS_FX_LINKED_UTILIZATION_DETVO trsFxLinkedUtilizationDetVO)
    {
        this.trsFxLinkedUtilizationDetVO = trsFxLinkedUtilizationDetVO;
    }
    public BigDecimal getRowSelected()
    {
        return rowSelected;
    }
    public void setRowSelected(BigDecimal rowSelected)
    {
        this.rowSelected = rowSelected;
    }
  
   
}
