<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>
<div style ="width:465px">
    <psjg:grid
    	id="trxTypeGridTbl_Id_${_pageRef}" caption=" "
  	    href="%{trxTypeGridUrl}" dataType="json" 
  	    sortable="true" filter="true"
    	gridModel="gridModel" rowList="5,10,15,20" rowNum="5"
    	pager="true" viewrecords="true" 
        altRows="true" ondblclick="dblClickEvent()"
        navigatorRefresh="false" 
        navigatorSearch="false"
        shrinkToFit="false" >
		<psjg:gridColumn id="CODE" colType="number" name="CODE" index="CODE" title="%{getText('Code_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="SHORT_DESC_ENG"  colType="text" name="SHORT_DESC_ENG" index="SHORT_DESC_ENG" title="%{getText('Brief_Desc_Eng_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="LONG_DESC_ENG"  colType="text" name="LONG_DESC_ENG" index="LONG_DESC_ENG" title="%{getText('Long_Desc_Eng_key')}" editable="false" sortable="true" search="true"/>
		<psjg:gridColumn id="SHORT_DESC_ARAB"  colType="text" name="SHORT_DESC_ARAB" index="SHORT_DESC_ARAB" title="%{getText('Brief_Desc_Arab_key')}" editable="false" sortable="true" search="true" hidden="session.sesVO.hideArabicColumns" />
		<psjg:gridColumn id="LONG_DESC_ARAB"  colType="text" name="LONG_DESC_ARAB" index="LONG_DESC_ARAB" title="%{getText('Long_Desc_Arab_key')}" editable="false" sortable="true" search="true" hidden="session.sesVO.hideArabicColumns" />
		<psjg:gridColumn id="REFERENCE"  colType="text" name="REFERENCE" index="REFERENCE" title="%{getText('_Reference_key')}" editable="false" sortable="true" search="true"/>
	</psjg:grid>
</div>	
	<script type="text/javascript">
	    function dblClickEvent()
		{
			// Batch Processing from reverse screen
			if(_pageRef == 'BP001RV')
			{
				reverseCreateBatchAfterSelectingTrxType();
			}
			
		}
		$("#gview_trxTypeGridTbl_Id_" + _pageRef + " div.ui-jqgrid-titlebar").hide();
	</script>	
