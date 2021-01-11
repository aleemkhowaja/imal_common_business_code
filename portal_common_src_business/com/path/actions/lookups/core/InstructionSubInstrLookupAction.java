package com.path.actions.lookups.core;

import com.path.bo.core.instructionsubinstr.InstructionSubInstrBO;
import com.path.lib.vo.LookupGrid;
import com.path.struts2.lib.common.base.LookupBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;

public class InstructionSubInstrLookupAction extends LookupBaseAction
{
    private InstructionSubInstrSC criteria = new InstructionSubInstrSC();
    private InstructionSubInstrBO instructionSubInstrBO;
    
    public String constructLookup() 
    {
	try
	{
	    // Design the Grid by defining the column model and column names
	    String[] name = { "SUB_INSTRUCTION_CODE", "BRIEF_NAME_ENG"};
	    String[] colType = { "number","text"};
	    String[] titles = { getText("code_key"), getText("Short_Name_key")};

	    // Defining the Grid
	    LookupGrid grid = new LookupGrid();
	    grid.setCaption(getText("sub_instr_def_key"));
	    grid.setRowNum("5");
	    grid.setUrl("/pathdesktop/InstrSubInstrLookup_fillInstructionSubInstrLookup");
	    lookup(grid, criteria, name, colType, titles);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}

	return SUCCESS;

    }
    
    
    public String fillInstructionSubInstrLookup()
    {
	try
	{
	    setSearchFilter(criteria);
	    copyproperties(criteria);
	    SessionCO sessionCO = returnSessionObject();
	    criteria.setUserId(sessionCO.getUserName());
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setPreferredLanguage(sessionCO.getLanguage());
	    
	    if(getRecords() == 0)
		{
		    setRecords(instructionSubInstrBO.returnInstructionSubInstrListCount(criteria));
		}
	    
	    setGridModel(instructionSubInstrBO.returnInstructionSubInstrList(criteria));	
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }


    public InstructionSubInstrSC getCriteria()
    {
        return criteria;
    }


    public void setCriteria(InstructionSubInstrSC criteria)
    {
        this.criteria = criteria;
    }


    public void setInstructionSubInstrBO(InstructionSubInstrBO instructionSubInstrBO)
    {
        this.instructionSubInstrBO = instructionSubInstrBO;
    }
    
    
}
