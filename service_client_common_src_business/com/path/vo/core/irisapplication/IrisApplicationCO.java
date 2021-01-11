/**
 * @Date:Feb 7, 2012
 * @Team:JAVA Team.
 * @copyright: PathSolution 2012
 */
package com.path.vo.core.irisapplication;

import java.math.BigDecimal;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_IRISVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.vo.core.common.RetailBaseVO;

public class IrisApplicationCO extends RetailBaseVO
{
    private BigDecimal irisId;
    private List<CIFVO> scannedCifs;
    
    private String result;
    private String eyeType = "0";
    private short action = 1;
    private double lhd ;
    private double lnumBits ;
    private double rhd ;
    private double rnumBits ;
    private int statusVal ;
    private String statusStr = "";
    private String personNbr = "";

    
    private String cifNo, sexe, engName, arabName, irisNo, nationality, dob, activityFlag;
    private String idType, idNo, userId, addString1, addString2, dateCreated, dateModified, createdBy, modifiedBy;
    
    private CIF_IRISVO cifIrisVO = new CIF_IRISVO();
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String cifStatus;
    private Boolean accesByTeller = true;


    
    
    public List<CIFVO> getScannedCifs()
    {
	return scannedCifs;
    }

    public void setScannedCifs(List<CIFVO> scannedCifs)
    {
	this.scannedCifs = scannedCifs;
    }

    public BigDecimal getIrisId()
    {
	return irisId;
    }

    public void setIrisId(BigDecimal irisId)
    {
	this.irisId = irisId;
    }

    public String getResult()
    {
        return result;
    }

    public void setResult(String result)
    {
        this.result = result;
    }

    public String getEyeType()
    {
        return eyeType;
    }

    public void setEyeType(String eyeType)
    {
        this.eyeType = eyeType;
    }

    public short getAction()
    {
        return action;
    }

    public void setAction(short action)
    {
        this.action = action;
    }

    public double getLhd()
    {
        return lhd;
    }

    public void setLhd(double lhd)
    {
        this.lhd = lhd;
    }

    public double getLnumBits()
    {
        return lnumBits;
    }

    public void setLnumBits(double lnumBits)
    {
        this.lnumBits = lnumBits;
    }

    public double getRhd()
    {
        return rhd;
    }

    public void setRhd(double rhd)
    {
        this.rhd = rhd;
    }

    public double getRnumBits()
    {
        return rnumBits;
    }

    public void setRnumBits(double rnumBits)
    {
        this.rnumBits = rnumBits;
    }

    public int getStatusVal()
    {
        return statusVal;
    }

    public void setStatusVal(int statusVal)
    {
        this.statusVal = statusVal;
    }

    public String getStatusStr()
    {
        return statusStr;
    }

    public void setStatusStr(String statusStr)
    {
        this.statusStr = statusStr;
    }

    public String getPersonNbr()
    {
        return personNbr;
    }

    public void setPersonNbr(String personNbr)
    {
        this.personNbr = personNbr;
    }

    public String getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(String cifNo)
    {
        this.cifNo = cifNo;
    }

    public String getSexe()
    {
        return sexe;
    }

    public void setSexe(String sexe)
    {
        this.sexe = sexe;
    }

    public String getEngName()
    {
        return engName;
    }

    public void setEngName(String engName)
    {
        this.engName = engName;
    }

    public String getArabName()
    {
        return arabName;
    }

    public void setArabName(String arabName)
    {
        this.arabName = arabName;
    }

    public String getIrisNo()
    {
        return irisNo;
    }

    public void setIrisNo(String irisNo)
    {
        this.irisNo = irisNo;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getDob()
    {
        return dob;
    }

    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getActivityFlag()
    {
        return activityFlag;
    }

    public void setActivityFlag(String activityFlag)
    {
        this.activityFlag = activityFlag;
    }

    public String getIdType()
    {
        return idType;
    }

    public void setIdType(String idType)
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

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAddString1()
    {
        return addString1;
    }

    public void setAddString1(String addString1)
    {
        this.addString1 = addString1;
    }

    public String getAddString2()
    {
        return addString2;
    }

    public void setAddString2(String addString2)
    {
        this.addString2 = addString2;
    }

    public String getDateCreated()
    {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated)
    {
        this.dateCreated = dateCreated;
    }

    public String getDateModified()
    {
        return dateModified;
    }

    public void setDateModified(String dateModified)
    {
        this.dateModified = dateModified;
    }

    public String getCreatedBy()
    {
        return createdBy;
    }

    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    public String getModifiedBy()
    {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy)
    {
        this.modifiedBy = modifiedBy;
    }

    public CIF_IRISVO getCifIrisVO()
    {
	return cifIrisVO;
    }

    public void setCifIrisVO(CIF_IRISVO cifIrisVO)
    {
	this.cifIrisVO = cifIrisVO;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getCifStatus()
    {
	return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
	this.cifStatus = cifStatus;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }
}
