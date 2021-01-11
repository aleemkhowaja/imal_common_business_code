package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.rifcttgl.RifcttGlBO;
import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.rifcttgl.RifcttGlSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * RifcttGlDependencyAction.java used to
 */
public class RifcttGlDependencyAction extends RetailBaseAction
{
	private RifcttGlBO rifcttGlBO;
	private RIFCTT_GLVO rifcttGlVO;
	private BigDecimal typeCode;
	private BigDecimal gl_Code;
	private BigDecimal slNo;
	private BigDecimal currencyCode;

	 public String dependencyByRifcttGl() {

		try 
		{
			SessionCO sessionCO = returnSessionObject();
			RifcttGlSC criteria = new RifcttGlSC();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setCifTypeCode(typeCode);
			criteria.setGlCode(gl_Code);
			criteria.setSlNbr(slNo);
			criteria.setCyCode(currencyCode);

			rifcttGlVO = rifcttGlBO.returnRifcttGlById(criteria);
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByRifcttGl method of RifcttGlDependencyAction");
			handleException(e, "ERROR in RifcttGl Dependency", null);
		}

		return SUCCESS;

	}




	public RIFCTT_GLVO getRifcttGlVO()
	{
		return rifcttGlVO;
	}


	public void setRifcttGlVO(RIFCTT_GLVO rifcttGlVO)
	{
		this.rifcttGlVO = rifcttGlVO;
	}


	public BigDecimal getTypeCode()
	{
		return typeCode;
	}


	public void setTypeCode(BigDecimal typeCode)
	{
		this.typeCode = typeCode;
	}


	public void setRifcttGlBO(RifcttGlBO rifcttGlBO)
	{
		this.rifcttGlBO = rifcttGlBO;
	}




	public BigDecimal getGl_Code()
	{
		return gl_Code;
	}




	public void setGl_Code(BigDecimal glCode)
	{
		gl_Code = glCode;
	}




	public BigDecimal getSlNo()
	{
		return slNo;
	}




	public void setSlNo(BigDecimal slNo)
	{
		this.slNo = slNo;
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
