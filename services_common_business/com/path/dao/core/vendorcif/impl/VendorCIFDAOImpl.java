package com.path.dao.core.vendorcif.impl;

import java.util.List;

import com.path.dao.core.vendorcif.VendorCIFDAO;
import com.path.dbmaps.vo.TRS_VENDORVO;
import com.path.dbmaps.vo.TRS_VENDORVOKey;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.vendorcif.VendorCIFCO;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public class VendorCIFDAOImpl extends BaseDAO implements VendorCIFDAO
{
    public int trsVendorCIFListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsVendorCIFListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("vendorCifMapper.trsVendorCIFListCount", criteria)).intValue();
	return nb;
    }

    public List trsVendorCIFList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("vendorCifMapper.trsVendorCIFList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsVendorCIFListMap");
	    return getSqlMap().queryForList("vendorCifMapper.trsVendorCIFList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    public VendorCIFCO returnTrsVendorCIFById(CifSC criteria) throws DAOException
    {

	return (VendorCIFCO) getSqlMap().queryForObject("vendorCifMapper.returnTrsVendorCIFById", criteria);
    }

    @Override
    public TRS_VENDORVO returnTrsVendorDetails(TRS_VENDORVOKey criteria) throws DAOException
    {
	return (TRS_VENDORVO) getSqlMap().queryForObject("vendorCifMapper.returnTrsVendorDetails", criteria);
    }

    @Override
    public String returnStopPaymentVendorDetails(TRS_VENDORVOKey criteria) throws DAOException
    {
	return (String) getSqlMap().queryForObject("vendorCifMapper.getStopVendorPayment", criteria);
    }

    /**
     * returns list contains all Purchase Party CIF based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws DAOException
     */
    @Override
    public List trsCIFACCList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("vendorCifMapper.trsCIFACCList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsCIFACCListMap");
	    return getSqlMap().queryForList("vendorCifMapper.trsCIFACCList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }

    /**
     * returns Purchase Party CIF record count...
     * 
     * @param criteria
     * @return list
     * @throws DAOException
     */
    @Override
    public int trsCIFACCListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsCIFACCListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("vendorCifMapper.trsCIFACCListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public Integer trsVendorIncentiveCIFListCount(CifSC criteria) throws DAOException
    {
	DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsVendorCIFListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("vendorCifMapper.trsVendorIncentiveCIFListCount", criteria)).intValue();
	return nb;
    }

    @Override
    public List<VendorCIFCO> trsVendorIncentiveCIFList(CifSC criteria) throws DAOException
    {
	if(criteria.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("vendorCifMapper.trsVendorIncentiveCIFList", criteria);
	}
	else
	{
	    DAOHelper.fixGridMaps(criteria, getSqlMap(), "vendorCifMapper.trsVendorCIFListMap");
	    return getSqlMap().queryForList("vendorCifMapper.trsVendorIncentiveCIFList", criteria, criteria.getRecToskip(),
		    criteria.getNbRec());
	}
    }
}
