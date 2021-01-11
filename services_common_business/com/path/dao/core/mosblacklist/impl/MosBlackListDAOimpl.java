package com.path.dao.core.mosblacklist.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dao.core.mosblacklist.MosBlackListDAO;
import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.lib.common.base.BaseDAO;
import com.path.lib.common.exception.DAOException;
import com.path.vo.common.blacklistmanagement.CifBlckLstVO;
import com.path.vo.common.blacklistmanagement.MosBlackListCO;
import com.path.vo.common.blacklistmanagement.MosBlackListSC;
import com.path.vo.core.blacklistmanagement.BlackListSC;

public class MosBlackListDAOimpl extends BaseDAO implements MosBlackListDAO
{

    public int checkCifBlcklist(MosBlackListSC mosBlackListSC) throws DAOException

    {
        return 1;

        // getSqlMap().update("mosBlackList.checkCifBlcklist", mosBlackListSC);
    }

    /**
     * returns the list of black list CifBlckLstVO
     */
    public ArrayList<CifBlckLstVO> returncifBlackList(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (ArrayList<CifBlckLstVO>) getSqlMap().queryForList("mosBlackList.returncifBlackList",
            mosBlackListSC);
    }

    public List<BigDecimal> returnMOSBlackListedCif(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return  getSqlMap().queryForList("mosBlackList.returnMOSBlackListedCif", mosBlackListSC);
    }

    public List<BigDecimal> returnUNBlackListedCif(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return getSqlMap().queryForList("mosBlackList.returnUNBlackListedCif", mosBlackListSC);
    }

    public List<BigDecimal> returnOFACBlackListedCif(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return getSqlMap().queryForList("mosBlackList.returnOFACBlackListedCif", mosBlackListSC);
    }

    public List<BigDecimal> returnBlackListByID(MosBlackListSC mosBlackListSC) throws DAOException
    {
        List<BigDecimal> i = null;
        try
        {
            i = getSqlMap().queryForList("mosBlackList.getBlackListByID", mosBlackListSC);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public List<BigDecimal> returnBlackListByRegisterNO(MosBlackListSC mosBlackListSC) throws DAOException
    {
        List<BigDecimal> i = null;
        try
        {
            i = getSqlMap().queryForList("mosBlackList.getBlackListByRegisterNO", mosBlackListSC);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return i;
    }

    public MosBlackListCO returnBlkTypeSource(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (MosBlackListCO) getSqlMap().queryForObject("mosBlackList.returnBlkTypeSource", mosBlackListSC);

    }

    public BigDecimal returnBlackListByCIFNO(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (BigDecimal) getSqlMap().queryForObject("mosBlackList.returnBlackListByCIFNO", mosBlackListSC);
    }

    @Override
    public String showcifBlackListed(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (String) getSqlMap().queryForObject("mosBlackList.showcifBlackListed", mosBlackListSC);
    }

    public Integer suspiciousBlackListUNMainRecordCount(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (Integer) getSqlMap().queryForObject("mosBlackList.suspiciousBlackListUNMainRecordCount",
            mosBlackListSC);
    }

    public void updateFillCifBlacklistMos(BlackListSC criteria) throws DAOException
    {
        getSqlMap().update("BlackListMapper.updateFillCifBlacklistMos", criteria);
    }

    public Integer getSuspiciousBlackListRecordCount(MosBlackListSC mosBlackListSC) throws DAOException
    {
        return (Integer) getSqlMap().queryForObject("mosBlackList.getSuspiciousBlackListRecordCount",
            mosBlackListSC);
    }

    public ArrayList<MosBlackListCO> getSuspiciousBlackListList(MosBlackListSC criteria) throws DAOException
    {
        return (ArrayList<MosBlackListCO>) getSqlMap().queryForList("mosBlackList.getSuspiciousBlackListList",
            criteria);
    }

    public ArrayList<MosBlackListCO> suspiciousBlackListUNMainList(MosBlackListSC criteria) throws DAOException
    {
        // ArrayList<MosBlackListCO> suspiciousList =null;

        // if (criteria.getCifNO() != null)
        // {
        // suspiciousList =(ArrayList<MosBlackListCO>)
        // getSqlMap().queryForList("mosBlackList.getSuspiciousBlackListList", criteria);
        // }

        ArrayList<MosBlackListCO> UNList = (ArrayList<MosBlackListCO>) getSqlMap().queryForList(
            "mosBlackList.suspiciousBlackListUNMainList", criteria);

        // if (suspiciousList != null && suspiciousList.size() >0)
        // {
        // UNList.addAll(suspiciousList);
        // }
        return UNList;
    }

    public ArrayList<MosBlackListCO> suspiciousBlackListJointMainList(MosBlackListSC criteria)
        throws DAOException
    {
        ArrayList<MosBlackListCO> UNList = (ArrayList<MosBlackListCO>) getSqlMap().queryForList(
            "mosBlackList.suspiciousBlackListUNMainList", criteria);
        return UNList;
    }

    @Override
    public void saveSuspiciousRecords(MosBlackListCO mosBlackListCO) throws DAOException
    {
        getSqlMap().delete("mosBlackList.deleteSuspiciousRecords", mosBlackListCO);
        for(MosBlackListCO tmpCO : mosBlackListCO.getSuspiciousGridList())
        {
            tmpCO.setCompCode(mosBlackListCO.getCompCode());
            tmpCO.setCifNo(mosBlackListCO.getCifNo());
            getSqlMap().insert("mosBlackList.saveSuspiciousRecords", tmpCO);
        }
    }

    public ArrayList<CIF_JOINT_DETVO> selectJointName(MosBlackListSC criteria) throws DAOException
    {
        return (ArrayList<CIF_JOINT_DETVO>) getSqlMap().queryForList("mosBlackList.selectJointName", criteria);
    }

    public BigDecimal countTrsBlackList(MosBlackListCO mosBlackListCO) throws DAOException
    {
        return (BigDecimal) getSqlMap().queryForObject("mosBlackList.countTrsBlackList", mosBlackListCO);
    }

    public void whiteListCif(MosBlackListCO mosBlackListCO) throws DAOException
    {
        getSqlMap().update("mosBlackList.whiteListCif", mosBlackListCO);
    }

    public List returnCriteriaMatching(MosBlackListSC mosBlackListSC) throws DAOException
    {
	
	return getSqlMap().queryForList("mosBlackList.returnCriteriaMatching", mosBlackListSC);
	
    }

}
