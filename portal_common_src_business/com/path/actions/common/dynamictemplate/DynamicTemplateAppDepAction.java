package com.path.actions.common.dynamictemplate;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.dbmaps.vo.BCOM_DYN_ENTITY_APP_LISTVO;
import com.path.dbmaps.vo.OPTVO;
import com.path.dbmaps.vo.S_APPVO;
import com.path.lib.common.base.GenericDAOImpl;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;

/**
 * 
 * Copyright 2014, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: deniskhaddad
 * 
 *          ApplicationDependencyAction.java used to manage Dependencies of
 *          Application
 */
public class DynamicTemplateAppDepAction extends BaseAction
{
    private S_APPVO appVO = new S_APPVO();
    private OPTVO optVO = new OPTVO();
    private String webAppsOnly;
    private DynamicTemplateBO dynamicTemplateBO;

    /**
     * dependency by Application Name
     * 
     * @return
     */
    public String applicationDepend()
    {
	try
	{
	    //checking if the application already exist
	    SessionCO sessionCO = returnSessionObject();
	    String appName = appVO.getAPP_NAME();
	    DynamicTemplateSC dynTempSc = new DynamicTemplateSC();
	    dynTempSc.setCurrAppName(appName);
	    dynTempSc.setCompCode(sessionCO.getCompanyCode());
	    int count = dynamicTemplateBO.checkIfAppExist(dynTempSc);
            if(count == 1)
            {
        	throw new BOException(MessageCodes.VALUE_ENTERED_ALREADY_EXISTS); 
            }
            
            //continue normal behavior for application name
	    if(StringUtil.nullToEmpty(appName).isEmpty())
	    {
		appVO = new S_APPVO();
	    }
	    else
    	    {
    		BCOM_DYN_ENTITY_APP_LISTVO appNameVO = new BCOM_DYN_ENTITY_APP_LISTVO();
    		appNameVO.setAPP_NAME(appVO.getAPP_NAME());
    		
    		appNameVO = dynamicTemplateBO.returnAppNameVO(appNameVO);
    		
    		if(appNameVO != null && StringUtil.isNotEmpty(appNameVO.getAPP_NAME()))
		{
		    S_APPVO applic = returnCommonLibBO().returnApplication(appVO);
		    // check if application available and if it is relates to
		    // WEb if webAppsOnly falg recieved
		    if(applic == null
			    || (webAppsOnly != null && !ConstantsCommon.APP_IS_WEB_AND_PB.equals(applic.getIS_WEB_YN())
				    && !ConstantsCommon.APP_IS_WEB_ONLY.equals(applic.getIS_WEB_YN())))
		    {
			appVO = new S_APPVO();
		    }
		    else
		    {
			String language = returnSessionObject().getLanguage();
			appVO.setAPP_DESC(applic.getAPP_DESC());
			if(ConstantsCommon.LANGUAGE_ARABIC.equals(language))
			{
			    appVO.setAPP_DESC(applic.getAPP_DESC_AR());
			}
			else if(ConstantsCommon.LANGUAGE_FRENCH.equals(language))
			{
			    appVO.setAPP_DESC(applic.getAPP_DESC_FR());
			}
			optVO = new OPTVO();
		    }

		}
    		else
    		{
    		    appVO = new S_APPVO();
    		}
    	    }
	}
	catch(Exception e)
	{
	    appVO = new S_APPVO();
	    optVO = new OPTVO();
	    handleException(e, null, null);
	}
	return SUCCESS;
    }

    public S_APPVO getAppVO()
    {
	return appVO;
    }

    public void setAppVO(S_APPVO appVO)
    {
	this.appVO = appVO;
    }

    public OPTVO getOptVO()
    {
        return optVO;
    }

    public void setWebAppsOnly(String webAppsOnly)
    {
        this.webAppsOnly = webAppsOnly;
    }
    
    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
	this.dynamicTemplateBO = dynamicTemplateBO;
    }
}
