package com.path.core.dao.blacklistmanagement.impl;

import java.math.BigDecimal;
import java.util.List;

import com.path.core.dao.blacklistmanagement.BlackListDAO;
import com.path.dbmaps.vo.MOSBLACKLISTVO;
import com.path.dbmaps.vo.MOSBLACKLIST_IDVOKey;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.cif.CifSC;

public class BlackListDAOImpl extends BaseDAO implements BlackListDAO
{

    @Override
    public int blackListMgmtCount(BlackListSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListMapper.blackListGridMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListMapper.blackListRecordCount", criteria)).intValue();
	return nb;
    }

    @Override
    public List blackListMgmtList(BlackListSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListMapper.blackListRecordList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListMapper.blackListGridMap");
	    return getSqlMap().queryForList("blackListMapper.blackListRecordList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public BlackListCO getBlackListDetails(BlackListSC criteria) throws DAOException
    {
	return (BlackListCO)getSqlMap().queryForObject("blackListMapper.getBlackListDetails",
		criteria);
    }

    public int returnCifRecordCountbyIdNo(CifSC cifSC) throws DAOException
    {
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListMapper.cifRecordCountbyIdNo", cifSC)).intValue();
	return nb;
    }

    @SuppressWarnings("unchecked")
    public List returnCifNobyIdNo(CifSC cifSC) throws DAOException
    {
	return getSqlMap().queryForList("blackListMapper.returnCifNobyIdNo", cifSC);
    }

    public int checkCIFisBlacklisted(CifSC cifSC) throws DAOException
    {
	int nb = 0;
	if(getSqlMap().queryForObject("blackListMapper.checkCIFisBlacklisted", cifSC) != null)
	{
	    nb = ((Integer) getSqlMap().queryForObject("blackListMapper.checkCIFisBlacklisted", cifSC)).intValue();
	}
	return nb;
    }

    @Override
    public List getBlackListIdsList(BlackListSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("blackListMapper.blackListIDsList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListMapper.blackListIDsGridMap");
	    return getSqlMap().queryForList("blackListMapper.blackListIDsList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int getBlackListIdsListCount(BlackListSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "blackListMapper.blackListIDsGridMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("blackListMapper.blackListIDsListCount", criteria)).intValue();
	return nb;
    }

  public int update(MOSBLACKLISTVO mosBlackListVO) throws DAOException
    {
	return (Integer) getSqlMap().update("MOSBLACKLIST.updateMOSBLACKLIST", mosBlackListVO);
    }

    public int updateCifBlackListForDelete(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().update("blackListMapper.updateCIF_DELETED_BLACKLISTED", cifSC);
    }

    public int updateCifApprovedBlackListStatus(BlackListSC blackListSC) throws DAOException
    {
	return (Integer) getSqlMap().update("blackListMapper.updateCifApprovedBlackListStatus", blackListSC);
    }

    public MOSBLACKLIST_TYPEVO blackListRevisionPeriod(BlackListSC criteria) throws DAOException
    {
	return (MOSBLACKLIST_TYPEVO) getSqlMap().queryForObject("blackListMapper.blackListRevisionPeriod", criteria);
    }

       public int updateCIF_BlackListed(CifSC cifSC) throws DAOException
    {
	return (Integer) getSqlMap().update("blackListMapper.updateCIF_BlackListed", cifSC);
    }
        
    public int insert_cifOnCifMosBlackListBasedOnCif(BlackListSC blackListSC) throws DAOException
    {
	return getSqlMap().update("blackListMapper.insert_cifOnCifMosBlackListBasedOnCif", blackListSC);
    }
    
    public int insert_cifOnCifMosBlackListBasedOnDocNo(BlackListSC blackListSC) throws DAOException
    {
	return getSqlMap().update("blackListMapper.insert_cifOnCifMosBlackListBasedOnDocNo", blackListSC);
    }
    
    public void updateToBeReversed(MOSBLACKLISTVO mosBlackListVO) throws DAOException
    {
	  getSqlMap().update("blackListMapper.updateToBeReversed", mosBlackListVO);
    }
    
    public void reverse(MOSBLACKLISTVO MosBlackListVO) throws DAOException
    {
	getSqlMap().update("blackListMapper.reverse", MosBlackListVO);
    }
   
    public void updateFillCifBlacklistMos(BlackListSC criteria) throws DAOException
    {
	getSqlMap().update("blackListMapper.updateFillCifBlacklistMos", criteria);
    }
   
    public void delete_MosBlacklistIds(BlackListSC criteria) throws DAOException
    {
	getSqlMap().update("blackListMapper.deleteMosBlackListIds", criteria);
    }
   
    public void insert_MosBlacklistIds(MOSBLACKLIST_IDVOKey criteria) throws DAOException
    {
	getSqlMap().update("MOSBLACKLIST_ID.insertMOSBLACKLIST_ID", criteria);
    }

    @Override
    public void updateSuspendBlacklistFMS(BlackListCO blackListCO) throws DAOException
    {
	getSqlMap().update("blackListMapper.updateSuspendBlacklist_FMSFACILITY", blackListCO);
	
    }
    
    @Override
    public void updateSuspendBlacklistCIF(BlackListCO blackListCO) throws DAOException
    {
	getSqlMap().update("blackListMapper.updateSuspendBlacklist_CIF", blackListCO);
	
    }
    
    public int deleteCifMosBlackList(MOSBLACKLISTVO mosBlackListVO) throws DAOException
    {
	return getSqlMap().delete("blackListMapper.deleteCifMosBlackList", mosBlackListVO);
    }
    
    //811848 - ABEI190173:
    public int deleteCifBlackList(MOSBLACKLISTVO mosBlackListVO) throws DAOException
    {
	return getSqlMap().delete("blackListMapper.deleteCifBlackList", mosBlackListVO);
    }
    
    @Override
    public void insertBlackListReason(BlackListSC blackListSC) throws DAOException
    {
	getSqlMap().update("blackListMapper.insertBlackListReason", blackListSC);
    }

    @Override
    public void updateBlackListReason(BlackListSC blackListSC) throws DAOException
    {
	getSqlMap().update("blackListMapper.updateBlackListReason", blackListSC);
    }

    @Override
    public BigDecimal selectBlackListReasonLineNo(BlackListSC blackListSC) throws DAOException
    {
	return (BigDecimal) getSqlMap().queryForObject("blackListMapper.selectBlackListReasonLineNo", blackListSC);
    }
}
