import{_ as w,u as y,r as C,a as r,o as V,h as b,b as o,w as s,d,e as h,E as u}from"./index-ca6a7fa3.js";const x={class:"main"},v={__name:"Register",setup(k){const _=y(),e=C({name:"",password:"",moreInfo:""}),i=()=>{h.post("/user/sign",JSON.stringify(e),{headers:{"Content-Type":"application/json"}}).then(t=>{t.code==0?(u({type:"success",showClose:!0,message:"注册成功"}),_.push("/login/")):(u({type:"error",showClose:!0,message:t.msg}),console.error(t))}).catch(t=>{u({type:"error",showClose:!0,message:"注册失败"}),console.error(t)})},c=()=>{_.push("/login")},f=()=>{e.name="",e.password="",e.moreInfo="",u({duration:1e3,type:"warning",showClose:!0,message:"清除成功"})};return(t,l)=>{const m=r("el-input"),a=r("el-form-item"),p=r("el-button"),g=r("el-form");return V(),b("div",x,[o(g,{model:e,"label-width":"75px",style:{padding:"20px"}},{default:s(()=>[o(a,{label:"用户名"},{default:s(()=>[o(m,{modelValue:e.name,"onUpdate:modelValue":l[0]||(l[0]=n=>e.name=n)},null,8,["modelValue"])]),_:1}),o(a,{label:"密码"},{default:s(()=>[o(m,{modelValue:e.password,"onUpdate:modelValue":l[1]||(l[1]=n=>e.password=n),type:"password"},null,8,["modelValue"])]),_:1}),o(a,{label:"备注"},{default:s(()=>[o(m,{modelValue:e.moreInfo,"onUpdate:modelValue":l[2]||(l[2]=n=>e.moreInfo=n)},null,8,["modelValue"])]),_:1}),o(a,null,{default:s(()=>[o(p,{type:"primary",onClick:i},{default:s(()=>[d("注册")]),_:1}),o(p,{onClick:c},{default:s(()=>[d("登录")]),_:1}),o(p,{type:"info",onClick:f},{default:s(()=>[d("清除")]),_:1})]),_:1})]),_:1},8,["model"])])}}},R=w(v,[["__scopeId","data-v-20fcff2a"]]);export{R as default};