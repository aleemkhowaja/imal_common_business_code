package com.path.core.actions.criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.criteria.CriteriaBO;
import com.path.bo.core.criteria.CriteriaConstant;
import com.path.bo.core.segmentation.CustSegmentationConstant;
import com.path.bo.reporting.CommonReportingBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.PathPropertyUtil;
import com.path.lib.common.util.StringUtil;
import com.path.lib.remote.RmiServiceCaller;
import com.path.lib.vo.GridUpdates;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.criteria.CriteriaCO;
import com.path.vo.core.criteria.CriteriaParamCO;
import com.path.vo.core.criteria.CriteriaSC;
import com.path.vo.reporting.DynLookupSC;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: tonyelkhoury extends GridBaseAction: which holds all the parameters
 *          needed for the JSON to parse the result and render the grid.
 *          GridBaseAction extends BaseAction which holds the method
 *          copyProperties in which the search statement is being constructed.
 */
public class CriteriaListAction extends LookupBaseAction//GridBaseAction //By Bilal For TP#750884 b*b
{

    private List<CriteriaCO> criteriaCOList = new ArrayList<CriteriaCO>();
    private List<CriteriaParamCO> criteriaParamCOList = new ArrayList<CriteriaParamCO>();
    private CriteriaSC criteriaSC = new CriteriaSC();
    private CriteriaBO criteriaBO;
    DynLookupSC dynLookupSC = new DynLookupSC();

    public void setCriteriaBO(CriteriaBO criteriaBO)
    {
	this.criteriaBO = criteriaBO;
    }

    /***
     * Returns the model of main grid
     */
    @Override
    public Object getModel()
    {
	return criteriaSC;
    }

    /**
     * 
     * 
     * @throws BaseException
     */
    public String loadCriteriaGrid()
    {
	String[] searchCol = { "CRITERIA_CODE", "CRITERIA_DESC" ,"CRITERIA_REFERENCE"};//bug 969312
	HashMap<String, String> dateSearchCol = new HashMap<String, String>();

	try
	{
	    System.out.println("\n\n\n\n\nj ================= \n\n\n\n\n\n\n\n");
	    SessionCO sessionCO = returnSessionObject();
	    criteriaSC.setSearchCols(searchCol);
	    criteriaSC.setCompCode(sessionCO.getCompanyCode());
	    criteriaSC.setBranchCode(sessionCO.getBranchCode());
	    criteriaSC.setAppName(sessionCO.getCurrentAppName());
	    criteriaSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
	    criteriaSC.setIvCrud(getIv_crud());
	    criteriaSC.setLang(sessionCO.getLanguage());
	    
	    //by bilal for TP#750884
	    if(get_pageRef().contains("CSG00"))
		{
			criteriaSC.setIsSegmentationScore("O");
		}
		else if(get_pageRef().contains("BR00"))
		{
			criteriaSC.setIsSegmentationScore("B");
		}
	    //end bilal
	    
	    /*
	     * for date column in the toolbar search, we must add it to the
	     * hashmap of date columns in our SC,otherwise the searching on this
	     * date column will not work as needed
	     */
	    dateSearchCol.put("DATE_CREATED", "DATE_CREATED");
	    criteriaSC.setDateSearchCols(dateSearchCol);

	    // copy the details related to search criteria to the SC
	    copyproperties(criteriaSC);

	    // if(!NumberUtil.isEmptyDecimal(sessionCO.getScannedCIFNo()))
	    // {
	    // criteriaSC.setScannedCIF(sessionCO.getScannedCIFNo());
	    // }

	    /*
	     * set number of rows to be displayed in the page of grid, and the
	     * total number of records for first time load only and on reset of
	     * search results
	     */
	    if(checkNbRec(criteriaSC))
	    {
		setRecords(criteriaBO.returnCriteriaListCount(criteriaSC));
	    }

	    /*
	     * return the collection of records
	     */
	    criteriaCOList = criteriaBO.returnCriteriaList(criteriaSC);

	    /*
	     * set the collection into gridModel attribute defined at JSP grid
	     * tag gridModel: the result list that contains the actual data
	     */
	    setGridModel(criteriaCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    public String loadParamGrid()
    {

	String[] searchCol = { "PARAM_TYPE", "PARAM_NAME" };
	HashMap<String, String> dateSearchCol = new HashMap<String, String>();
	
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    criteriaSC.setSearchCols(searchCol);
	    criteriaSC.setCompCode(sessionCO.getCompanyCode());
	     criteriaSC.setBranchCode(sessionCO.getBranchCode()); //By Bilal For TP#750884 
	    criteriaSC.setAppName(sessionCO.getCurrentAppName()); 
	    criteriaSC.setProgRef(returnCommonLibBO().returnOrginProgRef(sessionCO.getCurrentAppName(), get_pageRef()));
	    criteriaSC.setIvCrud(getIv_crud());
	    criteriaSC.setLang(sessionCO.getLanguage());

	    dateSearchCol.put("DATE_CREATED", "DATE_CREATED");
	    criteriaSC.setDateSearchCols(dateSearchCol);

	    copyproperties(criteriaSC);

	    // if("true".equals(criteriaCO.getEditMode()))
	    // {

//	    if(checkNbRec(criteriaSC))
//	    {
//		setRecords(criteriaBO.returnCriteriaParamListCount(criteriaSC));
//	    }
	    
	    criteriaParamCOList = criteriaBO.returnCriteriaParamList(criteriaSC);
	    
//	    //By Bilal For TP#750884 
    	for(int i=0; i < criteriaParamCOList.size(); i++)
	    {	
    		//By Bilal For TP#750884 replace param
    		if("M".equals(criteriaParamCOList.get(i).getCtsCriteriaParamVO().getENTITY_TYPE()))
    		{
    			criteriaParamCOList.get(i).setQuerySelectParamGridStr("{\"root\":".concat(PathJSONUtil
        			    .serialize(criteriaParamCOList.get(i), null, null, false, true))
        			    .concat("}"));
    		}
    		else
    		{
    			if(CriteriaConstant.PARAM_CLASS_Q.equals(criteriaParamCOList.get(i).getCtsCriteriaParamVO().getPARAM_CLASS()))
        		{
        			criteriaSC.setCRITERIA_CODE(criteriaParamCOList.get(i).getCtsCriteriaParamVO().getCRITERIA_CODE());
        	    	criteriaSC.setQueryId(criteriaParamCOList.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
        	    	criteriaParamCOList.get(i).setOldQueryIdParam(criteriaParamCOList.get(i).getCtsCriteriaParamVO().getPARAM_QUERY_ID());
        	    	criteriaParamCOList.get(i).setJsonMultiselectArray("{\"root\":".concat(PathJSONUtil
                			    .serialize(criteriaBO.loadMultiSelectListGrid(criteriaSC), null, null, false, true))
                			    .concat("}"));
        		}
        		else
        		{
        			criteriaParamCOList.get(i).getCtsCriteriaParamVO().setPARAM_QUERY_ID(null);
        		}	
    		}
			//end
	    }
	    
	    if(checkNbRec(criteriaSC))
	    {
		setRecords(criteriaParamCOList == null ? 0 : criteriaParamCOList.size());
	    }

	    // else
	    // {
	    //
	    // if(checkNbRec(criteriaSC))
	    // {
	    // setRecords(criteriaBO.returnCriteriaParamNewListCount(criteriaSC));
	    // }
	    //
	    // criteriaParamCOList =
	    // criteriaBO.returnCriteriaNewParamList(criteriaSC);
	    //
	    // }

	    setGridModel(criteriaParamCOList);

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;
    }
    
    //By Bilal For TP#750884
    public String constructQryMultiSelect()
    {
	
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "PARAM_VALUE","PARAM_NAME"};
	    String[] colType = { "text", "text"};
	    String[] titles = { getText("code_key"),getText("desc_key")};
	    String[] rowList = {"10", "20", "50", "100"};
	    
	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("List Value Of Param"));
	    grid.setRowNum("10");
	    grid.setRowList(rowList);
	    grid.setShrinkToFit("true");
	    grid.setUrl("/path/criteria/criteriaList_fillQryMultiSelect");
	    lookup(grid, criteriaSC, name, colType, titles);
	}
	catch(Exception e)
	{
	    log.error(e, "Error in constructLookup of constructQryMultiSelect");
	    handleException(e, null, null);
	}
	
	return SUCCESS;
	
    }
    
    /**
     * Fill the lookup 
     *
     * @return
     * @throws JSONExceptionr
     * 
     */
    public String fillQryMultiSelect()
	{
		HashMap<String, String> hmQryParam = new HashMap<String, String>();
		HashMap<String, Object> dynLookupSCMap = new HashMap<String, Object>();
		SessionCO sessionCO = returnSessionObject();
		List<CriteriaParamCO> listSelectParam;
		ArrayList<LinkedHashMap> lstMultiSelect;
		
		try {
			String[] searchCol = { "PARAM_VALUE","PARAM_NAME" };
			dynLookupSC.setSearchCols(searchCol);
			dynLookupSC.setIsSybase(returnCommonLibBO().returnIsSybase());
			dynLookupSC.setQryId(criteriaSC.getQueryId().toString());
			criteriaSC.setCompCode(sessionCO.getCompanyCode());
			criteriaSC.setBranchCode(sessionCO.getBranchCode());
			criteriaSC.setENTITY_TYPE("M");
			
			String reportUrl;
			reportUrl = PathPropertyUtil.returnPathPropertyFromFile("PathRemoting.properties", "reporting.serviceURL");
			if (reportUrl == null) {
				throw new BOException("Invalid reporting URL");
			}
			String checkReportingUrlService = reportUrl.concat("commonReportingBOService");
			CommonReportingBO commonReportingBO = (CommonReportingBO) RmiServiceCaller
					.returnRmiInterface(checkReportingUrlService, CommonReportingBO.class);
			
			if(criteriaSC.getQueryId() != null && !NumberUtil.isEmptyDecimal(criteriaSC.getQueryId()))
			{
				BigDecimal entityId = criteriaSC.getQueryId();
				HashMap<String, Object> hashIn = new HashMap<String, Object>();
				hashIn.put("queryId", entityId);
				ArrayList<HashMap<String, Object>> hashList = commonReportingBO.returnArgListByQryId(hashIn);
				if (hashList != null && hashList.size() > 0)
				{
					if(StringUtil.isNotEmpty(criteriaSC.getQuerySelectParamGridStr()))
					{
						GridUpdates guMultiselectParam = getGridUpdates(criteriaSC.getQuerySelectParamGridStr(),CriteriaParamCO.class, true);
						listSelectParam = (List<CriteriaParamCO>) guMultiselectParam.getLstAllRec();
					}
					else
					{
						listSelectParam = criteriaBO.returnReplaceArgumentSelect(criteriaSC);
					}
					
					if(listSelectParam != null && listSelectParam.size() > 0)
					{
						for(int i=0; i < listSelectParam.size(); i++)
					    {
							hmQryParam.put(listSelectParam.get(i).getCtsCriteriaParamVO().getPARAM_NAME(), listSelectParam.get(i).getCtsCriteriaParamVO().getPARAM_VALUE());
					    }
					}
					else
					{
						throw new BOException("Please fill missing values in param details");
					}
				}
				else
				{
					hmQryParam = new HashMap<String, String>();
				}
					
				//hmQryParam.put("CompanyCode", "1405");
				dynLookupSC.setHmQryParam(hmQryParam);
				dynLookupSC.setCompCode(sessionCO.getCompanyCode());
				dynLookupSC.setBranchCode(sessionCO.getBranchCode());
				dynLookupSC.setUserId(sessionCO.getUserName());
				dynLookupSC.setCurrAppName(sessionCO.getCurrentAppName());
				copyproperties(dynLookupSC);
				String[] propsArr = ConstantsCommon.returnQryResult_PROPS
						.toArray(new String[ConstantsCommon.returnQryResult_PROPS.size()]);
				PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap, false, propsArr);

				if (getRecords() == 0) {
					int nbrec = commonReportingBO.returnQryResultCnt(dynLookupSCMap);
					dynLookupSC.setNbRec(nbrec);
					dynLookupSC.setRecToskip(0);
					setRecords(nbrec);
				}
				PathPropertyUtil.copyProperties(dynLookupSC, dynLookupSCMap, false, propsArr);
				lstMultiSelect = commonReportingBO.returnQryResult(dynLookupSCMap);
				setGridModel(lstMultiSelect);
			}
		
			
		} catch (Exception e) {
			log.error(e, "Error in fillLookupData of BranchesLookupAction");
			handleException(e, null, null);
		}

		return SUCCESS;
	}
    //end
    
    public List<CriteriaCO> getCriteriaCOList()
    {
	return criteriaCOList;
    }

    public void setCriteriaCOList(List<CriteriaCO> criteriaCOList)
    {
	this.criteriaCOList = criteriaCOList;
    }

    public CriteriaSC getCriteriaSC()
    {
	return criteriaSC;
    }

    public void setCriteriaSC(CriteriaSC criteriaSC)
    {
	this.criteriaSC = criteriaSC;
    }

    public List<CriteriaParamCO> getCriteriaParamCOList()
    {
	return criteriaParamCOList;
    }

    public void setCriteriaParamCOList(List<CriteriaParamCO> criteriaParamCOList)
    {
	this.criteriaParamCOList = criteriaParamCOList;
    }

}
