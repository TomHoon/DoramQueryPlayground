<template>
  <div id="app" class="container">
    <h1>Post cards with comments</h1>
    <p class="lead">
      Each card shows post index, username, post content, and a list of comments (comment index +
      content).
    </p>

    <div class="grid">
      <article
        v-for="post in posts"
        :key="post.id"
        class="card"
        role="article"
        :aria-label="'Post ' + post.id"
      >
        <div class="card-header">
          <div class="user">
            <div class="avatar">{{ initials(post.username) }}</div>
            <div>
              <div class="name" :title="post.username">{{ post.username }}</div>
              <div style="font-size: 12px; color: var(--muted)">Post #{{ post.id }}</div>
            </div>
          </div>

          <div class="meta">
            <div v-if="post.created" style="font-weight: 600">{{ post.created }}</div>
            <div style="font-size: 12px">Comments: {{ post.comments.length }}</div>
          </div>
        </div>

        <div class="content">{{ post.content }}</div>

        <div class="comments" v-if="post.comments && post.comments.length">
          <div class="comment" v-for="c in post.comments" :key="c.id">
            <div class="c-idx">#{{ c.id }}</div>
            <div class="c-body">{{ c.content }}</div>
          </div>
        </div>

        <div class="comments" v-else>
          <div style="font-size: 13px; color: var(--muted)">No comments yet</div>
        </div>
      </article>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      posts: [
        {
          id: 1,
          username: "Alice Johnson",
          content: "Hello world! I just started learning SQL today.",
          created: "2025-09-01",
          comments: [
            {id: 101, content: "Nice! Good luck."},
            {id: 102, content: "Which book are you using?"},
          ],
        },
        {
          id: 2,
          username: "Bob Kim",
          content: "My first post — excited to be here.",
          created: "2025-09-02",
          comments: [{id: 103, content: "Welcome Bob!"}],
        },
        {
          id: 9,
          username: "Ivy Chen",
          content: "Learning SQL joins today — hands-on practice.",
          created: "2025-09-07",
          comments: [
            {id: 104, content: "Try self-joins for pair problems."},
            {id: 105, content: "Group by helped me a lot."},
            {id: 106, content: "Nice example, thanks!"},
          ],
        },
        {
          id: 40,
          username: "Tom",
          content: "Writing code in the evening — peaceful.",
          created: "2025-10-08",
          comments: [],
        },
      ],
    };
  },
  methods: {
    initials(name) {
      return name
        .split(" ")
        .map((s) => s[0] || "")
        .slice(0, 2)
        .join("")
        .toUpperCase();
    },
  },
};
</script>

<style scoped>
:root {
  --bg: #f5f7fb;
  --card: #ffffff;
  --muted: #6b7280;
  --accent: #0ea5a4;
  --shadow: 0 6px 18px rgba(15, 23, 42, 0.08);
  font-family: Inter, system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue", Arial;
}
* {
  box-sizing: border-box;
}
body {
  margin: 0;
  background: linear-gradient(180deg, #eef2f7 0%, var(--bg) 100%);
  color: #0f1724;
  padding: 28px;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.container {
  max-width: 1100px;
  margin: 0 auto;
}

h1 {
  margin: 0 0 12px;
  font-size: 20px;
  color: var(--accent);
}
p.lead {
  margin: 0 0 20px;
  color: var(--muted);
  font-size: 14px;
}

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(320px, 1fr));
  gap: 16px;
  margin-top: 18px;
}

.card {
  background: var(--card);
  border-radius: 12px;
  padding: 14px;
  box-shadow: var(--shadow);
  display: flex;
  flex-direction: column;
  transition: transform 0.14s ease, box-shadow 0.14s ease;
  border: 1px solid rgba(15, 23, 42, 0.04);
}
.card:hover {
  transform: translateY(-6px);
  box-shadow: 0 14px 30px rgba(15, 23, 42, 0.08);
}

.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 10px;
}
.user {
  display: flex;
  align-items: center;
  gap: 10px;
}
.avatar {
  width: 44px;
  height: 44px;
  border-radius: 8px;
  display: grid;
  place-items: center;
  font-weight: 700;
  background: linear-gradient(135deg, #8ee0d7 0%, #54bdb6 100%);
  color: #05323a;
  flex: 0 0 44px;
}
.user .name {
  font-weight: 700;
  font-size: 15px;
  color: #052025;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  max-width: 160px;
}
.meta {
  text-align: right;
  color: var(--muted);
  font-size: 13px;
}

.content {
  color: #0b1220;
  font-size: 14px;
  line-height: 1.45;
  margin-bottom: 12px;
  white-space: pre-wrap;
}

.comments {
  margin-top: 6px;
  border-top: 1px dashed rgba(10, 15, 20, 0.04);
  padding-top: 10px;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.comment {
  display: flex;
  gap: 10px;
  align-items: flex-start;
}
.c-idx {
  min-width: 36px;
  font-size: 13px;
  color: var(--muted);
  text-align: right;
  padding-right: 6px;
}
.c-body {
  background: #f8fafc;
  border-radius: 8px;
  padding: 8px 10px;
  border: 1px solid rgba(10, 15, 20, 0.02);
  flex: 1;
  font-size: 13px;
  color: #0b1220;
}

/* small screen tweaks */
@media (max-width: 420px) {
  .avatar {
    width: 40px;
    height: 40px;
    font-size: 14px;
  }
  .user .name {
    max-width: 120px;
  }
}
</style>
