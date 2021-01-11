package com.path.dao.core.educationallevel.impl;

import java.util.List;

import com.path.dao.core.educationallevel.EducationalLevelDAO;
import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public class EducationalLevelDAOImpl extends BaseDAO implements EducationalLevelDAO
{

    @Override
    public List economicSectorList(EducationalLevelSC educationalLevelSC) throws DAOException
    {
	if(educationalLevelSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("educationalLevelMapper.educationalLevelList", educationalLevelSC);
	}
	else
	{
	    DAOHelper
		    .fixGridMaps(educationalLevelSC, getSqlMap(), "educationalLevelMapper.educationalLevelList_ResMap");
	    return getSqlMap().queryForList("educationalLevelMapper.educationalLevelList", educationalLevelSC,
		    educationalLevelSC.getRecToskip(), educationalLevelSC.getNbRec());
	}
    }

    @Override
    public int economicSectorListCount(EducationalLevelSC educationalLevelSC) throws DAOException
    {
	DAOHelper.fixGridMaps(educationalLevelSC, getSqlMap(), "educationalLevelMapper.educationalLevelList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("educationalLevelMapper.educationalLevelListCount",
		educationalLevelSC)).intValue();
	return nb;
    }

	public EDUC_DEGREEVO educationLevelDependency(EducationalLevelSC educationalLevelSC) throws DAOException
    {
	return (EDUC_DEGREEVO) getSqlMap().queryForObject("educationalLevelMapper.educationalLevelDependency", educationalLevelSC);
    }
}
