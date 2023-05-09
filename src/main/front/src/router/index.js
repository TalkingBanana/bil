import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  { /* 커뮤니티 router*/
    path: '/community',
    name: 'community',
   
    component: () => import('../views/CommunityView.vue')
  }
  ,
  { /* 지식 router*/
    path: '/knowledge',
    name: 'knowledge',
    
    component: () => import('../views/KnowledgeView.vue')
  }
  ,
  { /* Q&A router*/
    path: '/question',
    name: 'question',
   
    component: () => import('../views/QuestionView.vue')
  }
  ,
  { /* 공지사항 router*/
    path: '/notice',
    name: 'notice',
    
    component: () => import('../views/NoticeView.vue')
  }
  ,
  { /* 교육 router*/
    path: '/StudyBoard',
    name: 'StudyBoard',
    
    component: () => import('../views/study/StudyBoard.vue')
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
    
    component: () => import('../views/ManagementView.vue')
  }
  ,
  { /* 로그인 페이지 router*/
    path: '/login',
    name: 'login',
    
    component: () => import('../views/LoginView.vue')
  }
  ,
  { /* 관리 페이지 router*/
    path: '/register',
    name: 'register',
    
    component: () => import('../views/RegisterView.vue')
  }
  ,
  { /* 마이 페이지 router*/
    path: '/profile',
    name: 'profile',
    
    component: () => import('../views/ProfileView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
