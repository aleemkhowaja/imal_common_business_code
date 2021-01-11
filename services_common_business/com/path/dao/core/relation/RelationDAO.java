package com.path.dao.core.relation;

import java.util.List;

import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.relation.RelationSC;

public interface RelationDAO
{
    public int relationListCount(RelationSC relationSC) throws DAOException;

    public List relationList(RelationSC relationSC) throws DAOException;
    
    public RELATIONVO returnRelationByCode(RelationSC relationSC) throws DAOException;
}
