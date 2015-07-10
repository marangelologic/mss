/*

 */

var today = new Date();
var dd = today.getDate();
var mm = today.getMonth() + 1; // January is 0!
var yyyy = today.getFullYear();
var dateToday = yyyy + '-' + AddZero(mm) + '-' + AddZero(dd);
var counter = 1;
var counter1 = 1;
var sample = "";
updateCounterTM = 1;
updateCounterWG = 1;
var addNewTM = "";
var addNewWG = "";
globalobj.SecurePages();
var psmEmil = "";
$(document)
		.ready(
				function() {
					$.validator.addMethod("greaterThan", function(value,
							element, params) {

						var target = $(params).val();
						if (!$("#tm_chk_box").is(":checked")) {
							return true;
						}
						var isValueNumeric = !isNaN(parseFloat(value))
								&& isFinite(value);
						var isTargetNumeric = !isNaN(parseFloat(target))
								&& isFinite(target);
						if (isValueNumeric && isTargetNumeric) {
							return Number(value) >= Number(target);
						}

						if (!/Invalid|NaN/.test(new Date(value))) {
							return new Date(value) >= new Date(target);
						}

						return false;

					}, ('Must be greater than {0}').replace("#", ""));

					$("#reason_row").hide();
					$("#leave_type_label").hide();
					$("#emp_leave_update_page_label").hide();
					ShowStartEndDates();
					ShowTrainingDates();
					GetEmployeeInfo(globalobj.GetEmployeeId());
					globalobj.SetPrevHistory("view/usip");
					GetEmpPsmMapping(globalobj.GetEmployeeId());
					$("#update_emp_form")
							.validate(
									{
										rules : {
											emp_start_training_update_page : {
												required : '#emp_is_training_field:checked'

											},
											emp_end_training_update_page : {
												required : '#emp_is_training_field:checked'
											},
											emp_email_update_page : {
												required : true
											},
											emp_next_tm_start_date : {
												required : '#tm_chk_box:checked',
												greaterThan : "#emp_end_date_update"
											},
											emp_next_wg_start_date : {
												required : '#wg_chk_box:checked'
											},
											emp_end_date_update : {
												required : '#tm_chk_box:checked',
												greaterThan : "#emp_start_date_update"
											}

										},
										messages : {
											emp_email_update_page : "<p>Please enter your Email Or a valid email address</p>",
											emp_start_training_update_page : "<p>Please enter your Start Date<p>",
											emp_end_training_update_page : "<p>Please enter End Date<p>",
											emp_next_tm_start_date : {
												required : "<p>Please provide Tm start date End Date<p>",
												greaterThan : "<p>TM End date must be greater than start date<p>"
											},
											emp_next_wg_start_date : {
												required : "<p>Please provide Workgroup End Date<p>",
												greaterThan : "<p>WG End date must be greater than start date<p>"

											},
											emp_end_date_update : {
												required : "<p>End date should be populated<p>",
												greaterThan : "<p>End Date should always be greater than start date"
											}
										},

										errorLabelContainer : $("ul",
												$('div#appendError')),
										wrapper : 'li',
										errorContainer : $('div#appendError'),
										errorPlacement : function(error,
												element) {
											$('#appendError').append(error);
										},
										onfocusout : false,
										onkeyup : false
									});

					enableDateOnClick("emp_start_training_update_page",
							"emp_resigned_update_page",
							"emp_end_training_update_page",
							"emp_end_date_update", "emp_next_tm_start_date",
							"emp_curr_wg_end_date", "emp_next_wg_start_date",
							"emp_hire_update_page", "quick_tm_start_date",
							"update_quick_tm_hired_date",
							"update_quick_psm_start_date",
							"emp_curr_wg_start_date", "emp_start_date_update");
					$("#emp_next_tm_end_date").hide();
					$("#emp_next_wg_end_date").hide();
					$("#quick_add_update_tm").hide();
					$("#quick_add_update_wg").hide();
					$("#tm_row_1").hide();
					$("#tm_row_12").hide();
					$("#tm_row_2").hide();
					$("#wg_row_1").hide();
					$("#wg_row_2").hide();
					GetPSMListForUpdate();
					$("#tm_chk_box").click(
							function() {
								if ($("#tm_chk_box").is(":checked")) {
									$("#tm_row_1").show();
									$("#tm_row_2").show();
									$("#emp_end_date_update").val(dateToday);
								} else {
									$("#tm_row_1").hide();
									$("#tm_row_2").hide();
								}
								globalobj.GetAllTMAvailable($(
										"#emp_curre_tm_update_page").val());
							});

					$("#wg_chk_box").click(function() {
						$("#wg_row_1").toggle('slow', ClearVal);
						$("#wg_row_2").toggle('slow');

					});
					$("#quick_add_update_tm_chckbx").click(
							function() {
								globalobj.ShowLoadingPage();
								$("#emp_end_date_update").val(dateToday);
								$("#current_update_team_div").slideToggle(
										"slow", $.unblockUI);
								$("#quick_add_update_tm").slideToggle("slow");

								if ((updateCounterTM % 2) != 0) {
									$("#tm_row_1").hide();
									$("#tm_row_2").hide();
									$('#tm_chk_box').prop("checked", false);
									updateCounterTM = updateCounterTM + 1;
								} else {
									$('#tm_chk_box').prop("checked", true);
									$("#tm_row_1").show();
									$("#tm_row_2").show();
									updateCounterTM = updateCounterTM + 1;
								}
							});

					$("#update_emp_all_info_top")
							.click(
									function() {
										if ($("#update_emp_form").valid()) {
											UpdateSpecialistInfo();
											$(this).removeAttr("href");
											$(this).attr("style",
													"background:#a1a1a1");
											$(this).unbind();
											$(this).off("click", "**");
											$("#update_emp_all_info_bottom")
													.unbind();
											$("#update_emp_all_info_bottom")
													.off("click", "**");
											$("#update_emp_all_info_bottom")
													.removeAttr("href");
											$("#update_emp_all_info_bottom")
													.attr("style",
															"background:#a1a1a1");
										}
									});
					$("#update_emp_all_info_bottom")
							.click(
									function() {
										if ($("#update_emp_form").valid()) {
											UpdateSpecialistInfo();
											$(this).removeAttr("href");
											$(this).attr("style",
													"background:#a1a1a1");
											$(this).unbind();
											$(this).off("click", "**");
											$("#update_emp_all_info_top")
													.unbind();
											$("#update_emp_all_info_top").off(
													"click", "**");
											$("#update_emp_all_info_top")
													.removeAttr("href");
											$("#update_emp_all_info_top").attr(
													"style",
													"background:#a1a1a1");
										}
									});
					$("#quick_add_update_wg_chckbx").click(
							function() {

								globalobj.ShowLoadingPage();
								$("#current_update_wg_div").slideToggle("slow",
										$.unblockUI);
								$("#quick_add_update_wg").slideToggle("slow");
								if ((updateCounterWG % 2) != 0) {
									$("#wg_row_1").hide();
									$("#wg_row_2").hide();
									$('#wg_chk_box').prop("checked", false);
									updateCounterWG = updateCounterWG + 1;
								} else {
									$('#wg_chk_box').prop("checked", true);
									$("#wg_row_1").show();
									$("#wg_row_2").show();
									updateCounterWG = updateCounterWG + 1;
								}

							});

					$("#emp_next_wg_start_date")
							.datepicker(
									{

										defaultDate : "+1w",
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif',
										onSelect : function(dateText, inst) {
											$(
													"#emp_wg_update_week_number_field")
													.val(
															$.datepicker
																	.iso8601Week(new Date(
																			dateText)));
										}

									});
					$("#emp_curr_wg_start_date")
							.datepicker(
									{

										defaultDate : "+1w",
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									/*
									 * onSelect : function(dateText, inst) { $(
									 * "#emp_wg_update_week_number_field") .val(
									 * $.datepicker .iso8601Week(new Date(
									 * dateText))); }
									 */

									});
					$("#emp_start_date_update")
							.datepicker(
									{

										defaultDate : "+1w",
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									/*
									 * onSelect : function(dateText, inst) { $(
									 * "#emp_wg_update_week_number_field") .val(
									 * $.datepicker .iso8601Week(new Date(
									 * dateText))); }
									 */

									});
					$("#update_quick_tm_hired_date")
							.datepicker(
									{

										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									/*
									 * onSelect : function(dateText, inst) { $(
									 * "#emp_wg_update_week_number_field") .val(
									 * $.datepicker .iso8601Week(new Date(
									 * dateText))); }
									 */

									});

					$("#emp_hire_update_page")
							.datepicker(
									{
										maxDate : new Date($(
												"#emp_resigned_update_page")
												.val()),
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});
					$("#quick_tm_start_date")
							.datepicker(
									{
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});
					$("#update_quick_psm_start_date")
							.datepicker(
									{
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});
					$("#emp_next_tm_start_date")
							.datepicker(
									{

										defaultDate : "+1w",
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										onClose : function(selectedDate) {
											$("#emp_next_tm_end_date")
													.datepicker("option",
															"minDate",
															selectedDate);
										},
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});

					$("#emp_hire_update_page")
							.datepicker(
									{

										maxDate : new Date($(
												"#emp_resigned_update_page")
												.val()),
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});

					$("#emp_end_training_update_page")
							.datepicker(
									{
										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										onSelect : function(selectedDate) {
											$("#emp_start_training_update_page")
													.datepicker("option",
															"maxDate",
															selectedDate);
										},
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,
										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});

					$("#emp_start_training_update_page")
							.datepicker(
									{

										changeMonth : true,
										numberOfMonths : 1,
										dateFormat : 'yy-mm-dd',
										changeYear : true,
										onSelect : function(selectedDate) {
											$("#emp_end_training_update_page")
													.datepicker("option",
															"minDate",
															selectedDate);
										},
										onClose : function(selectedDate) {
											$("#emp_end_training_update_page")
													.datepicker("option",
															"minDate",
															selectedDate);
										},
										showOn : 'button',
										buttonText : 'Show Date',
										buttonImageOnly : true,

										buttonImage : 'http://jqueryui.com/resources/demos/datepicker/images/calendar.gif'
									});

					$("#update_employee_button").click(function(e) {
						globalobj.ShowLoadingPage();
						UpdateSpecialistInfo();
						return false;
					});
					$(".button-1").click(function() {
						return false;
					});
					$("#cancel_update_employee").click(function() {
						globalobj.ShowLoadingPage();
						globalobj.GetPrevHistory("view/usip");

					});
					$("#cancel_update_employee_top").click(function() {
						globalobj.ShowLoadingPage();
						globalobj.GetPrevHistory("view/usip");
					});
					$("#emp_trans_tm_update").change(function() {
						globalobj.ShowLoadingPage();
						GetPSMEmail($(this).val());
					});

				});
$(".ui-datepicker-trigger").ready(function() {
	$(".ui-datepicker-trigger").hide();
});

$("legend").ready(function() {
	$("legend").css("background-color", "#f2f2f3").css("padding", "10px");
});
$(document).keypress(
		function(event) {
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if (keycode == '13') {
				if ($("#update_emp_form").valid()) {
					UpdateSpecialistInfo();
/*
					$("#update_emp_all_info_top").unbind();
					$("#update_emp_all_info_top").off("click", "**");
					$("#update_emp_all_info_top").removeAttr("href");
					$("#update_emp_all_info_top").attr("style",
							"background:#a1a1a1");
					$("#update_emp_all_info_bottom").unbind();
					$("#update_emp_all_info_bottom").off("click", "**");
					$("#update_emp_all_info_bottom").removeAttr("href");
					$("#update_emp_all_info_bottom").attr("style",
							"background:#a1a1a1");*/

				}
			}
		});

function GetRoleCategory(emp_id, role) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\": \"" + emp_id + "\", \"signature\": \"getroles\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#emp_role_update_page").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			resultsArray.sort();
			for (var i = 0; i < resultsArray.length; i++) {
				if (resultsArray[i].role_name == role) {
					data = data + "<option selected value='"
							+ resultsArray[i].role_name + "'>"
							+ resultsArray[i].role_name + "</option>";
				} else {
					data = data + "<option value='" + resultsArray[i].role_name
							+ "'>" + resultsArray[i].role_name + "</option>";
				}

			}
			$("#emp_role_update_page").append(data);
		},
		complete : function(e) {

		}  
	});
} 
function runScript(e) {
	if (e.keyCode == 13) {
		if ($("#update_emp_form").valid()) {
			UpdateSpecialistInfo();
			/*$(this).removeAttr("href");
			$(this).attr("style", "background:#a1a1a1");
			$(this).unbind();
			$(this).off("click", "**");
			$("#update_emp_all_info_bottom").unbind();
			$("#update_emp_all_info_bottom").off("click", "**");
			$("#update_emp_all_info_bottom").removeAttr("href");
			$("#update_emp_all_info_bottom")
					.attr("style", "background:#a1a1a1");*/
		}
	}
}
function AddZero(variable) {
	variable = "0" + variable;
	variable = variable.slice(-2);

	return variable;
}

function ClearValTM() {
	if ((parseFloat(counter1 % 2) != 0)) {
		$("#emp_end_date_update").val(dateToday);
	} else {
		$("#emp_end_date_update").val("");
	}
	counter1 = counter1 + 1;

}

function enableDateOnClick() {
	for (var i = 0; i < arguments.length; i++) {
		$("#" + arguments[i]).click(function() {
			$(this).datepicker().datepicker("show");
		});
	}
}

function ClearVal() {
	if ((parseFloat(counter % 2) != 0)) {
		$("#emp_curr_wg_end_date").val(dateToday);
	} else {
		$("#emp_curr_wg_end_date").val("");
	}
	counter = counter + 1;

}

function GetEmployeeInfo(id) {
	globalobj.ShowLoadingPage();
	var i = 0;
	$.ajax({
		type : "POST",
		url : "empinfo",
		data : "{\"emp_id\": \"" + id + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (i = 0; i < resultsArray.length; i++) {
				setIstraining(resultsArray[0].emp_status);
				$("#emp_id_update_page").val(resultsArray[0].emp_id).attr(
						"disabled");
				$("#emp_name_update_page").val(resultsArray[0].emp_name);
				$("#emp_email_update_page").val(resultsArray[0].email);
				$("#emp_role_update_page").val(resultsArray[0].role);
				$("#emp_role_update_page").attr("current-role",
						resultsArray[0].role);
				$("#emp_curre_tm_update_page").val(resultsArray[0].tm_name);
				GetLocationList(resultsArray[0].emp_location);
				GetProdFamList(resultsArray[0].emp_product_family);
				GetCenterList(resultsArray[0].emp_center);
				$("#emp_start_date_update").val(
						resultsArray[0].emp_tm_start_date);
				ReturnPresent($("#emp_end_date_update").val(
						resultsArray[0].emp_tm_end_date));
				$("#emp_hire_update_page").val(resultsArray[0].emp_hired_date);
				$("#emp_resigned_update_page").val(
						resultsArray[0].emp_resigned_date);
				$("#emp_curre_tm_id_update_page").val(resultsArray[0].tm_id);
				$("#emp_start_training_update_page").val(
						resultsArray[0].emp_training_start_date);
				$("#emp_end_training_update_page").val(
						resultsArray[0].emp_training_end_date);
				$("#flip_1").val(resultsArray[0].is_interim);
				GetRoleCategory(id, resultsArray[0].role);
				ReturnEmptype(resultsArray[0].emp_status);
				GetUpdatePortalRoles(resultsArray[0].emp_portal_role);

			}

		},
		complete : function(e) {
			GetCurrentWG(id);
			GetWorkgRoupHistory(id);
			$("#emp_id_update_page").attr("disabled", "disabled");
			$("#emp_curre_tm_update_page").attr("disabled", "disabled");
			$("#emp_curr_wg_update_page").attr("disabled", "disabled");
			ShowHistoricalData();
			globalobj.GetAllWGAvailable($("#emp_curr_wg_update_page").val());
			SetMinEndDates();
			GetQuarterOftheMonth("emp_hire_update_page", "");
			GetQatagAsPermanent(id);
			GetEmployeeAttribute(id);

		}
	});
}

function SetMinEndDates() {
	$("#emp_resigned_update_page").datepicker({
		minDate : new Date($("#emp_hire_update_page").val()),
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : 'yy-mm-dd',
		changeYear : true,
		onSelect : function(date) {
			$("#reason_row").show();
		}
	});
	$("#emp_curr_wg_end_date").datepicker({
		minDate : new Date($("#emp_next_wg_start_date").val()),
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : 'yy-mm-dd',
		changeYear : true
	});
	$("#emp_end_date_update").datepicker({
		minDate : new Date($("#emp_start_date_update").val()),
		defaultDate : "+1w",
		changeMonth : true,
		numberOfMonths : 1,
		dateFormat : 'yy-mm-dd',
		changeYear : true
	});
}

function setIstraining(status) {
	$("#training_dates_update_row").show();
	$("#emp_start_training_update_page").val("");
	$("#emp_end_training_update_page").val("");
	$("#emp_leave_update_page_label").hide();
	$("#leave_type_label").hide();
	if (status == "Training") {
		$("#emp_update_start_date_field").text("Training Start Date");
		$("#emp_update_end_date_field").text("Training End Date");
	} else if (status == "Contractual") {
		$("#emp_update_start_date_field").text("Contract Start Date");
		$("#emp_update_end_date_field").text("Contract End Date");
	} else if (status == "Leave") {
		$("#emp_leave_update_page_label").show();
		$("#leave_type_label").show();

		$("#emp_update_start_date_field").text("Leave Start Date");
		$("#emp_update_end_date_field").text("Leave End Date");
	} else {
		$("#training_dates_update_row").hide();
	}
}

function ShowTrainingDates() {
	$("#training_dates_update_row").hide();
	$("#emp_is_training_field").click(function() {
		if ($("#emp_is_training_field").is(":checked")) {
			$("#training_dates_update_row").show();
		} else {
			$("#training_dates_update_row").hide();
		}
	});
}

function UpdateSpecialistInfo() {
	$("#appendError").html("");
	updateInterimStatus($("#emp_id_update_page").val(), $("#flip_1").val());
	UpdateCurrentWgStatus($("#emp_curr_wg_update_page").val(), $(
			"#emp_id_update_page").val(), $("#emp_curr_wg_start_date").val(),
			$("#emp_curr_wg_end_date").val());

	var a = $("#tm_chk_box").is(":checked");
	var b = $("#wg_chk_box").is(":checked");
	if (a) {
		UpdateEmployeeInfoWithTM();
		EmailRosterChange("transfertm");

		EmailPSM(AddQuickNewTM(), psmEmil, globalobj.GetQuarterOftheMonth("",
				""), globalobj.GetYear(), $("#emp_name_update_page").val(),
				TmNameForQuality());
	}
	if (b) {
		UpdateEmployeeInfoWithWG();
	}
	if ((updateCounterTM % 2) == 0) {
		if (addNewTM == "") {
			UpdateEmployeeNewTmInfo($("#update_quick_tm_number").val(), $(
					"#quick_tm_start_date").val());
			EmailRosterChange("transfertm");
		}
	}
	if ($("#general_reasons").val() == "promoted"
			&& $("#emp_resigned_update_page").val()) {
		if ($("#emp_role_update_page").attr("current-role") != $(
				"#emp_role_update_page").val()) {
			AddPromoted($("#emp_id_update_page").val(), dateToday, $(
					"#taleo_update_page").val(), $("#emp_role_update_page")
					.val());
		} else {
			alert("Promoting with the same role is not applicable!");
			return false;
		}
	}
	if ($("#emp_psm_update").val() != $("#emp_psm_properties").attr("psm-id"))
		UpdateEmpPsmMapping($("#emp_id_update_page").val(),
				$("#emp_psm_update").val(),
				$("#emp_psm_update option:selected").text(), $(
						"#emp_psm_update").attr("psm-email"));

	AddNewWG1();
	updateOnlyEmpInfo();
	UpdateCurrentTmStatus($("#emp_curre_tm_id_update_page").val(), $(
			"#emp_id_update_page").val(), $("#emp_start_date_update").val(), $(
			"#emp_end_date_update").val());
}

function UpdateEmployeeNewTmInfo(tmNumber, newStartDate) {
	$.ajax({
		type : "POST",
		url : "auctmi",
		data : "{\"emp_id\": \"" + $("#emp_id_update_page").val() + "\","
				+ "\"tm_id\": \"" + $("#emp_curre_tm_id_update_page").val()
				+ "\"," + "\"emp_is_new\": \"0" + "\"," + "\"new_tm_id\": \""
				+ tmNumber + "\"," + "\"new_start_date\": \"" + newStartDate
				+ "\"," + "\"curr_end_date\": \""
				+ $("#emp_end_date_update").val() + "\","
				+ "\"cur_start_date\": \"" + $("#emp_start_date_update").val()
				+ "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			if ((updateCounterTM % 2) == 0) {
				addTmInfos($("#update_quick_tm_fname").val() + " "
						+ $("#update_quick_tm_lname").val(), $(
						"#update_quick_tm_number").val(), $(
						"#update_quick_tm_email").val());
			}
			EmailPSM(AddQuickNewTM(), "tm", globalobj.GetQuarterOftheMonth("",
					""), globalobj.GetYear());
		},
		complete : function(e) {
			addNewTM = "Added";
		}
	});
}

function addTmInfos(tmName, employeeId, tmEmail) {
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
			if (!(updateCounterWG % 2) == 0) {
				addTMWgInfo(AddQuickNewWG(), ReturnTmStartDate(), "",
						AddQuickNewTM());
			}
			$.unblockUI();
		}
	});
}

function updateOnlyEmpInfo() {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "usis",
		data : "{\"emp_id\": \"" + $("#emp_id_update_page").val() + "\","
				+ "\"emp_is_update\": \"1\"," + "\"emp_name\": \""
				+ $("#emp_name_update_page").val() + "\","
				+ "\"emp_email\": \"" + $("#emp_email_update_page").val()
				+ "\",\"emp_training_start_date\": \""
				+ $("#emp_start_training_update_page").val()
				+ "\",\"emp_training_end_date\": \""
				+ $("#emp_end_training_update_page").val() + "\","
				+ "\"emp_is_training\": \"" + ReturnIfTraining() + "\","
				+ "\"emp_role\": \"" + $("#emp_role_update_page").val() + "\","
				+ "\"emp_prod_fam\": \""
				+ $("#emp_prod_family_update_page").val() + "\","
				+ "\"emp_location\": \"" + $("#emp_location_update_page").val()
				+ "\"," + "\"emp_center\": \""
				+ $("#emp_center_update_page").val() + "\","
				+ "\"emp_hire_date\": \"" + $("#emp_hire_update_page").val()
				+ "\"," + "\"emp_res_date\": \""
				+ $("#emp_resigned_update_page").val() + "\",\"taleono\":\""
				+ "" + "\",\"emp_type\":\"" + $("#emp_update_type").val()
				+ "\",\"portal_role\":\"" + $("#emp_update_portal_role").val()
				+ "\"" + "}",

		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			if ($("#tag_as_permanent").val() == 0) {
				TagAsPermanent($("#emp_id_update_page").val(), "1",
						globalobj.dateToday);
			}
			isUpdate($("#emp_id_update_page").val(), $(
					"#emp_start_training_update_page").val(), $(
					"#emp_end_training_update_page").val(), $(
					"#emp_update_type").val(),
					(($("#emp_update_type").val() == "Leave") ? $(
							"#emp_leave_update_page").val() : ""), $(
							"#emp_update_type").attr("current-serial"));

		},
		complete : function(e) {
			if ($("#emp_resigned_update_page").val() != "") {
				AddToResignedEMp($("#emp_resigned_update_page").val(), $(
						"#emp_id_update_page").val(), $(
						"#emp_resigned_resaon_update_page").val(), $(
						"#emp_name_update_page").val());
			}

			$.unblockUI();
			globalobj.returnSuccess();
		}
	});
}

function UpdateEmployeeInfoWithTM() {
	$.ajax({
		type : "POST",
		url : "auctmi",
		data : "{\"emp_id\": \"" + $("#emp_id_update_page").val() + "\","
				+ "\"tm_id\": \"" + $("#emp_curre_tm_id_update_page").val()
				+ "\"," + "\"emp_is_new\": \"0" + "\"," + "\"new_tm_id\": \""
				+ $("#emp_trans_tm_update").val() + "\","
				+ "\"new_start_date\": \"" + $("#emp_next_tm_start_date").val()
				+ "\"," + "\"curr_end_date\": \""
				+ $("#emp_end_date_update").val() + "\","
				+ "\"cur_start_date\": \"" + $("#emp_start_date_update").val()
				+ "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {

		}
	});
}

function ReturnIfTraining() {
	var isTraining = "0";
	if ($("#emp_is_training_field").is(":checked")) {
		isTraining = "1";
	}
	return isTraining;
}

function ShowHistoricalData() {
	var data = "";
	$
			.ajax({
				type : "POST",
				url : "gtmhd",
				data : "{\"emp_id\": \"" + globalobj.GetEmployeeId() + "\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					data = data + "<thead><tr class='boldit'>";
					data = data + "<th>Team Manager</th>";
					data = data + "<th>Start Date</th>";
					data = data
							+ "<th>End Date</th><th>Delete</th></tr></thead><tbody>";
					for (var int = 0; int < resultsArray.length; int++) {
						data = data + "<tr id='tmhistoricaldata_"
								+ resultsArray[int].emp_tm_serial_mapping
								+ "'>";
						data = data
								+ "<td><input style='disabled : true; width: 60%' type='text' id='manager_name' value='"
								+ resultsArray[int].tm_name + "'/></td>";
						data = data
								+ "<td><input type='text' class='datepick' id='emp_tm_start_date_historical_"
								+ resultsArray[int].emp_tm_serial_mapping
								+ "' value='"
								+ resultsArray[int].emp_tm_start_date
								+ "' /></td>";
						data = data
								+ "<td><input type='text' class='datepickend' id='emp_tm_end_date_historical_"
								+ resultsArray[int].emp_tm_serial_mapping
								+ "' value='"
								+ resultsArray[int].emp_tm_end_date
								+ "' /></td>";
						data = data
								+ "<td><a href='javascript:void(0)' onclick='DeleteHistoricalDataThatConflicts(\""
								+ resultsArray[int].emp_tm_serial_mapping
								+ "\")'><img style='size: x-small' src=\"img/trash24x24.png\" /></a></td></tr>";
					}
					$("#historical_table").append(data + "</tbody>");
				},
				complete : function(e) {
					$(".datepick").each(
							function() {
								var id = $(this).attr("id").substring(29);
								$(this).datepicker(
										{
											changeMonth : true,
											numberOfMonths : 1,
											dateFormat : 'yy-mm-dd',
											changeYear : true,
											onClose : function(dateText, inst) {
												UpdateHistoricaldata(id, $(
														"#emp_tm_start_date_historical_"
																+ id).val(), $(
														"#emp_tm_end_date_historical_"
																+ id).val());
											}
										});
							});
					$(".datepickend").each(
							function() {
								alert($(this));
								var ids = $(this).attr("id").substring(27);
								$(this).datepicker(
										{
											changeMonth : true,
											numberOfMonths : 1,
											dateFormat : 'yy-mm-dd',
											changeYear : true,
											onClose : function(dateText, inst) {
												UpdateHistoricaldata(ids, $(
														"#emp_tm_start_date_historical_"
																+ ids).val(),
														$(
																"#emp_tm_end_date_historical_"
																		+ ids)
																.val());
											}
										});
							});

					$("#historical_table").dataTable({
						"columns" : [ {
							"width" : "40%"
						}, {
							"width" : "20%"
						}, {
							"width" : "20%"
						}, {
							"width" : "20%"
						} ]
					});
					$("#historical_table td,th").css("text-align", "center");

				}
			});
}
function returnPresentText(text) {
	var newtext = "";
	if (text == "" || text == null) {
		newtext = "Present";
	}

	return newtext;
}

function ReturnPresent(id) {

	if ((id).val() == "" || (id).val() == null) {
		(id).attr("placeholder", "Present: YYYY-MM-DD");
	}
}

function UpdateEmployeeInfoWithWG() {
	$.ajax({
		type : "POST",
		url : "aucwgi",
		data : "{\"emp_id\": \"" + $("#emp_id_update_page").val() + "\","
				+ "\"wgName\": \"" + $("#emp_curr_wg_update_page").val()
				+ "\"," + "\"new_wg_name\": \"" + AddQuickNewWG() + "\","
				+ "\"emp_is_new\": \"0\"," + "\"new_start_date\": \""
				+ $("#emp_next_wg_start_date").val() + "\","
				+ "\"curr_end_date\": \"" + $("#emp_curr_wg_end_date").val()
				+ "\"," + "\"cur_start_date\": \""
				+ $("#emp_curr_wg_start_date").val() + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		}
	});
}
function UpdateEmployeeInfoWithNewWG() {

	$.ajax({
		type : "POST",
		url : "aucwgi",
		data : "{\"emp_id\": \"" + $("#emp_id_update_page").val() + "\","
				+ "\"wgName\": \"" + $("#emp_curr_wg_update_page").val()
				+ "\"," + "\"new_wg_name\": \"" + AddQuickNewWG() + "\","
				+ "\"emp_is_new\": \"0\"," + "\"new_start_date\": \""
				+ ReturnWgStartDate() + "\"," + "\"curr_end_date\": \""
				+ dateToday + "\"," + "\"cur_start_date\": \""
				+ $("#emp_curr_wg_start_date").val() + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			addNewWg = "Added";
		}
	});
}

function GetWorkgRoupHistory(emp_id) {
	var data = "";
	$
			.ajax({
				type : "POST",
				url : "gcwdps",
				data : "{\"emp_id\": \"" + emp_id + "\",\"is_latest\":\"no\"}",
				contentType : "application/x-www-form-urlencoded",
				dataType : "json",
				success : function(response) {
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					data = data + "<thead><tr class='boldit'>";
					data = data + "<th>Work Group</th>";
					data = data + "<th>Start Date</th>";
					data = data + "<th>End Date</th>";

					data = data + "<td>Delete</td>" + "</tr></thead><tbody>";
					for (var int = 0; int < resultsArray.length; int++) {
						data = data + "<tr id='wghistoricaldata_"
								+ resultsArray[int].serial_emp_wg_mapping
								+ "'>";

						data = data
								+ "<td><input type='text' disabled='true' value='"
								+ resultsArray[int].wg_names + "' /></td>";
						data = data + "<td><input type='text' id='wghs_start_date_" + resultsArray[int].serial_emp_wg_mapping + "' class='wghs-start' value='" + resultsArray[int].start_date
								+ " '/></td>";
						data = data + "<td><input type='text' id='wghs_end_date_" + resultsArray[int].serial_emp_wg_mapping + "' class='wghs-end' value='" + resultsArray[int].end_date
								+ "' /></td>";
						data = data
								+ "<td><a href='javascript:void(0)' onclick='DeleteHistoricalWgDataThatConflicts(\""
								+ resultsArray[int].serial_emp_wg_mapping
								+ "\")'><img style='size: x-small' src=\"img/trash24x24.png\" /></a></td></tr>";
					}
					$("#historical_wg_table").append(data + "</tbody>");
				},
				complete : function(e) {
					
					$(".wghs-start").each(
							function() {
								var id = $(this).attr("id").substring(16);
								
								$(this).datepicker(
										{
											
											changeMonth : true,
											numberOfMonths : 1,
											dateFormat : 'yy-mm-dd',
											changeYear : true,
											onClose : function(dateText, inst) {
												UpdateWgHistoricaldata(id, $("#wghs_start_date_"+ id).val(), $("#wghs_end_date_"+ id).val());
												console.log($(this).attr("id"));
											}
										});
							}); 
					$(".wghs-end").each(
							function() {
								var ids = $(this).attr("id").substring(14);
								$(this).datepicker(
										{
											changeMonth : true,
											numberOfMonths : 1,
											dateFormat : 'yy-mm-dd',
											changeYear : true,
											onClose : function(dateText, inst) {
												UpdateWgHistoricaldata(ids, $("#wghs_start_date_"+ ids).val(),$("#wghs_end_date_"+ ids).val());
											}
										});
							});
					$("#historical_wg_table").dataTable({
						"columns" : [ {
							"width" : "40%"
						}, {
							"width" : "20%"
						}, {
							"width" : "20%"
						}, {
							"width" : "20%"
						} ]
					});
					$("#historical_wg_table td,th").css("text-align", "center");
				}
			});
}

function GetCurrentWG(emp_id) {
	$.ajax({
		type : "POST",
		url : "gcwdps",
		data : "{\"emp_id\": \"" + emp_id + "\",\"is_latest\":\"yes\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			$("#emp_curr_wg_update_page").val(resultsArray[0].wg_names);
			$("#emp_curr_wg_start_date").val(resultsArray[0].start_date);
			ReturnPresent($("#emp_curr_wg_end_date").val(
					resultsArray[0].end_date));
		}
	});

}

function GetProdFamList(emp_prod_fam) {
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
					$("#emp_prod_family_update_page").html("");
					var resultsArray = (typeof response) == 'string' ? eval('('
							+ response + ')') : response;
					for (var i = 0; i < resultsArray.length; i++) {
						if (emp_prod_fam == resultsArray[i].product_family_name) {
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
					$("#emp_prod_family_update_page").append(data);
				}
			});

}
function GetCenterList(emp_center_list) {
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
			$("#emp_center_update_page").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				if (emp_center_list == resultsArray[i].lang_center_name) {
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
			$("#emp_center_update_page").append(data);
		}
	});
}

function GetLocationList(emp_location_list) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getloclist"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#emp_location_update_page").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (var i = 0; i < resultsArray.length; i++) {

				if (emp_location_list == resultsArray[i].location_name) {
					data = data + "<option selected value='"
							+ resultsArray[i].location_name + "'>"
							+ resultsArray[i].location_name + "</option>";
				} else {
					data = data + "<option value='"
							+ resultsArray[i].location_name + "'>"
							+ resultsArray[i].location_name + "</option>";
				}
			}
		},
		complete : function(e) {
			$("#emp_location_update_page").append(data);
		}
	});
}
function ReturnEmptype(emp_type) {
	$("#emp_update_type").val(emp_type);
}

function ShowUpdateTrainingDates() {
	$("#training_dates_update_row").hide();
	$("#emp_update_type").change(function() {
		switch ($(this).val()) {
		case "Training":
			$("#training_dates_add_row").show();
			$("#leave_row").hide();
			$("#contractual_dates_add_row").hide();
			break;
		case "Contractual":
			$("#contractual_dates_add_row").show();
			$("#leave_row").hide();
			$("#training_dates_add_row").hide();
			break;
		case "Leave":
			$("#leave_row").show();
			$("#training_dates_add_row").hide();
			$("#contractual_dates_add_row").hide();
			break;
		case "Permanent":
			$("#training_dates_add_row").hide();
			$("#leave_row").hide();
			$("#contractual_dates_add_row").hide();
			break;
		default:
			$("#training_dates_add_row").hide();
			$("#leave_row").hide();
			$("#contractual_dates_add_row").hide();

			break;
		}
	});
}
function GetUpdatePortalRoles(role) {
	$("#emp_update_portal_role").html("");
	var data = "";
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\":\"\",\"signature\":\"getportalroles\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				if (resultsArray[i].portal_role_name != role) {
					data = data + "<option value='"
							+ resultsArray[i].portal_role_name + "'>"
							+ resultsArray[i].portal_role_name + "</option>";
				} else {
					data = data + "<option value='"
							+ resultsArray[i].portal_role_name + "' selected>"
							+ resultsArray[i].portal_role_name + "</option>";
				}
			}
			$("#emp_update_portal_role").append(data);
		},
		complete : function(e) {

		}
	});
}

function AddQuickNewTM() {
	var tmVal = $("#emp_curre_tm_id_update_page").val();
	if ((updateCounterTM % 2) == 0) {

		tmVal = $("#update_quick_tm_number").val();
	} else {
		if ($("#tm_chk_box").is(":checked") == true) {

			tmVal = $("#emp_trans_tm_update").val();
		}

	}
	if (tmVal == "") {
		tmVal = $("#emp_curre_tm_id_update_page").val();
	}
	return tmVal;
}

function AddQuickNewWG() {
	var wgVal = $("#emp_curr_wg_update_page").val();
	if ((updateCounterWG % 2) == 0) {
		wgVal = $("#update_quick_wg_name").val();
	} else {
		if ($("#wg_chk_box").is(":checked")) {
			wgVal = $("#emp_trans_wg_update").val();
		}
	}
	return wgVal;
}
function AddNewWG1() {

	if ((updateCounterWG % 2) == 0) {
		if (addNewWg == "") {
			AddWgInfo($("#update_quick_wg_psm").val(), $(
					"#emp_prod_family_update_page").val(), $(
					"#emp_center_update_page").val(),
					$("#update_quick_wg_name").val(), '0');
			UpdateEmployeeInfoWithNewWG();
		}
	}
}

function ReturnTmStartDate() {
	var tmStartDate = $("#emp_start_date_update").val();
	if ((updateCounterTM % 2) == 0) {
		tmStartDate = $("#update_quick_tm_hired_date").val();
	} else {
		if ($("#wg_chk_box").is(":checked")) {
			tmStartDate = $("#emp_next_wg_start_date").val();
		}
	}
	return tmStartDate;
}

function ReturnWgStartDate() {
	var wgStartDate = $("#emp_curr_wg_start_date").val();
	if ((updateCounterWG % 2) == 0) {
		wgStartDate = $("#update_quick_psm_start_date").val();
	} else {
		if ($("#wg_chk_box").is(":checked")) {
			wgStartDate = $("#emp_next_wg_start_date").val();
		}
	}

	return wgStartDate;
}
function AddWgInfo(psmName, prodFamName, langCenterName, wgName, wgTargetHC) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + psmName + "\",signature:\"" + "addwginfo"
				+ "\",prodFamName:\"" + prodFamName + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + langCenterName
				+ "\",langCenterDesc:\"" + "" + "\",wgName:\"" + wgName
				+ "\",wgId:\"" + "" + "\",wgTargetHC:\"" + wgTargetHC
				+ "\",wgWfHC:\"" + '0' + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			AddWorkGroupTM(AddQuickNewTM(), wgName);
			globalobj.returnSuccess();
		}
	});
}
function AddWorkGroupTM(tmId, workgroupName) {
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "addtmwg"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\""
				+ ReturnTmStartDate() + "\",langCenterName:\"" + ""
				+ "\",langCenterDesc:\"" + "" + "\",wgName:\"" + workgroupName
				+ "\",wgId:\"" + tmId + "\",wgTargetHC:\"" + ""
				+ "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
		},
		complete : function(e) {

		}
	});

}
function GetPSMListForUpdate() {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getpsmlist"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#update_quick_wg_psm").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {

				data = data + "<option value='" + resultsArray[i].psm_name
						+ "'>" + resultsArray[i].psm_name + "</option>";
			}
		},
		complete : function(e) {
			$("#update_quick_wg_psm").append(data);
		}
	});
}

function GetEmpPsmMapping(empId) {
	var data = "";
	var psmVal = "";
	$.ajax({
		type : "POST",
		async : false,
		url : "emptypecntrl",
		data : "{\"signature\":\"getpsmempmapping\",\"emp_id\":\"" + empId
				+ "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#update_quick_wg_psm").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				psmVal = resultsArray[0].psm_id;
			}
		},
		complete : function(e) {
			RenderEmpPsmMapping(psmVal);
		}
	});
}

function RenderEmpPsmMapping(psmId) {
	var data = "";
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "getpsmlist"
				+ "\",prodFamName:\"" + "" + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + "" + "\",langCenterDesc:\"" + ""
				+ "\",wgName:\"" + "" + "\",wgId:\"" + "" + "\",wgTargetHC:\""
				+ "" + "\",wgWfHC:\"" + "" + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			$("#update_quick_wg_psm").html("");
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				if (resultsArray[i].psm_employee_number != psmId) {
					data = data + "<option value='"
							+ resultsArray[i].psm_employee_number
							+ "' psm-email='" + resultsArray[i].psm_email
							+ "'>" + resultsArray[i].psm_name + "</option>";
				} else {
					data = data + "<option selected='selected' value='"
							+ resultsArray[i].psm_employee_number + "' >"
							+ resultsArray[i].psm_name + "</option>";
					$("#emp_psm_properties").attr("psm-id",
							resultsArray[i].psm_employee_number);
					$("#emp_psm_properties").attr("psm-email",
							resultsArray[i].psm_email);
					$("#emp_psm_properties").attr("psm-name",
							resultsArray[i].psm_name);

				}

			}
		},
		complete : function(e) {
			$("#emp_psm_update").append(data);
		}
	});

}
function UpdateEmpPsmMapping(empId, psmId, psmName, psmEmail) {
	globalobj.ShowLoadingPage();
	alert('called');
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updateemppsmmapping\",\"emp_id\":\"" + empId
				+ "\",\"psm_id\":\"" + psmId + "\",\"psm_name\":\"" + psmName
				+ "\",\"psm_email\":\"" + psmEmail + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			$.unblockUI();
			alert("test");
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

		},
		complete : function(e) {
			globalobj.returnSuccess();
		}
	});
}
function AddToResignedEMp(resDate, empId, reason, empName) {
	$.ajax({
		type : "POST",
		url : "ProdFamily",
		data : "{\"wgPSM\":\"" + "\",signature:\"" + "addtoresignedemployees"
				+ "\",prodFamName:\"" + resDate + "\",prodFamId:\"" + ""
				+ "\",prodFamDesc:\"" + "" + "\",langCenterId:\"" + ""
				+ "\",langCenterName:\"" + empName + "\",langCenterDesc:\""
				+ "" + "\",wgName:\"" + "" + "\",wgId:\"" + empId
				+ "\",wgTargetHC:\"" + "" + "\",wgWfHC:\"" + reason + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {

		}
	});
}

function GetLeaveDate() {

}

function UpdateLeaveDate() {

}

function AddQADefaultTargetScore(tmName, tmId, empName, empId, reqType,
		reqSubType, sDate, eDate, quarter, imp360Status, reportingStatus,
		reqStatus, reasonTm, prevScore, currScore, reqDate, isCurrentRecord,
		reqWeekNo, approvalWeekNo, reqOrder) {
	$.ajax({
		type : "POST",
		url : "qctrl",
		data : "{\"signature\":\"adddefaultqaScore\"," + "\"tmName\":" + "\""
				+ tmName + "\"," + "\"tmId\":" + "\"" + tmId + "\","
				+ "\"empName\":" + "\"" + empName + "\"," + "\"empId\":" + "\""
				+ empId + "\"," + "\"reqType\":" + "\"" + reqType + "\","
				+ "\"reqSubType\":" + "\"" + reqSubType + "\"," + "\"sDate\":"
				+ "\"" + sDate + "\"," + "\"eDate\":" + "\"" + eDate + "\","
				+ "\"quarter\":" + "\"" + quarter + "\"," + "\"imp360Status\":"
				+ "\"" + imp360Status + "\"," + "\"reportingStatus\":" + "\""
				+ reportingStatus + "\"," + "\"reqStatus\":" + "\"" + reqStatus
				+ "\"," + "\"reasonTm\":" + "\"" + reasonTm + "\","
				+ "\"prevScore\":" + "\"" + prevScore + "\","
				+ "\"currScore\":" + "\"" + currScore + "\"," + "\"reqDate\":"
				+ "\"" + reqDate + "\"," + "\"isCurrentRecord\":" + "\""
				+ isCurrentRecord + "\"," + "\"reqWeekNo\":" + "\"" + reqWeekNo
				+ "\"," + "\"approvalWeekNo\":" + "\"" + approvalWeekNo + "\","
				+ "\"qm_year\":" + "\"" + globalobj.GetYear() + "\","
				+ "\"wgName\":" + "\"" + AddQuickNewWG() + "\","

				+ "\"evalId\":" + "\"" + tmId + "\"," + "\"evalName\":" + "\""
				+ tmName + "\","

				+ "\"reqOrder\":" + "\"" + reqOrder + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
		},
		complete : function(e) {
			ReturnLastID(tmId, currScore, empId);
			globalobj.returnSuccess();
		}
	});

}
// type,agentName, start_date, newTarget, quarter, year,tmNames
function EmailTm(type, agentName, start_date, newTarget, quarter, year,
		tmNames, category) {
	if (category == "addpermanent") {
		$.ajax({
			type : "POST",
			url : "EmailToTm",
			data : "{\"signature\":\"" + "toTMFromEmployeeUpdate\""
					+ ",\"type\":\"" + type + "\",\"agentName\":\"" + agentName
					+ "\",\"start_date\":\"" + start_date
					+ "\",\"newTarget\":\"" + newTarget + "\",\"quarter\":\""
					+ quarter + "\",\"year\":\"" + year + "\",\"tmNames\":\""
					+ tmNames + "\"" +

					"}",
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				for (var i = 0; i < resultsArray.length; i++) {
					$("#tag_as_permanent").val(resultsArray[0].permanenttag);
				}
			},
			complete : function(e) {
				AddQADefaultTargetScore(TmNameForQuality(), AddQuickNewTM(), $(
						"#emp_name_update_page").val(),
						$("#emp_id_update_page").val(), "New", "target", "",
						"", globalobj.GetQuarterOftheMonth(), "New", "New",
						"unread", "Added To " + TmNameForQuality()
								+ " ,Done Training", $("#emp_trans_new_target")
								.val(), $("#emp_trans_new_target").val(),
						dateToday, "1", GetWeekNumber(), "", "submitted");
			}
		});
	} else {
		$.ajax({
			type : "POST",
			url : "EmailToTm",
			data : "{\"signature\":\"" + "SendToTmFRomTransferHead\""
					+ ",\"type\":\"" + type + "\",\"agentName\":\"" + agentName
					+ "\",\"start_date\":\"" + start_date
					+ "\",\"newTarget\":\"" + newTarget + "\",\"quarter\":\""
					+ quarter + "\",\"year\":\"" + year + "\",\"tmNames\":\""
					+ tmNames + "\"" +

					"}",
			contentType : "application/x-www-form-urlencoded",
			dataType : "json",
			success : function(response) {
				var resultsArray = (typeof response) == 'string' ? eval('('
						+ response + ')') : response;
				for (var i = 0; i < resultsArray.length; i++) {
					$("#tag_as_permanent").val(resultsArray[0].permanenttag);
				}
			},
			complete : function(e) {
				AddQADefaultTargetScore(TmNameForQuality(), AddQuickNewTM(), $(
						"#emp_name_update_page").val(),
						$("#emp_id_update_page").val(), "New", "target", "",
						"", globalobj.GetQuarterOftheMonth(), "New", "New",
						"unread", "Transferred From "
								+ $("#emp_curre_tm_update_page").val(), $(
								"#emp_trans_new_target").val(), $(
								"#emp_trans_new_target").val(), dateToday, "1",
						GetWeekNumber(), "", "submitted");
			}
		});
	}
}

function GetQatagAsPermanent(employeeId) {
	$.ajax({
		type : "POST",
		url : "qctrl",
		data : "{\"empId\":\"" + employeeId + "\",\"signature\":\""
				+ "getqastatus\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				$("#tag_as_permanent").val(resultsArray[0].permanenttag);
			}
		},
		complete : function(e) {

		}
	});
}

function TagAsPermanent(id, status, date) {
	$.ajax({
		type : "POST",
		url : "qctrl",
		data : "{\"empId\":\"" + id + "\",\"signature\":\""
				+ "tagaspermanent\",\"tag_date\":\"" + date + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
		},
		complete : function(e) {
			EmailRosterChange("addpermanent");
		}
	});
}

function GetQuarterOftheMonth(idDates, currentQuart) {
	var currentMonth = 0;
	var quarter = 0;

	if (idDates == "") {
		currentMonth = $("#" + idDates).datepicker("getDate").getMonth();
		quarter = Math.floor(((currentMonth + 11) / 3) % 4) + 1;
	} else {
		currentMonth = (new Date()).getMonth();
		quarter = Math.floor(((currentMonth + 11) / 3) % 4) + 1;
	}

	return quarter;
}

function GetWeekNumber() {

	return $.datepicker.iso8601Week(new Date());

}

function TmNameForQuality() {
	var tmname = $('#emp_trans_tm_update option:selected').text(); //
	if ((updateCounterTM % 2) == 0) {
		tmname = $("#update_quick_tm_fname").val() + " "
				+ $("#update_quick_tm_lname").val();
	}
	if (tmname == "") {
		tmname = $("#emp_curre_tm_update_page").val();
	}
	return tmname;

}

function ReturnTmName() {
	var tmName = $("#emp_curre_tm_update_page").val();
	if ((updateCounterTM % 2) == 0) {
		tmName = $("#update_quick_tm_fname").val() + " "
				+ $("#update_quick_tm_lname").val();
	}
	return tmName;
}

function ShowStartEndDates() {
	$("#emp_update_type").change(function() {
		setIstraining($(this).val());
	});
}

function StoreCurrentStatus(currentVal, sDate, eDate, serialID) {
	$("#emp_update_type").attr("current-value", currentVal);
	$("#emp_update_type").attr("current-start-date-value", sDate);
	$("#emp_update_type").attr("current-end-date-value", eDate);
	$("#emp_update_type").attr("current-serial", serialID);
}

function GetCurrentStatus(currentVal) {
	$.ajax({
		type : "POST",
		url : "qctrl",
		data : "{\"signature\":\"getcurrentempstat\",\"currstat\":\""
				+ currentVal + "\"}",
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

function AddPromoted(emp_id, sDate, taleoNo, position) {

	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\": \"" + emp_id + "\",\"sDate\": \"" + sDate
				+ "\",\"taleo\": \"" + taleoNo + "\",\"signature\":\""
				+ "addempattrib" + "\",\"position\":\"" + position + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			if (position == "Team Manager") {
				PromoteToTm($("#emp_name_update_page").val(), emp_id, $(
						"#emp_email_update_page").val(), dateToday);
			}
		}
	});
}

function GetEmployeeAttribute(empId) {

	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\":\"" + empId
				+ "\",\"signature\":\"getdetailattribute\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				$("#emp_start_training_update_page").val(
						resultsArray[i].start_date);
				$("#emp_end_training_update_page")
						.val(resultsArray[i].end_date);
				StoreCurrentStatus(resultsArray[0].type,
						resultsArray[0].start_date, resultsArray[0].end_date,
						resultsArray[0].historical_serial_id);
			}

		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}

// TO DO: 3-17-2015

function isUpdate(empId, sDate, eDate, type, subType, serialId) {

	globalobj.ShowLoadingPage();

	if ($("#emp_update_type").val() == $("#emp_update_type").attr(
			"current-value")) {

		UpdateEmployeeAttribute(empId, serialId, sDate, eDate);
	} else {

		MakeAttributeHistorical(empId, sDate, eDate, type, subType);

	}

}

function UpdateEmployeeAttribute(empId, serialId, sDate, eDate) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\":\"" + empId + "\"," + "\"serial_id\":\"" + serialId
				+ "\",\"sDate\":\"" + sDate + "\"," + "\"eDate\":\"" + eDate
				+ "\"," + "\"signature\":\"updateattribute\"}",
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

function AddEmployeeAttribute(empId, sDate, eDate, type, subType) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\":\"" + empId + "\",\"sDate\":\"" + sDate
				+ "\",\"subType\":\"" + subType + "\",\"eDate\":\"" + eDate
				+ "\",\"type\":\"" + type
				+ "\",\"signature\":\"addtotablestatus\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}

function MakeAttributeHistorical(empId, sDate, eDate, type, subType) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "empcontroller",
		data : "{\"emp_id\":\"" + empId
				+ "\",\"signature\":\"makeattributehistorical\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			AddEmployeeAttribute(empId, sDate, eDate, type, subType);
			$.unblockUI();
		}
	});
}

function PromoteToTm(tmName, employeeId, tmEmail, hiredDate) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "tmrequest",
		data : "{\"signature\":\"addtminfo\"" + "," + "\"tmname\":\"" + tmName
				+ "\"" + "," + "\"tmId\":\"" + employeeId + "\"" + ","
				+ "\"tm_is_active\":\"" + "1" + "\"" + ","
				+ "\"tm_wg_name\":\"" + "" + "\"" + ","
				+ "\"tm_wg_start_date\":\"" + "" + "\"" + ","
				+ "\"hiredDate\":\"" + hiredDate + "\","
				+ "\"tm_wg_end_date\":\"" + "" + "\"" + "," + "\"tmEmail\":\""
				+ tmEmail + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			addTMWgInfo(AddQuickNewWG(), dateToday, "", employeeId);
			$.unblockUI();
		}
	});
}

function AddNewTargetViaRosterChange() {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "tmrequest",
		data : "{\"signature\":\"addtminfo\"" + "," + "\"tmname\":\"" + tmName
				+ "\"" + "," + "\"tmId\":\"" + employeeId + "\"" + ","
				+ "\"tm_is_active\":\"" + "1" + "\"" + ","
				+ "\"tm_wg_name\":\"" + "" + "\"" + ","
				+ "\"tm_wg_start_date\":\"" + "" + "\"" + ","
				+ "\"hiredDate\":\"" + hiredDate + "\","
				+ "\"tm_wg_end_date\":\"" + "" + "\"" + "," + "\"tmEmail\":\""
				+ tmEmail + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {

			$.unblockUI();
		}
	});
}
function EmailRosterChange(category) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "QaTmCtrl",
		data : "{\"signature\":\"updatetohistoricaldata\",\"empId\":\""
				+ $("#emp_id_update_page").val() + "\",\"reqSubType\":\""
				+ "target" + "\",\"dec_type\": \"3\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

		},
		complete : function(e) {
			EmailTm("", $("#emp_name_update_page").val(), globalobj.dateToday,
					GetQuarterTargets($("#emp_id_update_page").val(),
							AddQuickNewTM(), globalobj.GetQuarterOftheMonth("",
									""), globalobj.GetYear(), "target"),
					globalobj.GetQuarterOftheMonth("", ""),
					globalobj.GetYear(), TmNameForQuality(), category);
			$.unblockUI();
			globalobj.returnSuccess();
		}
	});

}

function GetQuarterTargets(empId, tmId, quarter, year, reqsubtype) {
	globalobj.ShowLoadingPage();
	var currentTarget = "";
	$.ajax({
		type : "POST",
		url : "QaTmCtrl",
		async : false,
		data : "{\"signature\":\"gettargets\",\"empId\":\"" + empId
				+ "\",\"tmId\":\"" + tmId + "\",\"quarter\":\"" + quarter
				+ "\",\"qm_year\":\"" + year + "\",\"reqSubType\":\""
				+ reqsubtype + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			if (resultsArray.length <= 0) {
				currentTarget = "10";
			} else {
				for (var i = 0; i < resultsArray.length; i++) {
					if (resultsArray[0].decision_type == "declined") {

						currentTarget = resultsArray[0].tm_prev_score;
					} else {

						currentTarget = resultsArray[0].tm_current_score;
					}

				}
			}
		},
		complete : function(e) {
			$.unblockUI();
		}
	});

	return currentTarget;

}

function GetPSMEmail(tm_id) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "tmrequest",
		data : "{\"signature\":\"gettmpsmemail\"" + "," + "\"tmId\":\"" + tm_id
				+ "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;
			for (var i = 0; i < resultsArray.length; i++) {
				psmEmail = resultsArray[0].psm_email;
			}
		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}

function EmailPSM(tm_id, psm_email, quarter, year, emp_name, tm_name) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "EmailToTm",
		data : "{\"signature\":\"sendtopsm\"" + "," + "\"tm_id\":\"" + tm_id
				+ "\",\"quarter\":\"" + quarter + "\",\"tmNames\":\"" + tm_name
				+ "\",\"to\":\"" + psm_email + "\",\"year\":\"" + year
				+ "\",\"agentName\":\"" + emp_name + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {

			$.unblockUI();
		}
	});
}

function MakeInterimHistorical(empId) {

	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"historicalinterim\"" + "," + "\"emp_id\":\""
				+ empId + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			if ($("#flip_1").val() == "1") {
				InsertInterim(empId);
			}
			$.unblockUI();
		}
	});
}

function InsertInterim(empId) {

	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"insertinterim\"" + "," + "\"emp_id\":\""
				+ empId + "\"" + "}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {

			$.unblockUI();
		}
	});
}
function updateInterimStatus(emp_id, interimVal) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updateinterrimstatus\"" + ","
				+ "\"emp_id\":\"" + emp_id + "\",\"interimVal\":\""
				+ interimVal + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			MakeInterimHistorical(emp_id);
			$.unblockUI();
		}
	});
}

function UpdateCurrentTmStatus(tm_id, emp_id, start_date, end_date) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updatecurrentemptminfo\"" + ","
				+ "\"emp_id\":\"" + emp_id + "\",\"tm_id\":\"" + tm_id
				+ "\",\"start_date\":\"" + start_date + "\",\"end_date\":\""
				+ end_date + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}
function UpdateCurrentWgStatus(wg_name, emp_id, start_date, end_date) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updatecurrentempwginfo\"" + ","
				+ "\"emp_id\":\"" + emp_id + "\",\"wgname\":\"" + wg_name
				+ "\",\"start_date\":\"" + start_date + "\",\"end_date\":\""
				+ end_date + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}
function DeleteHistoricalDataThatConflicts(historicalId) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"detelethistoricaldata\"" + ","
				+ "\"historicalId\":\"" + historicalId + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			globalobj.returnSuccess();
			$("#tmhistoricaldata_" + historicalId).remove();
			$.unblockUI();
		}
	});
}

function DeleteHistoricalWgDataThatConflicts(historicalId) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"deteletwghistoricaldata\"" + ","
				+ "\"historicalId\":\"" + historicalId + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			globalobj.returnSuccess();
			$("#wghistoricaldata_" + historicalId).remove();
			$.unblockUI();
		}
	});
}

function UpdateHistoricaldata(serialId, startDate, endDate) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updatehistoricalinfo\"" + ","
				+ "\"historicalId\":\"" + serialId + "\",\"start_date\":\""
				+ startDate + "\",\"end_date\":\"" + endDate + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}

function UpdateWgHistoricaldata(serialId, startDate, endDate) {
	globalobj.ShowLoadingPage();
	$.ajax({
		type : "POST",
		url : "emptypecntrl",
		data : "{\"signature\":\"updatewghistoricalinfo\"" + ","
				+ "\"historicalId\":\"" + serialId + "\",\"start_date\":\""
				+ startDate + "\",\"end_date\":\"" + endDate + "\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {
			
		},
		complete : function(e) {
			$.unblockUI();
		}
	});
}
function addToEvaluationTable(lastInsertedId, evalId, target, employeeId) {
	$.ajax({
		type : "POST",
		url : "evalcntrl",
		data : "{\"signature\":\"addevaluatortarget\"" + ",\"evalSerialId\":\""
				+ lastInsertedId + "\"" + ",\"evalId\":\"" + evalId + "\""
				+ ",\"target\":\"" + target + "\",\"employeeId\":\""
				+ employeeId + "\"}",
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
function ReturnLastID(tmId, target, employeeId) {
	$.ajax({
		type : "POST",
		url : "evalcntrl",
		data : "{\"signature\":\"getlatestId\"}",
		contentType : "application/x-www-form-urlencoded",
		dataType : "json",
		success : function(response) {

			var resultsArray = (typeof response) == 'string' ? eval('('
					+ response + ')') : response;

			for (var i = 0; i < resultsArray.length; i++) {
				addToEvaluationTable(resultsArray[0].lastInsertedId, tmId,
						target, employeeId);
			}

		},
		complete : function(e) {

		}
	});

}