<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlCardsGrid_${_pageRef}" 
        namespace="/path/globalview" escapeAmp="false"
	    action="cardsListAction?_pageRef=${_pageRef}">
   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
</ps:url>
   <psjg:grid id="cardsListGridTbl_Id_${_pageRef}" 
		caption="%{getText('cards_key')}"
        altRows="true"
    	dataType="json" 
		filter="true"
    	gridModel="gridModel" 
    	href="%{urlCardsGrid_${_pageRef}}"
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
	<psjg:gridColumn id="banch_code"            index="banch_code"          colType="number" name="banch_code"           		 title="%{getText('Branch_code_key')}"          editable="false" sortable="true" search="true" />
	<psjg:gridColumn id="ctsCardsMGTVO.CARD_NO" index="CARD_NO"         	colType="text"   name="ctsCardsMGTVO.CARD_NO"        title="%{getText('Card_No_key')}" 				editable="false" sortable="true" search="true" hidden="true"/>
	<psjg:gridColumn id="maskedCardNo"         index="CARD_NO"		 	 	colType="text"  name="maskedCardNo"        		 	 title="%{getText('Card_No_key')}" 				editable="false" sortable="true" search="true" formatter="dashboard_cardsBtn"/>	
	<psjg:gridColumn id="APPLICATION_ID"        index="APPLICATION_ID"        colType="number" name="ctsCardsMGTVO.APPLICATION_ID" title="%{getText('Application_Id_key')}" 	editable="false" sortable="true" search="true" />
	<psjg:gridColumn id="primary_suplementary" index="primary_suplementary" colType="text"   name="primary_suplementary" 		 title="%{getText('Primary_Supplementary_key')}" editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="card_type"            index="card_type"            colType="text"   name="card_type"	         		 title="%{getText('Card_Type_key')}"            editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="expiry_date"          index="expiry_date"          colType="date"   name="expiry_date"          		 title="%{getText('Expiry_Date_key')}"          editable="false" sortable="true" search="true"/>				
	<psjg:gridColumn id="status"	           index="status"               colType="text"	 name="status"				 		 title="%{getText('status_key')}" 		        editable="false" sortable="true" search="true"/>
	
	<psjg:gridColumn id="APP_REF"        	   index="APP_REF"              colType="number" name="ctsCardsMGTVO.APP_REF" 								          title="%{getText('Application_Reference_key')}"                editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="CARD_HOLDER_NAME" 	   index="CARD_HOLDER_NAME"	    colType="text"   name="ctsCardsMGTVO.CARD_HOLDER_NAME" 	title="%{getText('Card_Holder_Name_key')}" editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="EffectiveDate"	       index="EFFECTIVE_DATE"       colType="date"	 name="ctsCardsMGTVO.EFFECTIVE_DATE"		 title="%{getText('Effective_Date_key')}" 		        editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="OutstandingBalance"   index="OUTSTANDING_BALANCE"  colType="number"	 name="ctsCardsMGTVO.OUTSTANDING_BALANCE"  title="%{getText('Outstanding_Balance_key')}" 		        editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="DueAmount"	           index="DUE_AMOUNT"           colType="number"	 name="ctsCardsMGTVO.DUE_AMOUNT"		 title="%{getText('due_amount_key')}" 		        editable="false" sortable="true" search="true"/>
	
	<psjg:gridColumn id="credit_type"	       index="credit_type"          colType="text"   name="credit_type"		     		 title="%{getText('Credit_Type_key')}" 	        editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="payment_perc"	       index="payment_perc"         colType="number" name="payment_perc"		 		 title="%{getText('Payment_Percentage_key')}" 	editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="acc_br"	           index="acc_br"               colType="number" name="acc_br"		         		 title="%{getText('Acc_Branch_key')}" 	        editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="acc_cy"	           index="acc_cy"               colType="number" name="acc_cy"	            	 	 title="%{getText('Acc_Currency_key')}" 	    editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="acc_gl"	           index="acc_gl"               colType="number" name="acc_gl"		         		 title="%{getText('Acc_GL_key')}" 	            editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="acc_cif"	           index="acc_cif"              colType="number" name="acc_cif"              		 title="%{getText('A_C_CIF_key')}"              editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="acc_sl"               index="acc_sl"               colType="number" name="acc_sl"				 		 title="%{getText('A_C_SL_key')}"               editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="ACC_ADD_REF"          index="ACC_ADD_REF"          colType="text" 	 name="amfVO.ADDITIONAL_REFERENCE"	 title="%{getText('Additional_Reference_key')}" editable="false" sortable="true" search="true"/>
	<psjg:gridColumn id="ACC_LONG_NAME_ENG"    index="ACC_LONG_NAME_ENG"    colType="text"   name="amfVO.LONG_NAME_ENG"			 title="%{getText('Account_Name_key')}"         editable="false" sortable="true" search="true"/>
</psjg:grid>

 <script type="text/javascript">
  //Setting multi header columns
 var accountKey  = "<ps:text name='Accounts_key'/>";
 var cardsManagementKey = "<ps:text name='cardsMgmt.cardsMgmtList' />";
 $("#cardsListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'acc_br', numberOfColumns: 6, titleText: accountKey}]
	});								
 </script>
