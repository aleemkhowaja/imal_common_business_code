package com.path.bo.core.swiftinfo.impl;

import java.util.List;

import com.path.bo.core.swiftinfo.SwiftInfoBO;
import com.path.dao.core.swiftinfo.SwiftInfoDAO;
import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.swiftinfo.SwiftInfoSC;
import com.path.vo.core.trxmgnt.nonfininfo.SwiftInfoCO;

public class SwiftInfoBOImpl extends BaseBO implements SwiftInfoBO
{
    private SwiftInfoDAO swiftInfoDAO;

    /**
     * return the Swift Info lookup list count
     * 
     * @param swiftInfoSC
     * @return int
     * @throws BaseException
     */
    public int returnSwiftInfoLookupCount(SwiftInfoSC swiftInfoSC) throws BaseException
    {
	return swiftInfoDAO.returnSwiftInfoLookupCount(swiftInfoSC);
    }

    public SwiftInfoDAO getSwiftInfoDAO()
    {
	return swiftInfoDAO;
    }

    public void setSwiftInfoDAO(SwiftInfoDAO swiftInfoDAO)
    {
	this.swiftInfoDAO = swiftInfoDAO;
    }

    public List<SwiftInfoCO> returnSwiftInfoLookupData(SwiftInfoSC swiftInfoSC) throws BaseException
    {
	return swiftInfoDAO.returnSwiftInfoLookupData(swiftInfoSC);
    }

    public SWIFT_INFOVO returnSwiftInfoById(SwiftInfoSC criteria) throws BaseException
    {
	return (SWIFT_INFOVO) swiftInfoDAO.returnSwiftInfoById(criteria);
    }

}
