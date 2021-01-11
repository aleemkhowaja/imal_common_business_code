<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlSafeBoxesGrid_${_pageRef}" 
        namespace="/path/globalview" escapeAmp="false"
	    action="safeboxesListAction?_pageRef=${_pageRef}">
   <ps:param name="cif_no"        value="criteria.cif_no"></ps:param>
   <ps:param name="loginTypeByBr" value="criteria.loginTypeByBr"></ps:param>
</ps:url>
  <psjg:grid id="safeBoxexListGridTbl_Id_${_pageRef}" 
		caption="%{getText('safe_boxes_key')}"
        altRows="true"
    	dataType="json" 
		filter="true"
    	gridModel="gridModel" 
    	href="%{urlSafeBoxesGrid_${_pageRef}}"
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
		<psjg:gridColumn id="statusTrx_${_pageRef}"  index="statusTrx" colType="text" name="statusTrx" title="statusTrx"      editable="false" sortable="true" search="true" hidden="true"/>
		<psjg:gridColumn id="ctsSafeboxVO.STATUS_${_pageRef}"  index="ctsSafeboxVO.STATUS" colType="text" name="ctsSafeboxVO.STATUS" title="ctsSafeboxVO.STATUS"      editable="false" sortable="true" search="true" hidden="true"/>
		<psjg:gridColumn id="ctsParamVO.PARAM_TYPE_${_pageRef}"  index="ctsParamVO.PARAM_TYPE" colType="text" name="ctsParamVO.PARAM_TYPE" title="ctsParamVO.PARAM_TYPE"      editable="false" sortable="true" search="true" hidden="true"/>
		<psjg:gridColumn id="branch_code_${_pageRef}"  index="branch_code" colType="number" name="branch_code" title="%{getText('Branch_code_key')}"      editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="trx_no_${_pageRef}"       index="trx_no"      colType="number" name="trx_no" 	   title="%{getText('Trx_No_key')}"	          editable="false" sortable="true" search="true"  formatter="dashboard_safeBoxTrxBtn"/>
		<psjg:gridColumn id="type_${_pageRef}"         index="type"        colType="text"   name="type"        title="%{getText('Safebox_Type_key')}"     editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="safebox_no_${_pageRef}"   index="safebox_no"  colType="number" name="safebox_no"  title="%{getText('Safebox_No_key')}"       editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="location_${_pageRef}"     index="location"    colType="text"   name="location"    title="%{getText('Safebox_Location_key')}" editable="false" sortable="true" search="true"/>				
		<psjg:gridColumn id="statusdesc_${_pageRef}"   index="statusdesc"  colType="text"	name="statusdesc"  title="%{getText('STATUS_key')}"   editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_br_${_pageRef}"	   index="acc_br"      colType="number" name="acc_br"	   title="%{getText('Acc_Branch_key')}" 	  editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_cy_${_pageRef}"	   index="acc_cy"      colType="number" name="acc_cy"	   title="%{getText('Acc_Currency_key')}" 	  editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_gl_${_pageRef}"	   index="acc_gl"      colType="number" name="acc_gl"	   title="%{getText('Acc_GL_key')}" 	      editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_cif_${_pageRef}"	   index="acc_cif"     colType="number" name="acc_cif"	   title="%{getText('A_C_CIF_key')}" 	      editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_sl_${_pageRef}"	   index="acc_sl"      colType="number" name="acc_sl"	   title="%{getText('A_C_SL_key')}" 	      editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="acc_add_ref_${_pageRef}"  index="acc_add_ref" colType="number" name="acc_add_ref" title="%{getText('Additional_Reference_key')}" 	           editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="accountName_${_pageRef}"  index="accountName" colType="text"	name="accountName" title="%{getText('Account_Name_key')}"     editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="dateFrom_${_pageRef}"     index="dateFrom"    colType="date"	name="dateFrom"    title="%{getText('From_date_key')}"        editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="dateTo_${_pageRef}"       index="dateTo"      colType="date"	name="dateTo"      title="%{getText('To_Date_key')}"          editable="false" sortable="true" search="true"/>
 </psjg:grid>
 <script type="text/javascript">

  //Setting multi header columns
 var accountKey  = "<ps:text name='Accounts_key'/>";
 var safeBoxesKey = "<ps:text name='safe_boxes_key'/>";
 
 $("#safeBoxexListGridTbl_Id_"+_pageRef).jqGrid('setGroupHeaders', {
	  useColSpanStyle: true, 
	  groupHeaders:[
		{startColumnName: 'acc_br', numberOfColumns: 6, titleText: accountKey}]
	});								
 </script>