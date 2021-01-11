package com.path.dao.core.idtype.impl;

import java.util.List;

import com.path.dao.core.idtype.IdTypeDAO;
import com.path.dbmaps.vo.ID_TYPESVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.idtype.IdTypeSC;

public class IdTypeDAOImpl extends BaseDAO implements IdTypeDAO
{

    @SuppressWarnings("unchecked")
	@Override
    public List<IdTypeSC> idTypeList(IdTypeSC idTypeSC) throws DAOException
    {
	if(idTypeSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("idTypeMapper.idTypeList", idTypeSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(idTypeSC, getSqlMap(), "idTypeMapper.idTypeList_ResMap");
	    return getSqlMap().queryForList("idTypeMapper.idTypeList", idTypeSC, idTypeSC.getRecToskip(),
		    idTypeSC.getNbRec());
	}
    }

    @Override
    public int idTypeListCount(IdTypeSC idTypeSC) throws DAOException
    {
	DAOHelper.fixGridMaps(idTypeSC, getSqlMap(), "idTypeMapper.idTypeList_ResMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("idTypeMapper.idTypeListCount", idTypeSC)).intValue();
	return nb;
    }

	@Override
	public ID_TYPESVO returnIdTypeById(IdTypeSC idTypeSC) throws DAOException
	{
		return (ID_TYPESVO) getSqlMap().queryForObject("idTypeMapper.returnIdTypeById", idTypeSC);
	}

	@Override
	public List idTypeByCIFTypeList(IdTypeSC idTypeSC) throws DAOException
	{
		if(idTypeSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("idTypeMapper.idTypeListByCIFType", idTypeSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(idTypeSC, getSqlMap(), "ID_TYPES.BaseResultMap");
		    return getSqlMap().queryForList("idTypeMapper.idTypeListByCIFType", idTypeSC, idTypeSC.getRecToskip(),
			    idTypeSC.getNbRec());
		}
	}

	@Override
	public int idTypeByCIFTypeListCount(IdTypeSC idTypeSC) throws DAOException
	{
		DAOHelper.fixGridMaps(idTypeSC, getSqlMap(), "ID_TYPES.BaseResultMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("idTypeMapper.idTypeListByCIFTypeCount", idTypeSC)).intValue();
		return nb;
	}

}
