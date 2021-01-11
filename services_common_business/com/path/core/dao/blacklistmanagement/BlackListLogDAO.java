package com.path.core.dao.blacklistmanagement;

import java.util.List;

import com.path.dbmaps.vo.CTS_BLACKLIST_LOGVO;
import com.path.dbmaps.vo.S_TODO_DETVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.blacklistmanagement.BlackListLogCO;
import com.path.vo.core.blacklistmanagement.BlackListLogSC;
import com.path.vo.core.blacklistmanagement.BlackListNameMatchCO;
import com.path.vo.core.blacklistmanagement.BlackListReasonCO;

public interface BlackListLogDAO
{

    
    Integer loadBlackListLogGridCount(BlackListLogSC blackListLogSC) throws DAOException;
    
    List<BlackListLogCO> loadBlackListLogGrid(BlackListLogSC blackListLogSC) throws DAOException;
    
    Integer loadBlackListReasonGridCount(BlackListLogSC blackListLogSC) throws DAOException;
    
    List<BlackListReasonCO> loadBlackListReasonPageGrid(BlackListLogSC blackListLogSC) throws DAOException;
    
    Integer loadBlackListNameMatchGridCount(BlackListLogSC blackListLogSC) throws DAOException;
    
    List<BlackListNameMatchCO> loadBlackListNameMatchPageGrid(BlackListLogSC blackListLogSC) throws DAOException;

    public void updateBlackListLog(CTS_BLACKLIST_LOGVO ctsBlackListLogVO)throws DAOException;
    
    public S_TODO_DETVO returnSTODOVOData (BlackListLogCO blackListLogCO)throws DAOException;

    public void updateBlckListTrxStatus(BlackListLogCO blackListLogCO) throws DAOException;

    public void updateBlckListCIFStatus(BlackListLogCO blackListLogCO) throws DAOException;

    
}
