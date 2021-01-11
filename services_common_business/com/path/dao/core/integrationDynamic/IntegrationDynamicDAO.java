package com.path.dao.core.integrationDynamic;

import java.util.List;

import com.path.lib.common.exception.DAOException;
import com.path.vo.core.integrationDynamic.IntegrationDynamicCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicSC;

public interface IntegrationDynamicDAO
{

    public IntegrationDynamicCO returnColumnsLkpList (IntegrationDynamicSC integrationDynamicSC) throws DAOException;
    public int returndynamicIntegrationListCount(IntegrationDynamicSC criteria) throws DAOException;
    public List returndynamicIntegrationList(IntegrationDynamicSC criteria) throws DAOException;
}
