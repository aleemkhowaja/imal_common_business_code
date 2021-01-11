/**
* @Auther:WissamAbouJaoude
 * @Date:May 16, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.credittype.CreditTypeBO;
import com.path.dbmaps.vo.CTSCREDIT_TYPEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.credittype.CreditTypeSC;

public class CreditTypeDependencyAction extends RetailBaseAction
{
    private CreditTypeBO creditTypeBO;
    private CreditTypeSC criteria = new CreditTypeSC();
    private BigDecimal CODE;
    private CTSCREDIT_TYPEVO creditTypeVO;

    /**
     * 
     */
    public Object getModel()
    {
	return criteria;
    }
    
    
    public String dependencyByCreditTypeCode() {

	try 
	{
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setCode(CODE);

		creditTypeVO = creditTypeBO.returnCreditTypeById(criteria);
		
	} 
	catch (Exception e) 
	{
		log.error(e,"Error in dependencyByCreditTypeCode method of CardTypeDependencyAction");
		handleException(e, "ERROR in Credit Type Dependency", null);
	}

	return SUCCESS;

}


    public CreditTypeSC getCriteria()
    {
        return criteria;
    }


    public void setCriteria(CreditTypeSC criteria)
    {
        this.criteria = criteria;
    }


    public CTSCREDIT_TYPEVO getCreditTypeVO()
    {
        return creditTypeVO;
    }


    public void setCreditTypeVO(CTSCREDIT_TYPEVO creditTypeVO)
    {
        this.creditTypeVO = creditTypeVO;
    }


    public void setCreditTypeBO(CreditTypeBO creditTypeBO)
    {
        this.creditTypeBO = creditTypeBO;
    }


    public BigDecimal getCODE()
    {
        return CODE;
    }


    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }

  
}


