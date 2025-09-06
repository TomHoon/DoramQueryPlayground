<template>
  <div>
    <div id="app" class="wrap">
      <h1>User comment cards</h1>
      <p class="lead">
        Each card shows <strong>user name</strong>, <strong>index</strong> (user id), and
        <strong>total comments</strong>.
      </p>

      <div class="grid">
        <article v-for="user in users" :key="user.id" class="card">
          <div class="avatar">{{ initials(user.name) }}</div>
          <div class="meta">
            <div class="name">{{ user.name }}</div>
            <div class="sub">User ID: {{ user.id }}</div>
          </div>
          <div class="badge">
            <div class="count">{{ user.total }}</div>
            <div class="idx">Total comments</div>
          </div>
        </article>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      users: [
        {id: 1, name: "Alice Johnson", total: 12},
        {id: 2, name: "Bob Kim", total: 7},
        {id: 3, name: "Carlos Rivera", total: 20},
        {id: 4, name: "Diana Lee", total: 3},
        {id: 5, name: "Eun Park", total: 15},
        {id: 6, name: "Frank Wu", total: 0},
        {id: 7, name: "Grace Li", total: 9},
        {id: 8, name: "Hiro Tanaka", total: 4},
        {id: 9, name: "Ivy Chen", total: 27},
        {id: 10, name: "Jon Snow", total: 11},
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
  --bg: #0f1724;
  --card: #0b1220;
  --muted: #9aa6b2;
  --accent: #6ee7b7;
  --glass: rgba(255, 255, 255, 0.03);
  font-family: Inter, ui-sans-serif, system-ui, -apple-system, "Segoe UI", Roboto, "Helvetica Neue",
    Arial;
}
* {
  box-sizing: border-box;
}
body {
  margin: 0;
  background: linear-gradient(180deg, #071029 0%, var(--bg) 100%);
  color: #e6eef6;
  padding: 40px;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
}

.wrap {
  max-width: 1100px;
  margin: 0 auto;
}

h1 {
  font-size: 22px;
  margin: 0 0 18px;
  color: var(--accent);
}
p.lead {
  margin: 0 0 28px;
  color: var(--muted);
}

/* Grid */
.grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(220px, 1fr));
  gap: 18px;
}

/* Card */
.card {
  background: linear-gradient(180deg, rgba(255, 255, 255, 0.02), rgba(255, 255, 255, 0.01));
  border: 1px solid rgba(255, 255, 255, 0.03);
  padding: 14px;
  border-radius: 12px;
  display: flex;
  align-items: center;
  gap: 12px;
  box-shadow: 0 6px 18px rgba(2, 6, 23, 0.6);
  transition: transform 0.18s ease, box-shadow 0.18s ease;
  backdrop-filter: blur(6px);
}
.card:hover {
  transform: translateY(-6px);
  box-shadow: 0 12px 30px rgba(2, 6, 23, 0.7);
}

.avatar {
  width: 56px;
  height: 56px;
  border-radius: 10px;
  display: grid;
  place-items: center;
  font-weight: 700;
  font-size: 18px;
  color: var(--bg);
  background: linear-gradient(135deg, #9ee7c0 0%, #4fd1c5 100%);
  flex: 0 0 56px;
}

.meta {
  flex: 1 1 auto;
  min-width: 0;
}
.meta .name {
  font-weight: 700;
  font-size: 15px;
  color: #f0fbf6;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
}
.meta .sub {
  font-size: 13px;
  color: var(--muted);
  margin-top: 6px;
}

.badge {
  text-align: right;
  min-width: 92px;
  display: flex;
  flex-direction: column;
  gap: 6px;
  align-items: flex-end;
}
.count {
  background: var(--glass);
  padding: 6px 10px;
  border-radius: 999px;
  font-weight: 700;
  color: var(--accent);
  font-size: 14px;
  border: 1px solid rgba(110, 231, 183, 0.08);
}
.idx {
  color: var(--muted);
  font-size: 12px;
}

/* small screens */
@media (max-width: 420px) {
  body {
    padding: 18px;
  }
  .avatar {
    width: 48px;
    height: 48px;
  }
}
</style>
