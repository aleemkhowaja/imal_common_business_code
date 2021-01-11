package com.path.dao.core.residencetypes;

import java.util.List;

import com.path.dbmaps.vo.RESIDENCE_TYPESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.residencetypes.ResidenceTypesSC;

public interface ResidenceTypesDAO
{
    public int residenceTypesListCount(ResidenceTypesSC criteria) throws DAOException;
    public List residenceTypesList(ResidenceTypesSC criteria) throws DAOException;
    public RESIDENCE_TYPESVO returnDependencyByCode(ResidenceTypesSC criteria) throws DAOException;
}
