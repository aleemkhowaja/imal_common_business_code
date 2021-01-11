/**
 * @Auther:MarwanMaddah
 * @Date:Feb 2, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.link.LinkBO;
import com.path.dbmaps.vo.S_LINKVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.link.LinkSC;


public class LinkLookupAction extends LookupBaseAction
{
    
    private String column1, column2, column3, column4, column5;
    private LinkSC criteria = new LinkSC();
    private LinkBO linkBO;
    private List<S_LINKVO> links;
    
    /**
     * 
     */
    @Override
    public Object getModel()
    {
	return criteria;
    }
    
    /**
     * Build a Grid inside the LiveSearch ...
     */
    public String drawingLinksGrid()
    {
	try
	{
	    String[]  name    = { "s_linkVO.LINK_CODE", "s_linkVO.BRIEF_NAME_ENG", "s_linkVO.LONG_NAME_ENG","s_linkVO.BRIEF_NAME_ARAB", "s_linkVO.LONG_NAME_ARAB", "LINK_TO_CIF","LINK_TO_AMF"};
	    String[]  colType = { "number", "text", "text", "text", "text","text","text"};
	 //   Boolean[] hidden  = {false,false,false,false,false};
	    String[]  titles  = { getText("code_key"), getText("brief_name_key"),getText("long_name_key"),getText("Brief_name_arb_key"), getText("Long_Name_Arab"),getText("link_to_cif_key"), getText("link_to_amf_key") };

	    /**
	     * Defining The Grid ...
	     */
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Links_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/LinkLookupAction_loadLinksLookup");
	    lookup(grid, criteria, name, colType, titles); 
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    /**
     * This method is to get data from BO and load them in a grid inside the liveSearch component. 
     * @return
     */
    public String loadLinksLookup()
    {
	try
	{
	  SessionCO sessionCO = returnSessionObject();
	  setSearchFilter(criteria);
	  copyproperties(criteria);
	  criteria.setCompCode(sessionCO.getCompanyCode());
	  criteria.setLovType(new BigDecimal(200));
	  criteria.setLangCode(sessionCO.getLanguage());

	  if(getRecords() == 0)
	  {
	    setRecords(linkBO.linkCodeLkpCount(criteria));
	  }
	  links = linkBO.linkCodeLkpRecords(criteria);
	  setGridModel(links);
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
   
   
   
    /**
     * @return the column1
     */
    public String getColumn1()
    {
        return column1;
    }
    /**
     * @param column1 the column1 to set
     */
    public void setColumn1(String column1)
    {
        this.column1 = column1;
    }
    /**
     * @return the column2
     */
    public String getColumn2()
    {
        return column2;
    }
    /**
     * @param column2 the column2 to set
     */
    public void setColumn2(String column2)
    {
        this.column2 = column2;
    }
    /**
     * @return the column3
     */
    public String getColumn3()
    {
        return column3;
    }
    /**
     * @param column3 the column3 to set
     */
    public void setColumn3(String column3)
    {
        this.column3 = column3;
    }
    /**
     * @return the column4
     */
    public String getColumn4()
    {
        return column4;
    }
    /**
     * @param column4 the column4 to set
     */
    public void setColumn4(String column4)
    {
        this.column4 = column4;
    }
    /**
     * @return the column5
     */
    public String getColumn5()
    {
        return column5;
    }
    /**
     * @param column5 the column5 to set
     */
    public void setColumn5(String column5)
    {
        this.column5 = column5;
    }


    /**
     * @return the links
     */
    public List<S_LINKVO> getLinks()
    {
        return links;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(List<S_LINKVO> links)
    {
        this.links = links;
    }

    public LinkSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(LinkSC criteria)
    {
        this.criteria = criteria;
    }

    public void setLinkBO(LinkBO linkBO)
    {
        this.linkBO = linkBO;
    }


  
}
