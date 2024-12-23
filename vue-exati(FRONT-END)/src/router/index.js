import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import AddJob from '@/components/AddJob.vue'
import AllJobs from '@/components/AllJobs.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: HomeView,
        },
        {
            path: '/jobs/add',
            name: 'jobsadd',
            component: AddJob
        },
        {
            path: '/jobs',
            name: 'jobs',
            component: AllJobs
        }
    ],
})

export default router