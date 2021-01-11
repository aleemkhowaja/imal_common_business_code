package com.path.vo.core.criteria;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.path.dbmaps.vo.CIFCONTROL_DEFINE_SCORE_RANGEVO;
import com.path.dbmaps.vo.CTS_CRITERIAVO;
import com.path.dbmaps.vo.CTS_CRITERIA_PARAMVO;
import com.path.dbmaps.vo.SYS_PARAM_SCREEN_DISPLAYVO;
import com.path.vo.core.common.RetailBaseVO;
import com.path.vo.core.procedureid.ProcedureIdCO;
import com.path.vo.core.queryid.QueryIdCO;

/**
 * 
 * Copyright 2017, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * @author: tonyelkhoury
 * 
 * 
 */

public class CriteriaCO extends RetailBaseVO
{

    private CTS_CRITERIAVO ctsCriteriaVO = new CTS_CRITERIAVO();
    private CTS_CRITERIA_PARAMVO ctsCriteriaParamVO = new CTS_CRITERIA_PARAMVO();
    private CTS_CRITERIAVO oldCtsCriteriaVO = new CTS_CRITERIAVO();// added by nour for 864398
    private String proceduresIdCOsStr;
    private String proceduresParamCOsStr;
    private String queriesParamCOsStr;
    private String PROC_NAME;
    private String statusDesc;
    private ProcedureIdCO procedureIdCO = new ProcedureIdCO();
    private QueryIdCO queryIdCO = new QueryIdCO();
    private List<CriteriaParamCO> criteriaProcParamCOLst = new ArrayList<CriteriaParamCO>();
    private List<CriteriaParamCO> criteriaQueryParamCOLst = new ArrayList<CriteriaParamCO>();
    private List<CriteriaParamCO> gridDeleteList = new ArrayList<CriteriaParamCO>();
    private BigDecimal BRANCH_CODE;
    private BigDecimal CRITERIA_CODE;
    private String ENTITY_TYPE;
    private BigDecimal ENTITY_ID;
    private BigDecimal PARAM_ORDER;
    private HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO > hm = new HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO>();
    private byte[] QUERY_OBJECT;
    private String QUERY_DESC;
    private String QuerySyntax;
    private String editMode = "false";
    private String entityName;

    private CIFCONTROL_DEFINE_SCORE_RANGEVO cifcontrolDefineScoreRangeVO = new CIFCONTROL_DEFINE_SCORE_RANGEVO(); //Rania - ABSAI180073 - FICA Risk Matrix calculation
    
    //By Bilal For TP#750884
    private String querySelectParamGridStr; 
    private List<CriteriaParamCO> criteriaQuerySelectParamCOLst = new ArrayList<CriteriaParamCO>(); 
    private BigDecimal queryParamId; 
    private String criteriaReference;
    
    public CTS_CRITERIAVO getCtsCriteriaVO()
    {
	return ctsCriteriaVO;
    }

    public void setCtsCriteriaVO(CTS_CRITERIAVO ctsCriteriaVO)
    {
	this.ctsCriteriaVO = ctsCriteriaVO;
    }

    public String getProceduresIdCOsStr()
    {
	return proceduresIdCOsStr;
    }

    public void setProceduresIdCOsStr(String proceduresIdCOsStr)
    {
	this.proceduresIdCOsStr = proceduresIdCOsStr;
    }

    public String getPROC_NAME()
    {
	return PROC_NAME;
    }

    public void setPROC_NAME(String pROCNAME)
    {
	PROC_NAME = pROCNAME;
    }

    public String getStatusDesc()
    {
	return statusDesc;
    }

    public void setStatusDesc(String statusDesc)
    {
	this.statusDesc = statusDesc;
    }

    public ProcedureIdCO getProcedureIdCO()
    {
	return procedureIdCO;
    }

    public void setProcedureIdCO(ProcedureIdCO procedureIdCO)
    {
	this.procedureIdCO = procedureIdCO;
    }

    public String getEditMode()
    {
	return editMode;
    }

    public void setEditMode(String editMode)
    {
	this.editMode = editMode;
    }

    public String getEntityName()
    {
	return entityName;
    }

    public void setEntityName(String entityName)
    {
	this.entityName = entityName;
    }

    public String getProceduresParamCOsStr()
    {
	return proceduresParamCOsStr;
    }

    public void setProceduresParamCOsStr(String proceduresParamCOsStr)
    {
	this.proceduresParamCOsStr = proceduresParamCOsStr;
    }

    public String getQueriesParamCOsStr()
    {
	return queriesParamCOsStr;
    }

    public void setQueriesParamCOsStr(String queriesParamCOsStr)
    {
	this.queriesParamCOsStr = queriesParamCOsStr;
    }

    public List<CriteriaParamCO> getCriteriaProcParamCOLst()
    {
	return criteriaProcParamCOLst;
    }

    public void setCriteriaProcParamCOLst(List<CriteriaParamCO> criteriaProcParamCOLst)
    {
	this.criteriaProcParamCOLst = criteriaProcParamCOLst;
    }

    public List<CriteriaParamCO> getCriteriaQueryParamCOLst()
    {
	return criteriaQueryParamCOLst;
    }

    public void setCriteriaQueryParamCOLst(List<CriteriaParamCO> criteriaQueryParamCOLst)
    {
	this.criteriaQueryParamCOLst = criteriaQueryParamCOLst;
    }

    public String getQUERY_DESC()
    {
	return QUERY_DESC;
    }

    public void setQUERY_DESC(String qUERYDESC)
    {
	QUERY_DESC = qUERYDESC;
    }

    public QueryIdCO getQueryIdCO()
    {
	return queryIdCO;
    }

    public void setQueryIdCO(QueryIdCO queryIdCO)
    {
	this.queryIdCO = queryIdCO;
    }

    public BigDecimal getBRANCH_CODE()
    {
	return BRANCH_CODE;
    }

    public void setBRANCH_CODE(BigDecimal bRANCHCODE)
    {
	BRANCH_CODE = bRANCHCODE;
    }

    public BigDecimal getCRITERIA_CODE()
    {
	return CRITERIA_CODE;
    }

    public void setCRITERIA_CODE(BigDecimal cRITERIACODE)
    {
	CRITERIA_CODE = cRITERIACODE;
    }

    public String getENTITY_TYPE()
    {
	return ENTITY_TYPE;
    }

    public void setENTITY_TYPE(String eNTITYTYPE)
    {
	ENTITY_TYPE = eNTITYTYPE;
    }

    public BigDecimal getENTITY_ID()
    {
	return ENTITY_ID;
    }

    public void setENTITY_ID(BigDecimal eNTITYID)
    {
	ENTITY_ID = eNTITYID;
    }

    public BigDecimal getPARAM_ORDER()
    {
	return PARAM_ORDER;
    }

    public void setPARAM_ORDER(BigDecimal pARAMORDER)
    {
	PARAM_ORDER = pARAMORDER;
    }

    public CTS_CRITERIA_PARAMVO getCtsCriteriaParamVO()
    {
	return ctsCriteriaParamVO;
    }

    public void setCtsCriteriaParamVO(CTS_CRITERIA_PARAMVO ctsCriteriaParamVO)
    {
	this.ctsCriteriaParamVO = ctsCriteriaParamVO;
    }

    public String getQuerySyntax()
    {
	return QuerySyntax;
    }

    public void setQuerySyntax(String querySyntax)
    {
	QuerySyntax = querySyntax;
    }

    public byte[] getQUERY_OBJECT()
    {
	return QUERY_OBJECT;
    }

    public void setQUERY_OBJECT(byte[] qUERYOBJECT)
    {
	QUERY_OBJECT = qUERYOBJECT;
    }

    public List<CriteriaParamCO> getGridDeleteList()
    {
	return gridDeleteList;
    }

    public void setGridDeleteList(List<CriteriaParamCO> gridDeleteList)
    {
	this.gridDeleteList = gridDeleteList;
    }

    public HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> getHm()
    {
        return hm;
    }

    public void setHm(HashMap<String, SYS_PARAM_SCREEN_DISPLAYVO> hm)
    {
        this.hm = hm;
    }

    public CIFCONTROL_DEFINE_SCORE_RANGEVO getCifcontrolDefineScoreRangeVO()
    {
        return cifcontrolDefineScoreRangeVO;
    }

    public void setCifcontrolDefineScoreRangeVO(CIFCONTROL_DEFINE_SCORE_RANGEVO cifcontrolDefineScoreRangeVO)
    {
        this.cifcontrolDefineScoreRangeVO = cifcontrolDefineScoreRangeVO;
    }
    
    public BigDecimal getQueryParamId() {
		return queryParamId;
	}

	public void setQueryParamId(BigDecimal queryParamId) {
		this.queryParamId = queryParamId;
	}


	public String getQuerySelectParamGridStr() {
		return querySelectParamGridStr;
	}

	public void setQuerySelectParamGridStr(String querySelectParamGridStr) {
		this.querySelectParamGridStr = querySelectParamGridStr;
	}

	public List<CriteriaParamCO> getCriteriaQuerySelectParamCOLst() {
		return criteriaQuerySelectParamCOLst;
	}

	public void setCriteriaQuerySelectParamCOLst(List<CriteriaParamCO> criteriaQuerySelectParamCOLst) {
		this.criteriaQuerySelectParamCOLst = criteriaQuerySelectParamCOLst;
	}

	
	public CTS_CRITERIAVO getOldCtsCriteriaVO()
	{
		return oldCtsCriteriaVO;
	}

	
	public void setOldCtsCriteriaVO(CTS_CRITERIAVO oldCtsCriteriaVO)
	{
		this.oldCtsCriteriaVO = oldCtsCriteriaVO;
	}

	
	public String getCriteriaReference()
	{
		return criteriaReference;
	}

	
	public void setCriteriaReference(String criteriaReference)
	{
		this.criteriaReference = criteriaReference;
	}
	
	
}
