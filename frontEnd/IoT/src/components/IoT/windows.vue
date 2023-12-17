<template>
    <div :model="main" class="main">
        <div style="padding: 50px;">
            <el-button @click="main.isStart = !main.isStart;">开关</el-button>
            <el-button @click="main.isStart = false">开始下雨</el-button>
            <el-button @click="main.isStart = true">停止下雨</el-button>
        </div>
        <div style="padding: 50px;">
            <div v-if="main.isStart" class="windows">
                <img src=".\static\WindowsOpen.jpg" alt="" srcset="" style="width: 200px;">
            </div>
            <div v-if="!main.isStart" class="windows">
                <img src=".\static\WindowsClose.jpg" alt="" srcset="" style="width: 200px;">
            </div>
        </div>
        <!-- <div style="padding: 50px;">
            <div class="windows">{{ main.isStart ? '窗户打开' : '窗户关闭' }}</div>
        </div> -->
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
</style>