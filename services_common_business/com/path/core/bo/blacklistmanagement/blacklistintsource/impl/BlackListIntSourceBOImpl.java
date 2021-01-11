package com.path.core.bo.blacklistmanagement.blacklistintsource.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.dynfiles.DynFilesBO;
import com.path.bo.core.common.base.RetailBaseBO;
import com.path.core.bo.blacklistmanagement.BlackListManagementConstant;
import com.path.core.bo.blacklistmanagement.blacklistintsource.BlackListIntSourceBO;
import com.path.core.dao.blacklistmanagement.BlackListIntSourceDAO;
import com.path.dbmaps.vo.DF_FILE_PARMVO;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynfiles.DynFilesDetCO;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public class BlackListIntSourceBOImpl extends RetailBaseBO implements BlackListIntSourceBO
{
    
    private BlackListIntSourceDAO blackListIntSourceDAO; 
    private DynFilesBO dynFilesBO;
    
    
    public BlackListIntSourceDAO getBlackListIntSourceDAO() { return blackListIntSourceDAO; }
    public void setBlackListIntSourceDAO(BlackListIntSourceDAO blackListIntSourceDAO) { this.blackListIntSourceDAO = blackListIntSourceDAO;}
    
    public DynFilesBO getDynFilesBO() { return dynFilesBO; }
	public void setDynFilesBO(DynFilesBO dynFilesBO) { this.dynFilesBO = dynFilesBO; }
	
	
	@Override
    public List<BlackListIntSourceCO> getMatchedCIFList(BlackListIntSourceSC criteria) throws BaseException {
		return blackListIntSourceDAO.getMatchedCIFList( criteria);
    }


    @Override
    public Integer getMatchedCIFListCount(BlackListIntSourceSC criteria) throws BaseException {
    	return blackListIntSourceDAO.getMatchedCIFListCount( criteria);
    }


    @Override
    public List<BlackListIntSourceCO> getWhiteList(BlackListIntSourceSC criteria) throws BaseException {
    	return blackListIntSourceDAO.getWhiteList( criteria);
    }


    @Override
    public Integer getWhiteListCount(BlackListIntSourceSC criteria) throws BaseException {
    	return blackListIntSourceDAO.getWhiteListCount( criteria);
    }

    
    public void switchCIFToSuspicious( BlackListIntSourceCO blackListIntSourceCOParam) throws BaseException{
	//AvoidReassigningParameters
	BlackListIntSourceCO blackListIntSourceCO = blackListIntSourceCOParam;
	
	String[] checkedParam = blackListIntSourceCO.getCheckedList().split(",");
	BlackListIntSourceSC criteria = new BlackListIntSourceSC();
	for(String rowId : checkedParam)
	{
	    String[] params = rowId.split(";");
	    String CIF_NO = params[0];
	    BigDecimal COMP_CODE = new BigDecimal(params[1]);

	    criteria.setCompCode(COMP_CODE);
	    criteria.setBlckListCifNo((new BigDecimal(CIF_NO.trim())));
	    
	    int blacklistedCIFCount = blackListIntSourceDAO.checkCIFBlackListed(criteria);
	    if(blacklistedCIFCount > 0)
	    {
		throw new BOException(MessageCodes.RECORD_CANNOT_BE_UNBLOCKED);
	    }
	}
	blackListIntSourceCO = fillCOValues(blackListIntSourceCO, BlackListManagementConstant.SUSPICIOUS);
		blackListIntSourceDAO.switchCIFListStatus( blackListIntSourceCO);
    }


    @Override
    public void switchCIFToWhiteList( BlackListIntSourceCO blackListIntSourceCOParam) throws BaseException {
	
	//AvoidReassigningParameters
	BlackListIntSourceCO blackListIntSourceCO = blackListIntSourceCOParam;
	
	blackListIntSourceCO = fillCOValues(blackListIntSourceCO, BlackListManagementConstant.WHITELISTED);
		blackListIntSourceDAO.switchCIFListStatus( blackListIntSourceCO);
    }
    
    @Override
    public void switchCIFToBlackList(BlackListIntSourceCO blackListIntSourceCOParam) throws BaseException
    {
	//AvoidReassigningParameters
	BlackListIntSourceCO blackListIntSourceCO = blackListIntSourceCOParam;
	
	blackListIntSourceCO = fillCOValues(blackListIntSourceCO, BlackListManagementConstant.BLACKLISTED);
		blackListIntSourceDAO.switchCIFListStatus( blackListIntSourceCO);
    }

    /**
     * Common function to fill the needed parameters when switching the status
     * of a cif list
     * 
     * @param blackListIntSourceCO
     * @param oldCifListFlag
     * @param BLACK_LISTED
     * @return blackListIntSourceCO
     * @throws BaseException
     */
    private BlackListIntSourceCO fillCOValues(BlackListIntSourceCO blackListIntSourceCO, BigDecimal BLACK_LISTED)
	    throws BaseException
    {
	Date date = commonLibBO.returnSystemDateWithTime();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss", Locale.ENGLISH);
	String timeSysDate = sdf.format(date);

	blackListIntSourceCO.setCurrentDate(timeSysDate);
	blackListIntSourceCO.getCifVO().setBLACK_LISTED(BLACK_LISTED);
	return blackListIntSourceCO;
    }
    

    
    @Override
    public void uploadFile(BlackListIntSourceSC criteria, DynFilesSC dynFilesSC, byte[] fileByte)
	    throws BaseException, IOException
    {
	// delete tables from db
	blackListIntSourceDAO.callSoundexPrepare(criteria);

	String fileName = criteria.getFileName();
	DynFilesDetCO dynFilesDetCO = new DynFilesDetCO();
	returnListParameterValues(dynFilesDetCO, dynFilesSC, fileName);
	//by bilal for BUG#951235
	fileName = fileName.substring(0,fileName.length() - 4).trim();
	dynFilesDetCO.getDfDataFileVO().setFILE_NAME(fileName);
	//end bilal
	dynFilesBO.processDynFilesImportView(dynFilesDetCO, dynFilesSC, fileByte);

	callSoundexProcess(criteria);

    }
	
	@Override
	public void continueExecuting(BlackListIntSourceSC criteria,
			DynFilesSC dynFilesSC)  throws BaseException{
		
		String fileName = criteria.getFileName();
		DynFilesDetCO dynFilesDetCO = new DynFilesDetCO();
		
		returnListParameterValues( dynFilesDetCO,  dynFilesSC, fileName);
		
		dynFilesBO.continueExecuting(dynFilesSC, dynFilesDetCO);
		
		callSoundexProcess(criteria);  //936705 - ZKI190031: if an error occured while uploading the file and the user wants to continue anw it will enter this method (continueExecuting from BlackListIntSourceUploadMaintAction.uploadFile). so it was processing the file and adding the data through dynamic file into black list tables (OFAC_MAIN, UN_MAIN...) without getting their soundex 
	}
	
	
    /**
     * Call the procedure that recalculate CIF names for soundex table
     * 
     * @param BlackListIntSourceSC
     * @return BlackListIntSourceSC
     * @throws BaseException
     */
    private void callSoundexProcess(BlackListIntSourceSC criteriaParam) throws BaseException
    {
	
	//AvoidReassigningParameters
	BlackListIntSourceSC criteria = criteriaParam;
	
	coreCommonProcedureBO.dropHashSoundex();
	coreCommonProcedureBO.createHashSoundex();

	criteria = coreCommonProcedureBO.callSoundexProcess(criteria);
	if(null != criteria)
	{
	    BigDecimal errorCode = criteria.getOS_ERROR_CODE();
	    //an ambiguous value -1.000000000 is returned,so this condition is escaping it
	    if( errorCode != null && errorCode.intValue() != -1 )
	    {
		throw new BOException(criteria.getOS_ERROR_CODE().intValue());
	    }
	    String errorText = criteria.getOS_ERROR_TEXT();
	    //an ambiguous value "E" is returned,so this condition is escaping it
	    if( errorText != null && !criteria.getOS_ERROR_TEXT().equals("") && !criteria.getOS_ERROR_TEXT().equals("E") && !criteria.getOS_ERROR_TEXT().equals("success"))
	    {
		throw new BOException(criteria.getOS_ERROR_TEXT());
	    }
	}
	coreCommonProcedureBO.dropHashSoundex();
    }
	
    private void returnListParameterValues(DynFilesDetCO dynFilesDetCO, DynFilesSC dynFilesSC, String fileName)
	    throws BaseException
    {
	dynFilesDetCO.setDfFileParmVO(new ArrayList<DF_FILE_PARMVO>());

	ArrayList<DF_FILE_PARMVO> listParamaters = dynFilesBO.returnDynFilesVisibleInputParameters(dynFilesSC);
	String fileLocation = dynFilesDetCO.getDfDataFileVO().getFILE_LOCATION();
	String fileExtension = dynFilesDetCO.getDfFileStructVO().getFILE_EXT();

	dynFilesBO.setDefaultValues(listParamaters, dynFilesSC, fileName, fileLocation, fileExtension);
    }
	@Override
	public Integer getDynFilesBlackListedListCount(BlackListIntSourceSC blackListIntSourceSC) throws BaseException {
		return blackListIntSourceDAO.getDynFilesBlackListedListCount(blackListIntSourceSC);
	}
	@Override
	public List<BlackListIntSourceCO> getDynFilesBlackListedList(BlackListIntSourceSC blackListIntSourceSC)
			throws BaseException {
		return blackListIntSourceDAO.getDynFilesBlackListedList(blackListIntSourceSC);
	}
	@Override
	public BlackListIntSourceCO depLookupFileName(BlackListIntSourceSC blackListIntSourceSC) throws BaseException {
		BlackListIntSourceCO blackListIntSourceCO;
		blackListIntSourceCO = blackListIntSourceDAO.depLookupFileName(blackListIntSourceSC);
		return blackListIntSourceCO;
	}

}
