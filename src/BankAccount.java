public class BankAccount {
    private int balance = 30000;
    private String owner;
    private int stalkingCounter = 0;

    /**
     * Konstruktor for klassen BankAccount
     *
     * @param owner
     */
    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    /**
     * Indsætter eller trækker beløb fra kontoen
     * Hvis man vil trække et beløb kaldes beløbet med et negativt tal, da +- som bekendt bliver til minus.
     *
     * @param amount
     */
    public void doTransaction(int amount) {

        balance += amount; // same as balance = balance+ amount;
    }

    /**
     * Alle objekter har en toString metode. Det er den System.out.print kalder når du skriver sådan her: System.out.print(mitobjekt)
     * Resultatet ser ud i stil med dette her: BankAccount@6d311334
     * Hvis du vil have mere kontrol over hvordan instanser af dine egne klasser skal printes ud, skal du "OVERRIDE" (overskrive) toString
     * - og det ser sådan her ud:
     */

    @Override
    public String toString() {
        String s;
        s = owner + " : " + balance + "\n";
        return s;
    }


    public int getBalance() {

        stalkingCounter++;// Den her linje skal demonstrere en af de ting jeg som programmør kan få ud af begrænse adgangen klassens felter (bemærk feltet 'balance' i toppen af klassen er private).
        // Hver gang instansens saldo skal 'ses' udefra, skal det ske gennem denne metode og jeg kan så tilføje lidt  kode
        // I dette eksempel bliver en 'stalkingCounter' talt op. M.a.o.: jeg tracker olddata.txt om udefrakommende interesse i feltet saldo.

        return balance;
    }

    public String getOwner() {
        return owner;
    }
}