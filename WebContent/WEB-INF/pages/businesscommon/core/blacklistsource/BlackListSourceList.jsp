<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:hidden id="iv_crud_${_pageRef}" name="iv_crud" />
<ps:hidden id="dualParam_${_pageRef}"
		name="blackListSourceCO.dualParam" />
<jsp:include page="/WEB-INF/pages/common/login/InfoBar.jsp" />

<ps:url id="urlblackListSourceListGrid" escapeAmp="false"
	action="BlackListSourceListAction_loadData"
	namespace="/path/blackListSource">
	<ps:param name="iv_crud" value="ivcrud_${_pageRef}"></ps:param>
	<ps:param name="_pageRef" value="_pageRef"></ps:param>
</ps:url>

<psjg:grid id="blackListSourceListGridTbl_Id_${_pageRef}" caption=" "
	href="%{urlblackListSourceListGrid}" dataType="json"
	hiddengrid='%{iv_crud== "R"}' pager="true" sortable="true"
	filter="true" gridModel="gridModel" rowNum="5" rowList="5,10,15,20"
	viewrecords="true" navigator="true" navigatorDelete="false"
	navigatorEdit="false" navigatorRefresh="false" navigatorAdd="false"
	navigatorSearch="true"
	navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
	altRows="true" ondblclick="blackListSourceList_onDbClickedEvent()"
	addfunc="blackListSourceList_onAddClicked" shrinkToFit="false"
	height="125">
	<psjg:gridColumn id="CODE" colType="number" name="blackSourceVO.CODE"
		index="CODE" title="%{getText('CODE_key')}" editable="false"
		sortable="true" search="true" />

	<psjg:gridColumn id="CIF_NO" colType="number"
		name="blackSourceVO.CIF_NO" index="CIF_NO"
		title="%{getText('cifno_key')}" editable="false" sortable="true"
		search="true" />

	<psjg:gridColumn id="BRIEF_NAME_ENG" colType="text"
		name="blackSourceVO.BRIEF_DESC_ENG" index="BRIEF_DESC_ENG"
		title="%{getText('brief_name_english_key')}" editable="false"
		sortable="true" search="true" />

	<psjg:gridColumn id="LONG_ENG_DESC" colType="text"
		name="blackSourceVO.LONG_DESC_ENG" index="LONG_DESC_ENG"
		title="%{getText('Long_Name_eng_key')}" editable="false"
		sortable="true" search="true" />

	<psjg:gridColumn id="BRIEF_NAME_ARAB" colType="text"
		name="blackSourceVO.BRIEF_DESC_ARAB" index="BRIEF_DESC_ARAB"
		title="%{getText('brief_name_ar_key')}" editable="false"
		sortable="true" search="true" />

	<psjg:gridColumn id="LONG_DESC_ARAB" colType="text"
		name="blackSourceVO.LONG_DESC_ARAB" index="LONG_DESC_ARAB"
		title="%{getText('Long_Description_arab_key')}" editable="false"
		sortable="true" search="true" />
	<ps:if test='blackListSourceCO.dualParam==1'>
	<psjg:gridColumn id="STATUS" name="statusDesc" index="STATUS_DESC"
		colType="text" title="%{getText('STATUS_key')}" editable="false"
		sortable="true" search="true" hidden="false" />
	</ps:if>
		
	


</psjg:grid>
<div id="blackListSourceListMaintDiv_id_${_pageRef}"
	style="width: 100%;">
	<ps:if test='iv_crud == "R"'>
		<%@include file="BlackListSourceMaint.jsp"%>
	</ps:if>
</div>
<script type="text/javascript">
	$.struts2_jquery.require("BlackListSourceMaint.js", null, jQuery.contextPath + "/businesscommon/js/core/blacklistsource/");
	$("#gview_blackListSourceListGridTbl_Id_" + _pageRef + " div.ui-jqgrid-titlebar").hide();
</script>