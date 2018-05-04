<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="page">
    <%--{# 导航栏 #}--%>
    <div class="navbar">
        <div class="navbar-inner sliding">
            <div class="right">
                <a class="link popover-open" href="#" data-popover=".popover-links">
                    <i class="icon f7-icons">bars</i>
                </a>
            </div>
            <div class="title ios-only ios_title" style="left: 0!important;"><img
                    src="/resources/static/img/app_logo.png" height="44px" class="ios_title">
            </div>
            <div class="title md-only"><img src="/resources/static/img/app_logo_md.png"
                                            height="56px" style="margin: 0 auto;"></div>
        </div>
    </div>
    <div class="toolbar tabbar-labels toolbar-bottom-md">
        <div class="toolbar-inner">
            <a id="student_groups_icon" href="#student_groups" class="tab-link tab-link-active">
                <i class="icon f7-icons ios-only">list_fill<span class="badge color-red">4</span></i>
                <i class="icon f7-icons md-only">list<span class="badge color-red">4</span></i>
                <span class="tabbar-label">群组</span>
            </a>
            <a href="#student_contact" class="tab-link">
                <i class="icon f7-icons ios-only">persons_fill</i>
                <i class="icon f7-icons md-only">persons</i>
                <span class="tabbar-label">通讯录</span>
            </a>
            <a href="#student_course" class="tab-link">
                <i class="icon f7-icons ios-only">book_fill<span class="badge color-red">3</span></i>
                <i class="icon f7-icons md-only">book<span class="badge color-red">3</span></i>
                <span class="tabbar-label">近期课程</span>
            </a>
            <a href="#student_mine" class="tab-link">
                <i class="icon f7-icons ios-only">person_fill</i>
                <i class="icon f7-icons md-only">person</i>
                <span class="tabbar-label">我</span>
            </a>
        </div>
    </div>
    <div class="tabs">
        <!--群组-->
        <div id="student_groups" class="page-content ptr-content tab tab-active">
            <div class="ptr-preloader">
                <div class="preloader"></div>
                <div class="ptr-arrow"></div>
            </div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-media"><img src="/resources/static/img/groups.jpg" width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">不去上课是小狗</div>
                                </div>
                                <div class="item-subtitle">英语课：8:50</div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-media"><img src="/resources/static/img/groups.jpg" width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">一日之计在于上课</div>
                                </div>
                                <div class="item-subtitle">数学课：10：30</div>
                            </div>
                        </a>
                    </li>
                </ul>

            </div>
        </div>


        <!--通讯录-->
        <div id="student_contact" class="page-content ptr-content tab">
            <div class="ptr-preloader">
                <div class="preloader"></div>
                <div class="ptr-arrow"></div>
            </div>
            <div class="ptr-preloader">
                <div class="preloader"></div>
                <div class="ptr-arrow"></div>
            </div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="/new_friend/" class="item-link item-content">
                            <div class="item-media"><i class="icon f7-icons">bars</i></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">新的朋友</div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#student_groups" class="tab-link item-link item-content" id="my_groups">
                            <div class="item-media"><i class="icon f7-icons">bars</i></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">我的群组</div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="/contact_detail/" class="item-link item-content">
                            <div class="item-media"><img
                                    src="/resources/static/img/zhangsan.jpeg" width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">张三</div>
                                </div>
                                <div class="item-subtitle">Zhang San</div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-media"><img src="/resources/static/img/lisi.jpeg"
                                                         width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">李四</div>
                                </div>
                                <div class="item-subtitle">Li Si</div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-media"><img src="/resources/static/img/huanger.jpeg"
                                                         width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">黄二</div>
                                </div>
                                <div class="item-subtitle">HuangEr</div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-media"><img src="/resources/static/img/mazi.jpeg"
                                                         width="44"/></div>
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title"> 麻子</div>
                                </div>
                                <div class="item-subtitle">MaZi</div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>

        <!--近期课程-->
        <div id="student_course" class="page-content ptr-content tab">
            <div class="ptr-preloader">
                <div class="preloader"></div>
                <div class="ptr-arrow"></div>
            </div>
            <div class="block" style="text-align: center">当前签到课程</div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="/course_detail/" class="item-link item-content">
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">数学课</div>
                                    <div class="item-center">A1303</div>
                                    <div class="item-right">01/02 10:00</div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="block" style="text-align: center">今日课程</div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">化学课</div>
                                    <div class="item-center">A3202</div>
                                    <div class="item-right">01/12 10:00</div>
                                </div>
                            </div>
                        </a>
                    </li>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">生物课</div>
                                    <div class="item-center">A1202</div>
                                    <div class="item-right">01/12 11:00</div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="block" style="text-align: center">明日课程</div>
            <div class="list media-list">
                <ul>
                    <li>
                        <a href="#" class="item-link item-content">
                            <div class="item-inner">
                                <div class="item-title-row">
                                    <div class="item-title">生物课</div>
                                    <div class="item-center">A1202</div>
                                    <div class="item-right">01/12 11:00</div>
                                </div>
                            </div>
                        </a>
                    </li>
                </ul>
            </div>
        </div>


        <!--我的信息-->
        <div id="student_mine" class="page-content tab">
            <div class="block" id="id_card">
                <div class="my_picture">
                    <img src="/resources/static/img/img.jpeg"/>
                </div>
                <div class="my_name">
                    <div>凌嘉文</div>
                    <div>华南理工大学</div>
                    <div>大四</div>
                </div>
            </div>
            <div class="row" id="my_information">
                <div class="row-inner">
                    <div>66</div>
                    <div>上课数</div>
                </div>
                <div class="row-inner" style="border: 1px solid #6d6d72;border-bottom: 0px;border-top: 0px;">
                    <div>60</div>
                    <div>签到数</div>
                </div>
                <div class="row-inner">
                    <div>6</div>
                    <div>逃课数</div>
                </div>
            </div>
            <div class="block" style="padding: 0px">
                <div class="list">
                    <ul>
                        <li>
                            <a href="/course_information/" class="item-link item-content">
                                <div class="item-media"><i class="icon f7-icons">bars</i></div>
                                <div class="item-inner">
                                    <div class="item-title">课程详情</div>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="list">
                    <ul>
                        <li>
                            <a href="/student_information/" class="item-link item-content">
                                <div class="item-media"><i class="icon f7-icons">bars</i></div>
                                <div class="item-inner">
                                    <div class="item-title">我的详细信息</div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="/change_password/" class="item-link item-content">
                                <div class="item-media"><i class="icon f7-icons">bars</i></div>
                                <div class="item-inner">
                                    <div class="item-title">更改密码</div>
                                </div>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="popover popover-links">
    <div class="popover-inner">
        <div class="list">
            <ul>
                <li><a class="list-button item-link"
                       onclick="app.router.navigate('/dispatch/', {ignoreCache: true})">配货管理</a></li>
                <li><a class="list-button item-link"
                       onclick="app.router.navigate('/refund/', {ignoreCache: true})">退货管理</a></li>
                <li><a class="list-button item-link"
                       onclick="app.router.navigate('/relogin/', {ignoreCache: true})">切换账号</a></li>
                <!--<li><a class="list-button item-link" href="/map/">地图</a></li>-->
            </ul>
        </div>
    </div>
</div>
</div>
</div>