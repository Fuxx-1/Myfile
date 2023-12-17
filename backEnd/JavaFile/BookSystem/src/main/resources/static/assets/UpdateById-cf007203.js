import{_ as C,u as v,r as w,e as p,E as r,a as i,c as U,w as s,l as a,o as k,b as l,d as c,k as x}from"./index-ca6a7fa3.js";const I={__name:"UpdateById",setup(T){const b=v();let e=w({id:null,name:"",price:"",margin:"",detail:"",picture:"",author:""});const g=()=>{p.patch("/book",JSON.stringify(e),{headers:{"Content-Type":"application/json"}}).then(o=>{o.code==0?r({type:"success",showClose:!0,message:"更新成功"}):(r({type:"error",showClose:!0,message:o.msg}),console.error(o))}).catch(o=>{r({type:"error",showClose:!0,message:"更新失败"}),console.error(o)})};let f=window.location.href.split("?");if(f.length>1){let o=f[1].split("=");if(o.length%2===0)for(let t=0;t<o.length;t+=2)e[o[t]]!==void 0&&(e[o[t]]=o[t+1])}const m=o=>x(o).format("YYYY-MM-DD HH:mm:ss"),V=()=>{r({type:"warning",showClose:!0,message:"请从该页面查询"}),b.push("/home/search")};return e.id===null?V():p.get("/book?id="+e.id,{headers:{"Content-Type":"application/json"}}).then(o=>{o.code==0?(e=Object.assign(e,o.data),r({type:"success",showClose:!0,message:"查询成功"}),e.picture=p.baseURL+"file?hex="+e.picture):(r({type:"error",showClose:!0,message:o.msg}),console.error(o))}).catch(o=>{r({type:"error",showClose:!0,message:"查询失败"}),console.error(o)}),(o,t)=>{const d=i("el-input"),n=i("el-form-item"),y=i("el-image"),_=i("el-button"),h=i("el-form");return k(),U(h,{model:a(e),"label-width":"130px",style:{padding:"70px"}},{default:s(()=>[l(n,{label:"书籍id"},{default:s(()=>[l(d,{modelValue:a(e).id,"onUpdate:modelValue":t[0]||(t[0]=u=>a(e).id=u),disabled:""},null,8,["modelValue"])]),_:1}),l(n,{label:"书名"},{default:s(()=>[l(d,{modelValue:a(e).name,"onUpdate:modelValue":t[1]||(t[1]=u=>a(e).name=u)},null,8,["modelValue"])]),_:1}),l(n,{label:"作者"},{default:s(()=>[l(d,{modelValue:a(e).author,"onUpdate:modelValue":t[2]||(t[2]=u=>a(e).author=u)},null,8,["modelValue"])]),_:1}),l(n,{label:"价格"},{default:s(()=>[l(d,{modelValue:a(e).price,"onUpdate:modelValue":t[3]||(t[3]=u=>a(e).price=u)},null,8,["modelValue"])]),_:1}),l(n,{label:"库存"},{default:s(()=>[l(d,{modelValue:a(e).margin,"onUpdate:modelValue":t[4]||(t[4]=u=>a(e).margin=u)},null,8,["modelValue"])]),_:1}),l(n,{label:"详情"},{default:s(()=>[l(d,{modelValue:a(e).detail,"onUpdate:modelValue":t[5]||(t[5]=u=>a(e).detail=u),type:"textarea"},null,8,["modelValue"])]),_:1}),l(n,{label:"创建者id"},{default:s(()=>[l(d,{modelValue:a(e).createId,"onUpdate:modelValue":t[6]||(t[6]=u=>a(e).createId=u),disabled:""},null,8,["modelValue"])]),_:1}),l(n,{label:"图片"},{default:s(()=>[l(y,{class:"image",src:a(e).picture,fit:"contain"},null,8,["src"])]),_:1}),l(n,{label:"主信息创建时间"},{default:s(()=>[l(d,{value:m(a(e).bookInfCreateTime),disabled:""},null,8,["value"])]),_:1}),l(n,{label:"主信息更新时间"},{default:s(()=>[l(d,{value:m(a(e).bookInfUpdateTime),disabled:""},null,8,["value"])]),_:1}),l(n,{label:"更多信息创建时间"},{default:s(()=>[l(d,{value:m(a(e).bookDetailCreateTime),disabled:""},null,8,["value"])]),_:1}),l(n,{label:"更多信息更新时间"},{default:s(()=>[l(d,{value:m(a(e).bookDetailUpdateTime),disabled:""},null,8,["value"])]),_:1}),l(n,null,{default:s(()=>[l(_,{type:"primary",onClick:g},{default:s(()=>[c("创建")]),_:1}),l(_,null,{default:s(()=>[c("取消")]),_:1})]),_:1})]),_:1},8,["model"])}}},D=C(I,[["__scopeId","data-v-0fd8b943"]]);export{D as default};