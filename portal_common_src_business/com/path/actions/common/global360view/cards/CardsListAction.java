/**
 * 
 */
package com.path.actions.common.global360view.cards;

import java.util.HashMap;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.global360view.cards.CardsBO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * CardsListAction.java used to
 */
public class CardsListAction extends GridBaseAction
{
    private DashboardSC criteria = new DashboardSC();
    private CardsBO cardsBO;
    /**
     * 
     * @date   May 3, 2013
     * @return String 
     *
     */
    public String loadCardsPage()
    {
        return SUCCESS;
    }
    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
  	return criteria;
    }  
    /**
     * 
     * @date   May 3, 2013
     * @return
     */
    public String cardsListGrid()
    {
  	String[] searchCol ={"banch_code"
  			    ,"APPLICATION_ID"
                  	    ,"CARD_NO"
                  	    ,"APP_REF"
                  	    ,"CARD_HOLDER_NAME"
                  	    ,"OUTSTANDING_BALANCE"
                  	    ,"DUE_AMOUNT"
                  	    ,"EFFECTIVE_DATE"
                  	    ,"primary_suplementary"
                  	    ,"card_type"
                  	    ,"expiry_date"
                  	    ,"status"
                  	    ,"credit_type"
                  	    ,"payment_perc"
                  	    ,"acc_br","acc_cy","acc_gl","acc_cif","acc_sl","ACC_ADD_REF","ACC_LONG_NAME_ENG"};

  	try
  	{

  	    HashMap dateSearchCols = new HashMap();
	    dateSearchCols.put("EFFECTIVE_DATE", "EFFECTIVE_DATE");
  	    SessionCO sessionCO = returnSessionObject();
  	    criteria.setSearchCols(searchCol);
  	    criteria.setDateSearchCols(dateSearchCols);
  	    copyproperties(criteria);
  	    
  	    criteria.setCompCode(sessionCO.getCompanyCode());
            if(ConstantsCommon.DASH_LOGIN_BRANCH.equals(criteria.getLoginTypeByBr()))
    	    {
    	       criteria.setBranchCode(sessionCO.getBranchCode());
    	    }
            criteria.setLoginBranchCode(sessionCO.getBranchCode());
  	    criteria.setIvCrud( getIv_crud());
  	    criteria.setProgRef(get_pageRef());
  	    criteria.setAppName( sessionCO.getCurrentAppName());
  	    criteria.setLanguage(sessionCO.getLanguage());
  	    criteria.setLovType(ConstantsCommon.CARDS_MANAGEMENT_STATUS_LOV_TYPE);
  	    criteria.setLovTypePrimSupp(ConstantsCommon.CARDS_MANAGEMENT_PRIMSUPP_LOV_TYPE);
	    if(sessionCO.getCtsTellerVO() != null)// Abdo TP#562279 11/09/2017
	    {
		criteria.setMaskedCardNo(sessionCO.getCtsTellerVO().getMASK_CARD_NO());
	    }
	    else
	    {
		criteria.setMaskedCardNo("");
	    }
  	    criteria.setUserId(sessionCO.getUserName());
  	    
	    if(ConstantsCommon.RET_APP_NAME.equals(sessionCO.getCurrentAppName()))
	    {
		criteria.setTellerCode(sessionCO.getCtsTellerVO().getCODE());
	    }
  	    if(checkNbRec(criteria))
  	    {
  		setRecords(cardsBO.cardsListCount(criteria));
  	    }
  	    setGridModel(cardsBO.cardsList(criteria));
  	}

        catch(Exception ex)
        {
  	    log.error(ex, "Error in Cards List Grid");
  	    handleException(ex, null, null);
        }
        return SUCCESS;
    }

    /**
     * @return the criteria
     */
    public DashboardSC getCriteria()
    {
        return criteria;
    }

    /**
     * @param criteria the criteria to set
     */
    public void setCriteria(DashboardSC criteria)
    {
        this.criteria = criteria;
    }

    /**
     * @param cardsBO the cardsBO to set
     */
    public void setCardsBO(CardsBO cardsBO)
    {
        this.cardsBO = cardsBO;
    }
}
