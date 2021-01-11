<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
 <ps:url id="urlDashAccDtlJvsGrid_${_pageRef}" action="dashAccDtlJvsListAction" escapeAmp="false" namespace="/path/globalview">
	 <ps:param name="iv_crud"      value="iv_crud"></ps:param>
	 <ps:param name="_pageRef"     value="_pageRef"></ps:param>
	 <ps:param name="cif_no"       value="criteria.cif_no"></ps:param>
	 <ps:param name="accNum"       value="criteria.accNum"></ps:param>
	 <ps:param name="compCode"     value="dashAccountDetailsCO.compCode"></ps:param>
	 <ps:param name="branchCode"   value="dashAccountDetailsCO.branchCode"></ps:param>
	 <ps:param name="currencyCode" value="dashAccountDetailsCO.currencyCode"></ps:param>
	 <ps:param name="glCode"       value="dashAccountDetailsCO.glCode"></ps:param>
	 <ps:param name="slNo"         value="dashAccountDetailsCO.slNo"></ps:param>
 </ps:url>
 <table width="100%">
    <tr>
     
    </tr>
    <tr>
    <td colspan="5">
          <div>
			 <psjg:grid
			    	id              ="dashAccDtlJvsGridTbl_Id_${_pageRef}" 
			  	    href            ="%{urlDashAccDtlJvsGrid_${_pageRef}}"
			        dataType        ="json"
			        caption         ="%{getText('jvs_list_key')}"
			        hiddengrid      ="false"
			    	pager           ="true"
			    	filter          ="true"
			    	sortable        ="false"
			    	gridModel       ="gridModel"
			    	rowNum          ="5"
					rowList         ="5,10,15,20"
					viewrecords     ="true" 
					navigator       ="true"
					altRows         ="true"
					navigatorRefresh="false" 
					navigatorAdd    ="false"
					navigatorDelete ="false"
					navigatorEdit   ="false"
					navigatorSearch ="false"
			        shrinkToFit     ="false"
			        ondblclick="dashAccDtlJVs_onDbClickedEvent()">			         	 			         
					   <psjg:gridColumn hidden="true" id="amount_FORMAT" index="amount_FORMAT"  name="amount_FORMAT" title=" "  colType="number"/>
					   <psjg:gridColumn id="compCode" 	 index="compCode"	 name="compCode" 	title="hidden col"                    colType="number"   editable="false" sortable="false" search="false"  hidden="true"/>
					   <psjg:gridColumn id="branchCode"  index="branchCode"	 name="branchCode" 	title="hidden col"                    colType="number"   editable="false" sortable="false" search="false"  hidden="true"/>
					   <psjg:gridColumn id="op_no"       index="op_no"       name="op_no"	    title="%{getText('jvOpNo_key')}"      colType="text"   editable="false" sortable="true" search="true"/>
					   <psjg:gridColumn id="srlNo" 		 index="srlNo"		 name="srlNo" 		title="hidden col"                    colType="text"   editable="false" sortable="false" search="false"  hidden="true"/>
					   <psjg:gridColumn id="jv_type"     index="jv_type"     name="jv_type"     title="%{getText('type_key')}"        colType="text"   editable="false" sortable="true" search="true"/>
					   <psjg:gridColumn id="jv_ref"      index="jv_ref"      name="jv_ref"      title="%{getText('JV_Ref_key')}"      colType="text"   editable="false" sortable="true" search="true"/>
					   <psjg:gridColumn id="op_status"   index="op_status"   name="op_status"   title="%{getText('status_key')}"      colType="text"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="value_date"	 index="value_date"  name="value_date"  title="%{getText('valueDate_key')}"   colType="date"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="trx_date"    index="trx_date"    name="trx_date"    title="%{getText('trs_date_key')}"    colType="date"   editable="false" sortable="true" search="true"/>
				       <psjg:gridColumn id="amount"	     index="amount"      name="amount"      title="%{getText('Amount_key')}"      colType="number" editable="false" sortable="true" search="true" formatter="currencyFmatterDRCR"/>
				       <psjg:gridColumn id="description" index="description" name="description" title="%{getText('Description_key')}" colType="text"   editable="false" sortable="true" search="true"/>
			  </psjg:grid>
          </div>
    </td>
    </tr>
 </table>
 <script type="text/javascript">
	 var jvDetslKey = "<ps:text name='JV_details_key'/>";
 </script>