package com.path.actions.common.dynamictemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import org.apache.struts2.json.JSONUtil;

import com.path.bo.common.MessageCodes;
import com.path.bo.common.audit.AuditConstant;
import com.path.bo.common.dynamictemplate.DynamicTemplateBO;
import com.path.bo.common.dynamictemplate.DynamicTemplateConstant;
import com.path.lib.common.exception.BOException;
import com.path.lib.common.exception.BaseException;
import com.path.lib.common.util.NumberUtil;
import com.path.lib.common.util.StringUtil;
import com.path.struts2.json.PathJSONUtil;
import com.path.struts2.lib.common.base.TreeBaseAction;
import com.path.vo.common.SessionCO;
import com.path.vo.common.audit.AuditRefCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateCO;
import com.path.vo.common.dynamictemplate.DynamicTemplateSC;
import com.path.vo.common.select.SelectCO;
import com.path.vo.common.select.SelectSC;
import com.path.vo.common.tree.TreeNode;
import com.path.vo.common.tree.TreeNodeCO;

/**
 * 
 * Copyright 2013, Path Solutions Path Solutions retains all ownership rights to
 * this source code
 * 
 * DynamicTemplateMaintAction.java used to
 */
public class DynamicTemplateMaintAction extends TreeBaseAction
{
    private DynamicTemplateBO dynamicTemplateBO;
    private DynamicTemplateCO dynTemplateCO;
    List<TreeNode> NodesList;
    private String jsonNodeList;
    private DynamicTemplateSC criteria = new DynamicTemplateSC();
    private List<SelectCO> nodeTypelist;
    private BigDecimal dtId; 
    private String dynTempAppName;
    private String count = null;
    int i = 0;
    int k =0;
    int headerCount =0;
    Map<Integer, TreeNode> nodesMap = new HashMap<Integer, TreeNode>();
    
    public void setDynamicTemplateBO(DynamicTemplateBO dynamicTemplateBO)
    {
	this.dynamicTemplateBO = dynamicTemplateBO;
    }

    public DynamicTemplateCO getDynTemplateCO()
    {
        return dynTemplateCO;
    }

    public void setDynTemplateCO(DynamicTemplateCO dynTemplateCO)
    {
        this.dynTemplateCO = dynTemplateCO;
    }
    
    public Object getModel()
    {
	return criteria;
    }

    public DynamicTemplateSC getCriteria()
    {
	return criteria;
    }

    public void setCriteria(DynamicTemplateSC criteria)
    {
	this.criteria = criteria;
    }

    public List<SelectCO> getNodeTypelist()
    {
        return nodeTypelist;
    }

    public void setNodeTypelist(List<SelectCO> nodeTypelist)
    {
        this.nodeTypelist = nodeTypelist;
    }
    
    private void initList() throws BaseException
    {
	SelectSC selSC = new SelectSC(DynamicTemplateConstant.nodeTypelistDropDown);
	nodeTypelist = returnLOV(selSC);
    }
    
    public BigDecimal getDtId()
    {
        return dtId;
    }

    public void setDtId(BigDecimal dtId)
    {
        this.dtId = dtId;
    }
    
    public String getDynTempAppName()
    {
        return dynTempAppName;
    }

    public void setDynTempAppName(String dynTempAppName)
    {
        this.dynTempAppName = dynTempAppName;
    }
    
    public List<TreeNode> getNodesList()
    {
        return NodesList;
    }

    public void setNodesList(List<TreeNode> nodesList)
    {
        NodesList = nodesList;
    }
    
    public String loadDynamicTemplatePage()
    {
	try
	{
	    set_searchGridId("dynamicTemplateListGridTbl_Id");
	    set_showSmartInfoBtn("false");
	    initList();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "dynamicTemplateList";
    }

    public String loadTree()
    {
	SessionCO sessionCO = returnSessionObject();
	criteria.setCompCode(sessionCO.getCompanyCode());
	List<TreeNodeCO> treeNodes = new ArrayList<TreeNodeCO>();
	TreeNodeCO theNode = new TreeNodeCO();
	if(dtId == null || NumberUtil.isEmptyDecimal(dtId))
	{
	    theNode.setParentNodeCode("ROOT");
	    theNode.setNodeCode("1");
	    theNode.setTitle(dynTempAppName);
	    treeNodes.add(theNode);
	}
	else
	{
	    criteria.setDyntempId(dtId);
	    criteria.setCurrAppName(dynTempAppName);
	    try
	    {
		treeNodes = dynamicTemplateBO.returnTreeNodes(criteria);
		if(treeNodes.isEmpty())
		{
		    treeNodes = new ArrayList<TreeNodeCO>();
		    theNode = new TreeNodeCO();
		    theNode.setParentNodeCode("ROOT");
		    theNode.setNodeCode("1");
		    theNode.setTitle(dynTempAppName);
		    treeNodes.add(theNode);
		}
		else
		{
		    treeNodes.get(0).setParentNodeCode("ROOT");
		}
	    }
	    catch(Exception ex)
	    {
		handleException(ex, null, null);
	    }
	}
	setNodes(treeNodes);
	// Return the json type of the tree
	return JSON_TREE;
    }
    
    public String retrieveSelectNodesDesc()
    {
	try
	{
	    if(NumberUtil.isEmptyDecimal(dtId))
	    {
//		dynTemplateCO = new DynamicTemplateCO();
		setDtId(null);
	    }
	    else
	    {
		criteria.setCompCode(returnSessionObject().getCompanyCode());
		criteria.setDyntempId(dtId);
		criteria.setNodeId(dynTemplateCO.getDynTemplateNodesVO().getNODE_ID());
		criteria.setParentNodeId(dynTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID());
		dynTemplateCO = dynamicTemplateBO.retrieveSelectNodesDesc(criteria);
		if(dynTemplateCO == null)
		{
		    dynTemplateCO = dynamicTemplateBO.retrieveSelectNodesDescWithoutScreenId(criteria);
		}
		dynTemplateCO.getDynTemplateNodesVO().setNODE_ID(criteria.getNodeId());
		dynTemplateCO.getDynTemplateNodesVO().setPARENT_NODE_ID(criteria.getParentNodeId());
	    }
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return SUCCESS;
    }
    
    public String openNodeDetails()
    {
	try
	{
	    initList();
	}
	catch(Exception ex)
	{
	    handleException(ex, null, null);
	}
	return "dynTempDetailPopup";
    }
    
    public String retrieveSelectedDynTempId()
    {
	try
	{
	    if(!NumberUtil.isEmptyDecimal(dtId))
	    {
		initList();
		DynamicTemplateSC dynTemplateSC = new DynamicTemplateSC();
		SessionCO sessionCO = returnSessionObject();
		dynTemplateSC.setCompCode(sessionCO.getCompanyCode());
		dynTemplateSC.setBranchCode(sessionCO.getBranchCode());
		dynTemplateSC.setDyntempId(dtId);
		dynTemplateSC.setCrudMode(getIv_crud());
		dynTemplateSC.setCurrAppName(sessionCO.getCurrentAppName());
		dynTemplateSC.setPreferredLanguage(sessionCO.getLanguage());
		dynTemplateSC.setMenuRef(get_pageRef());
		dynTemplateCO = dynamicTemplateBO.retrieveSelectedDynTempId(dynTemplateSC);
		applyRetrieveAudit(AuditConstant.DYNAMIC_TEMPLATE_KEY_REF, dynTemplateCO.getDynTemplateVO(),
			dynTemplateCO);
	    }
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	    return ERROR;
	}
	return "dynamicTemplateMaint";
    }
    
    public String saveNew()
    {
	try
	{
	    // apply session value
	    fillSessionData();

	    // AuditRefCO refCO;
	    if(NumberUtil.isEmptyDecimal(dynTemplateCO.getDynTemplateVO().getDYN_TEMP_ID()))
	    {
		dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.CREATED));
	    }
	    else
	    {
		dynTemplateCO.setAuditRefCO(fillSessionVariables(AuditConstant.UPDATE));
		dynTemplateCO.setAuditObj(returnAuditObject(dynTemplateCO.getClass()));
	    }
	    // save
	    dynTemplateCO.getDynTemplateVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	    dynTemplateCO.getDynTemplateNodesVO().setCOMP_CODE(dynTemplateCO.getCompCode());
	    dynamicTemplateBO.save(dynTemplateCO);
	    dynTemplateCO.getDynTemplateVO().setDYN_TEMP_ID(dynamicTemplateBO.retSavedDynTempId(dynTemplateCO));
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String deleteNode()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();
	    dynTemplateCO.getDynTemplateNodesVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    dynamicTemplateBO.deleteNode(dynTemplateCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String deleteDynTempId()
    {
	try
	{
	    SessionCO sessionCO = returnSessionObject();

	    dynTemplateCO = new DynamicTemplateCO();
	    dynTemplateCO.getDynTemplateVO().setCOMP_CODE(sessionCO.getCompanyCode());
	    dynTemplateCO.getDynTemplateVO().setDYN_TEMP_ID(dtId);
	    dynTemplateCO.getDynTemplateVO().setAPP_NAME(dynTempAppName);
	    dynTemplateCO.getDynTemplateNodesVO().setDYN_TEMP_ID(dtId);
	    dynamicTemplateBO.deleteDynTempId(dynTemplateCO);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return SUCCESS;
    }
    
    public String clearStpForm()
    {
	{
	    try
	    {
		initList();
		dynTemplateCO = new DynamicTemplateCO();
		applyRetrieveAudit(AuditConstant.DYNAMIC_TEMPLATE_KEY_REF, dynTemplateCO.getDynTemplateVO(),
			dynTemplateCO);
	    }
	    catch(Exception e)
	    {
		log.error(e, "");
	    }
	    return "dynamicTemplateMaint";
	}
    }

    public String loadTemplatePage()
    {
	{
	    try
	    {	
		dynTemplateCO = new DynamicTemplateCO();
		fillSessionData();
		DynamicTemplateSC dynTempSc = new DynamicTemplateSC();
		dynTempSc.setCurrAppName(dynTempAppName);
		dynTempSc.setCompCode(dynTemplateCO.getCompCode());
		criteria.setCrudMode(getIv_crud());
		List<DynamicTemplateCO>  returnedNodesList = dynamicTemplateBO.retNodesList(dynTempSc);
		List<TreeNodeCO> treeNodeCOsList = new ArrayList<TreeNodeCO>();
		NodesList = new ArrayList();
		String newAppName = dynTempAppName;
		
		if(returnedNodesList != null && !returnedNodesList.isEmpty())
		{
		    int i = 1;
		    int j = 0;
		    for(DynamicTemplateCO dynamicTemplateCO : returnedNodesList)
		    {
			if(!StringUtil.nullToEmpty(newAppName).equals(StringUtil.nullToEmpty(dynTempAppName)))
			{
			    setNodes(treeNodeCOsList);
			    NodesList.add(j, getNodes().get(0));
			    treeNodeCOsList = new ArrayList<TreeNodeCO>();
			    newAppName = null;
			    dynTempAppName = null;
			    j++;
			}
			if(StringUtil.nullToEmpty(newAppName).equals(StringUtil.nullToEmpty(dynTempAppName))
				|| "DT00MT".equals(dynTemplateCO.getProgRef()))
			{
			    TreeNodeCO treeNode = new TreeNodeCO();
			    treeNode.setNodeCode(dynamicTemplateCO.getDynTemplateNodesVO().getNODE_ID());
			    treeNode.setParentNodeCode(dynamicTemplateCO.getDynTemplateNodesVO().getPARENT_NODE_ID());
			    treeNode.setNodeOrder(dynamicTemplateCO.getDynTemplateNodesVO().getNODE_ORDER());
			    treeNode.setTitle(dynamicTemplateCO.getDynTemplateNodesVO().getNODE_DESC());
			    treeNode.setChecked(dynamicTemplateCO.getSysParamChrgTempScreensVO().getSCREEN_URL());
			    treeNode.setChildrenDisabled(dynamicTemplateCO.getDynTemplateNodesVO().getNODE_TYPE());
			    treeNode.setIcon(dynamicTemplateCO.getDynTemplateVO().getAPP_NAME());
			    treeNodeCOsList.add(treeNode);
			}
			
			ListIterator<DynamicTemplateCO> lit = returnedNodesList.listIterator(i);
			if(lit.hasNext())
			{
			    newAppName = lit.next().getDynTemplateVO().getAPP_NAME();
			}
			else
			{
			    newAppName = null;
			    setNodes(treeNodeCOsList);
			    NodesList.add(j, getNodes().get(0));
			    treeNodeCOsList = new ArrayList<TreeNodeCO>();
			    newAppName = null;
			    dynTempAppName = null;
			    j++;
			}
			dynTempAppName = dynamicTemplateCO.getDynTemplateVO().getAPP_NAME();
			i++;
		    }
		}
		
		jsonNodeList = PathJSONUtil.strutsJsonSerialize(NodesList, null, null, false, true);
		
		
		//NodesList = resultNodeList; //reOrderNode(resultNodeList.get(0));
	    }
 	    catch(Exception e)
	    {
		log.error(e, "");
	    }
	    return "dynamicTemplateDivs";
	}
    }
    
    
    public void fillSessionData() throws BaseException
    {
	SessionCO sessionCO = returnSessionObject();
	dynTemplateCO.setCompCode(sessionCO.getCompanyCode());
	dynTemplateCO.setBranchCode(sessionCO.getBranchCode());
	dynTemplateCO.setAppName(sessionCO.getCurrentAppName());
	dynTemplateCO.setProgRef(get_pageRef());
	dynTemplateCO.setUserID(sessionCO.getUserName());
	dynTemplateCO.setRunningDate(returnCommonLibBO().addSystemTimeToDate(sessionCO.getRunningDateRET()));
	dynTemplateCO.setIvCrud(getIv_crud());
	dynTemplateCO.setLanguage(sessionCO.getLanguage());
	dynTemplateCO.setUserID(sessionCO.getUserName());
    }
    
    private AuditRefCO fillSessionVariables(String status)
    {

	AuditRefCO refCO = initAuditRefCO();
	try
	{
	    refCO.setOperationType(status);
	    refCO.setKeyRef(AuditConstant.DYNAMIC_TEMPLATE_KEY_REF);
	}
	catch(Exception e)
	{
	    handleException(e, null, null);
	}
	return refCO;
    }

    public String getJsonNodeList()
    {
        return jsonNodeList;
    }

    public void setJsonNodeList(String jsonNodeList)
    {
        this.jsonNodeList = jsonNodeList;
    }

}
