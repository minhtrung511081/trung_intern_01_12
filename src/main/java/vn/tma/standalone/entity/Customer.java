package vn.tma.standalone.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "student1")
@Getter
@Setter
public class Customer {

    private String id;

    @Field(name = "name", type = FieldType.Text)
    private String name;

    @Field(name = "address", type = FieldType.Text)
    private String address;
}
