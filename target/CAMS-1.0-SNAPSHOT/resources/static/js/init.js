function pullToRefresh(url) {
    var ptrContent = $$('.ptr-content');
    ptrContent.on('ptr:refresh', function (e) {
        setTimeout(function () {
            app.router.navigate(url, {
                reloadCurrent: true,
                ignoreCache: true,
            });
            app.ptr.done()
        }, 2000)
    });
}

var app = new Framework7({
    // App root element
    root: '#app',
    // App Name
    name: 'My App',
    // App id
    id: 'com.chain-store.carrier',
    // Enable swipe panel
    panel: {
        swipe: 'left',
    },
    dialog: {
        title: '',
        buttonOk: '确定',
        buttonCancel: '取消',
    },
    // Add default routes
    routes: [
        //登录验证
        {
            path: '/login/',
            url: '/login',
            on: {
                pageInit: function (e, page) {
                },
            }
        },
        {
            path: '/main/',
            url: '/main',
            on: {
                pageInit: function (e, page) {
                },

                pageBeforeIn: function (e, page) {
                    $$('.ios_title').attr('style', 'margin: 0 auto; left: 0!important')
                },

                pageAfterIn: function (e, page) {
                    mainCss()
                }
            }
        },
        {
            path: '/new_friend/',
            url: '/new_friend',
            on: {
                pageInit: function (e, page) {
                },
            }
        },
        {
            path: '/contact_detail/',
            url: '/contact_detail',
            on: {
                pageInit: function (e, page) {
                    deleteContact()
                    setRemark()
                },
            }
        },
        {
            path: '/course_detail/',
            url: '/course_detail',
            on: {
                pageInit: function (e, page) {
                },
            }
        },
        {
            path: '/course_information/',
            url: '/course_information',
            on: {
                pageInit: function (e, page) {
                },
            }
        },
        {
            path: '/student_information/',
            url: '/student_information',
            on: {
                pageInit: function (e, page) {
                    myGender();
                    myName();
                },
                pageBeforeIn: function (e, page) {
                    myHead();
                }
            }
        },
        {
            path: '/student_information_school/',
            url: '/student_information_school',
            on: {
                pageInit: function (e, page) {
                   searchSchool();
                },
                pageBeforeIn: function (e, page) {
                }
            }
        },

        {
            path: '/student_information_grade/',
            url: '/student_information_grade',
            on: {
                pageInit: function (e, page) {
                    pickGrade()
                },
                pageBeforeIn: function (e, page) {
                }
            }
        },

        {
            path: '/student_information_signature/',
            url: '/student_information_signature',
            on: {
                pageInit: function (e, page) {
                },
                pageBeforeIn: function (e, page) {
                }
            }
        },
        {
            path: '/change_password/',
            url: '/change_password',
            on: {
                pageInit: function (e, page) {
                },
            }
        },
        {
            path: '/api/login_auth',
            url: '/api/login_auth',
            on: {
                pageInit: function (e, page) {
                },
            }
        },


    ],
});

var $$ = Dom7;

var mainView = app.views.create('.view-main');
