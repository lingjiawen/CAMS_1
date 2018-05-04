var f7App = new Framework7({
    'precompileTemplates': true,
    'smartSelectBackText': '返回',
    'smartSelectPopupCloseText': '关闭',
    'smartSelectPickerCloseText': '确定',
    'modalButtonOk': '确定',
    'modalButtonCancel': '取消',
    'modalPreloaderTitle': '加载中...',
    'notificationCloseButtonText': '关闭'
});
var $ = Dom7;

var mainView = f7App.addView('.view-main', {
    dynamicNavbar: true
});
var jdgo = new Odoo(f7App);
var localData = new LocalData();