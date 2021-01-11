<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt" uri="/path-toolbar-tags"%>



<script type="text/javascript">

function customerScoringProcess()
{
	_showProgressBar(true);

	var actionPath = jQuery.contextPath + "/path/segmentation/CustSegmentationMaintAction_custScoreProcess";
	var cifNo = $("#lookuptxt_cif_" + _pageRef).val();
	var segmentCode = $("#lookuptxt_score_" + _pageRef).val();

	var paramObj = {
			"custSegmentationSC.cifNo" : cifNo,
			"custSegmentationSC.segmentCode" : segmentCode,
			"_pageRef" : _pageRef
	};

	$.ajax({
			url : actionPath,
			type : "post",
			dataType : "json",
			data : paramObj,
			success : function(data)
			{
				if (typeof data["_error"] == "undefined" || data["_error"] == null)
				{
					$("#scoreValue_" + _pageRef).val(data.custSegmentationCO.score);
				}

				_showProgressBar(false);
			}
	});
}

	
</script>

<ps:form useHiddenProps="true" id="custScoringProcessFormId_${_pageRef}"  namespace="/path/segmentation">
<table width="30%" cellpadding="0" cellspacing="3">
	<tr>
		<td width="25%">
			<ps:label key="cif_key" id ="lbl_cif_${_pageRef}" for="lookuptxt_cif_${_pageRef}"></ps:label>
		</td>
		<%/* 
		<ps:if
				test='session.sesVO.currentAppName != "AML"'> 
				 */%>		
			
		<td width="20%">
			<psj:livesearch id            ="cif_${_pageRef}"
			               name          ="cif" 
			               mode          ="number"
			               readOnlyMode  ="${_recReadOnly}"
			               actionName    ="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
			               searchElement =""
			               resultList    ="CIF_NO:lookuptxt_cif_${_pageRef}"
			               parameter     ="custSegmentationSC.cifNo:lookuptxt_cif_${_pageRef}"
			               dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByMainCif"
			               dependency    ="lookuptxt_cif_${_pageRef}:custSegmentationSC.cifNo,cifDesc_${_pageRef}:custSegmentationSC.cifDesc,scoreValue_${_pageRef}:custSegmentationSC.score"></psj:livesearch>
		</td>
		<td>
			<ps:textfield id="cifDesc_${_pageRef}" name="custSegmentationSC.cifDesc" readonly="true"></ps:textfield>
		</td>
		<%/* </ps:if>
		
		
		<ps:if
				test='session.sesVO.currentAppName == "AML"'> <!-- added by nour for 777000 -->
			
		<td width="20%">
			<psj:livesearch id            ="cif_${_pageRef}"
			               name          ="cif" 
			               mode          ="number"
			               readOnlyMode  ="${_recReadOnly}"
			               actionName    ="${pageContext.request.contextPath}/pathdesktop/AmlCifLookup_constructLookup"
			               searchElement =""
			               resultList    ="CIF_NO:lookuptxt_cif_${_pageRef}"
			              parameter     ="custSegmentationSC.cifNo:lookuptxt_cif_${_pageRef}"
			               dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByMainCif"
			               dependency    ="lookuptxt_cif_${_pageRef}:custSegmentationSC.cifNo,cifDesc_${_pageRef}:custSegmentationSC.cifDesc,scoreValue_${_pageRef}:custSegmentationSC.score">
			               </psj:livesearch>
	
		</td>
		<td>
			<ps:textfield id="cifDesc_${_pageRef}" name="custSegmentationSC.cifDesc" readonly="true"></ps:textfield>
		</td>
		</ps:if>
		*/%>
	</tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
	<tr>
		<td width="25%">
			<ps:label key="Score" id ="lbl_score_${_pageRef}" for="lookuptxt_score_${_pageRef}"></ps:label>
		</td>
		<td width="20%">
			<psj:livesearch id            ="score_${_pageRef}"
			               name          ="score" 
			               mode          ="number"
			               readOnlyMode  ="${_recReadOnly}"
			               actionName    ="${pageContext.request.contextPath}/pathdesktop/SegmentationCodeLookupAction_constructSegmentationCodeLookup" 
			               searchElement =""
			               resultList    ="SEGMENT_CODE:lookuptxt_score_${_pageRef}"
			               parameter     ="custSegmentationSC.segmentCode:lookuptxt_score_${_pageRef}"
			               dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByMainSegmentCode"
			               dependency    ="lookuptxt_score_${_pageRef}:custSegmentationSC.segmentCode,segmentDesc_${_pageRef}:custSegmentationSC.segmentDesc,scoreValue_${_pageRef}:custSegmentationSC.score"></psj:livesearch>
		</td>
		<td>
			<ps:textfield id="segmentDesc_${_pageRef}" name="custSegmentationSC.segmentDesc" readonly="true"></ps:textfield>
		</td>
	</tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
	<tr>
		<td><ps:label key="score_value_key" id ="lbl_score_value_${_pageRef}" for="scoreValue_${_pageRef}"></ps:label></td>
		<td colspan="2"> 
			<ps:textfield id="scoreValue_${_pageRef}" name="custSegmentationSC.score" readonly="true"></ps:textfield>
		</td>
	</tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
	<tr></tr>	
	<tr></tr>
</table>

<ptt:toolBar id="custScore_process_toolbar_${_pageRef}" hideInAlert="false">
	<psj:submit id="custScore_process_${_pageRef}" button="true" freezeOnSubmit="true" onclick="customerScoringProcess()">
					<ps:label key="Process_key" for="custScore_process_${_pageRef}" />
	</psj:submit>
</ptt:toolBar>							
</ps:form>


