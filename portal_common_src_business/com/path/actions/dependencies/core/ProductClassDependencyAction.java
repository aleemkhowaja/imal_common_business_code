package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.productclass.ProductClassBO;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.productclass.ProductClassCO;
import com.path.vo.core.productclass.ProductClassSC;

public class ProductClassDependencyAction extends RetailBaseAction
{
    private ProductClassBO productClassBO;
    private ProductClassCO productClassCO;
    private BigDecimal CODE;
    private String calculatorType;
    private BigDecimal productClassId;
    private BigDecimal productCategory;
    private String productAppName;
    private String allTypesFlag;

    public String dependencyByMergeProductClassCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    ProductClassSC criteria = new ProductClassSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setAppName(sessionCO.getCurrentAppName());
	    criteria.setProductClassCode(CODE);
	    criteria.setProductClassCode(productClassId);
	    Object productDep = null;
	    if(productClassId.compareTo(BigDecimal.ZERO) != 0)
	    {
		productDep = productClassBO.returnMergeProductClassById(criteria);
	    }
	    else
	    {
		productDep = productClassBO.returnMergeProductClassByCode(criteria);
	    }

	    if(productDep == null)
	    {
		String errMsg = returnCommonLibBO().returnTranslErrorMessage(MessageCodes.INVALID_MISSING_PRODUCT_CLASS,
			sessionCO.getLanguage());
		addDependencyMsg(errMsg, null);
	    }
	    if(productClassId.compareTo(BigDecimal.ZERO) != 0)
	    {
		productClassCO = productClassBO.returnMergeProductClassById(criteria);
	    }
	    else
	    {
		productClassCO = productClassBO.returnMergeProductClassByCode(criteria);
	    }

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String dependencyByProductClassCode()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    ProductClassSC criteria = new ProductClassSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    if(productAppName == null || "".equals(productAppName))
	    {
		criteria.setAppName(sessionCO.getCurrentAppName());
	    }
	    else
	    {
		criteria.setAppName(productAppName);
	    }

	    criteria.setProductClassCode(CODE);
	    criteria.setIsRAhnyn(calculatorType);
	    criteria.setCategoryCode(NumberUtil.nullToZero(productCategory));
	    if(NumberUtil.nullToZero(CODE).compareTo(BigDecimal.ZERO) == 1)
	    {
		Object productDep = productClassBO.returnProductClassByCode(criteria);
		if(productDep == null && ConstantsCommon.NO
			.equals(StringUtil.nullEmptyToValue(criteria.getIsRAhnyn(), ConstantsCommon.NO)))
		{
		    String errMsg = returnCommonLibBO().returnTranslErrorMessage(
			    MessageCodes.INVALID_MISSING_PRODUCT_CLASS, sessionCO.getLanguage());
		    addDependencyMsg(errMsg, null);
		}
		if(ConstantsCommon.YES.equals(criteria.getIsRAhnyn()))
		{
		    productClassCO = productClassBO.returnProductClassCodeArRhanu(criteria);

		}
		else
		{
		    productClassCO = productClassBO.returnProductClassByCode(criteria);
		}
	    }
	    else
	    {
		productClassCO = new ProductClassCO();
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public String dependencyByProductClassCodeFms()
    {

	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    ProductClassSC criteria = new ProductClassSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setProductClassCode(CODE);
	    criteria.setAllTypesFlag(allTypesFlag);
	    criteria.setAllTypes(getText("All_types_key"));
	    productClassCO = productClassBO.returnProductClassByCodeFms(criteria);

	}
	catch(Exception e)
	{
	    productClassCO = new ProductClassCO();
	    handleException(e, null, null);
	}

	return SUCCESS;

    }

    public void setProductClassBO(ProductClassBO productClassBO)
    {
	this.productClassBO = productClassBO;
    }

    public ProductClassCO getProductClassCO()
    {
	return productClassCO;
    }

    public void setProductClassCO(ProductClassCO productClassCO)
    {
	this.productClassCO = productClassCO;
    }

    public BigDecimal getCODE()
    {
	return CODE;
    }

    public void setCODE(BigDecimal cODE)
    {
	CODE = cODE;
    }

    public BigDecimal getProductClassId()
    {
	return productClassId;
    }

    public void setProductClassId(BigDecimal productClassId)
    {
	this.productClassId = productClassId;
    }

    public String getCalculatorType()
    {
	return calculatorType;
    }

    public void setCalculatorType(String calculatorType)
    {
	this.calculatorType = calculatorType;
    }

    public BigDecimal getProductCategory()
    {
	return productCategory;
    }

    public void setProductCategory(BigDecimal productCategory)
    {
	this.productCategory = productCategory;
    }

    public String getProductAppName()
    {
	return productAppName;
    }

    public void setProductAppName(String productAppName)
    {
	this.productAppName = productAppName;
    }

    public String getAllTypesFlag()
    {
	return allTypesFlag;
    }

    public void setAllTypesFlag(String allTypesFlag)
    {
	this.allTypesFlag = allTypesFlag;
    }

}
