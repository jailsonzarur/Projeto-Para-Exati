<script setup>
import AllJobs from './AllJobs.vue';
import AllJobsHome from './AllJobsHome.vue';
import Jobs from './Jobs.vue';

</script>

<template>
    <section class="bg-gray-100 px-4 py-10">
      <div class="container-xl lg:container m-auto">
        <h2 class="text-3xl font-bold text-black-500 mb-6 text-center">
          Busque Vagas
        </h2>
        <div class="flex flex-wrap gap-4">
          <div class="w-full sm:w-auto h-96">
            <AllJobsHome />
          </div>
        </div>
      </div>
    </section>
</template>