package com.models;

/**
 * Created by Dreawalker on 26.07.2017.
 */
public class Cake {

    private Integer id;
    private Type type;
    private CoverType cover;
    private String pathToImg;
    private DecorComplexity complexity;

    public Cake() {}

    public Cake(Type type, CoverType cover, String pathToImg, DecorComplexity complexity) {
        this.type = type;
        this.cover = cover;
        this.pathToImg = pathToImg;
        this.complexity = complexity;
    }

    public Cake(Integer id, Type type, CoverType cover, String pathToImg, DecorComplexity complexity) {
        this.id = id;
        this.type = type;
        this.cover = cover;
        this.pathToImg = pathToImg;
        this.complexity = complexity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public CoverType getCover() {
        return cover;
    }

    public void setCover(CoverType cover) {
        this.cover = cover;
    }

    public String getPathToImg() {
        return pathToImg;
    }

    public void setPathToImg(String pathToImg) {
        this.pathToImg = pathToImg;
    }

    public DecorComplexity getComplexity() {
        return complexity;
    }

    public void setComplexity(DecorComplexity complexity) {
        this.complexity = complexity;
    }
}
