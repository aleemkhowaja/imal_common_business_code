package com.path.bo.core.residencetypes;

import java.util.List;

import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

public interface ResidenceTypesBO
{
    public int residenceTypesListCount(ResidenceTypesSC criteria) throws BaseException;
    public List residenceTypesList(ResidenceTypesSC criteria) throws BaseException;
    public RESIDENCE_TYPESVO returnDependencyByCode(ResidenceTypesSC criteria) throws BaseException;
  
}
