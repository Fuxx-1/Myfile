import{_ as i,u as w,r as y,a as n,c as C,w as s,o as g,b as o,d as u,e as U,E as a}from"./index-ca6a7fa3.js";const V={__name:"UpdateUser",setup(b){w();const e=y({name:"",moreInfo:""}),c=()=>{U.patch("/user",JSON.stringify(e),{headers:{"Content-Type":"application/json"}}).then(t=>{t.code==0?a({type:"success",showClose:!0,message:"更新成功"}):(a({type:"error",showClose:!0,message:t.msg}),console.error(t))}).catch(t=>{a({type:"error",showClose:!0,message:"更新失败"}),console.error(t)})},d=()=>{e.password="",e.newPassword="",a({duration:1e3,type:"warning",showClose:!0,message:"清除成功"})};return(t,l)=>{const _=n("el-input"),r=n("el-form-item"),p=n("el-button"),f=n("el-form");return g(),C(f,{model:e,"label-width":"75px",class:"form"},{default:s(()=>[o(r,{label:"新用户名"},{default:s(()=>[o(_,{modelValue:e.name,"onUpdate:modelValue":l[0]||(l[0]=m=>e.name=m)},null,8,["modelValue"])]),_:1}),o(r,{label:"新备注"},{default:s(()=>[o(_,{modelValue:e.moreInfo,"onUpdate:modelValue":l[1]||(l[1]=m=>e.moreInfo=m)},null,8,["modelValue"])]),_:1}),o(r,null,{default:s(()=>[o(p,{type:"primary",onClick:c},{default:s(()=>[u("更新")]),_:1}),o(p,{type:"info",onClick:d},{default:s(()=>[u("清除")]),_:1})]),_:1})]),_:1},8,["model"])}}},x=i(V,[["__scopeId","data-v-3e11ee3f"]]);export{x as default};