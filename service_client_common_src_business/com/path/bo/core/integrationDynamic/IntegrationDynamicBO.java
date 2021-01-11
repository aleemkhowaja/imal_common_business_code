package com.path.bo.core.integrationDynamic;

import java.util.List;

import com.path.dbmaps.vo.CIF_TRXTYPE_LIMITSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.integrationDynamic.IntegrationDynamicCO;
import com.path.vo.core.integrationDynamic.IntegrationDynamicSC;

public interface IntegrationDynamicBO
{

    public IntegrationDynamicCO returnColumnsLkpList(IntegrationDynamicSC integrationDynamicSC) throws BaseException;
    public int returndynamicIntegrationListCount(IntegrationDynamicSC criteria) throws BaseException;
    public List returndynamicIntegrationList(IntegrationDynamicSC criteria) throws BaseException;
    public CIF_TRXTYPE_LIMITSVO returnTypeCode(IntegrationDynamicSC integrationDynamicSC) throws BaseException;
    public IntegrationDynamicCO constructDynamicLookup(IntegrationDynamicCO integrationDynamicCO,IntegrationDynamicSC integrationDynamicSC) throws BaseException;
}
