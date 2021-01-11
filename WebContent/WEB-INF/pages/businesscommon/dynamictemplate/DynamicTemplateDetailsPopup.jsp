<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:hidden id="parentNodeId_${_pageRef}" name="dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID" />
				
<table width="100%" cellpadding="0" cellspacing="0"
	class="headerPortionContent ui-widget-content" border="0">
	<tr>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
		<td width="10%"></td>
	</tr>
	<tr>
		<td colspan="1"><ps:label id="parentNodeId_${_pageRef}"
				name="dynTemplateCO.dynTemplateNodesVO.PARENT_NODE_ID" />
		</td>
	</tr>
	<tr>
		<td colspan="1"><ps:label key="Code_key" id="code_${_pageRef}"
				for="codeDesc_${_pageRef}" /></td>
		<td colspan="3"><ps:textfield id="codeDesc_${_pageRef}"
				maxlength="4" name="dynTemplateCO.dynTemplateNodesVO.NODE_ID"
				readonly="false" /></td>
	</tr>
	<tr>
		<td colspan="1"><ps:label key="Description_key"
				id="descId_${_pageRef}" for="desc_${_pageRef}" /></td>
		<td colspan="5"><ps:textfield id="desc_${_pageRef}"
				maxlength="20" name="dynTemplateCO.dynTemplateNodesVO.NODE_DESC"
				readonly="false" /></td>
	</tr>
	<tr>
		<td colspan="1"><ps:label key="type_key"
				for="node_type_${_pageRef}" /></td>
		<td class="fldDataEdit center" colspan="1"><ps:select
				id="node_type_${_pageRef}"
				name="dynTemplateCO.dynTemplateNodesVO.NODE_TYPE"
				list="nodeTypelist" listValue="descValue" listKey="code"
				emptyOption="false" dependencySrc="" parameter="" dependency=""
				onchange="">
			</ps:select></td>
		<td class="fldLabelView" colspan="1"><ps:label
				key="screenName_key" id="screenName_lbl_${_pageRef}"
				for="lookuptxt_screenId_${_pageRef}" /></td>
		<td colspan="1"><psj:livesearch id="screenId_${_pageRef}"
				relatedDescElt="screenId"
				maxlength="4"
				name="dynTemplateCO.dynTemplateNodesVO.SCREEN_ID"
				paramList="criteria.currAppName:lookuptxt_newLblApp_Labeling"
				actionName="${pageContext.request.contextPath}/path/dynamicTemplate/DynamicTemplateLookupAction_constructLookup"
				resultList="sysParamChrgTempScreensVO.SCREEN_ID:lookuptxt_screenId_${_pageRef},sysParamChrgTempScreensVO.SCREEN_DESC:screenDesc_${_pageRef}" 
				searchElement="sysParamChrgTempScreensVO.SCREEN_ID,sysParamChrgTempScreensVO.SCREEN_DESC"
				autoSearch="false"
				dependencySrc="${pageContext.request.contextPath}/path/dynamicTemplate/DynamicTemplateDepAction_dependencyScreenById"
				parameter="screenId:lookuptxt_screenId_${_pageRef},criteria.currAppName:lookuptxt_newLblApp_Labeling"
				dependency="lookuptxt_screenId_${_pageRef}:dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_ID,screenDesc_${_pageRef}:dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC" />
		</td>
		<td colspan="6"><ps:textfield id="screenDesc_${_pageRef}" 
				name="dynTemplateCO.sysParamChrgTempScreensVO.SCREEN_DESC" readonly="true" /></td>
	</tr>
</table>
	
<psj:submit id="dynTempPopup_ok_${_pageRef}" button="true"
	freezeOnSubmit="true" onclick="dynTempPopup_okProcess()">
	<ps:label key="ok_key" for="dynTempPopup_ok_${_pageRef}" />
</psj:submit>
