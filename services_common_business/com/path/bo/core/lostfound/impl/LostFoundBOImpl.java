/**
 * 
 */
package com.path.bo.core.lostfound.impl;

import java.util.List;

import com.path.bo.core.lostfound.LostFoundBO;
import com.path.dao.core.lostfound.LostFoundDAO;
import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.lostfound.LostFoundSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * LostFoundBOImpl.java used to
 */
public class LostFoundBOImpl extends BaseBO implements LostFoundBO
{
    
    private LostFoundDAO lostFoundDAO;
   
    @Override
    public int docTypeLookupCount(LostFoundSC lostFoundSC) throws BaseException
    {
	return lostFoundDAO.docTypeLookupCount(lostFoundSC);
    }

    @Override
    public List<CTS_LOSTDOCVO> docTypeLookupList(LostFoundSC lostFoundSC) throws BaseException
    {
	return lostFoundDAO.docTypeLookupList(lostFoundSC);
    }
    
    public void setLostFoundDAO(LostFoundDAO lostFoundDAO)
    {
        this.lostFoundDAO = lostFoundDAO;
    }
    
    public CTS_LOSTDOCVO getLostDocByCode(CTS_LOSTDOCVO ctsLostDocVO) throws BaseException
    {
	return (CTS_LOSTDOCVO)genericDAO.selectByPK(ctsLostDocVO);
    }
    
    
}
