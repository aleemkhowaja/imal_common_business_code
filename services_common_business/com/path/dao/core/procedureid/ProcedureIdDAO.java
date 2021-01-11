package com.path.dao.core.procedureid;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public interface ProcedureIdDAO
{

    public int getprocedureIdCount(ProcedureIdSC procedureIdSC) throws DAOException;

    public List<ProcedureIdCO> getprocedureIdList(ProcedureIdSC procedureIdSC) throws DAOException;

    public ProcedureIdCO dependencyByProcId(ProcedureIdSC procedureIdSC) throws DAOException;

    public int getprocedureCount(ProcedureIdSC procedureIdSC) throws DAOException;

    public List<ProcedureIdCO> getprocedureList(ProcedureIdSC procedureIdSC) throws DAOException;

    public ProcedureIdCO dependencyByProcedure(ProcedureIdSC procedureIdSC) throws DAOException;

}
