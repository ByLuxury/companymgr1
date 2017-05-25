/*function link(){
    document.getElementById('light').style.display='block';
    document.getElementById('fade').style.display='block';  
}
function tip(){
    document.getElementById('light').style.display='none';
    document.getElementById('fade').style.display='none';
}*/
function link() {
	document.getElementById('light').style.display = 'block';
	document.getElementById('fade').style.display = 'block';
}
function tip() {
	document.getElementById('light').style.display = 'none';
	document.getElementById('fade').style.display = 'none';
}
$(function() {
	var p = 0;
	var n = 1;
	var vTr;
	var queryMethod ;
	$("#lastpage").click(
			function() {
				if(p==0){
					$("#lastpage").attr("disabled", true); 
				}
				p--;
				n = (n - 5) - 5; // n=(n-5)-5 n-5获取上页的最后一个，再减5获得第一个
				console.log("lastpage");
				console.log(n);
				console.log(p);
				// $("#table").empty();
				$("#table tr:not(:first)").empty("");
				$
						.ajax({
							url : "/companymgr1/QueryAllServlet",
							type : "post",
							data : {
								pagenow : p,
								queryType:queryMethod

							},
							dataType : "json",
							success : function(data) {
								console.log(data[0]);
								for (var i = 0; i < data.length; i++) {
									vTr = "<tr><td>" + (n++)
											+ "</td><td id='vid'>"
											+ data[i].vid
											+ "</td><td id='amount'>"
											+ data[i].price + "</td><td>"
											+ data[i].tax + "</td><td> "
											+ data[i].specifications
											+ "</td><td>" + data[i].outname
											+ "</td><td>" + data[i].amount
											+ "</td><td>" + data[i].date
											+ "</td></tr>";
									$("#table").append(vTr);
								}
							}
						});

			});
	$("#nextpage").click(
			function() {
				//n = (n - 5) - 5; // n=(n-5)-5 n-5获取上页的最后一个，再减5获得第一个
				console.log("lastpage");
				console.log(n);
				console.log(p);
				// $("#table").empty();
				$("#table tr:not(:first)").empty("");
				$
						.ajax({
							url : "/companymgr1/QueryAllServlet",
							type : "post",
							data : {
								pagenow : p,
								queryType:queryMethod

							},
							dataType : "json",
							success : function(data) {
								console.log(data[0]);
								for (var i = 0; i < data.length; i++) {
									vTr = "<tr><td>" + (n++)
											+ "</td><td id='vid'>"
											+ data[i].vid
											+ "</td><td id='amount'>"
											+ data[i].price + "</td><td>"
											+ data[i].tax + "</td><td> "
											+ data[i].specifications
											+ "</td><td>" + data[i].outname
											+ "</td><td>" + data[i].amount
											+ "</td><td>" + data[i].date
											+ "</td></tr>";
									$("#table").append(vTr);
								}
							}
						});
				p++;

			});

	$("#queryInvid,#queryOutvid").click(
			// #queryAll,#queryInvid,#queryOutvid,#nextpage
			function(e) { // 查询所有
				 queryMethod = $(e.target).attr('value');
				//console.log(queryMethod);
				var showType;
                var queryType;//发送给服务器的类型
				if (queryMethod == 'in') {
					$("#table tr:not(:first)").empty("");
					p=0;
					n=1;
					showType = "进项发票";
					queryType='in';
				} else if (queryMethod == 'out') {
					p=0;
					n=1;
					$("#table tr:not(:first)").empty("");
					showType = "销项发票";
					queryType="out";
				} else {
					$("#table tr:not(:first)").empty("");
					$("#invoiceType").hide();
				}
				$("#invoiceType").html(showType);
				p++;
				$("#rightbody").hide();
				$('#query-in-and-out').hide();
				// $('#rightbodyQueryInvid').hide();
				// $('#rightbodyQueryOutvid').hide();
				$("#rightbodyQueryAll").css("background", "none");
				$("#rightbodyQueryAll").show();
				console.log("nextpage");
				$("#table tr:not(:first)").empty("");
				$
						.ajax({
							url : "/companymgr1/QueryAllServlet",
							type : "post",
							data : {
								pagenow : p,
								queryType:queryType
							},// page=1 start=1 end=5 ;page=2 start=6 edn=10
								// ;page=3
							// start=11 edn=15
							dataType : "json",
							success : function(data) {
								// start=(end-5)-5;
								console.log(data[0]);
								for (var i = 0; i < data.length; i++) {
									vTr = "<tr><td>" + (n++)
											+ "</td><td id='vid'>"
											+ data[i].vid
											+ "</td><td id='amount'>"
											+ data[i].price + "</td><td>"
											+ data[i].tax + "</td><td> "
											+ data[i].specifications
											+ "</td><td>" + data[i].outname
											+ "</td><td>" + data[i].amount
											+ "</td><td>" + data[i].date
											+ "</td></tr>";
									$("#table").append(vTr);

								}
								console.log(n);
								console.log(p - 1);

							}
						});
				P++;

			});

	$("#inoutCompare").click(
			function() { // 对比分析
				$('#query-in-and-out').show();
				$("#rightbody").hide();
				$("#rightbodyQueryAll").hide();
				var invid = new Array();// 从服务器获取的进项发票数组
				var outvid = new Array();// 销项
				var invidSum = new Array();// 显示到前端的进项数据
				var outvidSum = new Array();// 销项

				var allMonth = [ "一月", "二月", "三月", "四月", "五月", "六月", "七月",
						"八月", "九月", "十月", "十一月", "十二月" ];

				$.ajax({
					url : "/companymgr1/InAndOutCompare",
					type : "post",
					dataType : "json",
					success : function(data) {

						invid = data[0];
						outvid = data[1];
						console.log(data.length);
						for (var i = 0; i < invid.length; i++) {
							invidSum[invid[i].month - 1] = invid[i].amount;

						}
						for (var j = 0; j < outvid.length; j++) {
							outvidSum[outvid[j].month - 1] = outvid[j].amount;

						}
						console.log(data);
						console.log(invidSum);
						console.log(outvidSum);
						var dom = document.getElementById("chart-in-and-out");
						var myChart = echarts.init(dom);
						// var app = {};
						option = null;
						option = {
							title : {
								text : '12个月进销项'
							},
							tooltip : {},
							legend : {
								data : [ '进项发票', '销项发票' ]
							},

							xAxis : {
								axisLabel : {
									interval : 0
								},// 防止显示不完全
								data : allMonth
							},

							yAxis : {},
							series : [ {
								name : '进项发票',
								type : 'bar',
								data : invidSum
							// 添加数据
							}, {
								name : '销项发票',
								type : 'bar',
								data : outvidSum
							} ]

						};
						if (option && typeof option === "object") {
							myChart.setOption(option, true);
						}
					}

				});

			});
});