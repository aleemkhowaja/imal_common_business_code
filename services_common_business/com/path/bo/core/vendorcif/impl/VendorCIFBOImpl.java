package com.path.bo.core.vendorcif.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.vendorcif.VendorCIFBO;
import com.path.dao.core.vendorcif.VendorCIFDAO;
import com.path.dbmaps.vo.IISCTRLVO;
import com.path.dbmaps.vo.TRS_VENDORVO;
import com.path.dbmaps.vo.TRS_VENDORVOKey;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.vendorcif.VendorCIFCO;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public class VendorCIFBOImpl extends BaseBO implements VendorCIFBO
{
    private VendorCIFDAO vendorCIFDAO;

    /**
     * return the Vendor CIF list count...
     * 
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int trsVendorCIFListCount(CifSC criteria) throws BaseException
    {
	return vendorCIFDAO.trsVendorCIFListCount(criteria);
    }

    /**
     * return a list contains all Vendor CIF based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    public List trsVendorCIFList(CifSC criteria) throws BaseException
    {
	return vendorCIFDAO.trsVendorCIFList(criteria);
    }

    public VendorCIFCO returnTrsVendorCIFById(CifSC criteria) throws BaseException
    {

	return vendorCIFDAO.returnTrsVendorCIFById(criteria);
    }

    public VendorCIFDAO getVendorCIFDAO()
    {
	return vendorCIFDAO;
    }

    public void setVendorCIFDAO(VendorCIFDAO vendorCIFDAO)
    {
	this.vendorCIFDAO = vendorCIFDAO;
    }

    @Override
    public TRS_VENDORVO returnTrsVendorDetails(TRS_VENDORVOKey criteria) throws BaseException
    {
	return vendorCIFDAO.returnTrsVendorDetails(criteria);
    }

    @Override
    public String returnStopPaymentVendorDetails(TRS_VENDORVOKey criteria) throws BaseException
    {
	return vendorCIFDAO.returnStopPaymentVendorDetails(criteria);
    }

    /**
     * returns list contains all Purchase Party CIF based on the criteria...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    @Override
    public List trsCIFACCList(CifSC criteria) throws BaseException
    {
	// TP# 231715 ;deepu.mohandas 16/10/2014
	IISCTRLVO iisctrlvo = new IISCTRLVO();
	iisctrlvo.setCOMP_CODE(criteria.getCompCode());
	iisctrlvo.setBRANCH_CODE(criteria.getBranchCode());
	iisctrlvo = commonLibBO.returnIISControlDetails(iisctrlvo);

	if(iisctrlvo != null
		&& StringUtil.nullToEmpty(iisctrlvo.getDEFAULT_PURCHASE_PARTY_AS_VEND()).equals(ConstantsCommon.YES))
	{
	    return vendorCIFDAO.trsVendorCIFList(criteria);
	}
	else
	{
	    return vendorCIFDAO.trsCIFACCList(criteria);

	}

    }

    /**
     * returns Purchase Party CIF record count...
     * 
     * @param criteria
     * @return list
     * @throws BaseException
     */
    @Override
    public int trsCIFACCListCount(CifSC criteria) throws BaseException
    {
	// TP# 231715 ;deepu.mohandas 16/10/2014
	IISCTRLVO iisctrlvo = new IISCTRLVO();
	iisctrlvo.setCOMP_CODE(criteria.getCompCode());
	iisctrlvo.setBRANCH_CODE(criteria.getBranchCode());
	iisctrlvo = commonLibBO.returnIISControlDetails(iisctrlvo);

	if(iisctrlvo != null
		&& StringUtil.nullToEmpty(iisctrlvo.getDEFAULT_PURCHASE_PARTY_AS_VEND()).equals(ConstantsCommon.YES))
	{
	    return vendorCIFDAO.trsVendorCIFListCount(criteria);
	}
	else
	{
	    return vendorCIFDAO.trsCIFACCListCount(criteria);
	}
    }

    @Override
    public Integer trsVendorIncentiveCIFListCount(CifSC criteria) throws BaseException
    {
	return vendorCIFDAO.trsVendorIncentiveCIFListCount(criteria);
    }

    @Override
    public List<VendorCIFCO> trsVendorIncentiveCIFList(CifSC criteria) throws BaseException
    {
	return vendorCIFDAO.trsVendorIncentiveCIFList(criteria);
    }
}
