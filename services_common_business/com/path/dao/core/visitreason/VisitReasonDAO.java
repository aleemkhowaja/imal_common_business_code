package com.path.dao.core.visitreason;

import java.util.List;

import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.visitreason.VisitReasonSC;

public interface VisitReasonDAO
{
    public int visitReasonListCount(VisitReasonSC visitReasonSC) throws DAOException;

    public List visitReasonList(VisitReasonSC visitReasonSC) throws DAOException;

    public CRM_PARAMVO returnVisitReasonById(VisitReasonSC visitReasonSC) throws DAOException;

    // returns Visit Reason Description
    public CRM_PARAMVO returnVisitReasonDesc(VisitReasonSC criteria) throws DAOException;

}
