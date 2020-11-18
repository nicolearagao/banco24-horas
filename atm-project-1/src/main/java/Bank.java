
import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Nicole Arag
 */
public class Bank {

    //nome do banco
    private String name;

    //lista de clientes
    private ArrayList<User> users;

    //lista de contas que o banco carrega 
    private ArrayList<Account> accounts;
    
    /*
    *Instanciar um objeto da classe banco com listas vazias para usuarios e contas
    *@param name - nome do banco criado 
    */
    public Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
}


    /**
     * gerar id unica para o usuario
     * @return nova id unica para usuario
     */
    public String getNewUserUUID() {
        String uuid;
        Random numberGen = new Random();
        int len = 6;
        boolean nonUnique;

        //continuar com o loop enquanto nao recebemos uma id unica 
        do {
            uuid = "";
            for (int i = 0; i < len; i++) {

                //casting a int para Integer para poder chamar o metodo toString
                uuid += ((Integer) numberGen.nextInt(10)).toString();

            }

            nonUnique = false;
            for (User u : this.users) {
                if (uuid.compareTo(u.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }


    /**
     * gerar id unica para contas
     * @return retorna id unica para cada conta criada 
     */
    public String getNewAccountUUID() {
      String uuid;
        Random numberGen = new Random();
        int len =10;
        boolean nonUnique;

        //continuar com o loop enquanto nao recebmos uma id unica 
        do {
            uuid = "";
            for (int i = 0; i < len; i++) {

                //casting a int para Integer para poder chamar o metodo toString
                uuid += ((Integer) numberGen.nextInt(10)).toString();

            }

            nonUnique = false;
            for (Account a: this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0) {
                    nonUnique = true;
                    break;
                }
            }

        } while (nonUnique);

        return uuid;
    }
    /**
     * adiciona conta a lista de contas do banco 
     * @param onAcct a conta a ser adicionada a lista de contas do banco
     */
    public void addAccount(Account onAcct){
        this.accounts.add(onAcct);
    }

   
    
   /*criar um novo usuario e adiciona-lo a lista
    *@return novo usuario do banco especifico
    */
    public User addUser(String firstName, String lastName, String pin,double balance){
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);
        
        //criar uma nova conta para o usuario, estou definindo contas poupancas como padrao para a primeira abertura de conta
        //adicionando a conta nova criada a lista de contas do banco e a lista de conta do usuario
       
        Account newAcct = new Account("Savings", newUser, this, balance);
        newUser.addAccount(newAcct);
        this.accounts.add(newAcct);
        
        return newUser;
    }
    
    /**
     * metodo para verificar se usuario existe no sistema e se senha corresponde
     * @param userID usuario a ser verificado
     * @param pin senha a ser conferida
     * @return retorna usuario caso ambos usuario e senha tenham sido locaalizados e correspondem, retorna null no caso de usuario invalido ou senha nao correspondente a um usuario existente
     */
    public User userLog(String userID, String pin){
        //procurar na lista de usuarios existentes
        for(User u : this.users){
            
            //checar se a user ID fornecida corresponde a uuid de determinado cliente e se pin e valido
            
            if(u.getUUID().compareTo(userID)== 0 && u.validatePin(pin)){
                return u;
            }
        }
        //se usuario nao for localizado ou pin incorreto
        return null;
    }
    
    /**
     * 
     * @return retorna o nome do banco
     */
    public String getName(){
        return this.name;
    }
    
    
}
