package com.path.bo.core.proofaddress;

import java.util.List;

import com.path.dbmaps.vo.CTS_PROOF_ADDRESSVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.proofaddress.ProofAddressSC;

public interface ProofAddressBO
{
    public int proofAddressListCount(ProofAddressSC proofAddressSC) throws BaseException;

    public List proofAddressList(ProofAddressSC proofAddressSC) throws BaseException;

    public CTS_PROOF_ADDRESSVO returnProofAddressCodeById(ProofAddressSC proofAddressSC) throws BaseException;

}

