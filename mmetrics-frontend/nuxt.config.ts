// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  components: {
    dirs: [
      '~/components', // skanuje wszystkie pliki w katalogu components
      '~/components/home' // dodaj ścieżkę do dodatkowego katalogu
    ]
  },
  runtimeConfig: {
    test: 'TEST',
  },
  modules: [
    '@nuxtjs/tailwindcss'
  ],
})
