package com.path.core.bo.blacklistmanagement;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.AlertsParamCO;
import com.path.vo.core.blacklistmanagement.BlackListCO;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public interface BlackListBO
{
    public int blackListMgmtCount(BlackListSC criteria) throws BaseException;

    public List blackListMgmtList(BlackListSC criteria) throws BaseException;

    public BlackListCO getBlackListDetails(BlackListSC criteria) throws BaseException;

    public List getBlackListIdsList(BlackListSC criteria) throws BaseException;

    public int getBlackListIdsListCount(BlackListSC criteria) throws BaseException;

    public BlackListCO validateBlackListCode(BlackListCO blackListCO) throws BaseException;

    public BlackListCO getBlackListetailsbyDocNo(BlackListCO blackListCO) throws BaseException;

    public BlackListCO validateAndReturnBirthDate(BlackListCO blackListCO) throws BaseException;

    public BlackListCO validateAndReturnSourceDate(BlackListCO blackListCO) throws BaseException;

    public BlackListCO validateAndReturnRevisionDate(BlackListCO blackListCO) throws BaseException;

    public BlackListCO validateAndReturnIssueDate(BlackListCO blackListCO) throws BaseException;

    public BlackListCO returnBlackListTypeData(BlackListCO blackListCO) throws BaseException;

    public BlackListCO saveBlackList(BlackListCO blackListCO) throws BaseException;

    public BlackListCO delete(BlackListCO blackListCO) throws BaseException;

    public BlackListCO toBeReversed(BlackListCO blackListCO) throws BaseException;

    public BlackListCO approve(BlackListCO blackListCO) throws BaseException;

    public BlackListCO reverse(BlackListCO blackListCO) throws BaseException;

    public BlackListCO submitData(BlackListCO blackListCO, String operationType) throws BaseException;

    public BlackListCO rejectBlackList(BlackListCO blackListCO) throws BaseException;

    public CTSTELLERVO returnCtsTellerDetails(CTSTELLERVO ctsTellerVO) throws BaseException;

    public BlackListCO dependencyByCIFNo(BlackListCO blackListCO) throws BaseException;

    public AlertsParamCO returnAlertsParamCO(BlackListCO blackListCO) throws BaseException;
    
    public BlackListCO checkBlackListRestriction(BlackListSC blackListSC) throws BaseException;
    
    public void updateBlackListReason(BlackListSC blackListSC) throws BaseException;
    
    public BigDecimal selectBlackListReasonLineNo(BlackListSC blackListSC) throws BaseException;

}
