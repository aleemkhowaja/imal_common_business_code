<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<div id="childcif_div_grid" style ="width:465px">

<ps:url id="urlChildCifGrid_${_pageRef}" 
        namespace="/path/globalview" escapeAmp="false"
	    action="dashChildCifListAction_loadChildCifGridData?_pageRef=${_pageRef}">
   	 <ps:param name="cif_no"        value="cif_no"></ps:param>
</ps:url>

    <psjg:grid
    	id="childcifGridTbl_Id" loadonce="true"
  	    href="%{urlChildCifGrid_${_pageRef}}" 
        dataType="json"
        pager="true"
        sortable="true"
		filter="true"
    	gridModel="gridModel" 
        viewrecords="true" 
        altRows="true"
        height="180"
        navigatorRefresh="false" 
        navigatorSearch="false" 
        shrinkToFit="true">
		<psjg:gridColumn id="cifVO.CIF_NO"    colType="text" name="cifVO.CIF_NO"    index="cifVO.CIF_NO"    title="%{getText('CIF_No_key')}"    editable="false" sortable="true" search="true" searchoptions="{sopt:['cn']}"/>
		<psjg:gridColumn id="cifVO.SHORT_NAME_ENG"  colType="text" name="cifVO.SHORT_NAME_ENG" index="cifVO.SHORT_NAME_ENG" title="%{getText('Short_name_eng_key')}" editable="false" sortable="true" search="true" searchoptions="{sopt:['cn']}"/>
	</psjg:grid>
</div>	
