<script setup>
import { defineProps } from 'vue';

defineProps({
    job_style: {
        type: String,
        default: 'Estilo da Vaga'
    },
    title: {
        type: String,
        default: 'Título da Vaga'
    },
    description: {
        type: String,
        default: 'Descrição da Vaga'
    },
    salary: {
        type: Number,
        default: 0
    },
    job_location: {
        type: String,
        default: 'Localização da Vaga'
    },
    job_id: {
        type: String,
    }
})

</script>

<template>
  <div class="bg-gray-100 p-6 rounded-lg shadow-md">
    <div class="bg-white rounded-xl shadow-md relative">
            <div class="p-4">
              <div class="mb-6">
                <div class="text-gray-600 my-2">{{ job_style }}</div>
                <h3 class="text-xl font-bold">{{ title }}</h3>
              </div>

              <div class="mb-5 line-clamp-3">
                {{ description }}
              </div>

              <h3 class="text-black mb-2 font-bold">R$ {{ salary }}</h3>

              <div class="border border-gray-100 mb-5"></div>

              <div class="flex flex-col lg:flex-row justify-between mb-4">
                <div class="text-black mb-3 font-bold">
                  <i class="fa-solid fa-location-dot text-lg"></i>
                  {{  job_location  }}
                </div>
                <a
                  :href="'/job/' + job_id"
                  class="h-[36px] bg-black text-white px-4 py-2 rounded-lg text-center text-sm"
                >
                  Veja Mais
                </a>
              </div>
            </div>
        </div>
  </div>
</template>