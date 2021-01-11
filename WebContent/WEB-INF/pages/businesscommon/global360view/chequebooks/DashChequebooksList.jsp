<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
			<ps:url id="urlDashChqBooksGrid_${_pageRef}" 
			        namespace="/path/globalview" escapeAmp="false"
				    action="chequebooksListAction?_pageRef=${_pageRef}">
			   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
			   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
			</ps:url>
		    <psjg:grid id="DashChqBookListGridTbl_Id_${_pageRef}" 
					caption="%{getText('chequeBooks_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlDashChqBooksGrid_${_pageRef}}"
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
			    <psjg:gridColumn id="BRANCH_CODE" colType="number" name="ctschqbookVO.BRANCH_CODE" index="BRANCH_CODE"  title="%{getText('Branch_code_key')}"    editable="false" sortable="true" search="true" />	        
				<psjg:gridColumn id="CODE" 		  colType="number" name="ctschqbookVO.CODE" 	   index="CODE" 		title="%{getText('request_number_key')}" editable="false" sortable="true" search="true" formatter="dashboard_chequebookCodeBtn"/>
				<psjg:gridColumn id="statusDesc"  colType="text"   name="statusDesc" 	   		   index="statusDesc" 	title="%{getText('status_key')}" 		 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="CHEQUE_CODE" colType="number" name="ctschqbookVO.CHEQUE_CODE" index="CHEQUE_CODE" 	title="%{getText('cheque_code_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="TYPES_DESC"  colType="text"   name="ctsTypeVO.DESC_ENG"       index="TYPES_DESC" 	title="%{getText('desc_eng_key')}" 	     editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_BR" 	  colType="number" name="ctschqbookVO.ACC_BR" 	   index="ACC_BR" 		title="%{getText('Acc_Branch_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_CY" 	  colType="number" name="ctschqbookVO.ACC_CY" 	   index="ACC_CY" 		title="%{getText('Acc_Currency_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_GL" 	  colType="number" name="ctschqbookVO.ACC_GL" 	   index="ACC_GL" 		title="%{getText('Acc_GL_key')}" 		 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_CIF" 	  colType="number" name="ctschqbookVO.ACC_CIF" 	   index="ACC_CIF" 		title="%{getText('Acc_CIF_key')}" 		 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_SL" 	  colType="number" name="ctschqbookVO.ACC_SL" 	   index="ACC_SL" 		title="%{getText('Acc_SL_key')}" 		 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="ACC_ADD_REF" colType="number" name="ctschqbookVO.ACC_ADD_REF" index="ACC_ADD_REF" 	title="%{getText('Additional_Reference_key')}"            editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="LONG_NAME_ENG" index="LONG_NAME_ENG"  						   colType="text"	    name="amfVO.LONG_NAME_ENG" 			 title="%{getText('Account_Name_key')}"     	   editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="IBAN_ACC_NO" colType="text"   name="amfVO.IBAN_ACC_NO" 	   index="IBAN_ACC_NO" 	title="%{getText('ibanAccNo_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="FROM_NUMBER" colType="number" name="ctschqbookVO.FROM_NUMBER" index="FROM_NUMBER" 	title="%{getText('from_number_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="NUMBER_TO"   colType="number" name="ctschqbookVO.NUMBER_TO"   index="NUMBER_TO" 	title="%{getText('to_number_key')}" 	 editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="STATUS" 	  colType="text"   name="ctschqbookVO.STATUS" 	   index="STATUS" 		title="%{getText('Status_Iden_key')}" 			 editable="false" sortable="true" search="true" hidden="true"/>
			</psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var accountKey  = "<ps:text name='Accounts_key'/>";
 var chequeBookKey = "<ps:text name='Chq_Book_key' />";
 $("#DashChqBookListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'ctschqbookVO.ACC_BR', numberOfColumns: 6, titleText: accountKey}]
	});		
	
							
 </script>