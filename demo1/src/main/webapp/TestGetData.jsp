<%--
  Created by IntelliJ IDEA.
  User: dragonone
  Date: 2021/11/29
  Time: 16:41
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
  <script src="static/js/DragonOne.js"></script>
  <style>
    #main,html,body{
      width: 100%;
    }
    #main{
      margin-top: 30px;
      height: 567px;
    }
  </style>
</head>
<body>
<div style="text-align: center;"></div>
<div id="main"></div>
<script type="text/javascript">
  var myChart = echarts.init(document.getElementById('main'),'dark');

  // 实现响应式
  window.onresize=function(){
    myChart.resize();
  };
  // 初始化，默认显示标题，图例和xy空坐标轴
  myChart.setOption({
    title : {
      text : '价格(元/m²)',
      left: 100,
      top: 2
    },
    tooltip : {},
    toolbox:{
      feature:{
        saveAsImage:{},
        dataView:{},
        magicType:{
          type: ['bar','line']
        }
      }
    },
    legend : {
      data : [ '北京各地区二手房平均房价']
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
      itemStyle: {
        color: {
          type: 'linear',
          x: 0,
          y: 0,
          x2: 0,
          y2: 1,
          colorStops: [{
            offset: 0,
            color: 'red' //0%处的颜色
          },
            {
              offset: 1,
              color: 'blue' //100%处的颜色
            }
          ]
        }
      },
      barWidth: '30%',
      markPoint: {
        data: [
          {
            type: 'max',
            name: '这是最大值'
          },
          {
            type: 'min',
            name: '这是最小值'
          }
        ]
      },
      markLine: {
        data: [
          {
            type: 'average',
            name: '这是平均值' //这个name并不会在页面中显示
          }
        ]
      },
      data : []
    } ]
  });
  //数据加载的loading动画
  myChart.showLoading();
  // X轴
  var names = [];
  // Y轴
  var avs = [];

  // ajax发起数据请求
  $.ajax({
    type : "get",
    //异步请求（同步请求将会锁住浏览器，其他操作须等请求完成才可执行）
    async : true,
    url : "testGet", // /demo1_war_exploded/testGet
    data : {},
    dataType : "json",
    success : function(result) {
      // console.log("成功")
      if (result) {
        // console.log("成功")
        for (var i = 0; i < result.length; i++) {
          names.push(result[i].name);
        }
        for (var i = 0; i < result.length; i++) {
          avs.push(result[i].price);
        }
        //隐藏加载动画
        myChart.hideLoading();
        // 覆盖操作-根据数据加载数据图表
        myChart.setOption({
          xAxis : {
            data : names
          },
          series : [ {
            // 根据名字对应到相应的数据
            name : '北京各地区二手房平均房价',
            markPoint: {
              data: [
                {
                  type: 'max',
                  name: '这是最大值'
                },
                {
                  type: 'min',
                  name: '这是最小值'
                }
              ]
            },
            data : avs
          } ]
        });

      }

    },
    error : function(errorMsg) {
      alert("图表请求数据失败!");
      myChart.hideLoading();
    }
  })
</script>
</body>
</html>

