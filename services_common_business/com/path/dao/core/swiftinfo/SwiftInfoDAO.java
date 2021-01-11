package com.path.dao.core.swiftinfo;

import java.util.List;

import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.swiftinfo.SwiftInfoSC;
import com.path.vo.core.trxmgnt.nonfininfo.SwiftInfoCO;

public interface SwiftInfoDAO
{

    int returnSwiftInfoLookupCount(SwiftInfoSC swiftInfoSC) throws DAOException;

    List<SwiftInfoCO> returnSwiftInfoLookupData(SwiftInfoSC swiftInfoSC) throws DAOException;

    public SWIFT_INFOVO returnSwiftInfoById(SwiftInfoSC criteria) throws DAOException;
}
