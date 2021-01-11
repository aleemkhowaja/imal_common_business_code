package com.path.dao.core.proofoccupation;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROOF_OCCUPATIONVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.proofoccupation.ProofOccupationSC;

public interface ProofOccupationDAO
{
    public CTS_PROOF_OCCUPATIONVO returnProofOccupationCodeById(ProofOccupationSC proofOccupationSC) throws DAOException;

    public List proofOccupationList(ProofOccupationSC proofOccupationSC) throws DAOException;

    public int proofOccupationListCount(ProofOccupationSC proofOccupationSC) throws DAOException;
}
