<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
	<body>
			<ps:url id="urlSpecialCondCIFGrid_${_pageRef}" 
			        namespace="/path/globalview" escapeAmp="false"
				    action="dashSpecialCondListAction_specialCondCifListGrid?_pageRef=${_pageRef}">
			   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
			</ps:url>
			<div>
			    <psjg:grid id="specialCondCifListGridTbl_Id_${_pageRef}" 
						caption="%{getText('specialConditions_key')}: %{getText('CIF_key')}"
				        altRows="true"
				    	dataType="json" 
						filter="true"
				    	gridModel="gridModel" 
				    	href="%{urlSpecialCondCIFGrid_${_pageRef}}"
				        navigator="true" 
				        navigatorAdd="false"
				        navigatorDelete="false"
				        navigatorEdit="false"
				        navigatorRefresh="false"
				        navigatorSearch="true" 
				        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
				    	pager="true"
				    	rowNum="5" 
				    	rowList="5,10,15,20"
				        shrinkToFit="false"
				        sortable="true"
				        viewrecords="true">
				    <psjg:gridColumn id="LINE_NO"    			index="LINE_NO"    			colType="number"	name="ctsSpCondVO.LINE_NO"			title="%{getText('Line_No._key')}"				editable="false" sortable="true" search="true" formatter="dashboard_specialCondCIFLineBtn"/>    	
					<psjg:gridColumn id="CIF_NO"    			index="CIF_NO"    			colType="number"	name="ctsSpCondVO.CIF_NO"			title="%{getText('CIF_No_key')}"				editable="false" sortable="true" search="true" />
					<psjg:gridColumn id="CIF_NAME"         		index="CIF_NAME"         	colType="text" 	 	name="cifVO.SHORT_NAME_ENG" 	    title="%{getText('CIF_Name_key')}"				editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="FORBID_RESTRICT_TRX"	index="FORBID_RESTRICT_TRX"	colType="text" 		name="ctsSpCondVO.FORBID_TRX"		title="%{getText('Forbid_Restrict_Trx_key')}"	editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="FORBID_PRODUCT"		index="FORBID_PRODUCT"     	colType="text" 		name="ctsSpCondVO.FORBID_PRODUCT"	title="%{getText('Forbid_Product_key')}"		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="REASON"				index="REASON"       		colType="text"		name="ctsSpCondVO.REASON_ENG"		title="%{getText('Reason_key')}"				editable="false" sortable="true" search="true"/>				
					<psjg:gridColumn id="STARTING_DATE"	 		index="STARTING_DATE"     	colType="date"		name="ctsSpCondVO.STARTING_DATE"	title="%{getText('starting_date_key')}"			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="EXPIRY_DATE"	     	index="EXPIRY_DATE"         colType="date"		name="ctsSpCondVO.EXPIRY_DATE"		title="%{getText('Expiry_Date_key')}"			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="ALLOW_SO"	     		index="ALLOW_SO"         	colType="checkbox" 	name="ctsSpCondVO.ALLOW_SO"			title="%{getText('Allow_Standing_Order_key')}" 	editable="false" sortable="true" align="center"
									 edittype="checkbox" 		formatter="checkbox" 		editoptions="{value:'1:0',dataEvents: [{ type: 'change', fn: function(e) {   } }]}" 					formatoptions="{disabled : true}"  width="75"/>
				</psjg:grid>
				<br/>
			</div>
			<ps:url id="urlSpecialCondAccGrid_${_pageRef}" 
			        namespace="/path/globalview" escapeAmp="false"
				    action="dashSpecialCondListAction_specialCondAccListGrid?_pageRef=${_pageRef}">
			   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
			</ps:url>
			<div>
				<psjg:grid id="specialCondAccListGridTbl_Id_${_pageRef}" 
						caption="%{getText('specialConditions_key')}: %{getText('Account_key')}"
				        altRows="true"
				    	dataType="json" 
						filter="true"
				    	gridModel="gridModel" 
				    	href="%{urlSpecialCondAccGrid_${_pageRef}}"
				        navigator="true" 
				        navigatorAdd="false"
				        navigatorDelete="false"
				        navigatorEdit="false"
				        navigatorRefresh="false"
				        navigatorSearch="true" 
				        navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt']}"
				    	pager="true"
				    	rowNum="5" 
				    	rowList="5,10,15,20"
				        shrinkToFit="false"
				        sortable="true"
				        viewrecords="true">	
				    <psjg:gridColumn id="LINE_NO"    			index="LINE_NO"    			 colType="number"	name="ctsSpCondVO.LINE_NO"			title="%{getText('Line_No._key')}"				editable="false" sortable="true" search="true" formatter="dashboard_specialCondAccLineBtn"/>
					<psjg:gridColumn id="ACC_BRANCH"    		index="ACC_BRANCH"			 colType="number"	name="ctsSpCondVO.ACC_BR"        	title="%{getText('Acc_Br_key')}"  				editable="false" sortable="true" search="true" />
					<psjg:gridColumn id="ACC_CURRENCY"         	index="ACC_CURRENCY"         colType="number" 	name="ctsSpCondVO.ACC_CY" 	    	title="%{getText('Acc_Cy_key')}"	   			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="ACC_GL"				index="ACC_GL" 				 colType="number"   name="ctsSpCondVO.ACC_GL"           title="%{getText('Acc_GL_key')}"     			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="ACC_CIF"				index="ACC_CIF"     		 colType="number" 	name="ctsSpCondVO.ACC_CIF"			title="%{getText('Acc_CIF_key')}"   			editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="ACC_SL"				index="ACC_SL"       		 colType="number"   name="ctsSpCondVO.ACC_SL"          	title="%{getText('Acc_SL_key')}"				editable="false" sortable="true" search="true"/>	
					<psjg:gridColumn id="ADDITIONAL_REFERENCE"  index="ADDITIONAL_REFERENCE" colType="text" 	name="amfVO.ADDITIONAL_REFERENCE" 	title="%{getText('Additional_Reference_key')}"  editable="false" sortable="true" search="true"/>			
					<psjg:gridColumn id="ACC_NAME"	 			index="ACC_NAME"     		 colType="text"	 	name="amfVO.BRIEF_NAME_ENG"			title="%{getText('Account_Name_key')}" 		   	editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="FORBID_RESTRICT_TRX"	index="FORBID_RESTRICT_TRX"	 colType="text"   	name="ctsSpCondVO.FORBID_TRX"		title="%{getText('Forbid_Restrict_Trx_key')}"   editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="FORBID_PRODUCT"		index="FORBID_PRODUCT"     	 colType="text" 	name="ctsSpCondVO.FORBID_PRODUCT"	title="%{getText('Forbid_Product_key')}"   		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="REASON"				index="REASON"       		 colType="text"   	name="ctsSpCondVO.REASON_ENG"       title="%{getText('Reason_key')}"  				editable="false" sortable="true" search="true"/>				
					<psjg:gridColumn id="STARTING_DATE"	 		index="STARTING_DATE"     	 colType="date"	 	name="ctsSpCondVO.STARTING_DATE"	title="%{getText('starting_date_key')}" 		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="EXPIRY_DATE"	     	index="EXPIRY_DATE"          colType="date" 	name="ctsSpCondVO.EXPIRY_DATE"		title="%{getText('Expiry_Date_key')}" 	   		editable="false" sortable="true" search="true"/>
					<psjg:gridColumn id="ALLOW_SO"	     		index="ALLOW_SO"         	 colType="checkbox" name="ctsSpCondVO.ALLOW_SO"			title="%{getText('Allow_Standing_Order_key')}" 	editable="false" sortable="true" align="center"
									 edittype="checkbox" 		formatter="checkbox" 		 editoptions="{value:'1:0',dataEvents: [{ type: 'change', fn: function(e) {   } }]}" 					formatoptions="{disabled : true}"  width="75"/>
				</psjg:grid>
			</div>
	</body>	
	 <script type="text/javascript">
		var specialCondKey = "<ps:text name='specialConditions_key'/>";
 	</script>