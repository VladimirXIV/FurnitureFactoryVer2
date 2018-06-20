package furniturefactory.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class OrderContent implements Serializable {

    private static final long serialVersionUID = -900L;

    @Id
    @Column(name = "ID")
    private long id;





}
