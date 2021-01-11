<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<html>
	<head>
   		<title> <ps:text name="" /> </title>   		
 
	</head>

	<body> 
	
		<div class="signatureListDiv"> 	
			
			<ps:hidden id = "hdDetails_${_pageRef}" 	 	name = "signatureSC.details"></ps:hidden>
			<ps:hidden id = "hdEdit_${_pageRef}" 		 name = "signatureSC.edit"></ps:hidden>
			<ps:hidden id = "hdChangeAmount_${_pageRef}"   	name = "signatureSC.changeAmount"></ps:hidden>
			<ps:hidden id = "hdAddBtnVisible_${_pageRef}"   	value = "${privilegeList.contains('SIGN002')&& privilegeList.contains('SIGN002A')}"></ps:hidden>
			<ps:hidden id = "hdDelBtnVisible_${_pageRef}"   	value = "${privilegeList.contains('SIGN002')&& privilegeList.contains('SIGN002D')}"></ps:hidden>
			<ps:hidden id = "hdApproveBtnVisible_${_pageRef}"   value = "${privilegeList.contains('SIGN001')&& privilegeList.contains('SIGN002P')}"></ps:hidden>
			<ps:hidden id = "hdRejectBtnVisible_${_pageRef}"    value = "${privilegeList.contains('SIGN001')&& privilegeList.contains('SIGN002R')}"></ps:hidden>
			<ps:hidden id = "showAcceptCancelBtns_${_pageRef}"   name = "signatureSC.showAcceptCancelBtns"></ps:hidden>
			<ps:hidden id = "toolbarLoaded_${_pageRef}"   value = "false"></ps:hidden>
			<ps:hidden id = "signNoteMandatory_${_pageRef}"   name = "signatureSC.signNoteMand"></ps:hidden>
			<ps:hidden id = "signViewMandatory_${_pageRef}"   name = "signatureSC.signViewMand"></ps:hidden>
			<ps:hidden id = "enforceSign_${_pageRef}"   name = "signatureSC.enforceSign"></ps:hidden>
			<ps:hidden id = "signValidateDate_${_pageRef}"   name = "signatureSC.validationDate"></ps:hidden>
			<ps:hidden id = "signApplyFilter_${_pageRef}"   name = "signatureSC.applyFilter"></ps:hidden>
			<ps:hidden id = "signTrxType_${_pageRef}"   name = "signatureSC.trxType"></ps:hidden>
			<ps:hidden id = "signParamAmount_${_pageRef}"   name = "signatureSC.amount"></ps:hidden>
			<ps:hidden id = "signMode_${_pageRef}"   name = "signatureSC.signMode"></ps:hidden>
			<%--EWBI160037 John Massaad--%>			
			<ps:hidden id = "parentIvCrud_${_pageRef}"   name = "signatureSC.parentIvCrud"/>
			<ps:hidden id = "trsStatus_${_pageRef}"   name = "signatureSC.trsStatus"/>
			<ps:hidden id = "trsNo_${_pageRef}"   name = "signatureSC.trsNo"/>
			<ps:hidden id = "validationDate_${_pageRef}"   name="signatureSC.validationDate" />
			<ps:set name="deleted_singatures_cannot_be_accepted_key" value="%{getEscText('deleted_singatures_cannot_be_accepted_key')}"/>
			<ps:set name="deleted_singatures_cannot_be_rejected_key" value="%{getEscText('deleted_singatures_cannot_be_rejected_key')}"/>
			<ps:set name="already_deleted_records_are_selected_key" value="%{getEscText('already_deleted_records_are_selected_key')}"/>
			<ps:set name="already_approved_records_are_selected_key" value="%{getEscText('already_approved_records_are_selected_key')}"/>
			<%--EWBI160037 John Massaad--%>
			<%-- ARIBI180055 --%>
			<ps:set name="deleted_record_can_be_rejected_key" value="%{getEscText('deleted_record_can_be_rejected_key')}"/>
			<ps:set name="approved_record_cannot_be_rejected_key" value="%{getEscText('approved_record_cannot_be_rejected_key')}"/>
			
			
			<ps:url id="signatureGrid" action="SignatureList_loadSignatureGrid?signatureSC.program=${signatureSC.program}&signatureSC.status=${signatureSC.status}&signatureSC.flag=${signatureSC.flag}" escapeAmp="false" namespace="/path/signature">
				<ps:param name="signatureSC.signatureTp"  	value="'${signatureSC.signatureTp}'"></ps:param>				 
				<ps:param name="signatureSC.cifNo"  	value="${signatureSC.cifNo}"></ps:param>				
				<ps:param name="signatureSC.branchCode" value="${signatureSC.branchCode}" ></ps:param>
				<ps:param name="signatureSC.currencyCode" value="${signatureSC.currencyCode}" ></ps:param>
				<ps:param name="signatureSC.glCode" value="${signatureSC.glCode}" ></ps:param>
				<ps:param name="signatureSC.slNo" value="${signatureSC.slNo}" ></ps:param>
				<ps:param name="signatureSC.readOnly" value="${signatureSC.readOnly}" ></ps:param>
				<ps:param name="signatureSC.showAcceptCancelBtns" value="${signatureSC.showAcceptCancelBtns}" ></ps:param>
				<ps:param name="signatureSC.signNoteMand" value="${signatureSC.signNoteMand}" ></ps:param>
				<ps:param name="signatureSC.signViewMand" value="${signatureSC.signViewMand}" ></ps:param>
				<%--EWBI160037 John Massaad--%>
				<ps:param name="signatureSC.trsNo" value="signatureSC.trsNo" ></ps:param>
				<ps:param name="signatureSC.trsType" value="signatureSC.trsType" ></ps:param>
				<ps:param name="signatureSC.cbInd" value="signatureSC.cbInd" ></ps:param>
				<%--EWBI160037 John Massaad--%>
			    <ps:param name="signatureSC.validateFlag" value="signatureSC.validateFlag" ></ps:param>
			    <ps:param name="signatureSC.validationDateStr" value="signatureSC.validationDateStr" ></ps:param>
			</ps:url>
			
		    <psjg:grid
		    	id="signatureGridTbl_Id_${_pageRef}" 	caption="%{getText('Sign_Signature_Management_key')}"	dataType="json" 
		    	href="%{signatureGrid}" 				pager="true" 											filter="false"
		    	gridModel="gridModel" 					multiboxonly="false"									rowNum = "9999999"
		        viewrecords="true" 						multiselect="true"										altRows="true"
		        navigator="true"  						height="130"											
		        navigatorAdd="false" navigatorDelete="false" navigatorEdit="false"   
		        navigatorRefresh="false"				navigatorSearch="false"									
		        hiddengrid='false'
		        shrinkToFit="false"	 autowidth="false" width="815"	 				
		        hidegrid="false"     		onCompleteTopics="onSignatureListLoad"  
		        pagerButtons="false" userDataOnFooter="true" footerrow="true" 
		        onSelectAllTopics="onSignatureCheckBoxSelect" onSelectRowTopics="onSignatureCheckBoxSelect"
		        onGridCompleteTopics="onSignatureCompleteGridload" rownumbers="true"
		        >
		        
				<psjg:gridColumn name="cifObjectVO.SIGN_PROTECTED_YN" 	 		title="Sign Protected" 				index="cifObjectVO.SIGN_PROTECTED_YN" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="cifObjectVO.SIGN_PROTECTED_YN"  	hidden="true"/>
				
		        <psjg:gridColumn name="checked" 	 		title="checked" 				index="checked" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="checked"  	hidden="true"/>
			    <psjg:gridColumn name="action" 						title="%{getText('actions_key')}"				index="action" 						colType="custom" 	editable="false" 	sortable="false" 	search="true"	id="actionEdit"
									 formatter="actionFormatter"  width="250" />
				
		        
				<psjg:gridColumn name="scanVO.DESCRIPTION"			title="%{getText('Description_key')}" 			index="DESCRIPTION" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="DESCRIPTION"/>
				<psjg:gridColumn name="instructionsDesc"			title="%{getText('signature_instructions_key')}" 			index="instructionsDesc" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="instructionsDesc"/>
				<psjg:gridColumn name="cifObjectVO.AMOUNT" 			title="%{getText('Amount_key')}" 				index="cifObjectVO.AMOUNT"			colType="number" 	editable="false" 	sortable="true" 	search="true"	id="AMOUNT" width="95"  formatter="currencyFmatter"  formatCol="currDecPoints" />				
				<psjg:gridColumn name="currencyDesc" 				title="%{getText('Currency_key')}" 				index="currencyDesc" 				colType="text" 		editable="false" 	sortable="true" 	search="true"	id="currencyDesc" width="60" />
				<psjg:gridColumn name="cifObjectVO.GROUP_ID" 		title="%{getText('Group_key')}" 				index="cifObjectVO.GROUP_ID" 		colType="text" 	  editable="false" 	sortable="true" 	search="true"	id="GROUP_ID" width="50" />
				<psjg:gridColumn name="scanVO.EXP_DATE" 			title="%{getText('Expiry_Date_key')}" 			index="scanVO.EXP_DATE"				colType="date" 		editable="false" 	sortable="true" 	search="true"	id="EXP_DATE" width="75" />
				<psjg:gridColumn name="scanVO.DEFAULT_UNLIMITED" 		title="%{getText('Never_Expire_key')}" 			index="scanVO.DEFAULT_UNLIMITED" 		colType="checkbox" 	editable="false" 	sortable="false"		edittype="checkbox" formatter="checkbox"
								 editoptions="{value:'1:0',dataEvents: [{ type: 'change', fn: function(e) {   } }]}"   			formatoptions="{disabled : true}"  width="75"
								 id="defaultUnlimitedFlag"  align="center" />
				<psjg:gridColumn name="statusDesc" 			title="%{getText('Status_key')}" 				index="statusDesc" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="statusDesc" width="75"/>
				<psjg:gridColumn name="toBeStatusDesc" 			title="To be status" 				index="toBeStatusDesc" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="toBeStatusDesc"  hidden="false"/>
				<psjg:gridColumn name="cifObjectVO.STATUS" 			title="%{getText('Status_key')}" 				index="cifObjectVO.STATUS" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="STATUS" width="75" hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.TO_BE_STATUS" 			title="To be status" 				index="cifObjectVO.TO_BE_STATUS" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="TO_BE_STATUS"  hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_SEQ" 		title="Object seq" 				index="cifObjectVO.OBJECT_SEQ" 		colType="number"	editable="false" 	sortable="false" 	search="true"	id="OBJECT_SEQ"  	hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.CIF_NO" 			title="Cif No" 				index="cifObjectVO.CIF_NO" 			colType="number" 	editable="false" 	sortable="false" 	search="true"	id="CIF_NO"  	 	hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_CY" 			title="Currency" 				index="cifObjectVO.ACC_CY" 			colType="number" 	editable="false" 	sortable="false" 	search="true"	id="ACC_CY"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_CIF" 		title="CIF" 				index="cifObjectVO.ACC_CIF" 		colType="number" 	editable="false" 	sortable="false" 	search="true"	id="ACC_CIF"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_SL" 			title="SL no" 				index="cifObjectVO.ACC_SL" 			colType="number" 	editable="false" 	sortable="false" 	search="true"	id="ACC_SL"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_GL" 			title="Gl no" 				index="cifObjectVO.ACC_GL" 			colType="number" 	editable="false" 	sortable="false" 	search="true"	id="ACC_GL"  		hidden="true"/>    
				<psjg:gridColumn name="cifObjectVO.AMOUNT_CY" 		title="Currency" 				index="cifObjectVO.AMOUNT_CY" 		colType="number" 	editable="false" 	sortable="false" 	search="true"	id="AMOUNT_CY"  	hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_CODE" 	title="Object Code" 				index="cifObjectVO.OBJECT_CODE" 	colType="number" 	editable="false" 	sortable="false" 	search="true"	id="OBJECT_CODE"  	hidden="true"/>
				<psjg:gridColumn name="origin" 	 					title="Origin" 				index="origin" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="signatureOrigin"  	hidden="true"/>
				<psjg:gridColumn name="originObjectCode" 	 		title="Origin Object Code" 				index="originObjectCode" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="signOriginObjectCode"  	hidden="true"/>				
				<psjg:gridColumn name="cifObjectVO.BRANCH_CODE" 	 		title="Branch Code" 				index="cifObjectVO.BRANCH_CODE" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="signBranchCode"  	hidden="true"/>
				<psjg:gridColumn name="signViewed" 	 		title="Sign Viewed" 				index="signViewed" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	id="signViewed"  	hidden="true"/>
				<psjg:gridColumn name="lineNo" 	 			title="lineNo" 				index="lineNo" 	colType="number" 	editable="false" 	sortable="false" 	search="false"	id="lineNo"  	hidden="true"/>				
			</psjg:grid>
		</div>
		 <%@include file="SignatureMaint.jsp" %>
	</body>
	<script  type="text/javascript">	
		var no_signatures_found = "<ps:text name='no_signatures_found_key' />";
		var cannot_proceed_title = "<ps:text name='Cannot_Proceed' />";
		$("#signatureGridTbl_Id_"+_pageRef).unsubscribe("onSignatureListLoad");
 		$("#signatureGridTbl_Id_"+_pageRef).subscribe("onSignatureListLoad",function(response,html){ 	
			onSignatureListLoad(response.originalEvent.request.signatureSC);	 
		});
		$("#signatureGridTbl_Id_"+_pageRef).unsubscribe("onSignatureCheckBoxSelect");
			$("#signatureGridTbl_Id_"+_pageRef).subscribe("onSignatureCheckBoxSelect",function(response,html){
			onSignatureCheckBoxSelect();	 
		});
		
		var deleted_singatures_cannot_be_accepted_key = '<ps:property value="deleted_singatures_cannot_be_accepted_key"  escapeHtml="false" escapeJavaScript="true"/>';
		var deleted_singatures_cannot_be_rejected_key = '<ps:property value="deleted_singatures_cannot_be_rejected_key"  escapeHtml="false" escapeJavaScript="true"/>';
		var already_deleted_records_are_selected_key = '<ps:property value="already_deleted_records_are_selected_key"  escapeHtml="false" escapeJavaScript="true"/>';
		var already_approved_records_are_selected_key = '<ps:property value="already_approved_records_are_selected_key"  escapeHtml="false" escapeJavaScript="true"/>';
		//ARIBI180055
		var deleted_record_can_be_rejected_key = '<ps:property value="deleted_record_can_be_rejected_key"  escapeHtml="false" escapeJavaScript="true"/>';
		var approved_record_cannot_be_rejected_key = '<ps:property value="approved_record_cannot_be_rejected_key"  escapeHtml="false" escapeJavaScript="true"/>';
	</script>
</html>
