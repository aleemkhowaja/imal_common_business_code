<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
<html>
	<head>
   		<title> <ps:text name="" /> </title>
	</head>

	<body> 
		<div class="copySignatureListDiv">	
			<ps:hidden id = "hdCopyBtnVisible_${_pageRef}"   	value = "${privilegeList.contains('SIGN002CP')}"></ps:hidden>
			<ps:url id="copySignatureGrid_${_pageRef}" action="SignatureList_loadCopySignatureGrid" escapeAmp="false" namespace="/path/signature">
				<ps:param name="signatureSC.signatureTp"  	value="'${signatureSC.signatureTp}'"></ps:param>				 
				<ps:param name="signatureSC.cifNo"  	value="${signatureSC.cifNo}"></ps:param>				
				<ps:param name="signatureSC.branchCode" value="${signatureSC.branchCode}" ></ps:param>
				<ps:param name="signatureSC.currencyCode" value="${signatureSC.currencyCode}" ></ps:param>
				<ps:param name="signatureSC.glCode" value="${signatureSC.glCode}" ></ps:param>
				<ps:param name="signatureSC.slNo" value="${signatureSC.slNo}" ></ps:param>
			</ps:url>
			
		    <psjg:grid
		    	id="copySignatureGridTbl_Id_${_pageRef}" 		caption=""	dataType="json" 
		    	href="%{copySignatureGrid_${_pageRef}}" 		treeGrid="true"          				treeGridModel="adjacency"
				loadonce="false"	 pager="true" 					filter="false"
		    	gridModel="gridModel" 							multiboxonly="false"					rowNum = "9999999"
		        viewrecords="true" 								multiselect="true"						altRows="true"
		        navigator="true"  								height="130"										
		        navigatorAdd="false"							navigatorDelete="false" 				navigatorEdit="false" 
		        navigatorRefresh="false"						navigatorSearch="false"					hiddengrid='false'
		        shrinkToFit="false"	 							autowidth="false" width="790"	 		hidegrid="false"     
		        pagerButtons="false"  ondblclick="copySignatureGridDbClick()"   >
		        
		     	<psjg:gridColumn name="accNoAndDesc" index="accNo" id="accNo"  title="%{getText('Account_Number_key')}" colType="text"  editable="false" sortable="false" width="300"/>
		     	<psjg:gridColumn name="action" 						title="%{getText('actions_key')}"				index="action" 						colType="custom" 	editable="false" 	sortable="true" 	search="true"	id="actionEdit"	 formatter="copySignActionFormatter"  width="110"/>		  		 
				<psjg:gridColumn name="cifObjectVO.AMOUNT" 			title="%{getText('Amount_key')}" 				index="cifObjectVO.AMOUNT"			colType="number" 	editable="false" 	sortable="true" 	search="true"	  width="100"/>
				<psjg:gridColumn name="currencyDesc" 				title="%{getText('Currency_key')}" 				index="currencyDesc" 				colType="text" 		editable="false" 	sortable="true" 	search="true"	  width="60" />
				<psjg:gridColumn name="cifObjectVO.GROUP_ID" 		title="%{getText('Group_key')}" 				index="cifObjectVO.GROUP_ID" 		colType="text" 	  editable="false" 	sortable="true" 	search="true"	  width="50" />
				<psjg:gridColumn name="scanVO.EXP_DATE" 			title="%{getText('Expiry_Date_key')}" 			index="scanVO.EXP_DATE"				colType="date" 		editable="false" 	sortable="true" 	search="true"	  width="100" />				 
				<psjg:gridColumn name="scanVO.DEFAULT_UNLIMITED" 		title="%{getText('Never_Expire_key')}" 			index="scanVO.DEFAULT_UNLIMITED" 		colType="checkbox" 	editable="true" 	sortable="true"		edittype="checkbox" formatter="checkbox"	formatoptions="{disabled : true}"  width="75"		 />				
				<psjg:gridColumn name="isLeaf" id="isLeaf" index="isLeaf"   colType="text" title="isLeaf"  editable="false" sortable="false"  hidden="true"/>
				<psjg:gridColumn name="parent" id="pId"  index="parent"  colType="text" title="parent"  editable="false" sortable="false"  hidden="true"/>
				<psjg:gridColumn name="index"  index="index" id="selIndex"  title="id" colType="text"  editable="false" sortable="false"  hidden="true" key="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_CODE" 	title="Object Code" 				index="cifObjectVO.OBJECT_CODE" 	colType="number" 	editable="false" 	sortable="true" 	search="true"	id="OBJECT_CODE"  	hidden="true"/>
				<psjg:gridColumn name="cifObjectVO.OBJECT_SEQ" 		title="Object seq" 				index="cifObjectVO.OBJECT_SEQ" 		colType="number"	editable="false" 	sortable="true" 	search="true"	id="OBJECT_SEQ"  	hidden="true"/>
				<psjg:gridColumn name="origin" 	 					title="Origin" 				index="origin" 	colType="text" 	editable="false" 	sortable="false" 	search="false"	  	hidden="true"/>
				
				
			</psjg:grid>
		</div>	
		<%@include  file="SignatureMaint.jsp"%>		
	</body>
	<script type="text/javascript">
	
		function copySignatureGridDbClick(){
		   
				var action 												= 	jQuery.contextPath+ "/path/signature/Signature_loadCopySignatureForm";
				var rowId 												= $("#copySignatureGridTbl_Id_" + _pageRef).jqGrid("getGridParam","selrow");
				var signatureParams										= 	{};
				var selectedSignatureObj 								= 	$("#copySignatureGridTbl_Id_" + _pageRef).jqGrid('getRowData', rowId);
			    if(selectedSignatureObj["isLeaf"]=="true"){	 
					signatureParams["signatureCO.index"] 					= 	selectedSignatureObj["index"];		 	
					signatureParams["signatureCO.signatureTp"] 				= 	$("#signatureTp_"+_pageRef).val();						
					signatureParams["signatureCO.cifObjectVO.OBJECT_CODE"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_CODE"];
					signatureParams["signatureCO.cifObjectVO.OBJECT_SEQ"] 	= 	selectedSignatureObj["cifObjectVO.OBJECT_SEQ"];
					signatureParams["signatureCO.origin"] 					= 	selectedSignatureObj["origin"];
					signatureParams["signatureSC.branchCode"] 				= 	$("#signatureBranchCode_"+_pageRef).val();
					signatureParams["_pageRef"] 							= 	_pageRef;
					signatureParams["signatureCO.viewMode"] 				= 	"V";
						
						$("#signatureFormDiv_"+'<ps:property value="_pageRef"  escapeHtml="false" escapeJavaScript="true"/>'+'<ps:property value="secondaryId"  escapeHtml="false" escapeJavaScript="true"/>').load(
						action,
						signatureParams, 
						function() {
						}
					);
			}
		 
	}
	</script>
 
</html>
