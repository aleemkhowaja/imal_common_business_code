<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@ taglib prefix="ptt"  uri="/path-toolbar-tags" %>

<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

<ps:form useHiddenProps="true" id="custSegmentProcessMaintFormId_${_pageRef}"  namespace="/path/segmentation">
	
	<div id="processFilterDiv_${_pageRef}"></div>
	
	<br />
	
	<table width="70%" cellpadding="0" cellspacing="3" >
		<tr>
			<td class="fldLabelView">
				<ps:label key="Date_key" id="lbl_processDate_${_pageRef}" for="processDate_${_pageRef}"/>
			</td>
			<td class="fldLabelView">
				<psj:datepicker id="processDate_${_pageRef}" name="custSegmentationSC.processDate" timepicker="false"
						buttonImageOnly="true" size="10" readonly="true"></psj:datepicker>
			</td>
		</tr>
	
		<tr>
			<td class="fldLabelView">
				<ps:label key="From_Branch_key" id="lbl_from_branch_${_pageRef}" for="lookuptxt_from_branch_${_pageRef}"/>
			</td>
			<td >
				<psj:livesearch
					actionName="${pageContext.request.contextPath}/pathdesktop/BranchesByUsrLookup_constructLookupByCompCode"
					id="from_branch_${_pageRef}" 
					name="custSegmentationSC.fromBranch"
					mode="number" 
					autoSearch="true"
					maxlength="4"
					leadZeros="4"
					relatedDescElt=""
					parameter="custSegmentationSC.branchCode:lookuptxt_from_branch_${_pageRef},custSegmentationSC.toBranch:lookuptxt_to_branch_${_pageRef}"
					dependency="lookuptxt_from_branch_${_pageRef}:custSegmentationSC.branchCode"
					dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyProcessBranch"
					searchElement="BRANCH_CODE">
				</psj:livesearch>
			</td>
		
			<td class="fldLabelView">
				<ps:label key="To_Branch_key" id="lbl_to_branch_${_pageRef}" for="lookuptxt_to_branch_${_pageRef}"/>
			</td>
			<td>
				<psj:livesearch
					actionName="${pageContext.request.contextPath}/pathdesktop/BranchesByUsrLookup_constructLookupByCompCode"
					id="to_branch_${_pageRef}" 
					name="custSegmentationSC.toBranch"
					mode="number" 
					autoSearch="true"
					maxlength="4"
					leadZeros="4"
					relatedDescElt=""
					parameter="custSegmentationSC.branchCode:lookuptxt_to_branch_${_pageRef},custSegmentationSC.fromBranch:lookuptxt_from_branch_${_pageRef}"
					dependency="lookuptxt_to_branch_${_pageRef}:custSegmentationSC.branchCode"
					dependencySrc="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyProcessBranch"
					searchElement="BRANCH_CODE">
				</psj:livesearch>
			</td>
		</tr>
	
		<tr>
			<td class="fldLabelView">
				<ps:label key="from_cif_key"
				              id ="lbl_from_cif_${_pageRef}"
				            for="lookuptxt_from_cif_${_pageRef}"></ps:label>
			</td>
			<td>	
			   <psj:livesearch id            ="from_cif_${_pageRef}"
			                  name          ="custSegmentationSC.fromCif" 
			                  mode          ="number"
			                  readOnlyMode  ="${_recReadOnly}"
			                  actionName    ="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
			                  searchElement =""
			                  resultList    ="CIF_NO:lookuptxt_from_cif_${_pageRef}"
			                  parameter     ="custSegmentationSC.cifNo:lookuptxt_from_cif_${_pageRef},custSegmentationSC.toCif:lookuptxt_to_cif_${_pageRef}"
			                  dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByCif"
			                  dependency    ="lookuptxt_from_cif_${_pageRef}:custSegmentationSC.cifNo" 
			  ></psj:livesearch>
			</td>
		
			<td class="fldLabelView">
				<ps:label key="to_cif_key"
				              id ="lbl_to_cif_${_pageRef}"
				            for="lookuptxt_to_cif_${_pageRef}"></ps:label>
			</td>
			<td>	
			   <psj:livesearch id            ="to_cif_${_pageRef}"
			                  name          ="custSegmentationSC.toCif" 
			                  mode          ="number"
			                  readOnlyMode  ="${_recReadOnly}"
			                  actionName    ="${pageContext.request.contextPath}/pathdesktop/CifLookup_constructLookup" 
			                  searchElement =""
			                  resultList    ="CIF_NO:lookuptxt_to_cif_${_pageRef}"
			                  parameter     ="custSegmentationSC.cifNo:lookuptxt_to_cif_${_pageRef},custSegmentationSC.fromCif:lookuptxt_from_cif_${_pageRef}"
			                  dependencySrc ="${pageContext.request.contextPath}/path/segmentation/CustSegmentationDependencyAction_dependencyByCif"
			                  dependency    ="lookuptxt_to_cif_${_pageRef}:custSegmentationSC.cifNo" 
			   ></psj:livesearch>
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td colspan="3" align="middle">
				<ps:radio theme="simple" id="processType_${_pageRef}" name="custSegmentationSC.processType"
							list="typeRadioMap" value="typeRadioMapDefaultValue"/>
			</td>
			<td width='5%'></td>
			<td>
				<psj:submit  id="process_${_pageRef}"  button="true" type="button" style="width:100px; height:30px"
								onclick="custSegmentationProcess_process()" freezeOnSubmit="true">
			    	<ps:label key="Process_key"/>
			   	</psj:submit>
			</td>
		</tr>
		
	</table>
	
	<br />

	<div id="custSegProcessGridDiv_${_pageRef}" hidden="true">
		<ps:if test='%{iv_crud.equals("P")}'>
			<%@include file="CustomerSegmentationProcessGrid.jsp"%>
		</ps:if>
	</div>
	
</ps:form>

<script type="text/javascript">
$(document).ready(function() {					
							$.struts2_jquery.require("CustSegmentationMaint.js" ,null,jQuery.contextPath+"/businesscommon/js/core/segmentation/");
						});
</script>