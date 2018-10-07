import javax.persistence.*;

@Entity
@Table(name="account_status")
public class Account_Status {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private int status_id;


    @Column(nullable = false)
    private String status_value;

    public Account_Status( String val) {
        this.status_value = val;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public String getStatus_value() {
        return status_value;
    }

    public void setStatus_value(String status_value) {
        this.status_value = status_value;
    }
}
