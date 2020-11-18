

/**
 *
 * @author Nicole Aragao
 */

import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        
        //inicializar scanner
        Scanner scan = new Scanner (System.in);
        
        //inicializar banco
        Bank theBank = new Bank ("Banco da Nicole");
        
        //adicionar um usuario para o banco, que cria automaticamente uma conta de poupanca
        
        User primeiroUser = theBank.addUser("Nicole", "Aragao", "5913", 100.0);
        
        //adicionar uma conta corrente para o primeiro usuario 
        
        Account newAccount = new Account ("Checking", primeiroUser, theBank, 100.0);
        primeiroUser.addAccount(newAccount);
        theBank.addAccount(newAccount);
        
        
        User currentUser;
        
        while(true){
            //permanecer na janela ate que um login seja um sucesso
            
            currentUser = ATM.mainMenuPrompt(theBank, scan);
            
            //permancer no menu ate que user saia
            
            ATM.printUserMenu(currentUser, scan);
        }
}
    /**
     * Print ATM menu de login 
     * @param theBank o banco do objeto user que a conta utiliza
     * @param scan o objeto scanner utilizado para ler as informacoes do usuario
     * @return o usuario com combinacao de id e senha corretas
     */
    
    public static User mainMenuPrompt(Bank theBank, Scanner scan){
        
        //inicializando
        String userID;
        String pin;
        User authorizedUser;
        
        //pergunta ao usuario combo de id com senha ate que ele digite uma combinacao correta 
        do{
            System.out.printf("Welcome to %s\n\n", theBank.getName());
            System.out.print("Enter user ID: ");
            userID = scan.nextLine();
            System.out.print("Enter pin: ");
            pin = scan.nextLine();
            
           //retornar o objeto suer que coresponde essa combinacao de id e pin 
           
           authorizedUser = theBank.userLog(userID, pin);
           if(authorizedUser == null){
               System.out.println("Incorrect user ID/pin combination.Please try again.");
               
           }
        }while(authorizedUser == null); //continuar na tela de login ate que uma combinacao de usuario e senha seja inserida
        
        return authorizedUser;
    }
    
    public static void printUserMenu(User theUser, Scanner scan){
     
     
        
        int choice;
        
        //menu do usuario
        do {
            System.out.printf("Welcome %s, what would you like to do?", theUser.getFirstName());
            System.out.println("  1)Show history of transactions");
            System.out.println("  2)Withdrawal");
            System.out.println("  3)Deposit");
            System.out.println("  4)Transfer");
            System.out.println("  5)Quit");
            System.out.println("");
            System.out.println("Enter choice: ");
            choice = scan.nextInt();
            
            if(choice < 1 || choice > 5){
                System.out.println("Invalid choice.Please choose 1-5");
            }
    }while (choice < 1 || choice > 5);
        
        //processar a escolha feita no menu
        
        switch(choice){
            
            case 1:
                ATM.showTransHistory(theUser, scan);
                break;
            case 2:
                ATM.withdrawalMoney(theUser, scan);
                break;
            case 3:
                ATM.depositMoney(theUser,scan);
                break;
            case 4:
                ATM.transferFunds(theUser, scan);
                break;
                
        }
        //mostrar o menu do usuario novamente, a menos que ele queira sair
        if(choice!= 5){
            ATM.printUserMenu(theUser, scan);
        }
}
