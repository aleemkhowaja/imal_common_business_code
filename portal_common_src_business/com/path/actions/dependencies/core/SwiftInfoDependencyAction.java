package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.swiftinfo.SwiftInfoBO;
import com.path.dbmaps.vo.SWIFT_INFOVO;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.swiftinfo.SwiftInfoSC;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: lvalappil
 *
 * CifSwiftDependencyAction.java used to
 */
public class SwiftInfoDependencyAction extends RetailBaseAction
{
	private SwiftInfoBO swiftInfoBO;
	private SWIFT_INFOVO cifSwiftVO;
	private String SEND_TO_RECEIVER;
    
	
    public String dependencyBySwiftInfo() {
 
		try 
		{
			if (!StringUtil.nullToEmpty(SEND_TO_RECEIVER).equals(""))
			{
				
				SessionCO sessionCO = returnSessionObject();
				SwiftInfoSC criteria = new SwiftInfoSC();
				criteria.setCompCode(sessionCO.getCompanyCode());
				criteria.setSendToReceiver(SEND_TO_RECEIVER);
				
				cifSwiftVO = swiftInfoBO.returnSwiftInfoById(criteria);
			}
		} 
		catch (Exception e) 
		{
			log.error(e,"Error in dependencyBySwiftInfo method of SwiftInfoDependencyAction");
			handleException(e, "ERROR in SwiftInfoDependencyAction Dependency", null);
		}

		return SUCCESS;

	}
   
 

	public void setSwiftInfoBO(SwiftInfoBO swiftInfoBO) {
		this.swiftInfoBO = swiftInfoBO;
	}


	public SWIFT_INFOVO getCifSwiftVO() {
		return cifSwiftVO;
	}



	public void setCifSwiftVO(SWIFT_INFOVO cifSwiftVO) {
		this.cifSwiftVO = cifSwiftVO;
	}



	public String getSEND_TO_RECEIVER() {
		return SEND_TO_RECEIVER;
	}



	public void setSEND_TO_RECEIVER(String sENDTORECEIVER) {
		SEND_TO_RECEIVER = sENDTORECEIVER;
	}
 

	
	
}
