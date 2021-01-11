package com.path.actions.lookups.core;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.path.bo.core.printreports.PrintReportsBO;
import com.path.lib.common.exception.BaseException;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.printreports.PrintReportsSC;

public class PrintReportsLookupAction extends LookupBaseAction {
	
    private PrintReportsSC criteria = new PrintReportsSC(); //ctstrsUploadSC
    private PrintReportsBO printReportsBO;
    private Integer  fileTypeReportCount;

    private String printReportsGridUrl;

    @Override
    public Object getModel()
    {
	return criteria;
    }
   
    /**
     * Set the Print Reports URL and load the  Print Reports Jsp Page...
     * 
     * @return
     */
    public String constructPrintReportsGrid()
    {
	try
	{
	    ServletContext application = ServletActionContext.getServletContext();
	    String theRealPath = application.getContextPath();
	    //here we are storing the Grid Url of the Gird and resending the parameters 
	    printReportsGridUrl = theRealPath + "/pathdesktop/PrintReports_loadPrintReportsGrid?_pageRef="+get_pageRef()+"&filteType="+criteria.getFilteType()+"&printingLevel="+criteria.getPrintingLevel();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "printReportsGird";
    }
    
    /**
     * get data from Database, convert them to be compatible with CTSTRXTYPEVO, get
     * HTML and set the Model.
     * 
     * @return
     */
    public String loadPrintReportsGrid()
    {
	String[] searchCol = {"REP_ID", "TITLE","ARG_ID"};
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setSearchCols(searchCol);
//	    setSearchFilter(criteria);
//	    criteria.setPreferredLanguage(sessionCO.getPreferredLanguage());
	    copyproperties(criteria);
	    if(checkNbRec(criteria))
	    {
		setRecords(printReportsBO.printReportsListCount(criteria));
	    }
	    // set the collection into gridModel attribute defined at JSP grid
	    setGridModel(printReportsBO.printReportsList(criteria));
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String returnFileTypeReportCount() throws BaseException
    {
	try
 	{
	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setNbRec(-1);
	    fileTypeReportCount = printReportsBO.printReportsListCount(criteria);
 	}
 	catch(Exception e)
 	{
 	    handleException(e, null, null);
 	}
 	return SUCCESS;
    }

    
  

    public String getPrintReportsGridUrl()
    {
        return printReportsGridUrl;
    }

    public void setPrintReportsGridUrl(String printReportsGridUrl)
    {
        this.printReportsGridUrl = printReportsGridUrl;
    }
    public void setPrintReportsBO(PrintReportsBO printReportsBO)
    {
        this.printReportsBO = printReportsBO;
    }


    public PrintReportsSC getCriteria()
    {
        return criteria;
    }


    public void setCriteria(PrintReportsSC criteria)
    {
        this.criteria = criteria;
    }

    public Integer getFileTypeReportCount()
    {
        return fileTypeReportCount;
    }

    public void setFileTypeReportCount(Integer fileTypeReportCount)
    {
        this.fileTypeReportCount = fileTypeReportCount;
    }



   
}
