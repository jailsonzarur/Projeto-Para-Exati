<script setup>
import { defineProps, ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios'; 

const title = ref('')
const job_description = ref('')
const salary = ref('')
const company_info = ref('')
const job_style = ref('')
const job_location = ref('')
const showModal = ref(false)

const router = useRouter()

const props = defineProps({
    jobId: {
        type: String,
        required: true
    }
})

async function delete_job(e) {
  try {

    const response = await axios.delete(`http://localhost:8080/jobs/${props.jobId}`);
    const data = response.data;

    console.log(data)

    showModal.value = false;
    router.push('/jobs')

  } catch (error) {
    console.error("Erro ao buscar os dados:", error);
  }
}

onMounted(async () => {
  try {

    const response = await axios.get(`http://localhost:8080/jobs/${props.jobId}`);
    const data = response.data;


    
    title.value = data["title"]
    job_description.value = data["job_description"]
    salary.value = data["salary"]
    company_info.value = data["company_info"]
    job_style.value = data["job_style"]
    job_location.value = data["job_location"]

  } catch (error) {
    console.error("Erro ao buscar os dados:", error);
  }
});

</script>

<template>
    <section>
      <div class="container m-auto py-6 px-6">
        <a
          href="/jobs"
          class="text-black hover:text-black-600 flex items-center"
        >
          <i class="fas fa-arrow-left mr-2"></i> <- Voltar à lista de vagas
        </a>
      </div>
    </section>

    <section class="bg-black-50">
      <div class="container m-auto py-10 px-6">
        <div class="grid grid-cols-1 md:grid-cols-70/30 w-full gap-6">
          <main>
            <div
              class="bg-white p-6 rounded-lg shadow-md text-center md:text-left"
            >
              <div class="text-gray-500 mb-4">{{ job_style }}</div>
              <h1 class="text-3xl font-bold mb-4">{{ title }}</h1>
              <div
                class="text-gray-500 mb-4 flex align-middle justify-center md:justify-start"
              >
                <i
                  class="fa-solid fa-location-dot text-lg text-black-700 mr-2 font-bold"
                ></i>
                <p class="text-black font-bold">{{ job_location }}</p>
              </div>
            </div>

            <div class="bg-white p-6 rounded-lg shadow-md mt-6">
              <h3 class="text-black-800 text-lg font-bold mb-6">
                Descrição da Vaga
              </h3>

              <p class="mb-4">
                {{ job_description }}
              </p>

              <h3 class="text-black-800 text-lg font-bold mb-2">Salário</h3>

              <p class="mb-4">{{ salary }}</p>
            </div>
          </main>

          
          <aside>
            
            <div class="bg-white p-6 rounded-lg shadow-md">
              <h3 class="text-xl font-bold mb-6">Informações sobre a Empresa</h3>

              <p class="my-2">
                {{ company_info }}
              </p>
            </div>

            
            <div class="bg-white p-6 rounded-lg shadow-md mt-6">
              <h3 class="text-xl font-bold mb-6">Alterar a Vaga</h3>
              <a
                href="/modal-update"
                class="bg-black hover:bg-black text-white text-center font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block"
                >Editar a Vaga</a
              >
              <button
                class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline mt-4 block"
                @click="showModal = true"
              >
                Deletar a Vaga
              </button>
            </div>
          </aside>
        </div>
      </div>
    </section>

  <!-- Modal -->
  <div
    v-if="showModal"
    class="fixed inset-0 bg-gray-800 bg-opacity-75 flex justify-center items-center z-50"
  >
    <div class="bg-white p-6 rounded-lg shadow-lg w-96">
      <h2 class="text-lg font-bold mb-4">Confirmar Exclusão</h2>
      <p class="mb-4">
        Tem certeza de que deseja deletar a vaga <strong>{{ title }}</strong>?
      </p>
      <div class="flex justify-end">
        <button
          class="bg-gray-300 hover:bg-gray-400 text-black font-bold py-2 px-4 rounded mr-2"
          @click="showModal = false"
        >
          Cancelar
        </button>
        <button
          class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded"
          @click="delete_job"
        >
          Confirmar
        </button>
      </div>
    </div>
  </div>
</template>