package com.path.vo.common.fom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIF_JOINT_DETVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.lib.vo.BaseVO;
import com.path.vo.common.select.SelectCO;
import com.path.vo.core.common.RetailBaseVO;

public class FomCifJointAccCO extends RetailBaseVO
{
    private CIF_JOINT_DETVO cifJointAccVO = new CIF_JOINT_DETVO();
    CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    private String nationDesc;
    private String idTypeDesc;
    private String idType2Desc;
    private String relationCodeDesc;
    private String jointCifDesc;
    private String jointTypeDesc;
    private String saveType;
    // added by jihad
    private String jointAccounts;
    private String language;
    private String cifStatus;
    private BigDecimal cifType;
    private BigDecimal jointCifBranch;
    private String iv_crud;
    private Date cif_UpdateDate;
    private Boolean accesByTeller = true;
    private String protectJoinInfo;
    private String defaultInfoFromJoinCIF;
    private Date runningDate;
    HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private String callingMode;// to specify on ehci mode we are sending the
			       // sc:update,load,oncahnge..
    private List<SelectCO> jointAccMaritalStatusDropDown = new ArrayList<SelectCO>();
    private List<SelectCO> jointAccGenderDropDown = new ArrayList<SelectCO>();
    private List<SelectCO> jointAccJoinTypeDropDown = new ArrayList<SelectCO>();

    //TP 262352 Hala Al Sheikh Enhance the checking on the US Passport
    private String jointAccCountryOfIssDesc;
    private String jointAccCountryOfIss1Desc;
    private String jointAccCountryOfIss2Desc;
    private String jointAccCountryOfIss3Desc;
    //End Hala
    
    //Hala Al Sheikh - BIPL180103
    private String blkListWarnMessage;
    
    private String allowCifCreationMaskYN;

    public String getCallingMode()
    {
	return callingMode;
    }

    public void setCallingMode(String callingMode)
    {
	this.callingMode = callingMode;
    }

    public BigDecimal getCifType()
    {
	return cifType;
    }

    public void setCifType(BigDecimal cifType)
    {
	this.cifType = cifType;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getBuisnessElement()
    {
	return buisnessElement;
    }

    public void setBuisnessElement(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> buisnessElement)
    {
	this.buisnessElement = buisnessElement;
    }

    public Date getRunningDate()
    {
	return runningDate;
    }

    public void setRunningDate(Date runningDate)
    {
	this.runningDate = runningDate;
    }

    public String getProtectJoinInfo()
    {
	return protectJoinInfo;
    }

    public void setProtectJoinInfo(String protectJoinInfo)
    {
	this.protectJoinInfo = protectJoinInfo;
    }

    public CIF_JOINT_DETVO getCifJointAccVO()
    {
	return cifJointAccVO;
    }

    public void setCifJointAccVO(CIF_JOINT_DETVO cifJointAccVO)
    {
	this.cifJointAccVO = cifJointAccVO;
    }

    public String getNationDesc()
    {
	return nationDesc;
    }

    public void setNationDesc(String nationDesc)
    {
	this.nationDesc = nationDesc;
    }

    public String getIdTypeDesc()
    {
	return idTypeDesc;
    }

    public void setIdTypeDesc(String idTypeDesc)
    {
	this.idTypeDesc = idTypeDesc;
    }

    public String getIdType2Desc()
    {
	return idType2Desc;
    }

    public void setIdType2Desc(String idType2Desc)
    {
	this.idType2Desc = idType2Desc;
    }

    public String getRelationCodeDesc()
    {
	return relationCodeDesc;
    }

    public void setRelationCodeDesc(String relationCodeDesc)
    {
	this.relationCodeDesc = relationCodeDesc;
    }

    public String getSaveType()
    {
	return saveType;
    }

    public void setSaveType(String saveType)
    {
	this.saveType = saveType;
    }

    public String getJointAccounts()
    {
	return jointAccounts;
    }

    public void setJointAccounts(String jointAccounts)
    {
	this.jointAccounts = jointAccounts;
    }

    public String getLanguage()
    {
	return language;
    }

    public void setLanguage(String language)
    {
	this.language = language;
    }

    public String getJointCifDesc()
    {
	return jointCifDesc;
    }

    public void setJointCifDesc(String jointCifDesc)
    {
	this.jointCifDesc = jointCifDesc;
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

    public String getIv_crud()
    {
	return iv_crud;
    }

    public void setIv_crud(String ivCrud)
    {
	iv_crud = ivCrud;
    }

    public Date getCif_UpdateDate()
    {
	return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
	cif_UpdateDate = cifUpdateDate;
    }

    public String getJointTypeDesc()
    {
	return jointTypeDesc;
    }

    public void setJointTypeDesc(String jointTypeDesc)
    {
	this.jointTypeDesc = jointTypeDesc;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public String getDefaultInfoFromJoinCIF()
    {
	return defaultInfoFromJoinCIF;
    }

    public void setDefaultInfoFromJoinCIF(String defaultInfoFromJoinCIF)
    {
	this.defaultInfoFromJoinCIF = defaultInfoFromJoinCIF;
    }

    public List<SelectCO> getJointAccMaritalStatusDropDown()
    {
	return jointAccMaritalStatusDropDown;
    }

    public void setJointAccMaritalStatusDropDown(List<SelectCO> jointAccMaritalStatusDropDown)
    {
	this.jointAccMaritalStatusDropDown = jointAccMaritalStatusDropDown;
    }

    public List<SelectCO> getJointAccGenderDropDown()
    {
	return jointAccGenderDropDown;
    }

    public void setJointAccGenderDropDown(List<SelectCO> jointAccGenderDropDown)
    {
	this.jointAccGenderDropDown = jointAccGenderDropDown;
    }

    public List<SelectCO> getJointAccJoinTypeDropDown()
    {
	return jointAccJoinTypeDropDown;
    }

    public void setJointAccJoinTypeDropDown(List<SelectCO> jointAccJoinTypeDropDown)
    {
	this.jointAccJoinTypeDropDown = jointAccJoinTypeDropDown;
    }

    public BigDecimal getJointCifBranch()
    {
        return jointCifBranch;
    }

    public void setJointCifBranch(BigDecimal jointCifBranch)
    {
        this.jointCifBranch = jointCifBranch;
    }
    public String getJointAccCountryOfIssDesc()
    {
        return jointAccCountryOfIssDesc;
    }

    public void setJointAccCountryOfIssDesc(String jointAccCountryOfIssDesc)
    {
        this.jointAccCountryOfIssDesc = jointAccCountryOfIssDesc;
    }

    public String getJointAccCountryOfIss1Desc()
    {
        return jointAccCountryOfIss1Desc;
    }

    public void setJointAccCountryOfIss1Desc(String jointAccCountryOfIss1Desc)
    {
        this.jointAccCountryOfIss1Desc = jointAccCountryOfIss1Desc;
    }

    public String getJointAccCountryOfIss2Desc()
    {
        return jointAccCountryOfIss2Desc;
    }

    public void setJointAccCountryOfIss2Desc(String jointAccCountryOfIss2Desc)
    {
        this.jointAccCountryOfIss2Desc = jointAccCountryOfIss2Desc;
    }

    public String getJointAccCountryOfIss3Desc()
    {
        return jointAccCountryOfIss3Desc;
    }

    public void setJointAccCountryOfIss3Desc(String jointAccCountryOfIss3Desc)
    {
        this.jointAccCountryOfIss3Desc = jointAccCountryOfIss3Desc;
    }

    public String getAllowCifCreationMaskYN()
    {
        return allowCifCreationMaskYN;
    }

    public void setAllowCifCreationMaskYN(String allowCifCreationMaskYN)
    {
        this.allowCifCreationMaskYN = allowCifCreationMaskYN;
    }

    public String getBlkListWarnMessage()
    {
        return blkListWarnMessage;
    }

    public void setBlkListWarnMessage(String blkListWarnMessage)
    {
        this.blkListWarnMessage = blkListWarnMessage;
    }

}