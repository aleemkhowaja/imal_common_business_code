<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
			 
			 <ps:url id="urlCtsRequestGrid" escapeAmp="false" 
				action="CtsRequestListAction_loadCtsRequestGrid" namespace="/path/requests">
			   <ps:param name="iv_crud"  value="%{iv_crud}"></ps:param> 
			   <ps:param name="_pageRef" value="_pageRef"></ps:param>
			   <ps:param name="fromRequest" value="%{fromRequest}"></ps:param>
			   <ps:param name="requestType" value="%{ctsRequestCO.ctsRequestVO.TYPE}"></ps:param>
			   <ps:param name="scannedCIFNo" value="%{ctsRequestCO.scannedCIFNo}"></ps:param>
			   <ps:param name="tfaStatus" value="%{ctsRequestCO.tfaStatus}"></ps:param>
			</ps:url>
			 
		    <psjg:grid id="ctsRequestGridTbl_Id_${_pageRef}" 
					caption=" "
			        altRows="true"
			        addfunc="${param.openNewCtsRequest}"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlCtsRequestGrid}" 
			        height="130"
			    	hiddengrid='%{iv_crud == "R"}'
			        navigator="true" 
			        navigatorAdd="false"
			        
			        navigatorDelete="false"
			        navigatorEdit="false"
			        navigatorRefresh="false"
			        navigatorSearch="true"
			        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
			        ondblclick="${param.onCtsRequestGridDblClick}" 
			    	pager="true" 
			    	rowNum="5" 
			    	rowList="5,10,15,20"
			        shrinkToFit="false"
			        sortable="true"
			        sortname="REQ_NO" sortorder="desc"
			        viewrecords="true" 
					>	 
				<psjg:gridColumn  id="ctsRequestVO.COMP_CODE"		colType="number"		name="ctsRequestVO.COMP_CODE"				title="COMP_CODE" 							index="COMP_CODE" 			editable="false" sortable="true"  search="true" hidden="true" />
				<psjg:gridColumn  id="ctsRequestVO.BRANCH"			colType="text"			name="ctsRequestVO.BRANCH"					title="BRANCH" 								index="BRANCH" 				editable="false" sortable="true"  search="true" hidden="true" />       
				<psjg:gridColumn  id="ctsRequestVO.REQ_NO"    		colType="number"		name="ctsRequestVO.REQ_NO" 					title="%{getText('request_number_key')}"	index="REQ_NO" width="90"   editable="false" sortable="true"  search="true" leadZeros="6"/>
				<psjg:gridColumn  id="ctsRequestVO.TYPE"			colType="number"		name="ctsRequestVO.TYPE"					title="%{getText('Type_key')}" 				index="TYPE"                editable="false" sortable="true"  search="true" leadZeros="6"/>
				<psjg:gridColumn  id="ctsRequestVO.REQ_DATE"		colType="date"			name="ctsRequestVO.REQ_DATE"				title="%{getText('Request_Date_key')}" 		index="REQ_DATE" 		    editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="ctsRequestVO.CIF_NO"			colType="number"		name="ctsRequestVO.CIF_NO"					title="%{getText('CIF_No_key')}" 			index="CIF_NO" 			    editable="false" sortable="true"  search="true" leadZeros="8"/>
				<psjg:gridColumn  id="cifIdNoStr"					colType="text"			name="cifIdNoStr"							title="%{getText('ID_No_key')}" 			index="cifIdNoStr" 		    editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="ctsRequestVO.REQ_REF"			colType="text"			name="ctsRequestVO.REQ_REF"					title="%{getText('Reference_key')}" 		index="REQ_REF" 			editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="ctsRequestVO.REQ_DESC"		colType="text"			name="ctsRequestVO.REQ_DESC"				title="%{getText('desc_eng_key')}" 			index="REQ_DESC" 			editable="false" sortable="true"  search="true" />
				<psjg:gridColumn  id="ctsRequestVO.STATUS"			colType="text"			name="ctsRequestVO.STATUS"					title="%{getText('Status_key')}" 			index="STATUS" 				editable="false" sortable="true"  search="true" hidden="true" />
				<psjg:gridColumn  id="requestStatusDesc"			colType="text"			name="requestStatusDesc"					title="%{getText('Status_key')}" 			index="requestStatusDesc" 	editable="false" sortable="true"  search="true" />
				
				<ps:if test='${ctsRequestCO.tfaStatus !="" and ctsRequestCO.tfaStatus !=null }'>			
					<psjg:gridColumn  id="ctsRequestVO.APPLICATION_CODE" colType="number"		name="ctsRequestVO.APPLICATION_CODE" 		title="%{getText('Document_Number_key')}" 			index="APPLICATION_CODE" 	editable="false" sortable="true"  search="true" leadZeros="10"/>				
			    </ps:if>
				<ps:else>
			     	<psjg:gridColumn  id="ctsRequestVO.APPLICATION_CODE" colType="number"		name="ctsRequestVO.APPLICATION_CODE" 		title="%{getText('Deal_No_key')}" 			index="APPLICATION_CODE" 	editable="false" sortable="true"  search="true" leadZeros="10"/>				
			  	</ps:else>
			  	<psjg:gridColumn  id="ctsRequestVO.PROCESS_BRANCH"    		colType="number"		name="ctsRequestVO.PROCESS_BRANCH" 					title="%{getText('branchCode')}"	index="PROCESS_BRANCH" width="90"   editable="false" sortable="true"  search="true" leadZeros="6"/>
				
				<psjg:gridColumn  id="ctsRequestVO.APPLICATION_CODE" colType="number"		name="ctsRequestVO.APPLICATION_CODE" 		title="%{getText('Deal_No_key')}" 			index="APPLICATION_CODE" 	editable="false" sortable="true"  search="true" leadZeros="10"/>				
				<psjg:gridColumn  id="ctsRequestVO.SAVED_AS_DRAFT"	colType="text"			name="ctsRequestVO.SAVED_AS_DRAFT"			title="%{getText('savedAsDraftDesc_key')}" 		index="SAVED_AS_DRAFT" 		editable="false" sortable="true"  search="true" hidden="true"/>
				<psjg:gridColumn  id="saveType"						colType="text"			name="saveType"								title="%{getText('savedAsDraftDesc_key')}" 		index="saveType" 			editable="false" sortable="true"  search="true" />
				
				
			</psjg:grid>

<%/* In case we open this screen from TFA module */ %>
<ps:if test='${ctsRequestCO.tfaStatus !="" and ctsRequestCO.tfaStatus !=null }'>			
	<script  type="text/javascript">
	    $.struts2_jquery.require("LgMgntList.js,LgMgntMaint.js" ,null,jQuery.contextPath+"/path/js/tfa/lg/");

	</script>
</ps:if>

<ps:if test='iv_crud == "R"'>
	<script>
		$(document).ready(function() {
			initTradePage();
		});
	</script>
</ps:if>

<script type="text/javascript">
 $("#gview_ctsRequestGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
 </script>
 
 <script  type="text/javascript">
    $.struts2_jquery.require("LgMgntList.js,LgMgntMaint.js" ,null,jQuery.contextPath+"/path/js/tfa/lg/");
</script>