<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlDashLostDocsGrid_${_pageRef}" 
        namespace="/path/globalview" escapeAmp="false"
	    action="dashLostDocsListAction?_pageRef=${_pageRef}">
   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
</ps:url>
 <psjg:grid id="DashLostDocsListGridTbl_Id_${_pageRef}" 
			caption="%{getText('lostDocuments_key')}"
	        altRows="true"
	    	dataType="json" 
			filter="true"
	    	gridModel="gridModel" 
	    	href="%{urlDashLostDocsGrid_${_pageRef}}"
	        navigator="true" 
	        navigatorAdd="false"
	        navigatorDelete="false"
	        navigatorEdit="false"
	        navigatorRefresh="false"
	        navigatorSearch="true"
	        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
	    	pager="true"
	    	rowNum="10" 
	    	rowList="5,10,15,20"
	        shrinkToFit="false"
	        sortable="true"
	        viewrecords="true">
			<psjg:gridColumn id="branch_code" 			colType="number" name="branch_code" 				index="branch_code" 		title="%{getText('Branch_code_key')}"    	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="trx_no"      			colType="number" name="trx_no"      				index="trx_no"      		title="%{getText('trsNo_key')}"          	   editable="false" sortable="true" search="true" formatter="dashboard_dahsLostDocsTrxBtn"/>
			<psjg:gridColumn id="status"      			colType="text"   name="status"      				index="status"      		title="%{getText('Status_key')}"         	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="DOC_TYPE"      		colType="text"   name="ctsLostFoundVO.DOC_TYPE"     index="DOC_TYPE"      		title="%{getText('Document_Type_key')}" 	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="DOC_TYPE_BRIEF_NAME"   colType="text"   name="ctsLostDocVO.BRIEF_DESC_ENG" index="DOC_TYPE_BRIEF_NAME" title="%{getText('doc_type_brief_name_key')}"  editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="DOC_CODE"      		colType="text"   name="ctsLostFoundVO.DOC_CODE"     index="DOC_CODE"      		title="%{getText('Document_Code_key')}" 	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="DOC_CODE_BRIEF_NAME"   colType="text"   name="docTypeBriefName"            index="DOC_CODE_BRIEF_NAME" title="%{getText('doc_code_brief_name_key')}"  editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_br"      			colType="number" name="acc_br"      				index="acc_br"      		title="%{getText('Acc_Branch_key')}"     	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_cy"      			colType="number" name="acc_cy"      				index="acc_cy"      		title="%{getText('Acc_Currency_key')}"   	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_gl"      			colType="number" name="acc_gl"      				index="acc_gl"      		title="%{getText('Acc_GL_key')}"         	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_cif"     			colType="number" name="acc_cif"     				index="acc_cif"     		title="%{getText('A_C_CIF_key')}"        	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_sl"      			colType="number" name="acc_sl"      				index="acc_sl"      		title="%{getText('A_C_SL_key')}"         	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="acc_sl"      			colType="number" name="acc_sl"      				index="acc_sl"      		title="%{getText('A_C_SL_key')}"         	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ACC_ADD_REF"   		colType="number" name="ctsLostFoundVO.ACC_ADD_REF"  index="ACC_ADD_REF"      	title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ACC_LONG_NAME" 		colType="text" 	 name="amfVO.LONG_NAME_ENG"      	index="ACC_LONG_NAME"      	title="%{getText('Account_Name_key')}"         editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="doc_no"      			colType="number" name="doc_no"      				index="doc_no"      		title="%{getText('document_no_key')}"    	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="to_doc_no"  			colType="number" name="to_doc_no"   				index="to_doc_no"   		title="%{getText('to_document_no_key')}" 	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="stop_date"   			colType="date"   name="stop_date"   				index="stop_date"   		title="%{getText('stop_date_key')}"      	   editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="stop_reason" 			colType="text"   name="stop_reason" 				index="stop_reason" 		title="%{getText('stop_reason_key')}"    	   editable="false" sortable="true" search="true"/>
 </psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var accountKey  = "<ps:text name='Accounts_key'/>";
 var lostDocsKey = "<ps:text name='lostDocuments_key'/>";
 $("#DashLostDocsListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'acc_br', numberOfColumns: 7, titleText: accountKey}]
	});								
 </script>
