/**
 * @Auther:WissamAbouJaoude
 * @Date:Mar 27, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.bo.core.cardtype.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.admin.branches.BranchesBO;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.cardtype.CardTypeBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.dao.core.cardtype.CardTypeDAO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.CTSCARDSVO;
import com.path.dbmaps.vo.CTSCARDS_MGTVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.vo.admin.branches.BranchesSC;
import com.path.vo.core.cardsmanagement.CardsManagementCO;
import com.path.vo.core.cardsmanagement.CardsManagementSC;
import com.path.vo.core.cardtype.CardTypeSC;

public class CardTypeBOImpl extends BaseBO implements CardTypeBO
{
    private CardTypeDAO cardTypeDAO;
    private CoreCommonServiceBO coreCommonServiceBO;
    private BranchesBO branchesBO;
    
    public int cardTypeListCount(CardTypeSC criteria)throws BaseException
    {	
	//Hala Al Sheikh - TP537584 - SBI170065
	if("MULTI_HO".equals(criteria.getScreenName()))
	{
	    BranchesSC branchesSC = new BranchesSC();
	    branchesSC.setCompCode(criteria.getCompCode());
	    int nb = branchesBO.returnMultiHO(branchesSC);
	    if(nb > 1)
	    {
		criteria.setMultiHO(true);
	    }
	    else
	    {
		criteria.setMultiHO(false);
	    }
	}
	return cardTypeDAO.cardTypeListCount(criteria);

	}
    
    public List cardTypeList(CardTypeSC criteria)throws BaseException
    {	
	//Hala Al Sheikh - TP537584 - SBI170065
	if("MULTI_HO".equals(criteria.getScreenName()))
	{
	    BranchesSC branchesSC = new BranchesSC();
	    branchesSC.setCompCode(criteria.getCompCode());
	    int nb = branchesBO.returnMultiHO(branchesSC);
	    if(nb > 1)
	    {
		criteria.setMultiHO(true);
	    }
	    else
	    {
		criteria.setMultiHO(false);
	    }
	}
	return cardTypeDAO.cardTypeList(criteria);
    }
    
    public CTSCARDSVO returnCardTypeById(CardTypeSC criteria)throws BaseException
    {
	if (criteria.getType() != null && StringUtil.isNotEmpty(criteria.getType()))
	    {
		if("2".equals(criteria.getType()))
		{
		    criteria.setCardCrDrtype("D");
		}
		else if("3".equals(criteria.getType()))
		{
		    criteria.setCardCrDrtype("C");
		}
		else
		{
		    criteria.setCardCrDrtype(null);
		}
	    }
	CTSCARDSVO ctsCardsVO = cardTypeDAO.returnCardTypeById(criteria);

	
	if(ctsCardsVO == null)
	    {
		throw new BOException(MessageCodes.Card_Type_not_Allowed);
	    }
	
	//BB180048-hussein-DCR for bb -Christina -Hassan
	if(ctsCardsVO != null && StringUtil.isNotEmpty(ctsCardsVO.getSTATUS()) && !"A".equals(ctsCardsVO.getSTATUS()))
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_STATUS);
	}
	// Hala Al Sheikh - TP537584 - SBI170065
	if(ctsCardsVO != null && "MULTI_HO".equals(criteria.getScreenName()))
	{
	    BranchesSC branchesSC = new BranchesSC();
	    branchesSC.setCompCode(criteria.getCompCode());
	    int result = branchesBO.returnMultiHO(branchesSC);
	    if(result > 1) // IsMultiHO //TP537584 - SBI170065
	    {
		BigDecimal allowedBrHo = NumberUtil.emptyDecimalToZero(ctsCardsVO.getALLOWED_IN_BR_UNDER_HO());

		BRANCHESVO branchesVO = new BRANCHESVO();
		branchesVO.setCOMP_CODE(criteria.getCompCode());
		branchesVO.setBRANCH_CODE(criteria.getBranchCode());
		branchesVO = commonLibBO.returnBranch(branchesVO);
		BigDecimal hoBranch = BigDecimal.ZERO;
		if(branchesVO != null)
		{
		    if("H".equals(branchesVO.getBR_TYPE()))
		    {
			hoBranch = criteria.getBranchCode();
		    }
		    else
		    {
			hoBranch = branchesVO.getMAIN_HO_BR();
		    }
		}
		if(allowedBrHo.compareTo(NumberUtil.emptyDecimalToZero(hoBranch)) != 0)
		{
		    throw new BOException(MessageCodes.CARD_TYPE_NOT_ALLOWED);
		}
	    }
	}
	
	// Rania - AIBBI180088 - Credit Card & Taqseed Card Managment
	if(ctsCardsVO != null && "1".equals(ctsCardsVO.getDISALLOW_MANUAL_CARD_CREAT_YN()))
	{
	    throw new BOException(MessageCodes.USER_CANNOT_CREATE_CARD_TYPE_MANUALLY);
	}
	// End Rania
	    
	return ctsCardsVO;
    }
    
    public CardTypeDAO getCardTypeDAO()
    {
        return cardTypeDAO;
    }
    
    public void setCardTypeDAO(CardTypeDAO cardTypeDAO)
    {
        this.cardTypeDAO = cardTypeDAO;
    }

    public CoreCommonServiceBO getCoreCommonServiceBO()
    {
        return coreCommonServiceBO;
    }

    public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
    {
        this.coreCommonServiceBO = coreCommonServiceBO;
    }

    public CTSCARDSVO returnDefaultedCardByCifTypeCode(CardTypeSC criteria) throws BaseException
    {
	return cardTypeDAO.returnDefaultedCardByCifTypeCode(criteria);
    }

    public List cardMgtList(CardsManagementSC criteria) throws BaseException
    {
	List<CTSCARDS_MGTVO> cardsMgtVOList = cardTypeDAO.cardMgtList(criteria);

	CardsManagementCO cardsManagementCO = new CardsManagementCO();
	for(CTSCARDS_MGTVO cardsMgntVO : cardsMgtVOList)
	{
	    cardsManagementCO.setLoginCompCode(criteria.getCompCode());
	    cardsManagementCO.setLoginBraCode(criteria.getBranchCode());
	    cardsManagementCO.setCardsMgtVO(cardsMgntVO);
	    cardsManagementCO.getCtsTellerVO().setMASK_CARD_NO(criteria.getMaskedCardNo());
	    cardsManagementCO.setLoginUserId(criteria.getUserId());//Hasan Bug#457443 10/04/2017
	    cardsMgntVO.setREFERENCE(coreCommonServiceBO.returnMaskedCardNo(cardsManagementCO));
	}
	return cardsMgtVOList;
    }

    public int cardMgtListCount(CardsManagementSC criteria) throws BaseException
    {
	return cardTypeDAO.cardMgtListCount(criteria);
    }

    public BranchesBO getBranchesBO()
    {
        return branchesBO;
    }

    public void setBranchesBO(BranchesBO branchesBO)
    {
        this.branchesBO = branchesBO;
    }
    

}
