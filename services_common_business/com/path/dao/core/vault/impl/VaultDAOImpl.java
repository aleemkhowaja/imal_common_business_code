package com.path.dao.core.vault.impl;

import java.util.List;

import com.path.dao.core.vault.VaultDAO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.vault.VaultSC;

@SuppressWarnings("unchecked")
public class VaultDAOImpl extends BaseDAO implements VaultDAO
{

    public int returnVaultLookupCount(VaultSC vaultSC) throws DAOException
    {
	DAOHelper.fixGridMaps(vaultSC, getSqlMap(), "vaultMapper.vaultListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("vaultMapper.returnVaultLookupCount", vaultSC)).intValue();
	return nb;

    }

    public List<CTSTELLERVO> returnVaultLookupData(VaultSC vaultSC) throws DAOException
    {
	DAOHelper.fixGridMaps(vaultSC, getSqlMap(), "vaultMapper.vaultListMap");
	if(vaultSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("vaultMapper.returnVaultLookupData", vaultSC);
	}
	else
	{
	    return getSqlMap().queryForList("vaultMapper.returnVaultLookupData", vaultSC, vaultSC.getRecToskip(),
		    vaultSC.getNbRec());
	}
    }

}
