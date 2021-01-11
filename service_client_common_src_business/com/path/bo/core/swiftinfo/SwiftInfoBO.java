package com.path.bo.core.swiftinfo;

import java.util.List;

import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.swiftinfo.SwiftInfoSC;
import com.path.vo.core.trxmgnt.nonfininfo.SwiftInfoCO;

public interface SwiftInfoBO
{
    int returnSwiftInfoLookupCount(SwiftInfoSC infoSC) throws BaseException;

    List<SwiftInfoCO> returnSwiftInfoLookupData(SwiftInfoSC infoSC) throws BaseException;

    public SWIFT_INFOVO returnSwiftInfoById(SwiftInfoSC criteria) throws BaseException;
}
