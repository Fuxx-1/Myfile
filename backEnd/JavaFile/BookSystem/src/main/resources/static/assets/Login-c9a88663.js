import{_ as V,u as x,r as d,n as k,a as n,o as z,h as N,i as U,b as e,l as m,w as s,d as _,e as B,E as l}from"./index-ca6a7fa3.js";const E={class:"main"},L={class:"avatar"},R={__name:"Login",setup(S){const i=x(),f=d({circleUrl:"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png",size:"large"}),{circleUrl:g,size:w}=k(f),o=d({name:"",password:""}),y=()=>{B.post("/user/login",JSON.stringify(o),{headers:{"Content-Type":"application/json"}}).then(t=>{t.code==0?(l({type:"success",showClose:!0,message:"登录成功"}),i.push("/")):(l({type:"error",showClose:!0,message:t.msg}),console.error(t))}).catch(t=>{l({type:"error",showClose:!0,message:"登录失败"}),console.error(t)})},b=()=>{i.push("/register")},h=()=>{o.name="",o.password="",l({duration:1e3,type:"warning",showClose:!0,message:"清除成功"})};return(t,a)=>{const C=n("el-avatar"),u=n("el-input"),r=n("el-form-item"),c=n("el-button"),v=n("el-form");return z(),N("div",E,[U("div",L,[e(C,{size:m(w),src:m(g)},null,8,["size","src"])]),e(v,{model:o,"label-width":"75px",style:{padding:"20px"}},{default:s(()=>[e(r,{label:"用户名"},{default:s(()=>[e(u,{modelValue:o.name,"onUpdate:modelValue":a[0]||(a[0]=p=>o.name=p)},null,8,["modelValue"])]),_:1}),e(r,{label:"密码"},{default:s(()=>[e(u,{modelValue:o.password,"onUpdate:modelValue":a[1]||(a[1]=p=>o.password=p),type:"password"},null,8,["modelValue"])]),_:1}),e(r,null,{default:s(()=>[e(c,{type:"primary",onClick:y},{default:s(()=>[_("登录")]),_:1}),e(c,{onClick:b},{default:s(()=>[_("注册")]),_:1}),e(c,{type:"info",onClick:h},{default:s(()=>[_("清除")]),_:1})]),_:1})]),_:1},8,["model"])])}}},j=V(R,[["__scopeId","data-v-9c0b786c"]]);export{j as default};
