import{_ as g,u as w,r as y,a as n,c as b,w as s,E as r,o as x,b as l,d as i,e as C}from"./index-ca6a7fa3.js";const v={__name:"Delete",setup(V){const a=w(),t=y({id:null}),d=()=>{C.delete("/book?id="+t.id).then(e=>{e.code==0?(r({type:"success",showClose:!0,message:"删除成功"}),a.push("/home/search")):(r({type:"error",showClose:!0,message:e.msg}),console.error(e))}).catch(e=>{r({type:"error",showClose:!0,message:"删除失败"}),console.error(e)})};let c=window.location.href.split("?");if(c.length>1){let e=c[1].split("=");if(e.length%2===0)for(let o=0;o<e.length;o+=2)t[e[o]]!==void 0&&(t[e[o]]=e[o+1])}const m=()=>{r({type:"warning",showClose:!0,message:"请从该页面查询"}),a.push("/home/search")};return t.id===null&&m(),(e,o)=>{const p=n("el-input"),u=n("el-form-item"),_=n("el-button"),f=n("el-form");return x(),b(f,{model:t,"label-width":"75px",class:"form"},{default:s(()=>[l(u,{label:"书籍id"},{default:s(()=>[l(p,{modelValue:t.id,"onUpdate:modelValue":o[0]||(o[0]=h=>t.id=h),disabled:""},null,8,["modelValue"])]),_:1}),l(u,null,{default:s(()=>[l(_,{type:"primary",onClick:d},{default:s(()=>[i("删除")]),_:1}),l(_,null,{default:s(()=>[i("取消")]),_:1})]),_:1})]),_:1},8,["model"])}}},D=g(v,[["__scopeId","data-v-1ee0696e"]]);export{D as default};
