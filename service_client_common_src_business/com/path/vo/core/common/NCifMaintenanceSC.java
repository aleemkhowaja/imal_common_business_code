package com.path.vo.core.common;

import java.math.BigDecimal;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_EXTENDEDVO;
import com.path.struts2.lib.common.BaseSC;

/**
 * added by jihadlamaa
 * 
 */
public class NCifMaintenanceSC extends BaseSC
{

    private CIFVO cifVO = new CIFVO();
    private CIF_EXTENDEDVO cif_EXTENDEDVO = new CIF_EXTENDEDVO();
    private BigDecimal errorCode;
    private String errorMessage;
    private BigDecimal cifNo;

    private String uniqueFieldName;
    private String valueUniqueFieldName;
    //
    private String type;
    private BigDecimal idType;
    private String idNo;
    private String statusDeleted;
    private BigDecimal idType2;
    private String idNo2;
    private String bank;

    private String status;
    private int countField;

    private String checkUniqness;

    private String shortNameEng;
    private String longNameEng;
    private String firstNameEng;
    private String secNameEng;
    private String thirdNameEng;
    private String lastNameEng;

    private String shortNameAr;
    private String longNameAr;
    private String firstNameAr;
    private String secNameAr;
    private String thirdNameAr;
    private String lastNameAr;

    private String BfNameUnique;
    private String LgNameUnique;

    private String BfANameUnique;
    private String LgANameUnique;

    private String NameDetailsUnique;
    private String NameDetailsUniqueAr;
    private String isJoinNull = "";
    private String tableName;
    private String operator = "";

    private String shortNameEngOpeartor;
    private String longNameEngOpeartor;
    private String firstNameEngOpeartor;
    private String secNameEngOpeartor;
    private String thirdNameEngOpeartor;
    private String lastNameEngOpeartor;

    private String shortNameArOpeartor;
    private String longNameArOpeartor;

    private String firstNameArOpeartor;
    private String secNameArOpeartor;
    private String thirdNameArOpeartor;
    private String lastNameArOpeartor;

    private String condSatisfied = "0";
    
    //added by John Massaad to IIAB100318
    private String accountType;
    private BigDecimal firstCIFNo;
    private BigDecimal lastCIFNo;
    
    private BigDecimal compCodeCif;
    
    private String fromValidationOfIdType2;
    
    private String statusSuspended;
    
    private BigDecimal obligorCode;

    //Rania - BMO180181
    private String enableUniquenessByCifTypeOnly;
    private BigDecimal cifType;
    private String joinIdNo;
    private BigDecimal joinIdType;
    //

    public String getCondSatisfied()
    {
	return condSatisfied;
    }

    public void setCondSatisfied(String condSatisfied)
    {
	this.condSatisfied = condSatisfied;
    }

    public String getShortNameEngOpeartor()
    {
	return shortNameEngOpeartor;
    }

    public void setShortNameEngOpeartor(String shortNameEngOpeartor)
    {
	this.shortNameEngOpeartor = shortNameEngOpeartor;
    }

    public String getLongNameEngOpeartor()
    {
	return longNameEngOpeartor;
    }

    public void setLongNameEngOpeartor(String longNameEngOpeartor)
    {
	this.longNameEngOpeartor = longNameEngOpeartor;
    }

    public String getFirstNameEngOpeartor()
    {
	return firstNameEngOpeartor;
    }

    public void setFirstNameEngOpeartor(String firstNameEngOpeartor)
    {
	this.firstNameEngOpeartor = firstNameEngOpeartor;
    }

    public String getSecNameEngOpeartor()
    {
	return secNameEngOpeartor;
    }

    public void setSecNameEngOpeartor(String secNameEngOpeartor)
    {
	this.secNameEngOpeartor = secNameEngOpeartor;
    }

    public String getThirdNameEngOpeartor()
    {
	return thirdNameEngOpeartor;
    }

    public void setThirdNameEngOpeartor(String thirdNameEngOpeartor)
    {
	this.thirdNameEngOpeartor = thirdNameEngOpeartor;
    }

    public String getLastNameEngOpeartor()
    {
	return lastNameEngOpeartor;
    }

    public void setLastNameEngOpeartor(String lastNameEngOpeartor)
    {
	this.lastNameEngOpeartor = lastNameEngOpeartor;
    }

    public String getShortNameArOpeartor()
    {
	return shortNameArOpeartor;
    }

    public void setShortNameArOpeartor(String shortNameArOpeartor)
    {
	this.shortNameArOpeartor = shortNameArOpeartor;
    }

    public String getLongNameArOpeartor()
    {
	return longNameArOpeartor;
    }

    public void setLongNameArOpeartor(String longNameArOpeartor)
    {
	this.longNameArOpeartor = longNameArOpeartor;
    }

    public String getFirstNameArOpeartor()
    {
	return firstNameArOpeartor;
    }

    public void setFirstNameArOpeartor(String firstNameArOpeartor)
    {
	this.firstNameArOpeartor = firstNameArOpeartor;
    }

    public String getSecNameArOpeartor()
    {
	return secNameArOpeartor;
    }

    public void setSecNameArOpeartor(String secNameArOpeartor)
    {
	this.secNameArOpeartor = secNameArOpeartor;
    }

    public String getThirdNameArOpeartor()
    {
	return thirdNameArOpeartor;
    }

    public void setThirdNameArOpeartor(String thirdNameArOpeartor)
    {
	this.thirdNameArOpeartor = thirdNameArOpeartor;
    }

    public String getLastNameArOpeartor()
    {
	return lastNameArOpeartor;
    }

    public void setLastNameArOpeartor(String lastNameArOpeartor)
    {
	this.lastNameArOpeartor = lastNameArOpeartor;
    }

    public BigDecimal getCifNo()
    {
	return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
	this.cifNo = cifNo;
    }

    public String getType()
    {
	return type;
    }

    public void setType(String type)
    {
	this.type = type;
    }

    public BigDecimal getIdType()
    {
	return idType;
    }

    public void setIdType(BigDecimal idType)
    {
	this.idType = idType;
    }

    public String getIdNo()
    {
	return idNo;
    }

    public void setIdNo(String idNo)
    {
	this.idNo = idNo;
    }

    public int getCountField()
    {
	return countField;
    }

    public void setCountField(int countField)
    {
	this.countField = countField;
    }

    public String getCheckUniqness()
    {
	return checkUniqness;
    }

    public void setCheckUniqness(String checkUniqness)
    {
	this.checkUniqness = checkUniqness;
    }

    public String getFirstNamEng()
    {
	return firstNameEng;
    }

    public void setFirstNamEng(String firstNamEng)
    {
	this.firstNameEng = firstNamEng;
    }

    public String getSecNameEng()
    {
	return secNameEng;
    }

    public void setSecNameEng(String secNameEng)
    {
	this.secNameEng = secNameEng;
    }

    public String getThirdNameEng()
    {
	return thirdNameEng;
    }

    public void setThirdNameEng(String thirdNameEng)
    {
	this.thirdNameEng = thirdNameEng;
    }

    public String getLastNameEng()
    {
	return lastNameEng;
    }

    public void setLastNameEng(String lastNameEng)
    {
	this.lastNameEng = lastNameEng;
    }

    public String getShortNameEng()
    {
	return shortNameEng;
    }

    public void setShortNameEng(String shortNameEng)
    {
	this.shortNameEng = shortNameEng;
    }

    public String getLongNameEng()
    {
	return longNameEng;
    }

    public void setLongNameEng(String longNameEng)
    {
	this.longNameEng = longNameEng;
    }

    public String getFirstNameAr()
    {
	return firstNameAr;
    }

    public void setFirstNameAr(String firstNameAr)
    {
	this.firstNameAr = firstNameAr;
    }

    public String getSecNameAr()
    {
	return secNameAr;
    }

    public void setSecNameAr(String secNameAr)
    {
	this.secNameAr = secNameAr;
    }

    public String getThirdNameAr()
    {
	return thirdNameAr;
    }

    public void setThirdNameAr(String thirdNameAr)
    {
	this.thirdNameAr = thirdNameAr;
    }

    public String getLastNameAr()
    {
	return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr)
    {
	this.lastNameAr = lastNameAr;
    }

    public String getShortNameAr()
    {
	return shortNameAr;
    }

    public void setShortNameAr(String shortNameAr)
    {
	this.shortNameAr = shortNameAr;
    }

    public String getLongNameAr()
    {
	return longNameAr;
    }

    public void setLongNameAr(String longNameAr)
    {
	this.longNameAr = longNameAr;
    }

    public String getBfNameUnique()
    {
	return BfNameUnique;
    }

    public void setBfNameUnique(String bfNameUnique)
    {
	BfNameUnique = bfNameUnique;
    }

    public String getLgNameUnique()
    {
	return LgNameUnique;
    }

    public void setLgNameUnique(String lgNameUnique)
    {
	LgNameUnique = lgNameUnique;
    }

    public String getBfANameUnique()
    {
	return BfANameUnique;
    }

    public void setBfANameUnique(String bfANameUnique)
    {
	BfANameUnique = bfANameUnique;
    }

    public String getLgANameUnique()
    {
	return LgANameUnique;
    }

    public void setLgANameUnique(String lgANameUnique)
    {
	LgANameUnique = lgANameUnique;
    }

    public String getNameDetailsUnique()
    {
	return NameDetailsUnique;
    }

    public void setNameDetailsUnique(String nameDetailsUnique)
    {
	NameDetailsUnique = nameDetailsUnique;
    }

    public String getNameDetailsUniqueAr()
    {
	return NameDetailsUniqueAr;
    }

    public void setNameDetailsUniqueAr(String nameDetailsUniqueAr)
    {
	NameDetailsUniqueAr = nameDetailsUniqueAr;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public String getValueUniqueFieldName()
    {
	return valueUniqueFieldName;
    }

    public void setValueUniqueFieldName(String valueUniqueFieldName)
    {
	this.valueUniqueFieldName = valueUniqueFieldName;
    }

    public String getIsJoinNull()
    {
	return isJoinNull;
    }

    public void setIsJoinNull(String isJoinNull)
    {
	this.isJoinNull = isJoinNull;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public BigDecimal getErrorCode()
    {
	return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
	this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
	this.errorMessage = errorMessage;
    }

    public String getFirstNameEng()
    {
	return firstNameEng;
    }

    public void setFirstNameEng(String firstNameEng)
    {
	this.firstNameEng = firstNameEng;
    }

    public String getTableName()
    {
	return tableName;
    }

    public void setTableName(String tableName)
    {
	this.tableName = tableName;
    }

    public void setOperator(String operator)
    {
	this.operator = operator;
    }

    public String getOperator()
    {
	return operator;
    }

    public String getStatusDeleted()
    {
	return statusDeleted;
    }

    public void setStatusDeleted(String statusDeleted)
    {
	this.statusDeleted = statusDeleted;
    }

    public BigDecimal getIdType2()
    {
	return idType2;
    }

    public void setIdType2(BigDecimal idType2)
    {
	this.idType2 = idType2;
    }

    public String getIdNo2()
    {
	return idNo2;
    }

    public void setIdNo2(String idNo2)
    {
	this.idNo2 = idNo2;
    }

    public String getBank()
    {
	return bank;
    }

    public void setBank(String bank)
    {
	this.bank = bank;
    }

    public String getUniqueFieldName()
    {
        return uniqueFieldName;
    }

    public void setUniqueFieldName(String uniqueFieldName)
    {
        this.uniqueFieldName = uniqueFieldName;
    }

    public String getAccountType()
    {
        return accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public BigDecimal getFirstCIFNo()
    {
        return firstCIFNo;
    }

    public void setFirstCIFNo(BigDecimal firstCIFNo)
    {
        this.firstCIFNo = firstCIFNo;
    }

    public BigDecimal getLastCIFNo()
    {
        return lastCIFNo;
    }

    public void setLastCIFNo(BigDecimal lastCIFNo)
    {
        this.lastCIFNo = lastCIFNo;
    }

    public String getFromValidationOfIdType2()
    {
        return fromValidationOfIdType2;
    }

    public void setFromValidationOfIdType2(String fromValidationOfIdType2)
    {
        this.fromValidationOfIdType2 = fromValidationOfIdType2;
    }

    public BigDecimal getCompCodeCif()
    {
        return compCodeCif;
    }

    public void setCompCodeCif(BigDecimal compCodeCif)
    {
        this.compCodeCif = compCodeCif;
    }

	
	public String getEnableUniquenessByCifTypeOnly()
	{
		return enableUniquenessByCifTypeOnly;
	}

	
	public void setEnableUniquenessByCifTypeOnly(String enableUniquenessByCifTypeOnly)
	{
		this.enableUniquenessByCifTypeOnly = enableUniquenessByCifTypeOnly;
	}

	
	public BigDecimal getCifType()
	{
		return cifType;
	}

	
	public void setCifType(BigDecimal cifType)
	{
		this.cifType = cifType;
	}

	
	public String getJoinIdNo()
	{
		return joinIdNo;
	}

	
	public void setJoinIdNo(String joinIdNo)
	{
		this.joinIdNo = joinIdNo;
	}

	
	public BigDecimal getJoinIdType()
	{
		return joinIdType;
	}

	
	public void setJoinIdType(BigDecimal joinIdType)
	{
		this.joinIdType = joinIdType;
	}

	public CIF_EXTENDEDVO getCif_EXTENDEDVO()
	{
	    return cif_EXTENDEDVO;
	}

	public void setCif_EXTENDEDVO(CIF_EXTENDEDVO cif_EXTENDEDVO)
	{
	    this.cif_EXTENDEDVO = cif_EXTENDEDVO;
	}

	public String getStatusSuspended()
	{
	    return statusSuspended;
	}

	public void setStatusSuspended(String statusSuspended)
	{
	    this.statusSuspended = statusSuspended;
	}

	public BigDecimal getObligorCode()
	{
	    return obligorCode;
	}

	public void setObligorCode(BigDecimal obligorCode)
	{
	    this.obligorCode = obligorCode;
	}
	
	
}
