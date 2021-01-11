package com.path.core.bo.blacklistmanagement;

import java.util.ArrayList;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.blacklistmanagement.BlackListLogCO;
import com.path.vo.core.blacklistmanagement.BlackListLogSC;
import com.path.vo.core.blacklistmanagement.BlackListNameMatchCO;
import com.path.vo.core.blacklistmanagement.BlackListReasonCO;
import com.path.vo.core.procedureid.ProcedureIdCO;

public interface BlackListLogBO
{
    
    Integer loadBlackListLogGridCount(BlackListLogSC blackListLogSC) throws BaseException;

    List<BlackListLogCO> loadBlackListLogGrid(BlackListLogSC blackListLogSC) throws BaseException;
    
    Integer loadBlackListReasonGridCount(BlackListLogSC blackListLogSC) throws BaseException;

    List<BlackListReasonCO> loadBlackListReasonPageGrid(BlackListLogSC blackListLogSC) throws BaseException;
    
    Integer loadBlackListNameMatchGridCount(BlackListLogSC blackListLogSC) throws BaseException;

    List<BlackListNameMatchCO> loadBlackListNameMatchPageGrid(BlackListLogSC blackListLogSC) throws BaseException;
    
    public void process(BlackListLogCO blackListLogCO) throws BaseException;

    
    
}
