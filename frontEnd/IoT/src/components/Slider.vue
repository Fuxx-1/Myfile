<template>
    <el-menu :default-active="activeIndex2" class="slide" mode="vertical" router background-color="#545c64"
        text-color="#fff" active-text-color="#ffd04b">
        <el-sub-menu index="1">
            <template #title>IoT</template>
            <el-menu-item index="/home/light">Light</el-menu-item>
            <el-menu-item index="/home/windows">windows</el-menu-item>
            <el-menu-item index="/home/lock">lock</el-menu-item>
            <el-menu-item index="/home/riceCooker">riceCooker</el-menu-item>
            <el-menu-item index="/home/airConditioner">airConditioner</el-menu-item>
            <el-menu-item index="/home/sweep">sweep</el-menu-item>
            <el-menu-item index="/home/curtain">curtain</el-menu-item>
            <el-menu-item index="/home/kitchenHood">kitchenHood</el-menu-item>

            <!-- <el-menu-item index="/home/updatePassword">Windows</el-menu-item> -->
        </el-sub-menu>
    </el-menu>
</template>

<script setup>

import { ref, reactive } from 'vue'

</script>

<style scoped>
.slide {
    height: 100%;
}
</style>
