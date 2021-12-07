import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
import TextSummary from '@/components/middle/TextSummary.vue'
import Test from '@/components/middle/test.vue'
import OCRSummary from '@/components/middle/OCRSummary.vue'
import STTSummary from '@/components/middle/STTSummary.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'TextSummary',
    component: TextSummary
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/textSummary',
    name: 'TextSummary',
    component: TextSummary,
  },
  {
    path: '/test',
    name: 'Test',
    component: Test,
  },
  {
    path: '/ocrSummary',
    name: 'OCRSummary',
    component: OCRSummary,
  },
  {
    path: '/sttSummary',
    name: 'STTSummary',
    component: STTSummary,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
