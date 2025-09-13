package com.gdl.spring.todoapp.Pojo;

public class TodoList {
    private int userId;
    private int id;
    private String title;
    private boolean status;

    public TodoList(int userId, int id, String title, boolean status) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TodoList{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
