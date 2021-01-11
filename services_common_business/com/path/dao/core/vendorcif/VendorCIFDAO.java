package com.path.dao.core.vendorcif;

import java.util.List;


import com.path.dbmaps.vo.TRS_VENDORVO;
import com.path.dbmaps.vo.TRS_VENDORVOKey;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.cif.CifSC;
import com.path.vo.core.vendorcif.VendorCIFCO;

/**
 * @Auther:Pappady
 * @Date:Apr 9, 2013
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
public interface VendorCIFDAO
{
    public int trsVendorCIFListCount(CifSC criteria) throws DAOException;

    public List trsVendorCIFList(CifSC criteria) throws DAOException;

    // Vendor CIF Dependency Action
    public VendorCIFCO returnTrsVendorCIFById(CifSC criteria) throws DAOException;

    public TRS_VENDORVO returnTrsVendorDetails(TRS_VENDORVOKey criteria) throws DAOException;

    public String returnStopPaymentVendorDetails(TRS_VENDORVOKey criteria) throws DAOException;

    public int trsCIFACCListCount(CifSC criteria) throws DAOException;

    public List trsCIFACCList(CifSC criteria) throws DAOException;

    public Integer trsVendorIncentiveCIFListCount(CifSC criteria)throws DAOException;

    public List<VendorCIFCO> trsVendorIncentiveCIFList(CifSC criteria)throws DAOException;
}
