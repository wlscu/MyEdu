package com.laowang.entity;

/**
 * @author 隔壁老王
 */
public class Course {
    private Integer cid;
    private String courseName;
    private String descs;
    private Integer courseType;
    private String courseImage;
    private String courseVideo;
    private Double coursePrice;
    private Integer status; // 课程状态 0：未上架 1：上架 2：下架
    private String createTime;

    public Course() {
    }

    public Course(Integer cid, String courseName, String descs, Integer courseType, String courseImage, String courseVideo, Double coursePrice, Integer status, String createTime) {
        this.cid = cid;
        this.courseName = courseName;
        this.descs = descs;
        this.courseType = courseType;
        this.courseImage = courseImage;
        this.courseVideo = courseVideo;
        this.coursePrice = coursePrice;
        this.status = status;
        this.createTime = createTime;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }

    public Integer getCourseType() {
        return courseType;
    }

    public void setCourseType(Integer courseType) {
        this.courseType = courseType;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCourseVideo() {
        return courseVideo;
    }

    public void setCourseVideo(String courseVideo) {
        this.courseVideo = courseVideo;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
