package vn.tma.standalone.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "student1", versionType = Document.VersionType.EXTERNAL)
@Getter
@Setter
public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
}
