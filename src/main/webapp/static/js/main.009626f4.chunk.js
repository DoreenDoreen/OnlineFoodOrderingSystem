(this["webpackJsonpdoordash-app"]=this["webpackJsonpdoordash-app"]||[]).push([[0],{152:function(e,t,n){},230:function(e,t,n){},231:function(e,t,n){"use strict";n.r(t);var a=n(0),c=n(23),s=n.n(c),r=(n(152),n(36)),i=n(239),o=n(236),l=n(85),u=n(106),j=n(104),d=n(143),h=n(234),b=n(238),f=n(57),m=n(241),p=n(242),O=function(e){var t="/login?username=".concat(e.username,"&password=").concat(e.password);return fetch(t,{method:"POST",headers:{"Content-Type":"application/json"},credentials:"include"}).then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to log in")}))},g=function(e){return fetch("/signup",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(e)}).then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to sign up")}))},x=n(7),y=function(e){Object(u.a)(n,e);var t=Object(j.a)(n);function n(){var e;Object(l.a)(this,n);for(var a=arguments.length,c=new Array(a),s=0;s<a;s++)c[s]=arguments[s];return(e=t.call.apply(t,[this].concat(c))).state={loading:!1},e.onFinish=function(t){console.log("Received values of form: ",t),e.setState({loading:!0}),O(t).then((function(){d.b.success("Login Successful"),e.props.onSuccess()})).catch((function(e){d.b.error(e.message)})).finally((function(){e.setState({loading:!1})}))},e.render=function(){return Object(x.jsxs)(h.a,{name:"normal_login",style:{width:300,margin:"auto"},onFinish:e.onFinish,children:[Object(x.jsx)(h.a.Item,{name:"username",rules:[{required:!0,message:"Please input your Username!"}],children:Object(x.jsx)(b.a,{prefix:Object(x.jsx)(m.a,{}),placeholder:"Username"})}),Object(x.jsx)(h.a.Item,{name:"password",rules:[{required:!0,message:"Please input your Password!"}],children:Object(x.jsx)(b.a.Password,{prefix:Object(x.jsx)(p.a,{}),type:"password",placeholder:"Password"})}),Object(x.jsx)(h.a.Item,{children:Object(x.jsx)(f.a,{type:"primary",htmlType:"submit",loading:e.state.loading,children:"Log in"})})]})},e}return n}(a.Component),v=y,S=n(75),w=n(70),C=n(235),F=n(233),I=n(147),P=S.a.Option,k=function(e){var t=e.itemId,n=Object(a.useState)(!1),c=Object(r.a)(n,2),s=c[0],i=c[1];return Object(x.jsx)(w.a,{title:"Add to shopping cart",children:Object(x.jsx)(f.a,{icon:Object(x.jsx)(I.a,{}),type:"primary",loading:s,onClick:function(){i(!0),function(e){return fetch("/order/".concat(e),{method:"POST",headers:{"Content-Type":"application/json"},credentials:"include"}).then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to add menu item to shopping cart")}))}(t).then((function(){d.b.success("Successfully add item")})).catch((function(e){d.b.error(e.message)})).finally((function(){i(!1)}))}})})};var T=function(e){var t=Object(a.useState)(!1),n=Object(r.a)(t,2),c=n[0],s=n[1],i=Object(a.useState)(),o=Object(r.a)(i,2),l=o[0],u=o[1],j=Object(a.useState)([]),h=Object(r.a)(j,2),b=h[0],f=h[1],m=Object(a.useState)([]),p=Object(r.a)(m,2),O=p[0],g=p[1];return Object(a.useEffect)((function(){s(!0),fetch("/restaurants").then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to get restaurants");return e.json()})).then((function(e){console.log("res data ->",e),f(e)})).catch((function(e){console.log("err ->",e.message),d.b.error(e.message)})).finally((function(){s(!1)}))}),[]),Object(a.useEffect)((function(){var e;l&&(s(!0),(e=l,fetch("/restaurant/".concat(e,"/menu")).then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to get menus");return e.json()}))).then((function(e){console.log("menu ->",e),g(e)})).catch((function(e){console.log(e.message),d.b.error(e.message)})).finally((function(){s(!1)})))}),[l]),Object(x.jsxs)("div",{children:[Object(x.jsx)(S.a,{value:l,loading:c,placeholder:"Select a restaurant",style:{width:300},onSelect:function(e){return u(e)},children:b.map((function(e){return Object(x.jsx)(P,{value:e.id,children:e.name},e.id)}))}),l&&Object(x.jsx)(C.b,{style:{marginTop:20},grid:{gutter:16,xs:1,sm:2,md:4,lg:4,xl:3,xxl:3},dataSource:O,renderItem:function(e){return Object(x.jsx)(C.b.Item,{children:Object(x.jsxs)(F.a,{title:e.name,extra:Object(x.jsx)(k,{itemId:e.id}),children:[Object(x.jsx)("img",{src:e.imageUrl,alt:e.name,style:{height:"auto",width:"100%",display:"block"}}),"Price: ".concat(e.price)]})})}})]})},E=n(138),L=n(237),M=function(e){Object(u.a)(n,e);var t=Object(j.a)(n);function n(){var e;Object(l.a)(this,n);for(var a=arguments.length,c=new Array(a),s=0;s<a;s++)c[s]=arguments[s];return(e=t.call.apply(t,[this].concat(c))).state={displayModal:!1},e.handleCancel=function(){e.setState({displayModal:!1})},e.signupOnClick=function(){e.setState({displayModal:!0})},e.onFinish=function(t){console.log("click"),g(t).then((function(){e.setState({displayModal:!1}),d.b.success("Successfully signed up")})).catch((function(e){d.b.error(e.message)})).finally((function(){e.handleCancel()}))},e}return Object(E.a)(n,[{key:"render",value:function(){return Object(x.jsxs)(x.Fragment,{children:[Object(x.jsx)(f.a,{type:"primary",onClick:this.signupOnClick,children:"Register"}),Object(x.jsx)(L.a,{title:"Register",visible:this.state.displayModal,onCancel:this.handleCancel,destroyOnClose:!0,children:Object(x.jsxs)(h.a,{name:"normal_register",onFinish:this.onFinish,preserve:!1,children:[Object(x.jsx)(h.a.Item,{name:"email",rules:[{required:!0,message:"Please input your email!"}],children:Object(x.jsx)(b.a,{prefix:Object(x.jsx)(m.a,{}),placeholder:"Email"})}),Object(x.jsx)(h.a.Item,{name:"password",rules:[{required:!0,message:"Please input your password!"}],children:Object(x.jsx)(b.a,{prefix:Object(x.jsx)(p.a,{}),placeholder:"Password"})}),Object(x.jsx)(h.a.Item,{name:"firstName",rules:[{required:!0,message:"Please input your first name!"}],children:Object(x.jsx)(b.a,{placeholder:"firstname"})}),Object(x.jsx)(h.a.Item,{name:"lastName",rules:[{required:!0,message:"Please input your last name!"}],children:Object(x.jsx)(b.a,{placeholder:"lastname"})}),Object(x.jsx)(h.a.Item,{children:Object(x.jsx)(f.a,{type:"primary",htmlType:"submit",children:"Register"})})]})})]})}}]),n}(a.Component),q=M,R=n(240),N=o.a.Text;var A=function(e){var t=Object(a.useState)(!1),n=Object(r.a)(t,2),c=n[0],s=n[1],i=Object(a.useState)(!1),o=Object(r.a)(i,2),l=o[0],u=o[1],j=Object(a.useState)({}),h=Object(r.a)(j,2),b=h[0],m=h[1],p=Object(a.useState)(!1),O=Object(r.a)(p,2),g=O[0],y=O[1],v=function(){s(!1)};return Object(a.useEffect)((function(){c&&(u(!0),fetch("/cart").then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to get shopping cart data");return e.json()})).then((function(e){console.log("cart data -> ",e),m(e)})).catch((function(e){d.b.error(e.message)})).finally((function(){u(!1)})))}),[c]),Object(x.jsxs)(x.Fragment,{children:[Object(x.jsx)(f.a,{type:"primary",onClick:function(){s(!0)},shape:"round",children:"Cart"}),Object(x.jsx)(R.a,{title:"My Shopping Cart",onClose:v,visible:c,width:400,footer:Object(x.jsxs)("div",{style:{display:"flex",justifyContent:"space-between"},children:[Object(x.jsx)(N,{children:"Total Price: $".concat(b.totalPrice?b.totalPrice.toFixed(2):0)}),Object(x.jsxs)("div",{children:[Object(x.jsx)(f.a,{style:{marginRight:8},onClick:v,children:"Cancel"}),Object(x.jsx)(f.a,{type:"primary",onClick:function(){y(!0),fetch("/checkout").then((function(e){if(e.status<200||e.status>=300)throw Error("Fail to checkout")})).then((function(){d.b.success("successfully checkout"),s(!1),v()})).catch((function(e){d.b.error(e.message)})).finally((function(){y(!1)}))},loading:g,disabled:l||b.orderItemList&&0===b.orderItemList.length,children:"Checkout"})]})]}),children:Object(x.jsx)(C.b,{dataSource:b?b.orderItemList:[],renderItem:function(e){return Object(x.jsx)(C.b.Item,{children:Object(x.jsx)(C.b.Item.Meta,{title:e.menuItem.name,description:"$".concat(e.price)})})}})})]})},B=(n(230),i.a.Header),H=i.a.Content,J=o.a.Title;var U=function(){var e=Object(a.useState)(!1),t=Object(r.a)(e,2),n=t[0],c=t[1];return Object(x.jsxs)(i.a,{style:{height:"100vh"},children:[Object(x.jsx)(B,{children:Object(x.jsxs)("div",{className:"header",children:[Object(x.jsx)(J,{level:2,style:{color:"white",lineHeight:"inherit",marginBottom:0},children:"Lai Food"}),Object(x.jsx)("div",{children:n?Object(x.jsx)(A,{}):Object(x.jsx)(q,{})})]})}),Object(x.jsx)(H,{style:{padding:"50px",maxHeight:"calc(100% - 64px)",overflowY:"auto"},children:n?Object(x.jsx)(T,{}):Object(x.jsx)(v,{onSuccess:function(){return c(!0)}})})]})},$=function(e){e&&e instanceof Function&&n.e(3).then(n.bind(null,243)).then((function(t){var n=t.getCLS,a=t.getFID,c=t.getFCP,s=t.getLCP,r=t.getTTFB;n(e),a(e),c(e),s(e),r(e)}))};s.a.render(Object(x.jsx)(U,{}),document.getElementById("root")),$()}},[[231,1,2]]]);
//# sourceMappingURL=main.009626f4.chunk.js.map