function setTab(name,cursel,n){
for(i=1;i<=n;i++){
var menu=document.getElementById(name+i);
var divid = "con_"+name+"_"+i;
var con=document.getElementById(divid);
menu.className=i==cursel?"hover":"";
con.style.display=i==cursel?"block":"none";
   // aa(con);
}
    var divid = "con_"+name+"_"+cursel;
    var dzName = $("#"+divid).text();
    //alert(divid);
    if("con_two_1" == divid){
        dzName = "德宏";
    }else if("con_two_2" == divid){
        dzName = "昆明";
    }else if("con_two_3" == divid){
        dzName = "西双版纳";
    }else if("con_two_4" == divid){
        dzName = "红河";
    }else if("con_two_5" == divid){
        dzName = "普洱";
    }else if("con_two_6" == divid){
        dzName = "保山";
    }else if("con_two_7" == divid){
        dzName = "文山";
    }else if("con_two_8" == divid){
        dzName = "临沧";
    }else if("con_two_9" == divid){
        dzName = "大理";
    }else if("con_two_10" == divid){
        dzName = "怒江";
    }

    //alert(dzName);
    typesByDZ(divid,dzName);
}

function typesByDZ(divid,dzName){
    var mydata;
    $.ajax({
        cache : true,
        url : "typesByDZ",
        data:{"dzName":dzName},
        async : false,
        success : function(r) {
            console.log("r==", r);
            mydata = eval('(' + r + ')');
            console.log("mydata", mydata);
        },
        error : function(r) {
            alert("失败！");
        }
    });
    var xdatademo = new Array();
    var ydatademo = new Array();
    for(var i=0;i<mydata[1].length;i++){
        xdatademo.push(mydata[1][i].bidType);
        ydatademo.push(mydata[1][i].typeNum);
    }
    console.log("xdatademo", xdatademo);
    console.log("ydatademo", ydatademo);
    var myChart = echarts.init(document.getElementById(divid));
    option = {
        color: ['#ffd200'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        legend: {
            data:mydata[0][0].dzName
        },
        grid: {
            left: '0%',
            right: '8%',
            bottom: '3%',
            containLabel: true
        },
        toolbox: {
            show : false,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'value',
                lineStyle: {       // 属性lineStyle控制线条样式
                    color: '#333',
                    width: 1
                },
                axisLabel: {
                    show: true,
                    textStyle: {
                        color: '#fff',
                        fontSize: 12
                    }
                },
                axisLine: {
                    lineStyle: {
                        type: 'solid',
                        color: '#fff',//左边线的颜色
                        width:'1'//坐标线的宽度
                    }
                },
                axisTick:{       //y轴刻度线
                    show:true,
                    color: '#fff'
                },
                splitLine:{
                    show:false
                }
            }
        ],
        yAxis : [
            {
                type : 'category',
                splitLine:{
                    show:false
                },
                axisLine: {
                    lineStyle: {
                        type: 'solid',
                        color: '#fff',//左边线的颜色
                        width:'1'//坐标线的宽度
                    }
                },
                axisTick:{       //y轴刻度线
                    show:true,
                    color: '#fff'
                },
                data:xdatademo
            }
        ],
        series : [
            {
                //name:'直接访问',
                name:mydata[0][0].dzName,
                type:'bar',
                stack: '总量',
                itemStyle : { normal: {label : {show: true, position: 'insideRight'}}},
                data:ydatademo,
                itemStyle: {
                    //柱形图圆角，鼠标移上去效果，如果只是一个数字则说明四个参数全部设置为那么多
                    emphasis: {
                        barBorderRadius: 3
                    },
                    normal: {
                        //柱形图圆角，初始化效果
                        barBorderRadius:[3, 3, 3, 3],
                        label: {
                            show: true,//是否展示
                            position: 'right',
                            textStyle: {
                                fontWeight:'bolder',
                                fontSize : '12',
                                color: '#ffd200',
                                fontFamily : '微软雅黑'
                            }
                        }
                    }
                }
            }
        ]
    };

    myChart.setOption(option,true);
}