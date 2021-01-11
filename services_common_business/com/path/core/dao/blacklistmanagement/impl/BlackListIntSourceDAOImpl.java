package com.path.core.dao.blacklistmanagement.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.core.dao.blacklistmanagement.BlackListIntSourceDAO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public class BlackListIntSourceDAOImpl extends BaseDAO implements BlackListIntSourceDAO
{

    @Override
    public Integer getMatchedCIFListCount(BlackListIntSourceSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListIntSourceMapper.matchedCIFListMap");
	return (Integer) getSqlMap().queryForObject("blackListIntSourceMapper.getMatchedCIFListCount", criteria);
    }

    @Override
    public List<BlackListIntSourceCO> getMatchedCIFList(BlackListIntSourceSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListIntSourceMapper.matchedCIFListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListIntSourceMapper.getMatchedCIFList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("blackListIntSourceMapper.getMatchedCIFList", criteria,
		    criteria.getRecToskip(), criteria.getNbRec());
	}
    }

    @Override
    public Integer getWhiteListCount(BlackListIntSourceSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListIntSourceMapper.matchedCIFListMap");
	return (Integer) getSqlMap().queryForObject("blackListIntSourceMapper.getWhiteListCount", criteria);
    }

    @Override
    public List<BlackListIntSourceCO> getWhiteList(BlackListIntSourceSC criteria) throws BaseException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListIntSourceMapper.matchedCIFListMap");
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListIntSourceMapper.getWhiteList", criteria);
	}
	else
	{
	    return getSqlMap().queryForList("blackListIntSourceMapper.getWhiteList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public void switchCIFListStatus(BlackListIntSourceCO blackListIntSourceCO) throws BaseException
    {
	String[] checkedParam = blackListIntSourceCO.getCheckedList().split(",");
	for(String rowId : checkedParam)
	{
	    String[] params = rowId.split(";");
	    String CIF_NO = params[0];
	    BigDecimal COMP_CODE = new BigDecimal(params[1]);

	    blackListIntSourceCO.getCifVO().setCIF_NO((new BigDecimal(CIF_NO.trim())));
	    blackListIntSourceCO.getCifVO().setCOMP_CODE(COMP_CODE);

	    int updateCif = getSqlMap().update("blackListIntSourceMapper.switchCIFListStatus_update",
		    blackListIntSourceCO);
	    if(updateCif == 0)
	    {
		getSqlMap().insert("blackListIntSourceMapper.switchCIFListStatus_insert", blackListIntSourceCO);
	    }
	}
    }

    @Override
    public void callSoundexPrepare(BlackListIntSourceSC criteria) throws BaseException
    {
	getSqlMap().delete("blackListIntSourceMapper.callSoundexPrepare", criteria);
    }
    
    public Integer checkCIFBlackListed(BlackListIntSourceSC criteria) throws BaseException
    {
	return (Integer) getSqlMap().queryForObject("blackListIntSourceMapper.checkCIFBlackListed", criteria);
    }
    
    @Override
	public List<BlackListIntSourceCO> getDynFilesBlackListedList(BlackListIntSourceSC blackListIntSourceSC)
			throws BaseException {
		DAOHelper.fixGridMaps(blackListIntSourceSC, getSqlMap(), "blackListIntSourceMapper.dynFilesListUploadMap");
		if(blackListIntSourceSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("blackListIntSourceMapper.getDynFilesBlackListedList", blackListIntSourceSC);
		}
		else
		{
		    return getSqlMap().queryForList("blackListIntSourceMapper.getDynFilesBlackListedList", blackListIntSourceSC, blackListIntSourceSC.getRecToskip(),
		    		blackListIntSourceSC.getNbRec());
		}
	}

	@Override
	public Integer getDynFilesBlackListedListCount(BlackListIntSourceSC blackListIntSourceSC) throws BaseException {
		DAOHelper.fixGridMaps(blackListIntSourceSC, getSqlMap(), "blackListIntSourceMapper.dynFilesListUploadMap");
		return (Integer) getSqlMap().queryForObject("blackListIntSourceMapper.getDynFilesBlackListedListCount", blackListIntSourceSC);
	}

	@Override
	public BlackListIntSourceCO depLookupFileName(BlackListIntSourceSC blackListIntSourceSC) throws BaseException {
		return (BlackListIntSourceCO)getSqlMap().queryForObject("blackListIntSourceMapper.getBlackListDynFileDetails", blackListIntSourceSC);
	}

}
