package com.path.vo.common.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.struts2.lib.common.GridParamsSC;

public class MosBlackListSC extends GridParamsSC
{
    private BigDecimal cifNO;
    private String qcBlkLastName;
    private String qcBlkThrdName;
    private String qcBlkSecName;
    private String qcBlkFName;
    private String qcBlkMLName;
    private String qcBlkMFName;
    private String qcBlkRegion;
    private String qcBlkCountry;
    private String qcBlkNation;
    private String qcBlkBPlace;
    private String qcBlkBdate;
    private String qcBlkRegNo;
    private String qcBlkIdNo;
    private String qcBlkLName;
    private String qcBlkBName;
    private String qcBlkLegal;
    
    private String qcBlkLastNameCond;
    private String qcBlkThrdNameCond;
    private String qcBlkSecNameCond;
    private String qcBlkFNameCond;
    private String qcBlkMLNameCond;
    private String qcBlkMFNameCond;
    private String qcBlkRegionCond;
    private String qcBlkCountryCond;
    private String qcBlkNationCond;
    private String qcBlkBPlaceCond;
    private String qcBlkBdateCond;
    private String qcBlkRegNoCond;
    private String qcBlkIdNoCond;
    private String qcBlkLNameCond;
    private String qcBlkBNameCond;
    private String qcBlkLegalCond;
    
    private String longNameEng;
    private String longNameArab;
    private String shortNameEng;
    private String shortNameArab;
    private String lastNameEng;
    private String firstNameEng;
    private String secNameEng;
    private String thirdNameEng;
    private String lastNameAr;
    private String firstNameAr;
    private String secNameAr;
    private String thirdNameAr;
    private String motherFirstName;
    private String motherLastName;
    private String placeOfBirth;
    private String idNo;
    private String bPlace;
    private String sColname;
    private String sType;
    private BigDecimal lCountry;
    private BigDecimal lRegion;
    private BigDecimal lNation;
    private BigDecimal lRegno;
    private BigDecimal lLegal;
    private Date ldtBDate;
    private BigDecimal lIdType;
    private BigDecimal bdMosBlkCode;
    private BigDecimal blackListed;
    private String andOR;
    
    private String cifAcc; //added by fady for suspicious screen. 4/4/2013
    private String soundex1;
    private String soundex2;
    private String soundex3;
    private String soundex4;
    private String soundexAr1;
    private String soundexAr2;
    private String soundexAr3;
    private String soundexAr4;
    private String count;
    private String countAr;
    private BigDecimal errorCode ;
    private String errorMessage;
    
    private Boolean cifSuspiciousFlag;
    private Boolean cifControlRecordFlag;
    private String blChecked;
    
    private String checkByDocumentId;
    private String documentIdType;
    private BigDecimal trsIdType;
    private String documentId;
    
    private String suspiciousGridListValue;
    
    private String status;

    private Integer countData;
    private BigDecimal trsNo;
    private List<MosBlackListCO> suspiciousRecordsList= new ArrayList<MosBlackListCO>() ;

    private String fromCountCall;
    
    public void setCifNO(BigDecimal cifNO)
    {
	this.cifNO = cifNO;
    }

    public BigDecimal getCifNO()
    {
	return cifNO;
    }

    public String getQcBlkLastName()
    {
        return qcBlkLastName;
    }

    public void setQcBlkLastName(String qcBlkLastName)
    {
        this.qcBlkLastName = qcBlkLastName;
    }

    public String getQcBlkThrdName()
    {
        return qcBlkThrdName;
    }

    public void setQcBlkThrdName(String qcBlkThrdName)
    {
        this.qcBlkThrdName = qcBlkThrdName;
    }

    public String getQcBlkSecName()
    {
        return qcBlkSecName;
    }

    public void setQcBlkSecName(String qcBlkSecName)
    {
        this.qcBlkSecName = qcBlkSecName;
    }

    public String getQcBlkFName()
    {
        return qcBlkFName;
    }

    public void setQcBlkFName(String qcBlkFName)
    {
        this.qcBlkFName = qcBlkFName;
    }

    public String getQcBlkMLName()
    {
        return qcBlkMLName;
    }

    public void setQcBlkMLName(String qcBlkMLName)
    {
        this.qcBlkMLName = qcBlkMLName;
    }

    public String getQcBlkMFName()
    {
        return qcBlkMFName;
    }

    public void setQcBlkMFName(String qcBlkMFName)
    {
        this.qcBlkMFName = qcBlkMFName;
    }

    public String getQcBlkRegion()
    {
        return qcBlkRegion;
    }

    public void setQcBlkRegion(String qcBlkRegion)
    {
        this.qcBlkRegion = qcBlkRegion;
    }

    public String getQcBlkCountry()
    {
        return qcBlkCountry;
    }

    public void setQcBlkCountry(String qcBlkCountry)
    {
        this.qcBlkCountry = qcBlkCountry;
    }

    public String getQcBlkNation()
    {
        return qcBlkNation;
    }

    public void setQcBlkNation(String qcBlkNation)
    {
        this.qcBlkNation = qcBlkNation;
    }

    public String getQcBlkBPlace()
    {
        return qcBlkBPlace;
    }

    public void setQcBlkBPlace(String qcBlkBPlace)
    {
        this.qcBlkBPlace = qcBlkBPlace;
    }

    public String getQcBlkBdate()
    {
        return qcBlkBdate;
    }

    public void setQcBlkBdate(String qcBlkBdate)
    {
        this.qcBlkBdate = qcBlkBdate;
    }

    public String getQcBlkRegNo()
    {
        return qcBlkRegNo;
    }

    public void setQcBlkRegNo(String qcBlkRegNo)
    {
        this.qcBlkRegNo = qcBlkRegNo;
    }

    public String getQcBlkIdNo()
    {
        return qcBlkIdNo;
    }

    public void setQcBlkIdNo(String qcBlkIdNo)
    {
        this.qcBlkIdNo = qcBlkIdNo;
    }

    public String getQcBlkLName()
    {
        return qcBlkLName;
    }

    public void setQcBlkLName(String qcBlkLName)
    {
        this.qcBlkLName = qcBlkLName;
    }

    public String getQcBlkBName()
    {
        return qcBlkBName;
    }

    public void setQcBlkBName(String qcBlkBName)
    {
        this.qcBlkBName = qcBlkBName;
    }

    public String getQcBlkLegal()
    {
        return qcBlkLegal;
    }

    public void setQcBlkLegal(String qcBlkLegal)
    {
        this.qcBlkLegal = qcBlkLegal;
    }

    public String getLongNameEng()
    {
        return longNameEng;
    }

    public void setLongNameEng(String longNameEng)
    {
        this.longNameEng = longNameEng;
    }

    public String getLongNameArab()
    {
        return longNameArab;
    }

    public void setLongNameArab(String longNameArab)
    {
        this.longNameArab = longNameArab;
    }

    public String getShortNameEng()
    {
        return shortNameEng;
    }

    public void setShortNameEng(String shortNameEng)
    {
        this.shortNameEng = shortNameEng;
    }

    public String getShortNameArab()
    {
        return shortNameArab;
    }

    public void setShortNameArab(String shortNameArab)
    {
        this.shortNameArab = shortNameArab;
    }

    public String getLastNameEng()
    {
        return lastNameEng;
    }

    public void setLastNameEng(String lastNameEng)
    {
        this.lastNameEng = lastNameEng;
    }

    public String getFirstNameEng()
    {
        return firstNameEng;
    }

    public void setFirstNameEng(String firstNameEng)
    {
        this.firstNameEng = firstNameEng;
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

    public String getLastNameAr()
    {
        return lastNameAr;
    }

    public void setLastNameAr(String lastNameAr)
    {
        this.lastNameAr = lastNameAr;
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

    public String getMotherFirstName()
    {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName)
    {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherLastName()
    {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName)
    {
        this.motherLastName = motherLastName;
    }

    public String getPlaceOfBirth()
    {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth)
    {
        this.placeOfBirth = placeOfBirth;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public String getbPlace()
    {
        return bPlace;
    }

    public void setbPlace(String bPlace)
    {
        this.bPlace = bPlace;
    }

    public BigDecimal getlCountry()
    {
        return lCountry;
    }

    public void setlCountry(BigDecimal lCountry)
    {
        this.lCountry = lCountry;
    }

    public BigDecimal getlRegion()
    {
        return lRegion;
    }

    public void setlRegion(BigDecimal lRegion)
    {
        this.lRegion = lRegion;
    }

    public BigDecimal getlNation()
    {
        return lNation;
    }

    public void setlNation(BigDecimal lNation)
    {
        this.lNation = lNation;
    }

    public BigDecimal getlRegno()
    {
        return lRegno;
    }

    public void setlRegno(BigDecimal lRegno)
    {
        this.lRegno = lRegno;
    }

    public BigDecimal getlLegal()
    {
        return lLegal;
    }

    public void setlLegal(BigDecimal lLegal)
    {
        this.lLegal = lLegal;
    }

    public Date getLdtBDate()
    {
        return ldtBDate;
    }

    public void setLdtBDate(Date ldtBDate)
    {
        this.ldtBDate = ldtBDate;
    }

    public BigDecimal getlIdType()
    {
        return lIdType;
    }

    public void setlIdType(BigDecimal lIdType)
    {
        this.lIdType = lIdType;
    }

    public void setAndOR(String andOR)
    {
	this.andOR = andOR;
    }

    public String getAndOR()
    {
	return andOR;
    }

    public String getQcBlkLastNameCond()
    {
        return qcBlkLastNameCond;
    }

    public void setQcBlkLastNameCond(String qcBlkLastNameCond)
    {
        this.qcBlkLastNameCond = qcBlkLastNameCond;
    }

    public String getQcBlkThrdNameCond()
    {
        return qcBlkThrdNameCond;
    }

    public void setQcBlkThrdNameCond(String qcBlkThrdNameCond)
    {
        this.qcBlkThrdNameCond = qcBlkThrdNameCond;
    }

    public String getQcBlkSecNameCond()
    {
        return qcBlkSecNameCond;
    }

    public void setQcBlkSecNameCond(String qcBlkSecNameCond)
    {
        this.qcBlkSecNameCond = qcBlkSecNameCond;
    }

    public String getQcBlkFNameCond()
    {
        return qcBlkFNameCond;
    }

    public void setQcBlkFNameCond(String qcBlkFNameCond)
    {
        this.qcBlkFNameCond = qcBlkFNameCond;
    }

    public String getQcBlkMLNameCond()
    {
        return qcBlkMLNameCond;
    }

    public void setQcBlkMLNameCond(String qcBlkMLNameCond)
    {
        this.qcBlkMLNameCond = qcBlkMLNameCond;
    }

    public String getQcBlkMFNameCond()
    {
        return qcBlkMFNameCond;
    }

    public void setQcBlkMFNameCond(String qcBlkMFNameCond)
    {
        this.qcBlkMFNameCond = qcBlkMFNameCond;
    }

    public String getQcBlkRegionCond()
    {
        return qcBlkRegionCond;
    }

    public void setQcBlkRegionCond(String qcBlkRegionCond)
    {
        this.qcBlkRegionCond = qcBlkRegionCond;
    }

    public String getQcBlkCountryCond()
    {
        return qcBlkCountryCond;
    }

    public void setQcBlkCountryCond(String qcBlkCountryCond)
    {
        this.qcBlkCountryCond = qcBlkCountryCond;
    }

    public String getQcBlkNationCond()
    {
        return qcBlkNationCond;
    }

    public void setQcBlkNationCond(String qcBlkNationCond)
    {
        this.qcBlkNationCond = qcBlkNationCond;
    }

    public String getQcBlkBPlaceCond()
    {
        return qcBlkBPlaceCond;
    }

    public void setQcBlkBPlaceCond(String qcBlkBPlaceCond)
    {
        this.qcBlkBPlaceCond = qcBlkBPlaceCond;
    }

    public String getQcBlkBdateCond()
    {
        return qcBlkBdateCond;
    }

    public void setQcBlkBdateCond(String qcBlkBdateCond)
    {
        this.qcBlkBdateCond = qcBlkBdateCond;
    }

    public String getQcBlkRegNoCond()
    {
        return qcBlkRegNoCond;
    }

    public void setQcBlkRegNoCond(String qcBlkRegNoCond)
    {
        this.qcBlkRegNoCond = qcBlkRegNoCond;
    }

    public String getQcBlkIdNoCond()
    {
        return qcBlkIdNoCond;
    }

    public void setQcBlkIdNoCond(String qcBlkIdNoCond)
    {
        this.qcBlkIdNoCond = qcBlkIdNoCond;
    }

    public String getQcBlkLNameCond()
    {
        return qcBlkLNameCond;
    }

    public void setQcBlkLNameCond(String qcBlkLNameCond)
    {
        this.qcBlkLNameCond = qcBlkLNameCond;
    }

    public String getQcBlkBNameCond()
    {
        return qcBlkBNameCond;
    }

    public void setQcBlkBNameCond(String qcBlkBNameCond)
    {
        this.qcBlkBNameCond = qcBlkBNameCond;
    }

    public String getQcBlkLegalCond()
    {
        return qcBlkLegalCond;
    }

    public void setQcBlkLegalCond(String qcBlkLegalCond)
    {
        this.qcBlkLegalCond = qcBlkLegalCond;
    }

    public void setsColname(String sColname)
    {
	this.sColname = sColname;
    }

    public String getsColname()
    {
	return sColname;
    }

    public void setsType(String sType)
    {
	this.sType = sType;
    }

    public String getsType()
    {
	return sType;
    }

    public void setBdMosBlkCode(BigDecimal bdMosBlkCode)
    {
	this.bdMosBlkCode = bdMosBlkCode;
    }

    public BigDecimal getBdMosBlkCode()
    {
	return bdMosBlkCode;
    }

    public void setCifSuspiciousFlag(Boolean cifSuspiciousFlag)
    {
	this.cifSuspiciousFlag = cifSuspiciousFlag;
    }

    public Boolean getCifSuspiciousFlag()
    {
	return cifSuspiciousFlag;
    }

    public void setCifControlRecordFlag(Boolean cifControlRecordFlag)
    {
	this.cifControlRecordFlag = cifControlRecordFlag;
    }

    public Boolean getCifControlRecordFlag()
    {
	return cifControlRecordFlag;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getBlackListed()
    {
        return blackListed;
    }

    public void setBlackListed(BigDecimal blackListed)
    {
        this.blackListed = blackListed;
    }

    public String getCifAcc()
    {
        return cifAcc;
    }

    public void setCifAcc(String cifAcc)
    {
        this.cifAcc = cifAcc;
    }

    public String getSoundex1()
    {
        return soundex1;
    }

    public void setSoundex1(String soundex1)
    {
        this.soundex1 = soundex1;
    }

    public String getSoundex2()
    {
        return soundex2;
    }

    public void setSoundex2(String soundex2)
    {
        this.soundex2 = soundex2;
    }

    public String getSoundex3()
    {
        return soundex3;
    }

    public void setSoundex3(String soundex3)
    {
        this.soundex3 = soundex3;
    }

    public String getSoundex4()
    {
        return soundex4;
    }

    public void setSoundex4(String soundex4)
    {
        this.soundex4 = soundex4;
    }

    public String getSoundexAr1()
    {
        return soundexAr1;
    }

    public void setSoundexAr1(String soundexAr1)
    {
        this.soundexAr1 = soundexAr1;
    }

    public String getSoundexAr2()
    {
        return soundexAr2;
    }

    public void setSoundexAr2(String soundexAr2)
    {
        this.soundexAr2 = soundexAr2;
    }

    public String getSoundexAr3()
    {
        return soundexAr3;
    }

    public void setSoundexAr3(String soundexAr3)
    {
        this.soundexAr3 = soundexAr3;
    }

    public String getSoundexAr4()
    {
        return soundexAr4;
    }

    public void setSoundexAr4(String soundexAr4)
    {
        this.soundexAr4 = soundexAr4;
    }

    public String getCount()
    {
        return count;
    }

    public void setCount(String count)
    {
        this.count = count;
    }

    public String getCountAr()
    {
        return countAr;
    }

    public void setCountAr(String countAr)
    {
        this.countAr = countAr;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public BigDecimal getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(BigDecimal errorCode)
    {
        this.errorCode = errorCode;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }

    public Integer getCountData()
    {
        return countData;
    }

    public void setCountData(Integer countData)
    {
        this.countData = countData;
    }

    public String getBlChecked()
    {
        return blChecked;
    }

    public void setBlChecked(String blChecked)
    {
        this.blChecked = blChecked;
    }

    public BigDecimal getTrsNo()
    {
        return trsNo;
    }

    public void setTrsNo(BigDecimal trsNo)
    {
        this.trsNo = trsNo;
    }

    public String getCheckByDocumentId()
    {
        return checkByDocumentId;
    }

    public void setCheckByDocumentId(String checkByDocumentId)
    {
        this.checkByDocumentId = checkByDocumentId;
    }

    public String getDocumentIdType()
    {
        return documentIdType;
    }

    public void setDocumentIdType(String documentIdType)
    {
        this.documentIdType = documentIdType;
    }

    public String getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(String documentId)
    {
        this.documentId = documentId;
    }

    public BigDecimal getTrsIdType()
    {
        return trsIdType;
    }

    public void setTrsIdType(BigDecimal trsIdType)
    {
        this.trsIdType = trsIdType;
    }

    public String getSuspiciousGridListValue()
    {
        return suspiciousGridListValue;
    }

    public void setSuspiciousGridListValue(String suspiciousGridListValue)
    {
        this.suspiciousGridListValue = suspiciousGridListValue;
    }

    public List<MosBlackListCO> getSuspiciousRecordsList()
    {
        return suspiciousRecordsList;
    }

    public void setSuspiciousRecordsList(List<MosBlackListCO> suspiciousRecordsList)
    {
        this.suspiciousRecordsList = suspiciousRecordsList;
    }

    public String getFromCountCall()
    {
        return fromCountCall;
    }

    public void setFromCountCall(String fromCountCall)
    {
        this.fromCountCall = fromCountCall;
    }
}
