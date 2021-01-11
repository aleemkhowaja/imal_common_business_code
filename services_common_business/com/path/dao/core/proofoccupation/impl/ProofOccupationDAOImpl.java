package com.path.dao.core.proofoccupation.impl;

import java.util.List;

import com.path.dao.core.proofoccupation.ProofOccupationDAO;
import com.path.dbmaps.vo.CTS_PROOF_OCCUPATIONVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.proofoccupation.ProofOccupationSC;

public class ProofOccupationDAOImpl extends BaseDAO implements ProofOccupationDAO
{

    public CTS_PROOF_OCCUPATIONVO returnProofOccupationCodeById(ProofOccupationSC proofOccupationSC) throws DAOException
    {

	return (CTS_PROOF_OCCUPATIONVO) getSqlMap().queryForObject("proofOccupationMapper.returnProofOccupationCodeById", proofOccupationSC);
    }

    public List proofOccupationList(ProofOccupationSC proofOccupationSC) throws DAOException
    {

	if(proofOccupationSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("proofOccupationMapper.empStatusList", proofOccupationSC);
	}
	else
	{
	    DAOHelper.fixGridMaps(proofOccupationSC, getSqlMap(), "proofOccupationMapper.proofOccupationListMap");
	    return getSqlMap().queryForList("proofOccupationMapper.proofOccupationList", proofOccupationSC, proofOccupationSC.getRecToskip(),
	    		proofOccupationSC.getNbRec());
	}
    }

    @Override
    public int proofOccupationListCount(ProofOccupationSC proofOccupationSC) throws DAOException
    {

	DAOHelper.fixGridMaps(proofOccupationSC, getSqlMap(), "proofOccupationMapper.proofOccupationListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("proofOccupationMapper.proofOccupationListCount", proofOccupationSC)).intValue();
	return nb;
    }

}
