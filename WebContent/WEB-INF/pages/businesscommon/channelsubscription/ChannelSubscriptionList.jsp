<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>

<ps:form useHiddenProps="true" id="channelSubscriptionFormId_${_pageRef}"  namespace="/path/channelSubscription">

<ps:url id="urlchannelSubscriptionListGrid" escapeAmp="false" action="ChannelSubscriptionListAction_loadChannelSubscriptionGrid" namespace="/path/channelSubscription">
   <ps:param name="iv_crud"  value="ivcrud_${_pageRef}"></ps:param>
   <ps:param name="_pageRef" value="_pageRef"></ps:param>
   <ps:param name="channelSubscriptionSC.cifNo" value="channelSubscriptionSC.cifNo"></ps:param>
</ps:url>
<ps:hidden id="additionalReferenceHdn_${_pageRef}" name="additionalReferenceHdn"/>
<ps:hidden id="channelSubscriptionStr_${_pageRef}" name="channelSubscriptionStr"/>
<psjg:grid
	id               ="channelSubscriptionListGridTbl_Id_${_pageRef}"
	caption          =" "
    href             ="%{urlchannelSubscriptionListGrid}"
    dataType         ="json"
   	hiddengrid="false" 
	pager            ="true"
	sortable         ="true"
	filter           ="true"
	gridModel        ="gridModel"
	rowNum           ="5"
	rowList          ="5,10,15,20"
    viewrecords      ="true"
    navigator        ="true"
    navigatorDelete  ="false"
    navigatorEdit    ="false"
    navigatorRefresh ="false"
    navigatorAdd     ="false"
    editurl="#" editinline="true"
    navigatorSearch  ="true"
    navigatorSearchOptions="{closeOnEscape: true,closeAfterSearch: true, multipleSearch: true,sopt:['eq','ne','lt','gt','le','ge']}"
    altRows          ="true"
    shrinkToFit      ="false" height="125">
     
    <psjg:gridColumn id="IS_REGISTRED_YN"   colType="checkbox"  name="cifChannelRegistrationVO.IS_REGISTRED_YN" index="IS_REGISTRED_YN" title="%{getText('is_registered_yn_key')}" editable="false" sortable="true"    formatter="checkbox" search="false" />
    <psjg:gridColumn id="CIF_NO" colType="text" name="cifChannelRegistrationVO.CIF_NO" index="CIF_NO" title="%{getText('CIF_no_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="CHANNEL_DESC" colType="text" name="channelDesc" index="CHANNEL_DESC" title="%{getText('channel_Key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="ACC_BR" colType="text" name="cifChannelRegistrationVO.ACC_BR" index="ACC_BR" title="%{getText('Branch_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="ACC_CY" colType="text" name="cifChannelRegistrationVO.ACC_CY" index="ACC_CY" title="%{getText('CY_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="ACC_GL" colType="text" name="cifChannelRegistrationVO.ACC_GL" index="ACC_GL" title="%{getText('G_L_Code_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="ACC_CIF" colType="text" name="cifChannelRegistrationVO.ACC_CIF" index="ACC_CIF" title="%{getText('CIF_SUB_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="ACC_SL" colType="text" name="cifChannelRegistrationVO.ACC_SL" index="ACC_SL" title="%{getText('S_L_No_key')}" editable="false" sortable="true" search="true" />
    <psjg:gridColumn id="additionalReference" colType="liveSearch" name="additionalReference" index="additionalReference"
			   title="%{getText('Additional_Reference_key')}" editable="true" sortable="false"
			   search="false" width="230" align="center" mode="number"
			   paramList="cifCode:cifChannelRegistrationVO.CIF_NO"
			   dataAction="${pageContext.request.contextPath}/pathdesktop/AccountLookup_constructAccountLookup"
			   searchElement=""
			   resultList="amfVO.BRANCH_CODE:cifChannelRegistrationVO.ACC_BR,amfVO.CURRENCY_CODE:cifChannelRegistrationVO.ACC_CY,amfVO.GL_CODE:cifChannelRegistrationVO.ACC_GL,amfVO.CIF_SUB_NO:cifChannelRegistrationVO.ACC_CIF,amfVO.SL_NO:cifChannelRegistrationVO.ACC_SL,amfVO.ADDITIONAL_REFERENCE:additionalReference_lookuptxt"
			   params="account.CIF_SUB_NO:cifChannelRegistrationVO.CIF_NO,account.ADDITIONAL_REFERENCE:additionalReference_lookuptxt"
			   dependencySrc="${pageContext.request.contextPath}/pathdesktop/AccountDependencyAction_dependencyByACRef?displayMsg=1" 
			   dependency="account.BRANCH_CODE:cifChannelRegistrationVO.ACC_BR,account.CURRENCY_CODE:cifChannelRegistrationVO.ACC_CY,account.GL_CODE:cifChannelRegistrationVO.ACC_GL,account.CIF_SUB_NO:cifChannelRegistrationVO.ACC_CIF,account.SL_NO:cifChannelRegistrationVO.ACC_SL,account.ADDITIONAL_REFERENCE:additionalReference_lookuptxt"
			   editoptions="{ maxlength:'34' }"
			   onOkMethod="javascript:changeRowStatus('event','this');"
    />

   <psjg:gridColumn id="CHANNEL" colType="text" name="cifChannelRegistrationVO.CHANNEL" index="CHANNEL"		hidden="true" title="hidden"  /> 	
</psjg:grid>
</ps:form>
<script  type="text/javascript">
    $.struts2_jquery.require("ChannelSubscriptionList.js,ChannelSubscriptionMaint.js" ,null,jQuery.contextPath+"/path/js/channelsubscription/");
    $("#gview_channelSubscriptionListGridTbl_Id_"+_pageRef+" div.ui-jqgrid-titlebar").hide();
</script>