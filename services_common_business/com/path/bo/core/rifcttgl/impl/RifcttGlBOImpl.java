package com.path.bo.core.rifcttgl.impl;

import java.util.List;

import com.path.bo.core.rifcttgl.RifcttGlBO;
import com.path.dao.core.rifcttgl.RifcttGlDAO;
import com.path.dbmaps.vo.RIFCTT_GLVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.rifcttgl.RifcttGlSC;

public class RifcttGlBOImpl extends BaseBO implements RifcttGlBO
{
    private RifcttGlDAO rifcttGlDAO;

    @Override
    public List accountList(RifcttGlSC criteria) throws BaseException
    {
	return rifcttGlDAO.accountList(criteria);
    }

    @Override
    public int accountListCount(RifcttGlSC criteria) throws BaseException
    {
	return rifcttGlDAO.accountListCount(criteria);
    }

    public RifcttGlDAO getRifcttGlDAO()
    {
	return rifcttGlDAO;
    }

    public void setRifcttGlDAO(RifcttGlDAO rifcttGlDAO)
    {
	this.rifcttGlDAO = rifcttGlDAO;
    }

    @Override
    public RIFCTT_GLVO returnRifcttGlById(RifcttGlSC criteria) throws BaseException
    {
	return (RIFCTT_GLVO) rifcttGlDAO.returnRifcttGlById(criteria);
    }

    @Override
    public int getRifMessageByCompLkpCount(RifcttGlSC criteria) throws BaseException
    {
	return rifcttGlDAO.getRifMessageByCompLkpCount(criteria);
    }

    @Override
    public List getRifMessageByCompLkpList(RifcttGlSC criteria) throws BaseException
    {
	return rifcttGlDAO.getRifMessageByCompLkpList(criteria);
    }

}
