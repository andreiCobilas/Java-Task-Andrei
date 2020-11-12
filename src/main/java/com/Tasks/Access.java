package com.Tasks;

public class Access {
    private User user;
    private Archive archive;
    private Integer permission;


    public Access(User user, Archive archive, Integer permission) {
        this.user = user;
        this.archive = archive;
        this.permission = permission;
    }

    public Integer getPermission() {
        return permission;
    }

    public Archive getArchive() {
        return archive;
    }

    public User getUser() {
        return user;
    }
}
