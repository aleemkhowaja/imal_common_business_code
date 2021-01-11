/**
 * 
 */
package com.path.bo.core.link;

import java.util.List;

import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.link.LinkSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkBO.java used to
 */
public interface LinkBO
{
    public List linkCodeLkpRecords(LinkSC criteria) throws BaseException;
    public int linkCodeLkpCount(LinkSC criteria) throws BaseException;
    public S_LINKVO loadLinkByPk(S_LINKVO sLinkVO) throws BaseException;
}
