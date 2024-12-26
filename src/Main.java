public class Main {
    private static final Helper help = new Helper();
    private static final ConsoleTexts console = new ConsoleTexts();
    private static final ApplyChoices apply = new ApplyChoices();

    public static void main(String[] args) {
        int choice;
        console.welcome();
        console.sortORsearch();
        choice = help.getInt(">\t\t", 2);
        apply.sortORsearch(choice);
    }
}