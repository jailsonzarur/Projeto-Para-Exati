<script setup>
</script>

<template>
    <nav class="bg-black-700 border-b border-black-1000">
      <div class="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
        <div class="flex h-20 items-center justify-between">
          <div
            class="flex flex-1 items-center justify-center md:items-stretch md:justify-start"
          >
            <a class="flex flex-shrink-0 items-center mr-4" href="/">
              <span class="hidden md:block text-black text-2xl font-bold ml-2"
                >Tech Jobs</span
              >
            </a>
            <div class="md:ml-auto">
              <div class="flex space-x-2">
                <a
                  href="/"
                  class="text-black bg-black-900 hover:bg-gray-900 hover:text-white rounded-md px-3 py-2"
                  >Home</a
                >
                <a
                  href="/jobs"
                  class="text-black bg-black-900 hover:bg-gray-900 hover:text-white rounded-md px-3 py-2"
                  >Jobs</a>
                <a
                  href="/jobs/add"
                  class="text-black bg-black-900 hover:bg-gray-900 hover:text-white rounded-md px-3 py-2">Adicionar Job</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>
</template>