<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
    <!-- <ps:hidden id="cifNo_${_pageRef}"  name="cif_no"/> -->
	<ps:url id="urlDashPassbooksGrid_${_pageRef}" 
	        namespace="/path/globalview" escapeAmp="false"
		    action="passbooksListAction?_pageRef=${_pageRef}">
	   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
	   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
	</ps:url>
    <psjg:grid id="dashPassbookListGridTbl_Id_${_pageRef}" 
			caption="%{getText('Passbook_key')}"
	        altRows="true"
	    	dataType="json" 
			filter="true"
	    	gridModel="gridModel" 
	    	href="%{urlDashPassbooksGrid_${_pageRef}}"
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
			   <psjg:gridColumn id="branch_code"   	   	 name="branch_code"   					  index="branch_code"   	colType="number" title="%{getText('Branch_code_key')}"   		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="passbook_no"   	     name="passbook_no"   	                  index="passbook_no"   	colType="number" title="%{getText('passbook_no_key')}"   		editable="false" sortable="true" search="true" formatter="dashboard_passBookNbBtn"/>
			   <psjg:gridColumn id="status"        		 name="status"        					  index="status"       	 	colType="text"   title="%{getText('status_key')}"        		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="date_created"  	     name="date_created"  	                  index="date_created"  	colType="date"   title="%{getText('date_created_key')}"  		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="passbook_type" 	     name="passbook_type" 					  index="passbook_type" 	colType="text"   title="%{getText('passbook_type_key')}" 		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="current_page"  	     name="current_page"  					  index="current_page"  	colType="number" title="%{getText('Current_Page_key')}"  		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="acc_br"              name="acc_br"        				      index="acc_br"        	colType="number" title="%{getText('Acc_Branch_key')}"    		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="acc_cy"       	 	 name="acc_cy"        					  index="acc_cy"        	colType="number" title="%{getText('Acc_Cy_key')}"        		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="acc_gl"        		 name="acc_gl"        					  index="acc_gl"        	colType="number" title="%{getText('Acc_GL_key')}"        		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="acc_cif"       		 name="acc_cif"       			    	  index="acc_cif"       	colType="number" title="%{getText('Acc_CIF_key')}"       		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="acc_sl"        		 name="acc_sl"        			    	  index="acc_sl"        	colType="number" title="%{getText('Acc_SL_key')}"        		editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="ACC_ADD_REF"   		 name="ctsPassBookVO.CHR_AC_ADD_REF"  	  index="ACC_ADD_REF"   	colType="text" title="%{getText('Additional_Reference_key')}"   editable="false" sortable="true" search="true"/>
			   <psjg:gridColumn id="ACC_LONG_NAME_ENG"   name="amfVO.LONG_NAME_ENG"  	  		  index="ACC_LONG_NAME_ENG" colType="text" title="%{getText('Account_Name_key')}" 		    editable="false" sortable="true" search="true"/>
			   
	</psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var accountKey  = "<ps:text name='Accounts_key'/>";
 var passbookKey = "<ps:text name='Passbook_key'/>";
 $("#dashPassbookListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'acc_br', numberOfColumns: 6, titleText: accountKey}]
	});								
 </script>
