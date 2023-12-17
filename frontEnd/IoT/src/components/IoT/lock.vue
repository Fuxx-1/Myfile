<template>
    <div :model="main" class="main">
        <div style="padding: 50px;">
            <el-button @click="main.isStart = !main.isStart;">开关</el-button>
            <el-button @click="open()">指纹开锁</el-button>
            <el-button @click="open()">面容开锁</el-button>
            <el-button @click="open()">掌纹开锁</el-button>
            <el-button @click="open()">密码开锁</el-button>
        </div>
        <div style="padding: 50px;">
            <div v-if="main.isStart" class="windows">
                <img src=".\static\door-o.jpg" alt="" srcset="">
            </div>
            <div v-if="!main.isStart" class="windows">
                <img src=".\static\door-c.jpg" alt="" srcset="">
            </div>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive } from 'vue'

let main = reactive({
    isStart: false,
})

function open() {
    main.isStart = true;
    setTimeout(() => {
        main.isStart = false;
    }, 3000);
}
</script>

<style scoped lang="less">
.main {
    width: 100%;
    height: 700px;
    margin: 0 auto;
    padding: 50px;
    // display: flex;
    // justify-content: center;
    // align-items: center;
}

.light {
    margin: 0 auto;
    text-align: center;
    width: 150px;
    height: 150px;
    border-radius: 5%;
    margin: 10px;
    filter: blur(3px);
}
</style>