<%--
  Created by IntelliJ IDEA.
  User: dragonone
  Date: 2021/11/29
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>数据可视化展示</title>
    <!-- 1.引入 echarts.js -->
    <script type="text/javascript" src="./static/js/echarts.min.js"></script>
    <!-- 引入jquery.js -->
    <script type="text/javascript" src="./static/js/jquery-3.6.0.min.js"></script>
</head>
<body style="margin: 5% 26% 0% 29%;">
<div style="text-align: center;">
</div>
<!-- 2.为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1200px; height: 400px;"></div>
<script type="text/javascript">
    //将echarts内容加载到id为main的div标签中
    var myChart = echarts.init(document.getElementById('main'));
    //3.初始化，默认显示标题，图例和xy空坐标轴
    myChart.setOption({
        title : {
            text : '北京各地区二手房平均房价'
        },
        tooltip : {},
        legend : {
            data : [ '北京各地区二手房平均房价' ]
        },
        xAxis : {
            type: 'category',
            "axisLabel":{
                interval: 0
            },
            data : []
        },
        yAxis : {
            type: 'value'
        },
        series : [ {
            name : '北京各地区二手房平均房价',
            type : 'bar',
            data : []
        } ]
    });
    //4.设置加载动画(非必须)
    //数据加载完之前先显示一段简单的loading动画
    myChart.showLoading();
    //5.定义数据存放数组(动态变)
    //建立一个地区数组（实际用来盛放X轴坐标值）
    var names = [];
    //建立一个平均房价数组（实际用来盛放Y坐标值）
    var avgs = [];

    //6.ajax发起数据请求
    $.ajax({
        type : "post",
        //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
        async : true,
        //请求发送到AvgPriceServlet
        url : "AvgPriceServlet",
        data : {},
        //返回数据形式为json
        dataType : "json",
        //7.请求成功后接收数据name+num两组数据
        success : function(result) {
            //result为服务器返回的json对象
            if (result) {
                //8.取出数据存入数组
                for (var i = 0; i < result.length; i++) {
                    //迭代取出类别数据并填入地区名称数组
                    names.push(result[i].district);
                }
                for (var i = 0; i < result.length; i++) {
                    //迭代取出销量并填入平均房价数组
                    avgs.push(result[i].avg_price);
                }
                //隐藏加载动画
                myChart.hideLoading();
                //9.覆盖操作-根据数据加载数据图表
                myChart.setOption({
                    xAxis : {
                        data : names
                    },
                    series : [ {
                        // 根据名字对应到相应的数据
                        name : '平均价格',
                        data : avgs
                    } ]
                });

            }

        },
        error : function(errorMsg) {
            //请求失败时执行该函数
            alert("图表请求数据失败!");
            myChart.hideLoading();
        }
    })
</script>
</body>
</html>

