import{_ as v,u as C,r as U,e as b,E as m,a as i,c as h,w as o,l as t,o as I,b as l,d as _,k as T}from"./index-ca6a7fa3.js";const w={__name:"SearchById",setup(x){const c=C();let e=U({id:null,name:"",picture:"",author:"",price:"",createId:null,detail:"",margin:null,bookInfCreateTime:null,bookInfUpdateTime:null,bookDetailCreateTime:null,bookDetailUpdateTime:null});const V=()=>{console.log("submit!")},g=()=>{m({type:"warning",showClose:!0,message:"请从该页面查询Detail"}),c.push("/home/search")},r=d=>T(d).format("YYYY-MM-DD HH:mm:ss");let p=window.location.href.split("?");if(p.length>1){let d=p[1].split("=");if(d.length%2===0)for(let a=0;a<d.length;a+=2)e[d[a]]!==void 0&&(e[d[a]]=d[a+1])}return e.id===null?g():b.get("/book?id="+e.id,{headers:{"Content-Type":"application/json"}}).then(d=>{d.code==0?(e=Object.assign(e,d.data),m({type:"success",showClose:!0,message:"查询成功"}),e.picture=b.baseURL+"file?hex="+e.picture):(m({type:"error",showClose:!0,message:d.msg}),console.error(d))}).catch(d=>{m({type:"error",showClose:!0,message:"查询失败"}),console.error(d)}),(d,a)=>{const s=i("el-input"),u=i("el-form-item"),y=i("el-image"),f=i("el-button"),k=i("el-form");return I(),h(k,{model:t(e),"label-width":"130px",style:{padding:"70px"}},{default:o(()=>[l(u,{label:"书籍id"},{default:o(()=>[l(s,{modelValue:t(e).id,"onUpdate:modelValue":a[0]||(a[0]=n=>t(e).id=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"书名"},{default:o(()=>[l(s,{modelValue:t(e).name,"onUpdate:modelValue":a[1]||(a[1]=n=>t(e).name=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"作者"},{default:o(()=>[l(s,{modelValue:t(e).author,"onUpdate:modelValue":a[2]||(a[2]=n=>t(e).author=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"价格"},{default:o(()=>[l(s,{modelValue:t(e).price,"onUpdate:modelValue":a[3]||(a[3]=n=>t(e).price=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"库存"},{default:o(()=>[l(s,{modelValue:t(e).margin,"onUpdate:modelValue":a[4]||(a[4]=n=>t(e).margin=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"详情"},{default:o(()=>[l(s,{modelValue:t(e).detail,"onUpdate:modelValue":a[5]||(a[5]=n=>t(e).detail=n),type:"textarea",disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"创建者id"},{default:o(()=>[l(s,{modelValue:t(e).createId,"onUpdate:modelValue":a[6]||(a[6]=n=>t(e).createId=n),disabled:""},null,8,["modelValue"])]),_:1}),l(u,{label:"图片"},{default:o(()=>[l(y,{class:"image",src:t(e).picture,fit:"contain"},null,8,["src"])]),_:1}),l(u,{label:"主信息创建时间"},{default:o(()=>[l(s,{value:r(t(e).bookInfCreateTime),disabled:""},null,8,["value"])]),_:1}),l(u,{label:"主信息更新时间"},{default:o(()=>[l(s,{value:r(t(e).bookInfUpdateTime),disabled:""},null,8,["value"])]),_:1}),l(u,{label:"更多信息创建时间"},{default:o(()=>[l(s,{value:r(t(e).bookDetailCreateTime),disabled:""},null,8,["value"])]),_:1}),l(u,{label:"更多信息更新时间"},{default:o(()=>[l(s,{value:r(t(e).bookDetailUpdateTime),disabled:""},null,8,["value"])]),_:1}),l(u,null,{default:o(()=>[l(f,{type:"primary",onClick:V},{default:o(()=>[_("创建")]),_:1}),l(f,null,{default:o(()=>[_("取消")]),_:1})]),_:1})]),_:1},8,["model"])}}},B=v(w,[["__scopeId","data-v-1de6c031"]]);export{B as default};