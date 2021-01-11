package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.fmsindicator.FmsIndicatorBO;
import com.path.dbmaps.vo.FMSINDICATORVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.fmsindicator.FmsIndicatorSC;

public class FmsIndicatorDependencyAction extends RetailBaseAction
{
	private FmsIndicatorBO fmsIndicatorBO;
	private FMSINDICATORVO fmsIndicatorVO = new FMSINDICATORVO();
	private BigDecimal code;
	private BigDecimal multiplier;
	private BigDecimal value;
	private BigDecimal netValue;
	private BigDecimal cifNo;

	
	public String dependencyOfFmsIndicatorNameById() throws BaseException {
	    
		try 
		{
		    	if(NumberUtil.isEmptyDecimal(code))
		    	{
		    	    setValue(BigDecimal.ZERO);
		    	    fmsIndicatorVO.setMULTIPLIER(multiplier);
		    	    fmsIndicatorVO.setBRIEF_NAME_ENG(null);
		    	    setNetValue(getValue().multiply(fmsIndicatorVO.getMULTIPLIER()));
		    	}
		    	else
		    	{
		    	    FmsIndicatorSC criteria = new FmsIndicatorSC();   
		    	    criteria.setCompCode(returnSessionObject().getCompanyCode());
		    	    criteria.setIndicatorCode(code);
		    	    fmsIndicatorVO = fmsIndicatorBO.returnFmsIndicatorNameById(criteria);
		    	    setNetValue(getValue().multiply(fmsIndicatorVO.getMULTIPLIER()));
		    	}
		    	
			
		} 
		catch (Exception e) 
		{
 		    	fmsIndicatorVO.setCODE(null);
		    	fmsIndicatorVO.setBRIEF_NAME_ENG(null);
		    	handleException(e, null, null);
		}

		return SUCCESS;

	}
	public String dependencyOfFmsGrossValue() throws BaseException {

		try 
		{	
				FmsIndicatorSC criteria = new FmsIndicatorSC();
				criteria.setIndicatorCode(code);
				if(getMultiplier() == null)
				{
				   setMultiplier(BigDecimal.ONE);
				}
				criteria.setMultiplier(getMultiplier());
				if(NumberUtil.isEmptyDecimal(getValue()))
				{
				    setValue(BigDecimal.ZERO);
				}
				criteria.setValue(getValue());
				    
				netValue = fmsIndicatorBO.dependencyOfFmsGrossValue(criteria);
				if(BigDecimal.ZERO.equals(netValue))
				{
				    setValue(BigDecimal.ZERO);
				}
				
		    
			
		} 
		catch (Exception e) 
		{
		    	setValue(BigDecimal.ZERO);
		    	setNetValue(BigDecimal.ZERO);
		    	handleException(e, null, null);
		    	
		}

		return SUCCESS;

	}
	
	public String returnFmsCustomerIndicatorNameById() throws BaseException {
	    
		try 
		{
		    	if(NumberUtil.isEmptyDecimal(code))
		    	{
		    	    fmsIndicatorVO = new FMSINDICATORVO();
		    	}
		    	else
		    	{
		    	    FmsIndicatorSC criteria = new FmsIndicatorSC();   
		    	    criteria.setCompCode(returnSessionObject().getCompanyCode());
		    	    criteria.setIndicatorCode(code);
		    	    criteria.setCifNo(NumberUtil.isEmptyDecimal(cifNo)?BigDecimal.ZERO : cifNo);
		    	    fmsIndicatorVO = fmsIndicatorBO.returnFmsCustomerIndicatorNameById(criteria);
		    	}
			
		} 
		catch (Exception e) 
		{
		    	fmsIndicatorVO.setCODE(null);
		    	fmsIndicatorVO.setBRIEF_NAME_ENG(null);
		    	handleException(e, null, null);
		}
		return SUCCESS;
	}
	

	public BigDecimal getMultiplier()
	{
	    return multiplier;
	}
	public void setMultiplier(BigDecimal multiplier)
	{
	    this.multiplier = multiplier;
	}
	public BigDecimal getValue()
	{
	    return value;
	}
	public void setValue(BigDecimal value)
	{
	    this.value = value;
	}
	public FMSINDICATORVO getFmsIndicatorVO()
	{
		return fmsIndicatorVO;
	}


	public void setFmsIndicatorVO(FMSINDICATORVO fmsIndicatorVO)
	{
		this.fmsIndicatorVO = fmsIndicatorVO;
	}



	public void setFmsIndicatorBO(FmsIndicatorBO fmsIndicatorBO)
	{
		this.fmsIndicatorBO = fmsIndicatorBO;
	}

	public BigDecimal getCode()
	{
		return code;
	}

	public void setCode(BigDecimal code)
	{
		this.code = code;
	}
	public BigDecimal getNetValue()
	{
	    return netValue;
	}
	public void setNetValue(BigDecimal netValue)
	{
	    this.netValue = netValue;
	}
	/**
	 * @return the cifNo
	 */
	public BigDecimal getCifNo()
	{
	    return cifNo;
	}
	/**
	 * @param cifNo the cifNo to set
	 */
	public void setCifNo(BigDecimal cifNo)
	{
	    this.cifNo = cifNo;
	}
	
}
