/**
 * 
 */
package com.path.bo.core.lostfound;

import java.util.List;

import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.lostfound.LostFoundSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: nabilfeghali
 *
 * LostFoundBO.java used to
 */
public interface LostFoundBO
{
    public int docTypeLookupCount(LostFoundSC lostFoundSC) throws BaseException;
    public List<CTS_LOSTDOCVO> docTypeLookupList(LostFoundSC lostFoundSC) throws BaseException;
    public CTS_LOSTDOCVO getLostDocByCode(CTS_LOSTDOCVO ctsLostDocVO) throws BaseException;
}
