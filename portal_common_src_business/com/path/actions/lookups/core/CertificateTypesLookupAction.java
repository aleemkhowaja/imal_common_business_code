package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.certificatetypes.CertificateTypesBO;
import com.path.dbmaps.vo.CTSCERTIFICATE_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.certificatetypes.CertificateTypesSC;


public class CertificateTypesLookupAction extends LookupBaseAction 
{
	private final CertificateTypesSC certificateTypesSC = new CertificateTypesSC();
	private CertificateTypesBO certificateTypesBO;
	
	
	@Override
	public Object getModel()
	{
		return certificateTypesSC;
	}
	
	/**
	 * Construct Certificate Types Lookup
	 * @return
	 */
	public String constructLookup() {

		try 
		{
			// Types the Grid by defining the column model and column names
			String[] name = { "CODE", "BRIEF_DESC_ENG", "BRIEF_DESC_ARAB"};
			String[] colType = { "number", "text", "text"};
			String[] titles = { getText("Code__key"), getText("Brief_Description_key"), getText("Brief_Desc_Arab_key")};

			if(returnSessionObject().getHideArabicColumns())
			    {
				name = new String[] {  "CODE", "BRIEF_DESC_ENG"};
				colType = new String[] {  "number", "text"};
				titles = new String[] { getText("Code__key"), getText("Brief_Description_key")};
					
			    }
			
			// Defining the Grid
			LookupGrid grid = new LookupGrid();
			grid.setCaption(getText("TypesList"));
			grid.setRowNum("5");
			grid.setUrl("/pathdesktop/CertificateTypeLookup_fillCertificateLkp");
						 
			/*int cols = name.length;

			for (int i = 0; i < cols; i++)
			{
				// Defining each column
				LookupGridColumn gridColumn = new LookupGridColumn();
				gridColumn.setName(name[i]);
				gridColumn.setIndex(name[i]);
				gridColumn.setColType(colType[i]);
				gridColumn.setTitle(titles[i]);
				gridColumn.setSearch(true);
				// adding column to the list
				lsGridColumn.add(gridColumn);
				
			}
			lookup(grid, lsGridColumn, null, certificateTypesSC);
			*/
			 lookup(grid, certificateTypesSC, name, colType, titles); 
		} 
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

		return SUCCESS;

	}

	/**
	 * Fill the lookup Types data filtered by user.
	 * @return
	 * 
	 */
	public String fillCertificateLkp() 
	{
		try {
		    	List<CTSCERTIFICATE_TYPEVO> typesVOList;
			setSearchFilter(certificateTypesSC);
			copyproperties(certificateTypesSC);
			
			SessionCO sessionCO = returnSessionObject();
			certificateTypesSC.setUserId(sessionCO.getUserName());
			certificateTypesSC.setCompCode(sessionCO.getCompanyCode());
			
			if (getRecords() == 0)
			{
				setRecords(certificateTypesBO.getcertificateypesCount(certificateTypesSC));
			}
			typesVOList = certificateTypesBO.getcertificateTypesList(certificateTypesSC);
			// set the collection into gridModel attribute defined at JSP grid
			setGridModel(typesVOList);

		} 
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
		return SUCCESS;
	}

	

	public void setCertificateTypesBO(CertificateTypesBO certificateTypesBO)
	{
	    this.certificateTypesBO = certificateTypesBO;
	}
    
}
