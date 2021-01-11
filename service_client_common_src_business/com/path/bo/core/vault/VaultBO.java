package com.path.bo.core.vault;

import java.util.List;

import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.vault.VaultSC;

public interface VaultBO
{

    int returnVaultLookupCount(VaultSC vaultSC) throws BaseException;

    List<CTSTELLERVO> returnVaultLookupData(VaultSC vaultSC) throws BaseException;

}
