<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<ps:form useHiddenProps="true"
	id="dynamicTemplateMaintFormId_${_pageRef}"
	namespace="/path/dynamicTemplate">
	<ps:hidden id="dynTempId_${_pageRef}"
		name="dynTemplateCO.dynTemplateVO.DYN_TEMP_ID" />
	<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
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
			<td class="fldLabelView" colspan="1"><ps:label
					key="application_key" id="trns_newLblApplication_lbl"
					for="lookuptxt_newLblApp_Labeling" /></td>
			<td><psj:livesearch id="newLblApp_Labeling"
					relatedDescElt="newLblApp_appDesc" size="8" required="true"
					name="dynTemplateCO.dynTemplateVO.APP_NAME"
					actionName="${pageContext.request.contextPath}/pathdesktop/ApplicationsLookup_constructLookup"
					paramList="webAppsOnly:webAppsOnly_${_pageRef},screenSrc:'DYN'"
					resultList="APP_NAME:newLblApp_Labeling" searchElement="APP_NAME"
					autoSearch="false" maxlength="4"
					dependencySrc="${pageContext.request.contextPath}/path/dynamicTemplate/DynamicTemplateAppDepAction_applicationDepend"
					parameter="appVO.APP_NAME:lookuptxt_newLblApp_Labeling"
					dependency="lookuptxt_newLblApp_Labeling:appVO.APP_NAME,newLblApp_appDesc:appVO.APP_DESC,lookuptxt_PageRef_Lkp:optVO.PROG_REF,PROG_DESC:optVO.PROG_DESC" 
					afterDepEvent="reloadDynamicTemplateTree()"
					/>
			</td>
			<td colspan="4"><ps:textfield id="newLblApp_appDesc" size="35"
					name="dynTemplateCO.APP_DESC" readonly="true" /></td>
		</tr>
	</table>
	<div id="dynTempNodeTreeMaintDiv_id_${_pageRef}" style="width: 100%;">
		<%@include file="DynamicTemplateNodeTree.jsp"%>
	</div>
	<psj:submit id="dynTempPreview_${_pageRef}" button="true"
		freezeOnSubmit="true" onclick="dynTempMaint_Preview()">
		<ps:label key="prv_sel_rep_key" for="dynTempPreview_${_pageRef}" />
	</psj:submit>
	<div class="clearfix">
		<psj:dialog id="openNodeDetailsPopup_${_pageRef}" 
					href=""
					autoOpen="false" 
					dataType="html" 
					modal="true"
					title="%{getText('Details_key')}" 
					width="850" 
					height="150"/>
	</div>
	<div class="clearfix">
		<psj:dialog id="openPreviewPopup_${_pageRef}" 
					href=""
					autoOpen="false" 
					dataType="html" 
					modal="true"
					title="%{getText('prv_sel_rep_key')}" 
					width="850" 
					height="850"
					/>
	</div>
	<ps:hidden id="webAppsOnly_${_pageRef}" name="webAppsOnlyRep" value="1"></ps:hidden>
</ps:form>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.struts2_jquery
						.require("DynamicTemplateMaint.js", null,
								jQuery.contextPath
										+ "/businesscommon/js/dynamictemplate/");
			});
</script>