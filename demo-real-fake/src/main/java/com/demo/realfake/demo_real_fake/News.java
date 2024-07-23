package com.demo.realfake.demo_real_fake;


public class News {
    private String title;
    private String content;
    private String imagePath;

    public News(String title, String content, String imagePath) {
        this.title = title;
        this.content = content;
        this.imagePath = imagePath;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
