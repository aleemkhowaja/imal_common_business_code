package com.path.bo.core.todotemplate.impl;

import java.util.List;

import com.path.bo.core.todotemplate.ToDoTemplateBO;
import com.path.dao.core.todotemplate.ToDoTemplateDAO;
import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public class ToDoTemplateBOImpl extends BaseBO implements ToDoTemplateBO{
	
	private ToDoTemplateDAO toDoTemplateDAO;
	
	 public ToDoTemplateDAO getToDoTemplateDAO()
	    {
		return toDoTemplateDAO;
	    }

	@Override
	public List toDoTemplateList(ToDoTemplateSC toDoTemplateSC)
			throws BaseException {
		return toDoTemplateDAO.toDoTemplateList(toDoTemplateSC);
	}

	@Override
	public int toDoTemplateListCount(ToDoTemplateSC toDoTemplateSC)
			throws BaseException {
		return toDoTemplateDAO.toDoTemplateListCount(toDoTemplateSC);
	}

	public void setToDoTemplateDAO(ToDoTemplateDAO toDoTemplateDAO) {
		this.toDoTemplateDAO = toDoTemplateDAO;
	}

	@Override
	public S_TODO_TEMPLATE_HDRVO returnToDoTemplateById(ToDoTemplateSC criteria)
			throws BaseException {
		return (S_TODO_TEMPLATE_HDRVO) toDoTemplateDAO.returnToDoTemplateById(criteria);
	}


	
}
