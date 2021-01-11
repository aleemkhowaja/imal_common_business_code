package com.path.vo.common.blacklistmanagement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.path.dbmaps.vo.CIFCONTROLVO;
import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_BLACKLISTVO;
import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.dbmaps.vo.MOSBLACKLISTVO;
import com.path.dbmaps.vo.UN_MAINVO;
import com.path.vo.common.fom.FomCifJointAccCO;
import com.path.vo.core.common.RetailBaseVO;


//previously (PB) str_return
public class MosBlackListCO extends RetailBaseVO
{
    private BigDecimal compCode;
    private BigDecimal branchCode;
    private String stringReturn;
   
    private BigDecimal min;
    private String status;
    private String stringReturnA;
    private BigDecimal idType;
    private String tel;
    private String idNo;
    private BigDecimal from; 
    private String briefName;
    private String briefNameArab; 
    private BigDecimal cifType;
    private BigDecimal country;
    private BigDecimal regionCode;
   
    private CIFVO cifVO = new CIFVO();// dw_data
    private List<FomCifJointAccCO> jointAccList = new ArrayList<FomCifJointAccCO>();// dw_data_joint
    private List<CIF_JOINT_DETVO> jointAccountVO= new  ArrayList<CIF_JOINT_DETVO>();
    private BigDecimal codeType;
    private BigDecimal codeSource;
    private String blacklistType;
    private String blacklistSource;
    private String longNameBlacklistType;
    private String longDescBlacklistSource;
    private BigDecimal codeCif;
    private String applyRounding;
    private ArrayList<CifBlckLstVO> cifBlckLstVO = new ArrayList<CifBlckLstVO>();
    private String longName;
    private String longNameAr;
    private List<MosBlackListCO> suspiciousGridList= new ArrayList<MosBlackListCO>() ;
    private BigDecimal cifNo;
    private String blType;
    private String blChecked;
    private BigDecimal trsNo;
    
    private String soundex1;
    private String soundex2;
    private String soundex3;
    private String soundex4;
    private String soundexAr1;
    private String soundexAr2;
    private String soundexAr3;
    private String soundexAr4;
    
    private String checkByDocumentId;
    private String documentIdType;
    private BigDecimal trsIdType;
    private String documentId;
    private BigDecimal criteriaCount;
    private String criteriaName;
    private BigDecimal criteriaPerc;
    private ArrayList<String> criteriaMatchList = new ArrayList<String>();


    public void setCriteriaName(String criteriaName)
    {
        this.criteriaName = criteriaName;
    }

    private  CIF_BLACKLISTVO  cifBlackListVO = new  CIF_BLACKLISTVO();
    
    private MOSBLACKLISTVO mosBlackListVO = new MOSBLACKLISTVO();
    
    private UN_MAINVO unMainVO = new UN_MAINVO();

    private CIFCONTROLVO cifControl = new CIFCONTROLVO();
    
    private String appName;
    
    private BigDecimal blackListed;
    
    private BigDecimal proceedBlackListed;
    private BigDecimal code;

    
    public MOSBLACKLISTVO getMosBlackListVO()
    {
	return mosBlackListVO;
    }
    
    public String getStringReturnA()
    {
        return stringReturnA;
    }

    public void setStringReturnA(String stringReturnA)
    {
        this.stringReturnA = stringReturnA;
    }

    public BigDecimal getCompCode() {
	return compCode;
    }

    public void setCompCode(BigDecimal compCode) {
	this.compCode = compCode;
    }

    public void setMosBlackListVO(MOSBLACKLISTVO mosBlackListVO)
    {
	this.mosBlackListVO = mosBlackListVO;
    }

    public CIFCONTROLVO getCifControl()
    {
	return cifControl;
    }

    public void setCifControl(CIFCONTROLVO cifControl)
    {
	this.cifControl = cifControl;
    }

    public CIFVO getCifVO()
    {
	return cifVO;
    }

    public void setCifVO(CIFVO cifVO)
    {
	this.cifVO = cifVO;
    }

    public BigDecimal getMin()
    {
	return min;
    }

    public void setMin(BigDecimal min)
    {
	this.min = min;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public BigDecimal getIdType()
    {
	return idType;
    }

    public void setIdType(BigDecimal idType)
    {
	this.idType = idType;
    }

    public String getTel()
    {
	return tel;
    }

    public void setTel(String tel)
    {
	this.tel = tel;
    }

    public String getIdNo()
    {
	return idNo;
    }

    public void setIdNo(String idNo)
    {
	this.idNo = idNo;
    }

    public BigDecimal getFrom()
    {
        return from;
    }

    public void setFrom(BigDecimal from)
    {
        this.from = from;
    }

    
    public String getBriefName()
    {
        return briefName;
    }

    public void setBriefName(String briefName)
    {
        this.briefName = briefName;
    }

    public String getBriefNameArab()
    {
        return briefNameArab;
    }

    public void setBriefNameArab(String briefNameArab)
    {
        this.briefNameArab = briefNameArab;
    }

    public BigDecimal getCountry()
    {
        return country;
    }

    public void setCountry(BigDecimal country)
    {
        this.country = country;
    }
    
    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public List<FomCifJointAccCO> getJointAccList()
    {
	return jointAccList;
    }

    public void setJointAccList(List<FomCifJointAccCO> jointAccList)
    {
	this.jointAccList = jointAccList;
    }

    public BigDecimal getCodeType()
    {
	return codeType;
    }

    public void setCodeType(BigDecimal codeType)
    {
	this.codeType = codeType;
    }

    public BigDecimal getCodeSource()
    {
	return codeSource;
    }

    public void setCodeSource(BigDecimal codeSource)
    {
	this.codeSource = codeSource;
    }

    public String getBlacklistType()
    {
	return blacklistType;
    }

    public void setBlacklistType(String blacklistType)
    {
	this.blacklistType = blacklistType;
    }

    public String getBlacklistSource()
    {
	return blacklistSource;
    }

    public void setBlacklistSource(String blacklistSource)
    {
	this.blacklistSource = blacklistSource;
    }

    public BigDecimal getCodeCif()
    {
	return codeCif;
    }

    public void setCodeCif(BigDecimal codeCif)
    {
	this.codeCif = codeCif;
    }

    public String getApplyRounding()
    {
	return applyRounding;
    }

    public void setApplyRounding(String applyRounding)
    {
	this.applyRounding = applyRounding;
    }

   
    public void setAppName(String appName)
    {
	this.appName = appName;
    }

    public String getAppName()
    {
	return appName;
    }

    public void setCifBlckLstVO(ArrayList<CifBlckLstVO> cifBlckLstVO)
    {
	this.cifBlckLstVO = cifBlckLstVO;
    }

    public ArrayList<CifBlckLstVO> getCifBlckLstVO()
    {
	return cifBlckLstVO;
    }

    public void setBlackListed(BigDecimal blackListed)
    {
	this.blackListed = blackListed;
    }

    public BigDecimal getBlackListed()
    {
	return blackListed;
    }

    public void setProceedBlackListed(BigDecimal proceedBlackListed)
    {
	this.proceedBlackListed = proceedBlackListed;
    }

    public BigDecimal getProceedBlackListed()
    {
	return proceedBlackListed;
    }

    public UN_MAINVO getUnMainVO()
    {
        return unMainVO;
    }

    public void setUnMainVO(UN_MAINVO unMainVO)
    {
        this.unMainVO = unMainVO;
    }
    public CIF_BLACKLISTVO getCifBlackListVO()
    {
        return cifBlackListVO;
    }

    public void setCifBlackListVO(CIF_BLACKLISTVO cifBlackListVO)
    {
        this.cifBlackListVO = cifBlackListVO;
    }

    public String getLongName()
    {
        return longName;
    }

    public void setLongName(String longName)
    {
        this.longName = longName;
    }

    public String getLongNameAr()
    {
        return longNameAr;
    }

    public void setLongNameAr(String longNameAr)
    {
        this.longNameAr = longNameAr;
    }
    
    public List<MosBlackListCO> getSuspiciousGridList()
    {
        return suspiciousGridList;
    }

    public void setSuspiciousGridList(List<MosBlackListCO> suspiciousGridList)
    {
        this.suspiciousGridList = suspiciousGridList;
    }

    public BigDecimal getCifNo()
    {
        return cifNo;
    }

    public void setCifNo(BigDecimal cifNo)
    {
        this.cifNo = cifNo;
    }
    
    public String getBlType()
    {
        return blType;
    }

    public void setBlType(String blType)
    {
        this.blType = blType;
    }
    
    public String getStringReturn()
    {
        return stringReturn;
    }

    public void setStringReturn(String stringReturn)
    {
        this.stringReturn = stringReturn;
    }

    public List<CIF_JOINT_DETVO> getJointAccountVO()
    {
        return jointAccountVO;
    }

    public void setJointAccountVO(List<CIF_JOINT_DETVO> jointAccountVO)
    {
        this.jointAccountVO = jointAccountVO;
    }

    public BigDecimal getBranchCode()
    {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode)
    {
        this.branchCode = branchCode;
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

    public BigDecimal getRegionCode()
    {
        return regionCode;
    }

    public void setRegionCode(BigDecimal regionCode)
    {
        this.regionCode = regionCode;
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

    public BigDecimal getTrsIdType()
    {
        return trsIdType;
    }

    public void setTrsIdType(BigDecimal trsIdType)
    {
        this.trsIdType = trsIdType;
    }

    public String getDocumentId()
    {
        return documentId;
    }

    public void setDocumentId(String documentId)
    {
        this.documentId = documentId;
    }

    public BigDecimal getCode()
    {
        return code;
    }

    public void setCode(BigDecimal code)
    {
        this.code = code;
    }
    
    public String getLongNameBlacklistType()
    {
        return longNameBlacklistType;
    }

    public void setLongNameBlacklistType(String longNameBlacklistType)
    {
        this.longNameBlacklistType = longNameBlacklistType;
    }

    public String getLongDescBlacklistSource()
    {
        return longDescBlacklistSource;
    }

    public void setLongDescBlacklistSource(String longDescBlacklistSource)
    {
        this.longDescBlacklistSource = longDescBlacklistSource;
    }
    
    public BigDecimal getCriteriaCount()
    {
        return criteriaCount;
    }

    public void setCriteriaCount(BigDecimal criteriaCount)
    {
        this.criteriaCount = criteriaCount;
    }

    public String getCriteriaName()
    {
        return criteriaName;
    }

    public BigDecimal getCriteriaPerc()
    {
        return criteriaPerc;
    }

    public void setCriteriaPerc(BigDecimal criteriaPerc)
    {
        this.criteriaPerc = criteriaPerc;
    }

    public ArrayList<String> getCriteriaMatchList()
    {
        return criteriaMatchList;
    }

    public void setCriteriaMatchList(ArrayList<String> criteriaMatchList)
    {
        this.criteriaMatchList = criteriaMatchList;
    }
    

    
}
