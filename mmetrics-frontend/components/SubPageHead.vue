<script setup lang="ts">
import { defineProps } from 'vue'

defineProps({
  title: String,
  description: String
})

</script>

<template>
  <div class="container py-12 mx-auto">
    <div class="flex flex-col text-center w-full">
      <h1 class="text-2xl font-bold title-font text-gray-900 dark:text-white">{{ title }}</h1>
      <p class="lg:w-2/3 mx-auto leading-relaxed text-base text-gray-500 dark:text-gray-400">{{ description }}</p>
    </div>
  </div>
</template>
