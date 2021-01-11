package com.path.dao.core.professioncategory.impl;

import java.util.List;

import com.path.dao.core.professioncategory.ProfessionCategoryDAO;
import com.path.dbmaps.vo.CTS_PROFESSION_CATEGORYVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.economicagent.EconomicAgentSC;
import com.path.vo.core.professioncategory.ProfessionCategorySC;

public class ProfessionCategoryDAOImpl extends BaseDAO implements ProfessionCategoryDAO
{

    @Override
    public List professionCategoryList(ProfessionCategorySC professionCategorySC) throws DAOException
    {
	if(professionCategorySC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("professionCategoryListMapper.professionCategoryList", professionCategorySC);
	}
	else
	{
	    DAOHelper.fixGridMaps(professionCategorySC, getSqlMap(), "professionCategoryListMapper.professionCategoryList_ResMap");
	    return getSqlMap().queryForList("professionCategoryListMapper.professionCategoryList", professionCategorySC,
		    professionCategorySC.getRecToskip(), professionCategorySC.getNbRec());
	}
    }

    public int professionCategoryListCount(ProfessionCategorySC professionCategorySC) throws DAOException
    {
	DAOHelper.fixGridMaps(professionCategorySC, getSqlMap(), "professionCategoryListMapper.professionCategoryList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("professionCategoryListMapper.professionCategoryListCount", professionCategorySC)).intValue();
	return nb;
    }

    public CTS_PROFESSION_CATEGORYVO returnDependencyByProfessionCategory(ProfessionCategorySC professionCategorySC) throws DAOException
    {
	return (CTS_PROFESSION_CATEGORYVO)getSqlMap().queryForObject("professionCategoryListMapper.returnDependencyByProfessionCategory", professionCategorySC);
    }
}
