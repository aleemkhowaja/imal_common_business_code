package com.path.actions.dependencies.core;

import java.math.BigDecimal;

import com.path.actions.base.RetailBaseAction;
import com.path.bo.core.todotemplate.ToDoTemplateBO;
import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.vo.common.SessionCO;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public class ToDoTemplateDependencyAction extends RetailBaseAction
{

    private ToDoTemplateBO toDoTemplateBO;
    private S_TODO_TEMPLATE_HDRVO toDoTemplateVO;
    private BigDecimal TODO_TEMPLATE;

    public String dependancyByTemplateCode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    ToDoTemplateSC criteria = new ToDoTemplateSC();
	    criteria.setCompCode(sessionCO.getCompanyCode());
	    criteria.setToDoTemplate(TODO_TEMPLATE);

	    toDoTemplateVO = toDoTemplateBO.returnToDoTemplateById(criteria);

	}
	catch(Exception e)
	{
	    log.error(e, "Error in dependancyByTemplateCode method of TODOTemplateCode");
	    handleException(e, "ERROR in TemplateCode Dependency", null);
	}

	return SUCCESS;
    }

    public S_TODO_TEMPLATE_HDRVO getToDoTemplateVO()
    {
	return toDoTemplateVO;
    }

    public void setToDoTemplateVO(S_TODO_TEMPLATE_HDRVO toDoTemplateVO)
    {
	this.toDoTemplateVO = toDoTemplateVO;
    }

    public BigDecimal getTODO_TEMPLATE()
    {
	return TODO_TEMPLATE;
    }

    public void setTODO_TEMPLATE(BigDecimal tODOTEMPLATE)
    {
	TODO_TEMPLATE = tODOTEMPLATE;
    }

    public void setToDoTemplateBO(ToDoTemplateBO toDoTemplateBO)
    {
	this.toDoTemplateBO = toDoTemplateBO;
    }

}
