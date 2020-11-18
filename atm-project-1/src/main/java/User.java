
import java.util.ArrayList;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*

 * @author Nicole Aragao
 */

public class User {

    //primeiro nome do usuario   
    private String firstName;

    //sobrenome usuario
    private String lastName;

    //identificador universal do usuario
    private String uuid;

    //MD5 hash da senha do usuario
    private byte pinHash[];

    //colecao de contas do usuario
    private ArrayList<Account> accounts;
    
   
    /**
    *Criar um novo usuario
    *@param firstName usuario nome
    *@param lastName sobrenome do usuario
    *@param pin a senha da conta do usuario
    @param theBank o objeto banco do qual o usuario e cliente
    * @param balance saldo inicial da conta
    */

    public User(String firstName, String lastName, String pin, Bank theBank) {
        this.firstName = firstName;
        this.lastName = lastName;

        try {
            //guardar a senha em MD5 hash para preservar a seguranca

            MessageDigest md = MessageDigest.getInstance("MD5");

            //digerindo o pin original com o algoritmo MD5 e armazenando no atributo
            this.pinHash = md.digest(pin.getBytes());
        
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("error, caught noSuchAlgorithmException");
            ex.printStackTrace();
            System.exit(1);
        }

        //gerar uma id unica, universal para o usuario 
        this.uuid = theBank.getNewUserUUID();
        
        //criar lista vazia de contas;
        this.accounts = new ArrayList<>();
        
        
        
      
        //print log message 
        //usando String format examples printf + %s para Strings
        System.out.printf("New user %s, %s with ID %s created.\n", firstName, lastName, this.uuid);

    }
    /** Adicionar uma conta a lista do usuario 
    *@param onAcct a conta a ser adicionada
    */
    
    public void addAccount(Account onAcct){
        this.accounts.add(onAcct);
    }
    /**
     * 
     * @return retornar a uuid do usuario 
     */
    
    public String getUUID(){
        return this.uuid;
    }
    /** Checar se o pin fornecido pelo usuario e valido ou nao 
     * 
     * @param pin a ser checado
     * @return se o pin e valido ou nao 
     */
    
    public boolean validatePin(String pin){
       try{
         MessageDigest md = MessageDigest.getInstance("MD5"); 
         return MessageDigest.isEqual(md.digest(pin.getBytes()), this.pinHash);
       
       }catch (NoSuchAlgorithmException ex) {
            System.err.println("error, caught noSuchAlgorithmException");
            ex.printStackTrace();
            System.exit(1);
        }
        return false;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    
}
