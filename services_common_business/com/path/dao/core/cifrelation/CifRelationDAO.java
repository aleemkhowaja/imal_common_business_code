package com.path.dao.core.cifrelation;

import java.util.List;

import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifrelation.CifRelationSC;

public interface CifRelationDAO
{
	public int cifRelationListCount(CifRelationSC criteria) throws DAOException;

    public List cifRelationList(CifRelationSC criteria) throws DAOException;
    
    public RELATION_BETWEEN_CIFSVO returnCifRelationByCode(CifRelationSC criteria)throws DAOException;
}
