<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%>
 

	<ps:form id="limitSchemaListForm_${_pageRef}" useHiddenProps="true" >
	
		<%@include file="LimitSchemaList.jsp" %>
		<ps:if test="showToolBar">
			<pt:toolBar  id="limitSchemaTooBar_${_pageRef}"  >				
				<psj:submit  button="true"  freezeOnSubmit="true" onclick="fomLimitSchema_onSaveClicked();" ><ps:text name="btn.save"></ps:text></psj:submit>			 
				<psj:submit id="limitSchema_ApproveBtn_Id_${_pageRef}"  button="true"  freezeOnSubmit="true" onclick="limitSchema_ApproveClicked();" ><ps:text name="Approved_key"></ps:text></psj:submit>
				<psj:submit  id="limitSchema_RejectBtn_Id_${_pageRef}" button="true"  freezeOnSubmit="true" onclick="limitSchema_RejectClicked();" ><ps:text name="btn.reject"></ps:text></psj:submit>				 	
			</pt:toolBar>
		</ps:if>
	</ps:form>
	
