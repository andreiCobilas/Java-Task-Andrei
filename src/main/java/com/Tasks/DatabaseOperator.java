package com.Tasks;

import java.util.HashMap;
import java.util.List;

public class DatabaseOperator {

    public static boolean isUserAllowed(List <Access> accesses, User user, Archive archive, int permission) {
        for(Access access: accesses){
            if(archive.getArchiveId().equals(access.getArchive().getArchiveId())
                    && access.getUser().getUserId().equals(user.getUserId())
                        && access.getPermission() == permission) return true;
        } return false;
    }

    public static boolean isUserAllowedToRead(List<Access> accesses, User user, Archive archive){
        return isUserAllowed(accesses,user,archive,1);
    }

    public static HashMap<User, Integer> getAccessors(List<Access> accesses){
        HashMap<User, Integer> user = new HashMap <User, Integer>();
        for(Access access : accesses){
            user.compute(access.getUser(), (k,v)->v == null ? 1: v + 1 );
        }
        return  user;
    }

}
