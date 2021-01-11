package com.path.bo.core.jvtypes;

import java.util.List;

import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.jvtypes.JVTypeSC;


public interface JVTypesBO
{
    	public int  getJVTypeLookupCount(JVTypeSC jvTypeSC ) throws BaseException;
	public List<JV_TYPEVO> getJVTypeLookupList(JVTypeSC jvTypeSC) throws BaseException;
	public JV_TYPEVO checkJVTypeValidation(JVTypeSC criteria) throws BaseException;
	public JV_TYPEVO checkJVTypeDep(JVTypeSC criteria) throws BaseException;
}
