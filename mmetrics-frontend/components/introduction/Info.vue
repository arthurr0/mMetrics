<script setup lang="ts">
import { onMounted } from 'vue'
import { initFlowbite } from 'flowbite'

onMounted(() => {
  initFlowbite();
})

</script>

<template>
  <div class="mx-auto max-w-screen-xl mb-10">
    <div class="py-8 px-4 sm:py-16 lg:px-6 bg-gray-100 dark:bg-gray-800 relative shadow-md sm:rounded-lg overflow-hidden">
      <div class="grid grid-cols-1">
        <div class="p-8">
          <h2 class="text-2xl font-bold text-gray-600 dark:text-gray-200">What is mMetrics?</h2>
          <p class="mt-4 text-gray-500 dark:text-gray-400">mMetrics is an open-source service for keeping custom metrics from developers' applications. It allows you to track and visualize your application's performance, errors, and other custom metrics.</p>
        </div>
      </div>

      <div class="grid grid-cols-1">
        <div class="p-8">
          <h2 class="text-2xl font-bold text-gray-600 dark:text-gray-200">Why mMetrics?</h2>
          <p class="mt-4 text-gray-500 dark:text-gray-400">mMetrics is designed to be simple and easy to use. It provides a clean and intuitive interface for tracking your application's metrics. With mMetrics, you can easily monitor your application's performance and identify issues before they become critical.</p>
        </div>
      </div>

      <div class="grid grid-cols-1">
        <div class="p-8">
          <h2 class="text-2xl font-bold text-gray-600 dark:text-gray-200">How does mMetrics work?</h2>
          <p class="mt-4 text-gray-500 dark:text-gray-400">mMetrics works by collecting data from your application and storing it in a database. You can then view this data in the mMetrics dashboard, where you can create custom dashboards and visualizations to track your application's performance.</p>
        </div>
      </div>
    </div>
  </div>
</template>
