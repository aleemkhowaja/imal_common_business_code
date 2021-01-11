package com.path.bo.core.common.base; 

import com.path.bo.core.common.CoreCommonBO;
import com.path.bo.core.common.CoreCommonChargesBO;
import com.path.bo.core.common.CoreCommonProcedureBO;
import com.path.bo.core.common.CoreCommonServiceBO;
import com.path.lib.common.base.BaseBO;

public class RetailBaseBO extends BaseBO{
	
	protected CoreCommonBO coreCommonBO;//common bean to be used for core
	protected CoreCommonProcedureBO coreCommonProcedureBO; // common bean to be used for the procedures of Core
	protected CoreCommonChargesBO coreCommonChargesBO; // common bean to be used for the charges section of Core
	protected CoreCommonServiceBO coreCommonServiceBO;// common bean to be used for the common method in imal_services

	public void setCoreCommonBO(CoreCommonBO coreCommonBO) {
		this.coreCommonBO = coreCommonBO;
	}

	public void setCoreCommonProcedureBO(CoreCommonProcedureBO coreCommonProcedureBO) {
		this.coreCommonProcedureBO = coreCommonProcedureBO;
	}

	public void setCoreCommonChargesBO(CoreCommonChargesBO coreCommonChargesBO)
	{
	    this.coreCommonChargesBO = coreCommonChargesBO;
	}
	
	public void setCoreCommonServiceBO(CoreCommonServiceBO coreCommonServiceBO)
	{
	    this.coreCommonServiceBO = coreCommonServiceBO;
	}
}
