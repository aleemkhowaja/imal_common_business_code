/**
 * @Auther:WissamAbouJaoude
 * @Date:May 18, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.trxtype.TrxTypeBO;
import com.path.dbmaps.vo.CTSTRXTYPEVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.trxtype.TrxTypeSC;

public class CardsTrxTypeDependencyAction extends RetailBaseAction
{
    private CTSTRXTYPEVO cardsTrxTypeVO;
    private final TrxTypeSC criteria = new TrxTypeSC();
    private TrxTypeBO trxTypeBO;
    private BigDecimal CODE;
    
    public Object getModel()
    {
	return criteria;
    }
    
    public String dependencyByCardTrxTypeCode() {

	try 
	{
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setCode(CODE);

		cardsTrxTypeVO = trxTypeBO.cardsTrxTypeDependency(criteria);
		
	} 
	catch (Exception e) 
	{
		log.error(e,"Error in dependencyByCardTrxTypeCode method of CardsTrxTypeDependencyAction");
		handleException(e, "ERROR in Card Trx Type Dependency", null);
	}

	return SUCCESS;
    }
    
    public String dependencyByTransactionTrendsTrxTypeCode() {

	try 
	{
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setCode(CODE);
		cardsTrxTypeVO = trxTypeBO.trxTypeForTransactionTrendsDependency(criteria);
		
	} 
	catch (Exception e) 
	{
		log.error(e,"Error in dependencyByCardTrxTypeCode method of CardsTrxTypeDependencyAction");
		handleException(e, "ERROR in Card Trx Type Dependency", null);
	}

	return SUCCESS;
    }
    
    public CTSTRXTYPEVO getCardsTrxTypeVO()
    {
        return cardsTrxTypeVO;
    }
    public void setCardsTrxTypeVO(CTSTRXTYPEVO cardsTrxTypeVO)
    {
        this.cardsTrxTypeVO = cardsTrxTypeVO;
    }
    public void setTrxTypeBO(TrxTypeBO trxTypeBO)
    {
        this.trxTypeBO = trxTypeBO;
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