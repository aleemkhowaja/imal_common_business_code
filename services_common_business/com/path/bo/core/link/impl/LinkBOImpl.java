/**
 * 
 */
package com.path.bo.core.link.impl;

import java.util.List;

import com.path.bo.core.link.LinkBO;
import com.path.dao.core.link.LinkDAO;
import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.link.LinkSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkBOImpl.java used to
 */
public class LinkBOImpl extends BaseBO implements LinkBO
{
    private LinkDAO linkDAO;
    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public List linkCodeLkpRecords(LinkSC criteria) throws BaseException
    {
	return linkDAO.linkCodeLkpRecords(criteria);
    }

    /**
     * 
     * @param criteria
     * @return
     * @throws BaseException
     */
    public int linkCodeLkpCount(LinkSC criteria) throws BaseException
    {
	return linkDAO.linkCodeLkpCount(criteria);
    }

    public LinkDAO getLinkDAO()
    {
        return linkDAO;
    }

    public void setLinkDAO(LinkDAO linkDAO)
    {
        this.linkDAO = linkDAO;
    }


    public S_LINKVO loadLinkByPk(S_LINKVO sLinkVO) throws BaseException
    {
	return (S_LINKVO)genericDAO.selectByPK(sLinkVO);
    }

}
