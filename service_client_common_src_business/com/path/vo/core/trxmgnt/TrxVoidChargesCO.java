package com.path.vo.core.trxmgnt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.vo.core.common.RetailBaseVO;

public class TrxVoidChargesCO  extends RetailBaseVO
{
    private List<TrxMgntVoidChargesCO> 	trxMgntVoidChargesCOs = new ArrayList<TrxMgntVoidChargesCO>();
    private String 		 	baseForeign;
    private BigDecimal		 	row;
    private BigDecimal			branch;
    private BigDecimal			currency;
    private BigDecimal			amount;
    private BigDecimal			total;			//To calculate Total Amount
    private BigDecimal			totalNew;		//To calculate Total of New Amounts
    private BigDecimal			totalFc;		//To calculate Total FC Amounts
    private BigDecimal			totalDuesNew;		//To calculate Total of New Dues Amounts
    private BigDecimal			totalDuesFc;		//To calculate Total FC Dues Amounts
    
    public String getBaseForeign()
    {
        return baseForeign;
    }
    public void setBaseForeign(String baseForeign)
    {
        this.baseForeign = baseForeign;
    }
    public BigDecimal getRow()
    {
        return row;
    }
    public void setRow(BigDecimal row)
    {
        this.row = row;
    }
    public BigDecimal getCurrency()
    {
        return currency;
    }
    public void setCurrency(BigDecimal currency)
    {
        this.currency = currency;
    }
 
    public BigDecimal getAmount()
    {
        return amount;
    }
    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
    }
    public BigDecimal getTotal()
    {
        return total;
    }
    public void setTotal(BigDecimal total)
    {
        this.total = total;
    }
    public BigDecimal getTotalNew()
    {
        return totalNew;
    }
    public void setTotalNew(BigDecimal totalNew)
    {
        this.totalNew = totalNew;
    }
    public BigDecimal getTotalFc()
    {
        return totalFc;
    }
    public void setTotalFc(BigDecimal totalFc)
    {
        this.totalFc = totalFc;
    }
    public BigDecimal getBranch()
    {
        return branch;
    }
    public void setBranch(BigDecimal branch)
    {
        this.branch = branch;
    }
    public BigDecimal getTotalDuesNew()
    {
        return totalDuesNew;
    }
    public void setTotalDuesNew(BigDecimal totalDuesNew)
    {
        this.totalDuesNew = totalDuesNew;
    }
    public BigDecimal getTotalDuesFc()
    {
        return totalDuesFc;
    }
    public void setTotalDuesFc(BigDecimal totalDuesFc)
    {
        this.totalDuesFc = totalDuesFc;
    }
    public List<TrxMgntVoidChargesCO> getTrxMgntVoidChargesCOs()
    {
        return trxMgntVoidChargesCOs;
    }
    public void setTrxMgntVoidChargesCOs(List<TrxMgntVoidChargesCO> trxMgntVoidChargesCOs)
    {
        this.trxMgntVoidChargesCOs = trxMgntVoidChargesCOs;
    }

}
