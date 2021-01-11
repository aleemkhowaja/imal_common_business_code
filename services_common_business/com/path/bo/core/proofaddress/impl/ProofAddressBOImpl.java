package com.path.bo.core.proofaddress.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.proofaddress.ProofAddressBO;
import com.path.dao.core.proofaddress.ProofAddressDAO;
import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.proofaddress.ProofAddressSC;

public class ProofAddressBOImpl extends BaseBO implements ProofAddressBO
{
    private ProofAddressDAO proofAddressDAO;

	public ProofAddressDAO getProofAddressDAO() {
		return proofAddressDAO;
	}

	public void setProofAddressDAO(ProofAddressDAO proofAddressDAO) {
		this.proofAddressDAO = proofAddressDAO;
	}

	@Override
    public CTS_PROOF_ADDRESSVO returnProofAddressCodeById(ProofAddressSC proofAddressSC) throws BaseException
    {
		CTS_PROOF_ADDRESSVO ctsProofAddressVO = proofAddressDAO.returnProofAddressCodeById(proofAddressSC);
	if(ctsProofAddressVO == null || ctsProofAddressVO.getPROF_ADDRESS_CODE() == null)
	{
	    throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	}
	return ctsProofAddressVO;
    }

    @Override
    public List proofAddressList(ProofAddressSC proofAddressSC) throws BaseException
    {
	return proofAddressDAO.proofAddressList(proofAddressSC);
    }

    @Override
    public int proofAddressListCount(ProofAddressSC proofAddressSC) throws BaseException
    {
	return proofAddressDAO.proofAddressListCount(proofAddressSC);
    }
}
