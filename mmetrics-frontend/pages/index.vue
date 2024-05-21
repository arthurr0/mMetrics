<script setup lang="ts">
import {onBeforeMount} from "#imports";

import { onMounted } from 'vue'
import { initFlowbite } from 'flowbite'

// initialize components based on data attribute selectors
onMounted(() => {
  initFlowbite();
})

const runtimeConfig = useRuntimeConfig();

onBeforeMount(() => {
  console.log('runtimeConfig', runtimeConfig)
});

</script>

<template>
  <HomeHero />
  <HomeAbout />
  <HomeFeatures />
  <HomeFAQ />
</template>

<style scoped>

</style>
