package com.path.bo.common.swift.swiftoutward;

import java.math.BigDecimal;

import com.path.bo.common.swift.swiftinward.SwiftInwardBO;
import com.path.bo.common.swift.swiftoutward.SwiftEngineBO;
import com.path.bo.common.swift.swiftoutward.SwiftOutwardNonTransBO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.SessionCO;
import com.path.vo.common.swift.swiftinward.SwiftInwardCO;
import com.path.vo.common.swift.swiftoutward.SwiftCO;
import com.path.vo.common.swift.swiftoutward.SwiftOutwardSC;

public class SwiftEngineBOImpl extends BaseBO implements SwiftEngineBO
{
	//efarah 07/04/2017 EWBI170270
    private SwiftOutwardNonTransBO swiftOutwardNonTransBO;
    private SwiftInwardBO swiftInwardBO;

    public void setSwiftInwardBO(SwiftInwardBO swiftInwardBO) {
		this.swiftInwardBO = swiftInwardBO;
	}

	public void setSwiftOutwardNonTransBO(SwiftOutwardNonTransBO swiftOutwardNonTransBO)
    {
	this.swiftOutwardNonTransBO = swiftOutwardNonTransBO;
    }

    public void startEngine() throws BaseException
    {
    	BigDecimal bdRefreshRate;
    	int iEngineStatus;
    	try
    	{
    		String language = swiftOutwardNonTransBO.returnLanguage("SWEN");
    		bdRefreshRate = swiftOutwardNonTransBO.returnRefreshRate(language,"SWIFT");
    		iEngineStatus = swiftOutwardNonTransBO.returnServiceStatus("SWIFT",language);
    		if(iEngineStatus == 1)
		    {
    			swiftOutwardNonTransBO.initEngineBeforeStart(language, BigDecimal.ONE, bdRefreshRate, new SwiftOutwardSC());
    		    swiftOutwardNonTransBO.runThread(new Long(bdRefreshRate.intValue() * 1000L), language, BigDecimal.ONE,BigDecimal.ONE, "SWEN", new SwiftCO(), null);
		    }
    		bdRefreshRate = swiftOutwardNonTransBO.returnRefreshRate(language,"SWIFT_IN");
    		iEngineStatus = swiftOutwardNonTransBO.returnServiceStatus("SWIFT_IN", language);
    		if(iEngineStatus == 1)
		    {
    			swiftInwardBO.runThread(new Long(bdRefreshRate.intValue() * 1000L), language, BigDecimal.ONE, BigDecimal.ONE, "SWEN", new SwiftInwardCO(), null, null);
		    }
    	}
    	catch(Exception e)
    	{
    		throw new BOException(e);
    	}
    }

	@Override
	public void stopEngine() throws BaseException {
		// TODO Auto-generated method stub
		
	}
}