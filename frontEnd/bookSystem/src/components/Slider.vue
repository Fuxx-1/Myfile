<template>
    <el-menu :default-active="activeIndex2" class="slide" mode="vertical" router background-color="#545c64"
        text-color="#fff" active-text-color="#ffd04b">
        <el-sub-menu index="1">
            <template #title>用户信息更新</template>
            <el-menu-item index="/home/updateUser">更新信息</el-menu-item>
            <el-menu-item index="/home/updatePassword">更新密码</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="2">
            <template #title>图书管理</template>
            <el-menu-item index="/home/search">图书查询</el-menu-item>
            <el-menu-item index="/home/add">添加</el-menu-item>
            <el-menu-item index="/home/searchById" disabled>图书id查询</el-menu-item>
            <el-menu-item index="/home/updateById" disabled>更新</el-menu-item>
            <el-menu-item index="/home/delete" disabled>删除</el-menu-item>
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
