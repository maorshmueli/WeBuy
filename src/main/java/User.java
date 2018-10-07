import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column(nullable=false,updatable = false)
    private int user_id;

    @Column(nullable=false)
    private String username;

    @Column(nullable=false)
    private String email;

    @Column(nullable=false)
    private String pw;

    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    private Date reg_date;

    @Column(nullable=false)
    private String first_name;

    @Column(nullable=false)
    private String last_name;

    @Column(nullable=false,updatable = false)
    private long id_number;

    @ManyToOne
    @JoinColumn(name="account_rank",nullable=false,foreignKey=@ForeignKey(name="fk_to_account_rank"))
    private Account_Rank account_rank;

    @ManyToOne
    @JoinColumn(name="account_status",nullable=false,foreignKey=@ForeignKey(name="fk_to_account_status"))
    private Account_Status account_status;

    public User(String username,String pw,String email,String fname,String lname,Account_Rank rank,Account_Status status,long id_num)
    {
        this.username=username;
        this.pw=pw;
        this.email=email;
        this.first_name=fname;
        this.last_name=lname;
        this.account_rank=rank;
        this.account_status=status;
        this.id_number=id_num;
        this.reg_date = new Date();
    }
}
