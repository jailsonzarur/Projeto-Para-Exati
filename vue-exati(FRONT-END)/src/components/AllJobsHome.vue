<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios'; 
import Jobs from './Jobs.vue';

const jobs = ref([])
const containJob = ref(false)

onMounted(async () => {
  try {
    const response = await axios.get('http://localhost:8080/jobs');
    const data = response.data;

    for (const key in data) {
      jobs.value.push({
        idJob: data[key]["idJob"],
        title: data[key]["title"],
        job_description: data[key]["job_description"],
        salary: data[key]["salary"],
        company_info: data[key]["company_info"],
        job_style: data[key]["job_style"],
        job_location: data[key]["job_location"],
      });
    }

    if(jobs.value.length != 0) containJob.value = true
    else containJob.value = false

  } catch (error) {
    console.error("Erro ao buscar os dados:", error);
  }
});

</script>

<template>
    <div v-if="containJob" class="flex flex-wrap gap-4 justify-center">
        <div
        v-for="job in jobs"
        :key="job.idJob"
        class="max-w-sm w-full sm:w-auto rounded h-96"
        >
        <Jobs
            :title="job.title"
            :description="job.job_description"
            :salary="job.salary"
            :job_location="job.job_location"
            :job_style="job.job_style"
            :job_id="job.idJob"
        />
        </div>
    </div>
    <div v-else>
      <h2 class="text-3xl font-bold text-gray-500 mb-6 text-center mt-6 m-auto">
        Nenhuma vaga encontrada
      </h2>
    </div>
</template>