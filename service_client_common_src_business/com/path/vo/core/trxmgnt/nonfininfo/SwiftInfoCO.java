package com.path.vo.core.trxmgnt.nonfininfo;

import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.vo.core.common.RetailBaseVO;

public class SwiftInfoCO extends RetailBaseVO
{
    private SWIFT_INFOVO swiftInfoVO = new SWIFT_INFOVO();

    private String showTextDesc;

    public SWIFT_INFOVO getSwiftInfoVO()
    {
	return swiftInfoVO;
    }

    public void setSwiftInfoVO(SWIFT_INFOVO swiftInfoVO)
    {
	this.swiftInfoVO = swiftInfoVO;
    }

    public String getShowTextDesc()
    {
	return showTextDesc;
    }

    public void setShowTextDesc(String showTextDesc)
    {
	this.showTextDesc = showTextDesc;
    }

}
