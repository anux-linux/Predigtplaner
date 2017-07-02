package sbb.model;

public class PreachingTask {

    private final String key;
    private String name;
    private String description;

    public PreachingTask(String key, String name, String description) {
	this.key = key;
	this.name = name;
	this.description = description;
    }

    public String getKey() {
	return key;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getDescription() {
	return description;
    }

    public void seDescription(String description) {
	this.description = description;
    }
}
