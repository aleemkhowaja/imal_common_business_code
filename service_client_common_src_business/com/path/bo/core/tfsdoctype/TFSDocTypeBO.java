/**
 * 
 */
package com.path.bo.core.tfsdoctype;

import java.util.List;

import com.path.dbmaps.vo.TFSDOCTYPEVO;
import com.path.lib.common.exception.BaseException;
import com.path.vo.core.tfsdoctype.TFSDocTypeSC;

/**
 * @author MarwanMaddah
 *
 */
public interface TFSDocTypeBO
{
    public List tfsDocTypeList(TFSDocTypeSC tfsDocTypeSC) throws BaseException;
    public int tfsDocTypeListCount(TFSDocTypeSC tfsDocTypeSC) throws BaseException;
    public TFSDOCTYPEVO returnTfsdoctype(TFSDocTypeSC tfsDocTypeSC) throws BaseException;
    
}
