package com.path.dao.core.itempropertydet;

import java.util.List;

import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public interface ItemPropertydetDAO
{
    // Item Property Details Lookup Action
    public int itemPropertydetListCount(ItemPropertydetSC criteria) throws DAOException;

    public List itemPropertydetList(ItemPropertydetSC criteria) throws DAOException;

    // Item Property Details Dependency Action
    public TRS_ITEM_PROPERTYDETVO returnItemPropertydetByCode(ItemPropertydetSC criteria) throws DAOException;
}
