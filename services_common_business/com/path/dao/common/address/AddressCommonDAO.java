/**
 * 
 */
package com.path.dao.common.address;

import java.util.List;

import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonSC;
import com.path.vo.core.csmfom.FomCO;

public interface AddressCommonDAO
{
    public List returnAddressList(AddressCommonSC criteria) throws DAOException;

    public List returnDefaultAddress(AddressCommonSC criteria) throws DAOException;

    public int returnAddressListCount(AddressCommonSC criteria) throws DAOException;

    public AddressCommonCO returnAddressDetails(AddressCommonSC criteria) throws DAOException;

    public List returnPermanentAddress(AddressCommonSC criteria) throws DAOException;

    public AddressCommonCO returnCifAddress(AddressCommonSC criteria) throws DAOException;

    public CIF_ADDRESSVO returnCountryTelCIFAddress(AddressCommonSC criteria) throws DAOException;

    public AddressCommonCO returnCifFirstAddress(AddressCommonSC criteria) throws DAOException;

    public AddressCommonCO returnAccountFirstAddress(AddressCommonSC criteria) throws DAOException;

    public List returnAccountAddressList(AddressCommonSC criteria) throws DAOException;

    public int returnAccountAddressListCount(AddressCommonSC criteria) throws DAOException;

    public AddressCommonCO returnAccountAddressDetails(AddressCommonSC criteria) throws DAOException;

    public int returnMaxAccountAddressLine(AddressCommonSC criteria) throws DAOException;

    /**
     * Return all the CIF Addresses Count
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return int
     * @throws DAOException
     */
    public int returnAllAddressListCount(AddressCommonSC criteria) throws DAOException;

    /**
     * Return all the CIF Addresses
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return List
     * @throws DAOException
     */
    public List returnAllAddressList(AddressCommonSC criteria) throws DAOException;
    
    public int checkAddressDefaultAddrFlag(AddressCommonSC addressCommonSC) throws DAOException;
    
    public List returnWalletAddress(AddressCommonSC criteria) throws DAOException;
    
    public int returnEWalletCIF(AddressCommonSC criteria)throws DAOException;

}
