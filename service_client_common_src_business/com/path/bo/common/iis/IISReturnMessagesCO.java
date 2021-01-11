
package com.path.bo.common.iis;

import java.util.ArrayList;

import com.path.lib.common.exception.BaseException;
import com.path.lib.vo.BaseVO;

/**
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: sooraj
 * 
 *          IISReturnMessagesCO.java used to Retrurn the Messages
 */
public class IISReturnMessagesCO extends BaseVO
{

    private ArrayList<BaseException> exceptionList = new ArrayList<BaseException>();

    private ArrayList<String> messageIdentifierList = new ArrayList<String>();
    private String jsonexceptionList;

    private boolean skipTransactionRollBackOnConfirm;
    private String calledFrom;

    /**
     * @return the exceptionList
     */
    public ArrayList<BaseException> getExceptionList()
    {
	return exceptionList;
    }

    /**
     * @param exceptionList the exceptionList to set
     */
    public void setExceptionList(ArrayList<BaseException> exceptionList)
    {
	this.exceptionList = exceptionList;
    }

    public void setJsonexceptionList(String jsonexceptionList)
    {
	this.jsonexceptionList = jsonexceptionList;
    }

    public String getJsonexceptionList()
    {
	return jsonexceptionList;
    }


    public String getCalledFrom()
    {
	return calledFrom;
    }

    public void setCalledFrom(String calledFrom)
    {
	this.calledFrom = calledFrom;
    }

    public boolean getSkipTransactionRollBackOnConfirm()
    {
	return skipTransactionRollBackOnConfirm;
    }

    public void setSkipTransactionRollBackOnConfirm(boolean skipTransactionRollBackOnConfirm)
    {
	this.skipTransactionRollBackOnConfirm = skipTransactionRollBackOnConfirm;
    }

    public ArrayList<String> getMessageIdentifierList()
    {
	return messageIdentifierList;
    }

    public void setMessageIdentifierList(ArrayList<String> messageIdentifierList)
    {
	this.messageIdentifierList = messageIdentifierList;
    }

}
