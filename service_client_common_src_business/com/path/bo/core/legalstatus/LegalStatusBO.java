package com.path.bo.core.legalstatus;

import java.util.List;

import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.legalstatus.LegalStatusSC;

public interface LegalStatusBO
{
    public int legalStatusListCount(LegalStatusSC legalStatusSC) throws BaseException;

    public List legalStatusList(LegalStatusSC legalStatusSC) throws BaseException;
    
    public LEGAL_STATUSVO returnDependencyByStatusCode(LegalStatusSC legalStatusSC) throws BaseException;
    
    

}
