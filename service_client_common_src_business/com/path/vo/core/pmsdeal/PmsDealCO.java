/**
 * 
 */
package com.path.vo.core.pmsdeal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import com.path.dbmaps.vo.PMSDEALVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.common.RetailBaseVO;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: raees
 * 
 *          PmsDealCO.java used to
 */
public class PmsDealCO extends RetailBaseVO
{
    private PMSDEALVO pmsDealVO;
    private String shortNameEng;
    private ArrayList<BaseException> listOfWarningMessages = new ArrayList<BaseException>();
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String tradeDetailsGridPriceFormat;
    private String cyName;
    private BigDecimal cyDecPoints;

    /**
     * @return the pmsDealVO
     */
    public PMSDEALVO getPmsDealVO()
    {
	return pmsDealVO;
    }

    /**
     * @param pmsDealVO the pmsDealVO to set
     */
    public void setPmsDealVO(PMSDEALVO pmsDealVO)
    {
	this.pmsDealVO = pmsDealVO;
    }

    /**
     * @return the shortNameEng
     */
    public String getShortNameEng()
    {
	return shortNameEng;
    }

    /**
     * @param shortNameEng the shortNameEng to set
     */
    public void setShortNameEng(String shortNameEng)
    {
	this.shortNameEng = shortNameEng;
    }

    public ArrayList<BaseException> getListOfWarningMessages()
    {
	return listOfWarningMessages;
    }

    public void setListOfWarningMessages(ArrayList<BaseException> listOfWarningMessages)
    {
	this.listOfWarningMessages = listOfWarningMessages;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
	return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
	this.hm = hm;
    }

    public String getTradeDetailsGridPriceFormat()
    {
	return tradeDetailsGridPriceFormat;
    }

    public void setTradeDetailsGridPriceFormat(String tradeDetailsGridPriceFormat)
    {
	this.tradeDetailsGridPriceFormat = tradeDetailsGridPriceFormat;
    }

    public String getCyName()
    {
	return cyName;
    }

    public void setCyName(String cyName)
    {
	this.cyName = cyName;
    }

    public BigDecimal getCyDecPoints()
    {
	return cyDecPoints;
    }

    public void setCyDecPoints(BigDecimal cyDecPoints)
    {
	this.cyDecPoints = cyDecPoints;
    }

}
