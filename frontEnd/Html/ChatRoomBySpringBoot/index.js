window.onload = function () {
    console.log("Hello");
    Vue.component("friendmessage", {
        props: ['info', 'avator'],
        template: '' +
            '<div class="row clearfix messageinnerbox">' +
                '<div class="col-sm-1 column"><img v-bind:src="avator" alt="" style="width: 2.4vw;border-radius: 50px;"></div>' +
                '<div class="col-sm-8 column messagestyle">{{info.msg}}</div>' +
                '<div class="col-sm-3 column"></div>' +
            '</div>'
    });
    Vue.component("mymessage", {
        props: ['info', 'avator'],
        template: '' +
            '<div class="row clearfix messageinnerbox">' +
            '<div class="col-sm-3 column"></div>' +
            '<div class="col-sm-8 column messagestyle">{{info.msg}}</div>' +
            '<div class="col-sm-1 column"><img v-bind:src="avator" alt="" style="width: 2.4vw;border-radius: 50px;"></div>' +
            '</div>'
    });
    var app = new Vue({
        el: '#app',
        data: {
            AuthInfo: "Copyright © 2021 聊天室 newimg.ltd",
            FriendList: [{
                avator: "https://portrait.gitee.com/uploads/avatars/user/2904/8712733_fuxx-1_1636456540.png!avatar200",
                name: "Fuxx"
            }],
            FriendAvator: "https://portrait.gitee.com/uploads/avatars/user/2904/8712733_fuxx-1_1636456540.png!avatar200",
            MyAvator: "https://portrait.gitee.com/uploads/avatars/user/2904/8712733_fuxx-1_1636456540.png!avatar200",
            Info: [{
                    isMine: false,
                    msg: 'friendMsg',
                },
                {
                    isMine: true,
                    msg: 'MyMsg',
                },
                {
                    isMine: false,
                    msg: 'friendMsg2',
                },
                {
                    isMine: true,
                    msg: 'MyMsg2fdsaaaaewriuoeiuokzvcxmnewryiqosdfasdfklasjdf;laksdjfdsfasdfkljlasdfjaskdfjaklfsd;lfkjewporijadvnm.',
                }
            ],
        }
    });
}