// src/router/index.js
import {createRouter, createWebHistory} from "vue-router";

// Import your components
import About from "../views/AboutPage.vue";
import BoardDetail from "../views/BoardDetail.vue";
import UserList from "../views/UserList.vue";
import PostList from "../views/PostList.vue";
import UserWithTotalComments from "../views/UserWithTotalComments.vue";
import UsernameContentGetLikes from "../views/UsernameContentGetLikes.vue";
import UsersPostsGetComments from "../views/UsersPostsGetComments.vue";
import PostWithoutComments from "../views/PostWithoutComments.vue";

// Define routes
const routes = [
  {path: "/about", name: "About", component: About},
  {path: "/detail", name: "BoardDetail", component: BoardDetail},
  {path: "/users", name: "UserList", component: UserList},
  {path: "/posts", name: "PostList", component: PostList},
  {path: "/userWithTotalComments", name: "UserWithTotalComments", component: UserWithTotalComments},
  {path: "/usersPostsGetComments", name: "UsersPostsGetComments", component: UsersPostsGetComments},
  {path: "/PostWithoutComments", name: "PostWithoutComments", component: PostWithoutComments},
  {
    path: "/usernameContentGetLikes",
    name: "UsernameContentGetLikes",
    component: UsernameContentGetLikes,
  },
];

// Create router
const router = createRouter({
  history: createWebHistory(), // uses HTML5 history mode
  routes,
});

export default router;
