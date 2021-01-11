package com.path.dao.core.iisitems;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.iisitems.ItemsCO;
import com.path.vo.core.iisitems.ItemsSC;

public interface ItemsDAO
{
    public List<ItemsCO> getItemsLookupDtls(ItemsSC itemsSC) throws DAOException;

    public Integer getItemsLookupCount(ItemsSC itemsSC) throws DAOException;

    /**
     * For AR-Rahnu Calulator
     * 
     * @param itemsSC
     * @return
     * @throws DAOException
     * @author sankar.remanan
     */
    public List<ItemsCO> getArRahnItemLookup(ItemsSC itemsSC) throws DAOException;

}
