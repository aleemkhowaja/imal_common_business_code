package com.path.dao.core.cifprofile.impl;

import java.util.List;

import com.path.dao.core.cifprofile.CifProfileDAO;
import com.path.dbmaps.vo.CIF_PROFILEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cifprofile.CifProfileSC;

public class CifProfileDAOImpl extends BaseDAO implements CifProfileDAO
{

    @Override
    public List cifProfileList(CifProfileSC cifProfileSC) throws DAOException
    {
	if(cifProfileSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifProfileMapper.cifProfileList", cifProfileSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(cifProfileSC, getSqlMap(), "cifProfileMapper.cifProfileList_ResMap");
	    return getSqlMap().queryForList("cifProfileMapper.cifProfileList", cifProfileSC,
		    cifProfileSC.getRecToskip(), cifProfileSC.getNbRec());
	}
    }

    @Override
    public int cifProfileListCount(CifProfileSC cifProfileSC) throws DAOException
    {
	DAOHelper.fixGridMaps(cifProfileSC, getSqlMap(), "cifProfileMapper.cifProfileList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifProfileMapper.cifProfileListCount", cifProfileSC)).intValue();
	return nb;
    }

    @Override
    public CIF_PROFILEVO returnCifProfileByCode(CifProfileSC cifProfileSC) throws DAOException
    {
	return (CIF_PROFILEVO) getSqlMap().queryForObject("cifProfileMapper.returnCifProfileById", cifProfileSC);
    }

}
