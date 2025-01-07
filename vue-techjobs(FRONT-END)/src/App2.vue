<script>
  export default {
    data() {
      return {
        "name": "Jailson Zarur",
        "status": "active",
        "tasks": ["Task One", "Task Two", "Task Three"],
        "link": "https://google.com"
      }
    }, 
    methods: {
      toggleStatus() {
        if(this.status === 'active') {
          this.status = 'peding'
        } else if (this.status === 'peding') {
          this.status = 'inactive'
        } else if (this.status === 'inactive') {
          this.status = 'active'
        }
      }
    }
  }
</script>

<template>
  <h1>{{ name }}</h1>
  <p v-if="status === 'active'">User is active</p>
  <p v-else-if="status === 'pending'">User is pending</p>
  <p v-else>User is inactive</p>

  <h3>Tasks</h3>
  <ul>
    <li v-for="task in tasks" :key="task">{{ task }}</li>
  </ul>

  <a v-bind:href="link">Click to Google</a>
  <br>
  <!--<button @click="toggleStatus">Click on Me</button>-->
  <button @click="toggleStatus">Click on Me</button>
</template>
