package com.path.dao.core.todotemplate;

import java.util.List;

import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public interface ToDoTemplateDAO {
	  public int toDoTemplateListCount(ToDoTemplateSC toDoTemplateSC) throws DAOException;

	    public List toDoTemplateList(ToDoTemplateSC toDoTemplateSC) throws DAOException;
	    
	    public S_TODO_TEMPLATE_HDRVO returnToDoTemplateById(ToDoTemplateSC criteria) throws DAOException;
	    

}
