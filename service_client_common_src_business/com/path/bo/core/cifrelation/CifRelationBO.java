package com.path.bo.core.cifrelation;

import java.util.List;

import com.path.dbmaps.vo.RELATION_BETWEEN_CIFSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cifrelation.CifRelationSC;

public interface CifRelationBO
{
    public int cifRelationListCount(CifRelationSC criteria) throws BaseException;

    public List cifRelationList(CifRelationSC criteria) throws BaseException;
    
    public RELATION_BETWEEN_CIFSVO returnCifRelationByCode(CifRelationSC criteria)throws BaseException;
}
