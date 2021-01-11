package com.path.bo.core.itempropertydet.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.itempropertydet.ItemPropertydetBO;
import com.path.dao.core.itempropertydet.ItemPropertydetDAO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.IISCTRLVOKey;
import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

/**
 * @Auther:Pappady
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
@SuppressWarnings("serial")
public class ItemPropertydetBOImpl extends BaseBO implements ItemPropertydetBO
{
    private ItemPropertydetDAO itemPropertydetDAO;

    /**
     * return the Item Property Details list count...
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int itemPropertydetListCount(ItemPropertydetSC criteria) throws BaseException
    {
	return itemPropertydetDAO.itemPropertydetListCount(criteria);
    }

    /**
     * return a list contains all Item Property Details based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List itemPropertydetList(ItemPropertydetSC criteria) throws BaseException
    {
	return itemPropertydetDAO.itemPropertydetList(criteria);
    }

    public TRS_ITEM_PROPERTYDETVO returnItemPropertydetByCode(ItemPropertydetSC criteria) throws BaseException
    {
	TRS_ITEM_PROPERTYDETVO trsItemPropertydetVO;
	trsItemPropertydetVO = itemPropertydetDAO.returnItemPropertydetByCode(criteria);
	// TP#157380;BejoyKodiyan;13/07/2014
	IISCTRLVOKey iisctrlvoKey = new IISCTRLVOKey();
	iisctrlvoKey.setCOMP_CODE(criteria.getCompCode());
	iisctrlvoKey.setBRANCH_CODE(criteria.getBranchCode());
	IISCTRLVO iisctrlVO = (IISCTRLVO) genericDAO.selectByPK(iisctrlvoKey);
	// TP#237710 ;Ravikant.Singh ;20/11/2014
    if(StringUtil.nullEmptyToValue(iisctrlVO.getITEM_DESC_IN_ARAB(), ConstantsCommon.NO)
                    .equals(ConstantsCommon.YES)
                    && trsItemPropertydetVO != null)
    {
        trsItemPropertydetVO.setPROPERTY_VALUE(StringUtil.nullToEmpty(trsItemPropertydetVO.getPROPERTY_VALUE_A()));
    }

	return trsItemPropertydetVO;
    }

    public ItemPropertydetDAO getItemPropertydetDAO()
    {
	return itemPropertydetDAO;
    }

    public void setItemPropertydetDAO(ItemPropertydetDAO itemPropertydetDAO)
    {
	this.itemPropertydetDAO = itemPropertydetDAO;
    }

}
