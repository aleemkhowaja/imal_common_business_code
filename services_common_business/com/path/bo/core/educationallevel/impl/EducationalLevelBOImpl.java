package com.path.bo.core.educationallevel.impl;

import java.util.List;

import com.path.bo.core.educationallevel.EducationalLevelBO;
import com.path.dao.core.educationallevel.EducationalLevelDAO;
import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public class EducationalLevelBOImpl extends BaseBO implements EducationalLevelBO
{

    private EducationalLevelDAO educationalLevelDAO;

    public EducationalLevelDAO getEducationalLevelDAO()
    {
	return educationalLevelDAO;
    }

    public void setEducationalLevelDAO(EducationalLevelDAO educationalLevelDAO)
    {
	this.educationalLevelDAO = educationalLevelDAO;
    }

    @Override
    public List educationalLevelList(EducationalLevelSC educationalLevelSC) throws BaseException
    {
	return educationalLevelDAO.economicSectorList(educationalLevelSC);
    }

    @Override
    public int educationalLevelListCount(EducationalLevelSC educationalLevelSC) throws BaseException
    {
	return educationalLevelDAO.economicSectorListCount(educationalLevelSC);
    }
    
    public EDUC_DEGREEVO educationLevelDependency(EducationalLevelSC educationalLevelSC) throws BaseException
    {
	return educationalLevelDAO.educationLevelDependency(educationalLevelSC);
    }

}
