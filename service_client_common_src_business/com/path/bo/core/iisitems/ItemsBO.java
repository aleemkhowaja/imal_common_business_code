package com.path.bo.core.iisitems;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.iisitems.ItemsCO;
import com.path.vo.core.iisitems.ItemsSC;

public interface ItemsBO
{
    // Lookup Calls
    public List<ItemsCO> getItemsLookupDtls(ItemsSC itemsSC) throws BaseException;

    /**
     * For AR- Rahnu Calulator
     * 
     * @param itemsSC
     * @return
     * @throws BaseException
     * @author sankar.remanan
     */
    public List<ItemsCO> getArRahnItemLookup(ItemsSC itemsSC) throws BaseException;

    public Integer getItemsLookupCount(ItemsSC itemsSC) throws BaseException;

}
