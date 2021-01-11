package com.path.dao.core.itempropertydet.impl;

import java.util.List;

import com.path.dao.core.itempropertydet.ItemPropertydetDAO;
import com.path.dbmaps.vo.TRS_ITEM_PROPERTYDETVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.itempropertydet.ItemPropertydetSC;

/**
 * @Auther:Pappady
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public class ItemPropertydetDAOImpl extends BaseDAO implements ItemPropertydetDAO
{
    /**
     * sql map to get the count of the Item Property Details list based on a
     * defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int itemPropertydetListCount(ItemPropertydetSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "itemPropertydetMapper.itemPropertydetListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("itemPropertydetMapper.itemPropertydetListCount", criteria))
		.intValue();
	return nb;
    }

    /**
     * sql map to get the Item Property Details list based on a defined criteria
     * 
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List itemPropertydetList(ItemPropertydetSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("itemPropertydetMapper.itemPropertydetList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "itemPropertydetMapper.itemPropertydetListMap");
	    return getSqlMap().queryForList("itemPropertydetMapper.itemPropertydetList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    public TRS_ITEM_PROPERTYDETVO returnItemPropertydetByCode(ItemPropertydetSC criteria) throws DAOException
    {

	return (TRS_ITEM_PROPERTYDETVO) getSqlMap().queryForObject("itemPropertydetMapper.returnItemPropertydetByCode",
		criteria);
    }
}
