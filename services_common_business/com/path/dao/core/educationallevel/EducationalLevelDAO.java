package com.path.dao.core.educationallevel;

import java.util.List;

import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public interface EducationalLevelDAO
{
    public List economicSectorList(EducationalLevelSC educationalLevelSC) throws DAOException;

    public int economicSectorListCount(EducationalLevelSC educationalLevelSC) throws DAOException;
    public EDUC_DEGREEVO educationLevelDependency(EducationalLevelSC educationalLevelSC) throws DAOException;

}
