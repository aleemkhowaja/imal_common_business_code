package com.path.dao.core.cifswift.impl;

import java.util.List;

import com.path.dao.core.cifswift.CifSwiftDAO;
import com.path.dbmaps.vo.CIF_BANK_DETAILSVO;
import com.path.dbmaps.vo.PMSCIFSWIFTVO;
import com.path.dbmaps.vo.S_PMSCIFSWIFTVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cifswift.CifSwiftSC;
import com.path.vo.core.csmfom.FomCifSwiftCO;

public class CifSwiftDAOImpl extends BaseDAO implements CifSwiftDAO
{

    @Override
    public List bankList(CifSwiftSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifSwiftMapper.cifSwiftList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "S_PMSCIFSWIFT.BaseResultMap");
	    return getSqlMap().queryForList("cifSwiftMapper.cifSwiftList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int bankListCount(CifSwiftSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "S_PMSCIFSWIFT.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifSwiftMapper.cifSwiftListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public S_PMSCIFSWIFTVO returnBankById(CifSwiftSC criteria) throws DAOException
    {
	return (S_PMSCIFSWIFTVO) getSqlMap().queryForObject("cifSwiftMapper.returnNameById", criteria);
    }

    public PMSCIFSWIFTVO returnPMSCIFSWIFTMinCIFBIC(CifSwiftSC criteria) throws DAOException
    {
	return (PMSCIFSWIFTVO) getSqlMap().queryForObject("cifSwiftMapper.returnPMSCIFSWIFTMinCIFBIC", criteria);
    }

    public PMSCIFSWIFTVO returnPMSCIFSWIFT(CifSwiftSC criteria) throws DAOException
    {
	return (PMSCIFSWIFTVO) getSqlMap().queryForObject("cifSwiftMapper.returnPMSCIFSWIFT", criteria);
    }

    public FomCifSwiftCO returnBankStatusBicCodeById(CifSwiftSC criteria) throws DAOException
    {
	return (FomCifSwiftCO) getSqlMap().queryForObject("cifSwiftMapper.returnBankStatusBicCodeById", criteria);
    }

    @Override
    public FomCifSwiftCO dependencySwiftReceiverBIC(CifSwiftSC criteria) throws DAOException
    {
	return (FomCifSwiftCO) getSqlMap().queryForObject("cifSwiftMapper.dependencySwiftReceiverBIC", criteria);
    }
    
    
    /**
     * BicCode Lookup count
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public int returnBicCodeLookupCount(CifSwiftSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifSwiftMapper.bankStatusBicCodeMap");
        return ((Integer) getSqlMap().queryForObject("cifSwiftMapper.returnBicCodeLookupCount", criteria))
                .intValue();
    }

    /**
     * Cif swift BicCode Lookup list
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public List<FomCifSwiftCO> returnBicCodeLookupList(CifSwiftSC criteria) throws DAOException
    {

        DAOHelper.fixGridMaps(criteria, getSqlMap(), "cifSwiftMapper.bankStatusBicCodeMap");
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("cifSwiftMapper.returnBicCodeLookupList", criteria);

        }
        else
        {
            return getSqlMap().queryForList("cifSwiftMapper.returnBicCodeLookupList", criteria,
                    criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    /**
     * Cif swift BicCode Dependency
     * 
     * @author: BoushraFahs
     * @date: 4 Oct 2013
     * @PB:
     * @param criteria
     * @return
     * @throws DAOException
     */
    public FomCifSwiftCO returnBicCodeById(CifSwiftSC criteria) throws DAOException
    {
        return (FomCifSwiftCO) getSqlMap().queryForObject("cifSwiftMapper.returnBicCodeById", criteria);

    }

    public CIF_BANK_DETAILSVO returnCifBankDetails(CIF_BANK_DETAILSVO cifBankDetailsVO) throws DAOException
    {
	return (CIF_BANK_DETAILSVO) getSqlMap().queryForObject("cifSwiftMapper.returnCifBankDetails", cifBankDetailsVO);
    }

    @Override
    public List benefBankBicByCountryList(CifSwiftSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("cifSwiftMapper.benefBankBicByCountryList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "S_PMSCIFSWIFT.BaseResultMap");
	    return getSqlMap().queryForList("cifSwiftMapper.benefBankBicByCountryList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    @Override
    public int benefBankBicByCountryCount(CifSwiftSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "S_PMSCIFSWIFT.BaseResultMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("cifSwiftMapper.benefBankBicByCountryCount", criteria)).intValue();
	return nb;
    }
}
