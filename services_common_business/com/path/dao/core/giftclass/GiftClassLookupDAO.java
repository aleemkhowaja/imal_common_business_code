package com.path.dao.core.giftclass;

import java.util.List;

import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.giftclass.GiftClassLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public interface GiftClassLookupDAO
{
    public int returnGiftClassLookupCount(GiftClassLookupSC criteria) throws DAOException;

    public List<CRM_PARAMVO> returnGiftClassLookupList(GiftClassLookupSC criteria) throws DAOException;

}