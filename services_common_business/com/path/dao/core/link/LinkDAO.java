/**
 * 
 */
package com.path.dao.core.link;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.link.LinkSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkDAO.java used to define the interface of AMF-CIF links Management
 */
public interface LinkDAO
{
    public int linkCodeLkpCount(LinkSC criteria) throws DAOException;
    public List linkCodeLkpRecords(LinkSC criteria) throws DAOException;
}
