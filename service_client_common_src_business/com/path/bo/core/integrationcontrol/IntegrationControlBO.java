package com.path.bo.core.integrationcontrol;

import java.util.List;

import com.path.dbmaps.vo.CTS_INTEG_PARAMVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.integrationcontrol.IntegrationControlSC;

public interface IntegrationControlBO {
	
	public int integrationControlListCount(IntegrationControlSC integrationControlSC) throws BaseException;
	 public List integrationControlList(IntegrationControlSC integrationControlSC) throws BaseException;
	 public CTS_INTEG_PARAMVO returnIntegrationControlById(IntegrationControlSC criteria) throws BaseException;

}
