/**
 * 
 */
package com.path.bo.core.tfsdoctype.impl;

import java.util.List;

import com.path.bo.core.tfsdoctype.TFSDocTypeBO;
import com.path.dao.core.tfsdoctype.TFSDocTypeDAO;
import com.path.dbmaps.vo.TFSDOCTYPEVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.tfsdoctype.TFSDocTypeSC;

/**
 * @author MarwanMaddah
 * 
 */
public class TFSDocTypeBOImpl extends BaseBO implements TFSDocTypeBO
{
    private TFSDocTypeDAO tfsDocTypeDAO;




    @Override
    public List tfsDocTypeList(TFSDocTypeSC tfsDocTypeSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return tfsDocTypeDAO.tfsDocTypeList(tfsDocTypeSC);
    }

    @Override
    public int tfsDocTypeListCount(TFSDocTypeSC tfsDocTypeSC) throws BaseException
    {
	// TODO Auto-generated method stub
	return tfsDocTypeDAO.tfsDocTypeListCount(tfsDocTypeSC);
    }

    public TFSDocTypeDAO getTfsDocTypeDAO()
    {
        return tfsDocTypeDAO;
    }

    public void setTfsDocTypeDAO(TFSDocTypeDAO tfsDocTypeDAO)
    {
        this.tfsDocTypeDAO = tfsDocTypeDAO;
    }

    public TFSDOCTYPEVO returnTfsdoctype(TFSDocTypeSC tfsDocTypeSC) throws BaseException
    {
	return tfsDocTypeDAO.returnTfsdoctype(tfsDocTypeSC);
    }
    
}
