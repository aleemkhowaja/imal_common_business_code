/**
 * 
 */
package com.path.actions.common.global360view;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.json.JSONException;

import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.global360view.DashboardCO;
import com.path.vo.common.global360view.DashboardSC;

/**
 * Copyright 2013, Path Solutions
 * Path Solutions retains all ownership rights to this source code 
 * 
 * @author: marwanmaddah
 *
 * DashAssetsLiabAccListAction.java used to
 */
public class DashboardGridsListAction extends GridBaseAction
{
    //private DashboardBO dashboardBO;
    private DashboardSC criteria           = new DashboardSC();
    private List<DashboardCO> girdDataList = new ArrayList<DashboardCO>();

    public Object getModel()
    {
    	return criteria; 
    }

        /**
	 * Used for getting Links Management List Details Grid for LinksManagementList.jsp
	 * @return
	 * @throws JSONException
	 */
	public String loadAssetsLiabAccGrid() throws JSONException
	{
	      String[] searchCol = {"category","totalNbrAcc","currentBalance","availableBalance","blockedAmount","overdrawLimit"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
		        copysearchproperties(criteria);
			
		        copyproperties(criteria);
		        
		        criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setLangCode(sessionCO.getLanguage());
			criteria.setAppName(sessionCO.getCurrentAppName());
			criteria.setProgRef(get_pageRef());
			criteria.setIvCrud(getIv_crud());

			/**
			 *  return the collection of records
			 */
//			DashboardCO assestsCO = new DashboardCO();
//			assestsCO.setCategory(getText("assets_key"));
//			assestsCO.setTotalNbrAcc(new BigDecimal(5));
//			assestsCO.setCategoryId(BigDecimal.ONE);
//			girdDataList.add(assestsCO);
//			
//			DashboardCO liabilitiesCO = new DashboardCO();
//			liabilitiesCO.setCategory(getText("liabilities_key"));
//			liabilitiesCO.setTotalNbrAcc(new BigDecimal(10));
//			liabilitiesCO.setCategoryId(BigDecimal.ZERO);
//			girdDataList.add(liabilitiesCO);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(girdDataList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in assets and liabilities accounts Grid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
        /**
	 * Used for getting Links Management List Details Grid for LinksManagementList.jsp
	 * @return
	 * @throws JSONException
	 */
	public String loadFinAppAndApprvdLinesGrid() throws JSONException
	{
	      String[] searchCol = {"category","totalNbrAcc","currentBalance","availableBalance","blockedAmount","overdrawLimit"};
	      try
		{
			/**
			 *  copy the details related to search criteria to the SC
			 */
		        SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
		        copysearchproperties(criteria);
			
		        copyproperties(criteria);
		        
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setBranchCode(sessionCO.getBranchCode());
			criteria.setLangCode(sessionCO.getLanguage());
			criteria.setAppName(sessionCO.getCurrentAppName());
			criteria.setProgRef(get_pageRef());
			criteria.setIvCrud(getIv_crud());
			
			DashboardCO theCO = new DashboardCO();
			


			/**
			 *  return the collection of records
			 */
			 
			girdDataList.add(theCO);
			
			/**
			 *  set the collection into gridModel attribute defined at JSP grid tag
			 */
			setGridModel(girdDataList);
			
		}
		catch(Exception e)
		{
			log.error(e, "Error in assets and liabilities accounts Grid");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	/**
	 * Used for getting Links Management List Details Grid for LinksManagementList.jsp
	 * @return
	 * @throws JSONException
	 */
	public String loadInvestTreasuryGrid() throws JSONException
	{
	    String[] searchCol = {"investTreasury_cash","investTreasury_holding","investTreasury_forex","investTreasury_moneyMarket","investTreasury_islamicDerivatives","investTreasury_sukuk"};
	    try
	    {
		/**
		 *  copy the details related to search criteria to the SC
		 */
		SessionCO sessionCO = returnSessionObject();
		criteria.setSearchCols(searchCol);
		copysearchproperties(criteria);
		
		copyproperties(criteria);
		
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setAppName(sessionCO.getCurrentAppName());
		criteria.setProgRef(get_pageRef());
		criteria.setIvCrud(getIv_crud());
		
		/**
		 *  return the collection of records
		 */
		DashboardCO theCO = new DashboardCO();
		girdDataList.add(theCO);
		
		/**
		 *  set the collection into gridModel attribute defined at JSP grid tag
		 */
		setGridModel(girdDataList);
		
	    }
	    catch(Exception e)
	    {
		log.error(e, "Error in assets and liabilities accounts Grid");
		handleException(e, null, null);
	    }
	    return SUCCESS;
	}
	/**
	 * 
	 * @author marwanmaddah
	 * @date   Apr 23, 2013
	 * @return
	 * @throws JSONException String
	 *
	 */
	public String loadFinancingDealsGrid() throws JSONException
	{
	    
	    try
	    {
 
		SessionCO sessionCO = returnSessionObject();		
		criteria.setCompCode(sessionCO.getCompanyCode());
		criteria.setLangCode(sessionCO.getLanguage());
		criteria.setAppName(sessionCO.getCurrentAppName());
		criteria.setProgRef(get_pageRef());
		criteria.setIvCrud(getIv_crud());
		
		/**
		 * Call BO layer
		 */
		DashboardCO financingDeals = null;
		for(int i=0;i<4;i++)
		{
		    financingDeals = new DashboardCO();
		    girdDataList.add(financingDeals);
		}
		
		
//		dashboardBO.returnFinanciingDealsList(criteria);
		/**
		 *  set the collection into gridModel attribute defined at JSP grid tag
		 */
		setGridModel(girdDataList);
		
	    }
	    catch(Exception e)
	    {
		log.error(e, "Error in assets and liabilities accounts Grid");
		handleException(e, null, null);
	    }
	    return SUCCESS;
	}

	/**
	 * @return the criteria
	 */
	public DashboardSC getCriteria()
	{
	    return criteria;
	}
	/**
	 * @param criteria the criteria to set
	 */
	public void setCriteria(DashboardSC criteria)
	{
	    this.criteria = criteria;
	}
	/**
	 * @return the girdDataList
	 */
	public List<DashboardCO> getGirdDataList()
	{
	    return girdDataList;
	}
	/**
	 * @param girdDataList the girdDataList to set
	 */
	public void setGirdDataList(List<DashboardCO> girdDataList)
	{
	    this.girdDataList = girdDataList;
	}

	/**
	 * @param dashboardBO the dashboardBO to set
	 */
//	public void setDashboardBO(DashboardBO dashboardBO)
//	{
//	    this.dashboardBO = dashboardBO;
//	}

}
