<template>
  <div class="app">
    <header class="app-header">
      <h1>Post Feed</h1>
      <button class="new-post-btn">New Post</button>
    </header>

    <main class="feed">
      <article class="post" aria-label="post-101" v-for="(item, index) in list" :key="index">
        <div class="avatar">{{ item.postId }}</div>
        <div>
          <div class="post-head">
            <div class="meta-left">
              <div>
                <div class="username">{{ item.postId }}</div>
                <div class="post-date">{{ item.postDate }}</div>
              </div>
              <div class="post-index">#101</div>
            </div>
            <!-- optional right-side (e.g., menu) -->
          </div>

          <div class="post-content">
            {{ item.content }}
          </div>

          <div class="post-footer">
            <div class="action"><span class="like-dot" aria-hidden="true"></span> Like</div>
            <div class="action">Comment</div>
            <div class="action">Share</div>
            <div style="margin-left: auto; color: var(--muted); font-size: 13px">
              posted 2 hours ago
            </div>
          </div>
        </div>
      </article>
    </main>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "App",
  components: {},
  data() {
    return {
      list: [],
    };
  },

  async mounted() {
    const {data} = await axios.get("http://localhost:12000/api/v1/post/posts");
    this.list = data;
    console.log("data ", data);
  },
};
</script>

<style>
:root {
  --bg: #f2f5f7;
  --card: #ffffff;
  --muted: #6b7280;
  --accent: #1877f2;
  --radius: 12px;
  --shadow: 0 6px 18px rgba(20, 30, 60, 0.08);
  --gap: 18px;
  --max-width: 760px;
}

/* Reset-ish */
* {
  box-sizing: border-box;
}
body {
  margin: 0;
  font-family: Inter, "Segoe UI", Roboto, "Helvetica Neue", Arial;
  background: linear-gradient(180deg, var(--bg), #eef3f7 120%);
  color: #111827;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  padding: 28px 16px;
  display: flex;
  justify-content: center;
}

.app {
  width: 100%;
  max-width: var(--max-width);
}

header.app-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 12px;
  margin-bottom: 18px;
}

header h1 {
  margin: 0;
  font-size: 20px;
  letter-spacing: -0.2px;
}

.new-post-btn {
  background: var(--accent);
  color: white;
  padding: 8px 12px;
  border-radius: 8px;
  border: none;
  cursor: pointer;
  font-weight: 600;
}

/* Feed container */
.feed {
  display: flex;
  flex-direction: column;
  gap: var(--gap);
}

/* Post card */
.post {
  cursor: pointer;
  background: var(--card);
  border-radius: var(--radius);
  box-shadow: var(--shadow);
  padding: 14px;
  display: grid;
  grid-template-columns: 52px 1fr;
  gap: 12px;
  align-items: start;
}

.avatar {
  width: 52px;
  height: 52px;
  border-radius: 50%;
  flex-shrink: 0;
  background: linear-gradient(135deg, #e6eefc, #d7f0ff);
  display: flex;
  align-items: center;
  justify-content: center;
  color: #0b4fa1;
  font-weight: 700;
  font-size: 18px;
}

.post-head {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 8px;
}

.meta-left {
  display: flex;
  gap: 10px;
  align-items: center;
}

.username {
  font-weight: 700;
  font-size: 15px;
  color: #0f172a;
}

.post-index {
  font-size: 12px;
  color: var(--muted);
  background: #f3f7fb;
  padding: 4px 8px;
  border-radius: 999px;
  border: 1px solid #eef5ff;
}

.post-date {
  display: block;
  font-size: 12px;
  color: var(--muted);
}

.post-content {
  margin-top: 8px;
  font-size: 15px;
  line-height: 1.55;
  color: #111827;
  white-space: pre-wrap;
}

.post-footer {
  margin-top: 12px;
  display: flex;
  gap: 12px;
  align-items: center;
  border-top: 1px solid #eef2f6;
  padding-top: 10px;
}

.action {
  display: inline-flex;
  align-items: center;
  gap: 8px;
  padding: 8px 10px;
  border-radius: 8px;
  font-size: 14px;
  color: var(--muted);
  cursor: pointer;
  user-select: none;
}

.action:hover {
  background: #f8fbff;
  color: #0f172a;
}

.like-dot {
  width: 8px;
  height: 8px;
  border-radius: 50%;
  background: var(--accent);
  box-shadow: 0 1px 4px rgba(24, 119, 242, 0.25);
}

/* small screens */
@media (max-width: 520px) {
  .post {
    grid-template-columns: 44px 1fr;
    padding: 12px;
    gap: 10px;
  }
  .avatar {
    width: 44px;
    height: 44px;
    font-size: 16px;
  }
  .post-index {
    display: none;
  } /* hide index on very small */
}
</style>
