package com.path.core.actions.segmentation;

import java.util.List;
import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
import com.path.bo.core.segmentation.CustSegmentationConstant;
import com.path.dbmaps.vo.CTS_SEGMENTVO;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.status.StatusCO;
import com.path.vo.core.segmentation.CustSegmentationSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * CustSegmentationStatusAction.java used to generate Status common Popup for
 * CustSegmentation
 */
public class CustSegmentationStatusAction extends GridBaseAction
{

    private CustSegmentationSC criteria = new CustSegmentationSC();
    private String url;

    public String search()
    {
	try
	{
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();

	    if(criteria.getProgRef() != null && criteria.getProgRef().contains("CSC00"))
	    {
		criteria.setIsSegmentationScore("SC");
	    }
	    else if(criteria.getProgRef() != null && criteria.getProgRef().contains("CSG00"))
	    {
		criteria.setIsSegmentationScore("S");
	    }

	    // TODO add you criteria parameters to the URL
	    url = theRealPath + "/path/segmentation/CustSegmentationStatusAction_loadStatusGrid.action?segment_code="
		    + criteria.getSegment_code() + "&isSegmentationScore=" + criteria.getIsSegmentationScore();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	    return ERROR_ACTION;
	}
	return "SUCCESS_STATUS";
    }

    public String loadStatusGrid()
    {
	String[] searchCol = { "userName", "status_desc", "status_date" };
	CTS_SEGMENTVO cts_segmentsVO = new CTS_SEGMENTVO();
	try
	{
		// added by nour for #864398
		if (criteria.getIsSegmentationScore() != null && criteria.getIsSegmentationScore().contains("CSC00"))
		{
			criteria.setIsSegmentationScore("SC");
		}
		else if (criteria.getIsSegmentationScore() != null && criteria.getIsSegmentationScore().contains("CSG00"))
		{
			criteria.setIsSegmentationScore("S");
		}
		else if (criteria.getIsSegmentationScore() != null && criteria.getIsSegmentationScore().contains("BR00CMT"))// added by nour for tp #864398

		{
			criteria.setIsSegmentationScore("BR");
		}
		// end nour
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setSearchCols(searchCol);
	    copyproperties(criteria);

	    // TODO set vo correct properties
	    // cts_segmentsVO.setCOMP_CODE(sessionCO.getCompanyCode());

	    List<String> colList = CustSegmentationConstant.custSegmentationStatusLst;
	    SelectSC lovCriteria = new SelectSC();
	    lovCriteria.setLanguage(sessionCO.getLanguage());
	    lovCriteria.setLovTypeId(CustSegmentationConstant.LOV_TYPE);

	    SessionCO sessionObject = returnSessionObject();

	    cts_segmentsVO.setCOMP_CODE(sessionObject.getCompanyCode());
	    cts_segmentsVO.setSEGMENT_CODE(criteria.getSegment_code());
	    cts_segmentsVO.setSEGMENT_TYPE(criteria.getIsSegmentationScore());
	    List<StatusCO> resultList = returnCommonLibBO().generateStatusList(cts_segmentsVO, colList, lovCriteria);
	    setGridModel(resultList);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }

    public Object getModel()
    {
	return criteria;
    }

    public CustSegmentationSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(CustSegmentationSC criteria)
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
}
