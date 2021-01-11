package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.instructiondefinition.InstructionDefinitionBO;
import com.path.dbmaps.vo.CTS_INSTRUCTIONVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.instructiondefinition.InstructionDefinitionSC;

public class InstructionDefinitionDependencyAction extends RetailBaseAction
{

    InstructionDefinitionBO instructionDefinitionBO;

    CTS_INSTRUCTIONVO ctsInstructionVO = new CTS_INSTRUCTIONVO();
    
    InstructionDefinitionSC instructionDefinitionSC = new InstructionDefinitionSC();	

    public String dependencyByInstructionCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    instructionDefinitionSC.setCompCode(sessionCO.getCompanyCode());
	    instructionDefinitionSC.setInstructionCode(ctsInstructionVO.getINSTRUCTION_CODE());
	    
	    if(instructionDefinitionSC.getCyExchType() != null)
	    {
        	    if(instructionDefinitionSC.getCyExchType().equals("1"))
        	    {	
        		instructionDefinitionSC.setCyExchType("P");
        	    }
        	    else if(instructionDefinitionSC.getCyExchType().equals("2"))
        	    {
        		instructionDefinitionSC.setCyExchType("S");
        	    }
	    }
	    else
	    {
		StringUtil.resetEmptyStringValues(instructionDefinitionSC.getCyExchType());
	    }
	    
	    ctsInstructionVO = instructionDefinitionBO.dependencyByInstructionCode(instructionDefinitionSC);
	    
	    if(ctsInstructionVO == null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	}
	catch(Exception e)
	{
	    // TODO: handle exception
	}

	return "success";
    }

    public void setInstructionDefinitionBO(InstructionDefinitionBO instructionDefinitionBO)
    {
	this.instructionDefinitionBO = instructionDefinitionBO;
    }

    public CTS_INSTRUCTIONVO getCtsInstructionVO()
    {
	return ctsInstructionVO;
    }

    public void setCtsInstructionVO(CTS_INSTRUCTIONVO ctsInstructionVO)
    {
	this.ctsInstructionVO = ctsInstructionVO;
    }

    public InstructionDefinitionSC getInstructionDefinitionSC()
    {
        return instructionDefinitionSC;
    }

    public void setInstructionDefinitionSC(InstructionDefinitionSC instructionDefinitionSC)
    {
        this.instructionDefinitionSC = instructionDefinitionSC;
    }
    
    
}
