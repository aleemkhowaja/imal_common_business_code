package com.path.vo.core.vault;

import java.math.BigDecimal;

import com.path.struts2.lib.common.GridParamsSC;

public class VaultSC extends GridParamsSC
{
    private String status;
    private BigDecimal privilege;
    private String vaultType;
    private String fromTransferCashVaultToVault;
    private BigDecimal vaultBranch;
    private String isTransferOfFund;
    private BigDecimal fromVaultBranch;
    private String dependencyOfFromVaultBranch;
    //DASI170153 
    private String isHoBranch;
    private String operationNature;
    private BigDecimal fromVaultCode;
    // added by nancy -14/07/2017-506480-SBI170091 - Rupee Traverler Cheque (RTC)
    private BigDecimal vaultCode;
    private BigDecimal vaultCy;
    private BigDecimal trxType;
    // end nancy
    private BigDecimal alBranchCode;
    private String separateVaultNo;
    private String vaultTypeIndicator;
    private String forbidTransferToMain;
    private String tabTransferType;
    private String isMainVault;
    private String vaultDirection;
    private String reference;
    
    
    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getPrivilege()
    {
	return privilege;
    }

    public void setPrivilege(BigDecimal privilege)
    {
	this.privilege = privilege;
    }

    public String getVaultType()
    {
	return vaultType;
    }

    public void setVaultType(String vaultType)
    {
        this.vaultType = vaultType;
    }

    public String getFromTransferCashVaultToVault()
    {
        return fromTransferCashVaultToVault;
    }

    public void setFromTransferCashVaultToVault(String fromTransferCashVaultToVault)
    {
        this.fromTransferCashVaultToVault = fromTransferCashVaultToVault;
    }

    public BigDecimal getVaultBranch()
    {
        return vaultBranch;
    }

    public void setVaultBranch(BigDecimal vaultBranch)
    {
        this.vaultBranch = vaultBranch;
    }

    public BigDecimal getVaultCode()
    {
        return vaultCode;
    }

    // added by nancy -14/07/2017-506480-SBI170091 - Rupee Traverler Cheque (RTC)
    public void setVaultCode(BigDecimal vaultCode)
    {
        this.vaultCode = vaultCode;
    }

    public BigDecimal getVaultCy()
    {
        return vaultCy;
    }

    public void setVaultCy(BigDecimal vaultCy)
    {
        this.vaultCy = vaultCy;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }
    // end nancy 

    public String getSeparateVaultNo()
    {
        return separateVaultNo;
    }

    public void setSeparateVaultNo(String separateVaultNo)
    {
        this.separateVaultNo = separateVaultNo;
    }

    public String getVaultTypeIndicator()
    {
        return vaultTypeIndicator;
    }

    public void setVaultTypeIndicator(String vaultTypeIndicator)
    {
        this.vaultTypeIndicator = vaultTypeIndicator;
    }

    public String getForbidTransferToMain()
    {
        return forbidTransferToMain;
    }

    public void setForbidTransferToMain(String forbidTransferToMain)
    {
        this.forbidTransferToMain = forbidTransferToMain;
    }

    public String getTabTransferType()
    {
        return tabTransferType;
    }

    public void setTabTransferType(String tabTransferType)
    {
        this.tabTransferType = tabTransferType;
    }

    public String getIsMainVault()
    {
        return isMainVault;
    }

    public void setIsMainVault(String isMainVault)
    {
        this.isMainVault = isMainVault;
    }

    public String getVaultDirection()
    {
        return vaultDirection;
    }

    public void setVaultDirection(String vaultDirection)
    {
        this.vaultDirection = vaultDirection;
    }

    public BigDecimal getAlBranchCode()
    {
        return alBranchCode;
    }

    public void setAlBranchCode(BigDecimal alBranchCode)
    {
        this.alBranchCode = alBranchCode;
    }

    public String getReference()
    {
        return reference;
    }

    public void setReference(String reference)
    {
        this.reference = reference;
    }




    
    public BigDecimal getFromVaultBranch()
    {
	return fromVaultBranch;
    }
    
    public void setFromVaultBranch(BigDecimal fromVaultBranch)
    {
	this.fromVaultBranch = fromVaultBranch;
    }
    
    public String getIsTransferOfFund()
    {
	return isTransferOfFund;
    }
    
    public void setIsTransferOfFund(String isTransferOfFund)
    {
	this.isTransferOfFund = isTransferOfFund;
    }

    public String getDependencyOfFromVaultBranch()
    {
        return dependencyOfFromVaultBranch;
    }

    public void setDependencyOfFromVaultBranch(String dependencyOfFromVaultBranch)
    {
        this.dependencyOfFromVaultBranch = dependencyOfFromVaultBranch;
    }

    public String getIsHoBranch()
    {
        return isHoBranch;
    }

    public void setIsHoBranch(String isHoBranch)
    {
        this.isHoBranch = isHoBranch;
    }

    public String getOperationNature()
    {
        return operationNature;
    }

    public void setOperationNature(String operationNature)
    {
        this.operationNature = operationNature;
    }

    public BigDecimal getFromVaultCode()
    {
        return fromVaultCode;
    }

    public void setFromVaultCode(BigDecimal fromVaultCode)
    {
        this.fromVaultCode = fromVaultCode;
    }

}
