<template>
    <el-form :model="form" label-width="130px" style="padding: 70px;">
        <el-form-item label="书籍id">
            <el-input v-model="form.id" disabled />
        </el-form-item>
        <el-form-item label="书名">
            <el-input v-model="form.name" />
        </el-form-item>
        <el-form-item label="作者">
            <el-input v-model="form.author" />
        </el-form-item>
        <el-form-item label="价格">
            <el-input v-model="form.price" />
        </el-form-item>
        <el-form-item label="库存">
            <el-input v-model="form.margin" />
        </el-form-item>
        <el-form-item label="详情">
            <el-input v-model="form.detail" type="textarea" />
        </el-form-item>
        <el-form-item label="创建者id">
            <el-input v-model="form.createId" disabled />
        </el-form-item>
        <el-form-item label="图片">
            <el-image class="image" :src="form.picture" fit="contain" />
        </el-form-item>
        <el-form-item label="主信息创建时间">
            <el-input :value="formatLocalDateTime(form.bookInfCreateTime)" disabled />
        </el-form-item>
        <el-form-item label="主信息更新时间">
            <el-input :value="formatLocalDateTime(form.bookInfUpdateTime)" disabled />
        </el-form-item>
        <el-form-item label="更多信息创建时间">
            <el-input :value="formatLocalDateTime(form.bookDetailCreateTime)" disabled />
        </el-form-item>
        <el-form-item label="更多信息更新时间">
            <el-input :value="formatLocalDateTime(form.bookDetailUpdateTime)" disabled />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">创建</el-button>
            <el-button>取消</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup>
import { ElMessage } from 'element-plus'
import { reactive } from 'vue'
import api from '../../request';
import dayjs from 'dayjs'
import { useRouter } from 'vue-router'
const router = useRouter()
// do not use same name with ref
let form = reactive({
    id: null,
    name: '',
    price: '',
    margin: '',
    detail: '',
    picture: '',
    author: ''
})

const onSubmit = () => {
    api.patch("/book", JSON.stringify(form), { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                // form = Object.assign(form, data.data)
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
const formatLocalDateTime = (timestamp) => {
    return dayjs(timestamp).format("YYYY-MM-DD HH:mm:ss");
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
} else {
    api.get("/book?id=" + form.id, { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                form = Object.assign(form, data.data)
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '查询成功',
                })
                form.picture = api.baseURL + 'file?hex=' + form.picture
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
                message: '查询失败',
            })
            console.error(error);
        });
}
</script>

<style scoped lang="less">
.image {
    width: 100px;
    height: 100px;
}
</style>