<template>
    <el-form :model="form" label-width="100px" class="form">
        <el-row :gutter="20">
            <el-col :span="15">
                <el-form-item label="关键字搜索">
                    <el-input v-model="form.name" />
                </el-form-item></el-col>
            <el-col :span="5">
                <el-form-item label="页大小">
                    <el-input v-model="form.size" />
                </el-form-item>
            </el-col>
        </el-row>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">查询</el-button>
            <el-button @click="onClear">清除关键字</el-button>
        </el-form-item>
    </el-form>
    <el-table :data="tableData" class="table">
        <el-table-column fixed prop="id" label="id" width="50" />
        <el-table-column prop="name" label="Name" width="200" />
        <el-table-column prop="price" label="Price" width="100" />
        <el-table-column prop="margin" label="Margin" width="100" />
        <el-table-column prop="createId" label="CreateId" width="100" />
        <el-table-column prop="createTime" label="create" width="200">
            <template #default="{ row }">
                {{ formatLocalDateTime(row.createTime) }}
            </template>
        </el-table-column>
        <el-table-column prop="updateTime" label="update" width="200">
            <template #default="{ row }">
                {{ formatLocalDateTime(row.updateTime) }}
            </template>
        </el-table-column>
        <el-table-column fixed="right" label="Operations" width="200">
            <template #default="scope">
                <el-button link type="primary" size="small" @click.prevent="getRowDetail(scope.$index)">
                    Detail
                </el-button>
                <el-button link type="primary" size="small" @click.prevent="updateRow(scope.$index)">
                    Update
                </el-button>
                <el-button link type="primary" size="small" @click.prevent="removeRow(scope.$index)">
                    Remove
                </el-button>
            </template>
        </el-table-column>
    </el-table>
    <div class="page">
        <el-row :gutter="20">
            <el-col :span="15" class="col">
                <el-text class="customText">第</el-text>
                <el-input class="num" v-model="form.page" />
                <el-text class="customText">页</el-text>
                <el-text class="customText">/</el-text>
                <el-text class="customText">每页</el-text>
                <el-input class="num" v-model="form.size" />
                <el-text class="lastText">个</el-text>
                <el-button @click="onClear">跳转</el-button>
                <el-button type="primary" @click="nextPage(-1)" :disabled="disableFrontPage">上一页</el-button>
                <el-button type="primary" @click="nextPage(1)" :disabled="disableNextPage">下一页</el-button>
                <el-button class="mt-4 button" @click="onAddItem" type="info" plain>增加一项</el-button>
            </el-col>
        </el-row>
    </div>
</template>
  
<script setup>
import api from '../../request';
import { computed, ref, reactive, resolveDirective, watch } from 'vue'
import { ElMessage } from 'element-plus'
import dayjs from 'dayjs'
import { useRouter } from 'vue-router'
const router = useRouter()
const now = new Date()
const disableFrontPage = ref(true);
const disableNextPage = ref(false);
const form = reactive({
    "name": "",
    "page": 1,
    "size": 5
})
const tableData = ref([
    {},
])
const formDTO = {
    "name": null,
    "offset": 1,
    "size": 5,
    updateWith(para) {
        this.name = para.name;
        this.offset = (parseInt(para.page) - 1) * parseInt(para.size);
        this.size = parseInt(para.size);
        return this
    }
}

const getRowDetail = (index) => {
    let data = tableData.value[index]
    router.push({ path: '/home/searchById', query: { id: data.id } })
}

const updateRow = (index) => {
    let data = tableData.value[index]
    router.push({ path: '/home/updateById', query: { id: data.id } })
}

const removeRow = (index) => {
    let data = tableData.value[index]
    router.push({ path: '/home/delete', query: { id: data.id } })
}

const onAddItem = () => {
    router.push('/home/add')
}

const onSubmit = () => {
    api.post("/book/query", JSON.stringify(formDTO.updateWith(form)), { headers: { 'Content-Type': 'application/json' } })
        .then(data => {
            if (data.code == 0) {
                // console.log(data.data);
                tableData.value = data.data.bookInfos
                ElMessage({
                    type: 'success',
                    showClose: true,
                    message: '查询成功',
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
                message: '查询失败',
            })
            console.error(error);
        });
}


watch(tableData, async () => {
    if (form.page > 1) disableFrontPage.value = false;
    else disableFrontPage.value = true;
    if (form.size == tableData.value.length) {
        disableNextPage.value = false;
    } else {
        disableNextPage.value = true;
    }
})

const nextPage = (offset) => {
    form.page += offset;
    if (form.page < 1) {
        form.page = 1
        ElMessage({
            type: 'warning',
            duration: 1000,
            showClose: true,
            message: '已经是第一页了',
        })
    } else {
        onSubmit();
    }
}

const onClear = () => {
    form.name = ''
    ElMessage({
        duration: 1000,
        type: 'warning',
        showClose: true,
        message: '清除成功',
    })
}

const formatLocalDateTime = (timestamp) => {
    return dayjs(timestamp).format("YYYY-MM-DD HH:mm:ss");
}
onSubmit();
</script>

<style lang="less" scoped>
.form {
    padding: 70px 70px 0px 70px;
    max-width: calc(100vw - 185px);
}

.table {
    max-width: calc(100vw - 185px);
    padding: 0px 70px 0px 70px;
    /* max-height: 250; */
}

.page {
    padding: 20px 70px;
    max-width: calc(100vw - 185px);
}

.num {
    width: 50px;
}

.customText {
    padding: 0px 5px;
}

.lastText {
    padding: 0px 20px 0 5px;
}
</style>