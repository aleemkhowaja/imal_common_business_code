package com.path.core.dao.blacklistmanagement.impl;

import java.util.List;

import com.path.core.dao.blacklistmanagement.BlackListLogDAO;
import com.path.dbmaps.vo.CTS_BLACKLIST_LOGVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.blacklistmanagement.BlackListLogCO;
import com.path.vo.core.blacklistmanagement.BlackListLogSC;
import com.path.vo.core.blacklistmanagement.BlackListNameMatchCO;
import com.path.vo.core.blacklistmanagement.BlackListReasonCO;

public class BlackListLogDAOImpl extends BaseDAO implements BlackListLogDAO
{


    public Integer loadBlackListLogGridCount(BlackListLogSC blackListLogSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(blackListLogSC.getSidx()).isEmpty())
	{
	    blackListLogSC.setSidx("ENTITY_NO");
	    blackListLogSC.setSord("DESC");
	}
	
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListLogGridMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListLogMapper.loadBlackListLogGridCount",
		blackListLogSC)).intValue();
	return nb;
    }


    public List<BlackListLogCO> loadBlackListLogGrid(BlackListLogSC blackListLogSC) throws DAOException
    {
	if(StringUtil.nullToEmpty(blackListLogSC.getSidx()).isEmpty())
	{
	    blackListLogSC.setSidx("ENTITY_NO");
	    blackListLogSC.setSord("DESC");
	}
	
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListLogGridMap");
	if(blackListLogSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListLogGrid", blackListLogSC);
	}
	else
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListLogGrid", blackListLogSC,
		    blackListLogSC.getRecToskip(), blackListLogSC.getNbRec());
	}
    }


    public Integer loadBlackListReasonGridCount(BlackListLogSC blackListLogSC) throws DAOException
    {
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListReasonGridMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListLogMapper.loadBlackListReasonGridCount",
		blackListLogSC)).intValue();
	return nb;
    }


    public List<BlackListReasonCO> loadBlackListReasonPageGrid(BlackListLogSC blackListLogSC) throws DAOException
    {
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListReasonGridMap");
	if(blackListLogSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListReasonPageGrid", blackListLogSC);
	}
	else
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListReasonPageGrid", blackListLogSC,
		    blackListLogSC.getRecToskip(), blackListLogSC.getNbRec());
	}
    }


    public Integer loadBlackListNameMatchGridCount(BlackListLogSC blackListLogSC) throws DAOException
    {
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListNameMatchGridMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListLogMapper.loadBlackListNameMatchGridCount",
		blackListLogSC)).intValue();
	return nb;
    }


    public List<BlackListNameMatchCO> loadBlackListNameMatchPageGrid(BlackListLogSC blackListLogSC) throws DAOException
    {
	DAOHelper.fixGridMaps(blackListLogSC, getSqlMap(), "blackListLogMapper.loadBlackListNameMatchGridMap");
	if(blackListLogSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListNameMatchPageGrid", blackListLogSC);
	}
	else
	{
	    return getSqlMap().queryForList("blackListLogMapper.loadBlackListNameMatchPageGrid", blackListLogSC,
		    blackListLogSC.getRecToskip(), blackListLogSC.getNbRec());
	}
    }


    public void updateBlackListLog(CTS_BLACKLIST_LOGVO ctsBlackListLogVO) throws DAOException
    {
	getSqlMap().update("blackListLogMapper.updateBlackListLog",ctsBlackListLogVO);
	
    }


    @Override
    public S_TODO_DETVO returnSTODOVOData(BlackListLogCO blackListLogCO) throws DAOException
    {
	return (S_TODO_DETVO) getSqlMap().queryForObject("blackListLogMapper.returnSTODOVOData", blackListLogCO);
    }


    public void updateBlckListTrxStatus(BlackListLogCO blackListLogCO) throws DAOException
    {
	getSqlMap().update("blackListLogMapper.updateBlckListTrxStatus",blackListLogCO);
	
    }


    public void updateBlckListCIFStatus(BlackListLogCO blackListLogCO) throws DAOException
    {
	getSqlMap().update("blackListLogMapper.updateBlckListCIFStatus",blackListLogCO);
	
    }
    
    
    

}
