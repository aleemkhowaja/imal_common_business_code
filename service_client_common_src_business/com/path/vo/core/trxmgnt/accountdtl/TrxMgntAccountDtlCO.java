package com.path.vo.core.trxmgnt.accountdtl;

import java.math.BigDecimal;

import com.path.dbmaps.vo.AMFVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CTSTRS_ACC_DETVO;
import com.path.vo.core.common.RetailBaseVO;

public class TrxMgntAccountDtlCO extends RetailBaseVO
{
  private CTSTRS_ACC_DETVO ctstrsACCDETVO = new CTSTRS_ACC_DETVO();
  private CTSTRS_ACC_DETVO ctstrsACCDETAILSVO = new CTSTRS_ACC_DETVO();
  private AMFVO accountVO = new AMFVO();
  private CIFVO cifVO = new CIFVO();
  private Boolean isVAT = false;
  private String totalPercMsg;
  private String amountDecPoints;
  private String baseDecimalFormat;
  private String signViewedforAccountDetails;
  private BigDecimal signatureAmount;

  public String getBaseDecimalFormat()
  {
      return baseDecimalFormat;
  }
  
  

  public void setBaseDecimalFormat(String baseDecimalFormat)
  {
      this.baseDecimalFormat = baseDecimalFormat;
  }

    public String getAmountDecPoints()
    {
	return amountDecPoints;
    }

    public void setAmountDecPoints(String amountDecPoints)
    {
	this.amountDecPoints = amountDecPoints;
    }

    /**
     * @return the ctstrsACCDETVO
     */
    public CTSTRS_ACC_DETVO getCtstrsACCDETVO()
    {
	return ctstrsACCDETVO;
    }

    /**
     * @param ctstrsACCDETVO the ctstrsACCDETVO to set
     */
    public void setCtstrsACCDETVO(CTSTRS_ACC_DETVO ctstrsACCDETVO)
    {
	this.ctstrsACCDETVO = ctstrsACCDETVO;
    }

    /**
     * @return the accountVO
     */
    public AMFVO getAccountVO()
    {
	return accountVO;
    }

    /**
     * @param accountVO the accountVO to set
     */
    public void setAccountVO(AMFVO accountVO)
    {
	this.accountVO = accountVO;
    }

    /**
     * @return the cifVO
     */
    public CIFVO getCifVO()
    {
	return cifVO;
    }

    /**
     * @param cifVO the cifVO to set
     */
    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public String getTotalPercMsg()
    {
	return totalPercMsg;
    }

    public void setTotalPercMsg(String totalPercMsg)
    {
	this.totalPercMsg = totalPercMsg;
    }

    public Boolean getIsVAT()
    {
	return isVAT;
    }

    public void setIsVAT(Boolean isVAT)
    {
	this.isVAT = isVAT;
    }

    public String getSignViewedforAccountDetails()
    {
	return signViewedforAccountDetails;
    }

    public void setSignViewedforAccountDetails(String signViewedforAccountDetails)
    {
	this.signViewedforAccountDetails = signViewedforAccountDetails;
    }

    public BigDecimal getSignatureAmount()
    {
	return signatureAmount;
    }

    public void setSignatureAmount(BigDecimal signatureAmount)
    {
	this.signatureAmount = signatureAmount;
    }



    public CTSTRS_ACC_DETVO getCtstrsACCDETAILSVO()
    {
        return ctstrsACCDETAILSVO;
    }



    public void setCtstrsACCDETAILSVO(CTSTRS_ACC_DETVO ctstrsACCDETAILSVO)
    {
        this.ctstrsACCDETAILSVO = ctstrsACCDETAILSVO;
    }

}
