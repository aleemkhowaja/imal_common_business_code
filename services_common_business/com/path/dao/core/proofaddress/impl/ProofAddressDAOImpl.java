package com.path.dao.core.proofaddress.impl;

import java.util.List;

import com.path.dao.core.proofaddress.ProofAddressDAO;
import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.proofaddress.ProofAddressSC;

public class ProofAddressDAOImpl extends BaseDAO implements ProofAddressDAO
{

    public CTS_PROOF_ADDRESSVO returnProofAddressCodeById(ProofAddressSC proofAddressSC) throws DAOException
    {

	return (CTS_PROOF_ADDRESSVO) getSqlMap().queryForObject("proofAddressMapper.returnProofAddressCodeById", proofAddressSC);
    }

    public List proofAddressList(ProofAddressSC proofAddressSC) throws DAOException
    {

	if(proofAddressSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("proofAddressMapper.empStatusList", proofAddressSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(proofAddressSC, getSqlMap(), "proofAddressMapper.proofAddressListMap");
	    return getSqlMap().queryForList("proofAddressMapper.proofAddressList", proofAddressSC, proofAddressSC.getRecToskip(),
	    		proofAddressSC.getNbRec());
	}
    }

    @Override
    public int proofAddressListCount(ProofAddressSC proofAddressSC) throws DAOException
    {

	DAOHelper.fixGridMaps(proofAddressSC, getSqlMap(), "proofAddressMapper.proofAddressListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("proofAddressMapper.proofAddressListCount", proofAddressSC)).intValue();
	return nb;
    }

}
