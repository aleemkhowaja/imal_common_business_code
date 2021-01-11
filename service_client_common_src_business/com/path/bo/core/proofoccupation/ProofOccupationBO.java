package com.path.bo.core.proofoccupation;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROOF_OCCUPATIONVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.proofoccupation.ProofOccupationSC;

public interface ProofOccupationBO
{
    public int proofOccupationListCount(ProofOccupationSC proofOccupationSC) throws BaseException;

    public List proofOccupationList(ProofOccupationSC proofOccupationSC) throws BaseException;

    public CTS_PROOF_OCCUPATIONVO returnProofOccupationCodeById(ProofOccupationSC proofOccupationSC) throws BaseException;

}

