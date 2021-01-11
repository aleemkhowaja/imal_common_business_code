package com.path.core.dao.blacklistmanagement;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public interface BlackListIntSourceDAO
{

    List<BlackListIntSourceCO> getMatchedCIFList(BlackListIntSourceSC criteria) throws BaseException;

    Integer getMatchedCIFListCount(BlackListIntSourceSC criteria) throws BaseException;

    List<BlackListIntSourceCO> getWhiteList(BlackListIntSourceSC criteria) throws BaseException;

    Integer getWhiteListCount(BlackListIntSourceSC criteria) throws BaseException;

    void switchCIFListStatus(BlackListIntSourceCO blackListIntSourceCO) throws BaseException;

    void callSoundexPrepare(BlackListIntSourceSC criteria) throws BaseException;
    
    Integer checkCIFBlackListed(BlackListIntSourceSC criteria) throws BaseException;
    
  //added by bilal for TP#885556
    List<BlackListIntSourceCO> getDynFilesBlackListedList(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;

    Integer getDynFilesBlackListedListCount(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;
    
    BlackListIntSourceCO depLookupFileName(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;
}
