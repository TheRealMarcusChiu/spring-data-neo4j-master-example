//package com.neo4j.example.springdataneo4jintroapp.model2;
//
//import com.neo4j.example.springdataneo4jintroapp.converters.Location;
//import com.neo4j.example.springdataneo4jintroapp.converters.LocationConverter;
//import com.neo4j.example.springdataneo4jintroapp.model2.relationship.Gender;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;
//import org.neo4j.ogm.annotation.typeconversion.Convert;
//
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.validation.Valid;
//import javax.validation.constraints.NotBlank;
//
//@NodeEntity
//public class Service extends Asset<ApplicationModule> {
//
//    private Boolean test;
//
//    @NotBlank
//    private String serviceName;
//
//    @Valid
//    @Relationship(ModelType.Constant.REQUEST)
//    private Service service;
//
//    @Convert(LocationConverter.class)
//    private Location location;
//
//    @Enumerated(EnumType.STRING)
//    private ModelType type;
//
////    @Relationship(ModelType.Constant.RESPONSE)
//    private SubService subService;
//
//    public Boolean getTest() {
//        return test;
//    }
//    public void setTest(final Boolean test) {
//        this.test = test;
//    }
//
//    public String getServiceName() { return serviceName; }
//    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
//
//    public Service getService() { return service; }
//    public void setService(Service service) { this.service = service; }
//
//    public Location getLocation() {
//        return location;
//    }
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    public void setModelType(ModelType type) {
//        this.type = type;
//    }
//    public ModelType getModelType() {
//        return type;
//    }
//
//    public static enum ModelType {
//        REQUEST(Constant.REQUEST),
//        RESPONSE(Constant.RESPONSE);
//        ModelType(String str) {
//        }
//        public static class Constant {
//            public static final String REQUEST = "REQUEST";
//            public static final String RESPONSE = "RESPONSE";
//        }
//    }
//
//    public SubService getSubService() {
//        return subService;
//    }
//    public void setSubService(SubService subService) {
//        this.subService = subService;
//    }
//
//    public static void main(String args[]) {
//        var male = Gender.MALE;
//        System.out.println(Gender.MALE.name());
//        System.out.println(ModelType.REQUEST.toString());
//    }
//}
