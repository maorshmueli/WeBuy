import javax.persistence.*;

@Entity
@Table(name="account_rank")
public class Account_Rank {

    @Id
    @Column(updatable = false)
    @GeneratedValue
    private int rank_id;


    @Column(nullable = false)
    private String rank_value;

    public Account_Rank(String val) {
        rank_value = val;
    }


    public int getRank_id() {
        return rank_id;
    }

    public void setRank_id(int rank_id) {
        this.rank_id = rank_id;
    }

    public String getRank_value() {
        return rank_value;
    }

    public void setRank_value(String rank_value) {
        this.rank_value = rank_value;
    }
}
