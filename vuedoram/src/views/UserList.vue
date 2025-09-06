<template>
  <div>
    <div class="header">
      <h1>User List</h1>
      <!-- <div class="filter-buttons">
        <button>All</button>
        <button>City</button>
        <button>Birth Year</button>
        <button>Username</button>
      </div> -->
    </div>

    <div class="search-area">
      <select v-model="category">
        <option value="city">City</option>
        <option value="username">Username</option>
        <option value="birthYear">Birth Year</option>
      </select>
      <input type="text" placeholder="Enter keyword" v-model="city" />
      <button @click="searchByCategory">Search</button>
    </div>

    <div class="user-list">
      <div class="user-card" v-for="(item, index) in list" :key="index">
        <p class="index">{{ index }}</p>
        <h3>{{ item.username }}</h3>
        <p>{{ item.birthYear }}</p>
        <p>{{ item.city }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

// 전체
// {city} 만
// {x} 년생만
// 생일 {오름/내림} 차순
// 유저 총 카운트
// 제일 {어린/많은} 유저
// '구'가 들어있는 유저

export default {
  data() {
    return {
      category: "city",
      list: [],
      city: "",
    };
  },
  async mounted() {
    // this.searchAll();
    axios.get("http://localhost:12000/api/v1/like/likes");
  },
  methods: {
    // ✅️{city} 만
    async searchByCategory() {
      if (!this.category) {
        this.searchAll();
        return;
      }

      const findCityURL = "http://localhost:12000/api/v1/users/" + this.city;
      const res = await axios.get(findCityURL);
      this.list = res?.data || [];
    },

    async searchAll() {
      const searchAll = "http://localhost:12000/api/v1/users";

      const res = await axios.get(searchAll);
      this.list = res?.data || [];
    },
  },
};
</script>

<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 20px;
}

.header {
  max-width: 900px;
  margin: 0 auto 20px auto;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header h1 {
  margin: 0;
  font-size: 28px;
  color: #333;
}

.filter-buttons {
  display: flex;
  gap: 10px;
}

.filter-buttons button {
  padding: 8px 16px;
  font-size: 14px;
  border: none;
  border-radius: 4px;
  background-color: #28a745;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.2s;
}

.filter-buttons button:hover {
  background-color: #218838;
}

/* Search area */
.search-area {
  max-width: 900px;
  margin: 0 auto 30px auto;
  display: flex;
  gap: 10px;
  justify-content: center;
  align-items: center;
}

.search-area select,
.search-area input {
  padding: 8px 10px;
  font-size: 14px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-area button {
  padding: 8px 16px;
  font-size: 14px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
  transition: background-color 0.2s;
}

.search-area button:hover {
  background-color: #0056b3;
}

/* User cards */
.user-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
}

.user-card {
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
  padding: 15px 20px;
  width: 200px;
  transition: transform 0.2s, box-shadow 0.2s;
}

.user-card:hover {
  transform: translateY(-5px);
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
}

.user-card h3 {
  margin: 0 0 10px;
  font-size: 18px;
  color: #333;
}

.user-card p {
  margin: 4px 0;
  color: #555;
  font-size: 14px;
}

.user-card .index {
  font-weight: bold;
  color: #007bff;
}
</style>
