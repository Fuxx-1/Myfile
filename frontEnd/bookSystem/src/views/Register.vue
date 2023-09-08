<template>
    <div class="main">
        <el-form :model="form" label-width="75px" style="padding: 20px;">
            <el-form-item label="用户名">
                <el-input v-model="form.name" />
            </el-form-item>
            <el-form-item label="密码">
                <el-input v-model="form.password" type="password" />
            </el-form-item>
            <el-form-item label="备注">
                <el-input v-model="form.moreInfo" />
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="onSubmit">注册</el-button>
                <el-button @click="toLogin">登录</el-button>
                <el-button type="info" @click="onClear">清除</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script setup>
import api from '../request';
import { ElMessage } from 'element-plus'
import { ref, reactive } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = reactive({
    name: '',
    password: '',
    moreInfo: ''
})
const onSubmit = () => {
    api.post("/user/sign", JSON.stringify(form), { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '注册成功',
                })
                router.push("/login/")
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
                message: '注册失败',
            })
            console.error(error);
        });
}
const toLogin = () => {
    router.push('/login')
}
const onClear = () => {
    form.name = ''
    form.password = ''
    form.moreInfo = ''
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