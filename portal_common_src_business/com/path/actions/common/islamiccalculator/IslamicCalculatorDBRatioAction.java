package com.path.actions.common.islamiccalculator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.path.bo.common.CommonMethods;
import com.path.bo.common.iis.islamiccalculator.IISCommonBO;
import com.path.dbmaps.vo.CURRENCIESVO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.iis.islamiccalculator.IISCommonCO;
import com.path.vo.common.iis.islamiccalculator.IslamicCalculatorDBRatioSC;

public class IslamicCalculatorDBRatioAction extends GridBaseAction
{
    private IISCommonBO iisCommonBO;
    List<IslamicCalculatorDBRatioSC> vtIslamicCalculatorDBRatioSC;
    private IISCommonCO iisCommonCO;
    private BigDecimal cifNo;
    private BigDecimal productClass;
    private BigDecimal currencyCode;

    public String getDBRRatio()
    {
	try
	{
	    String[] captions = { "Debt_Burden_Ratio_key", "Customer_monthly_salary_key", "Other_Source_of_Income_key",
		    "Total_Salary_key", "Direct_Customer_Exposure_key", "Own_installments_key",
		    "Guarantors_Commitments_key" };
	    SessionCO sessionCO = returnSessionObject();
	    iisCommonCO = new IISCommonCO();
	    iisCommonCO.setCompCode(sessionCO.getCompanyCode());
	    iisCommonCO.setCifNo(cifNo);
	    iisCommonCO.setStartDate(sessionCO.getRunningDateRET()); // TODO
	    // startDate
	    iisCommonCO.setProductClass(productClass);
	    iisCommonCO.setBranchCode(sessionCO.getBranchCode());
	    CURRENCIESVO currenciesVO = new CURRENCIESVO();
	    currenciesVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	    currenciesVO.setCURRENCY_CODE(currencyCode == null ? sessionCO.getBaseCurrencyCode():currencyCode);
	    CURRENCIESVO currencyVO = returnCommonLibBO().returnCurrency(currenciesVO);
	    BigDecimal decimalPoints = new BigDecimal(2);
	    if(currencyVO != null && currencyVO.getDECIMAL_POINTS() != null)
	    {
		decimalPoints = currencyVO.getDECIMAL_POINTS();
	    }
	    vtIslamicCalculatorDBRatioSC = iisCommonBO.calculateDBRatio(iisCommonCO);
	    if(!vtIslamicCalculatorDBRatioSC.isEmpty())
	    {
		for(int i = 0; i < 6; i++)
		{
		    vtIslamicCalculatorDBRatioSC.get(i).setDbrDetails(getText(captions[i]));
		    vtIslamicCalculatorDBRatioSC.get(i).setDbrAmountFormat(decimalPoints);
		}
		// IslamicCalculatorDBRatioSC lastElement = new
		// IslamicCalculatorDBRatioSC();
		IslamicCalculatorDBRatioSC summaryObject = new IslamicCalculatorDBRatioSC();
		// lastElement =
		// vtIslamicCalculatorDBRatioSC.remove(vtIslamicCalculatorDBRatioSC.size()-1);
		summaryObject = vtIslamicCalculatorDBRatioSC.remove(vtIslamicCalculatorDBRatioSC.size() - 1);
		vtIslamicCalculatorDBRatioSC.get(vtIslamicCalculatorDBRatioSC.size() - 1).setDbrDetails(
			getText(captions[6]));
		vtIslamicCalculatorDBRatioSC.get(vtIslamicCalculatorDBRatioSC.size() - 1).setDbrAmountFormat(
			decimalPoints);

		IslamicCalculatorDBRatioSC netSalaryObj = new IslamicCalculatorDBRatioSC();
		netSalaryObj.setDbrDetails(getText("Net_Salary_key"));// Net_Salary_key
		netSalaryObj.setDbrAmountFormat(decimalPoints);
		netSalaryObj.setDbrAmount(summaryObject.getDbrAmount());
		vtIslamicCalculatorDBRatioSC.add(netSalaryObj);
		if(vtIslamicCalculatorDBRatioSC != null && vtIslamicCalculatorDBRatioSC.size() > 3)
		{
		    HashMap hm = new HashMap();
		    // hm.put("dbrDetails", getText("Net_Salary_key"));
		    hm.put("dbrDetails", getText("Due_to_the_above_key").concat("(").concat(
			    NumberUtil.format(calculateSum(), CommonMethods.currencyMask(decimalPoints))).concat(" - ")
			    .concat(NumberUtil.format(new BigDecimal(100), CommonMethods.currencyMask(decimalPoints)))
			    .concat("%").concat(
				    " ".concat(getText("of_the_sal")).concat(" ").concat(
					    NumberUtil.format(vtIslamicCalculatorDBRatioSC.get(3).getDbrAmount(),
						    CommonMethods.currencyMask(decimalPoints))).concat(")")));
		    hm.put("dbrAmount", summaryObject.getDbrAmount());
		    setUserdata(hm);
		}
	    }
	    setGridModel(vtIslamicCalculatorDBRatioSC);
	}
	catch(Exception e)
	{
	    e.printStackTrace();
	}
	return "dbrRatio";
    }

    /***
     * Method for getting sum of dbr amount
     * 
     * @return
     */
    private BigDecimal calculateSum()
    {
	BigDecimal dbrAmt = BigDecimal.ZERO;
	for(IslamicCalculatorDBRatioSC islamicCalculatorDBRatioSC : vtIslamicCalculatorDBRatioSC)
	{
	    dbrAmt = dbrAmt.add(NumberUtil.nullToZero(islamicCalculatorDBRatioSC.getDbrAmount()));
	}
	return dbrAmt;
    }

    /**
     * Method for Debit Burdun Ratio
     * 
     * @return
     */
    public String populateIslamicCalculatorDebitBurdunRatioPopup()
    {
	return "populateIslamicCalculatorDebitBurdunRatioPopup";
    }

    public List<IslamicCalculatorDBRatioSC> getVtIslamicCalculatorDBRatioSC()
    {
	return vtIslamicCalculatorDBRatioSC;
    }

    public void setVtIslamicCalculatorDBRatioSC(Vector<IslamicCalculatorDBRatioSC> vtIslamicCalculatorDBRatioSC)
    {
	this.vtIslamicCalculatorDBRatioSC = vtIslamicCalculatorDBRatioSC;
    }

    public IISCommonCO getIisCommonCO()
    {
	return iisCommonCO;
    }

    public void setIisCommonCO(IISCommonCO iisCommonCO)
    {
	this.iisCommonCO = iisCommonCO;
    }

    public void setIisCommonBO(IISCommonBO iisCommonBO)
    {
	this.iisCommonBO = iisCommonBO;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public BigDecimal getProductClass()
    {
	return productClass;
    }

    public void setProductClass(BigDecimal productClass)
    {
	this.productClass = productClass;
    }

    public BigDecimal getCurrencyCode()
    {
	return currencyCode;
    }

    public void setCurrencyCode(BigDecimal currencyCode)
    {
	this.currencyCode = currencyCode;
    }

}
