<script setup lang="ts">

</script>

<template>
  <div class="mx-auto max-w-screen-xl mb-10">
    <div class="py-8 px-4 sm:py-16 lg:px-12 bg-gray-100 dark:bg-gray-800 relative shadow-md sm:rounded-lg overflow-hidden">
      <div class="mb-4 border-b border-gray-200 dark:border-gray-700">
        <h2 class="text-2xl font-bold text-gray-600 dark:text-gray-200">Service development kit</h2>

        <ul class="flex flex-wrap -mb-px text-sm font-medium text-center" id="default-tab" data-tabs-toggle="#default-tab-content" role="tablist">
          <li class="me-2" role="presentation">
            <button class="inline-block p-4 border-b-2 rounded-t-lg" id="spigot-tab" data-tabs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">
              Minecraft (Spigot)
            </button>
          </li>
          <li class="me-2" role="presentation">
            <button class="inline-block p-4 border-b-2 rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="bungeecord-tab" data-tabs-target="#dashboard" type="button" role="tab" aria-controls="dashboard" aria-selected="false">
              Minecraft (BungeeCord)
            </button>
          </li>
          <li class="me-2" role="presentation">
            <button class="inline-block p-4 border-b-2 rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="velocity-tab" data-tabs-target="#settings" type="button" role="tab" aria-controls="settings" aria-selected="false">
              Minecraft (Velocity)
            </button>
          </li>
          <li role="presentation">
            <button class="inline-block p-4 border-b-2 rounded-t-lg hover:text-gray-600 hover:border-gray-300 dark:hover:text-gray-300" id="custom-tab" data-tabs-target="#contacts" type="button" role="tab" aria-controls="contacts" aria-selected="false">
              Custom
            </button>
          </li>
        </ul>
      </div>
      <div id="default-tab-content">

        <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="profile" role="tabpanel" aria-labelledby="spigot-tab">
          <h2 class="text-primary-600 font-bold text-xl">Usage</h2>
          <p class="text-sm text-gray-500 dark:text-gray-400">To use the mMetrics SDK in your plugin, you need to initialize it in your main class. Here is an example of how to do it:</p>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
public class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        new MMetrics(this, apiCode); // apiCode you can get from product page.
    }
}</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Maven</h2>
          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;repository&gt;
    &lt;id&gt;mmetrics-repo&lt;/id&gt;
    &lt;url&gt;https://maven.mmetrics.com&lt;/url&gt;
&lt;/repository&gt;</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;dependency&gt;
    &lt;groupId&gt;com.mmetrics&lt;/groupId&gt;
    &lt;artifactId&gt;mmetrics-spigot&lt;/artifactId&gt;
    &lt;version&gt;VERSION&lt;/version&gt;
&lt;/dependency&gt;</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Gradle</h2>

          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
repositories {
    maven {
        url 'https://maven.mmetrics.com'
    }
}</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
dependencies {
    implementation 'com.mmetrics:mmetrics-spigot:VERSION'
}</pre>
        </div>

        <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="dashboard" role="tabpanel" aria-labelledby="dashboard-tab">
          <h2 class="text-primary-600 font-bold text-xl">Usage</h2>
          <p class="text-sm text-gray-500 dark:text-gray-400">To use the mMetrics SDK in your plugin, you need to initialize it in your main class. Here is an example of how to do it:</p>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
public class MyPlugin extends Plugin {
    @Override
    public void onEnable() {
        new MMetrics(this, apiCode); // apiCode you can get from product page.
    }
}</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Maven</h2>
          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;repository&gt;
    &lt;id&gt;mmetrics-repo&lt;/id&gt;
    &lt;url&gt;https://maven.mmetrics.com&lt;/url&gt;
&lt;/repository&gt;</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;dependency&gt;
    &lt;groupId&gt;com.mmetrics&lt;/groupId&gt;
    &lt;artifactId&gt;mmetrics-bungeecord&lt;/artifactId&gt;
    &lt;version&gt;VERSION&lt;/version&gt;
&lt;/dependency&gt;</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Gradle</h2>

          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
repositories {
    maven {
        url 'https://maven.mmetrics.com'
    }
}</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
dependencies {
    implementation 'com.mmetrics:mmetrics-bungeecord:VERSION'
}</pre>
        </div>
        <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="settings" role="tabpanel" aria-labelledby="settings-tab">

          <h2 class="text-primary-600 font-bold text-xl">Usage</h2>
          <p class="text-sm text-gray-500 dark:text-gray-400">To use the mMetrics SDK in your plugin, you need to initialize it in your main class. Here is an example of how to do it:</p>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
public class VelocityPlugin {

    private final ProxyServer proxyServer;

    @Inject
    public VelocityPlugin(
        ProxyServer proxyServer,
    ) {
        this.proxyServer = proxyServer;
    }

    @Subscribe
    public void onProxyInitialization(@NotNull ProxyInitializeEvent event) {
        new MMetrics(this, apiCode); // apiCode you can get from product page.
    }
}</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Maven</h2>
          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;repository&gt;
    &lt;id&gt;mmetrics-repo&lt;/id&gt;
    &lt;url&gt;https://maven.mmetrics.com&lt;/url&gt;
&lt;/repository&gt;</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>pom.xml</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
&lt;dependency&gt;
    &lt;groupId&gt;com.mmetrics&lt;/groupId&gt;
    &lt;artifactId&gt;mmetrics-velocity&lt;/artifactId&gt;
    &lt;version&gt;VERSION&lt;/version&gt;
&lt;/dependency&gt;</pre>

          <h2 class="text-primary-600 font-bold text-xl mt-10">Gradle</h2>

          <h4 class="text-gray-500 font-semibold mt-6">Repository</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following repository to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
repositories {
    maven {
        url 'https://maven.mmetrics.com'
    }
}</pre>

          <h4 class="text-gray-500 font-semibold mt-4">Dependency</h4>
          <span class="text-gray-500 dark:text-gray-400 text-sm">Add the following dependency to your <code>build.gradle</code> file:</span>
          <pre class="text-sm text-primary-600 dark:text-gray-400 bg-gray-200 dark:bg-gray-800 rounded-lg p-4 mt-2">
dependencies {
    implementation 'com.mmetrics:mmetrics-velocity:VERSION'
}</pre>
        </div>
        <div class="hidden p-4 rounded-lg bg-gray-50 dark:bg-gray-800" id="contacts" role="tabpanel" aria-labelledby="contacts-tab">
          <p class="text-sm text-gray-500 dark:text-gray-400">Soon</p>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

</style>
