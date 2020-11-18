
import java.util.ArrayList;


/**
 *
 * @author Nicole Aragao
 */
public class Account {

    //nome da conta
    private String name;

    //id universal
    private String uuid;

    //usuario da conta
    private User holder;
    
    //saldo inicial da conta
    private double balance;

    //lista de transacoes executadas
    private ArrayList<TRansaction> transactions;
   /**
    * instancia um novo objeto da classe Account
    * @param name nome da conta, savings, checkings, investiments 
    * @param holder nome do usuario da conta
    * @param theBank objeto banco a qual a conta pertence
    */
    
    public Account(String name, User holder, Bank theBank, double balance) {
        // nome da conta e usuario
        this.name = name;
        this.holder = holder;

        //metodo do banco que estabelece ids unicos para as contas
        this.uuid = theBank.getNewAccountUUID();

        //iniciar transacoes
        this.transactions = new ArrayList<TRansaction>();
        
        this.balance = balance;

        
    }
    /**
     * metodo que retorna a uuid unica da conta
     * @return uuid unica da conta 
     */
    public String getUUID(){
        return this.uuid;
    }
    
    public double getBalance(){
        return this.balance;
    }

}
