package com.path.bo.core.vendorcif;

import java.util.List;

import com.path.dbmaps.vo.TRS_VENDORVO;
import com.path.dbmaps.vo.TRS_VENDORVOKey;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.vendorcif.VendorCIFCO;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public interface VendorCIFBO
{
    // Vendor CIF Lookup Action
    public int trsVendorCIFListCount(CifSC criteria) throws BaseException;

    public List trsVendorCIFList(CifSC criteria) throws BaseException;

    // Vendor CIF Dependency Action
    public VendorCIFCO returnTrsVendorCIFById(CifSC criteria) throws BaseException;

    // To Return the Vendor details
    public TRS_VENDORVO returnTrsVendorDetails(TRS_VENDORVOKey criteria) throws BaseException;

    // To return Stop paymwent vendonr details
    public String returnStopPaymentVendorDetails(TRS_VENDORVOKey criteria) throws BaseException;

    // returns Purchase Party CIF record count...
    public int trsCIFACCListCount(CifSC criteria) throws BaseException;

    // returns list contains all Purchase Party CIF based on the criteria...
    public List trsCIFACCList(CifSC criteria) throws BaseException;

    public Integer trsVendorIncentiveCIFListCount(CifSC criteria)throws BaseException;

    public List<VendorCIFCO> trsVendorIncentiveCIFList(CifSC criteria)throws BaseException;
    
    
}
