package com.path.bo.core.vault.impl;

import java.util.List;

import com.path.bo.common.ConstantsCommon;
import com.path.bo.core.vault.VaultBO;
import com.path.dao.core.vault.VaultDAO;
import com.path.dbmaps.vo.BRANCHESVO;
import com.path.dbmaps.vo.CTSCONTROLVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.lib.common.base.BaseBO;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.StringUtil;
import com.path.vo.core.vault.VaultSC;

public class VaultBOImpl extends BaseBO implements VaultBO
{
   private VaultDAO vaultDAO;

    /**
     * return the Vault lookup list count  
     * @param vaultSC
     * @return int
     * @throws BaseException
     */
    public int returnVaultLookupCount(VaultSC vaultSC) throws BaseException
    {
	vaultSC = this.checkIsTransfer(vaultSC);
	//DASI170153
	BRANCHESVO branchesVO = new BRANCHESVO();
	branchesVO.setCOMP_CODE(vaultSC.getCompCode());
	branchesVO.setBRANCH_CODE(vaultSC.getBranchCode());
	branchesVO= (BRANCHESVO)genericDAO.selectByPK(branchesVO);
	if("1".equals(vaultSC.getOperationNature()) || "2".equals(vaultSC.getOperationNature()))
	{
	    vaultSC.setIsHoBranch(branchesVO.getBR_TYPE());	 
	}
	if(("2".equals(vaultSC.getOperationNature()) && "H".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null)
		|| ("3".equals(vaultSC.getOperationNature()) && vaultSC.getVaultBranch() != null )//BUG 640684
		|| ("".equals(vaultSC.getOperationNature()) && vaultSC.getVaultBranch() != null))//BUG 640684
	{
	    vaultSC.setBranchCode(vaultSC.getVaultBranch());
	}
	if(("2".equals(vaultSC.getOperationNature()) && "B".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null)
		|| ("1".equals(vaultSC.getOperationNature()) && "H".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null))
	{
	    vaultSC.setVaultBranch(vaultSC.getVaultBranch());
	}
	return vaultDAO.returnVaultLookupCount(vaultSC);
    }

    public VaultDAO getVaultDAO()
    {
        return vaultDAO;
    }

    public void setVaultDAO(VaultDAO vaultDAO)
    {
        this.vaultDAO = vaultDAO;
    }

    public List<CTSTELLERVO> returnVaultLookupData(VaultSC vaultSC) throws BaseException
    {
	vaultSC = this.checkIsTransfer(vaultSC);
	//DASI170153
	BRANCHESVO branchesVO = new BRANCHESVO();
	branchesVO.setCOMP_CODE(vaultSC.getCompCode());
	branchesVO.setBRANCH_CODE(vaultSC.getBranchCode());
	branchesVO= (BRANCHESVO)genericDAO.selectByPK(branchesVO);
	if("1".equals(vaultSC.getOperationNature()) || "2".equals(vaultSC.getOperationNature()))
	{
	    vaultSC.setIsHoBranch(branchesVO.getBR_TYPE());	 
	}
	if(("2".equals(vaultSC.getOperationNature()) && "H".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null)
		|| ("3".equals(vaultSC.getOperationNature()) && vaultSC.getVaultBranch() != null )//BUG 640684
		|| ("".equals(vaultSC.getOperationNature()) && vaultSC.getVaultBranch() != null))//BUG 640684
	{
	    vaultSC.setBranchCode(vaultSC.getVaultBranch());
	}
	if(("2".equals(vaultSC.getOperationNature()) && "B".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null)
		|| ("1".equals(vaultSC.getOperationNature()) && "H".equals(branchesVO.getBR_TYPE()) && vaultSC.getVaultBranch() != null))
	{
	    vaultSC.setVaultBranch(vaultSC.getVaultBranch());
	}
	return vaultDAO.returnVaultLookupData(vaultSC);
    }
    
    private VaultSC checkIsTransfer(VaultSC vaultSC) throws BaseException
    {
	CTSCONTROLVO ctsControlVO = new CTSCONTROLVO();
	ctsControlVO.setCOMP_CODE(vaultSC.getCompCode());
	ctsControlVO.setBRANCH_CODE(vaultSC.getBranchCode());
	ctsControlVO = commonLibBO.returnCtsControlDetails(ctsControlVO);
	
	if(ConstantsCommon.ONE.equals(StringUtil.nullEmptyToValue(ctsControlVO.getALLOW_TRSFR_MAIN_VAULT_YN(), ConstantsCommon.ZERO)))
	{
	    vaultSC.setIsTransferOfFund(ConstantsCommon.ONE);
	}
	else
	{
	    vaultSC.setIsTransferOfFund(ConstantsCommon.ZERO);
	}
	return vaultSC;
    }

}
