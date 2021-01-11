
function onEditInlineBeforeTopcics_addParamQuery(entityType)
{
	//var entityType = $("#entityType_"+_pageRef).val();
	var rowId = $("#_rowId").val();
	var queryParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
	var queryParamGridTbl = $("#" + queryParamGridId);
	var criteriaCode = $("#_criteriaCode_").val();
	var selRow = queryParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = queryParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_CLASS");
	var paramType = queryParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_TYPE");
	  if (paramVal == "F" || paramVal == "D")
			  {
			    queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
			    queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", false);
			    queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			    queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			    queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
			    queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
		        queryParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		        //By Bilal For TP#750884 param query
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
			  }
	  else if(paramVal == "S"  )
        	 {
                queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", false);
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		        queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
		        queryParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		      //By Bilal For TP#750884 param query
		        queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		        queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
	         }
	  //Added by bilal for Add Option 'Query'
	  else if(paramVal == "Q"  )
			 {
				if(paramType != "DATE" && paramType != "DATETIME")
				{
					 queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
					 queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
					 queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
					 queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
					 queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", false);
					 queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, false);
					 //By Bilal For TP#750884 param query
					 queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", false);
				}
				else
				{
					var preValue = queryParamGridTbl.jqGrid("getCellInputElt", selRow, "ctsSegmentParamVO.PARAM_CLASS").attr("prevValue");
					queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_CLASS", preValue);
				}
			  }
	  else
		  {
		    queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
			//By Bilal For TP#750884 param query
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
			queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
			queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
			queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
			queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
		    queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
		    queryParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
		    queryParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		  }
  queryParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp_" + criteriaCode, true);

}


function onEditInlineBeforeTopcics_addParamProc(entityType)
{
	debugger;
	//var entityType = $("#entityType_"+_pageRef).val();
	var rowId = $("#_rowId").val();
	var procParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
	var procParamGridTbl = $("#"+ procParamGridId);
	var criteriaCode = $("#_criteriaCode_").val();
	var selRow = procParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = procParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_CLASS");
	var paramType = procParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_TYPE");
	  if (paramVal == "F" || paramVal == "D")
			  {
			    procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
			    procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", false);
			    procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			    procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			    procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
			    procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
		        procParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		      //By Bilal For TP#750884 param query
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		        procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		        procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		        procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
			  }
	  else if(paramVal == "S"  )
        	 {
                procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", false);
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		        procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
		        procParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		      //By Bilal For TP#750884 param query
		        procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		        procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		        procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		        procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
	         }
	//Added by bilal for Add Option 'Query'
	  else if(paramVal == "Q"  )
			 {
				  if(paramType != "DATE" && paramType != "DATETIME")
				  {
						procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
						procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
						procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
						procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
						procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", false);
						procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, false);
						  //By Bilal For TP#750884 param query
						procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", false);
				  }
				  else
				  {
					  var preValue = procParamGridTbl.jqGrid("getCellInputElt", selRow, "ctsSegmentParamVO.PARAM_CLASS").attr("prevValue");
					  procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_CLASS", preValue);
				  }
			  }
	  else
		  {
			  procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			  procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
			  procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			  procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
				//By Bilal For TP#750884 param query
			  procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
			  procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
			  procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
			  procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
			  procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.SESSION_ATTR_NAME",null);
			  procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_VALUE",null);
			  procParamGridTbl.jqGrid('setCellValue',selRow,"ctsSegmentParamVO.PARAM_QUERY_ID",null);
			  procParamGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		  }
  procParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp_" + criteriaCode, true);
}


function segmentationQueryParam_onEditInlineBeforeTopics(entityType)
{
	var rowId = $("#_rowId").val();
	var queryParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
	var queryParamGridTbl = $("#" + queryParamGridId);
	var selRow = queryParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = queryParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_CLASS");
	var criteriaCode = $("#_criteriaCode_").val();
	queryParamGridTbl.jqGrid("setCellValue", selRow, "criteriaCode", criteriaCode); //By Bilal For TP#750884
	if(paramVal == "S" )
	{
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", false);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		//By Bilal For TP#750884 param query
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");

	}
	else if(paramVal == "F" || paramVal == "D")
	{
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", false);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		//By Bilal For TP#750884 param query
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		
	}
	else {
		if(paramVal == "Q")
		{
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", false);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, false);
			//By Bilal For TP#750884 param query
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", false);
		}
		else
		{
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
			//By Bilal For TP#750884 param query
			queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
			queryParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
			queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
			queryParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		}
	}
	
	//Rania - ABSAI180073
	debugger;
	if(_pageRef.indexOf("CSC00SC") == 0 && _pageRef != "CSC00SCUP"  && _pageRef != "CSC00SCMT")
	{
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_CLASS", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		queryParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
	}
	//
		
	queryParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp_" + criteriaCode, true);
	restrictSegParamType("Q");
}




function segmentationProcParam_onEditInlineBeforeTopics(entityType)
{
	var rowId = $("#_rowId").val();
	var procParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
	var procParamGridTbl = $("#"+ procParamGridId);
	var selRow = procParamGridTbl.jqGrid("getGridParam", 'selrow');
	var paramVal = procParamGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_CLASS");
	var criteriaCode = $("#_criteriaCode_").val();
	procParamGridTbl.jqGrid("setCellValue", selRow, "criteriaCode", criteriaCode); //By Bilal For TP#750884
	if(paramVal == "S" )
	{
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", false);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		//By Bilal For TP#750884 param query
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");

	}
	else if(paramVal == "F" || paramVal == "D")
	{
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", false);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		//By Bilal For TP#750884 param query
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
		procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		
	}
	else
	{
		if(paramVal == "Q")
		{
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", false);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, false);
			//By Bilal For TP#750884 param query
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", false);
		}
		else
		{
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", false);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
			//By Bilal For TP#750884 param query
			procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
			procParamGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
			procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
			procParamGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		}
	}
	
	//Rania - ABSAI180073
	if(_pageRef.indexOf("CSC00SC") == 0 && _pageRef != "CSC00SCUP"  && _pageRef != "CSC00SCMT")
	{
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.SESSION_ATTR_NAME", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_VALUE", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_CLASS", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "ctsSegmentParamVO.PARAM_QUERY_ID", true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		procParamGridTbl.jqGrid('setCellReadOnly', selRow, "segSelectParameterDetails", true);
	}
	//
	
	procParamGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp_" + criteriaCode, true);
	
	restrictSegProcParamType("P");
}


	function restrictSegParamType(entityType)
	{
		var rowId = $("#_rowId").val();
		var queryParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
		var queryParamGridTbl = $("#" + queryParamGridId);
		
		var selRow = queryParamGridTbl.jqGrid("getGridParam", 'selrow');
		var paramType = queryParamGridTbl.jqGrid("getCell", selRow,
				"ctsSegmentParamVO.PARAM_TYPE");
		var paramName = queryParamGridTbl.jqGrid("getCell", selRow,"ctsSegmentParamVO.PARAM_NAME"); //added by bilalFor BUG#974702
		if (paramType == 'NUMBER') {
			var columnName = document.getElementById(selRow+ "_ctsSegmentParamVO." + "PARAM_VALUE");
			//added by bilalFor BUG#974702, AIBIM200017
			if(paramName == "AL_SCORE_VALUE_FROM" || paramName == "AL_SCORE_VALUE_TO" || paramName.indexOf("AMOUNT")  >= 0 || paramName.indexOf("_PERC") >= 0)
			{
				$(columnName).numeric( {
					format : {format : "#,##0.000" }
				});
			}
			else
			{
				$(columnName).numeric();
			}
			//end bilal
	
		}
	
		else if (paramType == 'DATE') {
			var columnName = document.getElementById(selRow+ "_ctsSegmentParamVO." + "PARAM_VALUE");
			$(columnName).datepicker({ dateFormat: 'dd/mm/yy' });
	
		}
	
	}
	
	
	function restrictSegProcParamType(entityType)
	{
		var rowId = $("#_rowId").val();
		var procParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
		procParamGridTbl = $("#"+ procParamGridId);
		var selRow = procParamGridTbl.jqGrid("getGridParam", 'selrow');
		var paramType = procParamGridTbl.jqGrid("getCell", selRow,
				"ctsSegmentParamVO.PARAM_TYPE");
		var paramName = procParamGridTbl.jqGrid("getCell", selRow,"ctsSegmentParamVO.PARAM_NAME"); //added by bilalFor BUG#974702
		if (paramType == 'NUMBER') {
			var columnName = document.getElementById(selRow+ "_ctsSegmentParamVO." + "PARAM_VALUE");
			//added by bilalFor BUG#974702, AIBIM200017
			if(paramName == "AL_SCORE_VALUE_FROM" || paramName == "AL_SCORE_VALUE_TO" || paramName.indexOf("AMOUNT")  >= 0 || paramName.indexOf("_PERC") >= 0)
			{
				$(columnName).numeric( {
					format : {format : "#,##0.000" }
				});
			}
			else
			{
				$(columnName).numeric();
			}
			//end bilal
		}
	
		else if (paramType == 'DATE') {
			var columnName = document.getElementById(selRow+ "_ctsSegmentParamVO." + "PARAM_VALUE");
			$(columnName).datepicker({ dateFormat: 'dd/mm/yy' });
	
		}
	
	}

function onChangeParamQuery(entityType)
{
	var paramGridTbl;
	var criteriaCode = $("#_criteriaCode_").val();
	if(entityType == 'Q')
	{
		var rowId = $("#_rowId").val();
		paramGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
		paramGridTbl = $("#" + paramGridId);
	}
	else
	{
		var rowId = $("#_rowId").val();
		paramGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
		paramGridTbl = $("#" + paramGridId);
	}
	

	var selRow = paramGridTbl.jqGrid("getGridParam", 'selrow');
	
	divId = $("#dialog_div_spm_" + rowId + "_" + selRow + "_" + criteriaCode + "_" + entityType + _pageRef);
	var paramVal = paramGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_CLASS");
	var paramQueryId = paramGridTbl.jqGrid("getCell", selRow, "ctsSegmentParamVO.PARAM_QUERY_ID");
	if(paramVal == "Q"  )
	 {
		if(paramQueryId == null || paramQueryId == "")
		{
			paramGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, true);
		}
		else
		{
			paramGridTbl.jqGrid('setCellReadOnly', selRow, "multiSelectlkp_" + criteriaCode, false);
		}
		
		paramGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
		paramGridTbl.jqGrid("setCellValue", selRow, "querySelectParamGridStr", "");
		paramGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, "");
		paramGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", "");
		divId.empty().html("");
	  }
	paramGridTbl.jqGrid('setDialogCellReadOnlyText', selRow, "multiSelectlkp_" + criteriaCode, true);
}

function onChangeSelectParamValue(entityType)
{
	debugger;
	var paramGridTbl;
	var criteriaCode = $("#_criteriaCode_").val();
	if(entityType == 'Q')
	{
		var rowId = $("#_rowId").val();
		paramGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
		paramGridTbl = $("#" + paramGridId);
	}
	else
	{
		var rowId = $("#_rowId").val();
		paramGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
		paramGridTbl = $("#" + paramGridId);
	}
	

	var selRow = paramGridTbl.jqGrid("getGridParam", 'selrow');

	paramGridTbl.jqGrid('setCellValue',selRow,"multiSelectlkp_" + criteriaCode,null);
	paramGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, null);
	paramGridTbl.jqGrid("setCellValue", selRow, "jsonMultiselectArray", null);
}

//by bilal for issue the hidden column contain the selected value from livesearch
function fillQryMultiSelectJsonArray()
{
	var criteriaCode = $("#_criteriaCode_").val();
	var rowId = $("#_rowId").val();

	var queryParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#queryGridId").val();
	var rowsIdsQryParam =  $("#" + queryParamGridId).jqGrid('getDataIDs');
	for (var i = 0; i < rowsIdsQryParam.length; i++)
	{
		var rowIdQryParam = rowsIdsQryParam[i];
		var myObjectQryParam = $("#" + queryParamGridId).jqGrid('getRowData', rowIdQryParam);
		var paramClass = myObjectQryParam["ctsSegmentParamVO.PARAM_CLASS"];
		if(paramClass == 'Q')
		{
			var qrySelectParamGridStr = myObjectQryParam["jsonMultiselectArray"];
			$("#" + queryParamGridId).jqGrid("setCellValue", rowIdQryParam, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, qrySelectParamGridStr);
			if(qrySelectParamGridStr != "" &&  qrySelectParamGridStr !=undefined)
			{
				var nbSel=$.parseJSON(qrySelectParamGridStr)["root"].length;
				if(nbSel>0){
					var v;
					if(typeof Selected_key!="undefined" && Selected_key !=null && Selected_key!="")
					{											
						v=nbSel+" "+Selected_key;
					}
					else
					{
						v=nbSel+" Selected";
					}
					$("#" + queryParamGridId).jqGrid("setCellValue", rowIdQryParam, "multiSelectlkp_" + criteriaCode, v);
				}
			}
		}
	}
}

//by bilal for issue the hidden column contain the selected value from livesearch
function fillProcMultiSelectJsonArray()
{
	debugger;
	var criteriaCode = $("#_criteriaCode_").val();
	var rowId = $("#_rowId").val();

	var procParamGridId = $("#dialog_div_p" + rowId + "_" + _pageRef).find("#procGridId").val();
	var rowsIdsProcParam = $("#" + procParamGridId).jqGrid('getDataIDs');
	for (var i = 0; i < rowsIdsProcParam.length; i++)
	{
		var rowIdProcParam = rowsIdsProcParam[i];
		var myObjectProcParam = $("#" + procParamGridId).jqGrid('getRowData', rowIdProcParam);
		var paramClass = myObjectProcParam["ctsSegmentParamVO.PARAM_CLASS"];
		if(paramClass == 'Q')
		{
			var procSelectParamGridStr = myObjectProcParam["jsonMultiselectArray"];
			$("#" + procParamGridId).jqGrid("setCellValue", rowIdProcParam, "jsonMultiselectArray_multiSelectlkp_" + criteriaCode, procSelectParamGridStr);
			if(procSelectParamGridStr != "" &&  procSelectParamGridStr !=undefined)
			{
				var nbSel=$.parseJSON(procSelectParamGridStr)["root"].length;
				if(nbSel>0){
					var v;
					if(typeof Selected_key!="undefined" && Selected_key !=null && Selected_key!="")
					{											
						v=nbSel+" "+Selected_key;
					}
					else
					{
						v=nbSel+" Selected";
					}
					$("#" + procParamGridId).jqGrid("setCellValue", rowIdProcParam, "multiSelectlkp_" + criteriaCode, v);
				}
			}
		}
	}
}