import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import store from '@/store';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue'),
  },
  {
    path: '/signup',
    name: 'Signup',
    component: () => import('../views/sign-up.vue'),
  },
  {
    path: '/signin',
    name: 'Signin',
    component: () => import('../views/sign-in.vue'),
  },
  {
    path: '/admin',
    name: '',
    component: () => import('../views/admin.vue'),
    children: [
      {
        path: '',
        name: 'dashboard',
        component: () => import('../components/admin/dashboard.vue'),
      },
      {
        path: 'item',
        name: 'item',
        component: () => import('../components/admin/item/item.vue'),
      },
      {
        path: 'postitems',
        name: 'postitems',
        component: () => import('../components/admin/item/postitems.vue'),
        children: [
          {
            path: 'test',
            name: 'test',
            component: () => import('../components/admin/test.vue'),
          },
        ],
      },
      {
        path: 'updateitems',
        name: 'updateitems',
        component: () => import('../components/admin/item/updateitems.vue'),
      },
    ],
  },
  {
    path: '/item',
    name: 'Item',
    component: () => import('../views/item.vue'),
    children: [
      {
        path: '',
        name: 'item',
        component: () => import('../views/users/item/item-main.vue'),
      },
      {
        path: 'itemdetail',
        name: 'ItemDetail',
        component: () => import('../views/users/item/item-detail.vue'),
      },
    ],
  },
  {
    path: '/itemOrder',
    name: 'ItemOrder',
    component: () => import('../views/users/item/item-order.vue'),
  },
  {
    path: '/itemOrderConfirmed',
    name: 'ItemOrderConfirmed',
    component: () => import('../views/users/item/item-orderComfirmed.vue'),
  },
  {
    path: '/mypage',
    name: 'mypage',
    component: () => import('../views/users/mypage/mypage-main.vue'),
  },
  {
    path: '/cart',
    name: 'cart',
    component: () => import('../views/users/mypage/cart.vue'),
  },
  {
    path: '/*',
    component: () => import('../views/e404.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
