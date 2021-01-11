package com.path.bo.core.itempropertydet;

import java.util.List;

import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public interface ItemPropertydetBO
{
    // Item Property Details Lookup Action
    public int itemPropertydetListCount(ItemPropertydetSC criteria) throws BaseException;

    public List itemPropertydetList(ItemPropertydetSC criteria) throws BaseException;

    // Item Property Details Dependency Action
    public TRS_ITEM_PROPERTYDETVO returnItemPropertydetByCode(ItemPropertydetSC criteria) throws BaseException;

}
