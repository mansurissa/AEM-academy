package it.codeland.academy.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class SliderModel {
    private List<String> slides = new ArrayList<>();

    public List<String> getSlides() {
        return slides;
    }

    public void setSlides(List<String> slides) {
        this.slides = slides;
    }

    @PostConstruct
    protected void init(){
        slides.add("First slide");
        slides.add("Second slide");
        slides.add("Last slide");

    }
}
