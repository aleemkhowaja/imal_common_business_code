package com.path.dao.common.address.impl;

import java.util.List;

import com.path.dao.common.address.AddressCommonDAO;
import com.path.dbmaps.vo.CIF_ADDRESSVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.common.address.AddressCommonCO;
import com.path.vo.common.address.AddressCommonSC;
import com.path.vo.core.csmfom.FomCO;

public class AddressCommonDAOImpl extends BaseDAO implements AddressCommonDAO
{

    @Override
    public AddressCommonCO returnAddressDetails(AddressCommonSC criteria) throws DAOException
    {
        return (AddressCommonCO) getSqlMap().queryForObject("addressMapper.addressDetail", criteria);
    }

    @Override
    public List returnAddressList(AddressCommonSC criteria) throws DAOException
    {
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("addressMapper.moreAddressListWithOutFirstAddress", criteria);
        }
        else
        {
            DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.cifAddressDetailMap");
            return getSqlMap().queryForList("addressMapper.moreAddressListWithOutFirstAddress", criteria,
                    criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    @Override
    public int returnAddressListCount(AddressCommonSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.cifAddressDetailMap");
        int nb = 0;
        nb = ((Integer) getSqlMap().queryForObject("addressMapper.addressListCount", criteria)).intValue();
        return nb;
    }

    public List returnDefaultAddress(AddressCommonSC criteria) throws DAOException
    {
        return getSqlMap().queryForList("addressMapper.defaultAddress", criteria);
    }

    public List returnPermanentAddress(AddressCommonSC criteria) throws DAOException
    {
        return getSqlMap().queryForList("addressMapper.permanentAddress", criteria);
    }

    public AddressCommonCO returnCifAddress(AddressCommonSC criteria) throws DAOException
    {
        return (AddressCommonCO) getSqlMap().queryForObject("addressMapper.returnCifAddress", criteria);
    }

    @Override
    public CIF_ADDRESSVO returnCountryTelCIFAddress(AddressCommonSC criteria) throws DAOException
    {
        return (CIF_ADDRESSVO) getSqlMap().queryForObject("addressMapper.returnCountryTelCIFAddress", criteria);
    }

    public AddressCommonCO returnCifFirstAddress(AddressCommonSC criteria) throws DAOException
    {
        return (AddressCommonCO) getSqlMap().queryForObject("addressMapper.addressDetailFirstAddress", criteria);
    }

    // ******************************************************Account
    // Screen**********************************************************//

    public AddressCommonCO returnAccountFirstAddress(AddressCommonSC criteria) throws DAOException
    {
        return (AddressCommonCO) getSqlMap().queryForObject("addressMapper.acccountAddressDetailFirstAddress",
                criteria);
    }

    @Override
    public List returnAccountAddressList(AddressCommonSC criteria) throws DAOException
    {
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("addressMapper.moreAddressListWithOutFirstAddress", criteria);
        }
        else
        {
            DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.acccountAddressDetailMap");
            return getSqlMap().queryForList("addressMapper.acccountAddressListWithOutFirstAddress", criteria,
                    criteria.getRecToskip(), criteria.getNbRec());
        }
    }

    @Override
    public int returnAccountAddressListCount(AddressCommonSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.acccountAddressDetailMap");
        int nb = 0;
        nb = ((Integer) getSqlMap().queryForObject("addressMapper.acccountAddressListCountWithOutFirstAddress",
                criteria)).intValue();
        return nb;
    }

    @Override
    public AddressCommonCO returnAccountAddressDetails(AddressCommonSC criteria) throws DAOException
    {
        return (AddressCommonCO) getSqlMap().queryForObject("addressMapper.acccountAddressDetail", criteria);
    }

    public int returnMaxAccountAddressLine(AddressCommonSC criteria) throws DAOException
    {
        int nb = 0;
        nb = ((Integer) getSqlMap().queryForObject("addressMapper.returnMaxAccountAddressLine", criteria))
                .intValue();
        return nb;
    }

    /**
     * Return all the CIF Addresses
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return List
     * @throws DAOException
     */
    public List returnAllAddressList(AddressCommonSC criteria) throws DAOException
    {
        if(criteria.getNbRec() == -1)
        {
            return getSqlMap().queryForList("addressMapper.addressList", criteria);
        }
        else
        {
            DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.cifAddressDetailMap");
            return getSqlMap().queryForList("addressMapper.allAddressList", criteria, criteria.getRecToskip(),
                    criteria.getNbRec());
        }
    }

    /**
     * Return all the CIF Addresses Count
     * 
     * @author: BassamEid
     * @date: Dec 6, 2013
     * @param criteria
     * @return int
     * @throws DAOException
     */
    public int returnAllAddressListCount(AddressCommonSC criteria) throws DAOException
    {
        DAOHelper.fixGridMaps(criteria, getSqlMap(), "addressMapper.cifAddressDetailMap");

        return ((Integer) getSqlMap().queryForObject("addressMapper.allAddressListCount", criteria)).intValue();

    }
    
    public int checkAddressDefaultAddrFlag(AddressCommonSC addressCommonSC) throws DAOException
    {
	return ((Integer) getSqlMap().queryForObject("addressMapper.checkAddressDefaultAddrFlag", addressCommonSC)).intValue();
    }

    public List returnWalletAddress(AddressCommonSC criteria) throws DAOException
    {
	return getSqlMap().queryForList("addressMapper.walletAddress", criteria);
    }
    
    public int returnEWalletCIF(AddressCommonSC criteria)throws DAOException{
	
	return (Integer)getSqlMap().queryForObject("addressMapper.returnEWalletCIF", criteria);	 
    }
}
