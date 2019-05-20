$(function () {
    onSize();
    mainCanvas();
    $(window).resize(function () {
        onSize();
        mainCanvas();
    });
    $("#headerRightMy").click(function () {
        $("#AlertA").toggle("slow");
    })
    $(".panel").click(function () {
        ckh(this);
    })

});

function mainCanvas() {
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var dataAxis = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];
    var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149];
    var yMax = 100;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
       
        title: {
            text: '',
            subtext: ''
        },
        
        xAxis: {
            data: dataAxis,
            axisLabel: {
                inside: true,
                textStyle: {
                    color: '#fff'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            z: 10
        },
        yAxis: {
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
        },
        dataZoom: [{
            type: 'inside'
        }],
       
        series: [{ // For shadow
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: 'rgba(0,0,0,0.05)'
                    }
                },
                barGap: '-100%',
                barCategoryGap: '40%',
                data: dataShadow,
                animation: true
            },
            {
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [{
                                    offset: 0,
                                    color: '#BFC2CD'
                                },
                                {
                                    offset: 0.5,
                                    color: '#BFC2CD'
                                },
                                {
                                    offset: 1,
                                    color: '#BFC2CD'
                                }
                            ]
                        )
                    ,label: {
                        show: true, //开启显示
                        position: 'top', //在上方显示
                        textStyle: { //数值样式
                            color: '#BFC2CD',
                            fontSize: 16
                        }
                    }
                    },
                    emphasis: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [{
                                    offset: 0,
                                    color: '#e8403f'
                                },
                                {
                                    offset: 0.7,
                                    color: '#e8403f'
                                },
                                {
                                    offset: 1,
                                    color: '#e8403f'
                                }
                            ]
                        )
                    }
                },
                data: data
            }
        ]
    };

    // Enable data zoom when user click bar.
    var zoomSize = 6;
    myChart.on('click', function (params) {
        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
        myChart.dispatchAction({
            type: 'dataZoom',
            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
        });
    });

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
}

function onSize() {
    if ($(window).width() > 767) {
        $("#in_width").addClass("in_width");
        $("#nav_box").addClass("nav_box");
        $("#in_width").height(($(document).height()-60));
        $("#main canvas").width($("#main").width());
    } else {
        $("#in_width").removeClass("in_width");
        $("#nav_box").removeClass("nav_box");
        $("#in_width").height("100%");
    }
}

function ckh(obj) {
    $(obj).addClass("panel_active");
    $(obj).siblings().removeClass("panel_active");
}