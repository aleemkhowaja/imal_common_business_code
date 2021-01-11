<%@include file="/WEB-INF/pages/common/Encoding.jsp" %>
<%@include file="/WEB-INF/pages/common/TLDImport.jsp" %>


<ps:set name="ivcrud_${_pageRef}" value="iv_crud" />
<ps:set name="alertApprove_${_pageRef}" value="tradeCO.alertApprove" />
<table width="100%"  >
	<tr>			
		<td width="50%" >
		 <fieldset class="ui-widget-content ui-corner-all">
			<table width="100%">
			  <tr>
			 	 <td class="fldLabelView">
					<ps:label key="Charges_key" />
				  </td>
			      <td>
					<ps:textfield id="schemaCharges_${_pageRef}" 		name="ctsRequestCO.entityChargesCO.schema" readonly="true"/>
					<ps:hidden 	  id="entityType_${_pageRef}" 			name="ctsRequestCO.entityChargesCO.entityType"/>
				 </td>
				 <td width="50%">
				 	<ps:if test='%{#ivcrud_${_pageRef}=="P" || #ivcrud_${_pageRef}=="AC" || #ivcrud_${_pageRef}=="AD" || #alertApprove_${_pageRef}=="1"}'>
						<psj:submit button="true" freezeOnSubmit="true" onclick="waiveCharges();">
							<ps:text name="Waive_Charges_key"></ps:text>
						</psj:submit>	
	   				</ps:if>
				 </td>
				 								 
			  </tr>
			  <tr>								  
			    <td colspan="3">							 
			    	<jsp:include page="/WEB-INF/pages/businesscommon/charges/ChargesGrid.jsp">
						<jsp:param name="gridId" value="grid1_${_pageRef}"/>
						<jsp:param name="schemaCharges" value="schemaCharges_${_pageRef}"/>
						<jsp:param name="typeInd" value="${tradeCO.ivTradeType}"/>
						<jsp:param name="schema" value="${ctsRequestCO.entityChargesCO.schema}"/>
					</jsp:include>
			    </td>
			  </tr>
			 </table>	
			</fieldset>							  								 
		</td>			 			 	
	</tr>		
</table>