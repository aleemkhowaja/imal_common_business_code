package com.path.bo.core.mosblacklist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.blacklistmanagement.CifBlckLstVO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;

public interface MosBlackListBO 


{    
    public boolean checkCifBlcklist(MosBlackListCO mosBlackListCO) throws BaseException;
    public ArrayList<CifBlckLstVO> checkIdBlcklist(MosBlackListSC mosBlackListSC) throws BaseException;
    public MosBlackListCO checkSucpiciousIdBlcklist(MosBlackListSC mosBlackListSC) throws BaseException;
    public BigDecimal returnBlackListByCIFNO(MosBlackListSC mosBlackListSC) throws BaseException;
    public MosBlackListCO returnBlkTypeSource(MosBlackListSC mosBlackListSC) throws BaseException;
    /**
     * returns the list of black list CifBlckLstVO
     */
    public ArrayList<CifBlckLstVO> returncifBlackList(MosBlackListSC mosBlackListSC) throws BaseException;
    
    public List<BigDecimal> returnBlackListByID(MosBlackListSC mosBlackListSC) throws BaseException;
    public String showcifBlackListed(MosBlackListSC mosBlackListSC) throws DAOException;
    public Integer suspiciousBlackListUNMainRecordCount(MosBlackListSC mosBlackListSC) throws BaseException; 
    public Integer getSuspiciousBlackListRecordCount(MosBlackListSC mosBlackListSC) throws BaseException; 
    public ArrayList<MosBlackListCO> getSuspiciousBlackListList (MosBlackListSC criteria) throws BaseException; 
    public ArrayList<MosBlackListCO> suspiciousBlackListUNMainList (MosBlackListSC criteria) throws BaseException;
    public void saveSuspiciousRecords(MosBlackListCO mosBlackListCO) throws BaseException; 
    public ArrayList<CIF_JOINT_DETVO> selectJointName (MosBlackListSC criteria) throws BaseException;
    public ArrayList<MosBlackListCO> suspiciousBlackListJointMainList (MosBlackListSC criteria) throws DAOException;
    public BigDecimal countTrsBlackList(MosBlackListCO mosBlackListCO) throws BaseException;
    
    public void whiteListCif(MosBlackListCO mosBlackListCO) throws BaseException;
 
}
