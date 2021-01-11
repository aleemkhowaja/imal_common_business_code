package com.path.vo.core.reports;

import java.math.BigDecimal;
import java.util.Date;

import com.path.struts2.lib.common.GridParamsSC;

/**
 * @author EliasAoun
 * 
 */
public class ReportsSC extends GridParamsSC
{

    private BigDecimal company_code, branch_code;
    private BigDecimal acc_br_code, acc_cy_code, acc_gl_code, acc_cif_code, acc_sl_code;
    private Date fromDate, toDate;

    private String ibanCode;
    private String referenceCode;
    /* BUG#328202 */
    private String cardNo;

    // this property is used mostly in mapper to identify the filter source (
    // "form" or "To")
    private String fieldId;

    /**
     * Getters and Setters
     */
    public BigDecimal getCompany_code()
    {
	return company_code;
    }

    public void setCompany_code(BigDecimal companyCode)
    {
	company_code = companyCode;
    }

    public BigDecimal getBranch_code()
    {
	return branch_code;
    }

    public void setBranch_code(BigDecimal branchCode)
    {
	branch_code = branchCode;
    }

    public BigDecimal getAcc_br_code()
    {
	return acc_br_code;
    }

    public void setAcc_br_code(BigDecimal accBrCode)
    {
	acc_br_code = accBrCode;
    }

    public BigDecimal getAcc_cy_code()
    {
	return acc_cy_code;
    }

    public void setAcc_cy_code(BigDecimal accCyCode)
    {
	acc_cy_code = accCyCode;
    }

    public BigDecimal getAcc_gl_code()
    {
	return acc_gl_code;
    }

    public void setAcc_gl_code(BigDecimal accGlCode)
    {
	acc_gl_code = accGlCode;
    }

    public BigDecimal getAcc_cif_code()
    {
	return acc_cif_code;
    }

    public void setAcc_cif_code(BigDecimal accCifCode)
    {
	acc_cif_code = accCifCode;
    }

    public BigDecimal getAcc_sl_code()
    {
	return acc_sl_code;
    }

    public void setAcc_sl_code(BigDecimal accSlCode)
    {
	acc_sl_code = accSlCode;
    }

    public Date getFromDate()
    {
	return fromDate;
    }

    public void setFromDate(Date fromDate)
    {
	this.fromDate = fromDate;
    }

    public Date getToDate()
    {
	return toDate;
    }

    public void setToDate(Date toDate)
    {
	this.toDate = toDate;
    }

    public String getIbanCode()
    {
	return ibanCode;
    }

    public void setIbanCode(String ibanCode)
    {
	this.ibanCode = ibanCode;
    }

    public String getFieldId()
    {
	return fieldId;
    }

    public void setFieldId(String fieldId)
    {
	this.fieldId = fieldId;
    }

    public String getReferenceCode()
    {
        return referenceCode;
    }

    public void setReferenceCode(String referenceCode)
    {
        this.referenceCode = referenceCode;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

}
