package com.path.dao.core.mosblacklist;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.blacklistmanagement.CifBlckLstVO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public interface MosBlackListDAO
{
    
    public int  checkCifBlcklist(MosBlackListSC mosBlackListSC) throws DAOException;
    public ArrayList<CifBlckLstVO> returncifBlackList(MosBlackListSC mosBlackListSC) throws DAOException;
    public List<BigDecimal> returnMOSBlackListedCif (MosBlackListSC mosBlackListSC) throws DAOException;
    public List<BigDecimal> returnUNBlackListedCif (MosBlackListSC mosBlackListSC) throws DAOException;
    public List<BigDecimal> returnOFACBlackListedCif (MosBlackListSC mosBlackListSC) throws DAOException;
    public List<BigDecimal> returnBlackListByID (MosBlackListSC mosBlackListSC) throws DAOException;
    public List<BigDecimal> returnBlackListByRegisterNO (MosBlackListSC mosBlackListSC) throws DAOException;
    public MosBlackListCO returnBlkTypeSource(MosBlackListSC mosBlackListSC) throws DAOException;
    public BigDecimal returnBlackListByCIFNO(MosBlackListSC mosBlackListSC) throws DAOException;
    public String showcifBlackListed(MosBlackListSC mosBlackListSC) throws DAOException;
    public Integer suspiciousBlackListUNMainRecordCount(MosBlackListSC mosBlackListSC) throws DAOException;
    public  Integer getSuspiciousBlackListRecordCount(MosBlackListSC mosBlackListSC) throws DAOException;
    public ArrayList<MosBlackListCO> getSuspiciousBlackListList (MosBlackListSC criteria) throws DAOException; 
    public ArrayList<MosBlackListCO> suspiciousBlackListUNMainList (MosBlackListSC criteria) throws DAOException;
    public void saveSuspiciousRecords(MosBlackListCO mosBlackListCO) throws DAOException;
    public ArrayList<CIF_JOINT_DETVO> selectJointName (MosBlackListSC criteria) throws DAOException;
    public ArrayList<MosBlackListCO> suspiciousBlackListJointMainList (MosBlackListSC criteria) throws DAOException;
    public BigDecimal countTrsBlackList(MosBlackListCO mosBlackListCO) throws DAOException;
    public void whiteListCif(MosBlackListCO mosBlackListCO) throws DAOException;
    public List returnCriteriaMatching(MosBlackListSC mosBlackListSC) throws DAOException;
}
