<template>
  <div>
    <div class="board-container">
      <div class="board-title">Example Board Title</div>
      <div class="board-meta">
        Author:
        <span>Tom</span> | Date:
        <span>2025-09-06</span>
      </div>
      <div class="board-content">
        This is the content of the board. You can write detailed information, images, or anything
        you want here.
      </div>

      <div class="comments">
        <h3>Comments</h3>
        <div class="comment">
          <span class="comment-author">Alice</span>
          <span class="comment-date">2025-09-06</span>
          <div class="comment-content">This is a comment example.</div>
        </div>
        <div class="comment">
          <span class="comment-author">Bob</span>
          <span class="comment-date">2025-09-06</span>
          <div class="comment-content">Another comment goes here.</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script></script>

<style>
body {
  font-family: Arial, sans-serif;
  background-color: #f4f4f4;
  margin: 0;
  padding: 0;
}
.board-container {
  max-width: 800px;
  margin: 50px auto;
  background-color: #fff;
  padding: 20px 30px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  border-radius: 8px;
}
.board-title {
  font-size: 28px;
  font-weight: bold;
  margin-bottom: 10px;
}
.board-meta {
  font-size: 14px;
  color: #777;
  margin-bottom: 20px;
}
.board-content {
  font-size: 16px;
  line-height: 1.6;
  margin-bottom: 30px;
}
.comments {
  border-top: 1px solid #ddd;
  padding-top: 20px;
}
.comment {
  margin-bottom: 15px;
}
.comment-author {
  font-weight: bold;
  margin-right: 10px;
}
.comment-date {
  color: #999;
  font-size: 12px;
}
.comment-content {
  margin-top: 5px;
  padding-left: 10px;
}
</style>
