package com.path.vo.core.common;

import java.math.BigDecimal;
import java.util.Date;

import com.path.vo.common.CommonLibSC;

/**
 * 
 * Copyright 2015, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: eliasaoun
 * 
 *          CoreCommonSC.java used to be a common search criteria dedicated for csm Team
 */
public class CoreCommonSC extends CommonLibSC
{
    /**
     * this array will hold the codes of product keys, in order to be iterated in the mapper
     */
    private BigDecimal[] productCodeArr;
    private BigDecimal exemptedFromFilerReason; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    private Date exemptedFromFilerExpiryDte; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    private String exemptedFromFilerTaxYn; //Rania - 796564 SUMMIT - Merging FilerNon-filer in Account Limits
    
    /**
     * @return the productCodeArr
     */
    public BigDecimal[] getProductCodeArr()
    {
	return productCodeArr;
    }

    /**
     * @param productCodeArr the productCodeArr to set
     */
    public void setProductCodeArr(BigDecimal[] productCodeArr)
    {
	this.productCodeArr = productCodeArr;
    }

    public BigDecimal getExemptedFromFilerReason()
    {
        return exemptedFromFilerReason;
    }

    public void setExemptedFromFilerReason(BigDecimal exemptedFromFilerReason)
    {
        this.exemptedFromFilerReason = exemptedFromFilerReason;
    }

    public Date getExemptedFromFilerExpiryDte()
    {
        return exemptedFromFilerExpiryDte;
    }

    public void setExemptedFromFilerExpiryDte(Date exemptedFromFilerExpiryDte)
    {
        this.exemptedFromFilerExpiryDte = exemptedFromFilerExpiryDte;
    }

    public String getExemptedFromFilerTaxYn()
    {
        return exemptedFromFilerTaxYn;
    }

    public void setExemptedFromFilerTaxYn(String exemptedFromFilerTaxYn)
    {
        this.exemptedFromFilerTaxYn = exemptedFromFilerTaxYn;
    }
}
