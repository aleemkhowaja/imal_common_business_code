/**
 * 
 */
package com.path.bo.common.global360view.cards.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.common.global360view.cards.CardsBO;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.dao.common.global360view.cards.CardsDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.global360view.CardsCO;
import com.path.vo.common.global360view.DashboardSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.common.AccRestrictedSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * SafeBoxesBOImpl.java used to
 */
public class CardsBOImpl extends BaseBO implements CardsBO 
{
    private CardsDAO cardsDAO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private CoreCommonProcedureBO coreCommonProcedureBO;
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int cardsListCount(DashboardSC criteria) throws BaseException
    {

	AccRestrictedSC accRestrictedSC  = new AccRestrictedSC();
	accRestrictedSC.setFrAcBr(new BigDecimal(0));
	accRestrictedSC.setFrAcCif(criteria.getCif_no());
	accRestrictedSC.setFrAcCy(new BigDecimal(0));
	accRestrictedSC.setFrAcGl(new BigDecimal(0));
	accRestrictedSC.setFrAcSl(new BigDecimal(0));
	accRestrictedSC.setToAcBr(new BigDecimal(9999));
	accRestrictedSC.setToAcCif(criteria.getCif_no());
	accRestrictedSC.setToAcCy(new BigDecimal(999));
	accRestrictedSC.setToAcGl(new BigDecimal(999999));
	accRestrictedSC.setToAcSl(new BigDecimal(999));
	accRestrictedSC.setAppName(criteria.getAppName());
	accRestrictedSC.setUserId(criteria.getUserId());
	accRestrictedSC.setCompCode(criteria.getCompCode());
	accRestrictedSC.setBranchCode(criteria.getBranchCode());
	accRestrictedSC.setProgRef(criteria.getProgRef());
	//coreCommonProcedureBO.fillAccRestricted(accRestrictedSC);
	     
	return cardsDAO.cardsListCount(criteria);
    }

    /**
     * 
     * @param criteria
     * @return List
     * @throws BaseException
     * This method returns all records and the masked card number in case the masked card number flag is checked at the level of CSMADIM-> User-> Maintenance screen
     */
    public List<CardsCO> cardsList(DashboardSC criteria) throws BaseException
    {
	return batchMaskedCardNo(cardsDAO.cardsList(criteria), criteria);
    }

    /**
     * @return the cardsDAO
     */
    public CardsDAO getCardsDAO()
    {
        return cardsDAO;
    }

    /**
     * @param cardsDAO the cardsDAO to set
     */
    public void setCardsDAO(CardsDAO cardsDAO)
    {
        this.cardsDAO = cardsDAO;
    }
    

    /**
     * return masked Card for list of card
     * @param cardNum
     * @return
     */
    public List batchMaskedCardNo(List<CardsCO> cardsLst, DashboardSC criteria) throws BaseException
    {
	CardsManagementCO cardsManagementCO = new CardsManagementCO();
	
	for(CardsCO cardsCO : cardsLst)
	{
	    cardsManagementCO.setLoginCompCode(criteria.getCompCode());
	    cardsManagementCO.setLoginBraCode(criteria.getLoginBranchCode());
	    cardsManagementCO.setLoginUserId(criteria.getUserId());
	    cardsManagementCO.getCtsTellerVO().setMASK_CARD_NO(criteria.getMaskedCardNo());
	    cardsManagementCO.getCardsMgtVO().setCARD_NO(cardsCO.getCtsCardsMGTVO().getCARD_NO());
	    cardsManagementCO.setLoginUserId(criteria.getUserId());
	    //we are setting the cardNumber mask column in the grid
	    //the checking of wehter the flag of "card number mask" is done in commonLibBO.returnMaskedCardNo
	    cardsCO.setMaskedCardNo(coreCommonServiceBO.returnMaskedCardNo(cardsManagementCO));
	}
	return cardsLst;
    }
    
    // BB140052 -- [Hasan Youssef]
    public int cardsManagementListCount(CardsManagementSC criteria) throws BaseException
    {
    	return cardsDAO.cardsManagementListCount(criteria);
    }
    
    public List cardsManagementList(CardsManagementSC criteria) throws BaseException
    {
    	List<CardsManagementCO> cardsManagementLst = cardsDAO.cardsManagementList(criteria);
    	
    	if(!"G001BA".equals(criteria.getProgRef()))//795158 BB-S10 Activating other branch cards[falha]
    	{
    	for(CardsManagementCO cardsManagementCO : cardsManagementLst)
    	{
    		cardsManagementCO.setLoginCompCode(criteria.getCompCode());
    	    cardsManagementCO.setLoginBraCode(criteria.getBranchCode());
    	    cardsManagementCO.setLoginUserId(criteria.getUserId());
    	    cardsManagementCO.getCtsTellerVO().setMASK_CARD_NO(criteria.getMaskedCardNo());
    	    cardsManagementCO.setMaskedCardNo(coreCommonServiceBO.returnMaskedCardNo(cardsManagementCO));
    	}
    	}
    	return cardsManagementLst;
    }
    //end hasan 

  //Hala Al Sheikh - ABEI180106
    public int collateralsListCount(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return cardsDAO.collateralsListCount(cardsManagementSC);
    }
    public List collateralsList(CardsManagementSC cardsManagementSC) throws BaseException
    {
	return cardsDAO.collateralsList(cardsManagementSC);
    }
    //End Hala Al Sheikh - ABEI180106    
    
    public CoreCommonServiceBO getCoreCommonServiceBO()
    {
        return coreCommonServiceBO;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }
    

    public CoreCommonProcedureBO getCoreCommonProcedureBO()
    {
        return coreCommonProcedureBO;
    }

    public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO)
    {
        this.coreCommonProcedureBO = coreCommonProcedureBO;
    }
    

}
