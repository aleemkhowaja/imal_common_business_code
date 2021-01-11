package com.path.vo.core.reference;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

public class ReferenceSC extends GridParamsSC
{
    private String referenceType;
    private String iv_crud;
    private BigDecimal referenceNo;
    private String productType;// lnk_product_type
    private BigDecimal linkBranchNo;
    private BigDecimal linkYear;
    private String billType;
    private String raType;
    private BigDecimal linkReference;

    // FxDeal Lookup
    private BigDecimal trx;
    private BigDecimal cif;
    private Date trxDate;
    private BigDecimal baseCy;
    private BigDecimal currency;
    private String progRef;
    private BigDecimal fromNbr;
    private String forex;
    private String lcType;

    public String getReferenceType()
    {
        return referenceType;
    }

    public void setReferenceType(String referenceType)
    {
        this.referenceType = referenceType;
    }

    public String getIv_crud()
    {
        return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
        iv_crud = ivCrud;
    }

    public BigDecimal getReferenceNo()
    {
        return referenceNo;
    }

    public void setReferenceNo(BigDecimal referenceNo)
    {
        this.referenceNo = referenceNo;
    }

    public String getProductType()
    {
        return productType;
    }

    public void setProductType(String productType)
    {
        this.productType = productType;
    }

    public BigDecimal getLinkBranchNo()
    {
        return linkBranchNo;
    }

    public void setLinkBranchNo(BigDecimal linkBranchNo)
    {
        this.linkBranchNo = linkBranchNo;
    }

    public BigDecimal getLinkYear()
    {
        return linkYear;
    }

    public void setLinkYear(BigDecimal linkYear)
    {
        this.linkYear = linkYear;
    }

    public String getBillType()
    {
        return billType;
    }

    public void setBillType(String billType)
    {
        this.billType = billType;
    }

    public String getRaType()
    {
        return raType;
    }

    public void setRaType(String raType)
    {
        this.raType = raType;
    }

    public BigDecimal getLinkReference()
    {
        return linkReference;
    }

    public void setLinkReference(BigDecimal linkReference)
    {
        this.linkReference = linkReference;
    }

    /**
     * @return the trx
     */
    public BigDecimal getTrx()
    {
        return trx;
    }

    /**
     * @param trx the trx to set
     */
    public void setTrx(BigDecimal trx)
    {
        this.trx = trx;
    }

    /**
     * @return the cif
     */
    public BigDecimal getCif()
    {
        return cif;
    }

    /**
     * @param cif the cif to set
     */
    public void setCif(BigDecimal cif)
    {
        this.cif = cif;
    }

    /**
     * @return the trxDate
     */
    public Date getTrxDate()
    {
        return trxDate;
    }

    /**
     * @param trxDate the trxDate to set
     */
    public void setTrxDate(Date trxDate)
    {
        this.trxDate = trxDate;
    }

    /**
     * @return the baseCy
     */
    public BigDecimal getBaseCy()
    {
        return baseCy;
    }

    /**
     * @param baseCy the baseCy to set
     */
    public void setBaseCy(BigDecimal baseCy)
    {
        this.baseCy = baseCy;
    }

    /**
     * @return the currency
     */
    public BigDecimal getCurrency()
    {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(BigDecimal currency)
    {
        this.currency = currency;
    }

    /**
     * @return the progRef
     */
    public String getProgRef()
    {
        return progRef;
    }

    /**
     * @param progRef the progRef to set
     */
    public void setProgRef(String progRef)
    {
        this.progRef = progRef;
    }

    /**
     * @return the fromNbr
     */
    public BigDecimal getFromNbr()
    {
        return fromNbr;
    }

    /**
     * @param fromNbr the fromNbr to set
     */
    public void setFromNbr(BigDecimal fromNbr)
    {
        this.fromNbr = fromNbr;
    }

    /**
     * @return the forex
     */
    public String getForex()
    {
        return forex;
    }

    /**
     * @param forex the forex to set
     */
    public void setForex(String forex)
    {
        this.forex = forex;
    }

    /**
     * @return the lcType
     */
    public String getLcType()
    {
        return lcType;
    }

    /**
     * @param lcType the lcType to set
     */
    public void setLcType(String lcType)
    {
        this.lcType = lcType;
    }

}
