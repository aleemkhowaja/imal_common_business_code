/**
 * 
 */
package com.path.dao.common.global360view.others.impl;

import java.util.List;

import com.path.dao.common.global360view.others.DashOthersDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.global360view.DashOthersCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: elieachkar
 *
 * DashOthersDAOImpl.java used to
 */
public class DashOthersDAOImpl extends BaseDAO implements DashOthersDAO
{
    public int remittancesListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.remittancesListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.remittancesListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> remittancesList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.remittancesListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.remittancesList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.remittancesList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int specialCondAccListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.specialCondListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.specialCondAccListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> specialCondAccList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.specialCondListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.specialCondAccList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.specialCondAccList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int specialCondCifListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.specialCondListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.specialCondCifListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> specialCondCifList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.specialCondListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.specialCondCifList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.specialCondCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int authorizedSigListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.authorizedSigListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.authorizedSigListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> authorizedSigList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.authorizedSigListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.authorizedSigList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.authorizedSigList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int linksCifCifListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.linksCifCifListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> linksCifCifList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksCifCifList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksCifCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int linksAccAccListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.linksAccAccListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> linksAccAccList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksAccAccList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksAccAccList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int linksAccCifListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.linksAccCifListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> linksAccCifList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksAccCifList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksAccCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int linksCifAccListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.linksCifAccListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> linksCifAccList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.linksListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksCifAccList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.linksCifAccList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int soListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.soListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.soListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> soList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.soListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.soList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.soList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public int memosListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.memosListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.memosListCount", criteria)).intValue();
	return nb;
    }

    public List<DashOthersCO> memosList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.memosListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.memosList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.memosList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
    
    public DashOthersCO returnLinksExistanceQueryList(DashboardSC criteria) throws BaseException
    {
	return (DashOthersCO) getSqlMap().queryForObject("dashOthersMapper.returnLinksExistanceQueryList", criteria);
    }
    
    @Override
    public int childCifListCount(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.childCifListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("dashOthersMapper.childCifListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public List<DashOthersCO> childCifList(DashboardSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "dashOthersMapper.childCifListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("dashOthersMapper.childCifList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("dashOthersMapper.childCifList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

}
