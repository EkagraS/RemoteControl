package com.example.remotecontrol;

public class AnnouncementData {
    String announcementId, announcementTitle, announcementBody, announcementSubTitle;

    public AnnouncementData() {
    }

    public AnnouncementData(String announcementBody, String announcementSubTitle, String announcementTitle, String announcementId) {
        this.announcementBody = announcementBody;
        this.announcementSubTitle = announcementSubTitle;
        this.announcementTitle = announcementTitle;
        this.announcementId = announcementId;
    }

    public String getId() {
        return announcementId;
    }

    public void setId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getAnnouncementBody() {
        return announcementBody;
    }

    public void setAnnouncementBody(String announcementBody) {
        this.announcementBody = announcementBody;
    }

    public String getAnnouncementSubTitle() {
        return announcementSubTitle;
    }

    public void setAnnouncementSubTitle(String announcementSubTitle) {
        this.announcementSubTitle = announcementSubTitle;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }
}
