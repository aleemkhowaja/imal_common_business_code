package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.accounttype.AccountTypeBO;
import com.path.dbmaps.vo.RIFATTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.accounttype.AccountTypeSC;

public class AccountTypeDependencyAction extends RetailBaseAction
{
	private AccountTypeBO accountTypeBO;
	private RIFATTVO accountTypeVO;
	private BigDecimal accTypeCode;
	
	public String dependencyByAccountTypeCode() {

		try 
		{
		    if(NumberUtil.isEmptyDecimal(accTypeCode))
		    {
			accountTypeVO = new RIFATTVO();
		    }
		    else
		    {
			AccountTypeSC criteria = new AccountTypeSC();
			criteria.setCompCode(returnSessionObject().getCompanyCode());
			criteria.setTypeCode(accTypeCode);

			accountTypeVO = accountTypeBO.returnAccountTypeById(criteria);
			if(accountTypeVO == null)
			{
			    accountTypeVO = new RIFATTVO();
			}
		    }
			
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyByAccountTypeCode method of AccountTypeDependencyAction");
			handleException(e, "ERROR in AccountType Dependency", null);
		}

		return SUCCESS;

	}

	public RIFATTVO getAccountTypeVO()
	{
		return accountTypeVO;
	}

	public void setAccountTypeVO(RIFATTVO accountTypeVO)
	{
		this.accountTypeVO = accountTypeVO;
	}

	public BigDecimal getAccTypeCode()
	{
		return accTypeCode;
	}

	public void setAccTypeCode(BigDecimal accTypeCode)
	{
		this.accTypeCode = accTypeCode;
	}

	public void setAccountTypeBO(AccountTypeBO accountTypeBO)
	{
		this.accountTypeBO = accountTypeBO;
	}
		
}
