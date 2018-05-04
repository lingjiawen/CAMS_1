function myHead() {
    $$('#my_head').css('line-height', $$('#my_head_row').height() + 'px')
}

function myName() {
    $$('#name').click(function () {
        app.dialog.prompt("请输入姓名：", "", function (value) {
            $$('#name .item-inner .item-after').html(value)
        })
    })
}

function myGender() {
    $$('.male_click').on('click', function () {
        var crete = app.dialog.create({
            title: '',
            text: '请选择你的性别',
            buttons: [
                {
                    text: '男士',
                },
                {
                    text: '女士',
                },
            ],
            verticalButtons: true,
            onClick: function(dialog, index) {
                if(index == 0)
                    $$('#gender .item-inner .item-after').html('男')
                else if(index == 1)
                    $$('#gender .item-inner .item-after').html('女')
            }
        }).open();
    });
}