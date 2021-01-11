package com.path.bo.core.todotemplate;

import java.util.List;

import com.path.dbmaps.vo.S_TODO_TEMPLATE_HDRVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.todotemplate.ToDoTemplateSC;

public interface ToDoTemplateBO {
	 public int toDoTemplateListCount(ToDoTemplateSC toDoTemplateSC) throws BaseException;
	 public List toDoTemplateList(ToDoTemplateSC toDoTemplateSC) throws BaseException;
	 public S_TODO_TEMPLATE_HDRVO returnToDoTemplateById(ToDoTemplateSC criteria) throws BaseException;
	 }
