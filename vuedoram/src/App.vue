<template>
  <nav>
    <router-link to="/detail">Detail</router-link> | <router-link to="/about">About</router-link> |
    <router-link to="/users">Users</router-link> |
    <router-link to="/userWithTotalComments">userWithTotalComments</router-link> |
    <router-link to="/usernameContentGetLikes">UsernameContentGetLikes</router-link> |
    <router-link to="/usersPostsGetComments">UsersPostsGetComments</router-link> |
    <router-link to="/PostWithoutComments">PostWithoutComments</router-link> |
    <router-link to="/posts">Posts</router-link>
  </nav>

  <!-- where the pages will load -->
  <router-view />
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
