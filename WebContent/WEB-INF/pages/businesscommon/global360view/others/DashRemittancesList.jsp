<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:set name="cifNo_${_pageRef}" value="cif_no"/>
<body>
		<ps:url id="urlRemittancesGrid_${_pageRef}" 
		        namespace="/path/globalview" escapeAmp="false"
			    action="dashRemittancesListAction?_pageRef=${_pageRef}">
		   <ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
		</ps:url>
	    <psjg:grid id="remittancesListGridTbl_Id_${_pageRef}" 
				caption="%{getText('remittances_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel"  
		    	href="%{urlRemittancesGrid_${_pageRef}}"
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
		    <psjg:gridColumn id="decimal_points"            index="decimal_points"              colType="number" name="decimal_points" title=" " hidden="true"/>
		    <psjg:gridColumn id="COMP_CODE"		    	    index="COMP_CODE"					colType="number" name="ctstrsVO.COMP_CODE"					title="Hidden compCode"			                editable="false" sortable="true" search="true" hidden = "true"/>
		    <psjg:gridColumn id="trsType"		    	    index="trsType"					    colType="text"	 name="trsType"					            title="Hidden TRS_TYPE"			                editable="false" sortable="true" search="true" hidden = "true"/>
		    <psjg:gridColumn id="CB_IND"		    		index="CB_IND"				    	colType="text"	 name="ctstrsVO.CB_IND"			   			title="Hidden CB_IND"							editable="false" sortable="true" search="true" hidden = "true"/>
			<psjg:gridColumn id="BRANCH_CODE"				index="BRANCH_CODE"					colType="number" name="ctstrsVO.BRANCH_CODE"				title="%{getText('Branch_code_key')}"			editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="TRS_NO"					index="TRS_NO"						colType="number" name="ctstrsVO.TRS_NO"						title="%{getText('trs_no_key')}"				editable="false" sortable="true" search="true" formatter="dashboard_remittancesTrxBtn"/>
			<psjg:gridColumn id="TRX_TYPE"					index="TRX_TYPE"					colType="number" name="ctstrsVO.TRX_TYPE"					title="%{getText('Trx_Type_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="SHORT_DESC_ENG"			index="SHORT_DESC_ENG"				colType="text"	 name="ctstrxTypeVO.SHORT_DESC_ENG"			title="%{getText('shortDescEng_key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_BR"					index="TRS_AC_BR"					colType="number" name="ctstrsVO.TRS_AC_BR"					title="%{getText('Acc_Br_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_CY"					index="TRS_AC_CY"					colType="number" name="ctstrsVO.TRS_AC_CY"					title="%{getText('Acc_Cy_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_GL"					index="TRS_AC_GL"					colType="number" name="ctstrsVO.TRS_AC_GL"					title="%{getText('Acc_GL_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_CIF"				index="TRS_AC_CIF"					colType="number" name="ctstrsVO.TRS_AC_CIF"					title="%{getText('Acc_CIF_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_SL"					index="TRS_AC_SL"					colType="number" name="ctstrsVO.TRS_AC_SL"					title="%{getText('Acc_SL_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ACC_ADDITIONAL_REFERENCE"	index="ACC_ADDITIONAL_REFERENCE"	colType="text"   name="ctstrsVO.ACC_ADDITIONAL_REFERENCE"	title="%{getText('AdditionalReference_key')}" 	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LONG_NAME_ENG"				index="LONG_NAME_ENG"				colType="text"	 name="amfVO.LONG_NAME_ENG"					title="%{getText('Long_Name__key')}" 			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_BR"				index="TO_TRS_AC_BR"				colType="number" name="ctstrsVO.TO_TRS_AC_BR"				title="%{getText('Acc_Br_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_CY"				index="TO_TRS_AC_CY"				colType="number" name="ctstrsVO.TO_TRS_AC_CY"				title="%{getText('Acc_Cy_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_GL"				index="TO_TRS_AC_GL"				colType="number" name="ctstrsVO.TO_TRS_AC_GL"				title="%{getText('Acc_GL_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_CIF"				index="TO_TRS_AC_CIF"				colType="number" name="ctstrsVO.TO_TRS_AC_CIF"				title="%{getText('Acc_CIF_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_SL"				index="TO_TRS_AC_SL"				colType="number" name="ctstrsVO.TO_TRS_AC_SL"				title="%{getText('Acc_SL_key')}" 				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_ACC_ADD_REF"			index="TO_ACC_ADD_REF"				colType="text"   name="ctstrsVO.TO_ACC_ADD_REF"				title="%{getText('AdditionalReference_key')}" 	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="LONG_NAME_ENG"				index="LONG_NAME_ENG"				colType="text"   name="amfVO1.LONG_NAME_ENG"				title="%{getText('Long_Name__key')}" 			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="AMOUNT"					index="AMOUNT"						colType="number" name="ctstrsVO.AMOUNT"						title="%{getText('Amount_key')}" 				editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			<psjg:gridColumn id="TRS_DATE"					index="TRS_DATE" 					colType="date"	 name="ctstrsVO.TRS_DATE"					title="%{getText('trs_date_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="REMITTANCE_STATUS"			index="REMITTANCE_STATUS" 			colType="text"	 name="remittanceStatus"					title="%{getText('Remittance_Status_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="REMITT_TYPE"				index="REMITT_TYPE" 				colType="text" 	 name="remittanceType"						title="%{getText('Remittance_Type_key')}"		editable="false" sortable="true" search="true"/>
		</psjg:grid>
</body>	

 <script type="text/javascript">
  //Setting multi header columns
 var from_acc_Key = "<ps:text name='from_Acc'/>";
 var to_acc_Key = "<ps:text name='to_Acc'/>";
 var remittancesKey = "<ps:text name='remittances_key'/>";
 
 $(document).ready(function(){formatRemittancesGrid(from_acc_Key, to_acc_Key)});
 </script>