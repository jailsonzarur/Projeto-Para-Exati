<script setup>
import Navbar from './components/Navbar.vue';
import { RouterView } from 'vue-router';  
import BrowseJobs from './components/BrowseJobs.vue';
</script>

<template>
  <Navbar/>
  <RouterView/>
</template>