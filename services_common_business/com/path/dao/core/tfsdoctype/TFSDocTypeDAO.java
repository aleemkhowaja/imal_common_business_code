/**
 * 
 */
package com.path.dao.core.tfsdoctype;

import java.util.List;

import com.path.dbmaps.vo.TFSDOCTYPEVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.core.tfsdoctype.TFSDocTypeSC;


/**
 * @author MarwanMaddah
 *
 */
public interface TFSDocTypeDAO
{
    public List tfsDocTypeList(TFSDocTypeSC tfsdoctypeSC) throws DAOException;
    public int tfsDocTypeListCount(TFSDocTypeSC tfsdoctypeSC) throws DAOException;
    public TFSDOCTYPEVO returnTfsdoctype(TFSDocTypeSC tfsdoctypeSC) throws DAOException;
}
