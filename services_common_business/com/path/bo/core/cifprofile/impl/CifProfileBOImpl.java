package com.path.bo.core.cifprofile.impl;

import java.util.List;

import com.path.bo.core.cifprofile.CifProfileBO;
import com.path.dao.core.cifprofile.CifProfileDAO;
import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifprofile.CifProfileSC;

public class CifProfileBOImpl extends BaseBO implements CifProfileBO
{

    private CifProfileDAO cifProfileDAO;

    public CifProfileDAO getCifProfileDAO()
    {
	return cifProfileDAO;
    }

    public void setCifProfileDAO(CifProfileDAO cifProfileDAO)
    {
	this.cifProfileDAO = cifProfileDAO;
    }

    @Override
    public List cifProfileList(CifProfileSC cifProfileSC) throws BaseException
    {
	return cifProfileDAO.cifProfileList(cifProfileSC);
    }

    @Override
    public int cifProfileListCount(CifProfileSC cifProfileSC) throws BaseException
    {
	return cifProfileDAO.cifProfileListCount(cifProfileSC);
    }

    @Override
    public CIF_PROFILEVO returnCifProfileByCode(CifProfileSC cifProfileSC) throws BaseException
    {
	return cifProfileDAO.returnCifProfileByCode(cifProfileSC);
    }

}
