package com.project.app.user.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceNotFoundException extends Exception {
    
    private String resourceName;
    private long  resourceId;
    

    public ResourceNotFoundException(String resourceName, long resourceId) {
        super("Resource '"+resourceName+"' with id="+resourceId+" was not Found!!! :(");
        this.resourceName = resourceName;
        this.resourceId = resourceId;
    }


    public String getResourceName() {
        return resourceName;
    }
    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    public long getResourceId() {
        return resourceId;
    }
    public void setResourceId(long resourceId) {
        this.resourceId = resourceId;
    }
    
}
