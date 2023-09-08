<template>
    <el-form :model="form" label-width="50px" style="padding: 70px;">
        <el-form-item label="书名">
            <el-input v-model="form.name" />
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
        <el-form-item label="图片">
            <el-upload class="upload-demo" drag style="width: 100%;" action="http://127.0.0.1:8080/file"
                name="multipartFile" :on-success="handleSuccess" :on-error="handleError" auto-upload :limit="1"
                :auto-upload="false" :before-upload="beforeUpload">
                <el-icon class="el-icon--upload"><upload-filled /></el-icon>
                <div class="el-upload__text">
                    Drop file here or <em>click to upload</em>
                </div>
                <template #tip>
                    <div class="el-upload__tip">
                        jpg/png files with a size less than 5mb
                    </div>
                </template>
            </el-upload>


            <!-- <el-input v-model="form.picture" /> -->
        </el-form-item>
        <el-form-item label="作者">
            <el-input v-model="form.author" />
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">创建</el-button>
            <el-button type="info" @click="onClear">清除</el-button>
        </el-form-item>
    </el-form>
</template>

<script setup>
import api from '../../request';
import { ElMessage } from 'element-plus'
import { ref, reactive, toRefs } from 'vue'
import { UploadFilled } from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
const router = useRouter()
// do not use same name with ref
const form = reactive({
    name: '',
    price: '',
    margin: '',
    detail: '',
    picture: '',
    author: ''
})

const onSubmit = () => {
    api.post("/book", JSON.stringify(form), { headers: { 'Content-Type': 'application/json' } })
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
    form.name = ''
    form.price = ''
    form.margin = ''
    form.detail = ''
    form.picture = ''
    form.author = ''
    ElMessage({
        duration: 1000,
        type: 'warning',
        showClose: true,
        message: '清除成功',
    })
}
const handleSuccess = (response, file, fileList) => {
    form.picture = response.data;
    ElMessage({
        type: 'success',
        showClose: true,
        message: '上传成功',
    })
}
const handleError = (err, file, fileList) => {
    ElMessage({
        type: 'success',
        showClose: true,
        message: '上传失败',
    })
}
const beforeUpload = (file) => {
    // 在上传之前执行的操作，例如大小限制和文件类型检查
    console.log(file.length)
}
</script>

<style scoped lang="less"></style>