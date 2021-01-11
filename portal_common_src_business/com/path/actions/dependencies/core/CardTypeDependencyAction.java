/**
 * @Auther:WissamAbouJaoude
 * @Date:May 16, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.cardtype.CardTypeBO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardTypeDependencyAction extends RetailBaseAction
{
    private CardTypeBO cardTypeBO;
    private final CardTypeSC criteria = new CardTypeSC();
    private BigDecimal CODE;
    private CTSCARDSVO cardsVO;

    /**
     * 
     */
    public Object getModel()
    {
	return criteria;
    }
    
    
    public String dependencyByCardTypeCode() {

	try 
	{
		SessionCO sessionCO = returnSessionObject();
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setBranchCode(sessionCO.getBranchCode());//Hala Al Sheikh - TP537584 - SBI170065
		criteria.setCode(CODE);
		criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());

		cardsVO = cardTypeBO.returnCardTypeById(criteria);
		
	} 
	catch (Exception e) 
	{
//		log.error(e,"Error in dependencyByCardTypeCode method of CardTypeDependencyAction");
		handleException(e, null, null);
	}

	return SUCCESS;

}

    public void setCardTypeBO(CardTypeBO cardTypeBO)
    {
        this.cardTypeBO = cardTypeBO;
    }


    public BigDecimal getCODE()
    {
        return CODE;
    }


    public void setCODE(BigDecimal cODE)
    {
        CODE = cODE;
    }


    public CTSCARDSVO getCardsVO()
    {
        return cardsVO;
    }


    public void setCardsVO(CTSCARDSVO cardsVO)
    {
        this.cardsVO = cardsVO;
    }
}


