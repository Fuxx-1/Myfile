<template>
    <div :model="main" class="main">
        <div style="padding: 50px;">
            <el-button @click="main.isStart = !main.isStart;">开关</el-button>&nbsp;&nbsp;&nbsp;
            <input type="color" v-model="main.color" />
        </div>
        <div style="padding: 50px;">
            <div class="light" :style="{ 'background-color': main.isStart ? main.color : '#000' }"></div>
        </div>
    </div>
</template>

<script setup>
import { ref, reactive } from 'vue'
let main = reactive({
    isStart: false,
    color: '#ffff00'
})
</script>

<style scoped lang="less">
.main {
    width: 100%;
    height: 700px;
    margin: 0 auto;
    padding: 50px;

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