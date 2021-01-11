package com.path.actions.lookups.core;

import java.math.BigDecimal;
import java.util.List;

import com.path.bo.core.avafilecompanion.AvaFileCompanionLkpBO;
import com.path.dbmaps.vo.CTS_AVA_FILE_COMPANIONVO;
import com.path.lib.vo.LookupGrid;
import com.path.lib.vo.LookupGridColumn;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.avafilecompanion.AvaFileCompanionLkpSC;

public class AvaFileCompanionLookupAction extends LookupBaseAction
{
    private AvaFileCompanionLkpBO avaFileCompanionLkpBO;
    private AvaFileCompanionLkpSC avaFileCompanionLkpSC = new AvaFileCompanionLkpSC();
    private BigDecimal filCode;
    private BigDecimal companioSeq;
    private CTS_AVA_FILE_COMPANIONVO ctsAvaFileCompanionVO;
    
    
    
    public CTS_AVA_FILE_COMPANIONVO getCtsAvaFileCompanionVO()
    {
        return ctsAvaFileCompanionVO;
    }

    public void setCtsAvaFileCompanionVO(CTS_AVA_FILE_COMPANIONVO ctsAvaFileCompanionVO)
    {
        this.ctsAvaFileCompanionVO = ctsAvaFileCompanionVO;
    }

    public BigDecimal getCompanioSeq()
    {
        return companioSeq;
    }

    public void setCompanioSeq(BigDecimal companioSeq)
    {
        this.companioSeq = companioSeq;
    }

    public BigDecimal getFilCode()
    {
        return filCode;
    }

    public void setFilCode(BigDecimal filCode)
    {
        this.filCode = filCode;
    }

    @Override
    public Object getModel()
    {
	return avaFileCompanionLkpSC;
    }

    public AvaFileCompanionLkpSC getAvaFileCompanionLkpSC()
    {
        return avaFileCompanionLkpSC;
    }

    public void setAvaFileCompanionLkpSC(AvaFileCompanionLkpSC avaFileCompanionLkpSC)
    {
        this.avaFileCompanionLkpSC = avaFileCompanionLkpSC;
    }

    public void setAvaFileCompanionLkpBO(AvaFileCompanionLkpBO avaFileCompanionLkpBO)
    {
        this.avaFileCompanionLkpBO = avaFileCompanionLkpBO;
    }
    
    /**
     * Method that construct the operation type lookup grid
     * @return
     */
    public String constructAccompanistLookup()
    {

	try
	{
	    String[] name = { "COMPANION_SEQ", "CIF_NO", "SHORT_NAME", "LONG_NAME", "ID_TYPE", "ID_NUMBER", "ADDRESS" };
	    String[] colType = { "number", "number", "text", "text", "number", "text", "text" };
	    String[] titles = { getText("Code__key"), getText("Cif_No_key"), getText("Short_Name_key"),
		    getText("Long_Name_key"), getText("Id_Type_key"), getText("ID_Number_key"),
		    getText("Address_Eng_key") };
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Accompanist"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/AvaFileCompanionLookupAction_fillAccompanistLkp");
	    List<LookupGridColumn> lsGridColumn = returnStandarColSpecs(name, colType, titles);
	    lsGridColumn.get(0).setHidden(true);
	    lookup(grid, lsGridColumn, null, avaFileCompanionLkpSC);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;

    }

    /**
     * Method that fills the the operation type lookup
     * @return
     */
    public String fillAccompanistLkp()
    {
	try
	{
	    List<CTS_AVA_FILE_COMPANIONVO> ctsAvaFileCompanionList;
	    setSearchFilter(avaFileCompanionLkpSC);
	    copyproperties(avaFileCompanionLkpSC);
	    SessionCO sessionCO = returnSessionObject();
	    avaFileCompanionLkpSC.setCompCode(sessionCO.getCompanyCode());
	    avaFileCompanionLkpSC.setFileCode(filCode);
	    setRecords(avaFileCompanionLkpBO.returnAccompanistLookupCount(avaFileCompanionLkpSC));
	    ctsAvaFileCompanionList = avaFileCompanionLkpBO.returnAccompanistLookupList(avaFileCompanionLkpSC);
	    setGridModel(ctsAvaFileCompanionList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String dependencyByCompanionSeq()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    AvaFileCompanionLkpSC sc = new AvaFileCompanionLkpSC();
	    sc.setCompanionSeq(companioSeq);
	    sc.setCompCode(sessionCO.getCompanyCode());
	    sc.setFileCode(filCode);
	    ctsAvaFileCompanionVO = avaFileCompanionLkpBO.dependencyByCompanionSeq(sc);
	}
	catch(Exception e)
	{
	    ctsAvaFileCompanionVO = new CTS_AVA_FILE_COMPANIONVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

}
