package com.requestModel;

import java.util.List;

public class PetDetails {
	
	private int id;

    private Category category;

    private String name;

    private List<String> photoUrls;

    private List<Tags> tags;

    private String status;

    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setCategory(Category category){
        this.category = category;
    }
    
    public Category getCategory(){
        return this.category;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public void setPhotoUrls(List<String> photoUrls){
        this.photoUrls = photoUrls;
    }
    
    public List<String> getPhotoUrls(){
        return this.photoUrls;
    }
    
    public void setTags(List<Tags> tags){
        this.tags = tags;
    }
    
    public List<Tags> getTags(){
        return this.tags;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getStatus(){
        return this.status;
    }

}
