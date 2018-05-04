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
            <div class="right">
                <a href="#" class="link back">
                    <span>完成</span>
                </a>
            </div>
        </div>
    </div>
    <form class="searchbar">
        <div class="searchbar-inner">
            <div class="searchbar-input-wrap">
                <input type="search" placeholder="输入你的学校名">
                <i class="searchbar-icon"></i>
                <span class="input-clear-button"></span>
            </div>
            <span class="searchbar-disable-button">取消</span>
        </div>
    </form>
    <div class="page-content">
        <div class="searchbar-backdrop"></div>
        <div class="block searchbar-hide-on-search">
            <p>请在搜索框输入你的学校名或直接选择：</a></p>
        </div>
        <div class="list searchbar-found">
            <ul>
                <li class="item-content" onclick="
                  console.log('click')
                ">
                    <div class="item-inner">
                        <div class="item-title">华南理工大学</div>
                    </div>
                </li>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">清华大学</div>
                    </div>
                </li>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">北京大学</div>
                    </div>
                </li>
                <li class="item-content">
                    <div class="item-inner">
                        <div class="item-title">天津大学</div>
                    </div>
                </li>
            </ul>
        </div>
        <!-- Nothing found message -->
        <div class="block searchbar-not-found">
            <div class="block-inner">没有找到你的学校，请重新输入关键词或点击此处<a>创建</a></div>
        </div>
    </div>
</div>
</div>