<template>
    <el-form :model="form" label-width="75px" class="form">
        <el-form-item label="旧密码">
            <el-input v-model="form.password" type="password" />
        </el-form-item>
        <el-form-item label="新密码">
            <el-input v-model="form.newPassword" type="password" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">更新</el-button>
            <el-button type="info" @click="onClear">清除</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup>
import api from '../../request';
import { ElMessage } from 'element-plus'
import { ref, reactive, toRefs } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
// 数据部分
const form = reactive({
    password: '',
    newPassword: ''
})
// 点击行为
// 提交
const onSubmit = () => {
    api.put("/user", JSON.stringify(form), { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '更新成功',
                })
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
                message: '更新失败',
            })
            console.error(error);
        });
}
const onClear = () => {
    form.password = ''
    form.newPassword = ''
    ElMessage({
        duration: 1000,
        type: 'warning',
        showClose: true,
        message: '清除成功',
    })
}
</script>

<style scoped>
.form {
    padding: 70px;
    width: 700px;
}
</style>