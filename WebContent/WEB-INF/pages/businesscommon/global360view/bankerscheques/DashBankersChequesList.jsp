<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <!-- <ps:hidden id="cifNo_${_pageRef}"  name="cif_no"/> -->
			<ps:url id="urlBankersChqGrid_${_pageRef}" 
			        namespace="/path/globalview" escapeAmp="false"
				    action="dashBankersChequesListAction?_pageRef=${_pageRef}">
			   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
			   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
			</ps:url>

		    <psjg:grid id="bankersChqListGridTbl_Id_${_pageRef}" 
					caption="%{getText('bankers_cheques_key')}"
			        altRows="true"
			    	dataType="json" 
					filter="true"
			    	gridModel="gridModel" 
			    	href="%{urlBankersChqGrid_${_pageRef}}"
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
                <psjg:gridColumn id="decimal_points"    	index="decimal_points" 	     colType="number" name="decimal_points"  	  title=" "  hidden="true"/>
                <psjg:gridColumn id="COMP_CODE"		    	index="COMP_CODE"		     colType="number" name="ctstrsVO.COMP_CODE"           title="Hidden compCode"	                		editable="false" sortable="true" search="true" hidden = "true"/>
		    	<psjg:gridColumn id="TRS_TYPE"		    	index="TRS_TYPE"		     colType="text"   name="ctstrsVO.TRS_TYPE"	          title="Hidden TRS_TYPE"		            		editable="false" sortable="true" search="true" hidden = "true"/>
		    	<psjg:gridColumn id="CB_IND"		  		index="CB_IND"		  	     colType="text"   name="ctstrsVO.CB_IND"	  		  title="Hidden CB_IND"			           		    editable="false" sortable="true" search="true" hidden = "true"/>
				<psjg:gridColumn id="branch_code"       	index="branch_code"          colType="number" name="branch_code"         		  title="%{getText('Branch_code_key')}"             editable="false" sortable="true" search="true" />
				<psjg:gridColumn id="trx_no"            	index="trx_no"               colType="number" name="trx_no" 	          		  title="%{getText('Trx_No_key')}"	              	editable="false" sortable="true" search="true" formatter="dashboard_bankersChqTrxBtn"/>
				<psjg:gridColumn id="trx_type"          	index="trx_type"             colType="text"   name="trx_type"            		  title="%{getText('Transaction_Type_key')}"        editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="trxTypeDesc"	    	index="trxTypeDesc"	         colType="text"   name="trxTypeDesc"		  		  title="%{getText('shortDescEng_key')}"            editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_br"       	index="from_acc_br"          colType="number" name="from_acc_br"	     		  title="%{getText('Acc_Br_key')}"                  editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_cy"       	index="from_acc_cy"          colType="number" name="from_acc_cy"                  title="%{getText('Acc_Cy_key')}"                  editable="false" sortable="true" search="true"/>				
				<psjg:gridColumn id="from_acc_gl"	    	index="from_acc_gl"          colType="number" name="from_acc_gl"		 		  title="%{getText('Acc_GL_key')}" 		          	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_cif"	    	index="from_acc_cif"         colType="number" name="from_acc_cif"		  		  title="%{getText('Acc_CIF_key')}" 	            editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_sl"	    	index="from_acc_sl"          colType="number" name="from_acc_sl"		  		  title="%{getText('Acc_SL_key')}" 	              	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_add_ref"	    index="from_acc_add_ref"     colType="text"   name="from_acc_add_ref"		  	  title="%{getText('Additional_Reference_key')}"    editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="from_acc_name"         index="from_acc_name"        colType="text"   name="from_acc_name"     	  		  title="%{getText('Account_Name_key')}"            editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="to_acc_br"	        	index="to_acc_br"            colType="number" name="to_acc_br"	          		  title="%{getText('Acc_Br_key')}" 	              	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="to_acc_cy"	       	 	index="to_acc_cy"         	 colType="number" name="to_acc_cy"		      		  title="%{getText('Acc_Cy_key')}" 	              	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="to_acc_gl"	        	index="to_acc_gl"            colType="number" name="to_acc_gl"                    title="%{getText('Acc_GL_key')}"                  editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="to_acc_cif"        	index="to_acc_cif"        	 colType="number" name="to_acc_cif"		  			  title="%{getText('Acc_CIF_key')}"                 editable="false" sortable="true" search="true"/>
			    <psjg:gridColumn id="to_acc_sl"	           	index="to_acc_sl"         	 colType="number" name="to_acc_sl"		     		  title="%{getText('Acc_SL_key')}" 	              	editable="false" sortable="true" search="true"/>
			    <psjg:gridColumn id="to_acc_add_ref"	    index="to_acc_add_ref"       colType="text"   name="to_acc_add_ref"		  	  	  title="%{getText('Additional_Reference_key')}" 	editable="false" sortable="true" search="true"/>
				<psjg:gridColumn id="to_acc_name"        	index="to_acc_name"          colType="text"   name="to_acc_name"     	          title="%{getText('Account_Name_key')}"            editable="false" sortable="true" search="true"/>
			    <psjg:gridColumn id="amount"	        	index="amount"            	 colType="number" name="amount"		      			  title="%{getText('amount_key')}" 	              	editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
                <psjg:gridColumn id="trx_date"	        	index="trx_date"             colType="date"   name="trx_date"		      		  title="%{getText('trs_date_key')}" 	            editable="false" sortable="true" search="true"/>
                <psjg:gridColumn id="remittance_type"		index="remittance_type"      colType="text"   name="remittance_type"	  		  title="%{getText('Remittance_Type_key')}" 	    editable="false" sortable="true" search="true"/>
                <psjg:gridColumn id="remittance_status" 	index="remittance_status"    colType="text"   name="remittance_status"	  		  title="%{getText('Remittance_Status_key')}"       editable="false" sortable="true" search="true"/>			
			</psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var from_acc_Key 	 = "<ps:text name='from_acc_key'/>";
 var to_acc_Key = "<ps:text name='to_Account_key'/>";
  var bankersChqKey = "<ps:text name='bankers_cheques_key'/>";
 $("#bankersChqListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'from_acc_br', numberOfColumns: 6, titleText: from_acc_Key},{startColumnName: 'to_acc_br', numberOfColumns: 6, titleText: to_acc_Key}
	  ]
	});								
 </script>