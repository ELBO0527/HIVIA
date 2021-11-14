import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue')
  },
  {
    path: '/signup',
    name: 'Signup',
    component: () => import('../views/sign-up.vue')
  },
  {
    path: '/signin',
    name: 'Signin',
    component: () => import('../views/sign-in.vue')
  },
  {
    path: '/company',
    name: 'Company',
    component: () => import('../views/company.vue')
  },
  {
    path: '/solution',
    name: 'Solution',
    component: () => import('../views/solution.vue')
  },
  {
    path: '/details',
    name: 'Details',
    component: () => import('../views/details.vue')
  },
  {
    path: '/help',
    name: 'Help',
    component: () => import('../views/help.vue')
  },
  {
    path: '/help-list',
    name: 'Help-list',
    component: () => import('../views/help-list.vue')
  },
  {
    path: '/*',
    component: () => import('../views/e404.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
