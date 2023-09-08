<template>
    <el-form :model="form" label-width="75px" class="form">
        <el-form-item label="书籍id">
            <el-input v-model="form.id" disabled />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">删除</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup>
import api from '../../request';
import { ref, reactive } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()
const form = reactive({
    id: null
})
const onSubmit = () => {
    api.delete("/book?id=" + form.id)
        .then(data => {
            if (data.code == 0) {
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '删除成功',
                })
                router.push("/home/search")
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
                message: '删除失败',
            })
            console.error(error);
        });
}
let hurf = window.location.href.split('?')
if (hurf.length > 1) {
    let query = hurf[1].split('=')
    if (query.length % 2 === 0) {
        for (let i = 0; i < query.length; i += 2) {
            if (form[query[i]] !== undefined) {
                form[query[i]] = query[i + 1]
            }
        }
    }
}
const redirect = () => {
    ElMessage({
        type: 'warning',
        showClose: true,
        message: '请从该页面查询',
    })
    router.push("/home/search")
}
if (form.id === null) {
    redirect()
}
</script>

<style scoped lang="less">
.form {
    padding: 70px;
    width: 700px;
}

.button {
    margin-left: 20px;
}

.input {
    margin: 20px;
    max-width: 300px;
}
</style>
