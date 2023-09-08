<template>
    <div class="home">
        <div class="slider">
            <Slider />
        </div>
        <div class="box">
            <div class="header">
                BookSystem
            </div>
            <el-scrollbar class="content_box">
                <div class="content">
                    <router-view></router-view>
                </div>
            </el-scrollbar>
        </div>
    </div>
</template>

<script setup>
import Slider from '../components/Slider.vue';
// import { onBeforeRouteUpdate, onAfterRouteUpdate, useRouter } from 'vue-router';

</script>

<style scoped lang="less">
.home {
    width: 100%;
    max-height: 100vh;
    display: flex;
    overflow-y: hidden;
    overflow-x: hidden;
}

.slider {
    flex-basis: 175px;
    flex-shrink: 0;
    height: 100%;
}

.box {
    flex: 1;
    background-color: #f0f0f0;

    .header {
        width: 100%;
        height: 60px;
        background-color: #fff;
        line-height: 60px;
        text-align: center;
        font-weight: 800;
    }

    .content_box {
        padding: 15px 10px;
        box-sizing: border-box;
        max-height: calc(100vh - 60px);

        .content {
            width: 100%;
            height: 100%;
            background-color: #fff;
        }
    }
}
</style>