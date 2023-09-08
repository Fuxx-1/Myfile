import { createRouter, createWebHashHistory } from 'vue-router'
import api from "../request"
import { defineAsyncComponent } from 'vue'

const childRoutes = [
    {
        path: 'updateUser',
        component: () => import('../components/User/UpdateUser.vue')
    },
    {
        path: 'updatePassword',
        component: () => import('../components/User/UpdatePassword.vue')
    },
    {
        path: 'search',
        component: () => import('../components/Book/Search.vue')
    },
    {
        path: 'searchById',
        component: () => import('../components/Book/SearchById.vue')
    },
    {
        path: 'updateById',
        component: () => import('../components/Book/UpdateById.vue')
    },
    {
        path: 'delete',
        component: () => import('../components/Book/Delete.vue')
    },
    {
        path: 'add',
        component: () => import('../components/Book/Add.vue')
    }
]
const routes = [
    {
        path: '/home',
        name: 'home',
        component: defineAsyncComponent(() => import('../views/Home.vue')),
        meta: {
            title: '首页'
        },
        children: childRoutes
        // [
        //     {
        //         path: 'updateUser',
        //         component: () => import('../components/User/UpdateUser.vue')
        //     },
        //     {
        //         path: 'updatePassword',
        //         component: () => import('../components/User/UpdatePassword.vue')
        //     },
        //     {
        //         path: 'search',
        //         component: () => import('../components/Book/Search.vue')
        //     },
        //     {
        //         path: 'searchById',
        //         component: () => import('../components/Book/SearchById.vue')
        //     },
        //     {
        //         path: 'updateById',
        //         component: () => import('../components/Book/UpdateById.vue')
        //     },
        //     {
        //         path: 'delete',
        //         component: () => import('../components/Book/Delete.vue')
        //     },
        //     {
        //         path: 'add',
        //         component: () => import('../components/Book/Add.vue')
        //     }
        // ]
    },
    {
        path: '/login',
        name: 'login',
        component: defineAsyncComponent(() => import('../views/Login.vue')),
    },
    {
        path: '/register',
        name: 'register',
        component: defineAsyncComponent(() => import('../views/Register.vue')),
    },
    {
        path: '/',
        redirect: '/home',
    },
]


const router = createRouter({
    history: createWebHashHistory(),
    routes
})

router.beforeEach((to, from) => {
    if (to.name != 'register') {
        api.get("/test").then((data) => {
            if (data.code != 0) {
                router.push('/login')
            }
        }).catch(() => {
            router.push('/login')
        })
    }
})

export default router