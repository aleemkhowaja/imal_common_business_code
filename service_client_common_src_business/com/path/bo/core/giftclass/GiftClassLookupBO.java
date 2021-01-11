package com.path.bo.core.giftclass;

import java.util.List;

import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.giftclass.GiftClassLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public interface GiftClassLookupBO
{
    public int returnGiftClassLookupCount(GiftClassLookupSC criteria) throws BaseException;

    public List<CRM_PARAMVO> returnGiftClassLookup(GiftClassLookupSC criteria) throws BaseException;
}