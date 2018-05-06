<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page">
    <div class="navbar">
        <div class="navbar-inner">
            <div class="left">
                <a href="#" class="link back">
                    <i class="icon icon-back"></i>
                    <span>返回</span>
                </a>
            </div>
        </div>
    </div>
    <div class="page-content">
        <!--基本信息-->
        <div class="block-title">成员：</div>
        <div class="list media-list">
            <ul>
                <li>
                    <div class="table">
                        <div class="table_row">
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                        </div>
                        <div class="table_row">
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/zhangsan.jpeg"/></div>
                            <div class="table_cell"><img
                                    src="/resources/static/img/group_add_member.png"/></div>
                        </div>
                </li>
            </ul>
        </div>
        <div class="block-title">今日课程：</div>
        <div class="list media-list">
            <ul>
                <li class="accordion-item">
                    <a href="#" class="item-link item-content">
                        <div class="item-inner">
                            <div class="item-title-row">
                                <div class="item-title">化学课</div>
                                <div class="item-center">参与者:2/4</div>
                                <div class="item-right">01/12 08:00</div>
                            </div>
                        </div>
                    </a>
                    <div class="accordion-item-content">
                        <div class="block">
                            <p> 教师：刘孜文</p>
                            <p>上课地点：A1203</p>
                            <p>上课时间：08：00-10：00</p>
                            <p>上课周数：16周</p>
                            <p>当前周数：第3周</p>
                            <p>参与者：</p>
                            <div class="table" style="padding: 5px;">
                                <div class="table_row">
                                    <div style="display: table-cell; width: 33%">凌嘉文</div>
                                    <div style="display: table-cell; width: 33%">未签到</div>
                                    <div style="display: table-cell; width: 33%"><button class="button" onclick="app.dialog.confirm('确定要提醒他吗？','')">提醒他</button></div>
                                </div>
                            </div>
                            <div class="table" style="padding: 5px;">
                                <div class="table_row">
                                    <div style="display: table-cell; width: 33%">雷雨声</div>
                                    <div style="display: table-cell; width: 33%">未签到</div>
                                    <div style="display: table-cell; width: 33%"><button class="button" onclick="app.dialog.confirm('确定要提醒他吗？','')">提醒他</button></div>
                                </div>
                            </div>
                            <div class="table" style="padding: 5px;">
                                <div class="table_row">
                                    <div style="display: table-cell; width: 33%">李坤</div>
                                    <div style="display: table-cell; width: 33%">已签到</div>
                                    <div style="display: table-cell; width: 33%"><button class="button" disabled="true">提醒他</button></div>
                                </div>
                            </div>
                            <div class="table" style="padding: 5px;">
                                <div class="table_row">
                                    <div style="display: table-cell; width: 33%">李坤</div>
                                    <div style="display: table-cell; width: 33%">已签到</div>
                                    <div style="display: table-cell; width: 33%"><button class="button" disabled="true">提醒他</button></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <div class="block-title">今日旷课：</div>
        <div class="list media-list">
            <ul>
                <li>
                    <div class="item-content">
                        <div class="item-inner">
                            <div class="item-title-row">
                                <div class="item-title">雷雨声</div>
                                <div class="item-center">旷课数:3节</div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>