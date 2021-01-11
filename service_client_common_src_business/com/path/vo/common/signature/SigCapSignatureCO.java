package com.path.vo.common.signature;

import java.math.BigDecimal;
import java.util.HashMap;

import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;

public class SigCapSignatureCO extends BaseVO
{

    private String sigCapUrl;
    private String sigAaccountReference;
    private BigDecimal sigCapAmount;
    private String sigScreen;
    private HashMap<String,SYS_PARAM_SCREEN_DISPLAYVO> businessHm;
    
    
    

    public String getSigScreen()
    {
        return sigScreen;
    }

    public void setSigScreen(String sigScreen)
    {
        this.sigScreen = sigScreen;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBusinessHm()
    {
        return businessHm;
    }

    public void setBusinessHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> businessHm)
    {
        this.businessHm = businessHm;
    }

    public BigDecimal getSigCapAmount()
    {
        return sigCapAmount;
    }

    public void setSigCapAmount(BigDecimal sigCapAmount)
    {
        this.sigCapAmount = sigCapAmount;
    }

    public String getSigCapUrl()
    {
	return sigCapUrl;
    }

    public void setSigCapUrl(String sigCapUrl)
    {
	this.sigCapUrl = sigCapUrl;
    }

    public String getSigAaccountReference()
    {
	return sigAaccountReference;
    }

    public void setSigAaccountReference(String sigAaccountReference)
    {
	this.sigAaccountReference = sigAaccountReference;
    }

}