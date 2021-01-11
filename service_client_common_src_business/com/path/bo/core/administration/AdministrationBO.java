package com.path.bo.core.administration;

import java.util.List;

import com.path.dbmaps.vo.CTSADMINISTRATIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.administration.AdministrationSC;

public interface AdministrationBO
{
    public int administrationLookupCount(AdministrationSC criteria) throws BaseException;

    public List<CTSADMINISTRATIONVO> administrationLookupList(AdministrationSC criteria) throws BaseException;

    public CTSADMINISTRATIONVO returnAdministrationByCode(AdministrationSC criteria) throws BaseException;
}
