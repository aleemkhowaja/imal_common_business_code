/**
 * 
 */
package com.path.dao.core.amfstatus.impl;

import java.util.List;

import com.path.dao.core.amfstatus.AmfStatusReasonDAO;
import com.path.dbmaps.vo.AMF_SUSPEND_REASONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.amfstatus.AmfStatusSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: raees
 *
 * AmfStatusReasonDAOImpl.java used to
 */
public class AmfStatusReasonDAOImpl extends BaseDAO implements AmfStatusReasonDAO
{

    @SuppressWarnings("unchecked")
    public List<AMF_SUSPEND_REASONVO> amfStatusReasonList(AmfStatusSC amfStatusSC) throws DAOException
    {
	if(amfStatusSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("amfStatusReasonMapper.amfStatusReasonsList", amfStatusSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(amfStatusSC, getSqlMap(), "amfStatusReasonMapper.amfStatusReasonsListMap");
	    return getSqlMap().queryForList("amfStatusReasonMapper.amfStatusReasonsList", amfStatusSC,
		    amfStatusSC.getRecToskip(), amfStatusSC.getNbRec());
	}
    }

    public int amfStatusReasonListCount(AmfStatusSC amfStatusSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap()
		.queryForObject("amfStatusReasonMapper.amfStatusReasonsListCount", amfStatusSC)).intValue();
	return nb;
    }

    public AMF_SUSPEND_REASONVO returnDependencyByCode(AmfStatusSC amfStatusSC) throws DAOException
    {
	return (AMF_SUSPEND_REASONVO)getSqlMap().queryForObject("amfStatusReasonMapper.returnDependencyByCode", amfStatusSC);
    }

}
