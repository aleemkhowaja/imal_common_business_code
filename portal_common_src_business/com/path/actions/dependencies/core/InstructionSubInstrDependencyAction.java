package com.path.actions.dependencies.core;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.common.MessageCodes;
import com.path.bo.core.instructionsubinstr.InstructionSubInstrBO;
import com.path.dbmaps.vo.CTS_INSTRUCTION_SUB_INSTRUCTVO;
import com.path.dbmaps.vo.CTS_SUB_INSTRUCTIONVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.common.SessionCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrCO;
import com.path.vo.core.instructionsubinstr.InstructionSubInstrSC;

public class InstructionSubInstrDependencyAction extends RetailBaseAction
{
    private InstructionSubInstrSC criteria = new InstructionSubInstrSC();
    private InstructionSubInstrBO instructionSubInstrBO;
    private CTS_INSTRUCTION_SUB_INSTRUCTVO ctsInstructionSubInstrVO = new CTS_INSTRUCTION_SUB_INSTRUCTVO();
    private InstructionSubInstrCO instructionSubInstrCO = new InstructionSubInstrCO();
    private CTS_SUB_INSTRUCTIONVO ctsSubInstructionVO = new  CTS_SUB_INSTRUCTIONVO();
    
	    
    public String dependencyByInstrSubInstrCode() 
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setSubInstrCode(ctsInstructionSubInstrVO.getSUB_INSTRUCTION_CODE());
	    criteria.setInstrCode(ctsInstructionSubInstrVO.getINSTRUCTION_CODE());
	    instructionSubInstrCO = instructionSubInstrBO.dependencyByInstrSubInstrCode(criteria);
	    NumberUtil.resetEmptyValues(instructionSubInstrCO);
	    NumberUtil.resetEmptyValues(ctsInstructionSubInstrVO);
	    
	    if(instructionSubInstrCO != null)
	    {
		ctsSubInstructionVO.setBRIEF_NAME_ENG(instructionSubInstrCO.getBRIEF_NAME_ENG());
	    }
	    if((instructionSubInstrCO == null || instructionSubInstrCO.getCtsInstructionSubInstrVO() == null) && ctsInstructionSubInstrVO.getSUB_INSTRUCTION_CODE() != null)
	    {
		throw new BOException(MessageCodes.INVALID_MISSING_CODE);
	    }
	}
	catch(Exception e)
	{
	    ctsInstructionSubInstrVO.setSUB_INSTRUCTION_CODE(null);
	    handleException(e, null, null);
	}

	return "success";
    }

    public InstructionSubInstrSC getCriteria()
    {
        return criteria;
    }

    public void setCriteria(InstructionSubInstrSC criteria)
    {
        this.criteria = criteria;
    }

    public CTS_INSTRUCTION_SUB_INSTRUCTVO getCtsInstructionSubInstrVO()
    {
        return ctsInstructionSubInstrVO;
    }

    public void setCtsInstructionSubInstrVO(CTS_INSTRUCTION_SUB_INSTRUCTVO ctsInstructionSubInstrVO)
    {
        this.ctsInstructionSubInstrVO = ctsInstructionSubInstrVO;
    }

    public void setInstructionSubInstrBO(InstructionSubInstrBO instructionSubInstrBO)
    {
        this.instructionSubInstrBO = instructionSubInstrBO;
    }

    public InstructionSubInstrCO getInstructionSubInstrCO()
    {
        return instructionSubInstrCO;
    }

    public void setInstructionSubInstrCO(InstructionSubInstrCO instructionSubInstrCO)
    {
        this.instructionSubInstrCO = instructionSubInstrCO;
    }

    public CTS_SUB_INSTRUCTIONVO getCtsSubInstructionVO()
    {
        return ctsSubInstructionVO;
    }

    public void setCtsSubInstructionVO(CTS_SUB_INSTRUCTIONVO ctsSubInstructionVO)
    {
        this.ctsSubInstructionVO = ctsSubInstructionVO;
    }
    
    
}
