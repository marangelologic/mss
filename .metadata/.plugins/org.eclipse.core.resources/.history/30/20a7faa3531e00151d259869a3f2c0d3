var counterTMFields = 1;
$(document)
		.ready(
				function() {
					$("#new_work_group_tr").hide();
					$("#cancel_tm_add").click(function() {
						globalobj.ViewTmList();
					});
					$("#add_tm_info_button").click(
							function() {
								addTmInfos($("#tm_name_add_page").val()
										+ $("#tm_name_last_add_page").val(), $(
										"#tm_id_add_page").val(), $(
										"#tm_email_add_page").val());
							});
					$("#cancel_tm_add_top").click(function() {
						globalobj.ViewTmList();
					});
					$("#add_tm_info_button_top").click(
							function() {
								addTmInfos($("#tm_name_add_page").val() + " "
										+ $("#tm_name_last_add_page").val(), $(
										"#tm_id_add_page").val(), $(
										"#tm_email_add_page").val());
							});
					getAllworkGroupList(counterTMFields);
					enableDateOnClick("tm_start_date_add_page_1",
							"tm_end_date_add_page_1");
					$("#tm_start_date_add_page_1")
							.datepicker(
									{
										
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif',
										onSelect : function(selectedDate) {
											$("#tm_start_date_add_page")
													.datepicker("option",
															"maxDate",
															selectedDate);
										}
									});

					$("#tm_end_date_add_page_1")
							.datepicker(
									{
										maxDate : new Date($(
												"#tm_end_date_add_page").val()),
										minDate : 0,
										changeMonth : true,

										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif',
										onSelect : function(selectedDate) {
											$("#tm_end_date_add_page")
													.datepicker("option",
															"minDate",
															selectedDate);
										}
									});

					$("#add_new_wg_chckbx").click(function() {
						$("#new_work_group_tr").slideToggle("1000");
					});

				});

function GetOldnewWg() {
	var data = "";
	if ($("#add_new_wg_chckbx").is(":checked")) {
		data = $("#tm_new_wg_add").val();
		AddNewWG();
	} else {
		data = $("#tm_wg_add_page").val();

	}
	return data;

}
function enableDateOnClick() {
	for (var i = 0; i < arguments.length; i++) {
		$("#" + arguments[i]).click(function() {
			$(this).datepicker().datepicker("show");
		});
	}
}

function addTmInfos(tmName, employeeId, tmEmail) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "tmrequest",
		data : "{\"signature\":\"addtminfo\"" + "," + "\"tmname\":\"" + tmName
				+ "\"" + "," + "\"tmId\":\"" + employeeId + "\"" + ","
				+ "\"tm_is_active\":\"" + "1" + "\"" + ","
				+ "\"tm_wg_name\":\"" + "" + "\"" + ","
				+ "\"tm_wg_start_date\":\"" + "" + "\"" + ","
				+ "\"tm_wg_end_date\":\"" + "" + "\"" + "," + "\"tmEmail\":\""
				+ tmEmail + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			GetAllWGS();
			$.unblockUI();
			globalobj.returnSuccess();
		}
	});
}

function addTMWgInfo(wgName, wgStartDate, wgEndDate, tmId) {
	$.ajax({
		type : "POST",
		url : "tmrequest",
		data : "{\"signature\": \"updatetmwg\"" + "," + "\"tmname\":\"" + ""
				+ "\"" + "," + "\"tmId\":\""
				+ tmId
				+ "\""
				+ ","
				+ "\"tm_is_active\":\""
				+ ""
				+ "\""
				+ ","
				+ "\"tm_wg_name\":\""
				+ wgName
				+ "\""
				+ ","
				+ "\"tm_wg_start_date\":\""
				+ wgStartDate
				+ "\""
				+ ","
				+ "\"tm_wg_end_date\":\""
				+ wgEndDate
				+ "\""
				+ ","
				+ "\"tmEmail\":\"" + "" + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
		},
		complete : function(e) {
		}
	});
}
function getAllworkGroupList(id) {
	globalobj.ShowLoadingPage();
	$("#tm_wg_add_page_" + id).html();
	var data = "";
	$.ajax({
		type : "POST",
		url : "getallemp",
		data : "{\"wg_names\":\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (var i = 0; i < resultsArray.length; i++) {

				data = data + "<option value='" + resultsArray[i].wg_name
						+ "'>" + resultsArray[i].wg_name + "</option>";
			}
		},
		complete : function(e) {
			$("#tm_wg_add_page_" + id).append(data);
			$.unblockUI();
		}
	});
}

function GetAllWGS() {
	$('.newAppendStart').each(
			function() {
				globalobj.ShowLoadingPage();
				var idNo = (this.id).replace(/[^\d.]/g, '');

				// wgId, TmId,isActive,startDate,endDate
				AddWorkGroupMultiTM($("#tm_wg_add_page_" + idNo).val(), $(
						"#tm_id_add_page").val(), returnIfActive($(
						"#tm_end_date_add_page_" + idNo).val()), $(
						"#tm_start_date_add_page_" + idNo).val(), $(
						"#tm_end_date_add_page_" + idNo).val());
			});

}
function AddMoreWGFields() {

	var dataTable = "";
	counterTMFields = counterTMFields + 1;
	dataTable = dataTable + "<tr id='tr_add_tm_wg_" + counterTMFields + "'>";
	dataTable = dataTable + "<td>New Work Group "
			+ "</td><td><select id='tm_wg_add_page_" + counterTMFields
			+ "' class='newAppendWG" + "'></select></td>";
	dataTable = dataTable
			+ "<td>Start Date</td><td><input type='text' style='display:inline-block' class='newAppendStart' placeholder='DATE: YYYY-MM-DD' id='tm_start_date_add_page_"
			+ counterTMFields + "' /></td>";
	dataTable = dataTable
			+ "<td>End Date</td><td><input class='newAppendEnd' placeholder='DATE: YYYY-MM-DD' type='text' id='tm_end_date_add_page_"
			+ counterTMFields
			+ "' /></td><td><a data-current-number='"
			+ counterTMFields
			+ "' href='javascript:void(0)' onclick='clearTR(\"tr_add_tm_wg_"
			+ counterTMFields
			+ "\")'><img src='img/trash24x24.png' style='width:19px;' /></a></td></tr>";

	$("#tbl_tm_wg_mapping").append(dataTable);
	TransformToDate(counterTMFields);
}

function clearTR(tr) {
	$("#" + tr).html("");
}
function returnIfActive(endDate) {
	var endDateValue = "0";
	if (endDate == null || endDate == "") {
		endDateValue = "1";
	}
	return endDateValue;
}

function TransformToDate(counterTMFields) {
	$("#tm_start_date_add_page_" + counterTMFields)
			.datepicker(
					{
						show : true,
						defaultDate : "+1w",
						changeMonth : true,
						numberOfMonths : 1,
						dateFormat : 'yy-mm-dd',
						changeYear : true,
						showOn : 'button',
						buttonText : 'Show Date',
						buttonImageOnly : true,
						buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
					}).datepicker("show");

	$("#tm_end_date_add_page_" + counterTMFields)
			.datepicker(
					{
						show : true,
						defaultDate : "+1w",
						changeMonth : true,
						numberOfMonths : 1,
						dateFormat : 'yy-mm-dd',
						changeYear : true,
						showOn : 'button',
						buttonText : 'Show Date',
						buttonImageOnly : true,
						buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
					}).datepicker("show");

	$("#tm_start_date_add_page_" + counterTMFields).click(function() {
		$(this).datepicker().datepicker("show");
	});
	$("#tm_end_date_add_page_" + counterTMFields).click(function() {
		$(this).datepicker().datepicker("show");
	});
	getAllworkGroupList(counterTMFields);
}
function AddWorkGroupMultiTM(tmId, workgroupName, isActive, startDate, endDate) {
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "addmultiwgtm"
				+ "\",\"prodFamName\":\"" + "" + "\",\"prodFamId\":\""
				+ isActive + "\",prodFamDesc:\"" + endDate
				+ "\",langCenterId:\"" + startDate + "\",langCenterName:\""
				+ "" + "\",\"langCenterDesc\":\"" + "" + "\",wgName:\""
				+ workgroupName + "\",wgId:\"" + tmId + "\",wgTargetHC:\"" + ""
				+ "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

		},
		complete : function(e) {

			$.unblockUI();

		}
	});

}
