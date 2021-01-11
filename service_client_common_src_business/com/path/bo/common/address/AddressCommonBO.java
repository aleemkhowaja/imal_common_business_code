/**
 * 
 */
package com.path.bo.common.address;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonLabelCO;
import com.path.vo.common.address.AddressCommonSC;

public interface AddressCommonBO
{
    public List returnAddressList(AddressCommonSC criteria) throws BaseException;

    public List returnDefaultAddress(AddressCommonSC criteria) throws BaseException;

    public int returnAddressListCount(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO returnAddressDetails(AddressCommonSC criteria) throws BaseException;

    public AddressCommonLabelCO passAddressSectionLabel(BigDecimal compCode, String language) throws BaseException;

    public List returnPermanentAddress(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO returnCifAddress(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO returnAccountFirstAddress(AddressCommonSC criteria) throws BaseException;

    public CIF_ADDRESSVO returnCountryTelCIFAddress(AddressCommonSC criteria) throws BaseException;

    public List returnAccountAddressList(AddressCommonSC criteria) throws BaseException;

    public int returnAccountAddressListCount(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO returnAccountAddressDetails(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO initialiseAddressSreen(AddressCommonCO addressCommonCO) throws BaseException;

    public int returnMaxAccountAddressLine(AddressCommonSC criteria) throws BaseException;

    public AddressCommonCO addressDisplayManagement(AddressCommonCO addressCommonCO) throws BaseException;

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> initialiseAddressVisibility(AddressCommonCO addressCommonCO)
            throws BaseException;

    /**
     * Return all the CIF Addresses count
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return int
     * @throws BaseException
     */
    public int returnAllAddressListCount(AddressCommonSC criteria) throws BaseException;

    /**
     * Return all the CIF Addresses
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return List
     * @throws BaseException
     */
    public List returnAllAddressList(AddressCommonSC criteria) throws BaseException;
    
    public void checkAddressDefaultAddrFlag(AddressCommonCO addressCommonCO) throws BaseException;

    public int checkNegativeComp(AddressCommonSC criteria) throws BaseException;
    
    public AddressCommonCO fillDescriptionInSelectedLang(AddressCommonCO addressCommonCO) throws BaseException;
    
    public AddressCommonCO returnCifFirstAddress(AddressCommonSC criteria) throws BaseException;
    
    public List returnWalletAddress(AddressCommonSC criteria) throws BaseException;
}
