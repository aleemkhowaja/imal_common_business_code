package com.path.core.actions.segmentation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import com.path.bo.core.segmentation.CustSegmentationBO;
import com.path.bo.core.segmentation.CustSegmentationConstant;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.GridBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.segmentation.CustSegmentationCO;
import com.path.vo.core.segmentation.CustSegmentationParamCO;
import com.path.vo.core.segmentation.CustSegmentationSC;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to this source code
 * 
 * CustSegmentationListAction.java used to
 */
public class CustSegmentationListAction extends GridBaseAction
{

	private CustSegmentationBO custSegmentationBO;
	private CustSegmentationSC criteria = new CustSegmentationSC();
	private CustSegmentationCO custSegmentationCO = new CustSegmentationCO();

	private BigDecimal segmentCode;

	public String loadCustSegmentationGrid()
	{
		try
		{
			SessionCO sessionObject = returnSessionObject();
			String[] searchCol = { "COMP_CODE", "BRANCH_CODE", "SEGMENT_CODE", "SEGMENT_DESCR", "PRIORITY", "statusdesc", "CREATED_BY", "MODIFIED_BY",
					"APPROVED_BY", "REJECTED_BY", "OLD_STATUS" };
			HashMap<String, String> hmDate = new HashMap<String, String>();
			hmDate.put("DATE_CREATED", "DATE_CREATED");
			hmDate.put("DATE_MODIFIED", "DATE_MODIFIED");
			hmDate.put("DATE_UPDATED", "DATE_UPDATED");
			hmDate.put("DATE_APPROVED", "DATE_APPROVED");
			hmDate.put("DATE_REJECTED", "DATE_REJECTED");
			// SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			criteria.setDateSearchCols(hmDate);
			criteria.setLanguage(sessionObject.getLanguage());
			criteria.setLovTypeId(CustSegmentationConstant.LOV_TYPE);
			criteria.setSectionKey(get_pageRef());
			criteria.setCurrAppName(sessionObject.getCurrentAppName());
			criteria.setCompCode(sessionObject.getCompanyCode());
			criteria.setIsSegmentationScore(returnSegmentType()); // Rania - 718813 - Dynamic Customer Scoring on latest

			copyproperties(criteria);
			if (checkNbRec(criteria))
			{
				setRecords(custSegmentationBO.returnCustSegmentationListCount(criteria));
			}
			setGridModel(custSegmentationBO.returnCustSegmentationList(criteria));
		}
		catch (Exception e)
		{
			log.error(e, "Error in loadCustSegmentationGrid of CustSegmentationListAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	public String loadCustSegmentationDetailSubGrid()
	{
		try
		{
			SessionCO sessionCO = returnSessionObject();

			if (criteria.getSegmentCode() != null)
			{
				criteria.setSegment_code(criteria.getSegmentCode());
				criteria.setCompCode(sessionCO.getCompanyCode());
				criteria.setBranchCode(sessionCO.getBranchCode());
			}

			if (criteria.getSegment_code() == null)
			{
				setRecords(0);
				setGridModel(null);
			}
			else
			{
				criteria.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
				copyproperties(criteria);
				if (checkNbRec(criteria))
				{
					setRecords(custSegmentationBO.returnCustSegmentationDetailListCount(criteria));
				}
				setGridModel(custSegmentationBO.returnCustSegmentationDetailList(criteria));

				// List<CustSegmentationCO> gridModel = new
				// ArrayList<CustSegmentationCO>();
				//
				// gridModel = getGridModel();
				//
				//
				// String displayExpression = "";
				// for(int i = 0; i < gridModel.size(); i++)
				// {
				// CustSegmentationCO custSegCO = gridModel.get(i);
				//
				// if (custSegCO.getCtsSegmentDetVO().getLOGICAL_OPERATOR() !=
				// null) {
				// displayExpression.concat( " " +
				// custSegCO.getCtsSegmentDetVO().getLOGICAL_OPERATOR());
				// }
				// if (custSegCO.getCtsSegmentDetVO().getLEFT_OPERATOR() !=
				// null) {
				// displayExpression.concat( " " +
				// custSegCO.getCtsSegmentDetVO().getLEFT_OPERATOR());
				// }
				// if (custSegCO.getCtsSegmentDetVO().getCRITERIA_CODE() !=
				// null) {
				// displayExpression.concat(" " +
				// custSegCO.getCtsSegmentDetVO().getCRITERIA_CODE().toString());
				// }
				// if (custSegCO.getCtsSegmentDetVO().getRIGHT_OPERATOR() !=
				// null) {
				// displayExpression.concat( " " +
				// custSegCO.getCtsSegmentDetVO().getRIGHT_OPERATOR());
				// }
				// }

			}

			custSegmentationCO.setParamIsOpen(0);

		}
		catch (Exception e)
		{
			log.error(e, "Error in loadCustSegmentationDetailSubGrid of CustSegmentationDetailListAction");
			handleException(e, null, null);
		}
		return "loadGrid"; // loadJson
	}

	public String loadSegParamGrid()
	{

		String[] searchCol = { "PARAM_TYPE", "PARAM_NAME" };
		HashMap<String, String> dateSearchCol = new HashMap<String, String>();

		try
		{
			SessionCO sessionCO = returnSessionObject();
			criteria.setSearchCols(searchCol);
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setBranchCode(sessionCO.getBranchCode());

			dateSearchCol.put("DATE_CREATED", "DATE_CREATED");
			criteria.setDateSearchCols(dateSearchCol);
			set_pageRef(criteria.getProgRef());
			criteria.setIsSegmentationScore(returnSegmentType()); //Rania - 718813 - Dynamic Customer Scoring on latest
			copyproperties(criteria);

			List<CustSegmentationParamCO> custSegmentationParamListCO = custSegmentationBO.returnSegmentationParamList(criteria);

			if (checkNbRec(criteria))
			{
				setRecords(custSegmentationParamListCO == null ? 0 : custSegmentationParamListCO.size());
			}

			setGridModel(custSegmentationParamListCO);

		}
		catch (Exception e)
		{
			handleException(e, null, null);
		}

		return SUCCESS;
	}

	public String loadCustSegmentationProcessGrid()
	{
		try
		{
		    	
		    String[] searchCol = { "branchCode","CIF_NO","RECOMMENED_SEGMENT","recomendedPriority", "recommendedGroupCode", "currentSegment",
			    			"currentPriority", "currentGroupCode", "STATUS","CREATED_DATE"};
		    
		    HashMap<String, String> hmDate = new HashMap<String, String>();
		    hmDate.put("CREATED_DATE", "CREATED_DATE");
		    
		    criteria.setSearchCols(searchCol);
		    criteria.setDateSearchCols(hmDate);
		    copyproperties(criteria);

			// if(((NumberUtil.isEmptyDecimal(criteria.getFromBranch())
			// && NumberUtil.isEmptyDecimal(criteria.getToBranch())
			// && NumberUtil.isEmptyDecimal(criteria.getFromCif())
			// && NumberUtil.isEmptyDecimal(criteria.getToCif()))
			// && !"R".equals(criteria.getIvCrud())))
			// {
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());
			criteria.setUserId(sessionCO.getUserName());
			criteria.setLovTypeId(CustSegmentationConstant.LOV_TYPE);
			criteria.setSectionKey(get_pageRef());
			criteria.setCurrAppName(sessionCO.getCurrentAppName());
			criteria.setLanguage(sessionCO.getLanguage());
			criteria.setStatus("A");
			criteria.setProcessType(StringUtil.nullEmptyToValue(criteria.getProcessType(), "FP"));
			criteria.setBranchCode(sessionCO.getBranchCode());
			criteria.setRunningDate(sessionCO.getRunningDateRET());
			criteria.setAppName(sessionCO.getCurrentAppName());
			criteria.setProgRef("CSG00SEGSPMT");
			
			if(get_pageRef().contains("CSG00SEG"))
			{
			    criteria.setIsSegmentationScore("S");
			}
			
			if (!get_pageRef().equals("CSG00SEGSPP") && !"true".equals(criteria.get_search()))
			{
				custSegmentationBO.loadCustSegmentationProcessGrid(criteria);
			}

			if (checkNbRec(criteria))
			{
			    	
				setRecords(custSegmentationBO.returnCustSegmentationProcessListCount(criteria));
			}
			setGridModel(custSegmentationBO.returnCustSegmentationProcessList(criteria));
			// }
		}
		catch (Exception e)
		{
			log.error(e, "Error in loadCustSegmentationProcessGrid of CustSegmentationDetailListAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}

	/**
	 * @author raniaalbitar
	 * 718813 - Dynamic Customer Scoring on latest
	 */
	
	public String returnSegmentType()
	{
		String isSegmentScore = "S";

		if (get_pageRef() != null && get_pageRef().contains("CSC00"))
		{
			isSegmentScore = "SC";
		}
		else if (get_pageRef() != null && get_pageRef().contains("CSG00"))
		{
			isSegmentScore = "S";
		}

		return isSegmentScore;
	}
	public Object getModel()
	{
		return criteria;
	}

	public BigDecimal getSegmentCode()
	{
		return segmentCode;
	}

	public void setSegmentCode(BigDecimal segmentCode)
	{
		this.segmentCode = segmentCode;
	}

	public CustSegmentationSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(CustSegmentationSC criteria)
	{
		this.criteria = criteria;
	}

	public void setCustSegmentationBO(CustSegmentationBO custSegmentationBO)
	{
		this.custSegmentationBO = custSegmentationBO;
	}

}
