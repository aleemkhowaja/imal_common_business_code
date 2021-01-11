package com.path.actions.lookups.core;

import java.util.List;

import com.path.bo.core.ctsoperationstype.CtsOperationsTypeLkpBO;
import com.path.dbmaps.vo.CTS_OPERATIONS_TYPEVO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.ctsoperationstype.CtsOperationsTypeLkpSC;

public class CtsOperationsTypeLookupAction extends LookupBaseAction
{
    private CtsOperationsTypeLkpBO ctsOperationsTypeLkpBO;
    private CtsOperationsTypeLkpSC operationsTypeLkpSC  = new CtsOperationsTypeLkpSC();
    
    
    public CtsOperationsTypeLkpSC getOperationsTypeLkpSC()
    {
        return operationsTypeLkpSC;
    }

    public void setOperationsTypeLkpSC(CtsOperationsTypeLkpSC operationsTypeLkpSC)
    {
        this.operationsTypeLkpSC = operationsTypeLkpSC;
    }
    
    @Override
    public Object getModel()
    {
        return operationsTypeLkpSC;
    }

    /**
     * Method that construct the operation type lookup grid
     * @return
     */
    public String constructOperationTypeLookup()
    {

	try
	{
	    String[] name = { "CODE", "BRIEF_DESC_ENG" };
	    String[] colType = { "number", "text" };
	    String[] titles = { getText("Code__key"), getText("Name_key") };
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("Operation types list"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/CtsOperationsTypeLookupAction_fillOperationTypeLkp");
	    lookup(grid, operationsTypeLkpSC, name, colType, titles);
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
    public String fillOperationTypeLkp()
    {
	try
	{
	    List<CTS_OPERATIONS_TYPEVO> opTypeVOList;
	    copyproperties(operationsTypeLkpSC);
	    SessionCO sessionCO = returnSessionObject();
	    operationsTypeLkpSC.setCompCode(sessionCO.getCompanyCode());
	    setRecords(ctsOperationsTypeLkpBO.returnOperationTypeLookupCount(operationsTypeLkpSC));
	    opTypeVOList = ctsOperationsTypeLkpBO.returnOperationTypeLookupList(operationsTypeLkpSC);
	    setGridModel(opTypeVOList);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

//    public CtsOperationsTypeLkpBO getCtsOperationsTypeLkpBO()
//    {
//        return ctsOperationsTypeLkpBO;
//    }

    public void setCtsOperationsTypeLkpBO(CtsOperationsTypeLkpBO ctsOperationsTypeLkpBO)
    {
        this.ctsOperationsTypeLkpBO = ctsOperationsTypeLkpBO;
    }
}
