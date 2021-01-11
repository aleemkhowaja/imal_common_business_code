package com.path.dao.core.swiftinfo.impl;

import java.util.List;

import com.path.dao.core.swiftinfo.SwiftInfoDAO;
import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.swiftinfo.SwiftInfoSC;
import com.path.vo.core.trxmgnt.nonfininfo.SwiftInfoCO;

@SuppressWarnings("unchecked")
public class SwiftInfoDAOImpl extends BaseDAO implements SwiftInfoDAO
{

    public int returnSwiftInfoLookupCount(SwiftInfoSC swiftInfoSC) throws DAOException
    {
	DAOHelper.fixGridMaps(swiftInfoSC, getSqlMap(), "swiftInfoMapper.swiftInfoListMap");
	int nb = 0;
	nb = ((Integer) getSqlMap().queryForObject("swiftInfoMapper.returnSwiftInfoLookupCount", swiftInfoSC))
		.intValue();
	return nb;

    }

    public List<SwiftInfoCO> returnSwiftInfoLookupData(SwiftInfoSC swiftInfoSC) throws DAOException
    {
	DAOHelper.fixGridMaps(swiftInfoSC, getSqlMap(), "swiftInfoMapper.swiftInfoListMap");
	if(swiftInfoSC.getNbRec() == -1)
	{
	    return getSqlMap().queryForList("swiftInfoMapper.returnSwiftInfoLookupData", swiftInfoSC);
	}
	else
	{
	    return getSqlMap().queryForList("swiftInfoMapper.returnSwiftInfoLookupData", swiftInfoSC,
		    swiftInfoSC.getRecToskip(), swiftInfoSC.getNbRec());
	    
	}
    }

    public SWIFT_INFOVO returnSwiftInfoById(SwiftInfoSC criteria) throws DAOException
    {
	return (SWIFT_INFOVO) getSqlMap().queryForObject("swiftInfoMapper.returnSwiftInfoById", criteria);
    }

}
