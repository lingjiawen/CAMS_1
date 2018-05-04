function deleteContact() {
    $$('#delete_contact').click(function () {
        app.dialog.confirm("确定删除该联系人吗？","")
    })
}

function setRemark() {
    $$('#set_remark').click(function () {
        app.dialog.prompt("请输入备注名：","", function (value) {
            console.log("备注名为：", value)
        })
    })
}