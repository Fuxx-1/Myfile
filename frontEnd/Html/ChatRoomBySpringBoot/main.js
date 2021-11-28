const {
    defineComponent,
    ref,
    h
} = Vue;
const {
    ElMessage
} = ElementPlus;

window.onload = function () {

    var Main = {

        setup() {
            const isCollapse = ref(true)
            const reload = () => {
                ElMessage({
                    message: '刷新页面',
                    type: "warning"
                });
                window.location.reload();

            }
            const handleOpen = (key, keyPath) => {
                console.log(key, keyPath);
            }
            const handleClose = (key, keyPath) => {
                console.log(key, keyPath);
            }
            return {
                reload,
                isCollapse,
                handleOpen,
                handleClose,
            }
        },
    };

    const app = Vue.createApp(Main);
    app.use(ElementPlus);
    app.mount("#app");
    ElMessage({
        message: '页面加载成功',
        type: "success"
    });
    
}