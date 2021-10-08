var __reflect = this && this.__reflect || function (e, t, i) {
        e.__class__ = t, i ? i.push(t) : i = [t], e.__types__ = e.__types__ ? i.concat(e.__types__) : i
    },
    __extends = this && this.__extends || function (e, t) {
        function i() {
            this.constructor = e
        }
        for (var n in t) t.hasOwnProperty(n) && (e[n] = t[n]);
        e.prototype = null === t ? Object.create(t) : (i.prototype = t.prototype, new i)
    },
    control_type = function () {
        function e() {}
        return e
    }();
control_type.control_image = "ImageViewObjectData", control_type.control_textfield = "TextObjectData", __reflect(control_type.prototype, "control_type");
var WinBase = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t.touchEnabled = !0, t
    }
    return __extends(t, e), t.prototype.create = function (e) {
        this.groupName = e, RES.isGroupLoaded(this.groupName) ? this.creating() : (RES.addEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this), RES.addEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this), RES.addEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this), RES.loadGroup(this.groupName), WndManager.root.loading.visible = !0, WndManager.root.loading.update())
    }, t.prototype.creating = function () {
        this.createOk()
    }, t.prototype.createOk = function () {}, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t.prototype.onResourceLoadComplete = function (e) {
        e.groupName == this.groupName && (WndManager.root.loading.onRemove(), WndManager.root.loading.visible = !1, RES.removeEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this), RES.removeEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this), RES.removeEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this), this.creating())
    }, t.prototype.onResourceLoadError = function (e) {
        e.groupName == this.groupName && (console.warn("Group:" + e.groupName + " has failed to load"), this.onResourceLoadComplete(e))
    }, t.prototype.onResourceProgress = function (e) {
        e.groupName == this.groupName && WndManager.root.loading.setProgress(e.itemsLoaded, e.itemsTotal)
    }, t
}(egret.Sprite);
__reflect(WinBase.prototype, "WinBase");
var MyUtils = function () {
    function e() {}
    return e.GetBtn = function (t, i, n) {
        var r = new egret.Sprite;
        return r.x = t, r.y = i, r.touchEnabled = !0, r.addChild(e.createBitmapByName(n)), r
    }, e.GetBtn1 = function (e, t, i, n) {
        var r = new egret.Sprite;
        return r.graphics.beginFill(65280, 0), r.graphics.drawRect(0, 0, e, t), r.graphics.endFill(), r.width = e, r.height = t, r.x = i, r.y = n, r.touchEnabled = !0, r
    }, e.createBitmapByName = function (e, t, i, n, r, s) {
        void 0 === t && (t = 0), void 0 === i && (i = 0), void 0 === n && (n = 0), void 0 === r && (r = 0), void 0 === s && (s = "");
        var o = new egret.Bitmap,
            a = RES.getRes(e);
        switch (o.texture = a, o.touchEnabled = !0, 0 == t && (t = o.width), 0 == i && (i = o.height), s) {
            case "c_u":
                o.anchorOffsetX = o.width / 2;
                break;
            case "r_u":
                o.anchorOffsetX = o.width;
                break;
            case "r_c":
                o.anchorOffsetX = o.width, o.anchorOffsetY = o.height / 2;
                break;
            case "c_c":
                o.anchorOffsetX = o.width / 2, o.anchorOffsetY = o.height / 2;
                break;
            case "l_c":
                o.anchorOffsetY = o.height / 2;
                break;
            case "l_d":
                o.anchorOffsetY = o.height;
                break;
            case "c_d":
                o.anchorOffsetX = o.width / 2, o.anchorOffsetY = o.height;
                break;
            case "r_d":
                o.anchorOffsetX = o.width, o.anchorOffsetY = o.height
        }
        return o.x = n + o.anchorOffsetX, o.y = r + o.anchorOffsetY, o
    }, e.createImageByName = function (e, t, i, n, r, s) {
        void 0 === t && (t = 0), void 0 === i && (i = 0), void 0 === n && (n = 0), void 0 === r && (r = 0), void 0 === s && (s = "");
        var o = new eui.Image;
        switch (o.source = RES.getRes(e), s) {
            case "c_u":
                o.anchorOffsetX = t / 2;
                break;
            case "r_u":
                o.anchorOffsetX = t;
                break;
            case "r_c":
                o.anchorOffsetX = t, o.anchorOffsetY = i / 2;
                break;
            case "c_c":
                o.anchorOffsetX = t / 2, o.anchorOffsetY = i / 2;
                break;
            case "l_c":
                o.anchorOffsetY = i / 2;
                break;
            case "l_d":
                o.anchorOffsetY = i;
                break;
            case "c_d":
                o.anchorOffsetX = t / 2, o.anchorOffsetY = i;
                break;
            case "r_d":
                o.anchorOffsetX = t, o.anchorOffsetY = i
        }
        return o.x = n + o.anchorOffsetX, o.y = r + o.anchorOffsetY, o
    }, e.createImageByNameUrl = function (t, i, n, r, s, o) {
        void 0 === i && (i = 0), void 0 === n && (n = 0), void 0 === o && (o = "");
        var a = new eui.Image;
        switch (a.source = e._srcUrl + t, o) {
            case "c_u":
                a.anchorOffsetX = i / 2;
                break;
            case "r_u":
                a.anchorOffsetX = i;
                break;
            case "r_c":
                a.anchorOffsetX = i, a.anchorOffsetY = n / 2;
                break;
            case "c_c":
                a.anchorOffsetX = i / 2, a.anchorOffsetY = n / 2;
                break;
            case "l_c":
                a.anchorOffsetY = n / 2;
                break;
            case "l_d":
                a.anchorOffsetY = n;
                break;
            case "c_d":
                a.anchorOffsetX = i / 2, a.anchorOffsetY = n;
                break;
            case "r_d":
                a.anchorOffsetX = i, a.anchorOffsetY = n
        }
        return a.x = r + a.anchorOffsetX, a.y = s + a.anchorOffsetY, a.touchEnabled = !1, a
    }, e.getMovieClip = function (e) {
        var t = RES.getRes(e + "_json"),
            i = RES.getRes(e + "_png"),
            n = new egret.MovieClipDataFactory(t, i),
            r = n.generateMovieClipData(e),
            s = new egret.MovieClip(r);
        return s
    }, e.GetRequest = function () {
        var e = document.location.search,
            t = new Object;
        if (-1 != e.indexOf("?"))
            for (var i = e.substr(1), n = i.split("&"), r = 0; r < n.length; r++) t[n[r].split("=")[0]] = n[r].split("=")[1];
        return t
    }, e.getMyParamer = function (t) {
        var i = new Object;
        return i = e.GetRequest(), i[t]
    }, e.calcStringByte = function (t) {
        e.by.writeUTFBytes(t);
        var i = e.by.length;
        return e.by.clear(), i
    }, e.hitTest = function (e, t) {
        var i = e.getBounds();
        i.x = e.x, i.y = e.y;
        var n = t.getBounds();
        return n.x = t.x, n.y = t.y, i.intersects(n) ? !0 : !1
    }, e.hitTest1 = function (e, t) {
        var i = e.getBounds();
        i.x = e.x, i.y = e.y;
        var n = t.getBounds();
        return n.x = t.x, n.y = t.y, n.width = 30, n.height = 30, i.intersects(n) ? !0 : !1
    }, e.isPhoneNumber = function (e) {
        var t = /^(13[0-9]|15[012356789]|17[0-9]|18[0-9]|19[012356789]|14[57]|16[678])[0-9]{8}$/;
        return t.test(e) ? !0 : !1
    }, e.setAorn = function (e) {
        e.anchorOffsetX = e.width / 2, e.anchorOffsetY = e.height / 2
    }, e
}();
MyUtils._srcUrl = "", MyUtils.by = new egret.ByteArray, __reflect(MyUtils.prototype, "MyUtils");
var MainScene = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._code = "null", t._isQmp = !1, t._total = 5, t._sendTotal = 5, t._buttonEff = null, t._prop = new Protocol, t.addEventListener(egret.Event.ADDED_TO_STAGE, t.onAddToStage, t), t
    }
    return __extends(t, e), t.prototype.onAddToStage = function (e) {
        if (egret.ImageLoader.crossOrigin = "anonymous", isWeixin() && (shareUrl = weixinUrl, document.domain.indexOf("cbwl") < 0)) return void window.location.replace(weixinUrl);
        "iOS" != egret.Capabilities.os && "Android" != egret.Capabilities.os && "Windows Phone" != egret.Capabilities.os && (this.stage.orientation = egret.OrientationMode.AUTO, this.stage.scaleMode = egret.StageScaleMode.SHOW_ALL), console.log(egret.Capabilities.os), console.log("clientHeight==>", document.documentElement.clientHeight, document.documentElement.clientWidth);
        var t = 750 / document.documentElement.clientWidth;
        console.log("wBL==>", t), this._hBL = t * document.documentElement.clientHeight, console.log("hBL==>", this._hBL), this._hBL > 1448 ? (this.y = 0, this._upDot = 0, this._downDot = 1448, this._hBL = 1448) : this._hBL > 1212 ? (this.y = -((1448 - this._hBL) / 2), this._upDot = (1448 - this._hBL) / 2, this._downDot = 1448 - (1448 - this._hBL) / 2) : (this.y = -118, this._upDot = 118, this._downDot = 1330, this._hBL = 1212), this.stage.setContentSize(750, this._hBL), this._isQmp = !1, WndManager.root = this, this.wndmanager = new WndManager, this.soundExample = new SoundExample, this.addChild(this.wndmanager), this.loading = new Loading, this.addChildAt(this.loading, 0), RES.addEventListener(RES.ResourceEvent.CONFIG_COMPLETE, this.onConfigComplete, this), RES.loadConfig(config_json.clientUrl + "resource/default.res.json?v=" + versions, config_json.clientUrl + "resource/"), this.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlaySound, this)
    }, t.prototype.onPlaySound = function (e) {
        this.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlaySound, this);
        var t = document.getElementById("bgMusic");
        t.play()
    }, t.prototype.onConfigComplete = function (e) {
        RES.removeEventListener(RES.ResourceEvent.CONFIG_COMPLETE, this.onConfigComplete, this), RES.addEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this), RES.addEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this), RES.addEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this), RES.loadGroup("loading")
    }, t.prototype.onResourceLoadComplete = function (e) {
        if ("loading" == e.groupName) {
            var i = document.location.search;
            new Object; - 1 != i.indexOf("?") && egret.log("有参数！：", i), this.loading.update(), WndManager.root.onAddPetals(), "" != musicUrl && this.onAddEffectBtn(), RES.loadGroup("begin")
        } else "begin" == e.groupName && (RES.removeEventListener(RES.ResourceEvent.GROUP_COMPLETE, this.onResourceLoadComplete, this), RES.removeEventListener(RES.ResourceEvent.GROUP_LOAD_ERROR, this.onResourceLoadError, this), RES.removeEventListener(RES.ResourceEvent.GROUP_PROGRESS, this.onResourceProgress, this), WndManager.root._prop._openid = t.getItemByName("openid"), WndManager.root._prop._nickname = t.getItemByName("nickname"), WndManager.root._prop._headimgurl = t.getItemByName("headimgurl"), WndManager.root._prop._sex = t.getItemByName("sex"), WndManager.root._prop._country = t.getItemByName("country"), WndManager.root._prop._province = t.getItemByName("province"), WndManager.root._prop._city = t.getItemByName("city"), WndManager.root._prop._toOpenid = t.getItemByName("toOpenid"), WndManager.root._prop._token = t.getItemByName("token"), WndManager.root._prop._codeStr = t.getItemByName("yscdk"), WndManager.root._prop._serverUrl = config_json.serverUrl, console.log(config_json.scene1data), this.onEnterGame(), RES.loadGroup("com"))
    }, t.prototype.onEnterGame = function () {
        var e = this;
        this.loading.removeEventListener("onNextPage", this.onEnterGame, this), egret.setTimeout(function () {
            e.loading.onRemove(), e.loading.visible = !1
        }, this, 500), WndManager.switchWnd(BeginWnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA)
    }, t.prototype.onAddEffectBtn = function () {
        this._buttonEff = new ButtonEff, this._buttonEff.x = 700, this._buttonEff.y = this._upDot + 50, this.addChild(this._buttonEff)
    }, t.prototype.onAddPetals = function () {
        null != this._newPetals && (this._newPetals.stop(), this._newPetals.parent.removeChild(this._newPetals), this._newPetals = null), this._newPetals = new particle.GravityParticleSystem(RES.getRes("newParticle_png"), RES.getRes("newParticle_json")), this.addChild(this._newPetals), this._newPetals.touchEnabled = !1, this._newPetals.start()
    }, t.prototype.onResourceLoadError = function (e) {
        console.warn("Group:" + e.groupName + " has failed to load"), this.onResourceLoadComplete(e)
    }, t.prototype.onResourceProgress = function (e) {
        "common" == e.groupName && this.loading.setProgress(e.itemsLoaded, e.itemsTotal), "begin" == e.groupName && this.loading.setProgress(e.itemsLoaded, e.itemsTotal)
    }, t.getItemByName = function (e) {
        var t;
        return t = decodeURIComponent(this.getCookie(e)), t || (t = window.localStorage.getItem(e), t || (t = egret.localStorage.getItem(e))), t
    }, t.getCookie = function (e) {
        var t, i = new RegExp("(^| )" + e + "=([^;]*)(;|$)");
        return (t = document.cookie.match(i)) ? t[2] : null
    }, t
}(egret.DisplayObjectContainer);
__reflect(MainScene.prototype, "MainScene");
var Protocol = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._headimgurl = "https://thirdwx.qlogo.cn/mmopen/vi_32/iaRAVC3t5Ts0HXnjP1djKEK8OOwOHy1DdlTJhbdkzV6nDJexpXCAQOeZpQEQtUfoqiadVHic8Pt9CR1Ze2o5prcXA/132", t._nickname = "微信昵称", t._test = "?test=1&", t._lotteryBol = !0, t._level = 0, t._input = !1, t._gk = 0, t._bz = 0, t._endFun = null, t._texture = null, t._codeStr = "sadjhkashdj", t.onFindInfo_data = null, t.onGetCode_data = null, t.onSaveinfo_data = null, t.onGameHandler_data = null, t.onFacePort_data = null, t.onActvInfo_data = null, t.onGetLocation_data = null, t.onUploadWx_data = null, t._mask = null, t
    }
    return __extends(t, e), t.prototype.onEnterGame = function () {
        var e = this,
            t = new egret.Event("onEnterGame");
        e.dispatchEvent(t)
    }, t.prototype.onFindInfo = function () {
        var e = WndManager.root._prop._serverUrl + "/xsh5/wx/count",
            t = "";
        console.log("查询用户信息==>", e, t);
        var i = new egret.HttpRequest,
            n = this;
        i.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget;
            console.log(t.response);
            var i = JSON.parse(t.response);
            i && (n.onFindInfo_data = i), console.log("查询用户信息返回数据：", n.onFindInfo_data);
            var r = new egret.Event("onFindInfo");
            n.dispatchEvent(r)
        }, this), i.responseType = egret.HttpResponseType.TEXT, i.open(e, egret.HttpMethod.GET), i.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), i.send()
    }, t.prototype.onGetCode = function () {
        var e = WndManager.root._prop._serverUrl,
            t = "";
        console.log("领取==>", e, t);
        var i = new egret.HttpRequest,
            n = this;
        i.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget;
            console.log(t.response);
            var i = JSON.parse(t.response);
            i && (n.onGetCode_data = i), console.log("领取返回数据：", n.onGetCode_data);
            var r = new egret.Event("onGetCode");
            n.dispatchEvent(r)
        }, this), i.responseType = egret.HttpResponseType.TEXT, i.open(e, egret.HttpMethod.GET), i.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), i.send()
    }, t.prototype.onSaveinfo = function (e, t, i) {
        var n = WndManager.root._prop._serverUrl + "api.php",
            r = "a=SubInfo&tel=" + t + "&name=" + e + "&addr=" + i;
        console.log("保存中奖信息==>", n, r);
        var s = new egret.HttpRequest,
            o = this;
        s.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget;
            console.log(t.response);
            var i = JSON.parse(t.response);
            i && (o.onSaveinfo_data = i), console.log("保存中奖信息返回数据：", o.onSaveinfo_data);
            var n = new egret.Event("onSaveinfo");
            o.dispatchEvent(n)
        }, this), s.responseType = egret.HttpResponseType.TEXT, s.open(n, egret.HttpMethod.POST), s.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), s.send(r)
    }, t.prototype.onGameHandler = function (e, t) {
        var i = WndManager.root._prop._serverUrl + "api.php",
            n = "a=Game&gk=" + e + "&bz=" + t;
        console.log("保存中奖信息==>", i, n);
        var r = new egret.HttpRequest,
            s = this;
        r.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget;
            console.log(t.response);
            var i = JSON.parse(t.response);
            i && (s.onGameHandler_data = i), console.log("保存中奖信息返回数据：", s.onGameHandler_data);
            var n = new egret.Event("onGameHandler");
            s.dispatchEvent(n)
        }, this), r.responseType = egret.HttpResponseType.TEXT, r.open(i, egret.HttpMethod.POST), r.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), r.send(n)
    }, t.prototype.onFacePort = function (e, t, i, n, r) {
        void 0 === e && (e = "O3KtTWdse2LBO7amnDwTEmlFILXftaKu"), void 0 === t && (t = "NkLyUdtCWYU6zgxIcC4F4b3ELCmRcdXp"), void 0 === i && (i = "https://test.vmih5.com/lzg/10/adtp/resource/begin/select_2_img.jpg"), void 0 === n && (n = "181,238,87,108"), void 0 === r && (r = "https://test.vmih5.com/lzg/10/adtp/resource/begin/222.jpg");
        var s = "https://api-cn.faceplusplus.com/imagepp/v1/mergeface",
            o = "api_key=" + e + "&api_secret=" + t + "&template_url=" + encodeURIComponent(i) + "&template_rectangle=" + n + "&merge_url=" + encodeURIComponent(r) + "&merge_rate=80&feature_rate=80";
        console.log("进入游戏==>", s, o);
        var a = new egret.HttpRequest,
            l = this;
        a.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget,
                i = JSON.parse(t.response);
            i && (l.onFacePort_data = i), console.log("进入游戏返回数据：", l.onFacePort_data), l.uploadData(l.onFacePort_data.result);
            var n = new egret.Event("onFacePort");
            l.dispatchEvent(n)
        }, this), a.responseType = egret.HttpResponseType.TEXT, a.open(s, egret.HttpMethod.POST), a.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), a.send(o)
    }, t.prototype.onActvInfo = function () {
        var e = "https://activity2.changyou.com/appoint/actvInfo.ncdo",
            t = "callback",
            i = e + "?game=tl3d&actvKey=tl_201803&" + t + "=test";
        console.log(i), JsonpReq.process(i, this.onActvInfoReturn, this)
    }, t.prototype.onActvInfoReturn = function (e) {
        WndManager.root._prop.onActvInfo_data = e, console.log("跨域请求：", WndManager.root._prop.onActvInfo_data);
        var t = new egret.Event("onActvInfo");
        WndManager.root._prop.dispatchEvent(t)
    }, t.prototype.onGetLocation = function (e) {
        void 0 === e && (e = "28.240732,112.97735");
        var t = "https://wgame.9fsz.com/guns/authcApi/jak_scale/localtion",
            i = "test=1&location=" + e;
        console.log("获取地理位置==>", t, i);
        var n = new egret.HttpRequest,
            r = this;
        n.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget,
                i = JSON.parse(t.response);
            i && (r.onGetLocation_data = i), console.log("获取地理位置返回数据：", r.onGetLocation_data);
            var n = new egret.Event("onGetLocation");
            r.dispatchEvent(n)
        }, this), n.responseType = egret.HttpResponseType.TEXT, n.open(t, egret.HttpMethod.POST), n.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), n.send(i)
    }, t.prototype.onUploadWx = function (e) {
        console.log("__mediaId===>", e);
        var t = "https://wgame.9fsz.com/jiufan/api/oss/uploadWx",
            i = "mediaId=" + e + "&check=1&code=" + _currentCode + "&type=jpg";
        console.log("获取微信照片==>", t, i);
        var n = new egret.HttpRequest,
            r = this;
        n.addEventListener(egret.Event.COMPLETE, function (e) {
            var t = e.currentTarget;
            console.log(t.response);
            var i = JSON.parse(t.response);
            i && (r.onUploadWx_data = i), 200 == r.onUploadWx_data.code || wy.Toast.setContent(r.onUploadWx_data.message), console.log("获取微信照片返回数据：", r.onUploadWx_data);
            var n = new egret.Event("onChooseImage");
            r.dispatchEvent(n)
        }, this), n.responseType = egret.HttpResponseType.TEXT, n.open(t, egret.HttpMethod.POST), n.withCredentials = !0, n.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), n.send(i)
    }, t.prototype.uploadData = function (e) {
        null == WndManager.root._prop._mask && (WndManager.root._prop._mask = DrawGraphics.onDrawGraphicsSquare(0, 0, WndManager.root.stage.stageWidth, WndManager.root.stage.stageHeight, 16777215, 0, !0), WndManager.root.addChild(WndManager.root._prop._mask)), WndManager.root._prop._base64Str = e;
        var t, i = TransitionTimestamp.onFormatDate(String(Math.floor(serverTime / 1e3)))[4][0];
        t = "test=1&check=1&code=face/test/" + i + "&type=png&base64=" + e;
        var n = new egret.HttpRequest;
        n.responseType = egret.HttpResponseType.TEXT, n.open("https://wgame.9fsz.com/guns/ali/oss/upload?", egret.HttpMethod.POST), n.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"), n.send(t), n.addEventListener(egret.Event.COMPLETE, this.onDataComplete, this), n.addEventListener(egret.IOErrorEvent.IO_ERROR, this.onPostIOError, this), n.addEventListener(egret.ProgressEvent.PROGRESS, this.onPostProgress, this)
    }, t.prototype.onDataComplete = function (e) {
        e.currentTarget.removeEventListener(egret.Event.COMPLETE, this.onDataComplete, this), e.currentTarget.removeEventListener(egret.IOErrorEvent.IO_ERROR, this.onPostIOError, this), e.currentTarget.removeEventListener(egret.ProgressEvent.PROGRESS, this.onPostProgress, this);
        var t = e.currentTarget,
            i = String(t.response);
        egret.log("onDataComplete data 11111: " + i), null != WndManager.root._prop._mask && (WndManager.root._prop._mask.parent.removeChild(WndManager.root._prop._mask), WndManager.root._prop._mask = null);
        var n = JSON.parse(i);
        WndManager.root._prop.onDataComplete_data = n.data, console.log(WndManager.root._prop.onDataComplete_data), WndManager.root._prop.dispatchEvent(new egret.Event("onChooseImage"))
    }, t.prototype.onPostIOError = function (e) {
        e.currentTarget.removeEventListener(egret.Event.COMPLETE, this.onDataComplete, this), e.currentTarget.removeEventListener(egret.IOErrorEvent.IO_ERROR, this.onPostIOError, this), e.currentTarget.removeEventListener(egret.ProgressEvent.PROGRESS, this.onPostProgress, this), console.log("post error : " + e), egret.setTimeout(function () {
            WndManager.root._prop.uploadData(WndManager.root._prop._base64Str)
        }, this, 500)
    }, t.prototype.onPostProgress = function (e) {
        console.log("post progress : " + Math.floor(100 * e.bytesLoaded / e.bytesTotal) + "%")
    }, t
}(egret.Sprite);
__reflect(Protocol.prototype, "Protocol");
var qr;
! function (e) {
    var t = function () {
        function t(t) {
            this.mode = e.QRMode.MODE_8BIT_BYTE, this.data = t, this.parsedData = [];
            for (var i = 0, n = this.data.length; n > i; i++) {
                var r = [],
                    s = this.data.charCodeAt(i);
                s > 65536 ? (r[0] = 240 | (1835008 & s) >>> 18, r[1] = 128 | (258048 & s) >>> 12, r[2] = 128 | (4032 & s) >>> 6, r[3] = 128 | 63 & s) : s > 2048 ? (r[0] = 224 | (61440 & s) >>> 12, r[1] = 128 | (4032 & s) >>> 6, r[2] = 128 | 63 & s) : s > 128 ? (r[0] = 192 | (1984 & s) >>> 6, r[1] = 128 | 63 & s) : r[0] = s, this.parsedData.push(r)
            }
            this.parsedData = Array.prototype.concat.apply([], this.parsedData), this.parsedData.length != this.data.length && (this.parsedData.unshift(191), this.parsedData.unshift(187), this.parsedData.unshift(239))
        }
        return t.prototype.getLength = function (e) {
            return this.parsedData.length
        }, t.prototype.write = function (e) {
            for (var t = 0, i = this.parsedData.length; i > t; t++) e.put(this.parsedData[t], 8)
        }, t
    }();
    e.QR8bitByte = t, __reflect(t.prototype, "qr.QR8bitByte")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e() {
            this.buffer = [], this.length = 0
        }
        return e.prototype.get = function (e) {
            var t = Math.floor(e / 8);
            return 1 == (this.buffer[t] >>> 7 - e % 8 & 1)
        }, e.prototype.put = function (e, t) {
            for (var i = 0; t > i; i++) this.putBit(1 == (e >>> t - i - 1 & 1))
        }, e.prototype.getLengthInBits = function () {
            return this.length
        }, e.prototype.putBit = function (e) {
            var t = Math.floor(this.length / 8);
            this.buffer.length <= t && this.buffer.push(0), e && (this.buffer[t] |= 128 >>> this.length % 8), this.length++
        }, e
    }();
    e.QRBitBuffer = t, __reflect(t.prototype, "qr.QRBitBuffer")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function t() {}
        return t.create = function (i, n, r, s, o, a) {
            void 0 === n && (n = 200), void 0 === r && (r = 200), void 0 === s && (s = e.QRErrorCorrectLevel.H), void 0 === o && (o = 10), void 0 === a && (a = 1060437);
            var l = {
                    color: a,
                    width: n,
                    height: r,
                    correctLevel: s,
                    typeNumer: o
                },
                h = new e.QRCodeModel(l.typeNumer, l.correctLevel);
            return h.addData(i), h.make(), t.draw(h, l)
        }, t.draw = function (e, t) {
            var i = new egret.Sprite,
                t = t,
                n = e.getModuleCount(),
                r = t.width / n,
                s = t.height / n,
                o = 5;
            i.graphics.moveTo(-o, -o), i.graphics.beginFill(16777215), i.graphics.drawRect(-o, -o, t.width + 2 * o, t.height + 2 * o), i.graphics.endFill();
            for (var a = 0; n > a; a++)
                for (var l = 0; n > l; l++) {
                    var h = e.isDark(a, l);
                    h && (i.graphics.moveTo(l * r, a * s), i.graphics.beginFill(t.color), i.graphics.drawRect(l * r, a * s, r, s), i.graphics.endFill())
                }
            return i
        }, t
    }();
    e.QRCode = t, __reflect(t.prototype, "qr.QRCode")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function t(e, t) {
            this.modules = null, this.moduleCount = 0, this.dataCache = null, this.dataList = [], this.typeNumber = e, this.errorCorrectLevel = t, this.modules = null, this.moduleCount = 0, this.dataCache = null, this.dataList = []
        }
        return t.prototype.addData = function (t) {
            var i = new e.QR8bitByte(t);
            this.dataList.push(i), this.dataCache = null
        }, t.prototype.isDark = function (e, t) {
            if (0 > e || this.moduleCount <= e || 0 > t || this.moduleCount <= t) throw new Error(e + "," + t);
            return this.modules[e][t]
        }, t.prototype.getModuleCount = function () {
            return this.moduleCount
        }, t.prototype.make = function () {
            this.makeImpl(!1, this.getBestMaskPattern())
        }, t.prototype.makeImpl = function (e, i) {
            this.moduleCount = 4 * this.typeNumber + 17, this.modules = new Array(this.moduleCount);
            for (var n = 0; n < this.moduleCount; n++) {
                this.modules[n] = new Array(this.moduleCount);
                for (var r = 0; r < this.moduleCount; r++) this.modules[n][r] = null
            }
            this.setupPositionProbePattern(0, 0), this.setupPositionProbePattern(this.moduleCount - 7, 0), this.setupPositionProbePattern(0, this.moduleCount - 7), this.setupPositionAdjustPattern(), this.setupTimingPattern(), this.setupTypeInfo(e, i), this.typeNumber >= 7 && this.setupTypeNumber(e), null == this.dataCache && (this.dataCache = t.createData(this.typeNumber, this.errorCorrectLevel, this.dataList)), this.mapData(this.dataCache, i)
        }, t.prototype.setupPositionProbePattern = function (e, t) {
            for (var i = -1; 7 >= i; i++)
                if (!(-1 >= e + i || this.moduleCount <= e + i))
                    for (var n = -1; 7 >= n; n++) - 1 >= t + n || this.moduleCount <= t + n || (i >= 0 && 6 >= i && (0 == n || 6 == n) || n >= 0 && 6 >= n && (0 == i || 6 == i) || i >= 2 && 4 >= i && n >= 2 && 4 >= n ? this.modules[e + i][t + n] = !0 : this.modules[e + i][t + n] = !1)
        }, t.prototype.getBestMaskPattern = function () {
            for (var t = 0, i = 0, n = 0; 8 > n; n++) {
                this.makeImpl(!0, n);
                var r = e.QRUtil.getLostPoint(this);
                (0 == n || t > r) && (t = r, i = n)
            }
            return i
        }, t.prototype.createMovieClip = function (e, t, i) {
            var n = e.createEmptyMovieClip(t, i),
                r = 1;
            this.make();
            for (var s = 0; s < this.modules.length; s++)
                for (var o = s * r, a = 0; a < this.modules[s].length; a++) {
                    var l = a * r,
                        h = this.modules[s][a];
                    h && (n.beginFill(0, 100), n.moveTo(l, o), n.lineTo(l + r, o), n.lineTo(l + r, o + r), n.lineTo(l, o + r), n.endFill())
                }
            return n
        }, t.prototype.setupTimingPattern = function () {
            for (var e = 8; e < this.moduleCount - 8; e++) null == this.modules[e][6] && (this.modules[e][6] = e % 2 == 0);
            for (var t = 8; t < this.moduleCount - 8; t++) null == this.modules[6][t] && (this.modules[6][t] = t % 2 == 0)
        }, t.prototype.setupPositionAdjustPattern = function () {
            for (var t = e.QRUtil.getPatternPosition(this.typeNumber), i = 0; i < t.length; i++)
                for (var n = 0; n < t.length; n++) {
                    var r = t[i],
                        s = t[n];
                    if (null == this.modules[r][s])
                        for (var o = -2; 2 >= o; o++)
                            for (var a = -2; 2 >= a; a++) - 2 == o || 2 == o || -2 == a || 2 == a || 0 == o && 0 == a ? this.modules[r + o][s + a] = !0 : this.modules[r + o][s + a] = !1
                }
        }, t.prototype.setupTypeNumber = function (t) {
            for (var i = e.QRUtil.getBCHTypeNumber(this.typeNumber), n = 0; 18 > n; n++) {
                var r = !t && 1 == (i >> n & 1);
                this.modules[Math.floor(n / 3)][n % 3 + this.moduleCount - 8 - 3] = r
            }
            for (var n = 0; 18 > n; n++) {
                var r = !t && 1 == (i >> n & 1);
                this.modules[n % 3 + this.moduleCount - 8 - 3][Math.floor(n / 3)] = r
            }
        }, t.prototype.setupTypeInfo = function (t, i) {
            for (var n = this.errorCorrectLevel << 3 | i, r = e.QRUtil.getBCHTypeInfo(n), s = 0; 15 > s; s++) {
                var o = !t && 1 == (r >> s & 1);
                6 > s ? this.modules[s][8] = o : 8 > s ? this.modules[s + 1][8] = o : this.modules[this.moduleCount - 15 + s][8] = o
            }
            for (var s = 0; 15 > s; s++) {
                var o = !t && 1 == (r >> s & 1);
                8 > s ? this.modules[8][this.moduleCount - s - 1] = o : 9 > s ? this.modules[8][15 - s - 1 + 1] = o : this.modules[8][15 - s - 1] = o
            }
            this.modules[this.moduleCount - 8][8] = !t
        }, t.prototype.mapData = function (t, i) {
            for (var n = -1, r = this.moduleCount - 1, s = 7, o = 0, a = this.moduleCount - 1; a > 0; a -= 2)
                for (6 == a && a--;;) {
                    for (var l = 0; 2 > l; l++)
                        if (null == this.modules[r][a - l]) {
                            var h = !1;
                            o < t.length && (h = 1 == (t[o] >>> s & 1));
                            var _ = e.QRUtil.getMask(i, r, a - l);
                            _ && (h = !h), this.modules[r][a - l] = h, s--, -1 == s && (o++, s = 7)
                        } if (r += n, 0 > r || this.moduleCount <= r) {
                        r -= n, n = -n;
                        break
                    }
                }
        }, t.createData = function (i, n, r) {
            for (var s = e.QRRSBlock.getRSBlocks(i, n), o = new e.QRBitBuffer, a = 0; a < r.length; a++) {
                var l = r[a];
                o.put(l.mode, 4), o.put(l.getLength(), e.QRUtil.getLengthInBits(l.mode, i)), l.write(o)
            }
            for (var h = 0, a = 0; a < s.length; a++) h += s[a].dataCount;
            for (o.getLengthInBits() + 4 <= 8 * h && o.put(0, 4); o.getLengthInBits() % 8 != 0;) o.putBit(!1);
            for (; !(o.getLengthInBits() >= 8 * h) && (o.put(t.PAD0, 8), !(o.getLengthInBits() >= 8 * h));) o.put(t.PAD1, 8);
            return t.createBytes(o, s)
        }, t.createBytes = function (t, i) {
            for (var n = 0, r = 0, s = 0, o = new Array(i.length), a = new Array(i.length), l = 0; l < i.length; l++) {
                var h = i[l].dataCount,
                    _ = i[l].totalCount - h;
                r = Math.max(r, h), s = Math.max(s, _), o[l] = new Array(h);
                for (var c = 0; c < o[l].length; c++) o[l][c] = 255 & t.buffer[c + n];
                n += h;
                var d = e.QRUtil.getErrorCorrectPolynomial(_),
                    u = new e.QRPolynomial(o[l], d.getLength() - 1),
                    p = u.mod(d);
                a[l] = new Array(d.getLength() - 1);
                for (var c = 0; c < a[l].length; c++) {
                    var g = c + p.getLength() - a[l].length;
                    a[l][c] = g >= 0 ? p.get(g) : 0
                }
            }
            for (var m = 0, c = 0; c < i.length; c++) m += i[c].totalCount;
            for (var w = new Array(m), y = 0, c = 0; r > c; c++)
                for (var l = 0; l < i.length; l++) c < o[l].length && (w[y++] = o[l][c]);
            for (var c = 0; s > c; c++)
                for (var l = 0; l < i.length; l++) c < a[l].length && (w[y++] = a[l][c]);
            return w
        }, t
    }();
    t.PAD0 = 236, t.PAD1 = 17, e.QRCodeModel = t, __reflect(t.prototype, "qr.QRCodeModel")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e() {}
        return e
    }();
    t.L = 1, t.M = 0, t.Q = 3, t.H = 2, e.QRErrorCorrectLevel = t, __reflect(t.prototype, "qr.QRErrorCorrectLevel")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e() {}
        return e
    }();
    t.PATTERN000 = 0, t.PATTERN001 = 1, t.PATTERN010 = 2, t.PATTERN011 = 3, t.PATTERN100 = 4, t.PATTERN101 = 5, t.PATTERN110 = 6, t.PATTERN111 = 7, e.QRMaskPattern = t, __reflect(t.prototype, "qr.QRMaskPattern")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e() {}
        return e.glog = function (t) {
            return e.isInit || e.init(), 1 > t && console.log("错误:n=" + t), e.LOG_TABLE[t]
        }, e.gexp = function (t) {
            for (e.isInit || e.init(); 0 > t;) t += 255;
            for (; t >= 256;) t -= 255;
            return e.EXP_TABLE[t]
        }, e.init = function () {
            e.isInit = !0;
            for (var t = 0; 8 > t; t++) e.EXP_TABLE[t] = 1 << t;
            for (var t = 8; 256 > t; t++) e.EXP_TABLE[t] = e.EXP_TABLE[t - 4] ^ e.EXP_TABLE[t - 5] ^ e.EXP_TABLE[t - 6] ^ e.EXP_TABLE[t - 8];
            for (var t = 0; 255 > t; t++) e.LOG_TABLE[e.EXP_TABLE[t]] = t
        }, e
    }();
    t.EXP_TABLE = new Array(256), t.LOG_TABLE = new Array(256), e.QRMath = t, __reflect(t.prototype, "qr.QRMath")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e() {}
        return e
    }();
    t.MODE_NUMBER = 1, t.MODE_ALPHA_NUM = 2, t.MODE_8BIT_BYTE = 4, t.MODE_KANJI = 8, e.QRMode = t, __reflect(t.prototype, "qr.QRMode")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function t(e, t) {
            if (void 0 == e.length) throw new Error(e.length + "/" + t);
            for (var i = 0; i < e.length && 0 == e[i];) i++;
            this.num = new Array(e.length - i + t);
            for (var n = 0; n < e.length - i; n++) this.num[n] = e[n + i]
        }
        return t.prototype.get = function (e) {
            return this.num[e]
        }, t.prototype.getLength = function () {
            return this.num.length
        }, t.prototype.multiply = function (i) {
            for (var n = new Array(this.getLength() + i.getLength() - 1), r = 0; r < this.getLength(); r++)
                for (var s = 0; s < i.getLength(); s++) n[r + s] ^= e.QRMath.gexp(e.QRMath.glog(this.get(r)) + e.QRMath.glog(i.get(s)));
            return new t(n, 0)
        }, t.prototype.mod = function (i) {
            if (this.getLength() - i.getLength() < 0) return this;
            for (var n = e.QRMath.glog(this.get(0)) - e.QRMath.glog(i.get(0)), r = new Array(this.getLength()), s = 0; s < this.getLength(); s++) r[s] = this.get(s);
            for (var s = 0; s < i.getLength(); s++) r[s] ^= e.QRMath.gexp(e.QRMath.glog(i.get(s)) + n);
            return new t(r, 0).mod(i)
        }, t
    }();
    e.QRPolynomial = t, __reflect(t.prototype, "qr.QRPolynomial")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function e(e, t) {
            this.totalCount = e, this.dataCount = t
        }
        return e
    }();
    t.RS_BLOCK_TABLE = [
        [1, 26, 19],
        [1, 26, 16],
        [1, 26, 13],
        [1, 26, 9],
        [1, 44, 34],
        [1, 44, 28],
        [1, 44, 22],
        [1, 44, 16],
        [1, 70, 55],
        [1, 70, 44],
        [2, 35, 17],
        [2, 35, 13],
        [1, 100, 80],
        [2, 50, 32],
        [2, 50, 24],
        [4, 25, 9],
        [1, 134, 108],
        [2, 67, 43],
        [2, 33, 15, 2, 34, 16],
        [2, 33, 11, 2, 34, 12],
        [2, 86, 68],
        [4, 43, 27],
        [4, 43, 19],
        [4, 43, 15],
        [2, 98, 78],
        [4, 49, 31],
        [2, 32, 14, 4, 33, 15],
        [4, 39, 13, 1, 40, 14],
        [2, 121, 97],
        [2, 60, 38, 2, 61, 39],
        [4, 40, 18, 2, 41, 19],
        [4, 40, 14, 2, 41, 15],
        [2, 146, 116],
        [3, 58, 36, 2, 59, 37],
        [4, 36, 16, 4, 37, 17],
        [4, 36, 12, 4, 37, 13],
        [2, 86, 68, 2, 87, 69],
        [4, 69, 43, 1, 70, 44],
        [6, 43, 19, 2, 44, 20],
        [6, 43, 15, 2, 44, 16],
        [4, 101, 81],
        [1, 80, 50, 4, 81, 51],
        [4, 50, 22, 4, 51, 23],
        [3, 36, 12, 8, 37, 13],
        [2, 116, 92, 2, 117, 93],
        [6, 58, 36, 2, 59, 37],
        [4, 46, 20, 6, 47, 21],
        [7, 42, 14, 4, 43, 15],
        [4, 133, 107],
        [8, 59, 37, 1, 60, 38],
        [8, 44, 20, 4, 45, 21],
        [12, 33, 11, 4, 34, 12],
        [3, 145, 115, 1, 146, 116],
        [4, 64, 40, 5, 65, 41],
        [11, 36, 16, 5, 37, 17],
        [11, 36, 12, 5, 37, 13],
        [5, 109, 87, 1, 110, 88],
        [5, 65, 41, 5, 66, 42],
        [5, 54, 24, 7, 55, 25],
        [11, 36, 12],
        [5, 122, 98, 1, 123, 99],
        [7, 73, 45, 3, 74, 46],
        [15, 43, 19, 2, 44, 20],
        [3, 45, 15, 13, 46, 16],
        [1, 135, 107, 5, 136, 108],
        [10, 74, 46, 1, 75, 47],
        [1, 50, 22, 15, 51, 23],
        [2, 42, 14, 17, 43, 15],
        [5, 150, 120, 1, 151, 121],
        [9, 69, 43, 4, 70, 44],
        [17, 50, 22, 1, 51, 23],
        [2, 42, 14, 19, 43, 15],
        [3, 141, 113, 4, 142, 114],
        [3, 70, 44, 11, 71, 45],
        [17, 47, 21, 4, 48, 22],
        [9, 39, 13, 16, 40, 14],
        [3, 135, 107, 5, 136, 108],
        [3, 67, 41, 13, 68, 42],
        [15, 54, 24, 5, 55, 25],
        [15, 43, 15, 10, 44, 16],
        [4, 144, 116, 4, 145, 117],
        [17, 68, 42],
        [17, 50, 22, 6, 51, 23],
        [19, 46, 16, 6, 47, 17],
        [2, 139, 111, 7, 140, 112],
        [17, 74, 46],
        [7, 54, 24, 16, 55, 25],
        [34, 37, 13],
        [4, 151, 121, 5, 152, 122],
        [4, 75, 47, 14, 76, 48],
        [11, 54, 24, 14, 55, 25],
        [16, 45, 15, 14, 46, 16],
        [6, 147, 117, 4, 148, 118],
        [6, 73, 45, 14, 74, 46],
        [11, 54, 24, 16, 55, 25],
        [30, 46, 16, 2, 47, 17],
        [8, 132, 106, 4, 133, 107],
        [8, 75, 47, 13, 76, 48],
        [7, 54, 24, 22, 55, 25],
        [22, 45, 15, 13, 46, 16],
        [10, 142, 114, 2, 143, 115],
        [19, 74, 46, 4, 75, 47],
        [28, 50, 22, 6, 51, 23],
        [33, 46, 16, 4, 47, 17],
        [8, 152, 122, 4, 153, 123],
        [22, 73, 45, 3, 74, 46],
        [8, 53, 23, 26, 54, 24],
        [12, 45, 15, 28, 46, 16],
        [3, 147, 117, 10, 148, 118],
        [3, 73, 45, 23, 74, 46],
        [4, 54, 24, 31, 55, 25],
        [11, 45, 15, 31, 46, 16],
        [7, 146, 116, 7, 147, 117],
        [21, 73, 45, 7, 74, 46],
        [1, 53, 23, 37, 54, 24],
        [19, 45, 15, 26, 46, 16],
        [5, 145, 115, 10, 146, 116],
        [19, 75, 47, 10, 76, 48],
        [15, 54, 24, 25, 55, 25],
        [23, 45, 15, 25, 46, 16],
        [13, 145, 115, 3, 146, 116],
        [2, 74, 46, 29, 75, 47],
        [42, 54, 24, 1, 55, 25],
        [23, 45, 15, 28, 46, 16],
        [17, 145, 115],
        [10, 74, 46, 23, 75, 47],
        [10, 54, 24, 35, 55, 25],
        [19, 45, 15, 35, 46, 16],
        [17, 145, 115, 1, 146, 116],
        [14, 74, 46, 21, 75, 47],
        [29, 54, 24, 19, 55, 25],
        [11, 45, 15, 46, 46, 16],
        [13, 145, 115, 6, 146, 116],
        [14, 74, 46, 23, 75, 47],
        [44, 54, 24, 7, 55, 25],
        [59, 46, 16, 1, 47, 17],
        [12, 151, 121, 7, 152, 122],
        [12, 75, 47, 26, 76, 48],
        [39, 54, 24, 14, 55, 25],
        [22, 45, 15, 41, 46, 16],
        [6, 151, 121, 14, 152, 122],
        [6, 75, 47, 34, 76, 48],
        [46, 54, 24, 10, 55, 25],
        [2, 45, 15, 64, 46, 16],
        [17, 152, 122, 4, 153, 123],
        [29, 74, 46, 14, 75, 47],
        [49, 54, 24, 10, 55, 25],
        [24, 45, 15, 46, 46, 16],
        [4, 152, 122, 18, 153, 123],
        [13, 74, 46, 32, 75, 47],
        [48, 54, 24, 14, 55, 25],
        [42, 45, 15, 32, 46, 16],
        [20, 147, 117, 4, 148, 118],
        [40, 75, 47, 7, 76, 48],
        [43, 54, 24, 22, 55, 25],
        [10, 45, 15, 67, 46, 16],
        [19, 148, 118, 6, 149, 119],
        [18, 75, 47, 31, 76, 48],
        [34, 54, 24, 34, 55, 25],
        [20, 45, 15, 61, 46, 16]
    ], t.getRSBlocks = function (e, i) {
        var n = t.getRsBlockTable(e, i);
        if (void 0 == n) throw new Error("bad rs block @ typeNumber:" + e + "/errorCorrectLevel:" + i);
        for (var r = n.length / 3, s = [], o = 0; r > o; o++)
            for (var a = n[3 * o + 0], l = n[3 * o + 1], h = n[3 * o + 2], _ = 0; a > _; _++) s.push(new t(l, h));
        return s
    }, t.getRsBlockTable = function (i, n) {
        switch (n) {
            case e.QRErrorCorrectLevel.L:
                return t.RS_BLOCK_TABLE[4 * (i - 1) + 0];
            case e.QRErrorCorrectLevel.M:
                return t.RS_BLOCK_TABLE[4 * (i - 1) + 1];
            case e.QRErrorCorrectLevel.Q:
                return t.RS_BLOCK_TABLE[4 * (i - 1) + 2];
            case e.QRErrorCorrectLevel.H:
                return t.RS_BLOCK_TABLE[4 * (i - 1) + 3];
            default:
                return
        }
    }, e.QRRSBlock = t, __reflect(t.prototype, "qr.QRRSBlock")
}(qr || (qr = {}));
var qr;
! function (e) {
    var t = function () {
        function t() {}
        return t.getBCHTypeInfo = function (e) {
            for (var i = e << 10; t.getBCHDigit(i) - t.getBCHDigit(t.G15) >= 0;) i ^= t.G15 << t.getBCHDigit(i) - t.getBCHDigit(t.G15);
            return (e << 10 | i) ^ t.G15_MASK
        }, t.getBCHTypeNumber = function (e) {
            for (var i = e << 12; t.getBCHDigit(i) - t.getBCHDigit(t.G18) >= 0;) i ^= t.G18 << t.getBCHDigit(i) - t.getBCHDigit(t.G18);
            return e << 12 | i
        }, t.getBCHDigit = function (e) {
            for (var t = 0; 0 != e;) t++, e >>>= 1;
            return t
        }, t.getPatternPosition = function (e) {
            return t.PATTERN_POSITION_TABLE[e - 1]
        }, t.getMask = function (t, i, n) {
            switch (t) {
                case e.QRMaskPattern.PATTERN000:
                    return (i + n) % 2 == 0;
                case e.QRMaskPattern.PATTERN001:
                    return i % 2 == 0;
                case e.QRMaskPattern.PATTERN010:
                    return n % 3 == 0;
                case e.QRMaskPattern.PATTERN011:
                    return (i + n) % 3 == 0;
                case e.QRMaskPattern.PATTERN100:
                    return (Math.floor(i / 2) + Math.floor(n / 3)) % 2 == 0;
                case e.QRMaskPattern.PATTERN101:
                    return i * n % 2 + i * n % 3 == 0;
                case e.QRMaskPattern.PATTERN110:
                    return (i * n % 2 + i * n % 3) % 2 == 0;
                case e.QRMaskPattern.PATTERN111:
                    return (i * n % 3 + (i + n) % 2) % 2 == 0;
                default:
                    throw new Error("bad maskPattern:" + t)
            }
        }, t.getErrorCorrectPolynomial = function (t) {
            for (var i = new e.QRPolynomial([1], 0), n = 0; t > n; n++) i = i.multiply(new e.QRPolynomial([1, e.QRMath.gexp(n)], 0));
            return i
        }, t.getLengthInBits = function (t, i) {
            if (i >= 1 && 10 > i) switch (t) {
                case e.QRMode.MODE_NUMBER:
                    return 10;
                case e.QRMode.MODE_ALPHA_NUM:
                    return 9;
                case e.QRMode.MODE_8BIT_BYTE:
                    return 8;
                case e.QRMode.MODE_KANJI:
                    return 8;
                default:
                    throw new Error("mode:" + t)
            } else if (27 > i) switch (t) {
                case e.QRMode.MODE_NUMBER:
                    return 12;
                case e.QRMode.MODE_ALPHA_NUM:
                    return 11;
                case e.QRMode.MODE_8BIT_BYTE:
                    return 16;
                case e.QRMode.MODE_KANJI:
                    return 10;
                default:
                    throw new Error("mode:" + t)
            } else {
                if (!(41 > i)) throw new Error("type:" + i);
                switch (t) {
                    case e.QRMode.MODE_NUMBER:
                        return 14;
                    case e.QRMode.MODE_ALPHA_NUM:
                        return 13;
                    case e.QRMode.MODE_8BIT_BYTE:
                        return 16;
                    case e.QRMode.MODE_KANJI:
                        return 12;
                    default:
                        throw new Error("mode:" + t)
                }
            }
        }, t.getLostPoint = function (e) {
            for (var t = e.getModuleCount(), i = 0, n = 0; t > n; n++)
                for (var r = 0; t > r; r++) {
                    for (var s = 0, o = e.isDark(n, r), a = -1; 1 >= a; a++)
                        if (!(0 > n + a || n + a >= t))
                            for (var l = -1; 1 >= l; l++) 0 > r + l || r + l >= t || (0 != a || 0 != l) && o == e.isDark(n + a, r + l) && s++;
                    s > 5 && (i += 3 + s - 5)
                }
            for (var n = 0; t - 1 > n; n++)
                for (var r = 0; t - 1 > r; r++) {
                    var h = 0;
                    e.isDark(n, r) && h++, e.isDark(n + 1, r) && h++, e.isDark(n, r + 1) && h++, e.isDark(n + 1, r + 1) && h++, (0 == h || 4 == h) && (i += 3)
                }
            for (var n = 0; t > n; n++)
                for (var r = 0; t - 6 > r; r++) e.isDark(n, r) && !e.isDark(n, r + 1) && e.isDark(n, r + 2) && e.isDark(n, r + 3) && e.isDark(n, r + 4) && !e.isDark(n, r + 5) && e.isDark(n, r + 6) && (i += 40);
            for (var r = 0; t > r; r++)
                for (var n = 0; t - 6 > n; n++) e.isDark(n, r) && !e.isDark(n + 1, r) && e.isDark(n + 2, r) && e.isDark(n + 3, r) && e.isDark(n + 4, r) && !e.isDark(n + 5, r) && e.isDark(n + 6, r) && (i += 40);
            for (var _ = 0, r = 0; t > r; r++)
                for (var n = 0; t > n; n++) e.isDark(n, r) && _++;
            var c = Math.abs(100 * _ / t / t - 50) / 5;
            return i += 10 * c
        }, t.prototype.static_isSupportCanvas = function () {
            return "undefined" != typeof CanvasRenderingContext2D
        }, t._getTypeNumber = function (i, n) {
            for (var r = 1, s = t._getUTF8Length(i), o = 0, a = t.QRCodeLimitLength.length; a >= o; o++) {
                var l = 0;
                switch (n) {
                    case e.QRErrorCorrectLevel.L:
                        l = t.QRCodeLimitLength[o][0];
                        break;
                    case e.QRErrorCorrectLevel.M:
                        l = t.QRCodeLimitLength[o][1];
                        break;
                    case e.QRErrorCorrectLevel.Q:
                        l = t.QRCodeLimitLength[o][2];
                        break;
                    case e.QRErrorCorrectLevel.H:
                        l = t.QRCodeLimitLength[o][3]
                }
                if (l >= s) break;
                r++
            }
            if (r > t.QRCodeLimitLength.length) throw new Error("Too long data");
            return r
        }, t._getUTF8Length = function (e) {
            var t = encodeURI(e).toString().replace(/\%[0-9a-fA-F]{2}/g, "a");
            return t.length + (t.length != e ? 3 : 0)
        }, t
    }();
    t.PATTERN_POSITION_TABLE = [
        [],
        [6, 18],
        [6, 22],
        [6, 26],
        [6, 30],
        [6, 34],
        [6, 22, 38],
        [6, 24, 42],
        [6, 26, 46],
        [6, 28, 50],
        [6, 30, 54],
        [6, 32, 58],
        [6, 34, 62],
        [6, 26, 46, 66],
        [6, 26, 48, 70],
        [6, 26, 50, 74],
        [6, 30, 54, 78],
        [6, 30, 56, 82],
        [6, 30, 58, 86],
        [6, 34, 62, 90],
        [6, 28, 50, 72, 94],
        [6, 26, 50, 74, 98],
        [6, 30, 54, 78, 102],
        [6, 28, 54, 80, 106],
        [6, 32, 58, 84, 110],
        [6, 30, 58, 86, 114],
        [6, 34, 62, 90, 118],
        [6, 26, 50, 74, 98, 122],
        [6, 30, 54, 78, 102, 126],
        [6, 26, 52, 78, 104, 130],
        [6, 30, 56, 82, 108, 134],
        [6, 34, 60, 86, 112, 138],
        [6, 30, 58, 86, 114, 142],
        [6, 34, 62, 90, 118, 146],
        [6, 30, 54, 78, 102, 126, 150],
        [6, 24, 50, 76, 102, 128, 154],
        [6, 28, 54, 80, 106, 132, 158],
        [6, 32, 58, 84, 110, 136, 162],
        [6, 26, 54, 82, 110, 138, 166],
        [6, 30, 58, 86, 114, 142, 170]
    ], t.G15 = 1335, t.G18 = 7973, t.G15_MASK = 21522, t.QRCodeLimitLength = [
        [17, 14, 11, 7],
        [32, 26, 20, 14],
        [53, 42, 32, 24],
        [78, 62, 46, 34],
        [106, 84, 60, 44],
        [134, 106, 74, 58],
        [154, 122, 86, 64],
        [192, 152, 108, 84],
        [230, 180, 130, 98],
        [271, 213, 151, 119],
        [321, 251, 177, 137],
        [367, 287, 203, 155],
        [425, 331, 241, 177],
        [458, 362, 258, 194],
        [520, 412, 292, 220],
        [586, 450, 322, 250],
        [644, 504, 364, 280],
        [718, 560, 394, 310],
        [792, 624, 442, 338],
        [858, 666, 482, 382],
        [929, 711, 509, 403],
        [1003, 779, 565, 439],
        [1091, 857, 611, 461],
        [1171, 911, 661, 511],
        [1273, 997, 715, 535],
        [1367, 1059, 751, 593],
        [1465, 1125, 805, 625],
        [1528, 1190, 868, 658],
        [1628, 1264, 908, 698],
        [1732, 1370, 982, 742],
        [1840, 1452, 1030, 790],
        [1952, 1538, 1112, 842],
        [2068, 1628, 1168, 898],
        [2188, 1722, 1228, 958],
        [2303, 1809, 1283, 983],
        [2431, 1911, 1351, 1051],
        [2563, 1989, 1423, 1093],
        [2699, 2099, 1499, 1139],
        [2809, 2213, 1579, 1219],
        [2953, 2331, 1663, 1273]
    ], e.QRUtil = t, __reflect(t.prototype, "qr.QRUtil")
}(qr || (qr = {}));
var Algorithm = function () {
    function e() {}
    return e.onCrossMul = function (e, t) {
        return e.x * t.y - e.y * t.x
    }, e.onCheckCross = function (t, i, n, r) {
        var s = new egret.Point(t.x - n.x, t.y - n.y),
            o = new egret.Point(i.x - n.x, i.y - n.y),
            a = new egret.Point(r.x - n.x, r.y - n.y),
            l = e.onCrossMul(s, a) * e.onCrossMul(o, a);
        return s = new egret.Point(n.x - t.x, n.y - t.y), o = new egret.Point(r.x - t.x, r.y - t.y), a = new egret.Point(i.x - t.x, i.y - t.y), 0 >= l && e.onCrossMul(s, a) * e.onCrossMul(o, a) <= 0 ? !0 : !1
    }, e
}();
__reflect(Algorithm.prototype, "Algorithm");
var Collision = function () {
    function e() {}
    return e.prototype.testRectangleHit = function (e, t) {
        var i = e.getBounds(),
            n = t.getBounds();
        return i.x = e.x, i.y = e.y, n.x = t.x, n.y = t.y, i.intersects(n)
    }, e.prototype.faceToFaceHit = function (e, t) {
        return null != e && null != t ? e.x + e.width < t.x && e.y + e.height < t.y ? !1 : e.x + e.width > t.x + t.width && e.y + e.height > t.y + t.height ? !1 : (this.aRect ? (this.aRect.x = e.x, this.aRect.y = e.y, this.aRect.width = e.width, this.aRect.height = e.height) : this.aRect = new egret.Rectangle(e.x, e.y, e.width, e.height), this.bRect ? (this.bRect.x = t.x, this.bRect.y = t.y, this.bRect.width = t.width, this.bRect.height = t.height) : this.bRect = new egret.Rectangle(t.x, t.y, t.width, t.height), this.aRect.intersects(this.bRect)) : !1
    }, e.prototype.faceToPointHit = function (e, t, i) {
        var n = e.hitTestPoint(t, i);
        return n
    }, e.prototype.pxFaceToPointHit = function (e, t, i) {
        var n = e.hitTestPoint(t, i, !0);
        return n
    }, e.prototype.checkCircle = function (e, t) {
        var i = new egret.Point(e.x, e.y),
            n = new egret.Point(t.x, t.y);
        return egret.Point.distance(i, n) <= e.width / 2 + t.width / 2 ? !0 : !1
    }, e.prototype.checkHero = function (e, t, i) {
        for (var n = new egret.Rectangle(t.x - t.anchorOffsetX, t.y - t.anchorOffsetY, t.width, t.height), r = i, s = r.length, o = new egret.Point, a = 0; s > a; a++)
            if (o = e.localToGlobal(r[a].x, r[a].y), n.containsPoint(o)) {
                console.log("hit");
                break
            }
    }, e
}();
__reflect(Collision.prototype, "Collision");
var Down_Components = function () {
    function e() {}
    return e.addDownComponents = function (t, i, n, r, s, o, a, l) {
        void 0 === a && (a = "date"), void 0 === l && (l = null);
        var h, _, c = new egret.DisplayObjectContainer;
        h = new eui.Scroller, _ = new eui.Group, l.length >= r ? h.scrollPolicyV = eui.ScrollPolicy.ON : h.scrollPolicyV = eui.ScrollPolicy.OFF, h.scrollPolicyH = eui.ScrollPolicy.OFF, h.bounces = !1, h.viewport = _, _.cacheAsBitmap = !0;
        var d, u = !0,
            p = new egret.DisplayObjectContainer;
        if ("date" != a) {
            var g = MyUtils.createBitmapByName("CalendarModuleBgTxt_png");
            g.width = i, g.height = n * (r + 2), c.addChild(g);
            var m = GetTextField.createTextField(g.width, 53, s, 0, t);
            for (m.bold = !0, m.verticalAlign = egret.VerticalAlign.MIDDLE, c.addChild(m), d = 0; d < l.length; d++) {
                var w = new egret.DisplayObjectContainer,
                    y = new egret.Shape;
                u ? y.graphics.beginFill(16777215) : y.graphics.beginFill(15658734), u = !u, y.graphics.drawRect(0, 0, g.width, n), y.graphics.endFill(), y.graphics.lineTo(i, n);
                var v = GetTextField.createTextField(g.width, n, o, 0, String(l[d]), egret.TextFieldType.DYNAMIC, egret.HorizontalAlign.CENTER);
                v.touchEnabled = !1, v.verticalAlign = egret.VerticalAlign.MIDDLE, w.addChild(y), w.addChild(v), w.y = n * d, w.touchEnabled = !0, w.name = String(d), w.once(egret.TouchEvent.TOUCH_TAP, function (t) {
                    e._componentsSelectIndex = Number(t.currentTarget.name), c.dispatchEvent(new egret.Event("onSelectComponentsClick"))
                }, c), p.addChild(w)
            }
        } else {
            var g = MyUtils.createBitmapByName("CalendarModuleBgDate_png");
            for (g.width = i, c.addChild(g), d = 0; 100 > d; d++) {
                var w = new egret.DisplayObjectContainer,
                    y = new egret.Shape;
                u ? y.graphics.beginFill(16777215) : y.graphics.beginFill(15658734), u = !u, y.graphics.drawRect(0, 0, g.width, n), y.graphics.endFill(), y.graphics.lineTo(i, n);
                var v = GetTextField.createTextField(g.width, n, 26, 0, String(TransitionTimestamp.onFormatDate(TransitionTimestamp.onTimestampDate() + 86400 * d)), egret.TextFieldType.DYNAMIC, egret.HorizontalAlign.CENTER);
                v.verticalAlign = egret.VerticalAlign.MIDDLE, w.addChild(y), w.addChild(v), w.y = n * d, w.touchEnabled = !0, w.name = String(TransitionTimestamp.onFormatDate(TransitionTimestamp.onTimestampDate() + 86400 * d)), w.once(egret.TouchEvent.TOUCH_TAP, function (t) {
                    egret.log(e.CITY_1_INFO), e.CITY_1_INFO = t.currentTarget.name, c.dispatchEvent(new egret.Event("onSelectComponentsClick"))
                }, c), p.addChild(w)
            }
        }
        var S = new eui.Image;
        return S.source = RES.getRes("music2_png"), S.height = p.height, S.alpha = 0, h.width = g.width, h.height = n * r + 6, _.addChild(S), _.addChild(p), h.y = 53, c.addChild(h), c
    }, e
}();
Down_Components._componentsSelectIndex = 0, Down_Components.CITY_NUMBER = 1, Down_Components.CITY_1_INFO = 0, Down_Components.CITY_2_INFO = 0, Down_Components.CITY_3_INFO = 0, Down_Components.PROVINCES_DATA = [], Down_Components.CITY_DATA = [], Down_Components.AREA_DATA = [], Down_Components.PROVINCES_ID_DATA = [], Down_Components.CITY_ID_DATA = [], Down_Components.AREA_ID_DATA = [], Down_Components.PROFESSION_NUMBER = 1, Down_Components.PROFESSION_1_INFO = 0, Down_Components.PROFESSION_2_INFO = 0, Down_Components.PROFESSION_DATA = [], Down_Components.PROFESSION_TYPE_DATA = [], Down_Components.TYPE_DATA = [], __reflect(Down_Components.prototype, "Down_Components");
var DrawGraphics = function () {
    function e() {}
    return e.onDrawGraphicsSquare = function (e, t, i, n, r, s, o) {
        void 0 === s && (s = 1), void 0 === o && (o = !1);
        var a = new egret.Shape;
        return a.graphics.beginFill(r), a.graphics.drawRect(e, t, i, n), a.graphics.endFill(), a.alpha = s, a.touchEnabled = o, a
    }, e.onDrawGraphicsPolygon = function (e, t, i, n, r, s, o, a) {
        void 0 === a && (a = !1);
        var l = new egret.Shape;
        l.graphics.lineStyle(i, n, r), l.graphics.beginFill(s, o), l.graphics.moveTo(e.x, e.y);
        for (var h = 0; h < t.length; h++) l.graphics.lineTo(t[h].x, t[h].y);
        return l.graphics.lineTo(e.x, e.y), l.graphics.endFill(), l
    }, e.onDrawGraphicsCircle = function (e, t, i, n, r, s, o, a, l) {
        void 0 === n && (n = 16777215), void 0 === r && (r = 0), void 0 === s && (s = !1), void 0 === o && (o = 16777215), void 0 === a && (a = 1), void 0 === l && (l = !1);
        var h = new egret.Shape;
        return h.graphics.beginFill(n, 1), h.graphics.lineStyle(a, o), h.graphics.drawCircle(e, t, i), h.alpha = r, h.touchEnabled = s, h.graphics.endFill(), h
    }, e
}();
__reflect(DrawGraphics.prototype, "DrawGraphics");
var ExtractArray = function () {
    function e() {}
    return e.onNumRandoms = function (e, t, i) {
        var n = Math.floor((t - e) / i) + 1,
            r = Math.floor(Math.random() * n);
        return e + r * i
    }, e.onRrandomArr = function (t, i, n, r) {
        for (var s, o = 0; t.length < i;) {
            var a = e.onNumRandoms(n, r, 1);
            for (s = 0; s < t.length; s++) a != t[s] && o++;
            o == t.length && t.push(a), o = 0
        }
    }, e.onDisarrangeArr = function (t) {
        for (var i = [], n = 0; n < t.length; n++) i[n] = t[n];
        for (t = []; i.length > 0;) {
            var r = e.onNumRandoms(0, i.length - 1, 1);
            t.push(i[r]), i.splice(r, 1)
        }
        return t
    }, e.onGetRepeat = function (e) {
        var t = [];
        t = t.concat(e);
        var i, n, r = 0,
            s = [],
            o = [],
            a = [],
            l = [],
            h = t.length;
        for (i = 0; h > i; i++)
            if (r = 1, -1 != t[i]) {
                for (n = i + 1; h > n; n++) t[i] == t[n] && (r++, t[n] = -1);
                r > 1 ? (s.push(t[i]), o.push(r)) : 1 == r && a.push(t[i])
            } for (i = 0; i < s.length; i++) l.push(s[i]);
        for (i = 0; i < a.length; i++) l.push(a[i]);
        return console.log("接收的数组", e), console.log("重复的对象", s), console.log("重复的次数", o), console.log("无重复的对象", a), console.log("筛选后的不重复数组", l), [s, o, a, l]
    }, e.onEextractArr = function (t, i, n, r, s) {
        void 0 === t && (t = []), void 0 === i && (i = 0), void 0 === n && (n = 1), void 0 === r && (r = 0), void 0 === s && (s = null);
        var o, a = [],
            l = [],
            h = [];
        if (0 != r) {
            for (o = n; r >= o; o++) h.push(o);
            l = h
        }
        for (null != s && (l = [], l = l.concat(s)), o = 1; o <= t.length; o++) {
            a.push(t[o - 1]);
            for (var _ = 0; _ <= l.length - 1; _++) l[_] == t[o - 1] && l.splice(_, 1)
        }
        l = e.onDisarrangeArr(l);
        var c = Number(i - a.length);
        for (o = 1; c >= o; o++) a.push(l[o - 1]);
        return a = e.onDisarrangeArr(a)
    }, e
}();
__reflect(ExtractArray.prototype, "ExtractArray");
var GetTextField = function (e) {
    function t() {
        return e.call(this) || this
    }
    return __extends(t, e), t.createTextField = function (e, t, i, n, r, s, o, a) {
        void 0 === s && (s = egret.TextFieldType.DYNAMIC), void 0 === o && (o = egret.HorizontalAlign.CENTER), void 0 === a && (a = !1);
        var l = new egret.TextField;
        return l.type = s, l.multiline = a, l.textColor = n, l.size = i, l.textAlign = o, l.width = e, l.height = t, l.verticalAlign = egret.VerticalAlign.MIDDLE, l.text = r, l
    }, t.createBitmapText = function (e, t, i, n, r) {
        void 0 === r && (r = egret.HorizontalAlign.CENTER);
        var s = new egret.BitmapText;
        return s.font = RES.getRes(n), s.width = e, s.height = t, s.text = i, s.textAlign = r, s
    }, t
}(egret.DisplayObjectContainer);
__reflect(GetTextField.prototype, "GetTextField");
var RegularExpression = function () {
    function e() {}
    return e.isPhone = function (e) {
        var t = /^(13[0-9]|15[012356789]|17[0-9]|18[0-9]|19[012356789]|14[57]|16[678])[0-9]{8}$/;
        return t.test(e) ? !0 : !1
    }, e.isSpecial = function (e) {
        var t = /^0\d{2,3}-?\d{7,8}$/;
        return t.test(e) ? !0 : !1
    }, e.isEmail = function (e) {
        var t = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
        return t.test(e) ? !0 : !1
    }, e.isChinese = function (e) {
        var t = /^[\u4e00-\u9fa5]+(·[\u4e00-\u9fa5]+)*$/;
        return t.test(e) ? !0 : !1
    }, e.isAllEnglish = function (e) {
        var t = /^[a-zA-Z]+$/;
        return t.test(e) ? !0 : !1
    }, e.isIdentity = function (e) {
        var t = /^([1-9]\d{5}(18|19|20)\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx])$/;
        return t.test(e) ? !0 : !1
    }, e.onGetMyQRCodeParamer = function (t) {
        var i = new Object;
        return i = e.onGetQRCodeRequest(), i[t]
    }, e.onGetQRCodeRequest = function (e) {
        void 0 === e && (e = document.location.search);
        var t = e,
            i = new Object;
        if (-1 != t.indexOf("?"))
            for (var n = t.split("?"), r = n[1].split("&"), s = 0; s < r.length; s++) i[r[s].split("=")[0]] = r[s].split("=")[1];
        return i
    }, e.AlterStringLength = function (t, i) {
        for (var n = 0, r = "", s = 0, o = t.length; o > s; s++) {
            var a = t.charAt(s);
            if (e.isChinese(a)) {
                if (n += 2, n > i) return r;
                r += a
            } else {
                if (n++, n > i) return r;
                r += a
            }
        }
        return r
    }, e.GetStringLength = function (t) {
        for (var i = 0, n = "", r = 0, s = t.length; s > r; r++) {
            var o = t.charAt(r);
            egret.log(i, n), e.isChinese(o) ? (i += 2, n += o) : (n += o, i++)
        }
        return i
    }, e
}();
__reflect(RegularExpression.prototype, "RegularExpression");
var ScrollerControl = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t.myScroller = null, t.group = null, t
    }
    return __extends(t, e), t.prototype.onAddScroller = function (e, t, i, n, r, s) {
        void 0 === i && (i = !1), void 0 === n && (n = !1), void 0 === r && (r = eui.ScrollPolicy.ON), void 0 === s && (s = eui.ScrollPolicy.OFF), this.myScroller = new eui.Scroller, this.group = new eui.Group, this.myScroller.width = e, this.myScroller.height = t, this.myScroller.scrollPolicyV = r, this.myScroller.scrollPolicyH = s, this.myScroller.bounces = i, this.myScroller.viewport = this.group, this.group.cacheAsBitmap = n, this.addChild(this.myScroller)
    }, t.prototype.onAddImg = function (e) {
        this.group.addChild(e)
    }, t.prototype.onRemove = function () {
        null != this.myScroller && (this.myScroller.parent.removeChild(this.myScroller), this.group = null, this.myScroller = null)
    }, t
}(egret.DisplayObjectContainer);
__reflect(ScrollerControl.prototype, "ScrollerControl");
var ShakeTool = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t.xAngle = 0, t.yAngle = 0, t.zAngle = 0, t.last_x = 0, t.last_y = 0, t.last_z = 0, t.shakeCount = 0, t.lastTime = 0, t.shakeAngle = 45, t
    }
    return __extends(t, e), t.prototype.start = function () {
        this.shakeCount = 0, this.lastTime = 0, this.last_x = 0, this.last_y = 0, this.last_z = 0, this.orientation || (this.orientation = new egret.DeviceOrientation), this.orientation.addEventListener(egret.Event.CHANGE, this.onOrientation, this), this.orientation.start()
    }, t.prototype.stop = function () {
        this.orientation && (this.orientation.removeEventListener(egret.Event.CHANGE, this.onOrientation, this), this.orientation.stop())
    }, t.prototype.onOrientation = function (e) {
        var t = egret.getTimer();
        t - this.lastTime > 100 && (this.lastTime = t, this.xAngle = e.beta, this.yAngle = e.gamma, this.zAngle = e.alpha, (Math.abs(this.last_x - this.xAngle) > this.shakeAngle || Math.abs(this.last_y - this.yAngle) > this.shakeAngle || Math.abs(this.last_z - this.zAngle) > this.shakeAngle) && this.shakeCount++, this.last_x = this.xAngle, this.last_y = this.yAngle, this.last_z = this.zAngle), this.dispatchEventWith(egret.Event.CHANGE, !1, {
            x: this.xAngle,
            y: this.yAngle,
            z: this.zAngle,
            shakeCount: this.shakeCount
        })
    }, t
}(egret.EventDispatcher);
__reflect(ShakeTool.prototype, "ShakeTool");
var wy;
! function (e) {
    var t = function () {
        function e() {}
        return e.notifyMsg = function (e, t) {
            void 0 === t && (t = !0);
            var i = new egret.TextField;
            i.size = 30, i.x = 30, i.textAlign = "center", i.fontFamily = "微软雅黑", i.text = e, i.width >= WndManager.root.stage.stageWidth - 100 && (i.width = WndManager.root.stage.stageWidth - 100), i.verticalAlign = egret.VerticalAlign.MIDDLE, i.textColor = 16777215, i.lineSpacing = 15;
            var n = new egret.Sprite;
            n.graphics.beginFill(3421236, 1), n.graphics.drawRoundRect(0, 0, i.width + 60, i.height + 40, 20), n.graphics.endFill(), WndManager.root.addChild(n), i.x = 30, i.y = 20, n.addChild(i), n.x = WndManager.root.stage.stageWidth, n.y = (WndManager.root.stage.stageHeight - n.height) / 2;
            var r = (WndManager.root.stage.stageWidth - n.width) / 2;
            n.alpha = 0, t ? egret.Tween.get(n).to({
                x: r,
                alpha: 1
            }, 300).wait(1e3).to({
                x: -WndManager.root.stage.stageWidth,
                alpha: 0
            }, 400).call(function () {
                n.parent.removeChild(n)
            }, this) : (n.x = r, egret.Tween.get(n).to({
                alpha: 1
            }, 300).wait(1e3).to({
                alpha: 0
            }, 400).call(function () {
                n.parent.removeChild(n)
            }, this))
        }, e.setContent = function (e, t, i, n, r) {
            void 0 === t && (t = "H"), void 0 === i && (i = null), void 0 === n && (n = !0), void 0 === r && (r = WndManager.root), this.isChange = !1;
            var s = this.InstanceTf();
            s.width = 0 / 0, s.text = e, s.width >= r.stage.stageWidth - 100 && (s.width = r.stage.stageWidth - 100), (s.width != this.TF_WIDTH || s.height != this.TF_HEIGHT) && (this.isChange = !0), this.TF_WIDTH = s.width + 60, this.TF_HEIGHT = s.height + 40, s.y = 20;
            var o = this.InstanceSpr();
            o.x = (r.stage.stageWidth - o.width) / 2, egret.Tween.removeTweens(o);
            var a = r.stage.stageHeight - 150;
            a + this.TF_HEIGHT + 40 >= r.stage.stageHeight && (a -= 50), i && (n = !1, a = i), egret.Tween.get(o).to({
                alpha: 1
            }, 300).wait(2e3).to({
                alpha: 0
            }, 300).call(function () {
                o.parent && o.parent.removeChild(o)
            }), n && ("H" == t ? (o.y = r.stage.stageHeight, egret.Tween.get(o).to({
                y: a
            }, 300, egret.Ease.backOut), o.y = a) : (o.rotation = 90, o.y = (r.stage.stageHeight - o.width) / 2, o.x = -100, egret.Tween.get(o).to({
                x: 120
            }, 300, egret.Ease.backOut))), r.stage.addChild(o)
        }, e.InstanceTf = function () {
            return null == this.toastText && (this.toastText = new egret.TextField, this.toastText.size = this.FONT_SIZE, this.toastText.x = 30, this.toastText.textAlign = "center", this.toastText.fontFamily = "微软雅黑", this.toastText.verticalAlign = egret.VerticalAlign.MIDDLE, this.toastText.textColor = this.TXT_COLOR, this.toastText.lineSpacing = 15), this.toastText
        }, e.InstanceSpr = function () {
            return (null == this._instanceSpr || this.isChange) && (this._instanceSpr && this._instanceSpr.parent && this._instanceSpr.parent.removeChild(this._instanceSpr), this._instanceSpr = new egret.Sprite, this._instanceSpr.graphics.beginFill(this.BG_COLOR, 1), this._instanceSpr.graphics.drawRoundRect(0, 0, this.TF_WIDTH, this.TF_HEIGHT, 20), this._instanceSpr.graphics.endFill(), this._instanceSpr.addChild(this.toastText)), this._instanceSpr.alpha = 0, this._instanceSpr
        }, e
    }();
    t.BG_COLOR = 3421236, t.TXT_COLOR = 16777215, t.FONT_SIZE = 30, t.isChange = !1, e.Toast = t, __reflect(t.prototype, "wy.Toast")
}(wy || (wy = {}));
var TransitionTimestamp = function () {
    function e() {}
    return e.onTimestampDate = function () {
        return Math.round((new Date).getTime() / 1e3)
    }, e.onFormatDate = function (e) {
        var t, i, n, r = new Date(1e3 * parseInt(e)).toLocaleTimeString().replace("上午", "").replace("下午", "").replace(":", "").replace(":", ""),
            s = new Date(1e3 * parseInt(e)).toLocaleTimeString().replace("上午", "").replace("下午", ""),
            o = new Date(1e3 * parseInt(e)).toLocaleTimeString(),
            a = o.substr(0, 1),
            l = r,
            h = r,
            _ = r,
            c = new Date(1e3 * parseInt(e)).toLocaleDateString().replace(/\//gi, "-"),
            d = [];
        d = c.split("-"), d[0].lenget < 4 && d[d.length - 1].length > 2 && (d = d.unshift(d[d.length - 1]), d = d.pop()), c = "";
        for (var u = 0; u < d.length; u++) d[u].length < 2 && (d[u] = "0" + d[u]), u < d.length - 1 ? c = c + d[u] + "-" : c += d[u];
        if ("下" == a) {
            for (var p = 0; 4 > p; p++) l = l.substring(0, l.length - 1);
            if (Number(l) >= 1 && Number(l) <= 9) {
                h = h.substring(1);
                for (var g = 0; 3 > g; g++) _ = _.substring(1)
            } else {
                for (var m = 0; 2 > m; m++) h = h.substring(1);
                for (var w = 0; 4 > w; w++) _ = _.substring(1)
            }
            for (var y = 0; 2 > y; y++) h = h.substring(0, h.length - 1);
            t = 12 == Number(l) ? "12" : 12 + Number(l)
        } else {
            for (var p = 0; 4 > p; p++) l = l.substring(0, l.length - 1);
            if (Number(l) >= 0 && Number(l) <= 9) {
                h = h.substring(1);
                for (var g = 0; 3 > g; g++) _ = _.substring(1)
            } else {
                for (var m = 0; 2 > m; m++) h = h.substring(1);
                for (var w = 0; 4 > w; w++) _ = _.substring(1)
            }
            for (var y = 0; 2 > y; y++) h = h.substring(0, h.length - 1);
            t = 12 == Number(l) ? "00" : Number(l) >= 10 && Number(l) <= 11 ? Number(l) : "0" + Number(l)
        }
        i = h, n = _, s = c + " " + t + ":" + i + ":" + n;
        var v = [c, t, i, n];
        return d.push(s), d.push(v), egret.log(d), d
    }, e
}();
__reflect(TransitionTimestamp.prototype, "TransitionTimestamp");
var TweenHandler = function () {
    function e() {}
    return e.onInitAnchorOffset = function (t, i, n) {
        void 0 === i && (i = "eui"), void 0 === n && (n = null), e.tweenArr.push(t), t.addEventListener(egret.Event.ENTER_FRAME, e.onEvent, this)
    }, e.onInitAnchorOffsets = function (t, i, n) {
        void 0 === i && (i = "eui"), void 0 === n && (n = null), t.addEventListener(egret.Event.ENTER_FRAME, e.onEvent, this)
    }, e.onEvent = function (t) {
        t.currentTarget.width >= 1 && (t.currentTarget.removeEventListener(egret.Event.ENTER_FRAME, e.onEvent, this), t.currentTarget.anchorOffsetX = t.currentTarget.width / 2, t.currentTarget.anchorOffsetY = t.currentTarget.height / 2, t.currentTarget.x = t.currentTarget.x + t.currentTarget.width / 2, t.currentTarget.y = t.currentTarget.y + t.currentTarget.height / 2)
    }, e.onAddTweenObject = function (t) {
        e.tweenArr.push(t)
    }, e.onRemoveAllTween = function () {
        for (var t = 0; t < e.tweenArr.length; t++) egret.Tween.removeTweens(e.tweenArr[t]), e.tweenArr[t] = null;
        e.tweenArr = []
    }, e.onRemoveTween = function (t) {
        for (var i = 0; i < e.tweenArr.length; i++) e.tweenArr[i] == t && (egret.Tween.removeTweens(e.tweenArr[i]), e.tweenArr.splice(i, 1))
    }, e
}();
TweenHandler.tweenArr = [], __reflect(TweenHandler.prototype, "TweenHandler");
var TypewriterSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._txt = null, t._infoArray = null, t._currentInfo = "", t._currentIndex = 0, t._interval = 0, t._stopBol = !1, t
    }
    return __extends(t, e), t.prototype.onAddTypewriter = function (e, t, i, n, r, s, o, a, l, h, _) {
        void 0 === h && (h = 100), void 0 === _ && (_ = egret.VerticalAlign.MIDDLE), this._infoArray = i.split(""), this._interval = h, this._txt = GetTextField.createTextField(n, r, s, o, this._currentInfo, a, l), this._txt.lineSpacing = e, "bold" == t && (this._txt.fontFamily = t), this._txt.bold = !0, this.addChild(this._txt), this._txt.verticalAlign = _, this._currentIndex = 0, this.onStart()
    }, t.prototype.onStart = function () {
        this._stopBol || (this._currentInfo = this._currentInfo + this._infoArray[this._currentIndex], this._txt.text = this._currentInfo, this._currentIndex++, this._currentIndex >= this._infoArray.length ? this.dispatchEvent(new egret.Event("onTypewriterCom")) : egret.setTimeout(this.onStart, this, this._interval))
    }, t.prototype.onStop = function () {
        this._stopBol = !0
    }, t
}(egret.DisplayObjectContainer);
__reflect(TypewriterSp.prototype, "TypewriterSp");
var MoveWinBase = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t.clazzName = null, t.moveAny = null, t._guideIcon = null, t._index = 1, t.nX = 0, t.nY = 0, t._bMoved = !1, t._guide = null, t
    }
    return __extends(t, e), t.prototype.createOk = function () {
        this.init(), this.addEventListener(egret.TouchEvent.TOUCH_BEGIN, this.onClick, this), this.clazzName = egret.getDefinitionByName(egret.getQualifiedClassName(this))
    }, t.prototype.onClick = function (e) {
        if (e.type == egret.TouchEvent.TOUCH_BEGIN) this.nX = e.stageX, this.nY = e.stageY, this.removeEventListener(egret.TouchEvent.TOUCH_BEGIN, this.onClick, this), this.stage.addEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.addEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this);
        else if (e.type == egret.TouchEvent.TOUCH_MOVE) {
            if (this._bMoved) return;
            this.m_propty.movedType & t.MOVE_DOWN && this.nY - e.stageY > 100 && (this.onRemoveGuide(), this.stage.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this), this.nY = e.stageY, this._bMoved = !0, WndManager.switchWnd(this.clazzName, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_UP), WndManager.switchWnd(this.m_propty.down, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_DOWN)), this.m_propty.movedType & t.MOVE_UP && e.stageY - this.nY > 100 && (this.onRemoveGuide(), this.stage.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this), this.nY = e.stageY, this._bMoved = !0, WndManager.switchWnd(this.clazzName, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_DOWN), WndManager.switchWnd(this.m_propty.up, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_UP)), this.m_propty.movedType & t.MOVE_RIGHT && this.nX - e.stageX > 100 && (this.onRemoveGuide(), this.stage.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this), this.nX = e.stageX, this._bMoved = !0, WndManager.switchWnd(this.clazzName, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(this.m_propty.right, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_RIGHT)), this.m_propty.movedType & t.MOVE_LEFT && e.stageX - this.nX > 100 && (this.onRemoveGuide(), this.stage.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this), this.nX = e.stageX, this._bMoved = !0, WndManager.switchWnd(this.clazzName, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(this.m_propty.left, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_LEFT))
        } else e.type == egret.TouchEvent.TOUCH_END && (this.nX = e.stageX, this.nY = e.stageY, this.addEventListener(egret.TouchEvent.TOUCH_BEGIN, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_MOVE, this.onClick, this), this.stage.removeEventListener(egret.TouchEvent.TOUCH_END, this.onClick, this))
    }, t.prototype.onAddGuide = function () {
        this._guide = MyUtils.createBitmapByName("guideIcon_png"), this._guide.anchorOffsetX = this._guide.width / 2, this._guide.anchorOffsetY = this._guide.height, this._guide.x = 640, this._guide.y = 1030, this._guide.scaleX = this._guide.scaleY = .8, this._guide.rotation = -90, this.addChild(this._guide), egret.Tween.get(this._guide, {
            loop: !0
        }).to({
            x: this._guide.x - 20,
            alpha: .5
        }, 1e3).to({
            x: this._guide.x,
            alpha: 1
        }, 1e3)
    }, t.prototype.onRemoveGuide = function () {
        null != this._guide && (egret.Tween.removeTweens(this._guide), this._guide.parent.removeChild(this._guide), this._guide = null)
    }, t.prototype.Destroy = function () {
        e.prototype.Destroy.call(this)
    }, t.prototype.init = function () {}, t
}(WinBase);
MoveWinBase.MOVE_DOWN = 1, MoveWinBase.MOVE_UP = 2, MoveWinBase.MOVE_LEFT = 4, MoveWinBase.MOVE_RIGHT = 8, __reflect(MoveWinBase.prototype, "MoveWinBase");
var ScreenMovies;
! function (e) {
    function t(e, t) {
        function i(e) {
            v++, v == a && o.parent.removeChild(o)
        }
        var n = e,
            r = 640,
            s = 1236,
            o = new eui.Group;
        o.width = r, o.height = s, WndManager.root.addChild(o), WndManager.root.y = 0;
        for (var a = 40, l = 5, h = a / l, _ = 0; a > _; _++) {
            var c = r / l,
                d = s / h,
                u = _ % l * c,
                p = Math.floor(_ / l) * d,
                g = new egret.RenderTexture,
                m = (g.drawToTexture(n, new egret.Rectangle(u, p, c, d)), new egret.Bitmap);
            switch (m.texture = g, m.anchorOffsetX = c / 2, m.anchorOffsetY = d / 2, m.x = u + c / 2, m.y = p + d / 2, m.cacheAsBitmap = !0, o.addChild(m), 5 == t && (t = Math.ceil(4 * Math.random())), t) {
                case 1:
                    var w = egret.Tween.get(m);
                    w.to({
                        scaleX: 0,
                        scaleY: 0,
                        alpha: 0,
                        rotation: 359
                    }, 1e3, egret.Ease.circIn).call(i, this);
                    break;
                case 2:
                    var y = -r;
                    _ % 2 || (y = 2 * r);
                    var w = egret.Tween.get(m);
                    w.to({
                        x: y,
                        alpha: 0
                    }, 1e3, egret.Ease.circIn).call(i, this);
                    break;
                case 3:
                    var w = egret.Tween.get(m);
                    w.to({
                        scaleX: .2,
                        scaleY: 1,
                        alpha: 0,
                        blurFliter: 0
                    }, 1e3, egret.Ease.backInOut).call(i, this);
                    break;
                case 4:
                    var w = egret.Tween.get(m);
                    w.to({
                        alpha: 0
                    }, 500, egret.Ease.circIn).call(i, this);
                    break;
                default:
                    var w = egret.Tween.get(m);
                    w.to({
                        scaleX: 1,
                        scaleY: 0,
                        alpha: 0
                    }, 1e3, egret.Ease.circIn).call(i, this)
            }
        }
        WndManager.root._hBL > 1236 ? WndManager.root.y = 0 : WndManager.root._hBL > 1036 ? WndManager.root.y = -((1236 - WndManager.root._hBL) / 2) : WndManager.root.y = -100;
        var v = 0
    }
    e.MovieStart = t
}(ScreenMovies || (ScreenMovies = {}));
var SoundExample = function (e) {
    function t() {
        return e.call(this) || this
    }
    return __extends(t, e), t.startLoad = function (e, i) {
        void 0 === i && (i = !1), t.root.soundExample.startLoad(e, i)
    }, t.prototype.startLoad = function (e, t) {
        void 0 === t && (t = !1);
        var i = document.getElementById("effectMusic");
        t ? i.pause() : (i.src = e, i.play())
    }, t
}(egret.DisplayObjectContainer);
__reflect(SoundExample.prototype, "SoundExample");
var ButtonEff = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._btnImg = null, t._stopBol = !1, t._playBol = !1, t.create(), t
    }
    return __extends(t, e), t.prototype.create = function () {
        this._playBol = !1, this._btnImg = new egret.Bitmap, this._btnImg = MyUtils.createBitmapByName("music2_png"), this._btnImg.anchorOffsetX = this._btnImg.width / 2, this._btnImg.anchorOffsetY = this._btnImg.height / 2, this._btnImg.touchEnabled = !0, this.addChild(this._btnImg), egret.Tween.get(this._btnImg, {
            loop: !0
        }).to({
            rotation: 360
        }, 4e3), this._btnImg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onBtnTap, this)
    }, t.prototype.onBtnTap = function (e) {
        var t = document.getElementById("bgMusic");
        this._playBol ? (this._playBol = !1, egret.Tween.get(this._btnImg, {
            loop: !0
        }).to({
            rotation: 360
        }, 4e3), t.play()) : (this._playBol = !0, egret.Tween.removeTweens(this._btnImg), this._btnImg.rotation = 0, t.pause())
    }, t.prototype.onChange_stop = function () {
        if (!this._playBol) {
            var e = document.getElementById("bgMusic");
            e.pause()
        }
    }, t.prototype.onChange_play = function () {
        if (!this._playBol) {
            var e = document.getElementById("bgMusic");
            e.play()
        }
    }, t.prototype.onMusic_play = function () {
        var e = document.getElementById("bgMusic");
        this._playBol && (this._playBol = !1, egret.Tween.get(this._btnImg, {
            loop: !0
        }).to({
            rotation: 360
        }, 4e3)), e.play()
    }, t
}(egret.Sprite);
__reflect(ButtonEff.prototype, "ButtonEff");
var WIN_OPERATOR;
! function (e) {
    e[e.WIN_OPEN_NEW_UP = 0] = "WIN_OPEN_NEW_UP", e[e.WIN_OPEN_NEW = 1] = "WIN_OPEN_NEW", e[e.WIN_OPEN_NEW_DOWN = 2] = "WIN_OPEN_NEW_DOWN", e[e.WIN_CLOSE_DELETE = 3] = "WIN_CLOSE_DELETE", e[e.WIN_CLOSE_HIDE = 4] = "WIN_CLOSE_HIDE", e[e.WIN_OPEN_SHOW = 5] = "WIN_OPEN_SHOW", e[e.WIN_OPEN_SHOW_OR_HIDE = 6] = "WIN_OPEN_SHOW_OR_HIDE"
}(WIN_OPERATOR || (WIN_OPERATOR = {}));
var WIN_EFFECT;
! function (e) {
    e[e.EFFECT_WIN_CLOSE_BEGIN = 0] = "EFFECT_WIN_CLOSE_BEGIN", e[e.EFFECT_WIN_CLOSE_MOVE_LEFT = 1] = "EFFECT_WIN_CLOSE_MOVE_LEFT", e[e.EFFECT_WIN_CLOSE_MOVE_RIGHT = 2] = "EFFECT_WIN_CLOSE_MOVE_RIGHT", e[e.EFFECT_WIN_CLOSE_MOVE_UP = 3] = "EFFECT_WIN_CLOSE_MOVE_UP", e[e.EFFECT_WIN_CLOSE_MOVE_DOWN = 4] = "EFFECT_WIN_CLOSE_MOVE_DOWN", e[e.EFFECT_WIN_CLOSE_SCALE = 5] = "EFFECT_WIN_CLOSE_SCALE", e[e.EFFECT_WIN_CLOSE_ALPHA = 6] = "EFFECT_WIN_CLOSE_ALPHA", e[e.EFFECT_WIN_CLOSE_END = 7] = "EFFECT_WIN_CLOSE_END", e[e.EFFECT_WIN_OPEN_MOVE_LEFT = 8] = "EFFECT_WIN_OPEN_MOVE_LEFT", e[e.EFFECT_WIN_OPEN_MOVE_RIGHT = 9] = "EFFECT_WIN_OPEN_MOVE_RIGHT", e[e.EFFECT_WIN_OPEN_MOVE_UP = 10] = "EFFECT_WIN_OPEN_MOVE_UP", e[e.EFFECT_WIN_OPEN_MOVE_DOWN = 11] = "EFFECT_WIN_OPEN_MOVE_DOWN", e[e.EFFECT_WIN_OPEN_SCALE = 12] = "EFFECT_WIN_OPEN_SCALE", e[e.EFFECT_WIN_OPEN_ALPHA = 13] = "EFFECT_WIN_OPEN_ALPHA", e[e.EFFECT_WIN_OPEN_END = 14] = "EFFECT_WIN_OPEN_END"
}(WIN_EFFECT || (WIN_EFFECT = {}));
var WndManager = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t.wins = [], t
    }
    return __extends(t, e), t.prototype.switchWnd = function (e, i, n) {
        var r = null;
        switch (i) {
            case WIN_OPERATOR.WIN_OPEN_NEW_UP:
                r = new e, t.root.addChild(r), this.wins.push(r), onAddEvent("page", egret.getQualifiedClassName(e), "open"), onBiLogPage(egret.getQualifiedClassName(e));
                break;
            case WIN_OPERATOR.WIN_OPEN_NEW:
                r = new e, this.addChild(r), this.wins.push(r), onAddEvent("page", egret.getQualifiedClassName(e), "open"), onBiLogPage(egret.getQualifiedClassName(e));
                break;
            case WIN_OPERATOR.WIN_OPEN_NEW_DOWN:
                r = new e, this.addChildAt(r, 0), this.wins.push(r), onAddEvent("page", egret.getQualifiedClassName(e), "open"), onBiLogPage(egret.getQualifiedClassName(e));
                break;
            case WIN_OPERATOR.WIN_OPEN_SHOW:
                for (var s = 0; s < this.wins.length; s++)
                    if (this.wins[s] instanceof e) {
                        r = this.wins[s];
                        break
                    } null == r && (r = new e, this.wins.push(r)), this.addChild(r), r.visible = !0;
                break;
            case WIN_OPERATOR.WIN_CLOSE_DELETE:
                for (var s = 0; s < this.wins.length; s++)
                    if (this.wins[s] instanceof e) {
                        r = this.wins[s], this.wins.splice(s, 1);
                        break
                    } break;
            case WIN_OPERATOR.WIN_CLOSE_HIDE:
                for (var s = 0; s < this.wins.length; s++)
                    if (this.wins[s] instanceof e) {
                        r = this.wins[s];
                        break
                    } null == r && (r = new e, this.wins.push(r)), this.addChild(r);
                break;
            case WIN_OPERATOR.WIN_OPEN_SHOW_OR_HIDE:
                for (var s = 0; s < this.wins.length; s++)
                    if (this.wins[s] instanceof e) {
                        r = this.wins[s];
                        break
                    } null == r && (r = new e, this.wins.push(r)), this.addChild(r), r.visible = !1
        }
        if (null == r) return console.error("wnd can't null !!!!!!!!'"), r;
        var o = null;
        if (null == n || 0 == n) i == WIN_OPERATOR.WIN_CLOSE_HIDE ? r.visible = !1 : i == WIN_OPERATOR.WIN_CLOSE_DELETE ? r.Destroy() : i == WIN_OPERATOR.WIN_OPEN_SHOW_OR_HIDE && (r.visible = !r.visible);
        else if (n > WIN_EFFECT.EFFECT_WIN_CLOSE_END && n < WIN_EFFECT.EFFECT_WIN_OPEN_END) {
            switch (n) {
                case WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_LEFT:
                    r.x = -t.root.stage.stageWidth, r.y = 0, r.scaleX = 1, r.scaleY = 1, o = egret.Ease.bounceOut;
                    break;
                case WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_RIGHT:
                    r.x = t.root.stage.stageWidth, r.y = 0, r.scaleX = 1, r.scaleY = 1, o = egret.Ease.bounceOut;
                    break;
                case WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_UP:
                    r.x = 0, r.y = -1236, r.scaleX = 1, r.scaleY = 1, o = egret.Ease.bounceOut;
                    break;
                case WIN_EFFECT.EFFECT_WIN_OPEN_MOVE_DOWN:
                    r.x = 0, r.y = 1236, r.scaleX = 1, r.scaleY = 1, o = egret.Ease.bounceOut;
                    break;
                case WIN_EFFECT.EFFECT_WIN_OPEN_SCALE:
                    r.x = t.root.stage.stageWidth >> 1, r.y = t.root.stage.stageHeight >> 1, r.scaleX = 0, r.scaleY = 0;
                    break;
                case WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA:
                    r.alpha = .5
            }
            egret.Tween.get(r).to({
                x: 0,
                y: 0,
                alpha: 1
            }, 500)
        } else if (n > WIN_EFFECT.EFFECT_WIN_CLOSE_BEGIN && n < WIN_EFFECT.EFFECT_WIN_CLOSE_END) {
            var a, l, h, _, c;
            switch (n) {
                case WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_LEFT:
                    a = -t.root.stage.stageWidth, l = 0, h = 1, _ = 1, c = 1, o = egret.Ease.bounceIn;
                    break;
                case WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_RIGHT:
                    a = t.root.stage.stageWidth, l = 0, h = 1, _ = 1, c = 1, o = egret.Ease.bounceIn;
                    break;
                case WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_UP:
                    a = 0, l = -1236, h = 1, _ = 1, c = 1, o = egret.Ease.bounceIn;
                    break;
                case WIN_EFFECT.EFFECT_WIN_CLOSE_MOVE_DOWN:
                    a = 0, l = 1236, h = 1, _ = 1, c = 1, o = egret.Ease.bounceIn;
                    break;
                case WIN_EFFECT.EFFECT_WIN_CLOSE_SCALE:
                    h = 0, _ = 0, c = 1;
                    break;
                case WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA:
                    h = 1, _ = 1, c = 0
            }
            i == WIN_OPERATOR.WIN_CLOSE_DELETE && this.addChild(r), egret.Tween.get(r).to({
                x: a,
                y: l,
                alpha: c
            }, 500).call(function () {
                i == WIN_OPERATOR.WIN_CLOSE_HIDE ? r.visible = !1 : i == WIN_OPERATOR.WIN_CLOSE_DELETE && r.Destroy()
            }, this)
        }
        return r
    }, t.switchWnd = function (e, i, n) {
        return t.root.wndmanager.switchWnd(e, i, n)
    }, t.prototype.getWnd = function (e) {
        for (var t = 0; t < this.wins.length; t++)
            if (this.wins[t] instanceof e) return this.wins[t];
        return null
    }, t.getWnd = function (e) {
        return t.root.wndmanager.getWnd(e)
    }, t.setinfo = function (e, t) {}, t.prototype.clear = function () {
        this.wins = [], this.removeChildren()
    }, t.clear = function () {
        t.root.wndmanager.clear()
    }, t.getInstance = function () {
        return t.root.wndmanager
    }, t
}(egret.Sprite);
__reflect(WndManager.prototype, "WndManager");
var JsonpReq = function () {
    function e() {}
    return e.process = function (t, i, n) {
        window.testcallback = i, e.completeCall["call_" + e._regID] = i.bind(n), e.startLoader(t, e._regID)
    }, e.startLoader = function (e, t) {
        var i = document.createElement("script");
        i.src = e + "callback", document.body.appendChild(i)
    }, e
}();
JsonpReq._regID = 0, JsonpReq.completeCall = {}, __reflect(JsonpReq.prototype, "JsonpReq");
var LoadingMovie = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._role = null, t._roleTimer = 0, t._frameNum = 8, t
    }
    return __extends(t, e), t.prototype.addRole = function () {
        this._roleAny = [], this._role = MyUtils.createBitmapByName("scene001_png"), this.addChild(this._role);
        var e;
        for (e = 1; 25 >= e; e++) this._roleAny.push("scene00" + e + "_png")
    }, t.prototype.onPlay = function () {
        egret.startTick(this.onPlayEvent, this)
    }, t.prototype.onStop = function () {
        egret.stopTick(this.onPlayEvent, this), this.dispatchEvent(new egret.Event("onPlayerCom"))
    }, t.prototype.onPlayEvent = function (e) {
        this._roleTimer++;
        for (var t = 1; t <= this._roleAny.length; t++)
            if (this._roleTimer == this._frameNum * t) {
                for (var i = 0; i < this._roleAny.length; i++) i == t - 1 && (this._role.texture = RES.getRes(this._roleAny[i]));
                return t == this._roleAny.length && (this._roleTimer = 0), !1
            } return !1
    }, t
}(egret.DisplayObjectContainer);
__reflect(LoadingMovie.prototype, "LoadingMovie");
var Loading = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._loading_bg = null, t._loading_star0 = null, t._loading_star1 = null, t._loading_star2 = null, t._loading_proBg = null, t._loading_pro = null, t._loading_proMask = null, t._loading_logo = null, t._textField = null, t._hudieMovieSp = null, t
    }
    return __extends(t, e), t.prototype.update = function () {
        this._loading_bg = MyUtils.createImageByName("loading_bg_jpg", 750, 1448, 0, 0), this.addChild(this._loading_bg), this._loading_star0 = MyUtils.createImageByName("loading_star0_png", 568, 492, 70, 633), this.addChild(this._loading_star0), egret.Tween.get(this._loading_star0, {
            loop: !0
        }).to({
            alpha: 0
        }, 500).to({
            alpha: 1
        }, 500).wait(100), this._loading_star1 = MyUtils.createImageByName("loading_star1_png", 488, 161, 123, 633), this.addChild(this._loading_star1), egret.Tween.get(this._loading_star1, {
            loop: !0
        }).to({
            alpha: 0
        }, 800).to({
            alpha: 1
        }, 800), this._loading_star2 = MyUtils.createImageByName("loading_star2_png", 415, 143, 191, 641), this.addChild(this._loading_star2), egret.Tween.get(this._loading_star2, {
            loop: !0
        }).to({
            alpha: 0
        }, 600).wait(100).to({
            alpha: 1
        }, 600), this._loading_proBg = MyUtils.createImageByName("loading_proBg_png", 652, 66, 49, 691), this.addChild(this._loading_proBg), this._loading_pro = MyUtils.createImageByName("loading_pro_png", 574, 66, 88, 691), this.addChild(this._loading_pro), this._loading_proMask = DrawGraphics.onDrawGraphicsSquare(0, 0, 574, 70, 16777215, 1, !0), this._loading_proMask.x = -486, this._loading_proMask.y = 688, this.addChild(this._loading_proMask), this._loading_pro.mask = this._loading_proMask, this._loading_logo = MyUtils.createImageByName("loading_logo_png", 400, 58, 22, 127), this.addChild(this._loading_logo), this._hudieMovieSp = new LoadingHudieMovieSp, this._hudieMovieSp.addRole(), this._hudieMovieSp.x = 88, this._hudieMovieSp.y = 678, this._hudieMovieSp.onPlay(), this._hudieMovieSp.scaleX = this._hudieMovieSp.scaleY = .6, this.addChild(this._hudieMovieSp), egret.Tween.get(this._hudieMovieSp, {
            loop: !0
        }).to({
            y: 650
        }, 1e3).to({
            y: 668
        }, 1e3), this._textField = GetTextField.createTextField(750, 50, 26, 12242407, "0%"), this._textField.y = 758, this.addChild(this._textField)
    }, t.prototype.onRemove = function () {
        null != this._textField && (this._textField.parent.removeChild(this._textField), this._textField = null), null != this._loading_pro && (this._loading_pro.mask = null, this._loading_pro.parent.removeChild(this._loading_pro), this._loading_pro = null), null != this._hudieMovieSp && (console.log("rrr"), egret.Tween.removeTweens(this._hudieMovieSp), this._hudieMovieSp.onStop(), this._hudieMovieSp.parent.removeChild(this._hudieMovieSp), this._hudieMovieSp = null)
    }, t.prototype.setProgress = function (e, t) {
        egret.log(String(Math.floor(100 * e / t) + "%")), null != this._textField && (this._textField.text = String(Math.floor(100 * e / t) + "%"), this._hudieMovieSp.x = 88 + 574 * (e / t), this._loading_proMask.x = -486 + 574 * (e / t))
    }, t
}(egret.Sprite);
__reflect(Loading.prototype, "Loading");
var OpenAlbumHandler;
! function (e) {
    function t(e, t, i) {
        void 0 === e && (e = 1), void 0 === t && (t = "up"), void 0 === i && (i = null), console.log("wxAlbumPhoto==>")
    }

    function i(e) {}

    function n(e, t, i, n, r) {
        WndManager.root.y = 0;
        var s = new egret.RenderTexture;
        s.drawToTexture(e, new egret.Rectangle(t, i, n, r));
        var o = s.toDataURL("image/jpeg");
        o = String(o).substr(23, o.length), WndManager.root._hBL > 1236 ? WndManager.root.y = 0 : WndManager.root._hBL > 1036 ? this.y = -((1236 - WndManager.root._hBL) / 2) : WndManager.root.y = -100, WndManager.root._prop.uploadData(o)
    }
    e.wxAlbumPhoto = t, e.getAlbumPhoto = i, e.onSend = n
}(OpenAlbumHandler || (OpenAlbumHandler = {}));
var PageUtils = function () {
    function e() {
        this._pageData = null, this._pageTotal = 0, this._pageSize = 0, this._curPage = 0, this._beginIndex = 0, this._endIndex = 0
    }
    return e.prototype.init = function (e, t) {
        this._pageSize = e, this._pageData = t, this._pageTotal = Math.ceil(this._pageData.length / this._pageSize), this.updatePage()
    }, e.prototype.frontPage = function () {
        return this._curPage <= 0 ? !1 : (this._curPage--, this.updatePage(), !0)
    }, e.prototype.nextPage = function () {
        return this._curPage >= this._pageTotal - 1 ? !1 : (this._curPage++, this.updatePage(), !0)
    }, e.prototype.updatePage = function () {
        this._beginIndex = this._curPage * this._pageSize, this._endIndex = this._curPage * this._pageSize + this._pageSize, this._endIndex > this._pageData.length && (this._endIndex = this._pageData.length)
    }, e
}();
__reflect(PageUtils.prototype, "PageUtils");
var SendLoadingMovie = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._role = null, t._fx = 0, t._clickBol = !1, t._frameNum = 3, t
    }
    return __extends(t, e), t.prototype.addRole = function () {
        var e = DrawGraphics.onDrawGraphicsSquare(-320, -618, 640, 1236, 16777215, 0, !0);
        this.addChild(e);
        var t = new egret.Shape;
        t.graphics.beginFill(0), t.graphics.drawRoundRect(-94, -94, 188, 188, 28, 28), t.graphics.endFill(), t.alpha = .8, t.touchEnabled = !1, this.addChild(t), this._roleContainer = new egret.Sprite, this._roleAny = [], this._role = MyUtils.createBitmapByName("sendLoading_json.send001"), this._role.anchorOffsetX = this._role.width / 2, this._role.anchorOffsetY = this._role.height / 2, this._roleContainer.addChild(this._role);
        for (var i = 1; 60 >= i; i++) 42 > i ? this._roleAny.push("sendLoading_json.send00" + String(i)) : this._roleAny.push("sendLoading_json.send0042");
        this.addChild(this._roleContainer)
    }, t.prototype.RolePlay = function (e, t) {
        void 0 === e && (e = 0), void 0 === t && (t = 0), 0 == e && (this._roleTimer = 0), 0 != t && (this._frameNum = t), egret.startTick(this.onPlayEvent, this)
    }, t.prototype.onPlayEvent = function (e) {
        this._roleTimer++;
        for (var t = 1; t <= this._roleAny.length; t++)
            if (this._roleTimer == this._frameNum * t) {
                for (var i = 0; i < this._roleAny.length; i++) i == t - 1 && (this._role.texture = RES.getRes(this._roleAny[i]));
                return t == this._roleAny.length && (this._roleTimer = 0), !1
            } return !1
    }, t.prototype.RoleStop = function () {
        egret.stopTick(this.onPlayEvent, this), this._roleTimer = 0, this.dispatchEvent(new egret.Event("onNext"))
    }, t
}(egret.Sprite);
__reflect(SendLoadingMovie.prototype, "SendLoadingMovie");
var BeginCaoSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._begin_cao22 = null, t._begin_cao21 = null, t._begin_cao20 = null, t._begin_cao19 = null, t._begin_cao18 = null, t._begin_cao17 = null, t._begin_cao16 = null, t._begin_cao15 = null, t._begin_cao14 = null, t._begin_cao13 = null, t._begin_cao12 = null, t._begin_cao11 = null, t._begin_cao10 = null, t._begin_cao9 = null, t._begin_cao8 = null, t._begin_cao7 = null, t._begin_cao6 = null, t._begin_cao5 = null, t._begin_cao4 = null, t._begin_cao3 = null, t._begin_cao2 = null, t._begin_cao1 = null, t._begin_cao0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddBeginCao = function () {
        this._begin_cao22 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao22.png", 89, 106, 93, 44, "l_d"), this.addChild(this._begin_cao22), this._begin_cao21 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao21.png", 47, 75, 157, 77, "r_d"), this.addChild(this._begin_cao21), this._begin_cao20 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao20.png", 48, 99, 184, 53, "c_d"), this.addChild(this._begin_cao20), this._begin_cao19 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao19.png", 48, 85, 274, 67, "r_d"), this.addChild(this._begin_cao19), this._begin_cao18 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao18.png", 78, 112, 308, 39, "l_d"), this.addChild(this._begin_cao18), this._begin_cao17 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao17.png", 69, 82, 351, 70, "l_d"), this.addChild(this._begin_cao17), this._begin_cao16 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao16.png", 53, 104, 408, 48, "r_d"), this.addChild(this._begin_cao16), this._begin_cao15 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao15.png", 47, 114, 471, 33, "c_d"), this.addChild(this._begin_cao15), this._begin_cao14 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao14.png", 60, 71, 488, 80, "l_d"), this.addChild(this._begin_cao14), this._begin_cao13 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao13.png", 51, 141, 0, 0, "l_d"), this.addChild(this._begin_cao13), this._begin_cao12 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao12.png", 66, 84, 39, 36, "l_d"), this.addChild(this._begin_cao12), this._begin_cao11 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao11.png", 79, 87, 71, 65, "l_d"), this.addChild(this._begin_cao11), this._begin_cao10 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao10.png", 51, 76, 125, 104, "r_d"), this.addChild(this._begin_cao10), this._begin_cao9 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao9.png", 52, 113, 158, 75, "c_d"), this.addChild(this._begin_cao9), this._begin_cao8 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao8.png", 86, 124, 209, 64, "l_d"), this.addChild(this._begin_cao8), this._begin_cao7 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao7.png", 51, 96, 264, 92, "r_d"), this.addChild(this._begin_cao7), this._begin_cao6 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao6.png", 86, 129, 305, 58, "l_d"), this.addChild(this._begin_cao6), this._begin_cao5 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao5.png", 77, 92, 354, 96, "l_d"), this.addChild(this._begin_cao5), this._begin_cao4 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao4.png", 57, 94, 423, 70, "r_d"), this.addChild(this._begin_cao4), this._begin_cao3 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao3.png", 64, 73, 494, 74, "r_d"), this.addChild(this._begin_cao3), this._begin_cao2 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao2.png", 69, 118, 497, 29, "r_d"), this.addChild(this._begin_cao2), this._begin_cao1 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao1.png", 51, 136, 546, 8, "c_d"), this.addChild(this._begin_cao1), this._begin_cao0 = MyUtils.createImageByNameUrl("resource/begin/BeginCaoSp/begin_cao0.png", 61, 80, 570, 65, "l_d"), this.addChild(this._begin_cao0), this._arr = [];
        for (var e = 0; 23 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_begin_cao" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_begin_cao" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(BeginCaoSp.prototype, "BeginCaoSp");
var BeginWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._begin_bg = null, t._beginCaoSp = null, t._music2 = null, t._music1 = null, t._begin_hd = null, t._begin_info = null, t._begin_label2 = null, t._begin_label = null, t._begin_labelw = null, t._begin_startBtn = null, t._loading_logo = null, t._hd1 = null, t._hd2 = null, t._hd3 = null, t._hd4 = null, t._hd5 = null, t._hd6 = null, t._hd0 = null, t._XYArr = [
            [22.9, 1230.05, 0, 0, 1.8799285888671875, 1.8799285888671875, 0, 1],
            [148.6, 808.05, 0, 0, .9999974428177711, .9999974428177711, -14.998931884765625, 1],
            [608.8, 989.9, 0, 0, .9999974428177711, .9999974428177711, -14.998931884765625, 1],
            [552.75, 781.25, 0, 0, .596760368589523, .596760368589523, -14.99810791015625, 1],
            [566.25, 563.6, 0, 0, .4269584954810503, .4269584954810503, -14.998931884765625, 1],
            [723.75, 367.85, 0, 0, .5978631759189795, .5978631759189795, -14.99810791015625, 1],
            [611.55, 165.9, 0, 0, .49475538231586647, .49475538231586647, -14.997299194335938, 1]
        ], t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        var e = this;
        this._begin_bg = MyUtils.createImageByName("begin_bg_jpg", 750, 1448, 0, 0), this.addChild(this._begin_bg), this._beginCaoSp = new BeginCaoSp, this._beginCaoSp.onAddBeginCao(), this._beginCaoSp.x = 63, this._beginCaoSp.y = 1062, this.addChild(this._beginCaoSp);
        for (var t = 0; t < this._XYArr.length; t++) {
            this["_hd" + t] = new LoadingHudieMovieSp, this["_hd" + t].addRole(), this["_hd" + t].x = this._XYArr[t][0], this["_hd" + t].y = this._XYArr[t][1], 2 == t || 3 == t || 4 == t || 6 == t ? this["_hd" + t].scaleX = -this._XYArr[t][4] : this["_hd" + t].scaleX = this._XYArr[t][4], this["_hd" + t].scaleY = this._XYArr[t][5], this["_hd" + t].onPlay(), this.addChild(this["_hd" + t]);
            var i = 1e3 * Math.random() + 1e3;
            egret.Tween.get(this["_hd" + t], {
                loop: !0
            }).to({
                y: this["_hd" + t].y + (Math.floor(10 * Math.random()) + 10)
            }, i).to({
                y: this["_hd" + t].y
            }, i)
        }
        this._begin_label = MyUtils.createImageByName("begin_label_png", 620, 206, 83, 210, "c_c"), this._begin_label.y = this._begin_label.y + 50, this._begin_label.alpha = 0, this.addChild(this._begin_label), egret.Tween.get(this._begin_label, {
            loop: !1
        }).wait(500).to({
            alpha: 1,
            y: this._begin_label.y - 50
        }, 500).call(function () {
            e._begin_labelw = MyUtils.createImageByName("begin_label_png", 620, 206, 83, 210, "c_c"), e.addChild(e._begin_labelw), egret.Tween.get(e._begin_labelw, {
                loop: !0
            }).to({
                alpha: 0
            }, 1e3).to({
                alpha: 1
            }, 1e3), e._begin_label2 = MyUtils.createImageByName("begin_label2_png", 578, 29, 90, 411), e._begin_label2.alpha = 0, e.addChild(e._begin_label2), egret.Tween.get(e._begin_label2, {
                loop: !1
            }).to({
                alpha: 1
            }, 500).call(function () {
                e._begin_startBtn = MyUtils.createImageByName("begin_startBtn_png", 324, 89, 213, 1216, "c_c"), e._begin_startBtn.scaleX = e._begin_startBtn.scaleY = 0, e.addChild(e._begin_startBtn), egret.Tween.get(e._begin_startBtn, {
                    loop: !1
                }).to({
                    scaleX: 1,
                    scaleY: 1
                }, 500, egret.Ease.backOut).call(function () {
                    egret.Tween.get(e._begin_startBtn, {
                        loop: !0
                    }).wait(2e3).to({
                        scaleX: 1.1,
                        scaleY: 1.1,
                        rotation: -5
                    }, 100).to({
                        rotation: 5
                    }, 200).to({
                        rotation: -5
                    }, 200).to({
                        rotation: 5
                    }, 200).to({
                        scaleX: 1,
                        scaleY: 1,
                        rotation: 0
                    }, 100), e._begin_info = MyUtils.createImageByName("begin_info_png", 367, 29, 193, 1328), e._begin_info.alpha = 0, e._begin_info.touchEnabled = !1, e.addChild(e._begin_info), egret.Tween.get(e._begin_info, {
                        loop: !1
                    }).to({
                        alpha: 1
                    }, 500).call(function () {}, e), e._begin_startBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, e.onStartTap, e)
                }, e)
            }, e)
        }, this), this._loading_logo = MyUtils.createImageByName("loading_logo_png", 400, 58, 22, 127), this.addChild(this._loading_logo)
    }, t.prototype.onStartTap = function (e) {
        this._begin_startBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onStartTap, this), egret.Tween.removeTweens(this._begin_startBtn), this._begin_startBtn.scaleX = this._begin_startBtn.scaleY = 1, this._begin_startBtn.rotation = 0, egret.Tween.get(this._begin_startBtn).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(TransitionWnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA)
        }, this)
    }, t.prototype.Destroy = function () {
        if (null != this._beginCaoSp) {
            this._beginCaoSp.onRemove(), this._beginCaoSp.parent.removeChild(this._beginCaoSp), this._beginCaoSp = null;
            for (var e = 0; e < this._XYArr.length; e++) egret.Tween.removeTweens(this["_hd" + e]), this["_hd" + e].onStop()
        }
        this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(BeginWnd.prototype, "BeginWnd");
var CardSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._card_bg = null, t._card_lig0 = null, t._card_lig1 = null, t._card_frameInfo = null, t._card_musicInfo = null, t._card_circle = null, t._card_stopBtn = null, t._card_playBtn = null, t._card_returnBtn = null, t._bg = null, t._id = 0, t._reviseX = 0, t._reviseY = 0, t._playBol = !1, t._clickBol = !1, t
    }
    return __extends(t, e), t.prototype.onAddCard = function (e, t, i) {
        this._id = e, this._clickBol = !1, this._bg = DrawGraphics.onDrawGraphicsSquare(0, 0, 750, 1448, 0, .5, !0), this.addChild(this._bg), this._card_bg = MyUtils.createImageByName("card_bg_png", 645, 1021, 54, 178), this.addChild(this._card_bg), this._card_lig0 = MyUtils.createImageByName("card_lig0_png", 645, 1066, 54, 171), this.addChild(this._card_lig0), egret.Tween.get(this._card_lig0, {
            loop: !0
        }).to({
            alpha: .3
        }, 500).to({
            alpha: 1
        }, 500), this._card_lig1 = MyUtils.createImageByName("card_lig1_png", 621, 757, 41, 548), this.addChild(this._card_lig1), egret.Tween.get(this._card_lig1, {
            loop: !0
        }).to({
            alpha: .3
        }, 700).to({
            alpha: 1
        }, 700), this._card_frameInfo = MyUtils.createImageByName("card_frameInfo_png", 309, 44, 221, 1116), this.addChild(this._card_frameInfo);
        var n = new MusicPhotoSp;
        n.onAddMusicPhoto(this._id), n.x = 375, n.y = 493, this.addChild(n), this._card_musicInfo = MyUtils.createBitmapByName("card_music" + this._id + "Info_png"), this._card_musicInfo.anchorOffsetX = this._card_musicInfo.width / 2, this._card_musicInfo.x = 375, this._card_musicInfo.y = 720, this._card_musicInfo.alpha = 0, this.addChild(this._card_musicInfo), egret.Tween.get(this._card_musicInfo).wait(500).to({
            alpha: 1
        }, 500), this._card_circle = MyUtils.createImageByName("card_circle_png", 112, 111, 321, 982, "c_c"), this.addChild(this._card_circle), this._card_playBtn = MyUtils.createImageByName("card_playBtn_png", 84, 84, 336, 996, "c_c"), this.addChild(this._card_playBtn), this._card_returnBtn = MyUtils.createImageByName("card_returnBtn_png", 232, 73, 267, 1237, "c_c"), this.addChild(this._card_returnBtn), this.onList(!0);
        this._clickBol = !0, WndManager.root._buttonEff.onChange_stop(), this._playBol = !0;
        var r = document.getElementById("bgMusic");
        r.src = config_json._bgmUrl + "resource/sound/bgm" + this._id + ".mp3?v=" + versions, r.currentTime = 0, WndManager.root._buttonEff.onMusic_play(), console.log("this._musicId====>", config_json._bgmUrl + "resource/sound/bgm" + this._id + ".mp3?v=" + versions);
        var s = this;
        WndManager.root._prop._endFun = function () {
            console.log("_endFun==>"), s._playBol = !1, egret.Tween.removeTweens(s._card_circle), s._card_circle.rotation = 0, s._card_playBtn.source = RES.getRes("card_playBtn_png");
            var e = document.getElementById("bgMusic");
            e.removeEventListener("ended", WndManager.root._prop._endFun, !1), e.currentTime = 0, e.pause(), WndManager.root._prop._endFun = null
        }, r.addEventListener("ended", WndManager.root._prop._endFun, !1), this._card_playBtn.source = RES.getRes("card_stopBtn_png"), egret.Tween.get(this._card_circle, {
            loop: !0
        }).to({
            rotation: 360
        }, 5e3), onAddEvent("scene" + this._id, "play", "music" + this._id), onBiLogClick("scene" + this._id, "music" + this._id + "Open", "")
    }, t.prototype.onList = function (e) {
        e ? (this._card_returnBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onReturnTap, this), this._card_playBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlayMusic, this)) : (this._card_returnBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onReturnTap, this), this._card_playBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlayMusic, this))
    }, t.prototype.onReturnTap = function (e) {
        var t = this;
        this.onList(!1), null != WndManager.root._prop._endFun && WndManager.root._prop._endFun(), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            if (t._clickBol) {
                var e = document.getElementById("bgMusic");
                e.src = musicUrlArr[1], WndManager.root._buttonEff.onMusic_play()
            }
            t.dispatchEvent(new egret.Event("onNextScene")), t.parent.removeChild(t)
        }, this)
    }, t.prototype.onPlayMusic = function (e) {
        var t = this;
        if (this._clickBol = !0, console.log(this._playBol), null == WndManager.root._prop._endFun) {
            WndManager.root._buttonEff.onChange_stop(), this._playBol = !0;
            var i = document.getElementById("bgMusic");
            i.src = config_json._bgmUrl + "resource/sound/bgm" + this._id + ".mp3?v=" + versions, i.currentTime = 0, WndManager.root._buttonEff.onMusic_play(), console.log("this._musicId====>", config_json._bgmUrl + "resource/sound/bgm" + this._id + ".mp3?v=" + versions);
            var n = this;
            WndManager.root._prop._endFun = function () {
                console.log("_endFun==>"), n._playBol = !1, egret.Tween.removeTweens(n._card_circle), n._card_circle.rotation = 0, n._card_playBtn.source = RES.getRes("card_playBtn_png");
                var e = document.getElementById("bgMusic");
                e.removeEventListener("ended", WndManager.root._prop._endFun, !1), e.currentTime = 0, e.pause(), WndManager.root._prop._endFun = null
            }, i.addEventListener("ended", WndManager.root._prop._endFun, !1), onAddEvent("music", "play", "music" + this._id), onBiLogClick("sceneWnd" + this._id, "music" + this._id + "play", "")
        } else this._playBol = !1, WndManager.root._prop._endFun(), onAddEvent("music", "stop", "music" + this._id), onBiLogClick("sceneWnd" + this._id, "music" + this._id + "stop", "");
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).call(function () {
            console.log(t._playBol), t._playBol ? (t._card_playBtn.source = RES.getRes("card_stopBtn_png"), egret.Tween.get(t._card_circle, {
                loop: !0
            }).to({
                rotation: 360
            }, 5e3)) : (egret.Tween.removeTweens(t._card_circle), t._card_circle.rotation = 0, t._card_playBtn.source = RES.getRes("card_playBtn_png"))
        }, this).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            t.onList(!0)
        }, this)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(CardSp.prototype, "CardSp");
var CodeSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._code_frame = null, t._code_copyBtn = null, t._bg = null, t._txt = null, t._totalNum = 5, t
    }
    return __extends(t, e), t.prototype.onAddCode = function () {
        this._bg = DrawGraphics.onDrawGraphicsSquare(0, 0, 750, 1448, 0, .68, !0), this.addChild(this._bg), this._txt = GetTextField.createTextField(750, 50, 26, 16777215, "兑换码排队领取中，请稍候..."), this._txt.y = 700, this.addChild(this._txt), "null" == WndManager.root._prop._codeStr || null == WndManager.root._prop._codeStr ? (WndManager.root._prop.addEventListener("onGetCode", this.onGetCode, this), WndManager.root._prop.onGetCode()) : "888" == WndManager.root._prop._codeStr ? this.onShowCode("兑换码已被经领完！") : this.onShowCode()
    }, t.prototype.onGetCode = function (e) {
        var t = this;
        WndManager.root._prop.removeEventListener("onGetCode", this.onGetCode, this), 0 == WndManager.root._prop.onGetCode_data.code ? "null" != String(WndManager.root._prop.onGetCode_data.data) ? (WndManager.root._prop._codeStr = WndManager.root._prop.onGetCode_data.data, writeCookie("yscdk", WndManager.root._prop.onGetCode_data.data, 88888), this.onShowCode()) : (WndManager.root._prop._codeStr = "888", wy.Toast.setContent("兑换码已被经领完！"), this.onShowCode("兑换码已被经领完！"), writeCookie("yscdk", "888", 88888), this.onList(!0)) : this._totalNum >= 1 ? egret.setTimeout(function () {
            WndManager.root._prop.addEventListener("onGetCode", t.onGetCode, t), WndManager.root._prop.onGetCode()
        }, this, 3e3) : wy.Toast.setContent(WndManager.root._prop.onGetCode_data.msg)
    }, t.prototype.onShowCode = function (e) {
        if (void 0 === e && (e = "1"), null != this._txt && (this._txt.parent.removeChild(this._txt), this._txt = null), "1" != e) {
            var t = MyUtils.createBitmapByName("code_fall_png");
            t.anchorOffsetX = t.width / 2, t.anchorOffsetY = t.height / 2, t.x = 375, t.y = 724, t.touchEnabled = !1, this.addChild(t)
        } else {
            this._code_frame = MyUtils.createImageByName("code_frame_png", 613, 468, 72, 474), this.addChild(this._code_frame);
            var i = GetTextField.createTextField(307, 60, 26, 16777215, "兑换码：" + WndManager.root._prop._codeStr);
            i.x = 160, i.y = 806, this.addChild(i), this._code_copyBtn = MyUtils.createImageByName("code_copyBtn_png", 110, 60, 480, 806, "c_c"), this.addChild(this._code_copyBtn)
        }
        this.onList(!0)
    }, t.prototype.onList = function (e) {
        e ? (this._bg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onRemoveTap, this), null != this._code_copyBtn && this._code_copyBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onCopyTap, this)) : (this._bg.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onRemoveTap, this), null != this._code_copyBtn && this._code_copyBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onCopyTap, this))
    }, t.prototype.onCopyTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            t.onList(!0)
        }, this);
        var i = document.createElement("input");
        i.value = WndManager.root._prop._codeStr, document.body.appendChild(i), i.select(), i.setSelectionRange(0, i.value.length), document.execCommand("Copy"), document.body.removeChild(i), wy.Toast.setContent("已复制兑换码")
    }, t.prototype.onRemoveTap = function (e) {
        this.onList(!1), this.dispatchEvent(new egret.Event("onAddPosterImg")), this.parent.removeChild(this)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(CodeSp.prototype, "CodeSp");
var ComLuweiSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._cluwei7 = null, t._cluwei6 = null, t._lluwei4 = null, t._cluwei5 = null, t._cluwei4 = null, t._cluwei1 = null, t._lluwei3 = null, t._cluwei0 = null, t._rluwei6 = null, t._lluwei2 = null, t._lluwei1 = null, t._lluwei0 = null, t._rluwei5 = null, t._rluwei4 = null, t._rluwei3 = null, t._rluwei2 = null, t._rluwei1 = null, t._rluwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddComLuwei = function () {
        this._cluwei7 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei7.png", 52, 78, 136, 156, "c_c"), this.addChild(this._cluwei7), this._cluwei6 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei6.png", 35, 71, 133, 164, "c_c"), this.addChild(this._cluwei6), this._lluwei4 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/lluwei4.png", 92, 109, 103, 122, "l_c"), this.addChild(this._lluwei4), this._cluwei5 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei5.png", 31, 65, 108, 128, "c_c"), this.addChild(this._cluwei5), this._cluwei4 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei4.png", 29, 68, 98, 137, "c_c"), this.addChild(this._cluwei4), this._cluwei1 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei1.png", 27, 61, 97, 164, "c_c"), this.addChild(this._cluwei1), this._lluwei3 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/lluwei3.png", 49, 68, 76, 157, "l_c"), this.addChild(this._lluwei3), this._cluwei0 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/cluwei0.png", 24, 84, 78, 165, "c_c"), this.addChild(this._cluwei0), this._rluwei6 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei6.png", 83, 128, 12, 135, "r_c"), this.addChild(this._rluwei6), this._lluwei2 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/lluwei2.png", 79, 139, 56, 52, "l_c"), this.addChild(this._lluwei2), this._lluwei1 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/lluwei1.png", 81, 155, 0, 0, "l_c"), this.addChild(this._lluwei1), this._lluwei0 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/lluwei0.png", 75, 81, 0, 83, "l_c"), this.addChild(this._lluwei0), this._rluwei5 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei5.png", 231, 199, 400, 163, "r_c"), this.addChild(this._rluwei5), this._rluwei4 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei4.png", 189, 271, 413, 113, "r_c"), this.addChild(this._rluwei4), this._rluwei3 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei3.png", 139, 190, 611, 172, "r_c"), this.addChild(this._rluwei3), this._rluwei2 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei2.png", 178, 212, 552, 150, "r_c"), this.addChild(this._rluwei2), this._rluwei1 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei1.png", 193, 135, 371, 249, "r_c"), this.addChild(this._rluwei1), this._rluwei0 = MyUtils.createImageByNameUrl("resource/begin/ComLuweiSp/rluwei0.png", 160, 247, 520, 115, "r_c"), this.addChild(this._rluwei0), this._arr = [];
        var e;
        for (e = 0; 7 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_rluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_rluwei" + e])
        }
        for (e = 0; 8 > e; e++)
            if (3 !== e && 2 != e) {
                var t = 5 * Math.random() + 3;
                egret.Tween.get(this["_cluwei" + e], {
                    loop: !0
                }).to({
                    rotation: t
                }, 700 + Math.floor(100 * t)).to({
                    rotation: 0
                }, 700 + Math.floor(100 * t)), this._arr.push(this["_cluwei" + e])
            } for (e = 0; 5 > e; e++)
            if (6 != e) {
                var t = 5 * Math.random() + 3;
                egret.Tween.get(this["_lluwei" + e], {
                    loop: !0
                }).to({
                    rotation: t
                }, 700 + Math.floor(100 * t)).to({
                    rotation: 0
                }, 700 + Math.floor(100 * t)), this._arr.push(this["_lluwei" + e])
            }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(ComLuweiSp.prototype, "ComLuweiSp");
var ComPlayBtnSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._comPlay_bg = null, t._nameSp = null, t._comPlay_name1 = null, t._comPlay_name2 = null, t._nameMask = null, t._comPlay_stopBtn = null, t._comPlay_playBtn = null, t._id = 0, t
    }
    return __extends(t, e), t.prototype.onAddComPlayBtn = function (e) {
        this._id = e, this._comPlay_bg = MyUtils.createImageByName("comPlay_bg" + this._id + "_png", 613, 121, 0, 0), this.addChild(this._comPlay_bg), this._nameSp = new egret.DisplayObjectContainer, this._nameSp.touchEnabled = !1, this.addChild(this._nameSp), this._comPlay_name1 = MyUtils.createBitmapByName("comPlay_name" + this._id + "_png", 161, 79, 126, 23), this._comPlay_name1.touchEnabled = !1, this._nameSp.addChild(this._comPlay_name1), this._comPlay_name2 = MyUtils.createBitmapByName("comPlay_name" + this._id + "_png", 161, 79, 590, 23), this._comPlay_name2.touchEnabled = !1, this._nameSp.addChild(this._comPlay_name2), this._nameMask = DrawGraphics.onDrawGraphicsSquare(125, 0, 464, 121, 16777215, 1, !1), this.addChild(this._nameMask), this._nameSp.mask = this._nameMask, this._comPlay_stopBtn = MyUtils.createImageByName("comPlay_stopBtn_png", 117, 116, 32, 3, "c_c"), this._comPlay_stopBtn.visible = !1, this._comPlay_stopBtn.touchEnabled = !1, this.addChild(this._comPlay_stopBtn), this._comPlay_playBtn = MyUtils.createImageByName("comPlay_playBtn_png", 87, 94, 44, 15, "c_c"), this._comPlay_playBtn.touchEnabled = !1, this.addChild(this._comPlay_playBtn)
    }, t.prototype.onPlayHandler = function () {
        this._comPlay_stopBtn.visible = !0, this._comPlay_playBtn.visible = !1, egret.startTick(this.onStartPlay, this)
    }, t.prototype.onStopHandler = function () {
        this._comPlay_stopBtn.visible = !1, this._comPlay_playBtn.visible = !0, egret.stopTick(this.onStartPlay, this), this._comPlay_name1.x = 126, this._comPlay_name2.x = 590
    }, t.prototype.onStartPlay = function (e) {
        return this._comPlay_name1.x -= 2, this._comPlay_name2.x -= 2, this._comPlay_name1.x < -338 && (this._comPlay_name1.x = 590), this._comPlay_name2.x < -338 && (this._comPlay_name2.x = 590), !1
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(ComPlayBtnSp.prototype, "ComPlayBtnSp");
var ComPlaySp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._playBtnArr = null, t._comRecordSp = null, t._playId = 0, t
    }
    return __extends(t, e), t.prototype.onAddComPlay = function () {
        this._playBtnArr = [];
        for (var e = 1; 5 >= e; e++) {
            var t = new ComPlayBtnSp;
            t.onAddComPlayBtn(e), t.y = 140 * (e - 1), this.addChild(t), this._playBtnArr.push(t)
        }
        this._comRecordSp = new ComRecordSp, this._comRecordSp.onAddComRecord(), this._comRecordSp.y = 121, this.addChild(this._comRecordSp), this._playId = 1;
        var i = document.getElementById("bgMusic");
        i.src = config_json._bgmUrl + "resource/sound/bgm" + this._playId + ".mp3?v=" + versions, i.currentTime = 0, WndManager.root._buttonEff.onMusic_play(), this.onArrange(), this._playBtnArr[0].onPlayHandler()
    }, t.prototype.onList = function (e) {
        var t;
        if (e)
            for (t = 0; t < this._playBtnArr.length; t++) this._playBtnArr[t]._comPlay_bg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlayMusic, this);
        else
            for (t = 0; t < this._playBtnArr.length; t++) this._playBtnArr[t]._comPlay_bg.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onPlayMusic, this)
    }, t.prototype.onPlayMusic = function (e) {
        var t = this;
        if (this._playId != e.currentTarget.parent._id) {
            this.onList(!1), this._playId = e.currentTarget.parent._id;
            for (var i = 0; i < this._playBtnArr.length; i++) this._playBtnArr[i].onStopHandler();
            egret.Tween.get(this._comRecordSp).to({
                alpha: 0
            }, 200).call(function () {
                for (var e = 0; e < t._playBtnArr.length; e++) e >= t._playBtnArr.length - 1 ? egret.Tween.get(t._playBtnArr[e]).to({
                    y: 140 * e
                }, 200).call(t.onArrange, t) : egret.Tween.get(t._playBtnArr[e]).to({
                    y: 140 * e
                }, 200), e + 1 == t._playId && t._playBtnArr[e].onPlayHandler()
            });
            var n = document.getElementById("bgMusic");
            n.src = config_json._bgmUrl + "resource/sound/bgm" + this._playId + ".mp3?v=" + versions, n.currentTime = 0, WndManager.root._buttonEff.onMusic_play(), onBiLogClick("ComPage", "music" + this._playId + "play", ""), onAddEvent("ComPage", "music" + this._playId, "play")
        }
    }, t.prototype.onArrange = function () {
        var e = this;
        this._comRecordSp.onChange(this._playId), this._comRecordSp.y = 140 * (this._playId - 1) + 121;
        for (var t = 0; t < this._playBtnArr.length; t++) egret.Tween.removeTweens(this._playBtnArr[t]), t >= this._playId ? egret.Tween.get(this._playBtnArr[t]).to({
            y: 140 * t + 410
        }, 200) : egret.Tween.get(this._playBtnArr[t]).to({
            y: 140 * t
        }, 200);
        egret.Tween.get(this._comRecordSp).to({
            alpha: 1
        }, 200).call(function () {
            e.onList(!0)
        }, this)
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._playBtnArr.length; e++) this._playBtnArr[e].onStopHandler(), this._playBtnArr[e].parent.removeChild(this._playBtnArr[e]), this._playBtnArr[e] = null;
        this._playBtnArr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(ComPlaySp.prototype, "ComPlaySp");
var ComRecordSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._comRecord_frame = null, t._comRecord_record = null, t._comRecord_head = null, t._comRecord_photo = null, t._musicPhoto = null, t
    }
    return __extends(t, e), t.prototype.onAddComRecord = function () {
        this._comRecord_frame = MyUtils.createImageByName("comRecord_frame_png", 623, 410, 0, 0), this.addChild(this._comRecord_frame), this._comRecord_record = MyUtils.createImageByName("comRecord_record_png", 407, 406, 279, 12, "c_c"), this.addChild(this._comRecord_record), egret.Tween.get(this._comRecord_record, {
            loop: !0
        }).to({
            rotation: 360
        }, 1e4), this._comRecord_head = MyUtils.createImageByName("comRecord_head_png", 51, 194, 350, 1), this.addChild(this._comRecord_head), this._comRecord_photo = MyUtils.createImageByName("comRecord_photo_png", 332, 321, 0, 53), this.addChild(this._comRecord_photo)
    }, t.prototype.onChange = function (e) {
        null != this._musicPhoto && (this._musicPhoto.parent.removeChild(this._musicPhoto), this._musicPhoto = null), this._musicPhoto = new MusicPhotoSp, this._musicPhoto.onAddMusicPhoto(e), this._musicPhoto.scaleX = this._musicPhoto.scaleY = .65, this._musicPhoto.x = 130, this._musicPhoto.y = 231, this.addChild(this._musicPhoto)
    }, t.prototype.onRemove = function () {
        this._comRecord_record && (egret.Tween.removeTweens(this._comRecord_record), this._comRecord_record.parent.removeChild(this._comRecord_record), this._comRecord_record = null)
    }, t
}(egret.DisplayObjectContainer);
__reflect(ComRecordSp.prototype, "ComRecordSp");
var ComTransitionWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._transition_bg = null, t._transition_bg1 = null, t._transition_info0 = null, t._transition_info1 = null, t._transition_info2 = null, t._transition_info3 = null, t._transition_nextBtn = null, t._transition_nextBtn2 = null, t._loading_logo = null, t._transition_hd = null, t._infoTxt = null, t._totalNum = 0, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        this._transition_bg = MyUtils.createImageByName("transition_bg_png", 750, 1448, 0, 0), this.addChild(this._transition_bg), this._transition_bg1 = MyUtils.createImageByName("transition_bg1_png", 750, 1448, 0, 0), this.addChild(this._transition_bg1), egret.Tween.get(this._transition_bg1, {
            loop: !0
        }).to({
            alpha: .5
        }, 1e3).to({
            alpha: 1
        }, 1e3), this._infoTxt = GetTextField.createTextField(750, 80, 26, 16777215, "正在汇聚鸣神之土的声音...\n0%"), this._infoTxt.lineSpacing = 20, this._infoTxt.y = 684, this.addChild(this._infoTxt), this._transition_hd = new LoadingHudieMovieSp, this._transition_hd.addRole(), this._transition_hd.x = 200, this._transition_hd.y = 1095, this._transition_hd.onPlay(), this.addChild(this._transition_hd), egret.Tween.get(this._transition_hd, {
            loop: !0
        }).to({
            y: 1075
        }, 1e3).to({
            y: 1095
        }, 1e3), this._loading_logo = MyUtils.createImageByName("loading_logo_png", 400, 58, 22, 127), this.addChild(this._loading_logo), egret.startTick(this.onTxtEvent, this)
    }, t.prototype.onTxtEvent = function (e) {
        return this._totalNum++, this._infoTxt.text = "正在汇聚鸣神之土的声音...\n" + this._totalNum + "%", this._totalNum >= 100 && (WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(ComWnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), egret.stopTick(this.onTxtEvent, this)), !1
    }, t.prototype.Destroy = function () {
        null != this._transition_hd && (this._transition_hd.onStop(), this._transition_hd.parent.removeChild(this._transition_hd)), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(ComTransitionWnd.prototype, "ComTransitionWnd");
var ComWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._com_bg1 = null, t._com_bg0 = null, t._com_huaban2 = null, t._com_lig = null, t._com_huaban0 = null, t._comLuweiSp = null, t._com_luweiMask = null, t._com_label = null, t._com_recoreframe = null, t._com_recoreInfo = null, t._com_recoreImg = null, t._com_getBtn = null, t._com_shareBtn = null, t._com_newBtn = null, t._com_logo = null, t._music_returnBtn = null, t._comPlaySp = null, t._gameDiv = null, t._myImg = null, t.create("com"), t
    }
    return __extends(t, e), t.prototype.createOk = function () {
        this._music_returnBtn = MyUtils.createImageByName("return_page_png", 190, 60, 0, WndManager.root._upDot), this._music_returnBtn.alpha = 0, this.addChild(this._music_returnBtn), this._scrollCon = new egret.DisplayObjectContainer, this._myscrollView = new egret.ScrollView, this._myscrollView.setContent(this._scrollCon), this._myscrollView.width = 750, this._myscrollView.height = WndManager.root.stage.stageHeight, this._myscrollView.scrollSpeed = .3, this._myscrollView.horizontalScrollPolicy = "off", this._myscrollView.y = WndManager.root._upDot, this._myscrollView.bounces = !1, this.addChild(this._myscrollView), this._com_bg1 = MyUtils.createImageByName("com_bg1_jpg", 750, 1129, 0, 1515), this._scrollCon.addChild(this._com_bg1), this._com_bg0 = MyUtils.createImageByName("com_bg0_jpg", 750, 1517, 0, 0), this._scrollCon.addChild(this._com_bg0), this._com_lig = MyUtils.createImageByName("com_lig_png", 15, 314, 735, 803), this._scrollCon.addChild(this._com_lig), egret.Tween.get(this._com_lig, {
            loop: !0
        }).to({
            alpha: 0
        }, 500).to({
            alpha: 1
        }, 500), this._com_huaban0 = MyUtils.createImageByName("com_huaban0_png", 652, 294, 47, 86), this._scrollCon.addChild(this._com_huaban0), egret.Tween.get(this._com_huaban0, {
            loop: !0
        }).to({
            y: 106
        }, 2e3).to({
            y: 86
        }, 2e3), this._comLuweiSp = new ComLuweiSp, this._comLuweiSp.onAddComLuwei(), this._comLuweiSp.y = 2261, this._scrollCon.addChild(this._comLuweiSp), this._com_luweiMask = MyUtils.createImageByName("com_luweiMask_png", 750, 499, 0, 2145), this._scrollCon.addChild(this._com_luweiMask), this._com_label = MyUtils.createImageByName("com_label_png", 620, 251, 66, 98), this._scrollCon.addChild(this._com_label), this._comPlaySp = new ComPlaySp, this._comPlaySp.onAddComPlay(), this._comPlaySp.x = 59, this._comPlaySp.y = 413, this._scrollCon.addChild(this._comPlaySp), this._com_recoreframe = MyUtils.createImageByName("com_recoreframe_png", 613, 455, 64, 1571), this._scrollCon.addChild(this._com_recoreframe), this._com_recoreInfo = MyUtils.createImageByName("com_recoreInfo_png", 523, 26, 108, 1959), this._scrollCon.addChild(this._com_recoreInfo), this._com_recoreImg = MyUtils.createImageByName("com_recoreImg_png", 409, 323, 182, 1606), this._com_recoreImg.touchEnabled = !0, this._scrollCon.addChild(this._com_recoreImg), this._com_getBtn = MyUtils.createImageByName("com_getBtn_png", 364, 89, 193, 2084, "c_c"), this._scrollCon.addChild(this._com_getBtn), this._com_shareBtn = MyUtils.createImageByName("com_shareBtn_png", 232, 73, 112, 2232, "c_c"), this._scrollCon.addChild(this._com_shareBtn), this._com_newBtn = MyUtils.createImageByName("com_newBtn_png", 232, 73, 416, 2232, "c_c"), this._scrollCon.addChild(this._com_newBtn), this._com_logo = MyUtils.createBitmapByName("com_logo_png"), this._com_logo.anchorOffsetX = this._com_logo.width / 2, this._com_logo.x = 375, this._com_logo.y = 2386, this._scrollCon.addChild(this._com_logo), this.onList(!0)
    }, t.prototype.onList = function (e) {
        e ? (this._com_getBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGetTap, this), this._com_shareBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onShareTap, this), this._com_newBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onNewTap, this), this._com_recoreImg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGotoUrl, this)) : (this._com_getBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGetTap, this), this._com_shareBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onShareTap, this), this._com_newBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onNewTap, this), this._com_recoreImg.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGotoUrl, this))
    }, t.prototype.onGotoUrl = function (e) {
        onAddEvent("ComPage", "CD", "ckic"), onBiLogClick("ComPage", "cdOpen", ""), WndManager.root._buttonEff.onChange_stop();
        var t = document.documentElement.clientWidth,
            i = document.documentElement.clientHeight;
        document.getElementById("wxsub").style.position = "absolute", document.getElementById("wxsub").style.top = "0%", document.getElementById("wxsub").innerHTML = '<iframe allow="camera *;microphone *;" allowfullscreen="true" border="0" frameBorder="true" src="' + config_json.cdUrl + '" width="' + t + '" height="' + i + '"></iframe>', this.addQRCodeDiv()
    }, t.prototype.onGetTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            WndManager.switchWnd(ShareWnd, WIN_OPERATOR.WIN_OPEN_NEW_UP), t.onList(!0)
        }, this)
    }, t.prototype.onShareTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            WndManager.switchWnd(PosterWnd, WIN_OPERATOR.WIN_OPEN_NEW), t.onList(!0)
        }, this)
    }, t.prototype.onNewTap = function (e) {
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            var e = document.getElementById("bgMusic");
            e.src = musicUrl, e.currentTime = 0, WndManager.root._buttonEff.onMusic_play(), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(BeginWnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA)
        }, this)
    }, t.prototype.addQRCodeDiv = function () {
        var e = this,
            t = this._music_returnBtn.width,
            i = this._music_returnBtn.height,
            n = t / 750 * 100,
            r = Math.floor(i / WndManager.root.stage.stageHeight * 100);
        this._gameDiv = document.getElementById("posterId"), this._myImg = document.createElement("img"), this._myImg.id = "img_code", this._myImg.src = config_json.clientUrl + "resource/begin/ComWnd/return_page.png", this._myImg.style.width = n + "%", this._myImg.style.height = r + "%", this._myImg.style.position = "absolute", this._myImg.style.left = String(this._music_returnBtn.x / 750 * 100) + "0%", this._myImg.style.top = String(this.onGetLocalToGlobal(this._music_returnBtn).y / WndManager.root.stage.stageHeight * 100) + "0%", this._gameDiv.appendChild(this._myImg);
        var s = this;
        this._myImg.addEventListener("click", function () {
            s.removeQRCodeDiv(), e.visible = !0, WndManager.root._buttonEff.onMusic_play()
        }, !1), this.visible = !1
    }, t.prototype.removeQRCodeDiv = function () {
        null != this._myImg && (document.getElementById("wxsub").innerHTML = "", this._gameDiv.removeChild(this._myImg), this._myImg = null, this._gameDiv = null)
    }, t.prototype.onGetLocalToGlobal = function (e) {
        var t = WndManager.root.localToGlobal(e.x, e.y);
        return t
    }, t.prototype.Destroy = function () {
        null != this._comPlaySp && (this._comPlaySp.onRemove(), this._comPlaySp.parent.removeChild(this._comPlaySp), this._comPlaySp = null), null != this._comLuweiSp && (this._comLuweiSp.onRemove(), this._comLuweiSp.parent.removeChild(this._comLuweiSp), this._comLuweiSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(ComWnd.prototype, "ComWnd");
var GatherSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._gather_lig = null, t._gather_guide = null, t._gather_txt = null, t
    }
    return __extends(t, e), t.prototype.onAddGather = function () {}, t.prototype.onAddClick = function () {
        var e = this,
            t = DrawGraphics.onDrawGraphicsSquare(-127, -76, 258, 177, 16777215, 0, !0);
        this.addChild(t), this._gather_txt = MyUtils.createImageByName("gather_txt_png", 187, 42, -105, 55), this._gather_txt.alpha = 0, this.addChild(this._gather_txt), egret.Tween.get(this._gather_txt).to({
            alpha: 1
        }, 1e3).call(function () {
            egret.Tween.get(e._gather_txt, {
                loop: !0
            }).to({
                alpha: .5
            }, 1e3).to({
                alpha: 1
            }, 1e3)
        }, this)
    }, t.prototype.onRemove = function () {
        null != this._gather_guide && egret.Tween.removeTweens(this._gather_txt)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(GatherSp.prototype, "GatherSp");
var LoadingHudieMovieSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._role = null, t._roleTimer = 0, t._frameNum = 5, t
    }
    return __extends(t, e), t.prototype.addRole = function () {
        this._roleAny = [], this._role = MyUtils.createBitmapByName("hd_json.hd0"), this._role.anchorOffsetX = this._role.width / 2, this._role.anchorOffsetY = this._role.height / 2, this.addChild(this._role);
        for (var e = 0; 8 >= e; e++) this._roleAny.push("hd_json.hd" + e)
    }, t.prototype.onPlay = function () {
        egret.startTick(this.onPlayEvent, this)
    }, t.prototype.onStop = function () {
        egret.stopTick(this.onPlayEvent, this)
    }, t.prototype.onPlayEvent = function (e) {
        this._roleTimer++;
        for (var t = 1; t <= this._roleAny.length; t++)
            if (this._roleTimer == this._frameNum * t) {
                for (var i = 0; i < this._roleAny.length; i++) i == t - 1 && (this._role.texture = RES.getRes(this._roleAny[i]));
                return t == this._roleAny.length && (this._roleTimer = 0), !1
            } return !1
    }, t
}(egret.DisplayObjectContainer);
__reflect(LoadingHudieMovieSp.prototype, "LoadingHudieMovieSp");
var MusicPhotoSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._musicPhoto0 = null, t._musicPhoto1 = null, t._musicPhoto2 = null, t._musicPhoto3 = null, t._id = 0, t
    }
    return __extends(t, e), t.prototype.onAddMusicPhoto = function (e) {
        this._id = e, this._musicPhoto3 = MyUtils.createImageByName("card_music" + this._id + "photo3_png", 442, 491, 273, 210, "c_c"), this._musicPhoto3.x = 17, this._musicPhoto3.y = -37, this._musicPhoto3.rotation = 8, this.addChild(this._musicPhoto3), egret.Tween.get(this._musicPhoto3).wait(300).to({
            rotation: 0,
            x: 131,
            y: -33
        }, 1e3, egret.Ease.quintOut), this._musicPhoto2 = MyUtils.createImageByName("card_music" + this._id + "photo2_png", 430, 480, 190, 191, "c_c"), this._musicPhoto2.x = 21, this._musicPhoto2.y = -37, this._musicPhoto2.rotation = -6, this.addChild(this._musicPhoto2), egret.Tween.get(this._musicPhoto2).wait(300).to({
            rotation: 0,
            x: 45,
            y: -57
        }, 1e3, egret.Ease.quintOut), this._musicPhoto1 = MyUtils.createImageByName("card_music" + this._id + "photo1_png", 457, 503, 35, 199, "c_c"), this._musicPhoto1.x = 18, this._musicPhoto1.y = -35, this._musicPhoto1.rotation = 10, this.addChild(this._musicPhoto1), egret.Tween.get(this._musicPhoto1).wait(300).to({
            rotation: 0,
            x: -99,
            y: -37
        }, 1e3, egret.Ease.quintOut), this._musicPhoto0 = MyUtils.createImageByName("card_music" + this._id + "photo0_png", 389, 445, 137, 228, "c_c"), this._musicPhoto0.x = 19, this._musicPhoto0.y = -37, this.addChild(this._musicPhoto0), egret.Tween.get(this._musicPhoto0).wait(300).to({
            x: -28,
            y: -37
        }, 1e3, egret.Ease.quintOut)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(MusicPhotoSp.prototype, "MusicPhotoSp");
var NpcMovieSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._role = null, t._roleTimer = 0, t._frameNum = 8, t
    }
    return __extends(t, e), t.prototype.addRole = function () {
        this._roleAny = [], this._role = MyUtils.createBitmapByName("hdf_json.hdf0"), this._role.anchorOffsetX = this._role.width / 2, this._role.anchorOffsetY = this._role.height / 2, this.addChild(this._role);
        for (var e = 0; 7 >= e; e++) this._roleAny.push("hdf_json.hdf" + e)
    }, t.prototype.onPlay = function () {
        egret.startTick(this.onPlayEvent, this)
    }, t.prototype.onStop = function () {
        egret.stopTick(this.onPlayEvent, this), this.dispatchEvent(new egret.Event("onPlayerCom"))
    }, t.prototype.onPlayEvent = function (e) {
        this._roleTimer++;
        for (var t = 1; t <= this._roleAny.length; t++)
            if (this._roleTimer == this._frameNum * t) {
                for (var i = 0; i < this._roleAny.length; i++) i == t - 1 && (this._role.texture = RES.getRes(this._roleAny[i]));
                return t == this._roleAny.length && (this._roleTimer = 0), !1
            } return !1
    }, t
}(egret.DisplayObjectContainer);
__reflect(NpcMovieSp.prototype, "NpcMovieSp");
var PosterSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._img = null, t._poster_code = null, t._mask = null, t._id = 0, t._bg = null, t
    }
    return __extends(t, e), t.prototype.onAddPoster = function (e) {
        this._id = e, this._bg = DrawGraphics.onDrawGraphicsSquare(-378, -727, 756, 1454, 7515647, 1, !1), this.addChild(this._bg), this._img = MyUtils.createBitmapByName("poster" + e + "_jpg", 750, 1448, -375, -724), this._img.x = -375, this._img.y = -724, this.addChild(this._img), this._mask = DrawGraphics.onDrawGraphicsSquare(-375, -724, 750, 1448, 0, 1, !1), this.addChild(this._mask), this._mask.alpha = .78
    }, t.prototype.onScreenshot = function () {
        onAddEvent("create", "img", "海报" + this._id), onBiLogClick("posterPage", "poster" + this._id, ""), WndManager.root.y = 0, WndManager.root._prop._texture = new egret.RenderTexture, WndManager.root._prop._texture.drawToTexture(this, new egret.Rectangle(-375, -724, 750, 1448)), WndManager.root._prop._posterBase = WndManager.root._prop._texture.toDataURL("image/png"), WndManager.root.y = -WndManager.root._upDot, console.log(WndManager.root._prop._posterBase), WndManager.root._prop.dispatchEvent(new egret.Event("onScreenshotCom"))
    }, t.prototype.onShow = function () {
        this._bg.visible = !0, egret.Tween.get(this._mask).to({
            alpha: .78
        }, 500)
    }, t.prototype.onHide = function () {
        this._bg.visible = !1, egret.Tween.get(this._mask).to({
            alpha: 0
        }, 500)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(egret.DisplayObjectContainer);
__reflect(PosterSp.prototype, "PosterSp");
var PosterWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._loading_bg = null, t._poster_okBtn = null, t._poster_getBtn = null, t._poster_nextBtn = null, t._poster_prevBtn = null, t._poster_logo = null, t._poster = null, t._posterSp = null, t._posterObj = null, t._posterDiv = null, t._posterImg = null, t._posterArr = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        var e = this;
        onAddEvent("page", "goto", "poster"), this._loading_bg = MyUtils.createImageByName("loading_bg_jpg", 750, 1448, 0, 0), this._loading_bg.touchEnabled = !0, this.addChild(this._loading_bg), this._posterSp = new egret.DisplayObjectContainer, this.addChild(this._posterSp), this._poster = MyUtils.createBitmapByName("poster1_jpg"), this._poster.width = 427, this._poster.height = 825, this._poster.x = 106, this._poster.y = 188, this._poster.alpha = 0, this.addChild(this._poster), this._poster_okBtn = MyUtils.createImageByName("poster_okBtn_png", 232, 73, 416, 1256, "c_c"), this._poster_okBtn.touchEnabled = !0, this.addChild(this._poster_okBtn), this._poster_getBtn = MyUtils.createImageByName("poster_getBtn_png", 232, 73, 125, 1256, "c_c"), this._poster_getBtn.touchEnabled = !0, this.addChild(this._poster_getBtn), this._poster_nextBtn = MyUtils.createImageByName("poster_nextBtn_png", 60, 57, 661, 698, "c_c"), this._poster_nextBtn.touchEnabled = !0, this.addChild(this._poster_nextBtn), this._poster_prevBtn = MyUtils.createImageByName("poster_prevBtn_png", 60, 57, 45, 698, "c_c"), this._poster_prevBtn.touchEnabled = !0, this.addChild(this._poster_prevBtn), this._poster_logo = MyUtils.createImageByName("poster_logo_png", 258, 63, 43, WndManager.root._upDot + 20), this.addChild(this._poster_logo), this._posterArr = [];
        for (var t = [-375, 0, 375, 750, 1125], i = 0; i < t.length; i++) {
            var n = new PosterSp;
            n.onAddPoster(i + 1), n.x = t[i], n.y = 724, n.scaleX = n.scaleY = .58, this._posterSp.addChild(n), this._posterArr.push(n)
        }
        this._posterArr[2].onHide(), this._posterArr[2].scaleX = this._posterArr[2].scaleY = .68, this._posterSp.addChild(this._posterArr[2]), egret.setTimeout(function () {
            e._posterObj = e._posterArr[2], e.onList(!0)
        }, this, 500)
    }, t.prototype.onList = function (e) {
        e ? (this._poster_okBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onSelectTap, this), this._poster_nextBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onNextTap, this), this._poster_prevBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onPrevTap, this), this._poster_getBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGetTap, this)) : (this._poster_okBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onSelectTap, this), this._poster_nextBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onNextTap, this), this._poster_prevBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onPrevTap, this), this._poster_getBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGetTap, this))
    }, t.prototype.onGetTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            WndManager.root._prop.addEventListener("onScreenshotCom", t.onScreenshotCom, t), t._posterObj.onScreenshot()
        }, this)
    }, t.prototype.onSelectTap = function (e) {
        var i = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            i.onRemovePoster(), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA)
        }, this)
    }, t.prototype.onNextTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            t.onMove("next")
        }, this)
    }, t.prototype.onPrevTap = function (e) {
        var t = this;
        this.onList(!1), egret.Tween.get(e.currentTarget).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            t.onMove("prev")
        }, this)
    }, t.prototype.onMove = function (e) {
        this._posterObj = null, this.onRemovePoster();
        var t = 0;
        if ("next" == e)
            for (t = 0; t < this._posterArr.length; t++) {
                var i = .58;
                this._posterArr[t].x > 375 && this._posterArr[t].x < 751 ? (i = .68, this._posterArr[t].onHide(), this._posterSp.addChild(this._posterArr[t]), this._posterObj = this._posterArr[t]) : this._posterArr[t].onShow(), this._posterArr[t].x <= -375 && (this._posterSp.addChildAt(this._posterArr[t], 0), this._posterArr[t].x = 1500), t >= this._posterArr.length - 1 ? egret.Tween.get(this._posterArr[t]).to({
                    scaleX: i,
                    scaleY: i,
                    x: this._posterArr[t].x - 375
                }, 500).call(this.onList, this, [!0]) : egret.Tween.get(this._posterArr[t]).to({
                    scaleX: i,
                    scaleY: i,
                    x: this._posterArr[t].x - 375
                }, 500)
            } else
                for (t = 0; t < this._posterArr.length; t++) {
                    var i = .58;
                    this._posterArr[t].x < 320 && this._posterArr[t].x > -10 ? (i = .68, this._posterArr[t].onHide(), this._posterSp.addChild(this._posterArr[t]), this._posterObj = this._posterArr[t]) : this._posterArr[t].onShow(), this._posterArr[t].x >= 1125 && (this._posterSp.addChildAt(this._posterArr[t], 0), this._posterArr[t].x = -750), t >= this._posterArr.length - 1 ? egret.Tween.get(this._posterArr[t]).to({
                        scaleX: i,
                        scaleY: i,
                        x: this._posterArr[t].x + 375
                    }, 500).call(this.onList, this, [!0]) : egret.Tween.get(this._posterArr[t]).to({
                        scaleX: i,
                        scaleY: i,
                        x: this._posterArr[t].x + 375
                    }, 500)
                }
    }, t.prototype.onScreenshotCom = function () {
        WndManager.root._prop.removeEventListener("onScreenshotCom", this.addPosterDiv, this), egret.Tween.get(this._posterObj).to({
            scaleX: 1,
            scaleY: 1
        }, 500), WndManager.root.addChild(this._posterObj), this.addPosterDiv(), this.onList(!0)
    }, t.prototype.addPosterDiv = function () {
        this._poster.width, this._poster.height;
        this._posterDiv = document.getElementById("posterId"), this._posterImg = document.createElement("img"), this._posterImg.id = "img_code", this._posterImg.src = WndManager.root._prop._posterBase, this._posterImg.style.width = "100%", this._posterImg.style.height = "100%", this._posterImg.style.position = "absolute", this._posterImg.style.left = "0%", this._posterImg.style.top = "0%", this._posterImg.style.opacity = "0", this._posterDiv.appendChild(this._posterImg);
        var e = this;
        WndManager.root._prop._endFun = function () {
            e.onRemovePoster(), e._posterSp.addChild(e._posterObj), egret.Tween.get(e._posterObj).to({
                scaleX: .68,
                scaleY: .68
            }, 500)
        }, this._posterDiv.addEventListener("click", WndManager.root._prop._endFun, !1), onSharePic(WndManager.root._prop._posterBase)
    }, t.prototype.onGetLocalToGlobal = function (e) {
        var t = e.parent.localToGlobal(e.x, e.y);
        return t
    }, t.prototype.onRemovePoster = function () {
        null != this._posterImg && (this._posterDiv.removeChild(this._posterImg), this._posterImg = null, this._posterDiv = null)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(PosterWnd.prototype, "PosterWnd");
var RainMovieSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._role = null, t._roleTimer = 0, t._frameNum = 5, t
    }
    return __extends(t, e), t.prototype.addRole = function () {
        this._roleAny = [], this._role = MyUtils.createBitmapByName("scene_rain0_png"), this.addChild(this._role);
        for (var e = 0; 2 >= e; e++) this._roleAny.push("scene_rain" + e + "_png")
    }, t.prototype.onPlay = function () {
        egret.startTick(this.onPlayEvent, this)
    }, t.prototype.onStop = function () {
        egret.stopTick(this.onPlayEvent, this), this.dispatchEvent(new egret.Event("onPlayerCom"))
    }, t.prototype.onPlayEvent = function (e) {
        this._roleTimer++;
        for (var t = 1; t <= this._roleAny.length; t++)
            if (this._roleTimer == this._frameNum * t) {
                for (var i = 0; i < this._roleAny.length; i++) i == t - 1 && (this._role.texture = RES.getRes(this._roleAny[i]));
                return t == this._roleAny.length && (this._roleTimer = 0), !1
            } return !1
    }, t
}(egret.DisplayObjectContainer);
__reflect(RainMovieSp.prototype, "RainMovieSp");
var Scene1hua1Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene1_hua13 = null, t._scene1_hua12 = null, t._scene1_hua11 = null, t._scene1_hua10 = null, t._scene1_hua9 = null, t._scene1_hua8 = null, t._scene1_hua7 = null, t._scene1_hua6 = null, t._scene1_hua5 = null, t._scene1_hua4 = null, t._scene1_hua3 = null, t._scene1_hua2 = null, t._scene1_hua1 = null, t._scene1_hua0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddScene1hua1 = function () {
        this._scene1_hua13 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua13.png", 55, 149, 0, 0, "l_d"), this.addChild(this._scene1_hua13), this._scene1_hua12 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua12.png", 75, 144, 35.9999999999999, 38, "l_d"), this.addChild(this._scene1_hua12), this._scene1_hua11 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua11.png", 106, 115, 51.9999999999999, 68, "l_d"), this.addChild(this._scene1_hua11), this._scene1_hua10 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua10.png", 54, 75, 131, 108, "c_d"), this.addChild(this._scene1_hua10), this._scene1_hua9 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua9.png", 55, 105, 165, 78, "c_d"), this.addChild(this._scene1_hua9), this._scene1_hua8 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua8.png", 91, 117, 218, 66, "l_d"), this.addChild(this._scene1_hua8), this._scene1_hua7 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua7.png", 54, 87, 276, 96, "c_d"), this.addChild(this._scene1_hua7), this._scene1_hua6 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua6.png", 91, 122, 318, 61, "l_d"), this.addChild(this._scene1_hua6), this._scene1_hua5 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua5.png", 81, 83, 370, 100, "l_d"), this.addChild(this._scene1_hua5), this._scene1_hua4 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua4.png", 60, 111, 442, 72, "r_d"), this.addChild(this._scene1_hua4), this._scene1_hua3 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua3.png", 73, 106, 516, 77, "r_d"), this.addChild(this._scene1_hua3), this._scene1_hua2 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua2.png", 75, 144, 518, 30, "r_d"), this.addChild(this._scene1_hua2), this._scene1_hua1 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua1.png", 54, 149, 570, 8, "l_d"), this.addChild(this._scene1_hua1), this._scene1_hua0 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua1Sp/scene1_hua0.png", 74, 116, 587, 67, "l_d"), this.addChild(this._scene1_hua0), this._arr = [];
        for (var e = 0; 13 >= e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_scene1_hua" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_scene1_hua" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene1hua1Sp.prototype, "Scene1hua1Sp");
var Scene1hua2Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene1_hua8 = null, t._scene1_hua7 = null, t._scene1_hua6 = null, t._scene1_hua5 = null, t._scene1_hua4 = null, t._scene1_hua3 = null, t._scene1_hua2 = null, t._scene1_hua1 = null, t._scene1_hua0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddScene1hua2 = function () {
        this._scene1_hua8 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua8.png", 94, 111, 0, 12, "l_d"), this.addChild(this._scene1_hua8), this._scene1_hua7 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua7.png", 50, 79, 67, 46, "c_d"), this.addChild(this._scene1_hua7), this._scene1_hua6 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua6.png", 51, 104, 96.0000000000001, 21, "c_d"), this.addChild(this._scene1_hua6), this._scene1_hua5 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua5.png", 50, 89, 190, 36, "r_d"), this.addChild(this._scene1_hua5), this._scene1_hua4 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua4.png", 82, 119, 225, 6, "l_d"), this.addChild(this._scene1_hua4), this._scene1_hua3 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua3.png", 73, 86, 269, 39, "l_d"), this.addChild(this._scene1_hua3), this._scene1_hua2 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua2.png", 56, 109, 329, 16, "r_d"), this.addChild(this._scene1_hua2), this._scene1_hua1 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua1.png", 51, 130, 394, 0, "l_d"), this.addChild(this._scene1_hua1), this._scene1_hua0 = MyUtils.createImageByNameUrl("resource/begin/Scene1hua2Sp/scene1_hua0.png", 67, 100, 409, 49, "l_d"), this.addChild(this._scene1_hua0), this._arr = [];
        for (var e = 0; 8 >= e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_scene1_hua" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_scene1_hua" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene1hua2Sp.prototype, "Scene1hua2Sp");
var Scene1Wnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene1_bg0 = null, t._scene1_star = null, t._scene1_bg1 = null, t._scene1_cao = null, t._scene1_bg2 = null, t._scene1hua2Sp = null, t._scene1_bg3 = null, t._scene1hua1Sp = null, t._scene1_bg4 = null, t._cardSp = null, t._gatherSp = null, t._gatherX = 0, t._gatherY = 0, t._currentIndex = 0, t._showIndex = 0, t._npcMovieSp = null, t._data = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        this._scene1_bg0 = MyUtils.createImageByName("scene1_bg0_jpg", 750, 1448, 0, 0), this.addChild(this._scene1_bg0), this._scene1_star = MyUtils.createImageByName("scene1_star_png", 750, 509, 0, 680), this.addChild(this._scene1_star), egret.Tween.get(this._scene1_star, {
            loop: !0
        }).to({
            alpha: .2
        }, 500).to({
            alpha: 1
        }, 500), this._scene1_bg1 = MyUtils.createImageByName("scene1_bg1_png", 750, 1416, 0, 0), this.addChild(this._scene1_bg1), this._scene1_cao = MyUtils.createImageByName("scene1_cao_png", 587, 178, 94, 960), this.addChild(this._scene1_cao), egret.Tween.get(this._scene1_cao, {
            loop: !0
        }).to({
            alpha: .5
        }, 1100).to({
            alpha: 1
        }, 1100), this._scene1_bg2 = MyUtils.createImageByName("scene1_bg2_png", 750, 1448, 0, 0), this.addChild(this._scene1_bg2), this._scene1hua2Sp = new Scene1hua2Sp, this._scene1hua2Sp.onAddScene1hua2(), this._scene1hua2Sp.x = 140, this._scene1hua2Sp.y = 1299, this.addChild(this._scene1hua2Sp), this._scene1_bg3 = MyUtils.createImageByName("scene1_bg3_png", 749, 965, 1, 483), this.addChild(this._scene1_bg3), this._scene1hua1Sp = new Scene1hua1Sp, this._scene1hua1Sp.onAddScene1hua1(), this._scene1hua1Sp.x = 43, this._scene1hua1Sp.y = 1262, this.addChild(this._scene1hua1Sp), this._scene1_bg4 = MyUtils.createImageByName("scene1_bg4_png", 750, 1448, 0, 0), this.addChild(this._scene1_bg4), this._currentIndex = 0, this._showIndex = 0, this._data = config_json.scene1data, this._npcMovieSp = new NpcMovieSp, this._npcMovieSp.addRole(), this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp._frameNum = 10, this._npcMovieSp.onPlay(), this.addChild(this._npcMovieSp), this._npcMovieSp.touchEnabled = !1, this._gatherSp = new GatherSp, this._gatherSp.onAddGather(), this._gatherSp.x = this._data[305].x, this._gatherSp.y = this._data[305].y, this.addChild(this._gatherSp), egret.startTick(this.onMoveEvent, this), this._gatherSp.touchEnabled = !0, this._gatherSp.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this)
    }, t.prototype.onGatherTap = function (e) {
        void 0 === e && (e = null), null != this._gatherSp && (onAddEvent("clickEvent", "gather", "skip1"), this._gatherX = this._gatherSp.x, this._gatherY = this._gatherSp.y, this._gatherSp.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._gatherSp.onRemove(), this._gatherSp.parent.removeChild(this._gatherSp), this._gatherSp = null), this.onOpenWnd()
    }, t.prototype.onOpenWnd = function () {
        console.log("打开弹窗"), null == this._cardSp && (this._cardSp = new CardSp, this._cardSp.onAddCard(1, this._gatherX, this._gatherY), this._cardSp.alpha = 0, WndManager.root.addChild(this._cardSp), egret.Tween.get(this._cardSp).to({
            alpha: 1
        }, 500), this._cardSp.addEventListener("onNextScene", this.onNextScene, this))
    }, t.prototype.onNextScene = function (e) {
        this._cardSp.removeEventListener("onNextScene", this.onNextScene, this), WndManager.root._newPetals.stop(), egret.Tween.get(WndManager.root._newPetals).to({
            alpha: 0
        }, 500).call(function () {
            WndManager.root._newPetals.parent.removeChild(WndManager.root._newPetals), WndManager.root._newPetals = null
        }, WndManager.root), egret.Tween.removeTweens(this._npcMovieSp), this._npcMovieSp.onStop(), this._npcMovieSp._roleTimer = 0, this._npcMovieSp._frameNum = 8, this._npcMovieSp.onPlay(), egret.startTick(this.onNextEvent, this)
    }, t.prototype.onMoveEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 1)) {
            if (this._showIndex++, this._showIndex >= 305) return null != this._gatherSp && this._gatherSp.onAddClick(), egret.stopTick(this.onMoveEvent, this), egret.Tween.get(this._npcMovieSp, {
                loop: !0
            }).to({
                y: this._npcMovieSp.y - 15
            }, 1e3).to({
                y: this._npcMovieSp.y
            }, 1e3), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.onNextEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 2)) {
            if (this._showIndex++, this._showIndex >= this._data.length) return egret.stopTick(this.onNextEvent, this), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(Scene2Wnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.Destroy = function () {
        null != this._npcMovieSp && (egret.stopTick(this.onMoveEvent, this), this._npcMovieSp.onStop(), this._npcMovieSp.parent.removeChild(this._npcMovieSp), this._npcMovieSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(Scene1Wnd.prototype, "Scene1Wnd");
var Scene2Wnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene2_bg = null, t._scene2_weather0 = null, t._scene2_weather1 = null, t._scene2_star1 = null, t._scene2_cloud0 = null, t._scene2_cloud2 = null, t._scene2_cloud3 = null, t._scene2_cloud4 = null, t._scene2_cloud5 = null, t._scene2_cloud6 = null, t._scene2_bg1 = null, t._scene2_lig = null, t._scene2_star2 = null, t._scene2_bg2 = null, t._cardSp = null, t._gatherSp = null, t._gatherX = 0, t._gatherY = 0, t._currentIndex = 0, t._showIndex = 0, t._npcMovieSp = null, t._data = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        this._scene2_bg = MyUtils.createImageByName("scene2_bg_png", 750, 1448, 0, 0), this.addChild(this._scene2_bg), this._scene2_weather0 = MyUtils.createImageByName("scene2_weather0_png", 750, 775, 0, 0), this.addChild(this._scene2_weather0), egret.Tween.get(this._scene2_weather0, {
            loop: !0
        }).to({
            alpha: .5
        }, 2e3).to({
            alpha: 1
        }, 2e3), this._scene2_weather1 = MyUtils.createImageByName("scene2_weather1_png", 750, 483, 0, 0), this.addChild(this._scene2_weather1), egret.Tween.get(this._scene2_weather1, {
            loop: !0
        }).to({
            alpha: .5
        }, 1500).to({
            alpha: 1
        }, 1500), this._scene2_star1 = MyUtils.createImageByName("scene2_star1_png", 467, 502, 96, 60), this.addChild(this._scene2_star1), egret.Tween.get(this._scene2_star1, {
            loop: !0
        }).to({
            alpha: .3
        }, 1e3).to({
            alpha: 1
        }, 1e3), this._scene2_cloud0 = MyUtils.createImageByName("scene2_cloud0_png", 635, 605, 115, 367), this.addChild(this._scene2_cloud0), egret.Tween.get(this._scene2_cloud0, {
            loop: !0
        }).to({
            x: 135
        }, 2e3).to({
            x: 115
        }, 2e3), this._scene2_cloud2 = MyUtils.createImageByName("scene2_cloud2_png", 750, 284, 0, 0, "c_c"), this.addChild(this._scene2_cloud2), egret.Tween.get(this._scene2_cloud2, {
            loop: !0
        }).to({
            scaleX: 1.1
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene2_cloud3 = MyUtils.createImageByName("scene2_cloud3_png", 750, 1031, 0, 66.0000000000002), this.addChild(this._scene2_cloud3), egret.Tween.get(this._scene2_cloud3, {
            loop: !0
        }).to({
            x: 10
        }, 2e3).to({
            x: 0
        }, 2e3), this._scene2_cloud4 = MyUtils.createImageByName("scene2_cloud4_png", 344, 220, 0, 217), this.addChild(this._scene2_cloud4), egret.Tween.get(this._scene2_cloud4, {
            loop: !0
        }).to({
            x: -15
        }, 2e3).to({
            x: 0
        }, 2e3), this._scene2_cloud5 = MyUtils.createImageByName("scene2_cloud5_png", 517, 755, 233, 0), this.addChild(this._scene2_cloud5), egret.Tween.get(this._scene2_cloud5, {
            loop: !0
        }).to({
            x: 248
        }, 2e3).to({
            x: 233
        }, 2e3), this._scene2_cloud6 = MyUtils.createImageByName("scene2_cloud6_png", 487, 181, 0, 0), this.addChild(this._scene2_cloud6), egret.Tween.get(this._scene2_cloud6, {
            loop: !0
        }).to({
            x: -20
        }, 2e3).to({
            x: 0
        }, 2e3), this._scene2_bg1 = MyUtils.createImageByName("scene2_bg1_png", 750, 1137, 0, 311), this.addChild(this._scene2_bg1), this._scene2_lig = MyUtils.createImageByName("scene2_lig_png", 625, 570, 31.9999999999999, 641), this.addChild(this._scene2_lig), egret.Tween.get(this._scene2_lig, {
            loop: !0
        }).to({
            alpha: .3
        }, 1e3).to({
            alpha: 1
        }, 1e3), this._scene2_star2 = MyUtils.createImageByName("scene2_star2_png", 397, 511, 156, 925), this.addChild(this._scene2_star2), egret.Tween.get(this._scene2_star2, {
            loop: !0
        }).to({
            alpha: .2
        }, 500).to({
            alpha: 1
        }, 500), this._currentIndex = 0, this._showIndex = 0, this._data = config_json.scene2data, this._npcMovieSp = new NpcMovieSp, this._npcMovieSp.addRole(), this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp._frameNum = 10, this._npcMovieSp.onPlay(), this.addChild(this._npcMovieSp), this._npcMovieSp.touchEnabled = !1, this._gatherSp = new GatherSp, this._gatherSp.onAddGather(), this._gatherSp.x = this._data[305].x, this._gatherSp.y = this._data[305].y, this.addChild(this._gatherSp), egret.startTick(this.onMoveEvent, this), this._gatherSp.touchEnabled = !0, this._gatherSp.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._scene2_bg2 = MyUtils.createImageByName("scene2_bg2_png", 750, 1050, 0, 398), this._scene2_bg2.touchEnabled = !1, this.addChild(this._scene2_bg2)
    }, t.prototype.onGatherTap = function (e) {
        void 0 === e && (e = null), null != this._gatherSp && (onAddEvent("clickEvent", "gather", "skip1"), this._gatherX = this._gatherSp.x, this._gatherY = this._gatherSp.y, this._gatherSp.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._gatherSp.onRemove(), this._gatherSp.parent.removeChild(this._gatherSp), this._gatherSp = null), this.onOpenWnd()
    }, t.prototype.onOpenWnd = function () {
        console.log("打开弹窗"), null == this._cardSp && (this._cardSp = new CardSp, this._cardSp.onAddCard(2, this._gatherX, this._gatherY), this._cardSp.alpha = 0, WndManager.root.addChild(this._cardSp), egret.Tween.get(this._cardSp).to({
            alpha: 1
        }, 500), this._cardSp.addEventListener("onNextScene", this.onNextScene, this))
    }, t.prototype.onNextScene = function (e) {
        this._cardSp.removeEventListener("onNextScene", this.onNextScene, this), egret.Tween.removeTweens(this._npcMovieSp), this._npcMovieSp.onStop(), this._npcMovieSp._roleTimer = 0, this._npcMovieSp._frameNum = 8, this._npcMovieSp.onPlay(), egret.startTick(this.onNextEvent, this)
    }, t.prototype.onMoveEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 1)) {
            if (this._showIndex++, this._showIndex >= 305) return null != this._gatherSp && this._gatherSp.onAddClick(), egret.stopTick(this.onMoveEvent, this), egret.Tween.get(this._npcMovieSp, {
                loop: !0
            }).to({
                y: this._npcMovieSp.y - 15
            }, 1e3).to({
                y: this._npcMovieSp.y
            }, 1e3), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.onNextEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 2)) {
            if (this._showIndex++, this._showIndex >= this._data.length) return egret.stopTick(this.onNextEvent, this), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(Scene3Wnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.Destroy = function () {
        null != this._npcMovieSp && (egret.stopTick(this.onMoveEvent, this), this._npcMovieSp.onStop(), this._npcMovieSp.parent.removeChild(this._npcMovieSp), this._npcMovieSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(Scene2Wnd.prototype, "Scene2Wnd");
var Scene3luwei1Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._clluwei0 = null, t._lluwei4 = null, t._lluwei3 = null, t._lluwei2 = null, t._lluwei1 = null, t._lluwei0 = null, t._rluwei7 = null, t._rluwei6 = null, t._rluwei5 = null, t._rluwei4 = null, t._rluwei3 = null, t._rluwei2 = null, t._rluwei1 = null, t._rluwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddScene3luwei1 = function () {
        this._lluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/lluwei4.png", 30, 24, 556, 30, "l_d"), this.addChild(this._lluwei4), this._clluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/clluwei0.png", 37, 31, 220, 0, "c_d"), this.addChild(this._clluwei0), this._lluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/lluwei3.png", 23, 23, 548, 25, "l_d"), this.addChild(this._lluwei3), this._lluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/lluwei2.png", 18, 31, 547, 16, "l_d"), this.addChild(this._lluwei2), this._lluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/lluwei1.png", 37, 26, 477, 21, "l_d"), this.addChild(this._lluwei1), this._lluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/lluwei0.png", 23, 35, 475, 9.99999999999999, "l_d"), this.addChild(this._lluwei0), this._rluwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei7.png", 24, 42, 71.0000000000001, 14, "r_d"), this.addChild(this._rluwei7), this._rluwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei6.png", 22, 25, 76.0000000000001, 30, "r_d"), this.addChild(this._rluwei6), this._rluwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei5.png", 22, 26, 52.0000000000001, 34, "r_d"), this.addChild(this._rluwei5), this._rluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei4.png", 22, 26, 33.0000000000001, 37, "r_d"), this.addChild(this._rluwei4), this._rluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei3.png", 22, 26, 0, 40, "r_d"), this.addChild(this._rluwei3), this._rluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei2.png", 34, 29, 54.0000000000001, 29, "r_d"), this.addChild(this._rluwei2), this._rluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei1.png", 34, 29, 70.0000000000001, 25, "r_d"), this.addChild(this._rluwei1), this._rluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei1Sp/rluwei0.png", 26, 38, 14.0000000000001, 25, "r_d"), this.addChild(this._rluwei0), this._arr = [];
        var e;
        for (e = 0; 8 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_rluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_rluwei" + e])
        }
        for (e = 0; 1 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_clluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_clluwei" + e])
        }
        for (e = 0; 5 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_lluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_lluwei" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene3luwei1Sp.prototype, "Scene3luwei1Sp");
var Scene3luwei2Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._luwei11 = null, t._luwei10 = null, t._luwei9 = null, t._luwei8 = null, t._luwei7 = null, t._luwei6 = null, t._luwei5 = null, t._luwei4 = null, t._luwei3 = null, t._luwei2 = null, t._luwei1 = null, t._luwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onScene3luwei2 = function () {
        this._luwei11 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei11.png", 25, 28, 0, 0, "l_d"), this.addChild(this._luwei11), this._luwei10 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei10.png", 11, 23, 238, 32, "l_d"), this.addChild(this._luwei10), this._luwei9 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei9.png", 7, 16, 248, 34, "l_d"), this.addChild(this._luwei9), this._luwei8 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei8.png", 10, 30, 254, 29, "l_d"), this.addChild(this._luwei8), this._luwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei7.png", 10, 30, 262, 32, "l_d"), this.addChild(this._luwei7), this._luwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei6.png", 18, 27, 264, 32, "l_d"), this.addChild(this._luwei6), this._luwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei5.png", 8, 15, 277, 36, "l_d"), this.addChild(this._luwei5), this._luwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei4.png", 11, 21, 280, 35, "l_d"), this.addChild(this._luwei4), this._luwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei3.png", 19, 23, 11.9999999999999, 15, "l_d"), this.addChild(this._luwei3), this._luwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei2.png", 16, 25, 13, 2, "l_d"), this.addChild(this._luwei2), this._luwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei1.png", 16, 27, 29, 11, "l_d"), this.addChild(this._luwei1), this._luwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei2Sp/luwei0.png", 22, 21, 28, 10, "l_d"), this.addChild(this._luwei0), this._arr = [];
        var e;
        for (e = 0; 12 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_luwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_luwei" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene3luwei2Sp.prototype, "Scene3luwei2Sp");
var Scene3luwei3Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._luwei98 = null, t._luwei97 = null, t._luwei96 = null, t._luwei95 = null, t._luwei94 = null, t._luwei93 = null, t._luwei92 = null, t._luwei91 = null, t._luwei90 = null, t._luwei89 = null, t._luwei88 = null, t._luwei87 = null, t._luwei86 = null, t._luwei85 = null, t._luwei84 = null, t._luwei83 = null, t._luwei82 = null, t._luwei81 = null, t._luwei80 = null, t._luwei79 = null, t._luwei78 = null, t._luwei77 = null, t._luwei76 = null, t._luwei75 = null, t._luwei74 = null, t._luwei73 = null, t._luwei72 = null, t._luwei71 = null, t._luwei70 = null, t._luwei69 = null, t._luwei68 = null, t._luwei67 = null, t._luwei66 = null, t._luwei65 = null, t._luwei64 = null, t._luwei63 = null, t._luwei62 = null, t._luwei61 = null, t._luwei60 = null, t._luwei59 = null, t._luwei58 = null, t._luwei57 = null, t._luwei56 = null, t._luwei55 = null, t._luwei54 = null, t._luwei53 = null, t._luwei52 = null, t._luwei51 = null, t._luwei50 = null, t._luwei49 = null, t._luwei48 = null, t._luwei47 = null, t._luwei46 = null, t._luwei45 = null, t._luwei44 = null, t._luwei43 = null, t._luwei42 = null, t._luwei41 = null, t._luwei40 = null, t._luwei39 = null, t._luwei38 = null, t._luwei37 = null, t._luwei36 = null, t._luwei35 = null, t._luwei34 = null, t._luwei33 = null, t._luwei32 = null, t._luwei31 = null, t._luwei30 = null, t._luwei29 = null, t._luwei28 = null, t._luwei27 = null, t._luwei26 = null, t._luwei25 = null, t._luwei24 = null, t._luwei23 = null, t._luwei22 = null, t._luwei21 = null, t._luwei20 = null, t._luwei19 = null, t._luwei18 = null, t._luwei17 = null, t._luwei16 = null, t._luwei15 = null, t._luwei14 = null, t._luwei13 = null, t._luwei12 = null, t._luwei11 = null, t._luwei10 = null, t._luwei9 = null, t._luwei8 = null, t._luwei7 = null, t._luwei6 = null, t._luwei5 = null, t._luwei4 = null, t._luwei3 = null, t._luwei2 = null, t._luwei1 = null, t._luwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddScene3luwei3 = function () {
        this._luwei98 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei98.png", 30, 44, 668, 83, "c_d"), this.addChild(this._luwei98), this._luwei97 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei97.png", 29, 39, 657, 85, "c_d"), this.addChild(this._luwei97), this._luwei96 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei96.png", 31, 44, 623, 102, "c_d"), this.addChild(this._luwei96), this._luwei95 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei95.png", 31, 44, 606, 92, "c_d"), this.addChild(this._luwei95), this._luwei94 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei94.png", 31, 44, 575, 95, "c_d"), this.addChild(this._luwei94), this._luwei93 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei93.png", 31, 45, 567, 81, "c_d"), this.addChild(this._luwei93), this._luwei92 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei92.png", 31, 43, 562, 98, "c_d"), this.addChild(this._luwei92), this._luwei91 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei91.png", 30, 35, 534, 102, "c_d"), this.addChild(this._luwei91), this._luwei90 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei90.png", 52, 84, 197, 213, "c_d"), this.addChild(this._luwei90), this._luwei89 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei89.png", 35, 61, 165, 177, "c_d"), this.addChild(this._luwei89), this._luwei88 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei88.png", 36, 49, 177, 169, "c_d"), this.addChild(this._luwei88), this._luwei87 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei87.png", 35, 77, 186, 148, "c_d"), this.addChild(this._luwei87), this._luwei86 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei86.png", 35, 84, 197, 140, "c_d"), this.addChild(this._luwei86), this._luwei85 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei85.png", 39, 89, 203, 140, "c_d"), this.addChild(this._luwei85), this._luwei84 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei84.png", 65, 66, 208, 140, "c_d"), this.addChild(this._luwei84), this._luwei83 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei83.png", 36, 56, 221, 177, "c_d"), this.addChild(this._luwei83), this._luwei82 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei82.png", 35, 62, 233, 169, "c_d"), this.addChild(this._luwei82), this._luwei81 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei81.png", 78, 96, 111, 168, "c_d"), this.addChild(this._luwei81), this._luwei80 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei80.png", 36, 52, 90, 194, "c_d"), this.addChild(this._luwei80), this._luwei79 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei79.png", 35, 54, 78.9999999999999, 185, "c_d"), this.addChild(this._luwei79), this._luwei78 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei78.png", 36, 62, 77.9999999999999, 216, "c_d"), this.addChild(this._luwei78), this._luwei77 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei77.png", 35, 62, 90, 224, "c_d"), this.addChild(this._luwei77), this._luwei76 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei76.png", 71, 120, 149, 81, "c_d"), this.addChild(this._luwei76), this._luwei75 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei75.png", 102, 140, 100, 60, "c_d"), this.addChild(this._luwei75), this._luwei74 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei74.png", 37, 61, 76, 258, "c_d"), this.addChild(this._luwei74), this._luwei73 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei73.png", 35, 62, 280, 139, "c_d"), this.addChild(this._luwei73), this._luwei72 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei72.png", 36, 61, 291, 148, "c_d"), this.addChild(this._luwei72), this._luwei71 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei71.png", 42, 59, 51, 238, "c_d"), this.addChild(this._luwei71), this._luwei70 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei70.png", 36, 61, 48, 226, "c_d"), this.addChild(this._luwei70), this._luwei69 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei69.png", 36, 61, 36.0000000000001, 218, "c_d"), this.addChild(this._luwei69), this._luwei68 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei68.png", 35, 62, 25, 209, "c_d"), this.addChild(this._luwei68), this._luwei67 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei67.png", 36, 61, 31.9999999999999, 270, "c_d"), this.addChild(this._luwei67), this._luwei66 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei66.png", 37, 61, 14.0000000000001, 299, "c_d"), this.addChild(this._luwei66), this._luwei65 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei65.png", 36, 61, 13, 242, "c_d"), this.addChild(this._luwei65), this._luwei64 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei64.png", 35, 62, 2.99999999999989, 234, "c_d"), this.addChild(this._luwei64), this._luwei63 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei63.png", 35, 61, 59, 182, "c_d"), this.addChild(this._luwei63), this._luwei62 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei62.png", 35, 62, 48, 173, "c_d"), this.addChild(this._luwei62), this._luwei61 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei61.png", 36, 61, 9, 187, "c_d"), this.addChild(this._luwei61), this._luwei60 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei60.png", 37, 61, 9.99999999999989, 143, "c_d"), this.addChild(this._luwei60), this._luwei59 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei59.png", 37, 62, 48, 106, "c_d"), this.addChild(this._luwei59), this._luwei58 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei58.png", 25, 61, 697, 117, "c_d"), this.addChild(this._luwei58), this._luwei57 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei57.png", 37, 50, 708, 108, "c_d"), this.addChild(this._luwei57), this._luwei56 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei56.png", 32, 76, 718, 88, "c_d"), this.addChild(this._luwei56), this._luwei55 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei55.png", 21, 84, 729, 80, "c_d"), this.addChild(this._luwei55), this._luwei54 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei54.png", 79, 96, 642, 108, "c_d"), this.addChild(this._luwei54), this._luwei53 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei53.png", 36, 52, 622, 133, "c_d"), this.addChild(this._luwei53), this._luwei52 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei52.png", 35, 54, 611, 125, "c_d"), this.addChild(this._luwei52), this._luwei51 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei51.png", 35, 61, 610, 156, "c_d"), this.addChild(this._luwei51), this._luwei50 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei50.png", 36, 62, 621, 164, "c_d"), this.addChild(this._luwei50), this._luwei49 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei49.png", 70, 121, 680, 20, "c_d"), this.addChild(this._luwei49), this._luwei48 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei48.png", 102, 139, 632, 0, "c_d"), this.addChild(this._luwei48), this._luwei47 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei47.png", 36, 62, 608, 197, "c_d"), this.addChild(this._luwei47), this._luwei46 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei46.png", 41, 58, 583, 178, "c_d"), this.addChild(this._luwei46), this._luwei45 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei45.png", 37, 61, 579, 166, "c_d"), this.addChild(this._luwei45), this._luwei44 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei44.png", 36, 62, 567, 157, "c_d"), this.addChild(this._luwei44), this._luwei43 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei43.png", 35, 62, 556, 149, "c_d"), this.addChild(this._luwei43), this._luwei42 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei42.png", 36, 62, 563, 209, "c_d"), this.addChild(this._luwei42), this._luwei41 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei41.png", 36, 61, 546, 239, "c_d"), this.addChild(this._luwei41), this._luwei40 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei40.png", 36, 61, 545, 182, "c_d"), this.addChild(this._luwei40), this._luwei39 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei39.png", 36, 62, 534, 173, "c_d"), this.addChild(this._luwei39), this._luwei38 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei38.png", 36, 62, 590, 121, "c_d"), this.addChild(this._luwei38), this._luwei37 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei37.png", 35, 62, 580, 113, "c_d"), this.addChild(this._luwei37), this._luwei36 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei36.png", 37, 61, 540, 127, "c_d"), this.addChild(this._luwei36), this._luwei35 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei35.png", 36, 61, 542, 83, "c_d"), this.addChild(this._luwei35), this._luwei34 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei34.png", 36, 61, 580, 46, "c_d"), this.addChild(this._luwei34), this._luwei33 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei33.png", 29, 35, 632, 45, "c_d"), this.addChild(this._luwei33), this._luwei32 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei32.png", 30, 44, 614, 43, "c_d"), this.addChild(this._luwei32), this._luwei31 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei31.png", 30, 39, 603, 45, "c_d"), this.addChild(this._luwei31), this._luwei30 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei30.png", 31, 44, 569, 62, "c_d"), this.addChild(this._luwei30), this._luwei29 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei29.png", 31, 44, 552, 52, "c_d"), this.addChild(this._luwei29), this._luwei28 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei28.png", 31, 44, 521, 55, "c_d"), this.addChild(this._luwei28), this._luwei27 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei27.png", 31, 45, 513, 41, "c_d"), this.addChild(this._luwei27), this._luwei26 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei26.png", 31, 43, 508, 58, "c_d"), this.addChild(this._luwei26), this._luwei25 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei25.png", 29, 35, 481, 62, "c_d"), this.addChild(this._luwei25), this._luwei24 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei24.png", 52, 84, 143, 173, "c_d"), this.addChild(this._luwei24), this._luwei23 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei23.png", 29, 61, 111, 137, "c_d"), this.addChild(this._luwei23), this._luwei22 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei22.png", 36, 49, 123, 129, "c_d"), this.addChild(this._luwei22), this._luwei21 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei21.png", 35, 77, 132, 108, "c_d"), this.addChild(this._luwei21), this._luwei20 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei20.png", 35, 84, 143, 100, "c_d"), this.addChild(this._luwei20), this._luwei19 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei19.png", 39, 89, 149, 100, "c_d"), this.addChild(this._luwei19), this._luwei18 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei18.png", 65, 66, 154, 100, "c_d"), this.addChild(this._luwei18), this._luwei17 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei17.png", 36, 56, 167, 137, "c_d"), this.addChild(this._luwei17), this._luwei16 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei16.png", 35, 62, 179, 129, "c_d"), this.addChild(this._luwei16), this._luwei15 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei15.png", 78, 96, 57, 128, "c_d"), this.addChild(this._luwei15), this._luwei14 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei14.png", 36, 52, 36.0000000000001, 154, "c_d"), this.addChild(this._luwei14), this._luwei13 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei13.png", 35, 54, 25, 145, "c_d"), this.addChild(this._luwei13), this._luwei12 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei12.png", 35, 62, 25, 176, "c_d"), this.addChild(this._luwei12), this._luwei11 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei11.png", 36, 62, 36.0000000000001, 184, "c_d"), this.addChild(this._luwei11), this._luwei10 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei10.png", 72, 120, 95, 41, "c_d"), this.addChild(this._luwei10), this._luwei9 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei9.png", 102, 140, 46, 20, "c_d"), this.addChild(this._luwei9), this._luwei8 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei8.png", 36, 61, 23, 218, "c_d"), this.addChild(this._luwei8), this._luwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei7.png", 35, 62, 226, 99, "c_d"), this.addChild(this._luwei7), this._luwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei6.png", 36, 61, 237, 108, "c_d"), this.addChild(this._luwei6), this._luwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei5.png", 39, 59, 0, 198, "c_d"), this.addChild(this._luwei5), this._luwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei4.png", 30, 61, 0, 186, "c_d"), this.addChild(this._luwei4), this._luwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei3.png", 18, 60, 0, 178, "c_d"), this.addChild(this._luwei3), this._luwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei2.png", 36, 61, 5, 142, "c_d"), this.addChild(this._luwei2), this._luwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei1.png", 30, 62, 0, 133, "c_d"), this.addChild(this._luwei1), this._luwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei3Sp/luwei0.png", 31, 62, 0, 66, "c_d"), this.addChild(this._luwei0), this._arr = [];
        var e;
        for (e = 0; 99 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_luwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_luwei" + e])
        }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene3luwei3Sp.prototype, "Scene3luwei3Sp");
var Scene3luwei4Sp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._lluwei10 = null, t._lluwei9 = null, t._lluwei8 = null, t._rluwei9 = null, t._cluwei20 = null, t._rluwei8 = null, t._rluwei7 = null, t._cluwei19 = null, t._rluwei6 = null, t._cluwei18 = null, t._rluwei5 = null, t._cluwei17 = null, t._rluwei4 = null, t._cluwei16 = null, t._cluwei15 = null, t._rluwei3 = null, t._cluwei14 = null, t._cluwei13 = null, t._cluwei12 = null, t._cluwei11 = null, t._cluwei10 = null, t._lluwei7 = null, t._rluwei2 = null, t._rluwei1 = null, t._rluwei0 = null, t._cluwei9 = null, t._cluwei8 = null, t._cluwei7 = null, t._lluwei5 = null, t._lluwei4 = null, t._lluwei3 = null, t._lluwei2 = null, t._lluwei1 = null, t._lluwei0 = null, t._cluwei6 = null, t._cluwei5 = null, t._cluwei4 = null, t._cluwei3 = null, t._cluwei2 = null, t._cluwei1 = null, t._cluwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onScene3luwei4 = function () {
        this._lluwei10 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei10.png", 236, 205, 75, 200, "l_d"), this.addChild(this._lluwei10), this._lluwei9 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei9.png", 116, 166, 22, 208, "l_d"), this.addChild(this._lluwei9), this._lluwei8 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei8.png", 71, 136, 6, 169, "l_d"), this.addChild(this._lluwei8), this._rluwei9 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei9.png", 37, 66, 284, 86, "r_d"), this.addChild(this._rluwei9), this._cluwei20 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei20.png", 51, 79, 330, 103, "c_d"), this.addChild(this._cluwei20), this._rluwei8 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei8.png", 115, 117, 290, 21, "r_d"), this.addChild(this._rluwei8), this._rluwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei7.png", 49, 114, 324, 22, "r_d"), this.addChild(this._rluwei7), this._cluwei19 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei19.png", 47, 88, 372, 90, "c_d"), this.addChild(this._cluwei19), this._rluwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei6.png", 99, 111, 383, 92, "r_d"), this.addChild(this._rluwei6), this._cluwei18 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei18.png", 47, 83, 416, 109, "c_d"), this.addChild(this._cluwei18), this._rluwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei5.png", 83, 146, 394, 61, "r_d"), this.addChild(this._rluwei5), this._cluwei17 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei17.png", 41, 92, 432, 105, "c_d"), this.addChild(this._cluwei17), this._rluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei4.png", 93, 47, 240, 91, "r_d"), this.addChild(this._rluwei4), this._cluwei16 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei16.png", 33, 72, 455, 133, "c_d"), this.addChild(this._cluwei16), this._cluwei15 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei15.png", 60, 92, 570, 162, "c_d"), this.addChild(this._cluwei15), this._rluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei3.png", 99, 118, 563, 132, "r_d"), this.addChild(this._rluwei3), this._cluwei14 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei14.png", 33, 71, 624, 138, "c_d"), this.addChild(this._cluwei14), this._cluwei13 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei13.png", 30, 74, 637, 148, "c_d"), this.addChild(this._cluwei13), this._cluwei12 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei12.png", 30, 67, 639, 177, "c_d"), this.addChild(this._cluwei12), this._cluwei11 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei11.png", 53, 74, 639, 170, "c_d"), this.addChild(this._cluwei11), this._cluwei10 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei10.png", 26, 92, 664, 179, "c_d"), this.addChild(this._cluwei10), this._lluwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei7.png", 78, 131, 672, 154, "l_d"), this.addChild(this._lluwei7), this._rluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei2.png", 85, 151, 628, 56, "r_d"), this.addChild(this._rluwei2), this._rluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei1.png", 64, 126, 686, 0, "r_d"), this.addChild(this._rluwei1), this._rluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/rluwei0.png", 57, 78, 693, 88, "r_d"), this.addChild(this._rluwei0), this._cluwei9 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei9.png", 43, 90, 496, 127, "c_d"), this.addChild(this._cluwei9), this._cluwei8 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei8.png", 48, 89, 500, 134, "c_d"), this.addChild(this._cluwei8), this._cluwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei7.png", 137, 117, 75, 326, "c_d"), this.addChild(this._cluwei7), this._lluwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei5.png", 266, 248, 93, 163, "l_d"), this.addChild(this._lluwei5), this._lluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei4.png", 212, 364, 133, 109, "l_d"), this.addChild(this._lluwei4), this._lluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei3.png", 130, 294, 0, 173, "l_d"), this.addChild(this._lluwei3), this._lluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei2.png", 194, 323, 0, 150, "l_d"), this.addChild(this._lluwei2), this._lluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei1.png", 282, 216, 108, 257, "l_d"), this.addChild(this._lluwei1), this._lluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/lluwei0.png", 174, 331, 55, 112, "l_d"), this.addChild(this._lluwei0), this._cluwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei6.png", 38, 78, 88, 360, "c_d"), this.addChild(this._cluwei6), this._cluwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei5.png", 32, 66, 170, 354, "c_d"), this.addChild(this._cluwei5), this._cluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei4.png", 36, 63, 207, 407, "c_d"), this.addChild(this._cluwei4), this._cluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei3.png", 52, 91, 44.9999999999999, 362, "c_d"), this.addChild(this._cluwei3), this._cluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei2.png", 49, 93, 24, 377, "c_d"), this.addChild(this._cluwei2), this._cluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei1.png", 40, 91, 0, 360, "c_d"), this.addChild(this._cluwei1), this._cluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene3luwei4Sp/cluwei0.png", 39, 73, 54, 279, "c_d"), this.addChild(this._cluwei0), this._arr = [];
        var e;
        for (e = 0; 10 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_rluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_rluwei" + e])
        }
        for (e = 0; 21 > e; e++) {
            var t = 5 * Math.random() + 3;
            egret.Tween.get(this["_cluwei" + e], {
                loop: !0
            }).to({
                rotation: t
            }, 700 + Math.floor(100 * t)).to({
                rotation: 0
            }, 700 + Math.floor(100 * t)), this._arr.push(this["_cluwei" + e])
        }
        for (e = 0; 11 > e; e++)
            if (6 != e) {
                var t = 5 * Math.random() + 3;
                egret.Tween.get(this["_lluwei" + e], {
                    loop: !0
                }).to({
                    rotation: t
                }, 700 + Math.floor(100 * t)).to({
                    rotation: 0
                }, 700 + Math.floor(100 * t)), this._arr.push(this["_lluwei" + e])
            }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene3luwei4Sp.prototype, "Scene3luwei4Sp");
var Scene3Wnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene3_bg0 = null, t._scene3_bgLig = null, t._scene3_bg1 = null, t._scene3_bg2 = null, t._scene3_bg3 = null, t._scene3_bg4 = null, t._scene3_bg5 = null, t._scene3_cloud3 = null, t._scene3_cloud2 = null, t._scene3_cloud1 = null, t._scene3_flag = null, t._scene3_bg6 = null, t._scene3_cloud0 = null, t._cardSp = null, t._gatherSp = null, t._gatherX = 0, t._gatherY = 0, t._currentIndex = 0, t._showIndex = 0, t._npcMovieSp = null, t._data = null, t._scene3luwei1Sp = null, t._scene3luwei2Sp = null, t._scene3luwei3Sp = null, t._scene3luwei4Sp = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        this._scene3_bg0 = MyUtils.createImageByName("scene3_bg0_jpg", 750, 1448, 0, 0), this.addChild(this._scene3_bg0), this._scene3_bgLig = MyUtils.createImageByName("scene3_bgLig_png", 750, 1247, 0, 0), this.addChild(this._scene3_bgLig), egret.Tween.get(this._scene3_bgLig, {
            loop: !0
        }).to({
            alpha: .38
        }, 1e3).to({
            alpha: 1
        }, 1e3), this._scene3_bg1 = MyUtils.createImageByName("scene3_bg1_png", 750, 1378, 0, 0), this.addChild(this._scene3_bg1), this._scene3luwei1Sp = new Scene3luwei1Sp, this._scene3luwei1Sp.onAddScene3luwei1(), this._scene3luwei1Sp.x = 96, this._scene3luwei1Sp.y = 701, this.addChild(this._scene3luwei1Sp), this._scene3_bg2 = MyUtils.createImageByName("scene3_bg2_png", 736, 202, 14.0000000000001, 692), this.addChild(this._scene3_bg2), this._scene3luwei2Sp = new Scene3luwei2Sp, this._scene3luwei2Sp.onScene3luwei2(), this._scene3luwei2Sp.x = 441, this._scene3luwei2Sp.y = 714, this.addChild(this._scene3luwei2Sp), this._scene3_bg3 = MyUtils.createImageByName("scene3_bg3_png", 750, 938, 0, 324), this.addChild(this._scene3_bg3), this._scene3luwei3Sp = new Scene3luwei3Sp, this._scene3luwei3Sp.onAddScene3luwei3(), this._scene3luwei3Sp.x = 0, this._scene3luwei3Sp.y = 730, this.addChild(this._scene3luwei3Sp), this._scene3_bg4 = MyUtils.createImageByName("scene3_bg4_png", 750, 1174, 0, 274), this.addChild(this._scene3_bg4), this._scene3luwei4Sp = new Scene3luwei4Sp, this._scene3luwei4Sp.onScene3luwei4(), this._scene3luwei4Sp.x = 0, this._scene3luwei4Sp.y = 975, this.addChild(this._scene3luwei4Sp), this._scene3_bg5 = MyUtils.createImageByName("scene3_bg5_png", 750, 825, 0, 623), this.addChild(this._scene3_bg5), this._scene3_cloud3 = MyUtils.createImageByName("scene3_cloud3_png", 353, 119, 397, 86, "r_c"), this.addChild(this._scene3_cloud3), egret.Tween.get(this._scene3_cloud3, {
            loop: !0
        }).to({
            scaleX: 1.05
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene3_cloud2 = MyUtils.createImageByName("scene3_cloud2_png", 279, 149, 0, 172), this.addChild(this._scene3_cloud2), egret.Tween.get(this._scene3_cloud2, {
            loop: !0
        }).to({
            scaleX: 1.05
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene3_cloud1 = MyUtils.createImageByName("scene3_cloud1_png", 601, 267, 149, 0, "r_c"), this.addChild(this._scene3_cloud1), egret.Tween.get(this._scene3_cloud1, {
            loop: !0
        }).to({
            scaleX: 1.05
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene3_bg6 = MyUtils.createImageByName("scene3_bg6_png", 115, 82, 0, 192), this.addChild(this._scene3_bg6), this._currentIndex = 0, this._showIndex = 0, this._data = config_json.scene3data, this._npcMovieSp = new NpcMovieSp, this._npcMovieSp.addRole(), this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp._frameNum = 10, this._npcMovieSp.onPlay(), this.addChild(this._npcMovieSp), this._npcMovieSp.touchEnabled = !1, this._gatherSp = new GatherSp, this._gatherSp.onAddGather(), this._gatherSp.x = this._data[305].x, this._gatherSp.y = this._data[305].y, this.addChild(this._gatherSp), egret.startTick(this.onMoveEvent, this), this._gatherSp.touchEnabled = !0, this._gatherSp.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._scene3_flag = MyUtils.createImageByName("scene3_flag_png", 234, 973, 0, 207), this.addChild(this._scene3_flag), egret.Tween.get(this._scene3_flag, {
            loop: !0
        }).to({
            rotation: 3
        }, 1e3).to({
            rotation: 0
        }, 1e3), this._scene3_cloud0 = MyUtils.createImageByName("scene3_cloud0_png", 542, 207, 0, 0), this.addChild(this._scene3_cloud0), egret.Tween.get(this._scene3_cloud0, {
            loop: !0
        }).to({
            scaleX: 1.1
        }, 2e3).to({
            scaleX: 1
        }, 2e3)
    }, t.prototype.onGatherTap = function (e) {
        void 0 === e && (e = null), null != this._gatherSp && (onAddEvent("clickEvent", "gather", "skip1"), this._gatherX = this._gatherSp.x, this._gatherY = this._gatherSp.y, this._gatherSp.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._gatherSp.onRemove(), this._gatherSp.parent.removeChild(this._gatherSp), this._gatherSp = null), this.onOpenWnd()
    }, t.prototype.onOpenWnd = function () {
        console.log("打开弹窗"), null == this._cardSp && (this._cardSp = new CardSp, this._cardSp.onAddCard(3, this._gatherX, this._gatherY), this._cardSp.alpha = 0, WndManager.root.addChild(this._cardSp), egret.Tween.get(this._cardSp).to({
            alpha: 1
        }, 500), this._cardSp.addEventListener("onNextScene", this.onNextScene, this))
    }, t.prototype.onNextScene = function (e) {
        this._cardSp.removeEventListener("onNextScene", this.onNextScene, this), egret.Tween.removeTweens(this._npcMovieSp), this._npcMovieSp.onStop(), this._npcMovieSp._roleTimer = 0, this._npcMovieSp._frameNum = 8, this._npcMovieSp.onPlay(), egret.startTick(this.onNextEvent, this)
    }, t.prototype.onMoveEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 1)) {
            if (this._showIndex++, this._showIndex >= 305) return null != this._gatherSp && this._gatherSp.onAddClick(), egret.stopTick(this.onMoveEvent, this), egret.Tween.get(this._npcMovieSp, {
                loop: !0
            }).to({
                y: this._npcMovieSp.y - 15
            }, 1e3).to({
                y: this._npcMovieSp.y
            }, 1e3), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.onNextEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 2)) {
            if (this._showIndex++, this._showIndex >= this._data.length) return egret.stopTick(this.onNextEvent, this), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(Scene4Wnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.Destroy = function () {
        null != this._scene3luwei1Sp && (this._scene3luwei1Sp.onRemove(), this._scene3luwei1Sp.parent.removeChild(this._scene3luwei1Sp), this._scene3luwei1Sp = null), null != this._scene3luwei2Sp && (this._scene3luwei2Sp.onRemove(), this._scene3luwei2Sp.parent.removeChild(this._scene3luwei2Sp), this._scene3luwei2Sp = null), null != this._scene3luwei3Sp && (this._scene3luwei3Sp.onRemove(), this._scene3luwei3Sp.parent.removeChild(this._scene3luwei3Sp), this._scene3luwei3Sp = null), null != this._scene3luwei4Sp && (this._scene3luwei4Sp.onRemove(), this._scene3luwei4Sp.parent.removeChild(this._scene3luwei4Sp), this._scene3luwei4Sp = null), null != this._npcMovieSp && (egret.stopTick(this.onMoveEvent, this), this._npcMovieSp.onStop(), this._npcMovieSp.parent.removeChild(this._npcMovieSp), this._npcMovieSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(Scene3Wnd.prototype, "Scene3Wnd");
var Scene4luweiSp = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._lluwei7 = null, t._lluwei6 = null, t._lluwei5 = null, t._lluwei4 = null, t._lluwei3 = null, t._lluwei2 = null, t._lluwei1 = null, t._lluwei0 = null, t._arr = [], t
    }
    return __extends(t, e), t.prototype.onAddScene4luwei = function () {
        this._lluwei7 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei7.png", 180, 213, 439, 1134, "l_d"), this.addChild(this._lluwei7), this._lluwei6 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei6.png", 212, 185, 387, 1185, "l_d"), this.addChild(this._lluwei6), this._lluwei5 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei5.png", 141, 219, 322, 1229, "l_d"), this.addChild(this._lluwei5), this._lluwei4 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei4.png", 162, 224, 560, 1093, "l_d"), this.addChild(this._lluwei4), this._lluwei3 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei3.png", 162, 225, 402, 1095, "l_d"), this.addChild(this._lluwei3), this._lluwei2 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei2.png", 150, 162, 140, 1286, "l_d"), this.addChild(this._lluwei2), this._lluwei1 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei1.png", 179, 137, 173, 1311, "l_d"), this.addChild(this._lluwei1), this._lluwei0 = MyUtils.createImageByNameUrl("resource/begin/Scene4luweiSp/lluwei0.png", 90, 204, 319, 1208, "l_d"), this.addChild(this._lluwei0), this._arr = [];
        var e;
        for (e = 0; 8 > e; e++)
            if (6 != e) {
                var t = 5 * Math.random() + 3;
                egret.Tween.get(this["_lluwei" + e], {
                    loop: !0
                }).to({
                    rotation: t
                }, 700 + Math.floor(100 * t)).to({
                    rotation: 0
                }, 700 + Math.floor(100 * t)), this._arr.push(this["_lluwei" + e])
            }
    }, t.prototype.onRemove = function () {
        for (var e = 0; e < this._arr.length; e++) egret.Tween.removeTweens(this._arr[e]), this._arr[e].parent.removeChild(this._arr[e]), this._arr[e] = null;
        this._arr = []
    }, t
}(egret.DisplayObjectContainer);
__reflect(Scene4luweiSp.prototype, "Scene4luweiSp");
var Scene4Wnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene4_bg = null, t._scene4_cloud0 = null, t._scene4_thunder2 = null, t._scene4_cloud1 = null, t._scene4_thunder1 = null, t._scene4_cloud2 = null, t._scene4_bg1 = null, t._scene4_bg1Lig = null, t._scene4luweiSp = null, t._scene4_bg2 = null, t._scene_rain = null, t._scene4_tree0 = null, t._scene4_bg3 = null, t._scene4_tree1 = null, t._scene4_tree2 = null, t._cardSp = null, t._gatherSp = null, t._gatherX = 0, t._gatherY = 0, t._currentIndex = 0, t._showIndex = 0, t._npcMovieSp = null, t._data = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        this._scene4_bg = MyUtils.createImageByName("scene4_bg_jpg", 750, 1448, 0, 0), this.addChild(this._scene4_bg), this._scene4_cloud0 = MyUtils.createImageByName("scene4_cloud0_png", 544, 512, 0, 285), this.addChild(this._scene4_cloud0), egret.Tween.get(this._scene4_cloud0, {
            loop: !0
        }).to({
            x: -10
        }, 2e3).to({
            x: 0
        }, 2e3), this._scene4_thunder2 = MyUtils.createImageByName("scene4_thunder2_png", 410, 396, 318, 52), this._scene4_thunder2.alpha = 0, this.addChild(this._scene4_thunder2), egret.Tween.get(this._scene4_thunder2, {
            loop: !0
        }).wait(1500).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 200).wait(200).to({
            alpha: 0
        }, 300).wait(2e3), this._scene4_cloud1 = MyUtils.createImageByName("scene4_cloud1_png", 750, 650, 0, 66, "c_c"), this.addChild(this._scene4_cloud1), egret.Tween.get(this._scene4_cloud1, {
            loop: !0
        }).to({
            scaleX: 1.15
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene4_thunder1 = MyUtils.createImageByName("scene4_thunder1_png", 307, 710, 203, 0), this._scene4_thunder1.alpha = 0, this.addChild(this._scene4_thunder1), egret.Tween.get(this._scene4_thunder1, {
            loop: !0
        }).wait(1500).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 200).wait(200).to({
            alpha: 0
        }, 300).wait(2e3), this._scene4_cloud2 = MyUtils.createImageByName("scene4_cloud2_png", 533, 340, 217, 0, "r_c"), this.addChild(this._scene4_cloud2), egret.Tween.get(this._scene4_cloud2, {
            loop: !0
        }).to({
            scaleX: 1.1
        }, 2e3).to({
            scaleX: 1
        }, 2e3), this._scene4_bg1 = MyUtils.createImageByName("scene4_bg1_png", 750, 1448, 0, 0), this.addChild(this._scene4_bg1), this._scene4_bg1Lig = MyUtils.createImageByName("scene4_bg1Lig_png", 750, 797, 0, 284), this._scene4_bg1Lig.alpha = 0, this.addChild(this._scene4_bg1Lig), egret.Tween.get(this._scene4_bg1Lig, {
            loop: !0
        }).wait(1500).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 100).to({
            alpha: 0
        }, 100).to({
            alpha: 1
        }, 200).wait(200).to({
            alpha: 0
        }, 300).wait(2e3), this._scene4luweiSp = new Scene4luweiSp, this._scene4luweiSp.onAddScene4luwei(), this.addChild(this._scene4luweiSp), this._scene4_bg2 = MyUtils.createImageByName("scene4_bg2_png", 750, 987, 0, 461), this.addChild(this._scene4_bg2), this._scene_rain = new RainMovieSp, this._scene_rain.addRole(), this._scene_rain.onPlay(), this._scene_rain.alpha = 0, this.addChild(this._scene_rain), egret.Tween.get(this._scene_rain).wait(3e3).to({
            alpha: 1
        }, 500), this._scene4_tree0 = MyUtils.createImageByName("scene4_tree0_png", 481, 519, 0, 0, "l_d"), this.addChild(this._scene4_tree0), egret.Tween.get(this._scene4_tree0, {
            loop: !0
        }).to({
            rotation: -2
        }, 1e3).to({
            rotation: 0
        }, 1e3), this._scene4_bg3 = MyUtils.createImageByName("scene4_bg3_png", 707, 804, 0, 644), this.addChild(this._scene4_bg3), this._scene4_tree1 = MyUtils.createImageByName("scene4_tree1_png", 438, 815, 0, 0, "l_d"), this.addChild(this._scene4_tree1), egret.Tween.get(this._scene4_tree1, {
            loop: !0
        }).to({
            rotation: -1
        }, 1e3).to({
            rotation: 0
        }, 1e3), this._scene4_tree2 = MyUtils.createImageByName("scene4_tree2_png", 201, 275, 549, 1173, "c_c"), this.addChild(this._scene4_tree2), egret.Tween.get(this._scene4_tree1, {
            loop: !0
        }).to({
            rotation: -3
        }, 2e3).to({
            rotation: 0
        }, 2e3), this._currentIndex = 0, this._showIndex = 0, this._data = config_json.scene4data, this._npcMovieSp = new NpcMovieSp, this._npcMovieSp.addRole(), this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp._frameNum = 10, this._npcMovieSp.onPlay(), this.addChild(this._npcMovieSp), this._npcMovieSp.touchEnabled = !1, this._gatherSp = new GatherSp, this._gatherSp.onAddGather(), this._gatherSp.x = this._data[305].x, this._gatherSp.y = this._data[305].y, this.addChild(this._gatherSp), egret.startTick(this.onMoveEvent, this), this._gatherSp.touchEnabled = !0, this._gatherSp.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this)
    }, t.prototype.onGatherTap = function (e) {
        void 0 === e && (e = null), null != this._gatherSp && (onAddEvent("clickEvent", "gather", "skip1"), this._gatherX = this._gatherSp.x, this._gatherY = this._gatherSp.y, this._gatherSp.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._gatherSp.onRemove(), this._gatherSp.parent.removeChild(this._gatherSp), this._gatherSp = null), this.onOpenWnd()
    }, t.prototype.onOpenWnd = function () {
        console.log("打开弹窗"), null == this._cardSp && (this._cardSp = new CardSp, this._cardSp.onAddCard(4, this._gatherX, this._gatherY), this._cardSp.alpha = 0, WndManager.root.addChild(this._cardSp), egret.Tween.get(this._cardSp).to({
            alpha: 1
        }, 500), this._cardSp.addEventListener("onNextScene", this.onNextScene, this))
    }, t.prototype.onNextScene = function (e) {
        this._cardSp.removeEventListener("onNextScene", this.onNextScene, this), egret.Tween.removeTweens(this._npcMovieSp), this._npcMovieSp.onStop(), this._npcMovieSp._roleTimer = 0, this._npcMovieSp._frameNum = 8, this._npcMovieSp.onPlay(), egret.startTick(this.onNextEvent, this)
    }, t.prototype.onMoveEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 1)) {
            if (this._showIndex++, this._showIndex >= 305) return null != this._gatherSp && this._gatherSp.onAddClick(), egret.stopTick(this.onMoveEvent, this), egret.Tween.get(this._npcMovieSp, {
                loop: !0
            }).to({
                y: this._npcMovieSp.y - 15
            }, 1e3).to({
                y: this._npcMovieSp.y
            }, 1e3), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.onNextEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 2)) {
            if (this._showIndex++, this._showIndex >= this._data.length) return egret.stopTick(this.onNextEvent, this), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(Scene5Wnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = -this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.Destroy = function () {
        null != this._scene4luweiSp && (this._scene4luweiSp.onRemove(), this._scene4luweiSp.parent.removeChild(this._scene4luweiSp), this._scene4luweiSp = null), null != this._npcMovieSp && (egret.stopTick(this.onMoveEvent, this), this._npcMovieSp.onStop(), this._npcMovieSp.parent.removeChild(this._npcMovieSp), this._npcMovieSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(Scene4Wnd.prototype, "Scene4Wnd");
var Scene5Wnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._scene5_bg = null, t._scene5_star = null, t._scene5_bg1 = null, t._scene_cao0 = null, t._scene_cao1 = null, t._scene_cao2 = null, t._scene5_bg2 = null, t._cardSp = null, t._gatherSp = null, t._gatherX = 0, t._gatherY = 0, t._currentIndex = 0, t._showIndex = 0, t._npcMovieSp = null, t._data = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        WndManager.root.onAddPetals(), this._scene5_bg = MyUtils.createImageByName("scene5_bg_png", 750, 1448, 0, 0), this.addChild(this._scene5_bg), this._scene5_star = MyUtils.createImageByName("scene5_star_png", 750, 832, 0, 0), this.addChild(this._scene5_star), egret.Tween.get(this._scene5_star, {
            loop: !0
        }).to({
            alpha: .3
        }, 1200).to({
            alpha: 1
        }, 1200), this._scene5_bg1 = MyUtils.createImageByName("scene5_bg1_png", 750, 892, 0, 556), this.addChild(this._scene5_bg1), this._scene_cao0 = MyUtils.createImageByName("scene_cao0_png", 558, 234, 13, 1204), this.addChild(this._scene_cao0), egret.Tween.get(this._scene_cao0, {
            loop: !0
        }).to({
            alpha: .5,
            y: 1214
        }, 2e3).to({
            alpha: 1,
            y: 1204
        }, 2e3), this._scene_cao1 = MyUtils.createImageByName("scene_cao1_png", 558, 165, 120, 1283), this.addChild(this._scene_cao1), egret.Tween.get(this._scene_cao1, {
            loop: !0
        }).to({
            alpha: .5,
            y: 1273
        }, 2e3).to({
            alpha: 1,
            y: 1283
        }, 2e3), this._scene_cao2 = MyUtils.createImageByName("scene_cao2_png", 265, 55, 275, 1218), this.addChild(this._scene_cao2), egret.Tween.get(this._scene_cao2, {
            loop: !0
        }).to({
            alpha: .5,
            y: 1225
        }, 2e3).to({
            alpha: 1,
            y: 1218
        }, 2e3), this._scene5_bg2 = MyUtils.createImageByName("scene5_bg2_png", 750, 1448, 0, 0, "c_c"), this.addChild(this._scene5_bg2), egret.Tween.get(this._scene5_bg2, {
            loop: !0
        }).to({
            scaleX: 1.02
        }, 1e3).to({
            scaleX: 1
        }, 1e3), this._currentIndex = 0, this._showIndex = 0, this._data = config_json.scene5data, this._npcMovieSp = new NpcMovieSp, this._npcMovieSp.addRole(), this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp._frameNum = 10, this._npcMovieSp.onPlay(), this.addChild(this._npcMovieSp), this._npcMovieSp.touchEnabled = !1, this._gatherSp = new GatherSp, this._gatherSp.onAddGather(), this._gatherSp.x = this._data[305].x, this._gatherSp.y = this._data[305].y, this.addChild(this._gatherSp), egret.startTick(this.onMoveEvent, this), this._gatherSp.touchEnabled = !0, this._gatherSp.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this)
    }, t.prototype.onGatherTap = function (e) {
        void 0 === e && (e = null), null != this._gatherSp && (onAddEvent("clickEvent", "gather", "skip1"), this._gatherX = this._gatherSp.x, this._gatherY = this._gatherSp.y, this._gatherSp.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onGatherTap, this), this._gatherSp.onRemove(), this._gatherSp.parent.removeChild(this._gatherSp), this._gatherSp = null), this.onOpenWnd()
    }, t.prototype.onOpenWnd = function () {
        console.log("打开弹窗"), null == this._cardSp && (this._cardSp = new CardSp, this._cardSp.onAddCard(5, this._gatherX, this._gatherY), this._cardSp.alpha = 0, WndManager.root.addChild(this._cardSp), egret.Tween.get(this._cardSp).to({
            alpha: 1
        }, 500), this._cardSp.addEventListener("onNextScene", this.onNextScene, this))
    }, t.prototype.onNextScene = function (e) {
        this._cardSp.removeEventListener("onNextScene", this.onNextScene, this), egret.Tween.removeTweens(this._npcMovieSp), this._npcMovieSp.onStop(), this._npcMovieSp._roleTimer = 0, this._npcMovieSp._frameNum = 8, this._npcMovieSp.onPlay(), egret.startTick(this.onNextEvent, this)
    }, t.prototype.onMoveEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 1)) {
            if (this._showIndex++, this._showIndex >= 305) return null != this._gatherSp && this._gatherSp.onAddClick(), egret.stopTick(this.onMoveEvent, this), egret.Tween.get(this._npcMovieSp, {
                loop: !0
            }).to({
                y: this._npcMovieSp.y - 15
            }, 1e3).to({
                y: this._npcMovieSp.y
            }, 1e3), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.onNextEvent = function () {
        if (null != this._npcMovieSp && (this._currentIndex++, this._currentIndex >= 2)) {
            if (this._showIndex++, this._showIndex >= this._data.length) return egret.stopTick(this.onNextEvent, this), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(ComTransitionWnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA), !1;
            this._npcMovieSp.x = this._data[this._showIndex].x, this._npcMovieSp.y = this._data[this._showIndex].y, this._npcMovieSp.scaleX = this._data[this._showIndex].sX, this._npcMovieSp.scaleY = this._data[this._showIndex].sY, this._npcMovieSp.rotation = this._data[this._showIndex].r, this._currentIndex = 0
        }
        return !1
    }, t.prototype.Destroy = function () {
        null != this._npcMovieSp && (egret.stopTick(this.onMoveEvent, this), this._npcMovieSp.onStop(), this._npcMovieSp.parent.removeChild(this._npcMovieSp), this._npcMovieSp = null), this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(Scene5Wnd.prototype, "Scene5Wnd");
var ShareWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._share_txt = null, t._share_guide = null, t._bg = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        onBiLogClick("ComPage", "shareClick", ""), this._bg = DrawGraphics.onDrawGraphicsSquare(0, 0, 750, 1448, 0, .78, !0), this.addChild(this._bg), this._share_txt = MyUtils.createImageByName("share_txt_png", 346, 30, 202, 335), this.addChild(this._share_txt), this._share_guide = MyUtils.createImageByName("share_guide_png", 100, 135, 509, WndManager.root._upDot + 58), this.addChild(this._share_guide), egret.Tween.get(this._share_guide, {
            loop: !0
        }).to({
            y: WndManager.root._upDot + 48
        }, 1e3).to({
            y: WndManager.root._upDot + 58
        }, 1e3), this._bg.addEventListener(egret.TouchEvent.TOUCH_TAP, this.onRemoveShare, this)
    }, t.prototype.onRemoveShare = function (e) {
        this._bg.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onRemoveShare, this), config_json.getCodeBol || ("null" == WndManager.root._prop._codeStr || null == WndManager.root._prop._codeStr) && (WndManager.root._prop._codeStr = "888", writeCookie("yscdk", "888", 88888));
        var i = new CodeSp;
        i.onAddCode(), WndManager.root.addChild(i), WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(ShareWnd.prototype, "ShareWnd");
var TransitionWnd = function (e) {
    function t() {
        var t = e.call(this) || this;
        return t._transition_bg = null, t._transition_bg1 = null, t._transition_info0 = null, t._transition_info1 = null, t._transition_info2 = null, t._transition_info3 = null, t._transition_nextBtn = null, t._transition_nextBtn2 = null, t._loading_logo = null, t._transition_hd = null, t.createOkCurrent(), t
    }
    return __extends(t, e), t.prototype.createOkCurrent = function () {
        var e = this;
        this._transition_bg = MyUtils.createImageByName("transition_bg_png", 750, 1448, 0, 0), this.addChild(this._transition_bg), this._transition_bg1 = MyUtils.createImageByName("transition_bg1_png", 750, 1448, 0, 0), this.addChild(this._transition_bg1), egret.Tween.get(this._transition_bg1, {
            loop: !0
        }).to({
            alpha: .5
        }, 1e3).to({
            alpha: 1
        }, 1e3), this._transition_info0 = MyUtils.createImageByName("transition_info0_png", 170, 54, 291, 424), this._transition_info0.alpha = 0, this.addChild(this._transition_info0), egret.Tween.get(this._transition_info0).wait(800).to({
            alpha: 1,
            y: 414
        }, 1e3).call(function () {
            e._transition_info1 = MyUtils.createImageByName("transition_info1_png", 171, 54, 289, 509), e._transition_info1.alpha = 0, e.addChild(e._transition_info1), egret.Tween.get(e._transition_info1).to({
                alpha: 1,
                y: 499
            }, 1e3).call(function () {
                e._transition_info2 = MyUtils.createImageByName("transition_info2_png", 290, 54, 229, 594), e._transition_info2.alpha = 0, e.addChild(e._transition_info2), egret.Tween.get(e._transition_info2).to({
                    alpha: 1,
                    y: 584
                }, 1e3).call(function () {
                    e._transition_info3 = MyUtils.createImageByName("transition_info3_png", 409, 54, 170, 679), e._transition_info3.alpha = 0, e.addChild(e._transition_info3), egret.Tween.get(e._transition_info3).to({
                        alpha: 1,
                        y: 669
                    }, 1e3).call(function () {
                        e._transition_nextBtn = MyUtils.createImageByName("transition_nextBtn_png", 232, 73, 259, 868, "c_c"), e._transition_nextBtn.alpha = 0, e.addChild(e._transition_nextBtn), egret.Tween.get(e._transition_nextBtn).to({
                            alpha: 1
                        }, 1e3).call(function () {
                            e._transition_nextBtn2 = MyUtils.createImageByName("transition_nextBtn_png", 232, 73, 259, 868, "c_c"), e._transition_nextBtn2.touchEnabled = !1, e.addChild(e._transition_nextBtn2), egret.Tween.get(e._transition_nextBtn2, {
                                loop: !0
                            }).wait(2e3).to({
                                scaleX: 1.3,
                                scaleY: 1.3,
                                alpha: 0
                            }, 500), e._transition_nextBtn.addEventListener(egret.TouchEvent.TOUCH_TAP, e.onNextTap, e)
                        }, e)
                    }, e)
                }, e)
            }, e)
        }, this), this._transition_hd = new LoadingHudieMovieSp, this._transition_hd.addRole(), this._transition_hd.x = 200, this._transition_hd.y = 1095, this._transition_hd.onPlay(), this.addChild(this._transition_hd), egret.Tween.get(this._transition_hd, {
            loop: !0
        }).to({
            y: 1075
        }, 1e3).to({
            y: 1095
        }, 1e3), this._loading_logo = MyUtils.createImageByName("loading_logo_png", 400, 58, 22, 127), this.addChild(this._loading_logo)
    }, t.prototype.onNextTap = function (e) {
        var i = this;
        this._transition_nextBtn.removeEventListener(egret.TouchEvent.TOUCH_TAP, this.onNextTap, this), egret.Tween.removeTweens(this._transition_nextBtn), egret.Tween.removeTweens(this._transition_nextBtn2), this._transition_nextBtn2.visible = !1, this._transition_nextBtn.scaleX = this._transition_nextBtn.scaleY = 1, this._transition_nextBtn.rotation = 0, egret.Tween.get(this._transition_nextBtn).to({
            scaleX: .8,
            scaleY: .8
        }, 100).to({
            scaleX: 1,
            scaleY: 1
        }, 100).call(function () {
            egret.Tween.get(i._transition_nextBtn).to({
                alpha: 0
            }, 500), egret.Tween.removeTweens(i._transition_hd), egret.Tween.get(i._transition_hd).to({
                alpha: 0
            }, 1e3).call(function () {
                WndManager.switchWnd(t, WIN_OPERATOR.WIN_CLOSE_DELETE, WIN_EFFECT.EFFECT_WIN_CLOSE_ALPHA), WndManager.switchWnd(Scene1Wnd, WIN_OPERATOR.WIN_OPEN_NEW, WIN_EFFECT.EFFECT_WIN_OPEN_ALPHA)
            }, i)
        }, this)
    }, t.prototype.Destroy = function () {
        this.parent && this.parent.removeChild(this)
    }, t
}(WinBase);
__reflect(TransitionWnd.prototype, "TransitionWnd");
F