package com.path.bo.core.iisitems.impl;

import java.util.List;

import com.path.bo.core.iisitems.ItemsBO;
import com.path.dao.core.iisitems.ItemsDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.iisitems.ItemsCO;
import com.path.vo.core.iisitems.ItemsSC;

public class ItemsBOImpl extends BaseBO implements ItemsBO
{
    private ItemsDAO itemsDAO;

    // Lookup Details
    public List<ItemsCO> getItemsLookupDtls(ItemsSC itemsSC) throws BaseException
    {
	return itemsDAO.getItemsLookupDtls(itemsSC);
    }

    public Integer getItemsLookupCount(ItemsSC itemsSC) throws BaseException
    {
	return itemsDAO.getItemsLookupCount(itemsSC);
    }

    public void setItemsDAO(ItemsDAO itemsDAO)
    {
	this.itemsDAO = itemsDAO;
    }

    public ItemsDAO getItemsDAO()
    {
	return itemsDAO;
    }

    @Override
    public List<ItemsCO> getArRahnItemLookup(ItemsSC itemsSC) throws BaseException
    {
	return itemsDAO.getArRahnItemLookup(itemsSC);

    }

}
