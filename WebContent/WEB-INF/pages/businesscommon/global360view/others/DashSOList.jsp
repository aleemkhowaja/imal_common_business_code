<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

    <ps:set name="cifNo_${_pageRef}" value="cif_no"/>
    
    <table cellpadding="0" cellspacing="0" width="100%" border="0">
		<tr>
			<td class="fldLabelView" width="5%">
				<ps:label key="nbrOfTemplateSO_key" id="lbl_nbrOfTemplateSO_${_pageRef}" for="nbrOfTemplateSO_${_pageRef}" />	
			</td>
			<td class="fldLabelView" width="10%">
				<ps:textfield mode="number" id="nbrOfTemplateSO_${_pageRef}" name="dashOthersCO.nbrOfTemplateSO" readonly="true"/>						
			</td>
			<td class="fldLabelView" width="5%">
				<ps:label key="nbrOfProcessedSO_key" id="lbl_nbrOfProcessedSO_${_pageRef}" for="nbrOfProcessedSO_${_pageRef}" />	
			</td>
			<td class="fldLabelView" width="10%">
				<ps:textfield mode="number" id="nbrOfProcessedSO_${_pageRef}" name="dashOthersCO.nbrOfProcessedSO" readonly="true"/>						
			</td>			
			<td class="fldLabelView" width="70%">
			</td>
		</tr>
	</table>
			
   	<ps:url id="urlSOLinksGrid_${_pageRef}"
   			namespace="/path/globalview" escapeAmp="false"
			action="dashSOListAction?_pageRef=${_pageRef}">
			<ps:param name="cif_no" value="cifNo_${_pageRef}"></ps:param>
	</ps:url>
	<psjg:grid id="soListGridTbl_Id_${_pageRef}" 
				caption="%{getText('standingOrders_key')}"
		        altRows="true"
		    	dataType="json" 
				filter="true"
		    	gridModel="gridModel" 
		    	href="%{urlSOLinksGrid_${_pageRef}}"
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
		    <psjg:gridColumn id="decimal_points"            index="decimal_points"          colType="number"    name="decimal_points"   title=" "  hidden="true"/>
		    <psjg:gridColumn id="COMP_CODE"		    	    index="COMP_CODE"				colType="number"	name="ctstrsVO.COMP_CODE"			title="Hidden compCode"			                editable="false" sortable="true" search="true" hidden = "true"/>
		    <psjg:gridColumn id="TRS_TYPE"		    	    index="TRS_TYPE"				colType="text"		name="ctstrsVO.TRS_TYPE"			title="Hidden TRS_TYPE"			                editable="false" sortable="true" search="true" hidden = "true"/>
		    <psjg:gridColumn id="CB_IND"		    		index="CB_IND"				    colType="text"		name="ctstrsVO.CB_IND"			    title="Hidden CB_IND"							editable="false" sortable="true" search="true" hidden = "true"/>
			<psjg:gridColumn id="BRANCH_CODE"		    	index="BRANCH_CODE"				colType="number"	name="ctstrsVO.BRANCH_CODE"			title="%{getText('Branch_code_key')}"			editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="TRS_NO"					index="TRS_NO"					colType="number" 	name="ctstrsVO.TRS_NO"				title="%{getText('trs_no_key')}"				editable="false" sortable="true" search="true"  formatter="dashboard_SOTrxBtn"/>
			<psjg:gridColumn id="TRX_TYPE"					index="TRX_TYPE"				colType="number"	name="ctstrsVO.TRX_TYPE"			title="%{getText('Trx_Type_key')}"				editable="false" sortable="true" search="true" />
			<psjg:gridColumn id="SHORT_DESC_ENG"			index="SHORT_DESC_ENG"			colType="text"		name="ctstrxTypeVO.SHORT_DESC_ENG"	title="%{getText('shortDescEng_key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_BR"					index="TRS_AC_BR"				colType="number"	name="ctstrsVO.TRS_AC_BR"			title="%{getText('Acc_Br_key')}"				editable="false" sortable="true" search="true"/>				
			<psjg:gridColumn id="TRS_AC_CY"					index="TRS_AC_CY"				colType="number"	name="ctstrsVO.TRS_AC_CY"			title="%{getText('Acc_Cy_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_GL"					index="TRS_AC_GL"				colType="number"	name="ctstrsVO.TRS_AC_GL"			title="%{getText('Acc_GL_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_CIF"				index="TRS_AC_CIF"				colType="number"	name="ctstrsVO.TRS_AC_CIF"			title="%{getText('Acc_CIF_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TRS_AC_SL"					index="TRS_AC_SL"				colType="number"	name="ctstrsVO.TRS_AC_SL"			title="%{getText('Acc_SL_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="BRIEF_NAME_ENG"			index="BRIEF_NAME_ENG"			colType="text"		name="amfVO.BRIEF_NAME_ENG"			title="%{getText('Brief_Name_eng_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="ADDITIONAL_REFERENCE"		index="ADDITIONAL_REFERENCE"	colType="text"		name="amfVO.ADDITIONAL_REFERENCE"	title="%{getText('AdditionalReference_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_BR"				index="TO_TRS_AC_BR"			colType="number"	name="ctstrsVO.TO_TRS_AC_BR"		title="%{getText('Acc_Br_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_CY"				index="TO_TRS_AC_CY"			colType="number"	name="ctstrsVO.TO_TRS_AC_CY"		title="%{getText('Acc_Cy_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_GL"				index="TO_TRS_AC_GL"			colType="number"	name="ctstrsVO.TO_TRS_AC_GL"		title="%{getText('Acc_GL_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_CIF"				index="TO_TRS_AC_CIF"			colType="number"	name="ctstrsVO.TO_TRS_AC_CIF"		title="%{getText('Acc_CIF_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_TRS_AC_SL"				index="TO_TRS_AC_SL"			colType="number"	name="ctstrsVO.TO_TRS_AC_SL"		title="%{getText('Acc_SL_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_BRIEF_NAME_ENG"			index="TO_BRIEF_NAME_ENG"		colType="text"		name="BRIEF_NAME_ENG"				title="%{getText('Brief_Name_eng_key')}"		editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="TO_ADDITIONAL_REFERENCE"	index="TO_ADDITIONAL_REFERENCE"	colType="text"		name="amfVO1.ADDITIONAL_REFERENCE"	title="%{getText('AdditionalReference_key')}"	editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="AMOUNT"					index="AMOUNT"					colType="number"	name="ctstrsVO.AMOUNT"				title="%{getText('Amount_key')}"				editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR" formatCol="decimal_points"/>
			<psjg:gridColumn id="SO_PROCESS_TYPE"			index="SO_PROCESS_TYPE"			colType="text"		name="ctstrxTypeVO.SO_PROCESS_TYPE"	title="%{getText('Process_key')}"				editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="SO_PERIODICITY"			index="SO_PERIODICITY"			colType="text"		name="ctstrsVO.SO_PERIODICITY"		title="%{getText('Periodicity__key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="startDate"				    index="startDate"				colType="date"	    name="startDate"			        title="%{getText('Start_date_key')}"			editable="false" sortable="true" search="true"/>
			<psjg:gridColumn id="endDate"					index="endDate"				    colType="date"	    name="endDate"			            title="%{getText('end_date_key')}"				editable="false" sortable="true" search="true"/>
	</psjg:grid>
			
 <script type="text/javascript">
  //Setting multi header columns
 var from_acc_Key = "<ps:text name='from_Acc'/>";
 var to_acc_Key = "<ps:text name='to_Acc'/>";
 var standingOrdersKey = "<ps:text name='standingOrders_key'/>";
 $(document).ready(function(){formatSOGrid(from_acc_Key, to_acc_Key)});
 </script>