package com.path.bo.core.cifrelation.impl;

import java.util.List;

import com.path.bo.core.cifrelation.CifRelationBO;
import com.path.dao.core.cifrelation.CifRelationDAO;
import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrelation.CifRelationSC;

public class CifRelationBOImpl extends BaseBO implements CifRelationBO
{

    private CifRelationDAO cifRelationDAO;

    @Override
    public List cifRelationList(CifRelationSC criteria) throws BaseException
    {
	return cifRelationDAO.cifRelationList(criteria);
    }

    @Override
    public int cifRelationListCount(CifRelationSC criteria) throws BaseException
    {
	return cifRelationDAO.cifRelationListCount(criteria);
    }

    @Override
    public RELATION_BETWEEN_CIFSVO returnCifRelationByCode(CifRelationSC criteria) throws BaseException
    {
	return cifRelationDAO.returnCifRelationByCode(criteria);
    }

    public CifRelationDAO getCifRelationDAO()
    {
	return cifRelationDAO;
    }

    public void setCifRelationDAO(CifRelationDAO cifRelationDAO)
    {
	this.cifRelationDAO = cifRelationDAO;
    }

}
