package com.path.bo.core.proofoccupation.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.proofoccupation.ProofOccupationBO;
import com.path.dao.core.proofoccupation.ProofOccupationDAO;
import com.path.dbmaps.vo.CTS_PROOF_OCCUPATIONVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.proofoccupation.ProofOccupationSC;

public class ProofOccupationBOImpl extends BaseBO implements ProofOccupationBO
{
    private ProofOccupationDAO proofOccupationDAO;

	public ProofOccupationDAO getProofOccupationDAO() {
		return proofOccupationDAO;
	}

	public void setProofOccupationDAO(ProofOccupationDAO proofOccupationDAO) {
		this.proofOccupationDAO = proofOccupationDAO;
	}

	@Override
    public CTS_PROOF_OCCUPATIONVO returnProofOccupationCodeById(ProofOccupationSC proofOccupationSC) throws BaseException
    {
		CTS_PROOF_OCCUPATIONVO ctsProofOccupationVO = proofOccupationDAO.returnProofOccupationCodeById(proofOccupationSC);
	if(ctsProofOccupationVO == null || ctsProofOccupationVO.getPROOF_OCCUPATION_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	}
	return ctsProofOccupationVO;
    }

    @Override
    public List proofOccupationList(ProofOccupationSC proofOccupationSC) throws BaseException
    {
	return proofOccupationDAO.proofOccupationList(proofOccupationSC);
    }

    @Override
    public int proofOccupationListCount(ProofOccupationSC proofOccupationSC) throws BaseException
    {
	return proofOccupationDAO.proofOccupationListCount(proofOccupationSC);
    }
}
