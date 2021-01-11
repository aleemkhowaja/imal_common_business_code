package com.path.vo.core.common.billtypeaddref;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CTSTRS_BILL_REFERENCEVO;
import com.path.dbmaps.vo.CTSTRS_PROVIDER_INFOVO;
import com.path.dbmaps.vo.CTS_BILL_TYPE_PROVIDER_DETAILSVO;
import com.path.dbmaps.vo.CTS_BILL_TYPE_PROVIDER_FIELDSVO;
import com.path.dbmaps.vo.CTS_BILL_TYPE_REF_PREFIXVO;
import com.path.dbmaps.vo.CTS_SERV_REG_BILL_REFVO;
import com.path.vo.core.common.RetailBaseVO;

public class BillTypeAddReferenceCO extends RetailBaseVO
{

    private CTS_BILL_TYPE_PROVIDER_DETAILSVO ctsBillTypeProviderDtlsVO = new CTS_BILL_TYPE_PROVIDER_DETAILSVO();
    private CTS_BILL_TYPE_PROVIDER_FIELDSVO ctsBillTypeProviderFieldsVO = new CTS_BILL_TYPE_PROVIDER_FIELDSVO();
    private CTS_BILL_TYPE_REF_PREFIXVO ctsBillTypeRefPrefixVO = new CTS_BILL_TYPE_REF_PREFIXVO();
    
    private CTS_SERV_REG_BILL_REFVO ctsServRegBillRefVO = new CTS_SERV_REG_BILL_REFVO();
    private CTSTRS_BILL_REFERENCEVO ctstrsBillReferenceVO = new CTSTRS_BILL_REFERENCEVO();
    
    private String ctsServRegStatus;
    private List<BillTypeAddReferenceCO> referencesAllLst = new ArrayList<BillTypeAddReferenceCO>();
    private String referencesJsonStr;
    private Integer countReferenceProvider;
    private Integer found;
    private Integer statusFound;
    //Hasan Bug#488285 01/03/2017
    private String fromWhere;
    private BigDecimal lineNo;

    private BigDecimal amount;
    
    
    private String fieldName;
    private String fieldValue;
    String stringBufferAddRef;
    
    BigDecimal fieldCode;
    String fieldEValue;
    String referenceList;
    private String providerInfoDtlsGridUpdate;
    private List<BillTypeAddReferenceCO> billTypeAddReferenceCOList = new ArrayList<BillTypeAddReferenceCO>();
    private CTSTRS_PROVIDER_INFOVO ctsTrsProviderInfoVO = new CTSTRS_PROVIDER_INFOVO();

    
    public CTS_BILL_TYPE_PROVIDER_DETAILSVO getCtsBillTypeProviderDtlsVO()
    {
	return ctsBillTypeProviderDtlsVO;
    }

    public void setCtsBillTypeProviderDtlsVO(CTS_BILL_TYPE_PROVIDER_DETAILSVO ctsBillTypeProviderDtlsVO)
    {
	this.ctsBillTypeProviderDtlsVO = ctsBillTypeProviderDtlsVO;
    }

    public CTS_SERV_REG_BILL_REFVO getCtsServRegBillRefVO()
    {
	return ctsServRegBillRefVO;
    }

    public void setCtsServRegBillRefVO(CTS_SERV_REG_BILL_REFVO ctsServRegBillRefVO)
    {
	this.ctsServRegBillRefVO = ctsServRegBillRefVO;
    }

    public CTS_BILL_TYPE_PROVIDER_FIELDSVO getCtsBillTypeProviderFieldsVO()
    {
	return ctsBillTypeProviderFieldsVO;
    }

    public void setCtsBillTypeProviderFieldsVO(CTS_BILL_TYPE_PROVIDER_FIELDSVO ctsBillTypeProviderFieldsVO)
    {
	this.ctsBillTypeProviderFieldsVO = ctsBillTypeProviderFieldsVO;
    }

    public CTS_BILL_TYPE_REF_PREFIXVO getCtsBillTypeRefPrefixVO()
    {
	return ctsBillTypeRefPrefixVO;
    }

    public void setCtsBillTypeRefPrefixVO(CTS_BILL_TYPE_REF_PREFIXVO ctsBillTypeRefPrefixVO)
    {
	this.ctsBillTypeRefPrefixVO = ctsBillTypeRefPrefixVO;
    }

    public String getCtsServRegStatus()
    {
	return ctsServRegStatus;
    }

    public void setCtsServRegStatus(String ctsServRegStatus)
    {
	this.ctsServRegStatus = ctsServRegStatus;
    }

    public List<BillTypeAddReferenceCO> getReferencesAllLst()
    {
	return referencesAllLst;
    }

    public void setReferencesAllLst(List<BillTypeAddReferenceCO> referencesAllLst)
    {
	this.referencesAllLst = referencesAllLst;
    }

    public String getReferencesJsonStr()
    {
	return referencesJsonStr;
    }

    public void setReferencesJsonStr(String referencesJsonStr)
    {
	this.referencesJsonStr = referencesJsonStr;
    }

    public Integer getCountReferenceProvider()
    {
        return countReferenceProvider;
    }

    public void setCountReferenceProvider(Integer countReferenceProvider)
    {
        this.countReferenceProvider = countReferenceProvider;
    }

    public CTSTRS_BILL_REFERENCEVO getCtstrsBillReferenceVO()
    {
        return ctstrsBillReferenceVO;
    }

    public void setCtstrsBillReferenceVO(CTSTRS_BILL_REFERENCEVO ctstrsBillReferenceVO)
    {
        this.ctstrsBillReferenceVO = ctstrsBillReferenceVO;
    }

    public Integer getFound()
    {
        return found;
    }

    public void setFound(Integer found)
    {
        this.found = found;
    }

    public Integer getStatusFound()
    {
        return statusFound;
    }

    public void setStatusFound(Integer statusFound)
    {
        this.statusFound = statusFound;
    }

    public String getFromWhere()
    {
	return fromWhere;
    }

    public void setFromWhere(String fromWhere)
    {
	this.fromWhere = fromWhere;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public BigDecimal getAmount()
    {
	return amount;
    }

    public void setAmount(BigDecimal amount)
    {
	this.amount = amount;
    }

    public String getFieldName()
    {
	return fieldName;
    }

    public void setFieldName(String fieldName)
    {
	this.fieldName = fieldName;
    }

    public String getFieldValue()
    {
	return fieldValue;
    }

    public void setFieldValue(String fieldValue)
    {
	this.fieldValue = fieldValue;
    }

    public String getStringBufferAddRef()
    {
	return stringBufferAddRef;
    }

    public void setStringBufferAddRef(String stringBufferAddRef)
    {
	this.stringBufferAddRef = stringBufferAddRef;
    }

    public BigDecimal getFieldCode()
    {
        return fieldCode;
    }

    public void setFieldCode(BigDecimal fieldCode)
    {
        this.fieldCode = fieldCode;
    }

    public String getFieldEValue()
    {
        return fieldEValue;
    }

    public void setFieldEValue(String fieldEValue)
    {
        this.fieldEValue = fieldEValue;
    }

    public String getReferenceList()
    {
        return referenceList;
    }

    public void setReferenceList(String referenceList)
    {
        this.referenceList = referenceList;
    }

    public String getProviderInfoDtlsGridUpdate()
    {
        return providerInfoDtlsGridUpdate;
    }

    public void setProviderInfoDtlsGridUpdate(String providerInfoDtlsGridUpdate)
    {
        this.providerInfoDtlsGridUpdate = providerInfoDtlsGridUpdate;
    }

    public List<BillTypeAddReferenceCO> getBillTypeAddReferenceCOList()
    {
        return billTypeAddReferenceCOList;
    }

    public void setBillTypeAddReferenceCOList(List<BillTypeAddReferenceCO> billTypeAddReferenceCOList)
    {
        this.billTypeAddReferenceCOList = billTypeAddReferenceCOList;
    }

    public CTSTRS_PROVIDER_INFOVO getCtsTrsProviderInfoVO()
    {
        return ctsTrsProviderInfoVO;
    }

    public void setCtsTrsProviderInfoVO(CTSTRS_PROVIDER_INFOVO ctsTrsProviderInfoVO)
    {
        this.ctsTrsProviderInfoVO = ctsTrsProviderInfoVO;
    }
    
}
