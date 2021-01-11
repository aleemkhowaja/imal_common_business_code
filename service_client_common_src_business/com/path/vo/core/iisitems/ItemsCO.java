package com.path.vo.core.iisitems;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.dbmaps.vo.TRS_ITEMSVO;
import com.path.dbmaps.vo.TRS_ITEM_CATEGORYVO;
import com.path.lib.vo.BaseVO;

public class ItemsCO extends BaseVO implements Serializable
{
    // Lookup Details

    private TRS_ITEMSVO trsitemsvo;
    private TRS_ITEM_CATEGORYVO trsitemscategoryvo;
    private CURRENCIESVO currenciesvo;

    // /sankar

    private BigDecimal currencyCode;
    private Date valueDate;
    private BigDecimal unit_price;
    private BigDecimal weight;
    private BigDecimal amount;
    private BigDecimal financing_percent;
    private BigDecimal financing_amount;
    private BigDecimal ldec_financing_perc;
    private BigDecimal purchase_Party;
    private BigDecimal gold_Type;
    private String jewellry;
    private String value_Of_Surety;
    private BigDecimal jewellPropertyCode;
    private BigDecimal valueofSuretyPropertyCode;

    private BigDecimal pieces;

    private BigDecimal idec_max_financing_percentage;

    public BigDecimal getIdec_max_financing_percentage()
    {
	return idec_max_financing_percentage;
    }

    public void setIdec_max_financing_percentage(BigDecimal idecMaxFinancingPercentage)
    {
	idec_max_financing_percentage = idecMaxFinancingPercentage;
    }

    public BigDecimal getLdec_financing_perc()
    {
	return ldec_financing_perc;
    }

    public void setLdec_financing_perc(BigDecimal ldecFinancingPerc)
    {
	ldec_financing_perc = ldecFinancingPerc;
    }

    public BigDecimal getWeight()
    {
	return weight;
    }

    public void setWeight(BigDecimal weight)
    {
	this.weight = weight;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public BigDecimal getFinancing_percent()
    {
	return financing_percent;
    }

    public void setFinancing_percent(BigDecimal financingPercent)
    {
	financing_percent = financingPercent;
    }

    public BigDecimal getFinancing_amount()
    {
	return financing_amount;
    }

    public void setFinancing_amount(BigDecimal financingAmount)
    {
	financing_amount = financingAmount;
    }

    public BigDecimal getUnit_price()
    {
	return unit_price;
    }

    public void setUnit_price(BigDecimal unitPrice)
    {
	unit_price = unitPrice;
    }

    public void setTrsitemsvo(TRS_ITEMSVO trsitemsvo)
    {
	this.trsitemsvo = trsitemsvo;
    }

    public TRS_ITEMSVO getTrsitemsvo()
    {
	return trsitemsvo;
    }

    public void setTrsitemscategoryvo(TRS_ITEM_CATEGORYVO trsitemscategoryvo)
    {
	this.trsitemscategoryvo = trsitemscategoryvo;
    }

    public TRS_ITEM_CATEGORYVO getTrsitemscategoryvo()
    {
	return trsitemscategoryvo;
    }

    public void setCurrenciesvo(CURRENCIESVO currenciesvo)
    {
	this.currenciesvo = currenciesvo;
    }

    public CURRENCIESVO getCurrenciesvo()
    {
	return currenciesvo;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public Date getValueDate()
    {
	return valueDate;
    }

    public BigDecimal getPurchase_Party()
    {
	return purchase_Party;
    }

    public void setPurchase_Party(BigDecimal purchaseParty)
    {
	purchase_Party = purchaseParty;
    }

    public BigDecimal getGold_Type()
    {
	return gold_Type;
    }

    public void setGold_Type(BigDecimal goldType)
    {
	gold_Type = goldType;
    }

    public String getJewellry()
    {
	return jewellry;
    }

    public void setJewellry(String jewellry)
    {
	this.jewellry = jewellry;
    }

    public String getValue_Of_Surety()
    {
	return value_Of_Surety;
    }

    public void setValue_Of_Surety(String valueOfSurety)
    {
	value_Of_Surety = valueOfSurety;
    }

    public BigDecimal getPieces()
    {
	return pieces;
    }

    public void setPieces(BigDecimal pieces)
    {
	this.pieces = pieces;
    }

    public BigDecimal getJewellPropertyCode()
    {
	return jewellPropertyCode;
    }

    public void setJewellPropertyCode(BigDecimal jewellPropertyCode)
    {
	this.jewellPropertyCode = jewellPropertyCode;
    }

    public BigDecimal getValueofSuretyPropertyCode()
    {
	return valueofSuretyPropertyCode;
    }

    public void setValueofSuretyPropertyCode(BigDecimal valueofSuretyPropertyCode)
    {
	this.valueofSuretyPropertyCode = valueofSuretyPropertyCode;
    }
    

}
