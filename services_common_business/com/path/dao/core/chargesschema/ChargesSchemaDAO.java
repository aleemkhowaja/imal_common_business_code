package com.path.dao.core.chargesschema;

import java.util.List;

import com.path.dbmaps.vo.CTSCHARGES_SCHEMAVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.chargesschema.ChargesSchemaSC;
import com.path.vo.core.csmfom.CTSChargesCO;

public interface ChargesSchemaDAO {
    public int chargesSchemaListCount(ChargesSchemaSC criteria) throws DAOException;
    public List chargesSchemaList(ChargesSchemaSC criteria) throws DAOException;
    public CTSCHARGES_SCHEMAVO returnDependencyByCode (ChargesSchemaSC criteria) throws DAOException;
    public CTSCHARGES_SCHEMAVO returnChargesSchemaDetailByCode (ChargesSchemaSC criteria) throws DAOException;
    public int trxChargesSchemaListCount(ChargesSchemaSC criteria) throws DAOException;
    public List trxChargesSchemaList(ChargesSchemaSC criteria) throws DAOException;
    public int maintenenceChargesListCount(ChargesSchemaSC criteria) throws DAOException;
    public List maintenenceChargesList(ChargesSchemaSC criteria) throws DAOException;
    public int excemptedInBranchesListCount(ChargesSchemaSC criteria) throws DAOException;
    public List excemptedInBranchesList(ChargesSchemaSC criteria) throws DAOException;
    public CTSChargesCO returnChargesDetailByCode (ChargesSchemaSC criteria) throws DAOException;
    public int chargesSchemaForeignCYChargeListCount(ChargesSchemaSC criteria) throws DAOException;
    public List chargesSchemaForeignCYChargeList(ChargesSchemaSC criteria) throws DAOException;  
    public int isRosterChanged(ChargesSchemaSC criteria) throws DAOException;
    public int isCurrencyChanged(ChargesSchemaSC criteria) throws DAOException;
    
    public CTSChargesCO returnSegChargesDetailByCode (ChargesSchemaSC criteria) throws DAOException;


}

