<script setup>
import { ref } from 'vue';
import axios from 'axios';

const job_style = ref('')
const title = ref('')
const job_description = ref('')
const salary = ref('')
const job_location = ref('')

const company_name = ref('')
const company_description = ref('')
const company_email = ref('')
const company_phone = ref('')

const addJob = () => {

  const company_info = `Name: ${company_name.value}, Description: ${job_description.value}, 
  Email: ${company_email.value}, Phone: ${company_phone.value}`

  const jobData = {
    title: title.value,
    job_description: job_description.value,
    salary: salary.value,
    job_style: job_style.value,
    job_location: job_location.value,
    company_info: company_info
  }

  axios.post('http://localhost:8080/jobs', jobData, {
    headers: {
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': 'http://localhost:3000',
    }
  })
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error('Aconteceu um erro!', error);
  });

  location.reload()
}

</script>

<template>
    <section class="bg-white-50">
      <div class="container m-auto max-w-2xl py-24">
        <div
          class="bg-white px-6 py-8 mb-4 shadow-md rounded-md border m-4 md:m-0"
        >
          <form @submit.prevent="addJob">
            <h2 class="text-3xl text-center font-semibold mb-6">Adicionar Job</h2>

            <div class="mb-4">
              <label for="type" class="block text-gray-700 font-bold mb-2">Estilo</label>
              <select
                id="type"
                name="type"
                class="border rounded w-full py-2 px-3"
                v-model="job_style"
                required
              >
                <option value="Full-Time">Híbrido</option>
                <option value="Part-Time">Presencial</option>
                <option value="Remoto">Remoto</option>
                <option value="Estágio">Estágio</option>
              </select>
            </div>

            <div class="mb-4">
              <label class="block text-gray-700 font-bold mb-2">Título</label>
              <input
                type="text"
                id="name"
                name="name"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="Estágio FullStack"
                v-model="title"
                required
              />
            </div>
            <div class="mb-4">
              <label
                for="description"
                class="block text-gray-700 font-bold mb-2">Descrição</label>
              <textarea
                id="description"
                name="description"
                class="border rounded w-full py-2 px-3"
                rows="4"
                placeholder="Requisitos, habilidades necessárias..."
                v-model="job_description"
              ></textarea>
            </div>

            <div class="mb-4">
              <label for="type" class="block text-gray-700 font-bold mb-2">Salário</label>
              <input
                type="number"
                id="salario"
                name="salario"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="1800"
                v-model="salary"
                required
              />
            </div>

            <div class="mb-4">
              <label class="block text-gray-700 font-bold mb-2">
                Localização
              </label>
              <input
                type="text"
                id="location"
                name="location"
                class="border rounded w-full py-2 px-3 mb-2"
                placeholder="Ex: Curitiba..."
                v-model="job_location"
                required
              />
            </div>

            <h3 class="text-2xl mb-5">Informações da Empresa</h3>

            <div class="mb-4">
              <label for="company" class="block text-gray-700 font-bold mb-2"
                >Nome Empresa</label
              >
              <input
                type="text"
                id="company"
                name="company"
                class="border rounded w-full py-2 px-3"
                placeholder="Exati"
                v-model="company_name"
              />
            </div>

            <div class="mb-4">
              <label
                for="company_description"
                class="block text-gray-700 font-bold mb-2"
                >Descrição da Empresa</label
              >
              <textarea
                id="company_description"
                name="company_description"
                class="border rounded w-full py-2 px-3"
                rows="4"
                placeholder="O que a sua empresa faz?"
                v-model="company_description"
              ></textarea>
            </div>

            <div class="mb-4">
              <label
                for="contact_email"
                class="block text-gray-700 font-bold mb-2"
                >Email de contato</label
              >
              <input
                type="email"
                id="contact_email"
                name="contact_email"
                class="border rounded w-full py-2 px-3"
                placeholder="Email de contato"
                v-model="company_email"
                required
              />
            </div>
            <div class="mb-4">
              <label
                for="contact_phone"
                class="block text-gray-700 font-bold mb-2"
                >Telefone de contato</label
              >
              <input
                type="tel"
                id="contact_phone"
                name="contact_phone"
                class="border rounded w-full py-2 px-3"
                placeholder="Ex: (86) 9 8893-2854..."
                v-model="company_phone"
              />
            </div>

            <div>
              <button
                class="bg-black hover:bg-black-600 text-white font-bold py-2 px-4 rounded-full w-full focus:outline-none focus:shadow-outline"
                type="submit"
              >
                Cadastrar
              </button>
            </div>
          </form>
        </div>
      </div>
    </section>
</template>
