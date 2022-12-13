package edu.upc.eetac.dsa.model;

public class ObjectType {
    String objectTypeId;
    String objectTypeDescription;

    public ObjectType() {
    }

    public ObjectType(String objectTypeId, String objectTypeDescription) {
        this.objectTypeId = objectTypeId;
        this.objectTypeDescription = objectTypeDescription;
    }

    public String getObjectTypeId() {
        return objectTypeId;
    }

    public void setObjectTypeId(String objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    public String getObjectTypeDescription() {
        return objectTypeDescription;
    }

    public void setObjectTypeDescription(String objectTypeDescription) {
        this.objectTypeDescription = objectTypeDescription;
    }
}
