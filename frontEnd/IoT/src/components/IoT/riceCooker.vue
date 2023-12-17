<template>
    <div :model="main" class="main">
        <div style="padding: 50px;">
            <el-button @click="main.isStart = !main.isStart;">开关</el-button>
            <el-button @click="main.isStart = !main.isStart;">开始煮饭</el-button>
        </div>
        <div style="padding: 50px;">
            <div class="windows">{{ main.isStart ? '窗帘打开' : '窗帘关闭' }}</div>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive } from 'vue'

let main = reactive({
    isStart: false,
})
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