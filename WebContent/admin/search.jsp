<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.stx.entity.InTvid,com.stx.entity.OutTvid"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" type="text/css"
	href="/companymgr1/css/search.css">
<meta charset="UTF-8">
<title style="color: ">欢迎来到增值税管理系统</title>
<script type="text/javascript"
	src="/companymgr1/js/echarts.common.min.js"></script>
<script type="text/javascript" src="/companymgr1/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/companymgr1/js/search.js"></script>
<link rel="stylesheet" type="text/css"
	href="/companymgr1/bootstrap/studentInfo.css">
<link href="/companymgr1/bootstrap/css/bootstrap.css" type="text/css"
	rel="stylesheet">
<link href="/companymgr1/bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
<script src="/companymgr1/bootstrap/js/jQuery.js"></script>
<script src="/companymgr1/bootstrap/js/bootstrap.js"></script>
<script src="/companymgr1/js/WdatePicker.js"></script>
<script type="text/javascript">
	var arr;
	var allMonth = [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",
			"十月", "十一月", "十二月" ];
	var invocieType = [ '进项发票', '销项发票' ];
	$(function() {

		$("#queryByDate").click(function() {
			$("#rightbodyQueryAll").hide();
			$('#query-in-and-out').hide();
			$("#rightbody").show();
			$("#rightbody-data").show();//显示分时段查询
			$("#rightbody").css("background-color", "none");

		});
		$("#checkBtn").click(
				function() {
					$.ajax({
						url : "/companymgr1/MyServlet",
						type : "post",
						data : { //向服务器传递数据
							startDate : $("#myForm").find(
									"input[name='startDate']").val(),
							endDate : $("#myForm")
									.find("input[name='endDate']").val(),
							option : $("#invoicetype option:selected").val()
						// $("#invoicetype").find("option :selected").text();
						},
						dataType : "json",
						success : function(data) {
							arr = data;
							var a = new Array();
							console.log(data[0]);
							var showType=$('#invoicetype').find('option:selected').text();
							console.log(showType);
							for (var i = 0; i < arr.length; i++) {
								//a[i]=arr[i].amount;//
								a[arr[i].month - 1] = arr[i].amount;//json数组赋给新的数组,并与月份对应

							}
							console.log(arr);
							console.log(data);
							var dom = document.getElementById("chart");
							var myChart = echarts.init(dom);
							//var app = {};
							option = null;
							option = {
								title : {
									text : '12个月进销项'
								},
								tooltip : {},
								legend : {
									data : [ showType ] 
								},

								xAxis : {
									axisLabel : {
										interval : 0
									},
									data : allMonth
								},
								yAxis : {},
								series : [ {
									name : showType,//发票类型
									type : 'bar',
									data : a  //填充数据
								//添加数据
								},
								/*{
									name : '销项发票',
									type : 'bar',
									data : [ 200, 222, 333, 435, 633,
											612, 203, 234, 230, 165,
											120, 602 ]
								} */]

							};
							if (option && typeof option === "object") {
								myChart.setOption(option, true);
							}
						}
					});
				});
	});
</script>
</head>
<body>
	<div id="all">
		<div id="menu">
			<ul>
				<li><a href="javascript:void(0)" onclick="link()">在线帮助</a></li>
				<li class="menuDiv"></li>
				<li><a href="javascript:void(0)" onclick="link()">联系我们</a></li>
				<li class="menuDiv"></li>
				<li><a href="#">退出</a></li>
				<li class="menuDiv"></li>
			</ul>
		</div>
		<div id="header" style="color: #3C3C3C">
			<div id="logo" style="z-index: 5"></div>
			<div id="light" class="white_content">
				<div id="online">
					<h2 style="color: #FFFFE0">联系人：丑八怪</h2>
					<h3 style="color: #FFFFE0">联系电话：123456789</h3>
					<h3 style="color: #FFFFE0">QQ：123456789</h3>
					<a href="javascript:void(0)" onclick="tip()"> 关闭 </a>
				</div>
			</div>
			<div id="fade" class="black_overlay"></div>
		</div>

		<div id="mainbody">
			<div id="leftbody">
				<div id="picture1">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<span>增值税发票查询</span>
					</div>
				</div>
				<div id="picture2">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<a href="javascript:void(0)"  id="queryAll" value='all' ><span id="queryAll" value='all'>全部发票查询</span></a>
					</div>
				</div>
				<div id="picture3">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -10px">
						<a href="javascript:void(0)" id="queryByDate"><span>分时间段查询</span></a>
					</div>
				</div>
				<div id="picture4">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -10px">
						<a href="javascript:void(0);" id="queryInvid"><span  value="in">进项发票查询</span></a>
					</div>
				</div>
				<div id="picture5">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<a href="javascript:void(0);" id="queryOutvid"><span  value='out'>销项发票查询</span></a>
					</div>
				</div>
				<div id="picture6">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<span>增值税发票分析</span>
					</div>
				</div>
				<div id="picture7">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<a href="#"><span>季节分布分析</span></a>
					</div>
				</div>
				<div id="picture8">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -10px">
						<a href="#"><span>历史同比分析</span></a>
					</div>
				</div>
				<div id="picture9">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -20px">
						<a id="inoutCompare" href="javascript:void(0);"><span>进销对比分析</span></a>
					</div>
				</div>
				<div id="picture10">
					<div
						style="width: 120px; height: 100px; margin-top: 70px; margin-left: -10px">
						<a href="#"><span>库存备货分析</span></a>
					</div>
				</div>
			</div>

			<div id="rightbody">
				<div id="rightbody-data" style="display: none">
					<div style="margin: 0 auto;">
						<form id="myForm" method="post">
							<input id="startDate"
								style="margin-left: 20px; margin-top: 10px; width: 134px;"
								name="startDate" type="date" />&nbsp;&nbsp;至 &nbsp;&nbsp; <input
								id="endDate" name="endDate"
								style="margin-left: 0px; margin-top: 10px; width: 134px;"
								type="date" /> <select id="invoicetype" name="invoicetype"
								style="width: 134px; margin-top: 10px;">
								<option value="in">进项发票</option>
								<option value="out">销项发票</option>
							</select>&nbsp;&nbsp; <input type="button" id="checkBtn" value="查询" />&nbsp;&nbsp;
							<input type="reset" name="reset" value="重置" />
						</form>
					</div>
					<div id="chart"></div>
				</div>
			</div>
			<div class="rightQUery" id="rightbodyQueryAll" style="display: none">
			<span  id="invoiceType" style="display:inline-block;width:100%;height:25px;padding-top:5px;text-align:center;font-size:20px;background:#ccc"></span>
				<table style="margin-top:10px;" id="table" class="table table-bordered table-hover">
					<tr>
						<td>序号</td>
						<td>发票编号</td>
						<td>税价</td>
						<td>税率</td>
						<td>规格</td>
						<td>销货公司</td>
						<td>总金额</td>
						<td>时间</td>
					</tr>

				</table>
				<div class="pagination pagination-centered" style="margin-top:5px;">
					<ul>
						<li><a href='javascript:void(0);' id='homepage'>首页</a></li>
						<li><a href='javascript:void(0);' id="lastpage">上一页</a></li>
						<li><a href='javascript:void(0);' id="nextpage">下一页</a></li>
						<li><a href='javascript:void(0);' id='endpage'>尾页</a></li>
					</ul>
				</div>
			</div>
			<div id="query-in-and-out" style="display: none">
				<div id="chart-in-and-out"></div>
			</div>
		</div>


	</div>

</body>
</html>