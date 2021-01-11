package com.path.bo.core.chargesschema;

import java.util.List;

import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCO;

public interface ChargesSchemaBO {
    public int chargesSchemaListCount(ChargesSchemaSC criteria) throws BaseException;
    public List chargesSchemaList(ChargesSchemaSC criteria) throws BaseException;
    public CTSCHARGES_SCHEMAVO returnDependencyByCode (ChargesSchemaSC criteria) throws BaseException;
    public CTSCHARGES_SCHEMAVO returnChargesSchemaDetailByCode (ChargesSchemaSC criteria) throws BaseException;
    public int trxChargesSchemaListCount(ChargesSchemaSC criteria) throws BaseException;
    public List trxChargesSchemaList(ChargesSchemaSC criteria) throws BaseException;
    public int maintenenceChargesListCount(ChargesSchemaSC criteria) throws BaseException;
    public List maintenenceChargesList(ChargesSchemaSC criteria) throws BaseException;
    public int excemptedInBranchesListCount(ChargesSchemaSC criteria) throws BaseException;
    public List excemptedInBranchesList(ChargesSchemaSC criteria) throws BaseException;
    public CTSChargesCO returnChargesDetailByCode (ChargesSchemaSC criteria) throws BaseException;
    public int chargesSchemaForeignCYChargeListCount(ChargesSchemaSC criteria) throws BaseException;
    public List chargesSchemaForeignCYChargeList(ChargesSchemaSC criteria) throws BaseException;
}
