package com.path.dao.core.cifswift;

import java.util.List;

import com.path.dbmaps.vo.CIF_BANK_DETAILSVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

public interface CifSwiftDAO
{
    public int bankListCount(CifSwiftSC criteria) throws DAOException;

    public List bankList(CifSwiftSC criteria) throws DAOException;

    public S_PMSCIFSWIFTVO returnBankById(CifSwiftSC criteria) throws DAOException;

    public PMSCIFSWIFTVO returnPMSCIFSWIFTMinCIFBIC(CifSwiftSC criteria) throws DAOException;

    public PMSCIFSWIFTVO returnPMSCIFSWIFT(CifSwiftSC criteria) throws DAOException;

    public FomCifSwiftCO returnBankStatusBicCodeById(CifSwiftSC criteria) throws DAOException;

    public FomCifSwiftCO dependencySwiftReceiverBIC(CifSwiftSC criteria) throws DAOException;

    public int returnBicCodeLookupCount(CifSwiftSC criteria) throws DAOException;

    public List<FomCifSwiftCO> returnBicCodeLookupList(CifSwiftSC criteria) throws DAOException;

    public FomCifSwiftCO returnBicCodeById(CifSwiftSC criteria) throws DAOException;

    public CIF_BANK_DETAILSVO returnCifBankDetails(CIF_BANK_DETAILSVO cifBankDetailsVO) throws DAOException;
    
    public List benefBankBicByCountryList(CifSwiftSC criteria) throws DAOException;

    public int benefBankBicByCountryCount(CifSwiftSC criteria) throws DAOException;

}
