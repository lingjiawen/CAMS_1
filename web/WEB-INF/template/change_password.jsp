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
        <form class="list" id="my-form">
            <ul>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">用户名</div>
                            <div class="item-input-wrap">
                                <input type="text" name="username" placeholder="用户名" disabled="disabled"
                                       value="admin">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">密码</div>
                            <div class="item-input-wrap">
                                <input type="password" name="password" placeholder="密码">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">新密码</div>
                            <div class="item-input-wrap">
                                <input type="password" name="new_password" placeholder="新密码">
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="item-content item-input">
                        <div class="item-inner">
                            <div class="item-title item-label">重复新密码</div>
                            <div class="item-input-wrap">
                                <input type="password" name="new_password_confirm"
                                       placeholder="重复新密码">
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </form>
        <div class="block">
            <p class="row">
                <button id="change_psd" class="col button button-big button-fill">确认更改
                </button>
            </p>
        </div>
    </div>
</div>