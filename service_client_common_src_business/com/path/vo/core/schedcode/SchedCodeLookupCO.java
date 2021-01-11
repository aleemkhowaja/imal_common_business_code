package com.path.vo.core.schedcode;

import com.path.dbmaps.vo.CRM_VISIT_SCHEDVO;
import com.path.lib.vo.BaseVO;

public class SchedCodeLookupCO extends  BaseVO {
    private CRM_VISIT_SCHEDVO crmVisitSchedVO = new CRM_VISIT_SCHEDVO();
    private String shortNameEng;
    
    public void setCrmVisitSchedVO(CRM_VISIT_SCHEDVO crmVisitSchedVO)
    {
	this.crmVisitSchedVO = crmVisitSchedVO;
    }
    public CRM_VISIT_SCHEDVO getCrmVisitSchedVO()
    {
	return crmVisitSchedVO;
    }
    public void setShortNameEng(String shortNameEng)
    {
	this.shortNameEng = shortNameEng;
    }
    public String getShortNameEng()
    {
	return shortNameEng;
    }
}
