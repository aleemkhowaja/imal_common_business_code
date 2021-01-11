package com.path.dao.core.idtype;

import java.util.List;

import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.idtype.IdTypeSC;

public interface IdTypeDAO
{
    public List<IdTypeSC> idTypeList(IdTypeSC idTypeSC) throws DAOException;

    public int idTypeListCount(IdTypeSC idTypeSC) throws DAOException;

    public ID_TYPESVO returnIdTypeById(IdTypeSC idTypeSC) throws DAOException;

    public int idTypeByCIFTypeListCount(IdTypeSC idTypeSC) throws DAOException;

    public List idTypeByCIFTypeList(IdTypeSC idTypeSC) throws DAOException;

}
