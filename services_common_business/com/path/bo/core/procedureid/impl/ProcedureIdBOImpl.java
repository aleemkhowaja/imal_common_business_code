package com.path.bo.core.procedureid.impl;

import java.util.List;

import com.path.bo.core.procedureid.ProcedureIdBO;
import com.path.dao.core.procedureid.ProcedureIdDAO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.procedureid.ProcedureIdSC;

public class ProcedureIdBOImpl extends BaseBO implements ProcedureIdBO
{

    private ProcedureIdDAO procedureIdDAO;

    public int getprocedureIdCount(ProcedureIdSC procedureIdSC) throws BaseException
    {
	return procedureIdDAO.getprocedureIdCount(procedureIdSC);
    }

    public List<ProcedureIdCO> getprocedureIdList(ProcedureIdSC procedureIdSC) throws BaseException
    {
	return procedureIdDAO.getprocedureIdList(procedureIdSC);
    }

    public ProcedureIdDAO getProcedureIdDAO()
    {
	return procedureIdDAO;
    }

    public void setProcedureIdDAO(ProcedureIdDAO procedureIdDAO)
    {
	this.procedureIdDAO = procedureIdDAO;
    }

    @Override
    public ProcedureIdCO dependencyByProcId(ProcedureIdSC procedureIdSC) throws BaseException
    {
	return procedureIdDAO.dependencyByProcId(procedureIdSC);
    }

    public int getprocedureCount(ProcedureIdSC procedureIdSC) throws BaseException
    {
	return procedureIdDAO.getprocedureCount(procedureIdSC);
    }

    public List<ProcedureIdCO> getprocedureList(ProcedureIdSC procedureIdSC) throws BaseException
    {
	return procedureIdDAO.getprocedureList(procedureIdSC);
    }

    public ProcedureIdCO dependencyByProcedure(ProcedureIdSC procedureIdSC) throws BaseException
    {
	ProcedureIdCO co = procedureIdDAO.dependencyByProcedure(procedureIdSC);
	return co;
    }

}
