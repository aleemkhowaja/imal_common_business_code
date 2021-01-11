/**
 * 
 */
package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.link.LinkBO;
import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;

/**
 * Copyright 2012, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: MarwanMaddah
 *
 * LinkDependencyAction.java used to
 */
public class LinkDependencyAction extends RetailBaseAction
{
  private LinkBO linkBO;
  private S_LINKVO s_linkVO = new S_LINKVO();
  
  private String bnameEngReadOnly  = "true";
  private String bnameArReadOnly   = "true";
  
  public Object getModel()
  {
  	return s_linkVO;
  }  
  /**
   * To manage the dependency by link code...
   * @return
   */
  public String dependencyByLinkCode()
  {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    s_linkVO.setCOMP_CODE(sessionCO.getCompanyCode());
	    if(s_linkVO==null || NumberUtil.isEmptyDecimal(s_linkVO.getLINK_CODE()))
	    {
        	    s_linkVO = new S_LINKVO();
	    }
	    else
	    {
		s_linkVO = linkBO.loadLinkByPk(s_linkVO);
		if(s_linkVO == null)
		{
		    s_linkVO = new S_LINKVO();
		}
	    }
	    setBnameArReadOnly("true");
	    setBnameEngReadOnly("true");
	}
	catch(Exception ex)
	{
	    handleException(ex,null,null);
	}
	return SUCCESS;
  }
  
public void setLinkBO(LinkBO linkBO)
{
    this.linkBO = linkBO;
}
public S_LINKVO getS_linkVO()
{
    return s_linkVO;
}
public void setS_linkVO(S_LINKVO sLinkVO)
{
    s_linkVO = sLinkVO;
}
public String getBnameEngReadOnly()
{
    return bnameEngReadOnly;
}
public void setBnameEngReadOnly(String bnameEngReadOnly)
{
    this.bnameEngReadOnly = bnameEngReadOnly;
}
public String getBnameArReadOnly()
{
    return bnameArReadOnly;
}
public void setBnameArReadOnly(String bnameArReadOnly)
{
    this.bnameArReadOnly = bnameArReadOnly;
}
}
