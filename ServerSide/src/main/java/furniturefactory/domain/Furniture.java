package furniturefactory.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class Furniture implements Serializable {

    private static final long serialVersionUID = -1000L;

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;




}
