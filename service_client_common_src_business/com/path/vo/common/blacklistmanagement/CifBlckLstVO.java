package com.path.vo.common.blacklistmanagement;

import java.math.BigDecimal;
import java.util.Date;
import com.path.lib.vo.BaseVO;

public class CifBlckLstVO extends BaseVO
{
    private BigDecimal		compCode;
    private BigDecimal		cifNo;
    private BigDecimal		blCode;
    private String		longName;
    private String		nameAR;
    private String		title;
    private String		designation;
    private String		strDOB;
    private Date		dateDOB;
    private String		POB;
    private String		nationality;
    private String		passportNO;
    private String		blType;
    private String		blChecked;
    private BigDecimal		jointCIF;
    private String		columnName;
    private String		idType;
    private BigDecimal		returnBlCode;
    
    public BigDecimal getCompCode()
    {
        return compCode;
    }
    public void setCompCode(BigDecimal compCode)
    {
        this.compCode = compCode;
    }
    public BigDecimal getCifNo()
    {
        return cifNo;
    }
    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    public BigDecimal getBlCode()
    {
        return blCode;
    }
    public void setBlCode(BigDecimal blCode)
    {
        this.blCode = blCode;
    }
    public String getLongName()
    {
        return longName;
    }
    public void setLongName(String longName)
    {
        this.longName = longName;
    }
    public String getNameAR()
    {
        return nameAR;
    }
    public void setNameAR(String nameAR)
    {
        this.nameAR = nameAR;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getDesignation()
    {
        return designation;
    }
    public void setDesignation(String designation)
    {
        this.designation = designation;
    }
    public String getStrDOB()
    {
        return strDOB;
    }
    public void setStrDOB(String strDOB)
    {
        this.strDOB = strDOB;
    }
    public Date getDateDOB()
    {
        return dateDOB;
    }
    public void setDateDOB(Date dateDOB)
    {
        this.dateDOB = dateDOB;
    }
    public String getPOB()
    {
        return POB;
    }
    public void setPOB(String pOB)
    {
        POB = pOB;
    }
    public String getNationality()
    {
        return nationality;
    }
    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }
    public String getPassportNO()
    {
        return passportNO;
    }
    public void setPassportNO(String passportNO)
    {
        this.passportNO = passportNO;
    }
    public String getBlType()
    {
        return blType;
    }
    public void setBlType(String blType)
    {
        this.blType = blType;
    }
    public String getBlChecked()
    {
        return blChecked;
    }
    public void setBlChecked(String blChecked)
    {
        this.blChecked = blChecked;
    }
    public BigDecimal getJointCIF()
    {
        return jointCIF;
    }
    public void setJointCIF(BigDecimal jointCIF)
    {
        this.jointCIF = jointCIF;
    }
    public String getColumnName()
    {
        return columnName;
    }
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }
    public String getIdType()
    {
        return idType;
    }
    public void setIdType(String idType)
    {
        this.idType = idType;
    }
    public BigDecimal getReturnBlCode()
    {
        return returnBlCode;
    }
    public void setReturnBlCode(BigDecimal returnBlCode)
    {
        this.returnBlCode = returnBlCode;
    }
}
