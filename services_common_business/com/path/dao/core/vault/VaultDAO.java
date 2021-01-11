package com.path.dao.core.vault;

import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.vault.VaultSC;

public interface VaultDAO
{

    int returnVaultLookupCount(VaultSC vaultSC) throws DAOException;

    List<CTSTELLERVO> returnVaultLookupData(VaultSC vaultSC) throws DAOException;

}
