package com.path.bo.core.visitreason;

import java.util.List;

import com.path.dbmaps.vo.CRM_PARAMVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.visitreason.VisitReasonSC;

/**
 * @Auther:Joyce Kanazeh
 * @Date:July 9, 2016
 * @Team:CSM JAVA Team.
 * @copyright: PathSolution 2016
 */
public interface VisitReasonBO
{
    public int visitReasonListCount(VisitReasonSC visitReasonSC) throws BaseException;

    public List visitReasonList(VisitReasonSC visitReasonSC) throws BaseException;

    public CRM_PARAMVO returnVisitReasonById(VisitReasonSC visitReasonSC) throws BaseException;

    public CRM_PARAMVO returnVisitReasonDesc(VisitReasonSC criteria) throws BaseException;

}
