package com.path.dao.core.iisitems.impl;

import java.util.List;

import com.path.dao.core.iisitems.ItemsDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.iisitems.ItemsCO;
import com.path.vo.core.iisitems.ItemsSC;

public class ItemsDAOImpl extends BaseDAO implements ItemsDAO
{

    public List<ItemsCO> getItemsLookupDtls(ItemsSC itemsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(itemsSC, getSqlMap(), "itemsMapper.resultItemsLookupMap");
	if(itemsSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("itemsMapper.selectItemsLookupList", itemsSC);
	}
	else
	{
	    return getSqlMap().queryForList("itemsMapper.selectItemsLookupList", itemsSC,
		    itemsSC.getRecToskip(), itemsSC.getNbRec());
	}
    }

    @Override
    public Integer getItemsLookupCount(ItemsSC itemsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(itemsSC, getSqlMap(), "itemsMapper.resultItemsLookupMap");
	return (Integer) getSqlMap().queryForObject("itemsMapper.selectItemsLookupCount", itemsSC);
    }

    @Override
    public List<ItemsCO> getArRahnItemLookup(ItemsSC itemsSC) throws DAOException
    {
	DAOHelper.fixGridMaps(itemsSC, getSqlMap(), "itemsMapper.resultArRahnItemsLookupMap");
	if(itemsSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("itemsMapper.selectArRahnItemsLookupList", itemsSC);
	}
	else
	{
	    return getSqlMap().queryForList("itemsMapper.selectArRahnItemsLookupList", itemsSC, itemsSC.getRecToskip(),
		    itemsSC.getNbRec());
	}
    }

}
