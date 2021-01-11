package com.path.bo.core.relation.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.relation.RelationBO;
import com.path.dao.core.relation.RelationDAO;
import com.path.dbmaps.vo.RELATIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.relation.RelationSC;

public class RelationBOImpl extends BaseBO implements RelationBO
{

    private RelationDAO relationDAO;

    public RelationDAO getRelationDAO()
    {
	return relationDAO;
    }

    public void setRelationDAO(RelationDAO relationDAO)
    {
	this.relationDAO = relationDAO;
    }

    @Override
    public List relationList(RelationSC relationSC) throws BaseException
    {
	return relationDAO.relationList(relationSC);
    }

    @Override
    public int relationListCount(RelationSC relationSC) throws BaseException
    {
	return relationDAO.relationListCount(relationSC);
    }

    @Override
    public RELATIONVO returnRelationByCode(RelationSC relationSC) throws BaseException
    {
	RELATIONVO relationVO = relationDAO.returnRelationByCode(relationSC);
	if(relationVO == null)
	{
	    //throw new BOException(MessageCodes.INVALID_CODE);
	    throw new BOException(MessageCodes.INVALID_PARAM, new String[] { "Relation_key" });
	}
	return relationVO;
    }

}