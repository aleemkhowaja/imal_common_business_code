package com.path.vo.core.csmfom;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.path.dbmaps.vo.CIFVO;
import com.path.dbmaps.vo.CIF_MEMBERSVO;
import com.path.dbmaps.vo.CTSTELLERVO;
import com.path.dbmaps.vo.CTS_CIF_MEMBERS_DETVO;
import com.path.dbmaps.vo.CTS_CIF_MEMBERS_IDVO;
import com.path.dbmaps.vo.RIFCTTVO;
import com.path.vo.core.common.RetailBaseVO;

public class CifMembersCO extends RetailBaseVO
{

    private CIF_MEMBERSVO cifMembersVO = new CIF_MEMBERSVO();
    private RIFCTTVO rifcttVO = new RIFCTTVO();
    private CTS_CIF_MEMBERS_DETVO ctsCifMembersDetVO = new CTS_CIF_MEMBERS_DETVO();
    private CTS_CIF_MEMBERS_IDVO ctsCifMembersIDVO= new CTS_CIF_MEMBERS_IDVO();
    private List<CifMembersCO> gridUpdateList = new ArrayList<CifMembersCO>();
    private List<CTSCifMembersDetCO> gridMoreDetailsUpdateList = new ArrayList<CTSCifMembersDetCO>();
    private List<CTSCifMembersIdCO> gridMemberIDsUpdateList = new ArrayList<CTSCifMembersIdCO>();
    private String nationalityDesc;
    private String salutationDesc;
    private String relationCodeDesc;
    private String positionDesc;

    private CIFVO cifVo = new CIFVO();
    private String cifStatus;
    private Date cif_UpdateDate;
    private String LatestDateUpdated;
    private String memberMoreDetailsListStr;
    private String memberIDsListStr;
    private String memberMoreDetailsOpened;
    private String memberIDsOpened;
    
    private BigDecimal compCodeCif;//Hasan EWBI160091 06/06/2016
    private String PRIMARY_ID_TYPE_DESC;
    private Boolean accesByTeller=true;
    private CTSTELLERVO ctsTellerVO = new CTSTELLERVO();
    
    private String residenceDescription; //Hala Al Sheikh - SBI200125
    
    public CIF_MEMBERSVO getCifMembersVO()
    {
	return cifMembersVO;
    }

    public void setCifMembersVO(CIF_MEMBERSVO cifMembersVO)
    {
	this.cifMembersVO = cifMembersVO;
    }

    public List<CifMembersCO> getGridUpdateList()
    {
	return gridUpdateList;
    }

    public void setGridUpdateList(List<CifMembersCO> gridUpdateList)
    {
	this.gridUpdateList = gridUpdateList;
    }

    public String getNationalityDesc()
    {
	return nationalityDesc;
    }

    public void setNationalityDesc(String nationalityDesc)
    {
	this.nationalityDesc = nationalityDesc;
    }

    public String getCifStatus()
    {
        return cifStatus;
    }

    public void setCifStatus(String cifStatus)
    {
        this.cifStatus = cifStatus;
    }

    public Date getCif_UpdateDate()
    {
        return cif_UpdateDate;
    }

    public void setCif_UpdateDate(Date cifUpdateDate)
    {
        cif_UpdateDate = cifUpdateDate;
    }

    public CIFVO getCifVo()
    {
        return cifVo;
    }

    public void setCifVo(CIFVO cifVo)
    {
        this.cifVo = cifVo;
    }

    public String getLatestDateUpdated()
    {
        return LatestDateUpdated;
    }

    public void setLatestDateUpdated(String latestDateUpdated)
    {
        LatestDateUpdated = latestDateUpdated;
    }

    public CTS_CIF_MEMBERS_DETVO getCtsCifMembersDetVO()
    {
        return ctsCifMembersDetVO;
    }

    public void setCtsCifMembersDetVO(CTS_CIF_MEMBERS_DETVO ctsCifMembersDetVO)
    {
        this.ctsCifMembersDetVO = ctsCifMembersDetVO;
    }
    public String getMemberMoreDetailsListStr()
    {
        return memberMoreDetailsListStr;
    }

    public void setMemberMoreDetailsListStr(String memberMoreDetailsListStr)
    {
        this.memberMoreDetailsListStr = memberMoreDetailsListStr;
    }

    public List<CTSCifMembersDetCO> getGridMoreDetailsUpdateList()
    {
        return gridMoreDetailsUpdateList;
    }

    public void setGridMoreDetailsUpdateList(List<CTSCifMembersDetCO> gridMoreDetailsUpdateList)
    {
        this.gridMoreDetailsUpdateList = gridMoreDetailsUpdateList;
    }

    public String getMemberMoreDetailsOpened()
    {
        return memberMoreDetailsOpened;
    }

    public void setMemberMoreDetailsOpened(String memberMoreDetailsOpened)
    {
        this.memberMoreDetailsOpened = memberMoreDetailsOpened;
    }

    public String getMemberIDsListStr()
    {
        return memberIDsListStr;
    }

    public void setMemberIDsListStr(String memberIDsListStr)
    {
        this.memberIDsListStr = memberIDsListStr;
    }

    public List<CTSCifMembersIdCO> getGridMemberIDsUpdateList()
    {
        return gridMemberIDsUpdateList;
    }

    public void setGridMemberIDsUpdateList(List<CTSCifMembersIdCO> gridMemberIDsUpdateList)
    {
        this.gridMemberIDsUpdateList = gridMemberIDsUpdateList;
    }

    public String getMemberIDsOpened()
    {
        return memberIDsOpened;
    }

    public void setMemberIDsOpened(String memberIDsOpened)
    {
        this.memberIDsOpened = memberIDsOpened;
    }

    public CTS_CIF_MEMBERS_IDVO getCtsCifMembersIDVO()
    {
        return ctsCifMembersIDVO;
    }

    public void setCtsCifMembersIDVO(CTS_CIF_MEMBERS_IDVO ctsCifMembersIDVO)
    {
        this.ctsCifMembersIDVO = ctsCifMembersIDVO;
    }

    public RIFCTTVO getRifcttVO()
    {
        return rifcttVO;
    }

    public void setRifcttVO(RIFCTTVO rifcttVO)
    {
        this.rifcttVO = rifcttVO;
    }

    public String getSalutationDesc()
    {
        return salutationDesc;
    }

    public void setSalutationDesc(String salutationDesc)
    {
        this.salutationDesc = salutationDesc;
    }

    public String getRelationCodeDesc()
    {
        return relationCodeDesc;
    }

    public void setRelationCodeDesc(String relationCodeDesc)
    {
        this.relationCodeDesc = relationCodeDesc;
    }

    public String getPositionDesc()
    {
        return positionDesc;
    }

    public void setPositionDesc(String positionDesc)
    {
        this.positionDesc = positionDesc;
    }
    
    public String getPRIMARY_ID_TYPE_DESC()
    {
        return PRIMARY_ID_TYPE_DESC;
    }

    public void setPRIMARY_ID_TYPE_DESC(String pRIMARY_ID_TYPE_DESC)
    {
        PRIMARY_ID_TYPE_DESC = pRIMARY_ID_TYPE_DESC;
    }
    
    public void setCompCodeCif(BigDecimal compCodeCif)
    {
	this.compCodeCif = compCodeCif;
    }

    public BigDecimal getCompCodeCif()
    {
	return compCodeCif;
    }

    public Boolean getAccesByTeller()
    {
	return accesByTeller;
    }

    public void setAccesByTeller(Boolean accesByTeller)
    {
	this.accesByTeller = accesByTeller;
    }

    public CTSTELLERVO getCtsTellerVO()
    {
	return ctsTellerVO;
    }

    public void setCtsTellerVO(CTSTELLERVO ctsTellerVO)
    {
	this.ctsTellerVO = ctsTellerVO;
    }

    public String getResidenceDescription()
    {
        return residenceDescription;
    }

    public void setResidenceDescription(String residenceDescription)
    {
        this.residenceDescription = residenceDescription;
    }
}
