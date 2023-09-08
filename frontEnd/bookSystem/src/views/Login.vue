<template>
    <div class="main">
        <div class="avatar">
            <el-avatar :size="size" :src="circleUrl" />
        </div>
        <el-form :model="form" label-width="75px" style="padding: 20px;">
            <el-form-item label="用户名">
                <el-input v-model="form.name" />
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password" type="password" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">登录</el-button>
                <el-button @click="toRegister">注册</el-button>
                <el-button type="info" @click="onClear">清除</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script setup>
import api from '../request';
import { ElMessage } from 'element-plus'
import { ref, reactive, toRefs } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
// 头像部分
const state = reactive({
    circleUrl:
        'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
    size: 'large',
})
const { circleUrl, size } = toRefs(state)
// 数据部分
const form = reactive({
    name: '',
    password: ''
})
// 点击行为
// 提交
const onSubmit = () => {
    api.post("/user/login", JSON.stringify(form), { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '登录成功',
                })
                router.push("/")
            } else {
                ElMessage({
                    type: 'error',
                    showClose: true,
                    message: data.msg,
                })
                console.error(data);
            }
        })
        .catch(error => {
            ElMessage({
                type: 'error',
                showClose: true,
                message: '登录失败',
            })
            console.error(error);
        });
}
const toRegister = () => {
    router.push('/register')
}
// 清除
const onClear = () => {
    form.name = ''
    form.password = ''
    ElMessage({
        duration: 1000,
        type: 'warning',
        showClose: true,
        message: '清除成功',
    })
}
</script>

<style scoped>
.main {
    width: 500px;
    height: 280px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
}

.avatar {
    width: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
}
</style>