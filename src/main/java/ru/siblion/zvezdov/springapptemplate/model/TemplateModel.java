package ru.siblion.zvezdov.springapptemplate.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Dmitry on 23.09.2017.
 */
@XmlRootElement(name = "TemplateModel")
public class TemplateModel {
    public int id;
    public String name;

    public TemplateModel() {
    }

    public TemplateModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
