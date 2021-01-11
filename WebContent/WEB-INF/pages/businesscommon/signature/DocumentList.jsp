<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<html>
	<head>
	</head>
	<body> 
		<div> 	
			<ps:hidden id = "showDocViewLink_${_pageRef}${secondaryId}" 	 	name = "signatureSC.details"></ps:hidden>
			<ps:hidden id = "showDocEditLink_${_pageRef}${secondaryId}" 		 name = "signatureSC.edit"></ps:hidden>	
			<ps:if test="'_doc'.equals('${secondaryId}')">		
				<ps:hidden id = "showDocAddBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('DOC002A')}"></ps:hidden>
				<ps:hidden id = "showDocDelBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('DOC002D')}"></ps:hidden>
				<ps:hidden id = "showDocApproveBtn_${_pageRef}${secondaryId}"   	value = "${privilegeList.contains('DOC002P')}"></ps:hidden>
				<!--<ps:hidden id = "showDocRejectBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('DOC002R')}"></ps:hidden>-->
			</ps:if>
			<ps:else>
				<ps:hidden id = "showDocAddBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('PHO002A')}"></ps:hidden>
				<ps:hidden id = "showDocDelBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('PHO002D')}"></ps:hidden>
				<ps:hidden id = "showDocApproveBtn_${_pageRef}${secondaryId}"   	value = "${privilegeList.contains('PHO002P')}"></ps:hidden>
				<!--<ps:hidden id = "showDocRejectBtn_${_pageRef}${secondaryId}"   		value = "${privilegeList.contains('PHO002R')}"></ps:hidden>-->
			</ps:else>
			
		 
		
			<ps:url id="documentGridUrl_${_pageRef}${secondaryId}" action="SignatureList_loadDocumentGrid" escapeAmp="false" namespace="/path/signature">
				<ps:param name="signatureSC.signatureTp"  	value="'${signatureSC.signatureTp}'"></ps:param>				 
				<ps:param name="signatureSC.cifNo"  	value="${signatureSC.cifNo}"></ps:param>				
				<ps:param name="signatureSC.branchCode" value="${signatureSC.branchCode}" ></ps:param>
				<ps:param name="signatureSC.currencyCode" value="${signatureSC.currencyCode}" ></ps:param>
				<ps:param name="signatureSC.glCode" value="${signatureSC.glCode}" ></ps:param>
				<ps:param name="signatureSC.slNo" value="${signatureSC.slNo}" ></ps:param>
				<ps:param name="signatureSC.docType" value="'${signatureSC.docType}'" ></ps:param>
			</ps:url>
			
		    <psjg:grid
		    	id="documentGridTbl_Id_${_pageRef}${secondaryId}" 	caption=""												dataType="json" 
		    	href="%{documentGridUrl_${_pageRef}${secondaryId}}" 	pager="true" 											filter="false"
		    	gridModel="gridModel" 					multiboxonly="false"									rowNum = "9999999"
		        viewrecords="true" 						multiselect="true"		 								altRows="true"
		        navigator="true"  						height="130"										    width="790"				
		        navigatorAdd="false"					navigatorDelete="false" 								navigatorEdit="false" 
		        navigatorRefresh="false"				navigatorSearch="false"									hiddengrid='false'
		        shrinkToFit="false"						autowidth="false"  										 		
		        hidegrid="false"   						onCompleteTopics="onDocumentGridLoad"   pagerButtons="false"   >  
		       
		    	<psjg:gridColumn name="action" title="%{getText('actions_key')}" index="action"	colType="custom" 	editable="false" 	sortable="true" 	search="true"	id="documentGridActions"   		 formatter="function (cellvalue, options, rowObject) { return  docGridActionFormatter(cellvalue, options, rowObject,'${_pageRef}${secondaryId}');}" />  			
				<psjg:gridColumn name="scanVO.DESCRIPTION"		width="300"	title="%{getText('Description_key')}" 			index="scanVO.DESCRIPTION" 		colType="text" 		editable="false" 	sortable="true" 	search="true"	id="documentDesc_${_pageRef}${secondaryId}"/>
			
				<psjg:gridColumn name="statusDesc" 			title="%{getText('Status_key')}" 				index="statusDesc" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="statusDesc" width="75"/>
				<psjg:gridColumn name="toBeStatusDesc" 			title="%{getText('To_be_status_key')}" 				index="toBeStatusDesc" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="toBeStatusDesc"   />
				<psjg:gridColumn name="cifObjectVO.STATUS" 			title="%{getText('Status_key')}" 				index="cifObjectVO.STATUS" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="STATUS" width="75" hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.TO_BE_STATUS" 			title="To be status" 				index="cifObjectVO.TO_BE_STATUS" 			colType="text" 		editable="false" 	sortable="true" 	search="true"	id="TO_BE_STATUS"  hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_CODE" 	title="Object Code" 				index="cifObjectVO.OBJECT_CODE" 	colType="number" 	editable="false" 	sortable="true" 	search="true"	id="documentObjectCode_${_pageRef}${secondaryId}"  	hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_SEQ" 		title="Object seq" 				index="cifObjectVO.OBJECT_SEQ" 		colType="number"	editable="false" 	sortable="true" 	search="true"	id="OBJECT_SEQ"  	hidden="true"/>		
				<psjg:gridColumn name="cifObjectVO.ACC_CY" 			title="Currency" 				index="cifObjectVO.ACC_CY" 			colType="number" 	editable="false" 	sortable="true" 	search="true"	id="ACC_CY"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_CIF" 		title="CIF" 				index="cifObjectVO.ACC_CIF" 		colType="number" 	editable="false" 	sortable="true" 	search="true"	id="ACC_CIF"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_SL" 			title="SL no" 				index="cifObjectVO.ACC_SL" 			colType="number" 	editable="false" 	sortable="true" 	search="true"	id="ACC_SL"  		hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.ACC_GL" 			title="Gl no" 				index="cifObjectVO.ACC_GL" 			colType="number" 	editable="false" 	sortable="true" 	search="true"	id="ACC_GL"  		hidden="true"/>    
				<psjg:gridColumn name="cifObjectVO.BRANCH_CODE" 	 		title="Branch Code" 				index="cifObjectVO.BRANCH_CODE" 	colType="text" 	editable="false" 	sortable="false" 	search="false"  	hidden="true"/>
												
			</psjg:grid>
			  	<%@include  file="DocumentMaint.jsp"  %>	 
		</div>
		 
	</body>
	<script  type="text/javascript">	
 		$("#documentGridTbl_Id_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').subscribe("onDocumentGridLoad",function(){ 			
			onDocumentListLoad('<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>');	 
		});
		 	
		 
	</script>
	
 
</html>
