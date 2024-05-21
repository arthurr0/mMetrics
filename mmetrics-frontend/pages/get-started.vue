<script setup lang="ts">

import SubPageHead from "~/components/SubPageHead.vue";
import SDK from "~/components/introduction/SDK.vue";
</script>

<template>
  <section class="bg-white dark:bg-gray-900 min-h-screen">
    <SubPageHead title="Get started" description="Learn how to connect your application to us!" />
    <IntroductionInfo />
    <SDK />
  </section>
</template>

<style scoped>

</style>
