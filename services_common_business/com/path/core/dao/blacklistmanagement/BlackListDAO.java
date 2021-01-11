
package com.path.core.dao.blacklistmanagement;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.MOSBLACKLISTVO;
import com.path.dbmaps.vo.MOSBLACKLIST_IDVOKey;
import com.path.dbmaps.vo.MOSBLACKLIST_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;
import com.path.vo.core.cif.CifSC;

public interface BlackListDAO
{
    public int blackListMgmtCount(BlackListSC criteria) throws DAOException;

    public List blackListMgmtList(BlackListSC criteria) throws DAOException;

    public BlackListCO getBlackListDetails(BlackListSC criteria) throws DAOException;

    public List getBlackListIdsList(BlackListSC criteria) throws DAOException;

    public int getBlackListIdsListCount(BlackListSC criteria) throws DAOException;

    public int returnCifRecordCountbyIdNo(CifSC cifSC) throws DAOException;

    public List returnCifNobyIdNo(CifSC cifSC) throws DAOException;

    public int checkCIFisBlacklisted(CifSC cifSC) throws DAOException;

    public int update(MOSBLACKLISTVO mosBlackListVO) throws DAOException;

    public int updateCifBlackListForDelete(CifSC cifSC) throws DAOException;

    public int updateCifApprovedBlackListStatus(BlackListSC blackListSC) throws DAOException;

    public int updateCIF_BlackListed(CifSC cifSC) throws DAOException;

    public MOSBLACKLIST_TYPEVO blackListRevisionPeriod(BlackListSC criteria) throws DAOException;

    public int insert_cifOnCifMosBlackListBasedOnDocNo(BlackListSC blackListSC) throws DAOException;

    public int insert_cifOnCifMosBlackListBasedOnCif(BlackListSC blackListSC) throws DAOException;

    public void updateToBeReversed(MOSBLACKLISTVO mosBlackListVO) throws DAOException;

    public void reverse(MOSBLACKLISTVO MosBlackListVO) throws DAOException;

    public void updateFillCifBlacklistMos(BlackListSC criteria) throws DAOException;

    public void delete_MosBlacklistIds(BlackListSC criteria) throws DAOException;

    public void insert_MosBlacklistIds(MOSBLACKLIST_IDVOKey criteria) throws DAOException;

    public void updateSuspendBlacklistFMS(BlackListCO blackListCO) throws DAOException;
    public void updateSuspendBlacklistCIF(BlackListCO blackListCO) throws DAOException;
    
    public int deleteCifMosBlackList(MOSBLACKLISTVO mosBlackListVO) throws DAOException;
    
    public int deleteCifBlackList(MOSBLACKLISTVO mosBlackListVO) throws DAOException;
    public void insertBlackListReason(BlackListSC blackListSC) throws DAOException;
    public void updateBlackListReason(BlackListSC blackListSC) throws DAOException;
    public BigDecimal selectBlackListReasonLineNo(BlackListSC blackListSC) throws DAOException;
}
