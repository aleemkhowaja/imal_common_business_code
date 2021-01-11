<%@include file="/WEB-INF/pages/common/Encoding.jsp"%>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp"%>
<%@taglib prefix="pt" uri="/path-toolbar-tags"%> 


<div id="genAnnotationFormDiv_<ps:property value="_pageRef" escapeHtml="true"/>" style="overflow: hidden">
	<ps:form id="genAnnotationFormId_${_pageRef}" method="post"	  namespace="/path/signature/" useHiddenProps="true" >	
		<table width="100%" border="0" >		  
			<tr>
				<td class="fldLabelView" width="20%"  >
					<ps:label key="Gen_Ann_key" id="signGenAnnoationLabel_${_pageRef}"
						for="signGenAnnotation_${_pageRef}" />
				</td>
				<td width="50%"> 
					<ps:textarea  name="genAnnotation.ANNOTATION" id="signGenAnnotation_${_pageRef}"  rows="10"
						maxlength="4000" />
					
				</td>	
				<td  width="30%"></td>						
			</tr>			 
		</table>
		
	 	<ps:if test="%{_recReadOnly!='true'}">		
		<pt:toolBar id="genAnnotationTooBar_${_pageRef}">	
		
				<psj:submit button="true" freezeOnSubmit="true" id = "saveSignGenAnnoation_${_pageRef}"
					onclick="saveGenAnnotation();">
					<ps:text name="btn.save"></ps:text>
				</psj:submit>				
				<psj:submit button="true" freezeOnSubmit="true"	id = "clearSignGenAnnoation_${_pageRef}"			 
						onclick="clearGenAnnotationForm();">
						<ps:text name="btn.clear"></ps:text>
				</psj:submit>
				
		</pt:toolBar>
		</ps:if>
	</ps:form>
</div>
 


