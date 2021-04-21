//중요한 것들은 const를 씀(변경이 불가능 한 것들)
const Home = {
    template: `<div>
    <h1>Home</h1>
    <div>Home 페이지입니다</div>
    </div>`
}

const About = {
    template: `<div>
    <h1>About</h1>
    <div>About 페이지입니다</div>
    </div>`
}

//위에서 작성된 라우터 컴포넌트를 라우터에 설정
const routes = [
    { path: '/home', component: Home },
    { path: '/about', component: About }
]

//라우터 인스턴스를 생성하고 라우터를 설정
const router = new VueRouter({
    routes: routes
})

const app = new Vue({
    router: router,
    data: {
        header: '튜토리얼16 : router 임혜린',
        messages: [ 'Vue는 SPA(Single Page Application)을 구축하는 것이 가능합니다',
                   '어플리케이션을 작성하면서 페이지 이동은 필요합니다',
                   '어플리케이션 내의 페이지 이동을 라우팅이라고 합니다',
                   '페이지 이동을 만들기 위해서는 Vue Router를 사용합니다',
                   '기본적으로 Html에서는 <a>태그를 사용하고, 페이지 전체의 Dom을 갱신합니다',
                   'Vue Router에서는 router-link를 사용하고, 페이지의 일부분의 Dom만을 갱신합니다']
    }
}).$mount('#app-16')



