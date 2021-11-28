$(function () {
    var message = new Vue({
        el: "#message",
        data: {
            message: "<h1>Hello</h1>",
            isShow: false,
            active: "https://fuxx-1.gitee.io/images/background.png",
        },
        methods: {
            changeState1: function () {
                this.isShow = !this.isShow;
            }
        }
    })
    var message2 = new Vue({
        el: "#message2",
        data: {
            nums: 1,
            message2: "<h1>Hello</h1>",
            value: "输入信息"
        },
        methods: {
            changeState2: function () {
                alert(this.nums);
            }
        }
    })
})