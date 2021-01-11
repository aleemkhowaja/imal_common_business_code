package com.path.bo.core.procedureid;

import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public interface ProcedureIdBO

{
    public int getprocedureIdCount(ProcedureIdSC procedureIdSC) throws BaseException;

    public List<ProcedureIdCO> getprocedureIdList(ProcedureIdSC procedureIdSC) throws BaseException;

    public ProcedureIdCO dependencyByProcId(ProcedureIdSC procedureIdSC) throws BaseException;

    public int getprocedureCount(ProcedureIdSC procedureIdSC) throws BaseException;

    public List<ProcedureIdCO> getprocedureList(ProcedureIdSC procedureIdSC) throws BaseException;

    public ProcedureIdCO dependencyByProcedure(ProcedureIdSC procedureIdSC) throws BaseException;

}
