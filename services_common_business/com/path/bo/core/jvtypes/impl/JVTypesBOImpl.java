package com.path.bo.core.jvtypes.impl;

import java.util.List;

import com.path.bo.common.MessageCodes;
import com.path.bo.core.jvtypes.JVTypesBO;
import com.path.dao.core.jvtypes.JVTypesDAO;
import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.vo.core.jvtypes.JVTypeSC;

public class JVTypesBOImpl extends BaseBO implements JVTypesBO
{
    JVTypesDAO jvTypesDAO;

    public int getJVTypeLookupCount(JVTypeSC criteria) throws BaseException
    {
	return jvTypesDAO.getJVTypeLookupCount(criteria);
    }

    public List<JV_TYPEVO> getJVTypeLookupList(JVTypeSC criteria) throws BaseException
    {
	return jvTypesDAO.getJVTypeLookupList(criteria);
    }

    public JV_TYPEVO checkJVTypeValidation(JVTypeSC criteria) throws BaseException
    {
	// TP#205235; Saheer.Naduthodi; 23/07/2014 [START]
	int jvTypeCount = jvTypesDAO.returnCountJVType(criteria);
	if(jvTypeCount == 0)
	{
	    throw new BOException(MessageCodes.iis_invalid_code,
		    new String[] { "Selected_JV_Type_is_not_defined_at_Control_Record_key" }, false);
	}
	// TP#205235; Saheer.Naduthodi; 23/07/2014 [END]
	return jvTypesDAO.checkJVTypeValidation(criteria);
    }
    
    public JV_TYPEVO checkJVTypeDep(JVTypeSC criteria) throws BaseException
    {
    	JV_TYPEVO jvTypeVO = new JV_TYPEVO();
    	if(!NumberUtil.isEmptyDecimal(criteria.getJvCode()))
	    {
    		jvTypeVO = jvTypesDAO.checkJVTypeValidation(criteria);
    	
    		if(jvTypeVO==null) {
    			throw new BOException(MessageCodes.INVALID_ENTRY);
    		}
	    }
    	
    	return jvTypeVO;
    }

    public JVTypesDAO getJvTypesDAO()
    {
	return jvTypesDAO;
    }

    public void setJvTypesDAO(JVTypesDAO jvTypesDAO)
    {
	this.jvTypesDAO = jvTypesDAO;
    }

}
