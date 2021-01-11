package com.path.vo.common.iis.dealcharges;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.dbmaps.vo.TRSDEAL_ASSET_VNDR_INCENTIVEVO;
import com.path.struts2.lib.common.GridParamsSC;

/**
 * @Auther:Pappady
 * @Date:Apr 14, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public class TrsDealChargesSC extends GridParamsSC
{
    private BigDecimal dealNo;
    private BigDecimal lineNo;
    private BigDecimal prodClass;
    private String langCode;
    private String appName;
    private String progRef;
    private String ivCrud;
    private BigDecimal baseCyDecimalPoint;
    private BigDecimal dealCyDecimalPoint;
    // TP#190558; Saheer.Naduthodi; 20/07/2014
    private BigDecimal dealCY;
    private String pageRefName;
    private String promissoryFxType;
    private BigDecimal pfxCancellationNo;
    private BigDecimal totalCompContrib;
    private BigDecimal facilityNumber;
    private BigDecimal facilityBranch;
    private BigDecimal facilitySubLineNbr;
    private BigDecimal subLimitLineCount;
    private String calculatorYN = ConstantsCommon.NO;

    private List<TrsDealChargesCO> trsDealChargesCO;
    private String saveChargesYN = ConstantsCommon.NO;
    private Date maturityDate;

    private String skipAmountValidation;
    private Date valueDate;
    private String dealStatus;

    private BigDecimal dealAmt;
    private BigDecimal downPaymentAmt;

    // TP# 870190 BAJ Fawas.Kuruvakkottil 26/08/2019
    List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> assetVendorIncentiveGridList;

    // DEL/PFX
    private String dealType;

    public Date getValueDate()
    {
	return valueDate;
    }

    public void setValueDate(Date valueDate)
    {
	this.valueDate = valueDate;
    }

    public BigDecimal getSubLimitLineCount()
    {
	return subLimitLineCount;
    }

    public void setSubLimitLineCount(BigDecimal subLimitLineCount)
    {
	this.subLimitLineCount = subLimitLineCount;
    }

    public BigDecimal getFacilityNumber()
    {
	return facilityNumber;
    }

    public void setFacilityNumber(BigDecimal facilityNumber)
    {
	this.facilityNumber = facilityNumber;
    }

    public BigDecimal getFacilityBranch()
    {
	return facilityBranch;
    }

    public void setFacilityBranch(BigDecimal facilityBranch)
    {
	this.facilityBranch = facilityBranch;
    }

    public BigDecimal getFacilitySubLineNbr()
    {
	return facilitySubLineNbr;
    }

    public void setFacilitySubLineNbr(BigDecimal facilitySubLineNbr)
    {
	this.facilitySubLineNbr = facilitySubLineNbr;
    }

    public BigDecimal getLineNo()
    {
	return lineNo;
    }

    public void setLineNo(BigDecimal lineNo)
    {
	this.lineNo = lineNo;
    }

    public void setProdClass(BigDecimal prodClass)
    {
	this.prodClass = prodClass;
    }

    public BigDecimal getProdClass()
    {
	return prodClass;
    }

    public String getLangCode()
    {
	return langCode;
    }

    public void setLangCode(String langCode)
    {
	this.langCode = langCode;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getProgRef()
    {
	return progRef;
    }

    public void setProgRef(String progRef)
    {
	this.progRef = progRef;
    }

    public String getIvCrud()
    {
	return ivCrud;
    }

    public void setIvCrud(String ivCrud)
    {
	this.ivCrud = ivCrud;
    }

    public BigDecimal getDealNo()
    {
	return dealNo;
    }

    public void setDealNo(BigDecimal dealNo)
    {
	this.dealNo = dealNo;
    }

    public BigDecimal getBaseCyDecimalPoint()
    {
	return baseCyDecimalPoint;
    }

    public void setBaseCyDecimalPoint(BigDecimal baseCyDecimalPoint)
    {
	this.baseCyDecimalPoint = baseCyDecimalPoint;
    }

    public BigDecimal getDealCyDecimalPoint()
    {
	return dealCyDecimalPoint;
    }

    public void setDealCyDecimalPoint(BigDecimal dealCyDecimalPoint)
    {
	this.dealCyDecimalPoint = dealCyDecimalPoint;
    }

    public String getPageRefName()
    {
	return pageRefName;
    }

    public void setPageRefName(String pageRefName)
    {
	this.pageRefName = pageRefName;
    }

    public String getPromissoryFxType()
    {
	return promissoryFxType;
    }

    public void setPromissoryFxType(String promissoryFxType)
    {
	this.promissoryFxType = promissoryFxType;
    }

    public BigDecimal getDealCY()
    {
	return dealCY;
    }

    public void setDealCY(BigDecimal dealCY)
    {
	this.dealCY = dealCY;
    }

    public BigDecimal getPfxCancellationNo()
    {
	return pfxCancellationNo;
    }

    public void setPfxCancellationNo(BigDecimal pfxCancellationNo)
    {
	this.pfxCancellationNo = pfxCancellationNo;
    }

    public BigDecimal getTotalCompContrib()
    {
	return totalCompContrib;
    }

    public void setTotalCompContrib(BigDecimal totalCompContrib)
    {
	this.totalCompContrib = totalCompContrib;
    }

    public String getCalculatorYN()
    {
	return calculatorYN;
    }

    public void setCalculatorYN(String calculatorYN)
    {
	this.calculatorYN = calculatorYN;
    }

    public List<TrsDealChargesCO> getTrsDealChargesCO()
    {
	return trsDealChargesCO;
    }

    public void setTrsDealChargesCO(List<TrsDealChargesCO> trsDealChargesCO)
    {
	this.trsDealChargesCO = trsDealChargesCO;
    }

    public String getSaveChargesYN()
    {
	return saveChargesYN;
    }

    public void setSaveChargesYN(String saveChargesYN)
    {
	this.saveChargesYN = saveChargesYN;
    }

    public String getSkipAmountValidation()
    {
	return skipAmountValidation;
    }

    public void setSkipAmountValidation(String skipAmountValidation)
    {
	this.skipAmountValidation = skipAmountValidation;
    }

    public String getDealStatus()
    {
	return dealStatus;
    }

    public void setDealStatus(String dealStatus)
    {
	this.dealStatus = dealStatus;
    }

    public List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> getAssetVendorIncentiveGridList()
    {
	return assetVendorIncentiveGridList;
    }

    public void setAssetVendorIncentiveGridList(List<TRSDEAL_ASSET_VNDR_INCENTIVEVO> assetVendorIncentiveGridList)
    {
	this.assetVendorIncentiveGridList = assetVendorIncentiveGridList;
    }

    public BigDecimal getDealAmt()
    {
	return dealAmt;
    }

    public void setDealAmt(BigDecimal dealAmt)
    {
	this.dealAmt = dealAmt;
    }

    public BigDecimal getDownPaymentAmt()
    {
	return downPaymentAmt;
    }

    public void setDownPaymentAmt(BigDecimal downPaymentAmt)
    {
	this.downPaymentAmt = downPaymentAmt;
    }

    public String getDealType()
    {
	return dealType;
    }

    public void setDealType(String dealType)
    {
	this.dealType = dealType;
    }

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}
}
