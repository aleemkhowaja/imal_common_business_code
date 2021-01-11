package com.path.dao.core.profession.impl;

import java.util.List;

import com.path.dao.core.profession.ProfessionDAO;
import com.path.dbmaps.vo.CTS_PROFESSIONVO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.profession.ProfessionSC;

public class ProfessionDAOImpl extends BaseDAO implements ProfessionDAO
{

    @Override
    public List professionList(ProfessionSC professionSC) throws DAOException
    {
	if(professionSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("professionListMapper.professionList", professionSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(professionSC, getSqlMap(), "professionListMapper.professionList_ResMap");
	    return getSqlMap().queryForList("professionListMapper.professionList", professionSC,
		    professionSC.getRecToskip(), professionSC.getNbRec());
	}
    }

    public int professionListCount(ProfessionSC professionSC) throws DAOException
    {
	DAOHelper.fixGridMaps(professionSC, getSqlMap(), "professionListMapper.professionList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("professionListMapper.professionListCount", professionSC)).intValue();
	return nb;
    }

    public CTS_PROFESSIONVO returnDependencyByProfession(ProfessionSC professionSC) throws DAOException
    {
	return (CTS_PROFESSIONVO)getSqlMap().queryForObject("professionListMapper.returnDependencyByProfession", professionSC);
    }
}
