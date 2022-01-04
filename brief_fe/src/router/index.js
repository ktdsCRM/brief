import Vue from 'vue'
import VueRouter from 'vue-router'
// import Home from '../views/Home.vue'
import TextSummary from '@/components/middle/TextSummary.vue'
import OCRSummary from '@/components/middle/OCRSummary.vue'
import STTSummary from '@/components/middle/STTSummary.vue'
import SumList from '@/components/middle/SumList.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'TextSummary',
    component: TextSummary
  },
  {
    path: '/textSummary',
    name: 'TextSummary',
    component: TextSummary,
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
  },
  {
    path: '/sumList',
    name: 'SumList',
    component: SumList,
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
