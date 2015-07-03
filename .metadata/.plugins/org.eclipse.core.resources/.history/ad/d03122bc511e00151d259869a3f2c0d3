<!-- Main Page  -->
<!-- Coded By MarAngelo -->
<!-- Coded Year 2014 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en-GB">
<head>
<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/foundation/5.4.7/css/foundation.min.css">
	<link rel="stylesheet" type="text/css" href="dataTables.foundation.css">
		<link rel="shortcut icon" type="image/x-icon"
			href="img/Gnome-Stock-Person-64.ico">
			<link href="js/index.css" rel="stylesheet" type="text/css" />

			<link rel="apple-touch-icon-precomposed"
				href="img/Gnome-Stock-Person-64.ico" />
			<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
  
			<script type="text/javascript"
				src="js/DataTables-1.10.2/media/js/jquery.js"></script>

			<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
			<script type="text/javascript"
				src="js/jquery-ui-1.9.1/ui/minified/jquery-ui.min.js"></script>

			<script type="text/javascript"  
				src="js/jquery-ui-1.9.1/ui/jquery.ui.core.js"></script>
			<script type="text/javascript"
				src="js/jquery-ui-1.9.1/ui/jquery.ui.widget.js"></script>
			<script type="text/javascript"
				src="js/jquery-ui-1.9.1/ui/jquery.ui.datepicker.js"></script>
			<script type="text/javascript"
				src="js/DataTables-1.10.2/media/js/jquery.dataTables.js"></script>
			<script type="text/javascript" src="js/blockui/blockui.js"></script>
			<script type="text/javascript" src="modules/com.global.obj.js"></script>

			<script type="text/javascript" src="js/ios/js/modernizr-2.0.6.min.js"></script>
			<script type="text/javascript" src="js/ios/js/prettify.js"></script>
			<script type="text/javascript" src="js/ios/js/iosOverlay.js"></script>


			<link href="js/DataTables-1.10.2/media/css/jquery.dataTables.css"
				type="text/css" rel="stylesheet" />

			<link href="js/jquery-ui-1.9.1/themes/base/jquery-ui.css"
				rel="stylesheet" type="text/css" />


			<link href="js/ios/css/custom.css" rel="stylesheet" type="text/css" />
			<link href="js/ios/css/iosOverlay.css" rel="stylesheet"
				type="text/css" />
			<link rel="stylesheet"
				href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css"></link>
			<script type="text/javascript"
				src="js/FusionChartsFree/JSClass/FusionCharts.js"></script>

			<script type="text/javascript"
				src="js/jquery-validation-1.13.1/dist/jquery.validate.min.js"></script>
			<script type="text/javascript"
				src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
			<script type="text/javascript">
				var globalobj = new GlobalObjects();

				$(document)['ready']

						(function() {//0153903//mar
							//0122467//tan//0151217

							CountNewRequest();
							//SetSecurity(localStorage.getItem("0b8b667e7722bc7e363b601ce584259d"));	
							SetSecurity("6016812");//0122467
							globalobj.ShowLoadingPage();
							$("#loadCharts_btn").hide();
							$("#load_employees").hide();
							$("#load_workgroups").hide();
							$("#load_qm_reports").hide();
							$("#load_qm_target").hide();
							$("#qa_eval").hide();
							$("#load_tms").hide();
							$("#qa_links").hide();
							$("#mgt_qa_link").hide();
							$("#wf_rep_links").hide();
							$("#qa_evaluators").hide();

							$("#content").attr("height", $(document).height());
							$('#qa_links').click(function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vqmtmd');
								return false;
							});
							$("#wf_rep_links").click(function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/reports');
								return false;
							});
							$('#mgt_qa_link').click(function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vtmqalist');
								return false;
							});
							$('#load_employees').click(function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vssc');
								return false;
							});
							$('#load_scores_per_tm')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/ustm');
								return false;
							});
							$('#load_tms')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vtml');
								return false;
							});
							$('#load_workgroups')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vwgl');
								return false;
							});
							$('#load_admin')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vadp');
								return false;
							});//
							$('#load_qm_reports')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/qmreports');
								return false;
							});

							$('#load_qm_target')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/vqmft');
								return false;
							});
							$('#qa_evaluators')['click'](function() {
								globalobj.ShowLoadingPage();
								$('#content')['load']('view/evaluators');
								return false;
							});
							function SetSecurity(empId) {

								var data = "";
								$
										.ajax({
											type : "POST",
											url : "guaccess",
											data : "{\"emp_id\":\"" + empId
													+ "\"}",
											contentType : "application/x-www-form-urlencoded",
											dataType : "json",
											success : function(response) {

												var resultsArray = (typeof response) == 'string' ? eval('('
														+ response + ')')
														: response;
												for (var i = 0; i < resultsArray.length; i++) {
													localStorage
															.setItem(
																	"29a7e96467b69a9f5a93332e29e9b0de",
																	resultsArray[0].a);
													localStorage
															.setItem(
																	"0b8b667e7722bc7e363b601ce584259d",
																	empId);
												}

											},
											complete : function(e) {
												globalobj.userId = empId;
												globalobj.username = empId;
												SetAccessLinks();

											}
										});
							}

						});

				function SetAccessLinks() {
					if (localStorage
							.getItem("29a7e96467b69a9f5a93332e29e9b0de") == "1d0258c2440a8d19e716292b231e3190") {
						$("#load_workgroups").show();
						$("#load_tms").show();
						$(".edit").removeAttr("href");
						$(".edit").attr("style", "background:#a1a1a1");
						$(".edit").unbind();
						$(".edit").off("click", "**");
						$('#content')['load']('view/vtml');
						window.onbeforeunload = before;
						window.onunload = after;
						$("#emp_link").text("All Employees");
						$("#mgt_link").text("My View");
						$("#wg_link").text("My Teams");
						$("#mgt_qa_link").show();
						function before(evt) {
							return "Leaving / Reloading the page will lose any unsave data.";

						}
						function after(evt) {
							//This event fires too fast for the application to execute before the browser unloads
						}
					} else if (localStorage
							.getItem("29a7e96467b69a9f5a93332e29e9b0de") == "d66636b253cb346dbb6240e30def3618") {
						$('#load_qm_reports').show();
						$("#qa_links").show();
						$('#content')['load']('view/vqmtmd');
						$("#load_qm_target").show();
						$("#qa_evaluators").show();
					} else if (localStorage
							.getItem("29a7e96467b69a9f5a93332e29e9b0de") == "b33aed8f3134996703dc39f9a7c95783") {
						alert("You Do not have access to this page!!!");
						window.close();

					} else if ((localStorage
							.getItem("29a7e96467b69a9f5a93332e29e9b0de") == "21232f297a57a5a743894a0e4a801fc3")) {
						$("#loadCharts_btn").show();
						$("#load_employees").show();
						$("#loadCharts_btn").show();
						$("#load_employees").show();
						$("#load_workgroups").show();
						$("#load_tms").show();
						$("#wf_rep_links").show();
						globalobj.loadCharts();
						window.onbeforeunload = before;
						window.onunload = after;
						function before(evt) {
							return "Leaving / Reloading the page will lose any unsave data.";

						}
						function after(evt) {
							//This event fires too fast for the application to execute before the browser unloads
						}
					} else {
						alert("You Do not have access to this page!!!");
						//window.close();
					}
				}

				function CountNewRequest() {
					$
							.ajax({
								type : "POST",
								url : "QaTmCtrl",
								data : "{\"signature\":\"getallnewreqs\"}",
								contentType : "application/x-www-form-urlencoded",
								dataType : "json",
								success : function(response) {

									var resultsArray = (typeof response) == 'string' ? eval('('
											+ response + ')')
											: response;
									for (var i = 0; i < resultsArray.length; i++) {
										if (resultsArray[0].countReqs == 0) {
											$("#qm_new_res").hide();
										} else {
											$("#qm_new_res").text(
													resultsArray[0].countReqs);
										}
									}

								},
								complete : function(e) {

								}
							});

				}
			</script>
</head>
<body>

	<div id="container" class="clearfix" style="width: 100%; height: 100%">

		<div id="header">
			<img src="img/headerhdpr.jpg" style="width: 101%" />
		</div>
		<div id='cssmenu'>

			<ul>
				<li>&nbsp;</li>

				<li><a id="loadCharts_btn" href='javascript:void(0)'
					onclick='globalobj.loadCharts()'><span>Global DashBoard</span></a></li>
				<li><a id="qa_links" href='javascript:void(0)'
					onclick='javascript:void(0)'><span>Quality Managers</span>&nbsp;<span
						id="qm_new_res" class="numberCircle"
						style="padding-right: 5px; padding-left: 5px;"></span></a></li>
				<li><a id="load_qm_reports" href='javascript:void(0)'><span
						id="">Quality Reports</span></a></li>
				<li><a id="load_qm_target" href='javascript:void(0)'><span
						id="">PLOT NEW TARGET</span></a></li>
				<li><a id="load_employees" href='javascript:void(0)'><span
						id="emp_link">Employee</span></a></li>
				<li><a id="load_workgroups" href='javascript:void(0)'><span
						id="wg_link">Workgroups</span></a></li>
				<li><a id="load_tms" href='javascript:void(0)'><span
						id="mgt_link">Managers</span></a></li>
				<li><a id="wf_rep_links" href='javascript:void(0)'><span
						id="wf_rep_link_span">WORK FORCE REPORTS</span></a></li>

				<li><a id="qa_evaluators" href='javascript:void(0)'><span
						id="qa_evaluators_span">EVALUATORS</span></a></li>

				<li><a id="mgt_qa_link" href='javascript:void(0)'><span
						id="">My Tasks</span></a></li>
			</ul>
			<ul>

			</ul>
		</div>

		<div id="content"></div>

	</div>
	<p>&nbsp;</p>
	<div class="footer"></div>
</body>
</html>