package com.path.actions.common.global360view.others;

import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.global360view.DashboardSC;

public class DashChildCifMaintAction extends BaseAction
{
    private DashboardSC criteria = new DashboardSC();
    
    public String loadChildCifMaintPage()
    {
	
	
	return "childCifMainPageList";
    }

    public Object getModel()
    {
	return criteria;
    }
}
