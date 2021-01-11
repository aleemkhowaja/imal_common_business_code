package com.path.dao.core.legalstatus;

import java.util.List;

import com.path.dbmaps.vo.LEGAL_STATUSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.legalstatus.LegalStatusSC;

public interface LegalStatusDAO
{
    public List legalStatusList(LegalStatusSC legalStatusSC) throws DAOException;
    public int legalStatusListCount(LegalStatusSC legalStatusSC) throws DAOException;
    public LEGAL_STATUSVO returnDependencyByStatusCode(LegalStatusSC legalStatusSC) throws DAOException;
}
