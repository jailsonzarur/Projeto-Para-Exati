<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios'; 
import Jobs from './Jobs.vue';

const jobs = ref([])

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/jobs');
    const data = response.data;

    for (const key in data) {
      jobs.value.push({
        idJob: data[key]["idJob"],
        title: data[key]["title"],
        job_description: data[key]["description"],
        salary: data[key]["salary"],
        company_info: data[key]["company_info"],
        job_style: data[key]["job_style"],
        job_location: data[key]["job_location"],
      });
    }

    console.log(jobs.value);
  } catch (error) {
    console.error("Erro ao buscar os dados:", error);
  }
});

</script>

<template>
    <ul>
        <li v-for="job in jobs" :key="job.idJob">
            <Jobs :title="job.title" :description="job.job_description"
            :salary="job.salary" :job_location="job.job_location"
            :job_style="job.job_style"/>
        </li>
    </ul>
</template>