<template>
  <div id="app">
    <h1>User Posts</h1>
    <div class="grid">
      <div v-for="post in posts" :key="post.id" class="card">
        <div class="header">
          <div class="index">#{{ post.id }}</div>
          <div class="username">{{ post.username }}</div>
        </div>
        <div class="content">{{ post.content }}</div>
        <div class="likes">❤️ {{ post.likes }} likes</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      posts: [
        {id: 1, username: "Alice", content: "Hello world!", likes: 12},
        {id: 2, username: "Bob", content: "My first post!", likes: 5},
        {id: 3, username: "Carlos", content: "Good morning everyone", likes: 9},
        {id: 4, username: "Diana", content: "Nice weather today", likes: 3},
        {id: 5, username: "Eun", content: "Just had lunch", likes: 7},
      ],
    };
  },
};
</script>

<style scoped>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background: #f4f6f9;
  padding: 30px;
}
h1 {
  margin-bottom: 20px;
}
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 16px;
}
.card {
  background: #fff;
  border-radius: 10px;
  padding: 16px;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.08);
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  transition: transform 0.2s;
}
.card:hover {
  transform: translateY(-5px);
}
.header {
  display: flex;
  justify-content: space-between;
  margin-bottom: 12px;
}
.index {
  font-weight: bold;
  color: #666;
}
.username {
  font-weight: 600;
  color: #333;
}
.content {
  flex: 1;
  margin-bottom: 14px;
  color: #444;
  font-size: 15px;
  line-height: 1.4;
}
.likes {
  text-align: right;
  font-size: 14px;
  font-weight: bold;
  color: #1d9d74;
}
</style>
