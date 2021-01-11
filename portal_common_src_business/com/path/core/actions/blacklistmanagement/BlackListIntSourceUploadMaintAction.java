package com.path.core.actions.blacklistmanagement;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.scheduling.quartz.LocalDataSourceJobStore;

import net.sf.json.JSONObject;

import com.path.bo.common.MessageCodes;
import org.apache.commons.io.FileUtils;
import com.path.core.bo.blacklistmanagement.BlackListManagementConstant;
import com.path.core.bo.blacklistmanagement.blacklistintsource.BlackListIntSourceBO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.PTH_CTRL1VO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.FileUtil;
import com.path.struts2.lib.common.base.BaseAction;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

/**
 * PB : w_maintain_upload_un_ofac
 * @author EliasAoun
 */
public class BlackListIntSourceUploadMaintAction extends BaseAction
{
    private BlackListIntSourceBO blackListIntSourceBO;
    private BlackListIntSourceCO blackListIntSourceCO = new BlackListIntSourceCO();
    private PTH_CTRL1VO pthCtrl1VO = new PTH_CTRL1VO();
    private BlackListIntSourceSC blackListIntSourceSC = new BlackListIntSourceSC();

    private boolean CBTab; // specify if the user can see CB tab or not
    private String _asSource;

    private File file;
    public String contentType;
    private String filename;
    private boolean proceed;
    private InputStream scriptStream;
    //by bilal for TP#885556
    private String fileCode;
    private String structCode;

    public String initialize() throws Exception
    {
	pthCtrl1VO = returnCommonLibBO().returnPthCtrl1();

	// load success message to use in case of success upload
	String confirmMsg = returnCommonLibBO().returnTranslErrorMessage(1730, returnSessionObject().getLanguage());
	blackListIntSourceCO.setConfirmMsg(confirmMsg);

	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(returnSessionObject().getCompanyCode());
	ctsControlVO.setBRANCH_CODE(returnSessionObject().getBranchCode());
	ctsControlVO = returnCommonLibBO().returnCtsControlDetails(ctsControlVO);
	setCBTab(("6").equals(ctsControlVO.getINWARD_OUTWARD_CLR_CHQ()));

	return SUCCESS;
    }

    /**
     * Uploads the file and returns the file data to be displayed in the grid
     * 
     * @return
     */
    public String uploadFile() throws Exception
    {
	try
	{

	    DynFilesSC dynFilesSC = new DynFilesSC();
	    BlackListIntSourceSC criteria = new BlackListIntSourceSC();

	    // TODO Auto-generated to check the alert to show
	    // if( null == filename || filename.equals(""))
	    // return SUCCESS;

	    dynFilesSC.setCompCode(returnSessionObject().getCompanyCode());
	    dynFilesSC.setBranchCode(returnSessionObject().getBranchCode());

	    dynFilesSC.setBaseCurr(returnSessionObject().getBaseCurrencyCode());
	    dynFilesSC.setAppName(returnSessionObject().getCurrentAppName());
	    
	    //added by bilal for TP#885556
	    dynFilesSC.setFileCode(fileCode);
		dynFilesSC.setStructCode(structCode);
	    
//	    if(BlackListManagementConstant.AS_SOURCE_UN.equals(_asSource))
//	    {
//		dynFilesSC.setFileCode(BlackListManagementConstant.FILE_CODE_UN);
//		dynFilesSC.setStructCode(BlackListManagementConstant.STRUCT_CODE_UN);
//	    }
//	    else if(BlackListManagementConstant.AS_SOURCE_OFAC.equals(_asSource))
//	    {
//		dynFilesSC.setFileCode(BlackListManagementConstant.FILE_CODE_OFAC);
//		dynFilesSC.setStructCode(BlackListManagementConstant.STRUCT_CODE_OFAC);
//	    }
//	    
//	    else{
//		
//		dynFilesSC.setFileCode(BlackListManagementConstant.FILE_CODE_EU);
//		dynFilesSC.setStructCode(BlackListManagementConstant.STRUCT_CODE_EU);		
//		
//	    }

	    dynFilesSC.setStructType(BlackListManagementConstant.STRUCT_TYPE);
	    dynFilesSC.setUserId(returnSessionObject().getUserName());
	    dynFilesSC.setSystemDate(returnSessionObject().getRunningDateRET());

	    criteria.setCompCode(returnSessionObject().getCompanyCode());
	    criteria.setFileName(filename);
	    criteria.setAs_source(_asSource);

	    if(proceed)
	    {
		blackListIntSourceBO.continueExecuting(criteria, dynFilesSC);
	    }
	    else
	    {
//	    	if(file != null && !"".equals(file))
	    	if(file != null && file.isFile() && file.length() > 0) //fixing pmd EC_UNRELATED_TYPES 
	    	{
	    		blackListIntSourceBO.uploadFile(criteria, dynFilesSC, FileUtils.readFileToByteArray(file));
	    	}
	    	else
	    	{
	    		 //throw new BaseException("Wrong on Dynamic file Configuration");
	    		 throw new BOException(MessageCodes.WRONG_ON_CONFIGURATION_UPLOAD_FILE);
	    	}
	    }

	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));

	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    scriptStream = new ByteArrayInputStream(JSONObject.fromObject(this).toString().getBytes(FileUtil.DEFAULT_FILE_ENCODING));
	    return "downloadError";
	}
	return "downloadError";
    }
    
	// added by bilal for TP#885556
	public String depLookupFileName() {
		try {
			blackListIntSourceCO = blackListIntSourceBO.depLookupFileName(blackListIntSourceSC);
		} catch (BaseException e) {
			handleException(e, null, null);
		}
		return "loadJson";
	}

    /** Getters and Setters */
    public void setBlackListIntSourceBO(BlackListIntSourceBO blackListIntSourceBO)
    {
	this.blackListIntSourceBO = blackListIntSourceBO;
    }

    public PTH_CTRL1VO getPthCtrl1VO() throws BaseException
    {
	return pthCtrl1VO;
    }

    public void setPthCtrl1VO(PTH_CTRL1VO pthCtrl1VO)
    {
	this.pthCtrl1VO = pthCtrl1VO;
    }

    public void setFileNameUN(File file)
    {
	this.file = file;
    }

    public void setFileNameUNContentType(String contentType)
    {
	this.contentType = contentType;
    }

    public void setFileNameUNFileName(String filename)
    {
	this.filename = filename;
    }

    public void setFileNameOFAC(File file)
    {
	this.file = file;
    }

    public void setFileNameOFACContentType(String contentType)
    {
	this.contentType = contentType;
    }

    public void setFileNameOFACFileName(String filename)
    {
	this.filename = filename;
    }
    
    public void setFileNameEU(File file)
    {
	this.file = file;
    }
    
    public void setFileNameEUContentType(String contentType)
    {
	this.contentType = contentType;
    }
    
    public void setFileNameEUFileName(String filename)
    {
	this.filename = filename;
    }

    public void setFileNameHM(File file)
    {
	this.file = file;
    }

    public void setFileNameHMContentType(String contentType)
    {
	this.contentType = contentType;
    }

    public void setFileNameHMFileName(String filename)
    {
	this.filename = filename;
    }
    
    public boolean isCBTab()
    {
	return CBTab;
    }

    public void setCBTab(boolean cBTab)
    {
	CBTab = cBTab;
    }

    public BlackListIntSourceCO getBlackListIntSourceCO()
    {
	return blackListIntSourceCO;
    }

    public void setBlackListIntSourceCO(BlackListIntSourceCO blackListIntSourceCO)
    {
	this.blackListIntSourceCO = blackListIntSourceCO;
    }

    public String get_asSource()
    {
	return _asSource;
    }

    public void set_asSource(String asSource)
    {
	_asSource = asSource;
    }

    public boolean isProceed()
    {
	return proceed;
    }

    public void setProceed(boolean proceed)
    {
	this.proceed = proceed;
    }

    public InputStream getScriptStream()
    {
	return scriptStream;
    }

    public void setScriptStream(InputStream scriptStream)
    {
	this.scriptStream = scriptStream;
    }

	public BlackListIntSourceSC getBlackListIntSourceSC() {
		return blackListIntSourceSC;
	}

	public void setBlackListIntSourceSC(BlackListIntSourceSC blackListIntSourceSC) {
		this.blackListIntSourceSC = blackListIntSourceSC;
	}

	public String getFileCode() {
		return fileCode;
	}

	public void setFileCode(String fileCode) {
		this.fileCode = fileCode;
	}

	public String getStructCode() {
		return structCode;
	}

	public void setStructCode(String structCode) {
		this.structCode = structCode;
	}

}
