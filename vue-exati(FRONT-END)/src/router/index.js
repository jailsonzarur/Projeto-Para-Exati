import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import AddJob from '@/components/AddJob.vue'
import AllJobs from '@/components/AllJobs.vue'
import Job from '@/components/Job.vue'
import ModalUpdate from '@/components/ModalUpdate.vue'

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
        },
        {
            path: '/job/:id',
            name: 'job',
            component: Job,
            props: route => ({ jobId: route.params.id})
        },
        {
            path: '/modal-update',
            name: 'modal',
            component: ModalUpdate,
        }
    ],
})

export default router