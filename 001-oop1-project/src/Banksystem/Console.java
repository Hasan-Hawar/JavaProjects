package Banksystem;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.Scanner;

import extendedFunctions.Formatter;

/**
 * This console is only used by a bank employee and contains all the important customer service methods 
 * like create a new customer or a bank account, withdraw or deposit money etc..
 *
 */

public class Console {

  ICustomerService ics;
  Formatter formatter;

  /**
   * This constructs use an interface for the remote method invocation .
   * @param ics Remote Interface contains Customer Service methods
   * @throws Exception
   */
  public Console(ICustomerService ics)  {

    this.ics = ics;

  }

  Scanner scanner = new Scanner(System.in);

  /**
   * This mainView method start with the primary page of the console.
   * Switch case will forwarded to the next view or exit the console.
   * @throws Exception throws an Exception if one of the switch case method fail.
   */
  void mainView() throws Exception {

    boolean quit = true;
    System.out.println("=================================================");
    System.out.println("|            BANK 'NAME' HAUPTMENUE             |");
    System.out.println("=================================================");
    System.out.println("|        Gewuenschte Option eingeben:           |");
    System.out.println("|                                               |");
    System.out.println("|         '1' fuer Kunden erfassen              |");
    System.out.println("|         '2' fuer bei einem Kunden einloggen   |");
    System.out.println("|                                               |");
    System.out.println("|                                               |");
    System.out.println("|         '3' fuer Beenden                      |");
    System.out.println("=================================================");
    System.out.println(" ");
    int number = scanner.nextInt();
    System.out.println(" ");
    System.out.println(" ");
    System.out.println(" ");


    while (quit) {

      switch (number) {

        case 1:
          System.out.println("'Kunden erfassen' wurde ausgewaehlt");
          System.out.println(" ");
          createCustomer();
          break;

        case 2:
          System.out.println("'Bei einem Kunden einloggen' wurde ausgewaehlt");
          System.out.println(" ");
          loggin();
          break;

        case 3:
          System.out.println("Beenden wurde ausgewaehlt");
          System.out.println("Auf Wiedersehen");
          System.out.println(" ");
          quit = false;

        default:
          System.out.println("Ungueltige Eingabe");
          System.out.println(" ");
      }
    }
  }

 /**
  * The method take the user input to create a new Customer. 
  * @throws RemoteException throws if remote method calls fail.
  */
  void createCustomer()  {

    System.out.println(" ");
    System.out.println("=================================================");
    System.out.println("|                 Kunden erfassen               |");
    System.out.println("=================================================");
    System.out.println(" ");
    System.out.println("Nachname eingeben: ");
    String lastName = scanner.nextLine();
    System.out.println("Vorname eingeben: ");
    String firstName = scanner.nextLine();
    System.out.println("Passwort eingeben: ");
    String password = scanner.nextLine();
    System.out.println(" ");

    try {
      String customer = ics.createCustomer(firstName, lastName, password);
      String[] customerData = formatter.getSplitedString(customer);
      System.out.println("Kunde " + lastName + " " + firstName + " wurde erfasst");
      System.out.println("Kundennummer lautet: " + customerData[0]);

    } catch (NullPointerException | RemoteException e) {

      System.out.print("Exception aufgefangen");
    }
  }

  /**
   * This method ask for a customerNumber to use after the main customer service methods
   * @throws IOException  if the asked input is not correct.
   * @throws RemoteException throws if remote method calls fail.
   * @throws BankLimitException if the defined bank limit will be reached. 
 */
  void loggin() throws IOException, BankLimitException {

    try {

      boolean exit = true;

      while (exit) {

        String customerNumber;
        String customer;
        String customerData[];
        String[] accounts = new String[15];



        System.out.println(" ");
        System.out.println("=================================================");
        System.out.println("|                   LOGIN                       |");
        System.out.println("=================================================");
        System.out.println(" ");


        System.out.println("Kundenummer eingeben: ");
        System.out.println(" ");
        customerNumber = scanner.nextLine();
        System.out.println(" ");

        while (ics.getCustomer(customerNumber) != null) {
          System.out.println("Diese Kundenummer existiert nicht");
          System.out.println("Gueltige Kundenummer eingeben: ");
          customerNumber = scanner.nextLine();
          System.out.println(" ");
        }

        customer = ics.getCustomer(customerNumber);
        customerData = formatter.getSplitedString(customer);
        customerNumber = customerData[0];

        System.out.println("Kunde " + customerNumber + "hat folgende Konten: ");
        int j = 0;
        for (int i = 4; i < customerData.length; i++) {
          accounts[j] = customerData[i];
          j++;
        }

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");



        System.out.println(" ");
        System.out.println("=================================================");
        System.out.println("|    EINGELOGGT BEIM KUNDEN " + customerNumber + "  |");
        System.out.println("|===============================================|");
        System.out.println("|          Waehlen Sie eine Option aus:         |");
        System.out.println("|           1. Neues Konto eroeffnen            |");
        System.out.println("|           2. Passwort aendern                 |");
        System.out.println("|           3. Zahlungsauftrag erfassen         |");
        System.out.println("|           4. Kontostand abfragen              |");
        System.out.println("|           5. Geld abheben                     |");
        System.out.println("|           6. Geld einzahlen                   |");
        System.out.println("|           7. Kontoubertrag                    |");
        System.out.println("|           8. Beenden                          |");
        System.out.println("=================================================");
        System.out.println(" ");

        int number = scanner.nextInt();

        switch (number) {

          case 1:
            System.out.println("'Konto eröffnen' wurde ausgewaehlt");
            createBankAccount(customerNumber);
            break;

          case 2:
            System.out.println("'Passwort ändern' wurde ausgewaehlt");
            changePassword(customerNumber, accounts);
            break;

          case 3:
            System.out.println("'Zahlungsaufrag erfassen' wurde ausgewaehlt");
            payOffMoney(customerNumber, accounts);
            break;

          case 4:
            System.out.println("'Kontostand abfragen' wurde ausgewaehlt");
            getBalance(customerNumber, accounts);
            break;

          case 5:
            System.out.println("'Geld abheben' wurde ausgewaehlt");
            withdrawMoney(customerNumber, accounts);
            break;

          case 6:
            System.out.println("'Geld einzahlen' wurde ausgewaehlt");
            depositMoney(customerNumber, accounts);
            break;

          case 7:
            System.out.println("'Kontoübertrag' wurde ausgewaehlt");
            accountTransfer(customerNumber, accounts);
            break;

          case 8:
            System.out.println("Auf Wiedersehen");
            exit = false;
            break;

          default:
            System.out.println("Ungültige Eingabe");
        }
      }
    } catch (RemoteException e) {

      System.out.print("Exception aufgefangen");
    }
  }

  /**
   * This method ask for several user inputs to create a savings or private account
   * @param customerNumber to refer to the right customer after created a new account
   * @throws IOException if the asked input is not correct.
   * @throws RemoteException RemoteException throws if remote method calls fail.
   */
  void createBankAccount(String customerNumber) throws IOException {

    String tokens = ";";
    String accountArgs;
    String accountType;
    String balance;
    String interest;
    String creditLimit;
    String dailyLimit;
    String pin = "0000";

    System.out.println("=================================================");
    System.out.println("|                 Konto erfassen                |");
    System.out.println("=================================================");
    System.out.println(" ");

    System.out.println("Kontotyp eingeben: ");
    System.out.println("'1' für Sparkonto eingeben");
    System.out.println("'2' für Privatkonto eingeben");
    System.out.println(" ");
    accountType = scanner.nextLine();

    while (!(accountType.equals("1") || accountType.equals("2"))) {
      System.out.println("Falscher Kntotyp eingegeben!");
      System.out.println("Gültiger Kontotyp eingeben:");
      System.out.println(" ");
      System.out.println("'1' für Privatkonto eingeben");
      System.out.println("'2' für Sparkonto eingeben");
      accountType = scanner.nextLine();
      System.out.println(" ");
    }
    System.out.println("Startguthaben einzahlen? ");
    System.out.println("Betrag angeben:");
    balance = scanner.nextLine();
    System.out.println(" ");

    System.out.println("Individueller Zinssatz nach Einkommensprüfung eingeben: ");
    interest = scanner.nextLine();
    System.out.println(" ");

    System.out.println("Individueller Überziehungslimite nach Einkommensprüfung eingeben: ");
    System.out.println("Nur bei Privatkonto möglich!");
    creditLimit = scanner.nextLine();
    System.out.println(" ");

    System.out.println("Individueller Tages-Rückzugslimite nach Einkommensprüfung eingeben: ");
    dailyLimit = scanner.nextLine();
    System.out.println(" ");

    accountArgs = accountType + tokens + balance + tokens + interest + tokens + creditLimit + tokens
        + dailyLimit + tokens + pin;

    try {

      ics.createAccount(customerNumber, accountArgs);
      System.out.println("Konto wurde erfasst");

    } catch (NullPointerException | RemoteException e) {

      System.out.print("Exception aufgefangen");
    }

  }

  /**
   * This method is to change the password for EBanking or the account pin. The account pin
   * will changed randomly the the password can be changed as the customer want. 
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   * @throws IOException if the asked input is not correct.
   * @throws RemoteException throws if remote method calls fail.
   */
  void changePassword(String customerNumber, String[] accounts)
      throws IOException {
    System.out.println("=================================================");
    System.out.println("|                PASSWORT AENDERN               |");
    System.out.println("=================================================");
    System.out.println(" ");

    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }
    System.out.println("=================================================");
    System.out.println(" ");
    System.out.println("Fuer Konto Pin aendern '1' eingeben.");
    System.out.println("E-Banking Passwort aendern  '2' eingeben.");
    System.out.println(" ");
    int number = scanner.nextInt();
    try {
      switch (number) {

        case 1:
          System.out.println("Fuer welches Konto Pin aendern");
          System.out.println(" ");
          String accountNumber = scanner.nextLine();
          System.out.println("neuer Pin wird automatisch generiert! ");
          System.out.println(" ");
          ics.changeAccountPin(accountNumber);
          break;

        case 2:
          System.out.println("neues Passwort eingeben: ");
          System.out.println(" ");
          String newPassword = scanner.nextLine();
          ics.changeCustomerPassword(customerNumber, newPassword);
          break;
      }
    } catch (RemoteException e) {
      System.out.println("Exception aufegfangen");

    }
  }

  /**
   * This method is for make a payment to another account
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   * @throws BankLimitException if the defined bank limit will be reached. 
   * @throws RemoteException throws if remote method calls fail.
   */
  void payOffMoney(String customerNumber, String[] accounts)
      throws BankLimitException, RemoteException {
    String debitAccount;
    String targetAccount;
    String amount;
    System.out.println("=================================================");
    System.out.println("|           ZAHLUNGSAUFTRAG ERFASSEN            |");
    System.out.println("=================================================");
    System.out.println(" ");

    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }
    System.out.println(" ");
    System.out.println("Belastungskonto eingeben: ");
    debitAccount = scanner.nextLine();
    System.out.println(" ");
    System.out.println("Begünstigungskonto eingeben: ");
    targetAccount = scanner.nextLine();
    System.out.println(" ");
    System.out.println("Betrag eingeben: ");
    amount = scanner.nextLine();
    ics.transferMoney(debitAccount, targetAccount, amount);
  }

  /**
   * This method is to check the current balance of an account
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   */
  void getBalance(String customerNumber, String[] accounts)  {

    String[] accountData;
    System.out.println("=================================================");
    System.out.println("|              KONTOSTAND ABFRAGEN              |");
    System.out.println("|===============================================|");
    System.out.println(" ");
    // need to define how long the customerNumber will be...
    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }

    try {
      System.out.println("=================================================");
      System.out.println(" ");
      System.out.println("Gewünschtes Konto für Kontostand abfragen eingeben: ");
      System.out.println(" ");
      String accountNumber = scanner.nextLine();
      ics.getAccount(accountNumber);
      accountData = formatter.getSplitedString(accountNumber);
      System.out.println(" ");


      System.out.println("| Guthaben auf dem Konto " + accountNumber + " beträgt:      |");
      System.out.printf("|          CHF %s                               |%n", accountData[1]);
      System.out.println("|                                               |");
      System.out.println("=================================================");
      System.out.println(" ");

    } catch (RemoteException e) {
      System.out.println("Exception aufgefangen");
    }

  }

  /**
   * This method is to withdraw money from an account
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   * @throws BankLimitException if the defined bank limit will be reached.
   */
  void withdrawMoney(String customerNumber, String[] accounts)
      throws BankLimitException  {

    System.out.println("=================================================");
    System.out.println("|               GELD ABHEBEN                    |");
    System.out.println("=================================================");

    // need to define how long the customerNumber will be...
    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }
    System.out.println("=================================================");
    System.out.println(" ");

    try {
      System.out.println("Von welchem Konto abheben?");
      System.out.println("Kontonummer angbene: ");
      String accountNumber = scanner.nextLine();
      System.out.println(" ");
      System.out.println("Wie viel abheben?");
      System.out.println("Geldbetrag eingeben: ");
      String amount = scanner.nextLine();
      ics.payoffMoney(accountNumber, amount);
    } catch (RemoteException e) {

      System.out.println("Exception aufgefangen");
    }


  }


  /**
   * This method is to deposit money in an account.
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   */
  void depositMoney(String customerNumber, String[] accounts)  {

    System.out.println("=================================================");
    System.out.println("|               GELD EINZAHLEN                  |");
    System.out.println("=================================================");
    // need to define how long the customerNumber will be...
    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }
    System.out.println("=================================================");
    System.out.println(" ");

    System.out.println("Auf welches Konto einzahlen?");
    System.out.println("Kontonummer eingeben: ");
    System.out.println(" ");
    String targetAccount = scanner.nextLine();
    System.out.println(" ");
    System.out.println("Wie viel einzahlen?");
    System.out.println("Betrag eingeben: ");
    String amount = scanner.nextLine();
    System.out.println(" ");

    try {

      ics.depositMoney(targetAccount, amount);

    } catch (NullPointerException | RemoteException e) {
      System.out.print("Exception aufgefangen");
    }
    System.out.println("Einzahlung war erfolgreich!");
    System.out.println(" ");
  }


  /**
   * This method is to transfer money within own customer accounts.
   * @param customerNumber to refer the right customer.
   * @param accounts to have all accounts from that customer.
   * @throws BankLimitException if the defined bank limit will be reached.
   */
  void accountTransfer(String customerNumber, String[] accounts)
      throws BankLimitException {

    System.out.println("=================================================");
    System.out.println("|               KONTOÜBERTRAG                   |");
    System.out.println("=================================================");
    System.out.println(" ");
    // need to define how long the customerNumber will be...
    System.out.println("|        Kunde " + customerNumber + " hat folgende Konten:       |");
    for (String t : accounts) {
      // correct the format when we test this with a seven digits bankNumber
      System.out.printf("|         - %s                                |%n", t);
    }
    System.out.println("=================================================");
    System.out.println(" ");
    System.out.println("Belastungskonto eingeben: ");
    String debitAccount = scanner.nextLine();
    System.out.println(" ");
    System.out.println("Zielkonto eingeben: ");
    String targetAccount = scanner.nextLine();
    System.out.println(" ");
    System.out.println("Betrag eingeben: ");
    String amount = scanner.nextLine();

    try {

      ics.transferMoney(debitAccount, targetAccount, amount);

    } catch (NullPointerException | RemoteException e) {

      System.out.print("NullPointerException aufgefangen");
    }
    System.out.println("Geldübertrag war erfolgreich!");
    System.out.println(" ");
  }


}

