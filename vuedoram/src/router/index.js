// src/router/index.js
import {createRouter, createWebHistory} from "vue-router";

// Import your components
import About from "../views/AboutPage.vue";
import BoardDetail from "../views/BoardDetail.vue";
import UserList from "../views/UserList.vue";
import PostList from "../views/PostList.vue";

// Define routes
const routes = [
  {path: "/about", name: "About", component: About},
  {path: "/detail", name: "BoardDetail", component: BoardDetail},
  {path: "/users", name: "UserList", component: UserList},
  {path: "/posts", name: "PostList", component: PostList},
];

// Create router
const router = createRouter({
  history: createWebHistory(), // uses HTML5 history mode
  routes,
});

export default router;
