package com.path.vo.core.trxmgnt.settlement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTRS_SETTLEMENTVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntSettlementCO extends RetailBaseVO
{
    private List<TrxMgntSettlementCO> trxMgntSettlementCOs = new ArrayList<TrxMgntSettlementCO>();
    private List<TrxMgntSettlementCO> trxMgntSettlDealsCOs = new ArrayList<TrxMgntSettlementCO>();
    private List<TrxMgntSettlementCO> trxMgntSettlAllDealsCOs = new ArrayList<TrxMgntSettlementCO>();
    private List<TrxMgntSettlementCO> trxMgntSettlJointCifCOs = new ArrayList<TrxMgntSettlementCO>();
    private CTSTRS_SETTLEMENTVO ctstrsSettlementVO = new CTSTRS_SETTLEMENTVO();
    private BigDecimal TOTAL_INST_AMOUNT;
    private String dealsDetailsGridUpdates;
    private String settlementGridUpdates;
    private String dependencySrc;
    private Boolean fromLookup;
    private BigDecimal cifSettlement;
    private BigDecimal currentRow;
    private String warningMsg;

    public CTSTRS_SETTLEMENTVO getCtstrsSettlementVO()
    {
	return ctstrsSettlementVO;
    }

    public void setCtstrsSettlementVO(CTSTRS_SETTLEMENTVO ctstrsSettlementVO)
    {
	this.ctstrsSettlementVO = ctstrsSettlementVO;
    }

    public BigDecimal getTOTAL_INST_AMOUNT()
    {
	return TOTAL_INST_AMOUNT;
    }

    public void setTOTAL_INST_AMOUNT(BigDecimal tOTALINSTAMOUNT)
    {
	TOTAL_INST_AMOUNT = tOTALINSTAMOUNT;
    }

    public String getDealsDetailsGridUpdates()
    {
        return dealsDetailsGridUpdates;
    }

    public void setDealsDetailsGridUpdates(String dealsDetailsGridUpdates)
    {
        this.dealsDetailsGridUpdates = dealsDetailsGridUpdates;
    }

    public List<TrxMgntSettlementCO> getTrxMgntSettlementCOs()
    {
        return trxMgntSettlementCOs;
    }

    public void setTrxMgntSettlementCOs(List<TrxMgntSettlementCO> trxMgntSettlementCOs)
    {
        this.trxMgntSettlementCOs = trxMgntSettlementCOs;
    }

    public List<TrxMgntSettlementCO> getTrxMgntSettlDealsCOs()
    {
        return trxMgntSettlDealsCOs;
    }

    public void setTrxMgntSettlDealsCOs(List<TrxMgntSettlementCO> trxMgntSettlDealsCOs)
    {
        this.trxMgntSettlDealsCOs = trxMgntSettlDealsCOs;
    }

    public List<TrxMgntSettlementCO> getTrxMgntSettlJointCifCOs()
    {
        return trxMgntSettlJointCifCOs;
    }

    public void setTrxMgntSettlJointCifCOs(List<TrxMgntSettlementCO> trxMgntSettlJointCifCOs)
    {
        this.trxMgntSettlJointCifCOs = trxMgntSettlJointCifCOs;
    }

    public String getDependencySrc()
    {
        return dependencySrc;
    }

    public void setDependencySrc(String dependencySrc)
    {
        this.dependencySrc = dependencySrc;
    }

    public Boolean getFromLookup()
    {
        return fromLookup;
    }

    public void setFromLookup(Boolean fromLookup)
    {
        this.fromLookup = fromLookup;
    }

    public String getSettlementGridUpdates()
    {
        return settlementGridUpdates;
    }

    public void setSettlementGridUpdates(String settlementGridUpdates)
    {
        this.settlementGridUpdates = settlementGridUpdates;
    }

    public BigDecimal getCifSettlement()
    {
        return cifSettlement;
    }

    public void setCifSettlement(BigDecimal cifSettlement)
    {
        this.cifSettlement = cifSettlement;
    }

    public List<TrxMgntSettlementCO> getTrxMgntSettlAllDealsCOs()
    {
        return trxMgntSettlAllDealsCOs;
    }

    public void setTrxMgntSettlAllDealsCOs(List<TrxMgntSettlementCO> trxMgntSettlAllDealsCOs)
    {
        this.trxMgntSettlAllDealsCOs = trxMgntSettlAllDealsCOs;
    }

    public BigDecimal getCurrentRow()
    {
        return currentRow;
    }

    public void setCurrentRow(BigDecimal currentRow)
    {
        this.currentRow = currentRow;
    }

    public String getWarningMsg()
    {
        return warningMsg;
    }

    public void setWarningMsg(String warningMsg)
    {
        this.warningMsg = warningMsg;
    }

}
