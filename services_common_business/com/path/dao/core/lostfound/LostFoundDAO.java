/**
 * 
 */
package com.path.dao.core.lostfound;

import java.util.List;

import com.path.dbmaps.vo.CTS_LOSTDOCVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.lostfound.LostFoundSC;

/**
 * Copyright 2012, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: nabilfeghali
 * 
 *          LostFoundDAO.java used to
 */
public interface LostFoundDAO
{
    public int docTypeLookupCount(LostFoundSC lostFoundSC) throws DAOException;

    public List<CTS_LOSTDOCVO> docTypeLookupList(LostFoundSC lostFoundSC) throws DAOException;
}
