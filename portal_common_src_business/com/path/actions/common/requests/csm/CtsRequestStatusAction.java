/**
 * 
 */
package com.path.actions.common.requests.csm;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.path.bo.common.requests.csm.CtsRequestBO;
import com.path.bo.common.requests.csm.CtsRequestConstant;
import com.path.dbmaps.vo.CTS_REQUESTVO;
import com.path.lib.common.util.NumberUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.requests.csm.CtsRequestSC;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;

/**
 * @author raees
 * 
 */
public class CtsRequestStatusAction extends GridBaseAction
{
    CtsRequestSC criteria = new CtsRequestSC();
    private CtsRequestBO ctsRequestBO;
    private String url;

    public String searchRequestStatus()
    {
	try
	{
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();
	    url = theRealPath + "/path/requests/CtsRequestStatus_loadRequestStatusGrid.action?code="
		    + criteria.getCode()+"&branchCode="+criteria.getBranchCode();
	}
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
	return "SUCCESS_STATUS";
    }

    public String loadRequestStatusGrid()
    {
	String[] searchCol = { "userName", "status_desc", "status_date" };
	CTS_REQUESTVO ctsrRequestVO = new CTS_REQUESTVO();
	SelectSC lovCriteria = new SelectSC();

	List<StatusCO> resultList = new ArrayList<StatusCO>();
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    BigDecimal compCode = sessionCO.getCompanyCode();
	    BigDecimal branch = sessionCO.getBranchCode();

	    criteria.setSearchCols(searchCol);
	    ctsrRequestVO.setCOMP_CODE(compCode);
	    //we should send the request branch code and NOT the session branch code
	    ctsrRequestVO.setBRANCH(criteria.getBranchCode());
	    ctsrRequestVO.setREQ_NO(criteria.getCode());

	    lovCriteria.setLanguage(sessionCO.getLanguage());
	    lovCriteria.setCompCode(compCode);
	    lovCriteria.setBranchCode(branch);
	    lovCriteria.setLovTypeId(CtsRequestConstant.LOV_TYPE);
	    if(!NumberUtil.isEmptyDecimal(criteria.getCode()))

	    {

		resultList = ctsRequestBO.generateRequestStatusList(ctsrRequestVO, CtsRequestConstant
			.getRequestStatusFields(), lovCriteria);
	    }
	    setGridModel(resultList);
	}
	catch(Exception ex)
	{
	    log.error("Error in the loadStatusGrid method");
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public CtsRequestSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CtsRequestSC criteria)
    {
	this.criteria = criteria;
    }

    public String getUrl()
    {
	return url;
    }

    public void setUrl(String url)
    {
	this.url = url;
    }

    public void setCtsRequestBO(CtsRequestBO ctsRequestBO)
    {
	this.ctsRequestBO = ctsRequestBO;
    }
}
