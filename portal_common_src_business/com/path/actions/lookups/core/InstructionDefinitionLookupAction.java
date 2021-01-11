package com.path.actions.lookups.core;

import com.path.bo.core.instructiondefinition.InstructionDefinitionBO;
import com.path.lib.common.util.StringUtil;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;

public class InstructionDefinitionLookupAction extends LookupBaseAction
{
    private InstructionDefinitionSC criteria = new InstructionDefinitionSC();
    private InstructionDefinitionBO instructionDefinitionBO;
    
    public Object getModel()
    {
	return criteria;
    }
    
    public String constructLookup() 
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "INSTRUCTION_CODE", "BRIEF_NAME_ENG","CIRCULAR_CODE" };
	    String[] colType = { "number","text","number"};
	    String[] titles = { getText("code_key"),  getText("Short_Name_key") ,  getText("circular_code")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("instruction_definition_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/InstructionLookup_fillInstructionLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    public String fillInstructionLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    
	    if(criteria.getCyExchType() != null)
	    {
		if(criteria.getCyExchType().equals("1"))
		    {
			criteria.setCyExchType("P");
		    }
		    else if(criteria.getCyExchType().equals("2"))
		    {
			criteria.setCyExchType("S");
		    }
	    }
	    else
	    {
		StringUtil.resetEmptyStringValues(criteria.getCyExchType());
	    }
	    
	    if(getRecords() == 0)
		{
		    setRecords(instructionDefinitionBO.returnInstructionDefinitionListCount(criteria));
		}
	    
	    setGridModel(instructionDefinitionBO.returnInstructionDefinitionList(criteria));	
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public InstructionDefinitionSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(InstructionDefinitionSC criteria)
    {
        this.criteria = criteria;
    }

    public void setInstructionDefinitionBO(InstructionDefinitionBO instructionDefinitionBO)
    {
        this.instructionDefinitionBO = instructionDefinitionBO;
    }
    
    
}
