package com.path.vo.core.idtype;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;
import com.path.vo.core.blacklistmanagement.BlackListIdsCO;

public class IdTypeSC extends GridParamsSC
{
    private BigDecimal idTypeCode;
    private BigDecimal idTypeCode2;
    private BigDecimal cifTypeCode;
    // added by jihad in order to filter the mandatories ID
    private String idTypeMandYn;
    private String existInAllowIds;
    private String idNoCode;
    private String showInvalideCodeMsg;
    private String elements;
    List<BlackListIdsCO> IdTypeCOList = new ArrayList<BlackListIdsCO>();
    private BigDecimal cifNo;
    
    //TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    private String countryOfIssuanceIDName;
    private String countryOfIssuanceDescIDName;
    private String fromGrid;
    
    //US#227979 - BB140191
    private BigDecimal trxType;
    private String enableMagneticCardReader;
    private String eligibility;

    
    private BigDecimal memberCifNo;
    private String fromMember;
    public String getExistInAllowIds()
    {
	return existInAllowIds;
    }

    public void setExistInAllowIds(String existInAllowIds)
    {
	this.existInAllowIds = existInAllowIds;
    }

    public BigDecimal getIdTypeCode()
    {
	return idTypeCode;
    }

    public String getIdTypeMandYn()
    {
	return idTypeMandYn;
    }

    public void setIdTypeMandYn(String idTypeMandYn)
    {
	this.idTypeMandYn = idTypeMandYn;
    }

    public void setIdTypeCode(BigDecimal idTypeCode)
    {
	this.idTypeCode = idTypeCode;
    }

    public BigDecimal getCifTypeCode()
    {
	return cifTypeCode;
    }

    public void setCifTypeCode(BigDecimal cifTypeCode)
    {
	this.cifTypeCode = cifTypeCode;
    }

    public List<BlackListIdsCO> getIdTypeCOList()
    {
	return IdTypeCOList;
    }

    public void setIdTypeCOList(List<BlackListIdsCO> idTypeCOList)
    {
	IdTypeCOList = idTypeCOList;
    }

    public String getShowInvalideCodeMsg()
    {
        return showInvalideCodeMsg;
    }

    public void setShowInvalideCodeMsg(String showInvalideCodeMsg)
    {
        this.showInvalideCodeMsg = showInvalideCodeMsg;
    }

    /**
     * @return the idTypeCode2
     */
    public BigDecimal getIdTypeCode2()
    {
        return idTypeCode2;
    }

    /**
     * @param idTypeCode2 the idTypeCode2 to set
     */
    public void setIdTypeCode2(BigDecimal idTypeCode2)
    {
        this.idTypeCode2 = idTypeCode2;
    }

    /**
     * @return the elements
     */
    public String getElements()
    {
        return elements;
    }

    /**
     * @param elements the elements to set
     */
    public void setElements(String elements)
    {
        this.elements = elements;
    }

    public String getCountryOfIssuanceIDName()
    {
        return countryOfIssuanceIDName;
    }

    public void setCountryOfIssuanceIDName(String countryOfIssuanceIDName)
    {
        this.countryOfIssuanceIDName = countryOfIssuanceIDName;
    }

    public String getCountryOfIssuanceDescIDName()
    {
        return countryOfIssuanceDescIDName;
    }

    public void setCountryOfIssuanceDescIDName(String countryOfIssuanceDescIDName)
    {
        this.countryOfIssuanceDescIDName = countryOfIssuanceDescIDName;
    }

    public String getFromGrid()
    {
        return fromGrid;
    }

    public void setFromGrid(String fromGrid)
    {
        this.fromGrid = fromGrid;
    }
    
    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getIdNoCode()
    {
	return idNoCode;
    }

    public void setIdNoCode(String idNoCode)
    {
	this.idNoCode = idNoCode;
    }

    public BigDecimal getTrxType()
    {
        return trxType;
    }

    public void setTrxType(BigDecimal trxType)
    {
        this.trxType = trxType;
    }

    public String getEnableMagneticCardReader()
    {
        return enableMagneticCardReader;
    }

    public void setEnableMagneticCardReader(String enableMagneticCardReader)
    {
        this.enableMagneticCardReader = enableMagneticCardReader;
    }

    public BigDecimal getMemberCifNo()
    {
        return memberCifNo;
    }

    public void setMemberCifNo(BigDecimal memberCifNo)
    {
        this.memberCifNo = memberCifNo;
    }

    public String getFromMember()
    {
        return fromMember;
    }

    public void setFromMember(String fromMember)
    {
        this.fromMember = fromMember;
    }


	public String getEligibility()
	{
	    return eligibility;
	}

	public void setEligibility(String eligibility)
	{
	    this.eligibility = eligibility;
	}

}
