var counterField = 1;
$(document)
		.ready(
				function() {

					globalobj.SetPrevHistory("view/uwgp");
					GetWgDetail(globalobj.GetWGId());
					$("#cancel_wg_update").click(function() {
						// globalobj.ViewWgList();
						globalobj.GetPrevHistory("view/uwgp");
					});
					$("#update_wg_info_button")
							.click(
									function() {
										UpdateWgInfo();
										$(this).removeAttr("href");
										$(this).attr("style",
												"background:#a1a1a1");
										$(this).unbind();
										$(this).off("click", "**");
										$("#update_wg_info_button_low")
												.unbind();
										$("#update_wg_info_button_low").off(
												"click", "**");
										$("#add_wg_info_button_low")
												.removeAttr("href");
										$("#update_wg_info_button_low").attr(
												"style", "background:#a1a1a1");
									});

					$("#cancel_wg_update_low").click(function() {
						// globalobj.ViewWgList();
						globalobj.GetPrevHistory("view/uwgp");
					});
					$("#update_wg_info_button_low").click(
							function() {
								UpdateWgInfo();
								$(this).removeAttr("href");
								$(this).attr("style", "background:#a1a1a1");
								$(this).unbind();
								$(this).off("click", "**");
								$("#update_wg_info_button").unbind();
								$("#update_wg_info_button").off("click", "**");
								$("#update_wg_info_button").removeAttr("href");
								$("#update_wg_info_button").attr("style",
										"background:#a1a1a1");
							});
					enableDateOnClick("wg_tm_start_date_update_page",
							"wg_tm_end_date_update_page");
					$("#wg_tm_start_date_update_page")
							.datepicker(
									{
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
											$("#wg_tm_end_date_update_page")
													.datepicker("option",
															"maxDate",
															selectedDate);
										}
									});

					$("#wg_tm_end_date_update_page")
							.datepicker(
									{
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
											$("#wg_tm_start_date_update_page")
													.datepicker("option",
															"minDate",
															selectedDate);
										}
									});
					globalobj.SecurePages();
				});

function enableDateOnClick() {
	for (var i = 0; i < arguments.length; i++) {
		$("#" + arguments[i]).click(function() {
			$(this).datepicker().datepicker("show");
		});
	}
}
function GetWgDetail(wgName) {
	var i = 0;
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "gwgi",
		data : "{\"wg_names\":\"" + wgName + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (i = 0; i < resultsArray.length; i++) {
				$("#wg_id_update_page").val(resultsArray[0].wg_serial_id);
				$("#wg_name_update_page").val(resultsArray[0].wg_name);
				GetProdFamList(resultsArray[0].wg_prod_family);
				GetCenterList(resultsArray[0].wg_language_center);
				$("#wg_old_name").val(resultsArray[0].wg_name);
			}

			GetWgMembers(wgName);
			GetDetailTmWgList(wgName);
		},
		complete : function(e) {
			$("#wg_id_update_page").attr("disabled", "disabled");

		}
	});
}

function GetWgMembers(wgName) {
	$
			.ajax({
				type : "POST",
				url : "gwgm",
				data : "{\"wg_names\":\""
						+ wgName
						+ "\",\"role\": \""
						+ localStorage
								.getItem("29a7e96467b69a9f5a93332e29e9b0de")
						+ "\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					$("#member_wg_list").html("");
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;

					var data = "";
					data = data
							+ "<thead><tr><th> <b> Employee Name</b> </th> <th>Start Date</th> <th><b>End Date</b> </th></tr></thead><tbody>";
					
					for (var i = 0; i < resultsArray.length; i++) {
						data = data
								+ "<tr><td style='align:right; width:25%'><a href='javascript:void(0)' onclick='globalobj.redirectToEmpPage(\""
								+ resultsArray[i].emp_id
								+ "\")'>"
								+ resultsArray[i].emp_name + "</a></td><td>"
								+ resultsArray[i].start_date + "</td><td>&nbsp;</td></tr>";
					}

					$("#member_wg_list").append(data + "</tbody>");

				},
				complete : function(e) {
					$("#member_wg_list").dataTable({
						"columns" : [ {
							"width" : "40%"
						}, {
							"width" : "40%"
						}, {
							"width" : "20%"
						} ]
					});
					$("#member_wg_list th").css("text-align", "center");
					GetCurrentHeadCount(wgName);
					GetTargetHeadCount(wgName);
					$("#wg_id_update_page").attr("disabled", "disabled");
				}
			});

}

function GetCurrentHeadCount(wgName) {
	$
			.ajax({
				type : "POST",
				url : "gwghc",
				data : "{\"wg_names\":\"" + wgName + "\",\"perWG\":\"yes\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					var resultsArray = (typeof response) == 'string' ? eval('(s'
							+ response + ')')
							: response;
					if (resultsArray.length <= 0) {

						$("#wg_chc_update_page").val("0");
					}
					for (var i = 0; i < resultsArray.length; i++) {

						$("#wg_chc_update_page")
								.val(
										((resultsArray[0].current_head_count == undefined) ? "0"
												: resultsArray[0].current_head_count));
					}
				},
				complete : function(e) {
					$("#wg_id_update_page").attr("disabled", "disabled");
				}
			});
}

function UpdateWgInfo() {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "uwgi",
		data : "{\"wg_names\":\"" + $("#wg_name_update_page").val()
				+ "\",\"target_hd_count\":\"" + $("#wg_thc_update_page").val()
				+ "\",\"oldWgName\":\"" + $("#wg_old_name").val() + "\","
				+ "\"wg_language_center\":\"" + $("#wg_upadte_center").val()
				+ "\"," + "\"wg_prod_family\":\""
				+ $("#wg_upadte_product_family").val() + "\"," + "\"wg_id\":\""
				+ $("#wg_id_update_page").val() + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			GetAllTMsForUpdate();
			globalobj.returnSuccess();

		}
	});
}
function GetTargetHeadCount(wgName) {
	$
			.ajax({
				type : "POST",
				url : "gwgthd",
				data : "{\"wg_names\":\"" + wgName + "\",\"perWG\":\"yes\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					for (var i = 0; i < resultsArray.length; i++) {
						$("#wg_thc_update_page").val(
								resultsArray[0].target_head_count);
					}
				},
				complete : function(e) {
					// GetTmWgList(wgName);

				}
			});
}
function GetTmWgList(wgName) {
	$
			.ajax({
				type : "POST",
				url : "gwgtmlist",
				data : "{\"wg_names\":\"" + wgName + "\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					$("#tm_wg_list").html("");
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					var data = "<table class='tbl_mem_list'>";
					data = data
							+ "<tr><td> <b> Manager Name</b> </td> <td><b>Start Date for this Work Group </b> </td></tr>";
					data = data + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
					for (var i = 0; i < resultsArray.length; i++) {
						data = data
								+ "<tr><td style='align:right; width:25%'><a href='javascript:void(0)' onclick='globalobj.redirectToEmpPage(\""
								+ resultsArray[i].tm_employee_id
								+ "\")' class='member_list'>"
								+ resultsArray[i].tm_name + "</a></td><td>"
								+ resultsArray[i].start_date + "</td></tr>";
						$("#wg_tm_start_date_update_page").val(
								resultsArray[0].start_date);
						$("#wg_tm_end_date_update_page").val(
								resultsArray[0].end_date);

					}
					if (resultsArray.length <= 3) {

						data = data + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
						data = data + "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
					}
					if (resultsArray.length <= 0) {
						for (var i = 0; i < 3; i++) {
							data = data
									+ "<tr><td>&nbsp;</td><td>&nbsp;</td></tr>";
						}
					}

					$("#tm_wg_list").append(data + "</table>");

				},
				complete : function(e) {
					$("#wg_id_update_page").attr("disabled", "disabled");
					$.unblockUI();
				}
			});

}

function TransformToDate(counter1) {
	$("#wg_tm_start_date_update_page_" + counter1)
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

	$("#wg_tm_end_date_update_page_" + counter1)
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

	$("#wg_tm_start_date_update_page_" + counter1).click(function() {
		$(this).datepicker().datepicker("show");
	});
	$("#wg_tm_end_date_update_page_" + counter1).click(function() {
		$(this).datepicker().datepicker("show");
	});
}

function GetProdFamList(prodfam) {
	var data = "";
	$
			.ajax({
				type : "POST",
				url : "ProdFamily",
				data : "{\"wgPSM\":\"" + "\",signature:\"" + "getprodfamlist"
						+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
						+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
						+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\""
						+ "" + "\",wgName:\"" + "" + "\",wgId:\"" + ""
						+ "\",wgTargetHC:\"" + "" + "\",wgWfHC:\"" + "" + "\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					$("#wg_upadte_product_family").html("");
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					for (var i = 0; i < resultsArray.length; i++) {
						if (prodfam == resultsArray[i].product_family_name) {
							data = data + "<option selected value='"
									+ resultsArray[i].product_family_name
									+ "'>"
									+ resultsArray[i].product_family_name
									+ "</option>";
						} else {
							data = data + "<option value='"
									+ resultsArray[i].product_family_name
									+ "'>"
									+ resultsArray[i].product_family_name
									+ "</option>";
						}
					}
				},
				complete : function(e) {
					$("#wg_upadte_product_family").append(data);
				}
			});

}
function GetCenterList(center) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getallcenters"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#wg_upadte_center").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				if (center == resultsArray[i].lang_center_name) {
					data = data + "<option selected value='"
							+ resultsArray[i].lang_center_name + "'>"
							+ resultsArray[i].lang_center_name + "</option>";
				} else {
					data = data + "<option value='"
							+ resultsArray[i].lang_center_name + "'>"
							+ resultsArray[i].lang_center_name + "</option>";
				}
			}
		},
		complete : function(e) {
			$("#wg_upadte_center").append(data);
		}
	});

}
// GET TEAM MANAGERS NAME DISABLED
function GetUpdateTMList(current_tm) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getalltms"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#wg_tm_update_page").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				if (current_tm == resultsArray[i].tm_employee_id) {
					data = data + "<option selected value='"
							+ resultsArray[i].tm_employee_id + "'>"
							+ resultsArray[i].tm_name + "</option>";
				} else {
					data = data + "<option value='"
							+ resultsArray[i].tm_employee_id + "'>"
							+ resultsArray[i].tm_name + "</option>";
				}

			}
		},
		complete : function(e) {
			$("#wg_tm_update_page").append(data);
		}
	});

}

function GetWGUpdateTM(wgName) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getwgtm"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + wgName + "\",wgId:\"" + ""
				+ "\",wgTargetHC:\"" + "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				data = resultsArray[0].tm_id;
			}
		},
		complete : function(e) {

		}
	});

}
// #NEWTMWGLIST
function GetDetailTmWgList(wgName) {
	var counterHere = 1;
	$
			.ajax({
				type : "POST",
				url : "gwgtmlist",
				data : "{\"wg_names\":\"" + wgName + "\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					$("#tm_wg_list").html("");
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					var dataTable = "<table id='update_wg_table'>";
					counterHere = resultsArray.length;
					dataTable = dataTable
							+ "<tr><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td></tr>";
					for (var i = 0; i < resultsArray.length; i++) {
						dataTable = dataTable + "<tr id='tr_add_tm_wg_"
								+ counterField + "'>";
						dataTable = dataTable
								+ "<td>Team Manager "
								+ "</td><td><input type='hidden' id='update_team_manager_"
								+ counterField + "' class='newAppendManager"
								+ "' value='" + resultsArray[i].tm_employee_id
								+ "' /><input type='text' value='"
								+ resultsArray[i].tm_name
								+ "'  disabled='disabled' /> </td>";
						dataTable = dataTable
								+ "<td>Start Date</td><td><input type='text' style='display:inline-block' class='newAppendStart' placeholder='DATE: YYYY-MM-DD' id='wg_tm_start_date_update_page_"
								+ counterField + "' value='"
								+ resultsArray[i].start_date + "' /></td>";
						dataTable = dataTable
								+ "<td>End Date</td><td><input class='newAppendEnd' placeholder='DATE: YYYY-MM-DD' type='text' id='wg_tm_end_date_update_page_"
								+ counterField + "' value='"
								+ ReturnNull(resultsArray[i].end_date)
								+ "' /></td><td>&nbsp;</td></tr>";

						// TransformToDate(counterField);
						counterField = parseInt(counterField) + 1;
					}
					$("#tm_wg_list").append(dataTable + "</table>");

				},
				complete : function(e) {
					for (var j = 1; j <= counterHere; j++) {
						TransformToDate(j);
					}
					$.unblockUI();
					// $("#wg_id_update_page").attr("disabled","disabled");
				}
			});

}
function ReturnNull(date) {
	newDate = date;
	if (date == "" || date == null || date == "undefined" || date == undefined) {
		newDate = "";
	}

	return newDate;
}

function AddMoreTmFields() {

	var dataTable = "";

	dataTable = dataTable + "<tr id='tr_update_tm_wg_" + counterField + "'>";
	dataTable = dataTable + "<td>New Team Manager "
			+ "</td><td><select id='update_team_manager_" + counterField
			+ "' class='newAppendManager" + "'></select></td>";
	dataTable = dataTable
			+ "<td>Start Date</td><td><input type='text' style='display:inline-block' class='newAppendStart' placeholder='DATE: YYYY-MM-DD' id='wg_tm_start_date_update_page_"
			+ counterField + "' /></td>";
	dataTable = dataTable
			+ "<td>End Date</td><td><input class='newAppendEnd' placeholder='DATE: YYYY-MM-DD' type='text' id='wg_tm_end_date_update_page_"
			+ counterField
			+ "' /></td><td><a data-current-number='"
			+ counterField
			+ "' href='javascript:void(0)' onclick='clearTR(\"tr_update_tm_wg_"
			+ counterField
			+ "\")'><img src='img/trash24x24.png' style='width:19px;' /></a></td></tr>";

	$("#update_wg_table").append(dataTable);

	TransformToDate(counterField);
	GetTMList("update_team_manager_" + counterField);
	counterField = counterField + 1;

}

function clearTR(tr) {
	$("#" + tr).html("");
}
// GET TEAM MANAGER AND APPEND TO SELECT
function GetTMList(id) {
	globalobj.ShowLoadingPage();
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getalltms"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			// $("#add_team_manager").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (var i = 0; i < resultsArray.length; i++) {

				data = data + "<option value='"
						+ resultsArray[i].tm_employee_id + "'>"
						+ resultsArray[i].tm_name + "</option>";
			}
			$("#" + id).append(data);
		},
		complete : function(e) {

			$.unblockUI();
		}
	});

}

function GetAllTMsForUpdate() {
	DeleteWgTmRecords($("#wg_name_update_page").val());
	// var $items = $('.newAppendStart');
	// startDate = startDate // langCenterDesc = endDate
	$('.newAppendStart').each(
			function() {
				globalobj.ShowLoadingPage();
				var idNo = (this.id).replace(/[^\d.]/g, '');
				// tmId, workgroupName,isActive,startDate,endDate
				updateWorkGroupMultiTM($("#update_team_manager_" + idNo).val(),
						$("#wg_name_update_page").val(), returnIfActive($(
								"#wg_tm_end_date_update_page_" + idNo).val()),
						$("#wg_tm_start_date_update_page_" + idNo).val(), $(
								"#wg_tm_end_date_update_page_" + idNo).val());

			});

}
function returnIfActive(endDate) {
	var endDateValue = "0";
	if (endDate == null || endDate == "") {
		endDateValue = "1";
	}
	return endDateValue;
}
function updateWorkGroupMultiTM(tmId, workgroupName, isActive, startDate,
		endDate) {
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "addmultitmwg"
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
// #DEASSOCIATE WG AND TM
function DeleteWgTmRecords(wgName) {
	globalobj.ShowLoadingPage();
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "deassoctmwg"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + wgName + "\",wgId:\"" + ""
				+ "\",wgTargetHC:\"" + "" + "\",wgWfHC:\"" + "" + "\"}",
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
/*
 * function UpdateTMWgInfo(wgName, wgStartDate, wgEndDate, tmId) {
 * CleanTmWg(tmId); $.ajax({ type : "POST", url : "tmrequest", data :
 * "{\"signature\": \"updatetmwg\"" + "," + "\"tmname\":\"" + "" + "\"" + "," +
 * "\"tmId\":\"" + tmId + "\"" + "," + "\"tm_is_active\":\"" + "" + "\"" + "," +
 * "\"tm_wg_name\":\"" + wgName + "\"" + "," + "\"tm_wg_start_date\":\"" +
 * wgStartDate + "\"" + "," + "\"tm_wg_end_date\":\"" + wgEndDate + "\"" + "," +
 * "\"tmEmail\":\"" + "" + "\"" + "}", contentType :
 * "application/x-www-form-urlencoded", dataType : "json", success :
 * function(response) { var resultsArray = (typeof response) == 'string' ?
 * eval('(' + response + ')') : response; }, complete : function(e) {
 * globalobj.returnSuccess(); } }); } function CleanTmWg(tmId) { $.ajax({ type :
 * "POST", url : "tmrequest", data : "{\"signature\": \"deletetmwginfo\"" + "," +
 * "\"tmname\":\"" + "" + "\"" + "," + "\"tmId\":\"" + tmId + "\"" + "," +
 * "\"tm_is_active\":\"" + "" + "\"" + "," + "\"tm_wg_name\":\"" + "" + "\"" +
 * "," + "\"tm_wg_start_date\":\"" + "" + "\"" + "," + "\"tm_wg_end_date\":\"" + "" +
 * "\"" + "," + "\"tmEmail\":\"" + "" + "\"" + "}", contentType :
 * "application/x-www-form-urlencoded", dataType : "json", success :
 * function(response) { var resultsArray = (typeof response) == 'string' ?
 * eval('(' + response + ')') : response; }, complete : function(e) { } }); }
 */
