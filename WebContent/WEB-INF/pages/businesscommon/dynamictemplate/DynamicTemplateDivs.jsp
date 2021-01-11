<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>

<script type="text/javascript">

	$(document).ready(function() 
			{	$.struts2_jquery.require("DynamicTemplateMaint.js", null,jQuery.contextPath	+ "/businesscommon/js/dynamictemplate/");
				$.struts2_jquery.require("DynamicTemplateConventionMaint.js", null,jQuery.contextPath	+ "/businesscommon/js/dynamictemplate/");
				var jsonElement = ${jsonNodeList};
				var params = {};
				debugger;
				params["accBr"] = "${criteria.accBr}";
				params["accCy"] = "${criteria.accCy}";
				params["accGl"] = "${criteria.accGl}";
				params["accCif"] = "${criteria.accCif}";
				params["accSl"] = "${criteria.accSl}";
				params["cifNo"] = "${criteria.cifNo}";
				params["segmentNo"] = "${criteria.segmentNo}";
				params["entityType"] = "${criteria.entityType}";
				params["iv_crud"] = "${criteria.crudMode}"; 
				
				//console.log(JSON.stringify(jsonElement));
				//console.log(params);
				drawListElement(jsonElement,params);
			});
	
var processed_sucessfully_key = "<ps:text name='processed_sucessfully_key'/>";
var deleted = "<ps:text name='processed_sucessfully_key'/>";

</script>


<div id="templateDiv_id_${_pageRef}" style="width:100%;">
	<ps:form id="templateScreenForm_${_pageRef}" >
		<ps:hidden id="iv_crud_${_pageRef}"	 name="iv_crud"  />
		<ps:hidden id="productChargesToBeDeletedStr_${_pageRef}"	name="accountChargesCO.productChargesToBeDeletedStr"  />
		<ps:iterator value="NodesList" status="status" begin="0">
			<div id="appContainer_${status.index}${_pageRef}" class= "TreenodeClass${_pageRef}">
				<div id="baseContainer_${status.index}${_pageRef}" class= "TreenodeClass${_pageRef}"></div>
			</div>
		</ps:iterator>
		 <ptt:toolBar id="templateMaintToolBar_${_pageRef}" hideInAlert="true">	
			<psj:submit id="templateSave_${_pageRef}" button="true" onclick="templateChargesSave('saveCharges')" >
				<ps:if test='iv_crud == "R"'>
					<ps:text name="%{getText('save_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "P"'>
					<ps:text name="%{getText('approve_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "UP"'>
					<ps:text name="%{getText('update_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "S"'>
					<ps:text name="%{getText('suspend_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "RA"'>
					<ps:text name="%{getText('reactivate_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "TS"'>
					<ps:text name="%{getText('to_suspend_key')}"></ps:text>	
				</ps:if>
				<ps:if test='iv_crud == "TA"'>
					<ps:text name="%{getText('to_reactivate_key')}"></ps:text>	
				</ps:if>
			</psj:submit>
		</ptt:toolBar>	
	</ps:form>
</div>


