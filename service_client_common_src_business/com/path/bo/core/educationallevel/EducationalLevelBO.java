package com.path.bo.core.educationallevel;

import java.util.List;

import com.path.dbmaps.vo.EDUC_DEGREEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.educationallevel.EducationalLevelSC;

public interface EducationalLevelBO
{
    public int educationalLevelListCount(EducationalLevelSC educationalLevelSC) throws BaseException;

    public List educationalLevelList(EducationalLevelSC educationalLevelSC) throws BaseException;
    public EDUC_DEGREEVO educationLevelDependency(EducationalLevelSC educationalLevelSC) throws BaseException;

}
