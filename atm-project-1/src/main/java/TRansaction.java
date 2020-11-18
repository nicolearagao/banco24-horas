
import java.util.Date;

/**
 *
 * @author Nicole Aragao 
 */
public class TRansaction {
    
    //valor da transacao
    private double amount;
    
    //hora e data da transacao
    private Date timestamp;
    
    //extrato para a transacao
    private String memo;
    
    //Conta relacionada a transacao
    private Account inAccount;

    /**
     * instancia um objeto transaction recebendo uma quantia e a conta que esta sendo feita
     * @param amount quantia da transacao
     * @param inAccount conta em que ela acontece 
     */
    public TRansaction(double amount, Account inAccount) {
        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo= "";
    }
 
    /**
     * instancia um objeto transaction recebendo uma quantia e a conta que esta sendo feita
     * @param amount quantia da transacao
     * @param memo
     * @param inAccount conta em que ela acontece
     */
    public TRansaction(double amount, String memo, Account inAccount) {
       this(amount, inAccount);
       
       this.memo = memo;
    }
    
    
  
    
}
