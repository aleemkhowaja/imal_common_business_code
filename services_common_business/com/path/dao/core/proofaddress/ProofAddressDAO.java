package com.path.dao.core.proofaddress;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.proofaddress.ProofAddressSC;

public interface ProofAddressDAO
{
    public CTS_PROOF_ADDRESSVO returnProofAddressCodeById(ProofAddressSC proofAddressSC) throws DAOException;

    public List proofAddressList(ProofAddressSC proofAddressSC) throws DAOException;

    public int proofAddressListCount(ProofAddressSC proofAddressSC) throws DAOException;
}
