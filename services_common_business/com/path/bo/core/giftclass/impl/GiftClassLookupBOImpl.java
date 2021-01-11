package com.path.bo.core.giftclass.impl;

import java.util.List;

import com.path.bo.core.giftclass.GiftClassLookupBO;
import com.path.dao.core.giftclass.GiftClassLookupDAO;
import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.giftclass.GiftClassLookupSC;

/**
 * 
 * Copyright 2016, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 */
public class GiftClassLookupBOImpl extends BaseBO implements GiftClassLookupBO
{
    GiftClassLookupDAO giftClassLookupDAO;

    @Override
    public int returnGiftClassLookupCount(GiftClassLookupSC criteria) throws BaseException
    {
	return giftClassLookupDAO.returnGiftClassLookupCount(criteria);
    }

    @Override
    public List<CRM_PARAMVO> returnGiftClassLookup(GiftClassLookupSC criteria) throws BaseException
    {
	return giftClassLookupDAO.returnGiftClassLookupList(criteria);
    }
    
    public GiftClassLookupDAO getGiftClassLookupDAO()
    {
        return giftClassLookupDAO;
    }

    public void setGiftClassLookupDAO(GiftClassLookupDAO giftClassLookupDAO)
    {
        this.giftClassLookupDAO = giftClassLookupDAO;
    }
}
