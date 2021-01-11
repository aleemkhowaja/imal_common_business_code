package com.path.dao.core.todotemplate.impl;

import java.util.List;

import com.path.dao.core.todotemplate.ToDoTemplateDAO;
import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.lib.common.util.DAOHelper;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public class ToDoTemplateDAOImpl extends BaseDAO implements ToDoTemplateDAO{

	@Override
	public List toDoTemplateList(ToDoTemplateSC toDoTemplateSC)
			throws DAOException {		
		if(toDoTemplateSC.getNbRec() == -1)
		{
		    return getSqlMap().queryForList("toDoTemplateListMapper.toDoTemplateList", toDoTemplateSC);
		}
		else
		{
		    DAOHelper.fixGridMaps(toDoTemplateSC, getSqlMap(), "toDoTemplateListMapper.toDoTemplateListMap");
		    return getSqlMap().queryForList("toDoTemplateListMapper.toDoTemplateList", toDoTemplateSC, toDoTemplateSC.getRecToskip(),
		    		toDoTemplateSC.getNbRec());
		}
	}

	@Override
	public int toDoTemplateListCount(ToDoTemplateSC toDoTemplateSC)
			throws DAOException {
		DAOHelper.fixGridMaps(toDoTemplateSC, getSqlMap(), "toDoTemplateListMapper.toDoTemplateListMap");
		int nb = 0;
		nb = ((Integer) getSqlMap().queryForObject("toDoTemplateListMapper.toDoTemplateListCount", toDoTemplateSC)).intValue();
		return nb;
	}

	@Override
	public S_TODO_TEMPLATE_HDRVO returnToDoTemplateById(ToDoTemplateSC criteria)
			throws DAOException {
		return (S_TODO_TEMPLATE_HDRVO) getSqlMap().queryForObject("toDoTemplateListMapper.returnToDoTemplateById", criteria);
	}

}
