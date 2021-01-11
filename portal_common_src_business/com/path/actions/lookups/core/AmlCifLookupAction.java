/**
 * @Auther:Nour
 * @Date:Mar 6, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.actions.lookups.core;

import java.util.ArrayList;
import java.util.List;
import com.path.bo.core.amlcif.AmlCifBO;
import com.path.dbmaps.vo.AML_CUSTOMERVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.cif.CifSC;
import net.sf.json.JSONException;

/**
 * @author Nour
 * 
 */
public class AmlCifLookupAction extends LookupBaseAction
{

	private CifSC criteria = new CifSC();
	private AmlCifBO amlCifBO;
	private List<AML_CUSTOMERVO> cifVOList;

	/**
	 * 
	 */
	@Override
	public Object getModel()
	{
		return criteria;
	}

	/**
	 * Construct CIF Lookup based on the VO returned in the resultMap. w_lookup_cif
	 * 
	 * @return String
	 */
	public String constructBankCifLookup()
	{
		try
		{
			// Design the Grid by defining the column model and column names
			String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "CIF_TYPE", "ADDITIONAL_REFERENCE" };

			String[] index = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "CIF_TYPE", "ADDITIONAL_REFERENCE" };

			String[] colType = { "number", "text", "text", "number", "text", "text", "text", "text" };

			String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"), getText("Cif_Type_key"), getText("Tel_key"),
					getText("Resident_key"), getText("Civil_ID_key"), getText("Additional_Reference_key") };

			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/AmlCifLookup_fillBankCifLookup");
			int cols = name.length;
			List<LookupGridColumn> gridColumnsList = new ArrayList<LookupGridColumn>();

			for (int i = 0; i < cols; i++)
			{
				// Defining each column
				LookupGridColumn gridColumn = new LookupGridColumn();
				gridColumn.setName(name[i]);
				gridColumn.setIndex(index[i]);
				gridColumn.setColType(colType[i]);
				gridColumn.setTitle(titles[i]);
				gridColumn.setSearch(true);
				// adding column to the list
				gridColumnsList.add(gridColumn);
			}
			lookup(grid, gridColumnsList, null, criteria);
		}
		catch (Exception e)
		{
			log.error(e, "Error in constructBankCifLookup of AssetsCifLookupAction");
		}

		return SUCCESS;
	}

	/**
	 * Fill the lookup CIF data filtered by the defined criteria
	 * 
	 * @return String
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	public String fillBankCifLookup() throws JSONException
	{
		try
		{
			setSearchFilter(criteria);
			copyproperties(criteria);
			SessionCO sessionCO = returnSessionObject();
			criteria.setCompCode(sessionCO.getCompanyCode());

			if (checkNbRec(criteria))
			{
				setRecords(amlCifBO.returnBankCifListCount(criteria));
			}

			cifVOList = amlCifBO.returnBankCIF(criteria);

			// set the collection into gridModel attribute defined at JSP grid
			setGridModel(cifVOList);

		}
		catch (Exception e)
		{
			log.error(e, "Error in fillBankCifLookup of AssetsCifLookupAction");
			handleException(e, null, null);
		}
		return SUCCESS;
	}
	
	
	 public String constructLookup()
	    {
		try
		{
			// Design the Grid by defining the column model and column names
			String[] name = { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "SHORT_NAME_ARAB", "LONG_NAME_ARAB", "TEL", "ID_NO", "CIF_TYPE",
					"ADDITIONAL_REFERENCE" };
			String[] colType = { "number", "text", "text", "text", "text", "text", "text", "text", "text" };
			String[] titles = { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"), getText("Short_Name_Arab_key"),
					getText("Long_Name_Arab_key"), getText("Tel_key"), getText("Id_No_key"), getText("Cif_Type_key"), getText("Additional_Reference_key") };

			if (returnSessionObject().getHideArabicColumns())
			{
				name = new String[] { "CIF_NO", "SHORT_NAME_ENG", "LONG_NAME_ENG", "TEL", "ID_NO", "CIF_TYPE", "ADDITIONAL_REFERENCE" };
				colType = new String[] { "number", "text", "text", "text", "text", "text", "text" };
				;
				titles = new String[] { getText("CIF_No_key"), getText("Short_Name_key"), getText("Long_Name__key"), getText("Tel_key"), getText("Id_No_key"),
						getText("Cif_Type_key"), getText("Additional_Reference_key") };
			}

		    // Defining the Grid
		    LookupGrid grid = new LookupGrid();
		    grid.setCaption(getText("cifList_key"));
		    grid.setRowNum("5");
		    grid.setUrl("/pathdesktop/AmlCifLookup_fillCifLookup");

		    List<LookupGridColumn> columnSpecs = returnStandarColSpecs(name, colType, titles);
		    columnSpecs.get(0).setLeadZeros("4");
		    columnSpecs.get(1).setLeadZeros("8");

		    lookup(grid, columnSpecs, null, criteria);
		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}

		return SUCCESS;

	    }
	 
	 /**
	     * Fill the lookup CIF data filtered by the defined criteria
	     * 
	     * @return
	     */
	    public String fillCifLookup()
	    {
		try
		{
		    setSearchFilter(criteria);
		    copyproperties(criteria);
		    SessionCO sessionCO = returnSessionObject();
		    criteria.setUserId(sessionCO.getUserName());
		    criteria.setCompCode(sessionCO.getCompanyCode());
		    criteria.setLang(sessionCO.getLanguage());
		    if((criteria.getSrchMapFldsOnly() != null) && criteria.getSrchMapFldsOnly().get("ID_NO") != null)
		    {

			criteria.setIdNoFilter(criteria.getSrchMapFldsOnly().get("ID_NO").toString());
		    }

		    
		    if (checkNbRec(criteria))
			{
			   setRecords(amlCifBO.cifListCount(criteria));
			}
			
			setGridModel(amlCifBO.cifList(criteria));
		    

		}
		catch(Exception e)
		{
		    handleException(e, null, null);
		}
		return SUCCESS;
	    }


	public CifSC getCriteria()
	{
		return criteria;
	}

	public void setCriteria(CifSC criteria)
	{
		this.criteria = criteria;
	}

	public void setAmlCifBO(AmlCifBO amlCifBO)
	{
		this.amlCifBO = amlCifBO;
	}

	
	public List<AML_CUSTOMERVO> getCifVOList()
	{
		return cifVOList;
	}

	
	public void setCifVOList(List<AML_CUSTOMERVO> cifVOList)
	{
		this.cifVOList = cifVOList;
	}

	
	
	

}
