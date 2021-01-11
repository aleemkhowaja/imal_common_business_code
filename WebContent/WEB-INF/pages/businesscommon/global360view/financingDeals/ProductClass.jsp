<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:url id="urlProductClass" action="financingDealsListAction_loadProductClassData" namespace="/path/globalview" escapeAmp="false">
	 <ps:param name="iv_crud"      			 value="iv_crud"></ps:param>
	 <ps:param name="_pageRef"      		 value="_pageRef"></ps:param>
	 <ps:param name="financingDealsSC.cifNo" value="financingDealsSC.cifNo"></ps:param>
	  <ps:param name="financingDealsSC.dealType" value="financingDealsSC.dealType"></ps:param>
 </ps:url>
 <psjg:grid
    	id				="productClassGridTbl_Id_${_pageRef}" 
  	    href            ="%{urlProductClass}"
        dataType        ="json"
        hiddengrid      ="false"
    	pager           ="false"
    	sortable        ="false"
		filter          ="false"
    	gridModel       ="gridModel"    	 
		viewrecords     ="true" 
		navigator       ="false"
		altRows         ="true"
		navigatorRefresh="false" 
		navigatorAdd    ="false"
		navigatorDelete ="false"
		navigatorEdit   ="false"
		pagerButtons    ="false" 
		navigatorSearch ="false"
        shrinkToFit     ="true"
        title="Product Class"
        >	 			         
       <psjg:gridColumn id="code"	         index="trsClassVO.CODE"             name="trsClassVO.CODE"            title="%{getText('Code_key')}"         colType="number" editable="false" sortable="false" search="false" formatter="showlink"  formatoptions="{baseLinkUrl: 'javascript:',showAction:'dashboard_productClassClicked(\"',addParam:'\");'}"/>
       <psjg:gridColumn id="briefNameEng"    index="trsClassVO.BRIEF_NAME_ENG"   name="trsClassVO.BRIEF_NAME_ENG"  title="%{getText('Brief_Name_Eng_key')}"      colType="text" editable="false" sortable="false" search="false" />
       <psjg:gridColumn id="longNameEng"     index="trsClassVO.LONG_NAME_ENG"    name="trsClassVO.LONG_NAME_ENG"   title="%{getText('Long_Name_Eng_key')}"          colType="text" editable="false" sortable="false" search="false" />
       <psjg:gridColumn id="briefNameArab"   index="trsClassVO.BRIEF_NAME_ARAB"  name="trsClassVO.BRIEF_NAME_ARAB" title="%{getText('Brief_name_arb_key')}"      colType="text" editable="false" sortable="false" search="false" />
       <psjg:gridColumn id="longNameArab"	 index="trsClassVO.LONG_NAME_ARAB"   name="trsClassVO.LONG_NAME_ARAB"  title="%{getText('Long_Name_Arab_key')}"     colType="text" editable="false" sortable="false" search="false" />
       <psjg:gridColumn id="amount"	     	 index="amount"                      name="amount"                     title="%{getText('Amount_key')}"          colType="number" editable="false" sortable="false" search="false" />     
       
      
 </psjg:grid>
 
 