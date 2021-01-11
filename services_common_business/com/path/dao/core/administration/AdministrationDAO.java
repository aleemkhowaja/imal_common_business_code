package com.path.dao.core.administration;

import java.util.List;

import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.administration.AdministrationSC;

public interface AdministrationDAO
{
    public int administrationCount(AdministrationSC administrationSC) throws DAOException;

    public List<CTSADMINISTRATIONVO> administrationList(AdministrationSC administrationSC) throws DAOException;

    public CTSADMINISTRATIONVO selectAdministrationByCode(AdministrationSC criteria)throws DAOException;
}
