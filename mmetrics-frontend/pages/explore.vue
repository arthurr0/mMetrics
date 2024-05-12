<script setup lang="ts">

import SubPageHead from "~/components/SubPageHead.vue";
</script>

<template>
  <section class="bg-white dark:bg-gray-900 min-h-screen">
    <SubPageHead title="Public Metrics" description="Metrics that are publicly available to everyone." />
    <ExploreTable />
  </section>
</template>
