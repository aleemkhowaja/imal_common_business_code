/**
 * 
 */
package com.path.dao.core.jvtypes;

import java.util.List;

import com.path.dbmaps.vo.JV_TYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.jvtypes.JVTypeSC;

/**
 * @author Linchu
 * 
 */
public interface JVTypesDAO
{
    public int getJVTypeLookupCount(JVTypeSC criteria) throws DAOException;

    public List<JV_TYPEVO> getJVTypeLookupList(JVTypeSC criteria) throws DAOException;

    public JV_TYPEVO checkJVTypeValidation(JVTypeSC criteria) throws DAOException;

    // TP#205235; Saheer.Naduthodi; 23/07/2014
    public int returnCountJVType(JVTypeSC criteria) throws DAOException;
}
