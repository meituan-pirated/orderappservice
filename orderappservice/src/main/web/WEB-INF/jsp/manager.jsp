<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .vml{behavior:url(#default#VML);display:inline-block;position:absolute}
        .amap-custom{top:0;left:0;position:absolute}
        .amap-container img{max-width:none!important;max-height:none!important}
        .amap-container{touch-action:none;position:relative;overflow:hidden;background:#fcf9f2 url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAfQAAAH0AgMAAAC2uDcZAAAADFBMVEX////////////////1pQ5zAAAABHRSTlMAgP/AWuZC2AAAAVhJREFUeAFiYGAQYGDEQjAB2rcDC4BiGIqiU7abdKlO2QkeIClyPsDHweMKtOPHIJ1Op6/w7Y4fdqfT6VpndzqdrnV2p9PpWmd3Oj3qWndSoKp+2J1Op7vr7E6n07XO7nQ6XevsTqfTtc7udPo4/f787E6n0911dqfT6VpndzqdrnV2p9PpWmd3Ot27Ce8m6HS6u85dR6fTtU7r6HS61mkdnU7XOrvT6XTvJuxOp9PddXan0+laZ3c6na51dDpd67SOTqd7N+HdBJ1Od9e56+h0utZpHZ1O1zq70+l0rbM7nU73bsLudDrdXWd3Ol3rtI5Op2ud1tHpdK3TOjqd7t2EdxN0Ot1dZ3c6na51dqfT6VpndzqdrnV2p9Pp3k3Q6XR3nbuOTqdrndbR6XSt0zo6na51Wken072bsDudTnfX2Z1Op2ud3el0utbZnU7XOq2j0+t0uncTD1gO4zoT5doZAAAAAElFTkSuQmCC);-ms-touch-action:none}
        .amap-drags,.amap-layers{width:100%;height:100%;position:absolute;overflow:hidden}
        .amap-layers canvas{-webkit-touch-callout:none;-webkit-user-select:none;-khtml-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none}.amap-layer img{pointer-events:none}.amap-e,.amap-maps{width:100%;height:100%}.amap-maps,.amap-e,.amap-layers,.amap-tile,.amap-tile-container{position:absolute;left:0;top:0;overflow:hidden}.amap-context{position:absolute;left:0;top:0}.amap-overlays,.amap-markers,.amap-marker{position:absolute;left:0;top:0}.amap-layers{z-index:0}.amap-overlays{z-index:110;cursor:default}.amap-markers{z-index:120}.amap-controls{z-index:150}.amap-copyright{position:absolute;display:block!important;left:77px;height:16px;bottom:0;padding-bottom:3px;font-size:11px;font-family:Arial,sans-serif;z-index:160}.amap-logo{position:absolute;bottom:1px;left:1px;z-index:160;height:20px}.amap-logo img{width:73px!important;height:20px!important;border:0;vertical-align:baseline!important}.amap-icon{position:relative;z-index:1}.amap-icon img{position:absolute;z-index:-1}.amap-marker-label{position:absolute;z-index:2;border:1px solid blue;background-color:white;white-space:nowrap;cursor:default;padding:3px;font-size:12px;line-height:14px}
        .amap-info{position:absolute;left:0;z-index:140;width:320px}
        .amap-menu{position:absolute;z-index:140;_width:100px}
        .amap-info-close{position:absolute;right:5px;_right:12px;+right:11px;top:5px;_top:2px;+top:2px;color:#c3c3c3;text-decoration:none;font:bold 16px/14px Tahoma,Verdana,sans-serif;width:14px;height:14px}
        .amap-info-outer,
        .amap-menu-outer{box-shadow:0 1px 2px rgba(0,0,0,0.1);background:none repeat scroll 0 0 white;border-radius:2px;padding:1px;text-align:left}
        .amap-menu-outer:hover{box-shadow:0 1px 2px rgba(0,0,0,0.3)}
        .amap-info-contentContainer:hover
        .amap-info-outer{box-shadow:0 1px 2px rgba(0,0,0,0.3)}
        .amap-info-content{position:relative;background:#fff;padding:10px 18px 10px 10px;line-height:1.4;overflow:auto}
        .amap-marker-content{position:relative}
        .amap-info{_width:320px}.amap-menu{_width:100px}
        .amap-info-sharp-old{overflow:hidden;position:absolute;background-image:url(http://webapi.amap.com/images/arrows.png)}
        .bottom-center .amap-info-sharp-old{height:12px;margin:0 auto;width:20px;background-position:center 12px;top:100%;margin-top:-9px;left:50%;margin-left:-10px}
        .bottom-left .amap-info-sharp-old{height:12px;width:13px;background-position:-16px -46px;top:100%;margin-top:-9px}
        .bottom-right .amap-info-sharp-old{height:12px;width:13px;top:-1px;background-position:-56px -46px;left:100%;margin-left:-13px;top:100%;margin-top:-9px}
        h.middle-left .amap-info-sharp-old{height:20px;width:12px;background-position:left;top:50%;margin-top:-10px;margin-left:-11px}.center .amap-info-sharp-old{display:none}.middle-right .amap-info-sharp-old{height:20px;margin-right:0;width:12px;background-position:right;left:100%;margin-left:-9px;top:50%;margin-top:-10px}.top-center .amap-info-sharp-old{height:12px;margin:0 auto;width:20px;background-position:top;top:0;margin-top:-3px;left:50%;margin-left:-10px}.top-left .amap-info-sharp-old{height:12px;width:13px;background-position:-16px -3px;top:0;margin-top:-3px}.top-right .amap-info-sharp-old{height:12px;width:13px;background-position:-56px -3px;left:100%;margin-left:-13px;top:0;margin-top:-3px}.amap-info-sharp{position:absolute}.bottom-center .amap-info-sharp{bottom:0;left:50%;margin-left:-8px;border-left:8px solid transparent;border-right:8px solid transparent;border-top:8px solid #fff}.bottom-center .amap-info-sharp:after{position:absolute;content:"";margin-left:-8px;margin-top:-7px;border-left:8px solid transparent;border-right:8px solid transparent;border-top:8px solid rgba(0,0,0,0.3);filter:blur(2px);z-index:-1}.amap-info-contentContainer:hover.bottom-center .amap-info-sharp:after{border-top:8px solid rgba(0,0,0,0.5)}.bottom-left .amap-info-sharp{border-color:transparent #fff;border-width:0 0 10px 10px;border-style:solid}.bottom-left .amap-info-sharp:after{position:absolute;content:"";margin-left:-10px;border-color:transparent rgba(0,0,0,0.3);border-width:0 0 10px 10px;border-style:solid;filter:blur(1px);z-index:-1}.amap-info-contentContainer:hover.bottom-left .amap-info-sharp:after{border-color:transparent rgba(0,0,0,0.5)}.bottom-left .amap-info-content{border-radius:2px 2px 2px 0}.bottom-right .amap-info-sharp{right:0;border-top:10px solid #fff;border-left:10px solid transparent}.bottom-right .amap-info-sharp:after{position:absolute;margin-top:-9px;margin-left:-10px;content:"";border-top:10px solid rgba(0,0,0,0.3);border-left:10px solid transparent;filter:blur(1px);z-index:-1}.amap-info-contentContainer:hover.bottom-right .amap-info-sharp:after{border-top:10px solid rgba(0,0,0,0.5)}.bottom-right .amap-info-content{border-radius:2px 2px 0 2px}.top-center .amap-info-sharp{top:0;left:50%;margin-left:-8px;border-left:8px solid transparent;border-right:8px solid transparent;border-bottom:8px solid #fff}.top-center .amap-info-sharp:after{position:absolute;content:"";margin-top:0;margin-left:-8px;border-left:8px solid transparent;border-right:8px solid transparent;border-bottom:8px solid rgba(0,0,0,0.3);filter:blur(1px);z-index:-1}.top-left .amap-info-sharp{left:0;top:0;border-bottom:10px solid #fff;border-right:10px solid transparent}.top-left .amap-info-sharp:after{position:absolute;content:"";margin-top:0;margin-left:0;border-bottom:10px solid rgba(0,0,0,0.3);border-right:10px solid transparent;filter:blur(1px);z-index:-1}.top-right .amap-info-sharp{right:0;top:0;border-bottom:10px solid #fff;border-left:10px solid transparent}.top-right .amap-info-sharp:after{position:absolute;content:"";margin-top:0;margin-left:-10px;border-bottom:10px solid rgba(0,0,0,0.3);border-left:10px solid transparent;filter:blur(1px);z-index:-1}.middle-right .amap-info-sharp{right:0;top:50%;margin-top:-8px;border-top:8px solid transparent;border-left:8px solid #fff;border-bottom:8px solid transparent}.middle-right .amap-info-sharp:after{position:absolute;content:"";margin-top:-8px;margin-left:-8px;border-top:8px solid transparent;border-left:8px solid rgba(0,0,0,0.3);border-bottom:8px solid transparent;filter:blur(1px);z-index:-1}.amap-info-contentContainer:hover.middle-right .amap-info-sharp:after{border-left:8px solid rgba(0,0,0,0.5)}.middle-left .amap-info-sharp{left:0;top:50%;margin-top:-8px;border-top:8px solid transparent;border-right:8px solid #fff;border-bottom:8px solid transparent}.middle-left .amap-info-sharp:after{position:absolute;content:"";margin-top:-8px;margin-left:0;border-top:8px solid transparent;border-right:8px solid rgba(0,0,0,0.3);border-bottom:8px solid transparent;filter:blur(1px);z-index:-1}.amap-info-contentContainer:hover.middle-left .amap-info-sharp:after{border-right:8px solid rgba(0,0,0,0.5)}.amap-info-contentContainer.top-left,.amap-info-contentContainer.top-center,.amap-info-contentContainer.top-right{padding-top:8px}.amap-info-contentContainer.bottom-left,.amap-info-contentContainer.bottom-center,.amap-info-contentContainer.bottom-right{padding-bottom:8px}.amap-info-contentContainer.middle-right{padding-right:8px}.amap-info-contentContainer.middle-left{padding-left:8px}.amap-menu-outer{margin:0;padding:0;list-style-type:none}ul.amap-menu-outer li{cursor:pointer;height:35px;line-height:35px;word-break:break-all;padding:0 10px;font-size:12px;white-space:nowrap}ul.amap-menu-outer li a{text-decoration:none;font-size:13px;margin:0 5px;color:#000;padding:5px 5px}ul.amap-menu-outer li:hover{background-color:#f3f3ee}.amap-overlay-text-container{display:block;width:auto;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;background:#fff;padding:2px 3px;border:1px solid #ccc;border-radius:3px}.amap-overlay-text-container.amap-overlay-text-empty{display:none}.amap-info-content-ie8{border:1px solid #9c9c9c}
    </style>
    <title>后台管理</title>
</head>
<body style="margin: 0px;" class="">
    <div id="app">
        <section class="el-container" style="width: 100%; margin:0px">
            <aside class="el-aside" style="width: 120px;">
                <div class="root">
                    <ul role="menubar" class="el-menu-vertical-demo el-menu" style="background-color: rgb(84, 92, 100);">
                        <li role="menuitem" tabindex="-1" class="el-menu-item is-disabled" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);"><span></span></li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item is-active" style="padding-left: 20px; color: rgb(255, 208, 75); background-color: rgb(84, 92, 100);"><i class="el-icon-s-home"></i><span>首页</span>
                        </li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);"><i class="el-icon-s-shop"></i><span>商家</span></li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);"><i class="el-icon-user"></i><span>用户</span></li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);">
                            <i class="el-icon-document"></i><span>订单</span></li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);">
                            <i class="el-icon-s-marketing"></i>
                            <span>统计</span></li>
                        <li role="menuitem" tabindex="-1" class="el-menu-item" style="padding-left: 20px; color: rgb(255, 255, 255); background-color: rgb(84, 92, 100);">
                            <i class="el-icon-setting"></i>
                            <span>设置</span>
                        </li>
                    </ul>
                </div>
            </aside>
            <section class="el-container is-vertical">
                <header class="el-header" style="height: 60px; border-bottom: 1px solid rgb(190, 190, 190);">
                    <div class="header">
                        <div class="name"> </div>
                        <div class="head-img">
                            <div class="el-dropdown">
                                <span class="el-dropdown-link head-img-click el-dropdown-selfdefine   " aria-haspopup="list" aria-controls="dropdown-menu-9951" role="button" tabindex="0">
                                    <img src="/shops_cms/img/bbbb.1628995f.jpg">
                                    <i class="el-icon-arrow-down el-icon--right"></i>
                                </span>
                                <span class=""></span>
                            </div>
                        </div>
                        <div class="list-head">
                            <div class="el-row">
                                <div class="el-dialog__wrapper" style="display: none;">
                                    <div role="dialog" aria-modal="true" aria-label="dialog" class="el-dialog el-dialog--center" style="margin-top: 15vh; width: 35%;">
                                        <div class="el-dialog__header">
                                            <span class="el-dialog__title"></span>
                                            <button type="button" aria-label="Close" class="el-dialog__headerbtn">
                                                <i class="el-dialog__close el-icon el-icon-close"></i>
                                            </button>
                                        </div>
                                        <!---->
                                        <div class="el-dialog__footer">
                                            <div class="dialog-footer">
                                                <button type="button" class="el-button el-button--primary"><!----><!---->
                                                    <span>确 定</span>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="el-dialog__wrapper" style="display: none;">
                            <div role="dialog" aria-modal="true" aria-label="待处理事项" class="el-dialog" style="margin-top: 15vh; width: 30%;">
                                <div class="el-dialog__header">
                                    <span class="el-dialog__title">待处理事项</span>
                                    <button type="button" aria-label="Close" class="el-dialog__headerbtn">
                                        <i class="el-dialog__close el-icon el-icon-close"></i>
                                    </button>
                                </div><!---->
                                <div class="el-dialog__footer">
                                    <span class="dialog-footer">
                                        <button type="button" class="el-button el-button--primary"><!----><!---->
                                            <span>关 闭</span>
                                        </button>
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </header>
                <main class="el-main" style="background-color: rgb(245, 247, 249); margin: 0px; padding: 0px;">
                    <div class="bg-main">
                        <main class="el-main">
                            <div class="el-row" style="margin-left: -10px; margin-right: -10px;">
                                <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                                    <div class="tishi">
                                        <div class="ts_01">
                                            <div class="ts_01_l">订单</div>
                                            <div class="ts_01_m">今</div>
                                        </div>
                                        <div class="ts_02">
                                            <div class="ts_02_l">
                                        <span>0/0</span>
                                                <br>今日订单/收入
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                                    <div class="tishi">
                                        <div class="ts_01">
                                            <div class="ts_01_l">交易</div>
                                            <div class="ts_01_m">月</div>
                                        </div>
                                        <div class="ts_02"><div class="ts_02_l">
                                            <span>0/0</span>
                                            <br>本月订单/收入
                                        </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                                    <div class="tishi"><div class="ts_01"><div class="ts_01_l">用户</div><div class="ts_01_m">今</div></div><div class="ts_02"><div class="ts_02_l"><span>0</span><br>
    今日新增用户
</div></div></div></div>
                                <div class="el-col el-col-6" style="padding-left: 10px; padding-right: 10px;">
                                    <div class="tishi">
                                        <div class="ts_01">
                                            <div class="ts_01_l">用户</div>
                                            <div class="ts_01_m">月</div>
                                        </div>
                                        <div class="ts_02">
                                            <div class="ts_02_l">
                                                <span>0</span>
                                                <br>本月新增用户
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="el-row" style="background-color: rgb(255, 255, 255);">
                                <div class="el-row" style="display: flex; justify-content: flex-start; padding: 10px; height: 70px; line-height: 50px;">
                                    <span>按月查询：</span>
                                    <div class="el-date-editor el-input el-input--prefix el-input--suffix el-date-editor--month">
                                        <!---->
                                        <input type="text" autocomplete="off" name="" placeholder="选择月" class="el-input__inner">
                                        <span class="el-input__prefix">
                                            <i class="el-input__icon el-icon-date"></i>
                                            <!---->
                                        </span>
                                        <span class="el-input__suffix">
                                            <span class="el-input__suffix-inner">
                                                <i class="el-input__icon"></i>
                                                <!----><!----><!----><!---->
                                            </span>
                                            <!---->
                                        </span>
                                    </div>
                                </div>
                                <div class="ve-line" style="width: auto; height: 400px; position: relative;">
                                    <div class="" _echarts_instance_="ec_1623063234635" style="width: auto; height: 400px; position: relative; -webkit-tap-highlight-color: transparent; user-select: none;">
                                        <div style="position: relative; width: 413px; height: 400px; padding: 0px; margin: 0px; border-width: 0px; cursor: default;">
                                            <canvas data-zr-dom-id="zr_0" width="619" height="600" style="position: absolute; left: 0px; top: 0px; width: 413px; height: 400px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); padding: 0px; margin: 0px; border-width: 0px;"></canvas>
                                        </div>
                                        <div style="position: absolute; display: none; border-style: solid; white-space: nowrap; z-index: 9999999; transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s, top 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s; background-color: rgba(50, 50, 50, 0.7); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); font: 14px / 21px &quot;Microsoft YaHei&quot;; padding: 5px; left: 225px; top: 104px; pointer-events: none;">06-24 2021<br>
                                            <span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:#19d4ae;"></span>
                                            用户量: 0<br>
                                            <span style="display:inline-block;margin-right:5px;border-radius:10px;width:10px;height:10px;background-color:#5ab1ef;"></span>
                                            订单量: 0<br>
                                        </div>
                                    </div>
                                    <div class="v-charts-data-empty" style="display: none;"> 暂无数据 </div>
                                    <div class="v-charts-component-loading" style="display: none;">
                                        <div class="loader">
                                            <div class="loading-spinner">
                                                <svg viewBox="25 25 50 50" class="circular">
                                                    <circle cx="50" cy="50" r="20" fill="none" class="path"></circle>
                                                </svg>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>
                </main>
            </section>
        </section>
    </div>
    <script src="/shops_cms/js/chunk-vendors.36f89859.js"></script>
    <script src="/shops_cms/js/app.81deca5b.js"></script>
    <ul class="el-dropdown-menu el-popper" id="dropdown-menu-9951" style="transform-origin: center top; z-index: 2033; display: none;">
        <li tabindex="-1" class="el-dropdown-menu__item"><!---->修改密码</li>
        <li tabindex="-1" class="el-dropdown-menu__item"><!---->退出</li>
        <div x-arrow="" class="popper__arrow" style="left: 61px;"></div>
    </ul>
</body>

</html>
