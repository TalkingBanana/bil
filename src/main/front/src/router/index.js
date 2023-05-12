import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import community from "@/views/CommunityView.vue"
import knowledge from "@/views/KnowledgeView.vue"
import question from "@/views/QuestionView.vue"
import notice from "@/views/NoticeView.vue"
import StudyBoard from "@/views/study/StudyBoard.vue"
import management from "@/views/ManagementView.vue"
import profile from "@/views/user/ProfileView.vue"

import store from "../vuex/store";

const requireAuth = () => (from, to, next) => {
  const token = localStorage.getItem('user_token')
  if (token) {
    store.state.isLogin = true
    return next()
  } // isLogin === true면 페이지 이동
  next('/user/login') // isLogin === false면 다시 로그인 화면으로 이동
}

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  { /* 커뮤니티 router*/
    path: '/community',
    name: 'community',
   
    component: community,
    beforeEnter: requireAuth()
  }
  ,
  { /* 지식 router*/
    path: '/knowledge',
    name: 'knowledge',
    
    component: knowledge,
    beforeEnter: requireAuth()
  }
  ,
  { /* Q&A router*/
    path: '/question',
    name: 'question',
   
    component: question,
    beforeEnter: requireAuth()
  }
  ,
  { /* 공지사항 router*/
    path: '/notice',
    name: 'notice',
    
    component: notice,
    beforeEnter: requireAuth()
  }
  ,
  { /* 교육 router*/
    path: '/StudyBoard',
    name: 'StudyBoard',
    
    component: StudyBoard,
    beforeEnter: requireAuth()
  },
  { /* 교육 게시글 작성 router */
    path : '/StudyWrite',
    name : 'StudyWrite',

    component:()=> import('../views/study/StudyWrite.vue')
  },
  { /* 교육 페에지 상세보기 router */
    path : '/StudyDetail/:num',
    name : 'StudyDetail',
    props: true,

    component:()=> import('../views/study/StudyDetail.vue')

  },
  { /* 관리 페이지 router*/
    path: '/management',
    name: 'management',
    
    component: management,
    beforeEnter: requireAuth()
  }
  ,
  { /* 로그인 페이지 router*/
    path: '/user/login',
    name: 'login',
    
    component: () => import('../views/user/LoginView.vue')
  }
  ,
  { /* 회원가입 페이지 router*/
    path: '/user/register',
    name: 'register',
    
    component: () => import('../views/user/RegisterView.vue')
  }
  ,
  { /* 마이 페이지 router*/
    path: '/user/profile',
    name: 'profile',
    
    component: profile,
    beforeEnter: requireAuth()
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router