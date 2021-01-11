package com.path.core.bo.blacklistmanagement.blacklistintsource;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.path.lib.common.exception.BaseException;
import com.path.vo.common.dynfiles.DynFilesSC;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceCO;
import com.path.vo.core.blacklistmanagement.BlackListIntSourceSC;

public interface BlackListIntSourceBO
{
    /**
     * get the count of matched CIF grid
     * 
     * @param BlackListIntSourceSC
     * @return Integer
     * @throws BaseException
     */
    public Integer getMatchedCIFListCount(BlackListIntSourceSC criteria) throws BaseException;

    /**
     * get the records of matched CIF grid
     * 
     * @param BlackListIntSourceSC
     * @return List<BlackListIntSourceCO>
     * @throws BaseException
     */
    public List<BlackListIntSourceCO> getMatchedCIFList(BlackListIntSourceSC criteria) throws BaseException;

    /**
     * get the count of white list grid
     * 
     * @param BlackListIntSourceSC
     * @return Integer
     * @throws BaseException
     */
    public Integer getWhiteListCount(BlackListIntSourceSC criteria) throws BaseException;

    /**
     * get the records of white list grid
     * 
     * @param BlackListIntSourceSC
     * @return List<BlackListIntSourceCO>
     * @throws BaseException
     */
    public List<BlackListIntSourceCO> getWhiteList(BlackListIntSourceSC criteria) throws BaseException;

    /**
     * switch the status of a cif list to suspicious
     * 
     * @param BlackListIntSourceCO
     * @return void
     * @throws BaseException
     */
    public void switchCIFToSuspicious(BlackListIntSourceCO blackListIntSourceCO) throws BaseException;

    /**
     * switch the status of a cif list to white list
     * 
     * @param BlackListIntSourceCO
     * @return void
     * @throws BaseException
     */
    public void switchCIFToWhiteList(BlackListIntSourceCO blackListIntSourceCO) throws BaseException;

    /**
     * switch the status of a cif list to black list
     * 
     * @param BlackListIntSourceCO
     * @return void
     * @throws BaseException
     */
    public void switchCIFToBlackList(BlackListIntSourceCO blackListIntSourceCO) throws BaseException;

    /**
     * upload an xml file related to UN or OFAC
     * 
     * @param dynFilesDetCO
     * @param dynFilesSC
     * @param fileByte
     * @return void
     * @throws BaseException, IOException
     */
    public void uploadFile(BlackListIntSourceSC criteria, DynFilesSC dynFilesSC, byte[] fileByte) throws BaseException,
	    IOException;

    /**
     * it continue executing file only after confirming alert
     * 
     * @param BlackListIntSourceSC
     * @param DynFilesSC
     * @throws BaseException
     */
    public void continueExecuting(BlackListIntSourceSC criteria, DynFilesSC dynFilesSC) throws BaseException;
    
    //addedb y bilal for TP#885556
    public Integer getDynFilesBlackListedListCount(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;

    public List<BlackListIntSourceCO> getDynFilesBlackListedList(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;
    
    public BlackListIntSourceCO depLookupFileName(BlackListIntSourceSC blackListIntSourceSC) throws BaseException;

}
