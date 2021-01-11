package com.path.bo.core.relation;

import java.util.List;

import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.relation.RelationSC;

public interface RelationBO
{
    public int relationListCount(RelationSC relationSC) throws BaseException;

    public List relationList(RelationSC relationSC) throws BaseException;

    public RELATIONVO returnRelationByCode(RelationSC relationSC) throws BaseException;
}
