import java.util.*;
public class Main {
    //Program pozwoli nam kontrolować nasze lodówkowe zasoby.
    //Funkcje: dodawanie/usuwanie produktów, tworzenie listy zakupowej

    private static String[][] fridgeArray = new String[50][3];
    //deklaracja tablicy, w której będziemy przechowywać zawartość lodówki (max 50 produktów)
    //fridgeArray[][0] - nazwa produktu podana przez użytkownika
    //fridgeArray[][1] - ilość
    //fridgeArray[][2] - klucz do wyszukiwania: nazwa produktu, ale wszystkie litery są małe
    //zmiana liter na małe w nazwie naszego produktu
    //sprawi, że przy późniejszym wyszukiwaniu produktu
    //wielkość liter nie będzie miała znaczenia

    private static List shoppingList = new ArrayList();
    //deklaracja listy, w której będziemy przechowywać listę zakupów

    private static int n = 0;
    //deklaracja licznika elementów w lodówce

    private static int i;
    //rezerwacja miejsca w pamięci na i, które będziemy wykorzystywać do iteracji pętli

    public static void AddToFridge(String a, float b) {
        for (i = 0; i < fridgeArray.length; i++) {
            //operacja wykona się tyle razy ile zadeklarowaliśmy dostępnych miejsc w naszej "lodówce"
            if (fridgeArray[i][2] == null) {
                //szuka "wolnego" miejsca w tablicy i przypisuje tam nazwę produktu, ilość oraz nasz klucz
                fridgeArray[i][0] = a;
                fridgeArray[i][1] = Float.toString(b);
                fridgeArray[i][2] = a.toLowerCase();
                break;
            }
        }
        n++;
        //zwiększenie licznika o 1
        System.out.println("Produkt dodany pomyślnie.");
    }
    //funkcja dodaje nazwę produktu, ilość oraz klucz do tablicy, a następnie zwiększa licznik o 1

    public static void RemoveFromFridge(String a) {
        for(i=0;i<fridgeArray.length;i++){
            //operacja wykona się tyle razy ile zadeklarowaliśmy dostępnych miejsc w naszej "lodówce"
            temporaryList.clear();
            temporaryList.add(fridgeArray[i][2]);
            //czyści listę oraz tworzy listę jednoelementową z klucza z tablicy o indeksie [i][2]
            if (temporaryList.contains(a.toLowerCase())){
                //sprawdza czy podane przez użytkownika słowo zamienione na klucz znajduje się na liście kluczy
                fridgeArray[i][0] = null;
                fridgeArray[i][1] = null;
                fridgeArray[i][2] = null;
                break;
            }
        }
        n--;
        //zmniejszenie licznika o 1
        System.out.println("Produkt usunięty pomyślnie.");
    }
    //funkcja usuwa nazwę produktu, ilość oraz klucz z tablicy, a następnie zmniejsza licznik o 1

    private static List temporaryList = new ArrayList();
    //deklaracja miejsca w pamięci na listę tymczasową, której będziemy używać do różnych operacji

    public static void ArrayToList(){
        temporaryList.clear();
        for (i=0;i<fridgeArray.length;i++){
            //operacja wykona się tyle razy ile zadeklarowaliśmy dostępnych miejsc w naszej "lodówce"
            if (fridgeArray[i][2]!=null){
                temporaryList.add(fridgeArray[i][2]);
            }
        }
    }
    //funkcja tworzy listę z niepustych elementów tablicy o indeksie [i][2] (klucze), by móc wykonywać na niej różne operacje
    //czyli stworzona zostanie lista naszych wszystkich kluczy, które zapisaliśmy w tablicy
    //przy każdym użyciu funkcji lista tymczasowa zostaje wyczyszczona

    public static boolean Check(String a){
        ArrayToList();
        if(temporaryList.contains(a.toLowerCase())) {
            //sprawdza czy podane przez użytkownika słowo zamienione na klucz znajduje się na liście kluczy
            return true;
        }
        return false;
    }
    //funkcja korzysta z wyżej opisanej funkcji ArrayToList,
    //a następnie na podstawie stworzonej listy tymczasowej sprawdza czy element znajduje się na liście,
    //jednocześnie dając nam informację czy element znajduje się w tablicy

    public static void Overwrite(String a, float b){
        for(i=0;i<fridgeArray.length;i++){
            //operacja wykona się tyle razy ile zadeklarowaliśmy dostępnych miejsc w naszej "lodówce"
            temporaryList.clear();
            temporaryList.add(fridgeArray[i][2]);
            //czyści listę oraz tworzy listę jednoelementową z klucza z tablicy o indeksie [i][2]
            if (temporaryList.contains(a.toLowerCase())){
                //sprawdza czy podane przez użytkownika słowo zamienione na klucz znajduje się na liście kluczy
                fridgeArray[i][1] = Float.toString(b);
                break;
            }
        }
        System.out.println("Nadpisano pomyślnie.");
    }
    //funkcja nadpisuje ilość naszego produktu

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = null;
        String userInput = null;
        String temp = null;
        float userInputFloat;
        //deklaracja zmiennych, z których korzysta program

        final String defaultSwitch = "Nie rozumiem, spróbuj ponownie.";
        //deklaracja stałego ciągu znaków używanego przy iteracji switcha

        System.out.println("Witaj,");
        while (choice != "K") {
            //Operacje będą się wykonywać do momentu, gdy użytkownik nie wybierze opcji "Koniec programu"
            System.out.println("1 - Zarządzanie lodówką");
            System.out.println("2 - Zarządzanie listą zakupów");
            System.out.println("K - Koniec programu");
            choice = scanner.nextLine().toUpperCase();
            //wyświetla listę dostępnych opcji, czeka na odpowiedź od użytkownika
            //i w zależności od inputu użytkownika wykonuje wcześniej opisane operacje
            //gdy użytkownik wpisze coś z poza listy dostępnych opcji
            //wyświetlony zostanie zadeklarowany przez nas ciąg znaków zapisany w zmiennej defaultswitch
            switch (choice) {
                case "1":
                    while (choice != "P") {
                        //Operacje będą się wykonywać do momentu, gdy użytkownik nie wybierze opcji "Powrót"
                        System.out.println("Q - Wyświetlenie zawartości lodówki");
                        System.out.println("D - Dodanie produktu do lodówki");
                        System.out.println("U - Usunięcie produktu z lodówki");
                        System.out.println("P - Powrót");
                        choice = scanner.nextLine().toUpperCase();
                        //wyświetla listę dostępnych opcji, czeka na odpowiedź od użytkownika
                        //i w zależności od inputu użytkownika wykonuje wcześniej opisane operacje
                        //gdy użytkownik wpisze coś z poza listy dostępnych opcji
                        //wyświetlony zostanie zadeklarowany przez nas ciąg znaków zapisany w zmiennej defaultswitch
                        switch(choice){
                            default:
                                System.out.println(defaultSwitch);
                                continue;
                            case "Q":
                                //Wyświetlenie zawartości lodówki
                                ArrayToList();
                                if(temporaryList.isEmpty()){
                                    //jeśli w naszej wirtualnej lodówce nic nie ma to wyświetla poniższy ciąg znaków
                                    System.out.println("Lodówka jest pusta.");
                                }
                                else{
                                    //jeśli w naszej wirtualnej lodówce jest chociaż jedna rzecz to wyświetla poniższy ciąg znaków
                                    //oraz wypisuje kolejno każdy niepusty element tablicy: nazwa produktu oraz ilość
                                    System.out.println("Zawartość lodówki:");
                                    for (i = 0; i<fridgeArray.length;i++){
                                        if (fridgeArray[i][2]!=null){
                                            System.out.println(fridgeArray[i][0]+", ilość: "+fridgeArray[i][1]);
                                        }
                                    }
                                }
                                continue;
                            case "D":
                                //Dodanie produktu do lodówki
                                //program najpierw sprawdza czy nie została przekroczona maksymalna ilość produktów w lodówce
                                //jeśli została przekroczona to zasugeruje usunięcie produktów, aby móc dodać nowe
                                //jeśli nie to program kontynuuje działanie
                                if(n<fridgeArray.length){
                                    System.out.println("Podaj nazwę produktu, który chcesz dodać:");
                                    userInput = scanner.nextLine();
                                    //program prosi, by podać nazwę produktu, a następnie czeka na odpowiedź od użytkownika
                                    //za pomocą funkcji Check sprawdza czy produkt już znajduje się w lodówce
                                    //jeśli tak to pyta czy nadpisać ilość danego produktu i w zależności od wyboru nadpisuje lub wraca do menu
                                    //jeśli nie to wykonują się operacje mające na celu dodanie produktu do lodówki
                                    //program sprawdza czy podane przez użytkownika wartości są prawidłowe,
                                    //jeśli nie to nie pozwala kontynuować do czasu wprowadzenia prawidłowych wartości
                                    //wielkość liter oraz znak przecinka lub kropki w podanej liczbie nie mają znaczenia
                                    if(Check(userInput)==false) {
                                        while(true){
                                            try {
                                                System.out.println("Podaj ilość:");
                                                temp = scanner.nextLine();
                                                temp = temp.replace(',','.');
                                                userInputFloat = Float.parseFloat(temp);
                                                AddToFridge(userInput, userInputFloat);
                                                break;
                                            } catch (NumberFormatException nfe){
                                                System.out.println("Podana wartość nie jest liczbą. Spróbuj ponownie.");
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Ten produkt znajduje się już w lodówce. Czy chcesz nadpisać ilość?");
                                        System.out.println("T - Nadpisz ilość");
                                        System.out.println("N - Powrót do menu zarządzania lodówką");
                                        while (true){
                                            choice = scanner.nextLine().toUpperCase();
                                            temporaryList.clear();
                                            temporaryList.add(choice);
                                            if (temporaryList.contains("T") || temporaryList.contains("N")){
                                                break;
                                            }
                                            else {
                                                System.out.println(defaultSwitch);
                                            }
                                        }
                                        switch (choice){
                                            case "T":
                                                while(true){
                                                    try{
                                                        System.out.println("Podaj ilość do nadpisania:");
                                                        temp = scanner.nextLine();
                                                        temp = temp.replace(',','.');
                                                        userInputFloat = Float.parseFloat(temp);
                                                        Overwrite(userInput, userInputFloat);
                                                        break;
                                                    } catch (NumberFormatException nfe){
                                                        System.out.println("Podana wartość nie jest liczbą. Spróbuj ponownie.");
                                                    }
                                                }
                                                break;
                                            case "N":
                                                break;
                                            default:
                                                System.out.println(defaultSwitch);
                                                continue;
                                        }
                                    }
                                }
                                else {
                                    System.out.println("Lista jest pełna (max 50 produktów)! Usuń z listy produkty, by móc dodać nowe.");
                                }

                                continue;
                            case "U":
                                //Usunięcie produktu z lodówki
                                //program prosi, by podać nazwę produktu, a następnie czeka na odpowiedź od użytkownika
                                //za pomocą funkcji Check sprawdza czy produkt znajduje się w lodówce
                                //jeśli tak to wykonują się operacje mające na celu usunięcie produktu do lodówki,
                                //a następnie pyta czy dodać usunięty produkt do listy zakupów
                                //i w zależności od odpowiedzi użytkownika doda produkt do listy lub wróci do menu
                                //jeśli nie to wróci z informacją do użytkownika, że takiego produktu nie ma na liście i wróci do menu
                                //program sprawdza czy podane przez użytkownika wartości są prawidłowe,
                                //jeśli nie to nie pozwala kontynuować do czasu wprowadzenia prawidłowych wartości
                                //wielkość liter oraz znak przecinka lub kropki w podanej liczbie nie mają znaczenia
                                System.out.println("Podaj nazwę produktu, który chcesz usunąć:");
                                userInput = scanner.nextLine();
                                if(Check(userInput)==false) {
                                    System.out.println("Nie ma takiego produktu na liście.");
                                }
                                else{
                                    RemoveFromFridge(userInput);
                                    System.out.println("Czy chcesz dodać ten produkt do listy zakupów?");
                                    System.out.println("T - Tak");
                                    System.out.println("N - Nie");
                                    while (true){
                                        choice = scanner.nextLine().toUpperCase();
                                        temporaryList.clear();
                                        temporaryList.add(choice);
                                        if (temporaryList.contains("T") || temporaryList.contains("N")){
                                            break;
                                        }
                                        else {
                                            System.out.println(defaultSwitch);
                                        }
                                    }
                                    switch (choice){
                                        case "T":
                                            shoppingList.add(userInput.toUpperCase());
                                            System.out.println("Dodano do listy zakupów.");
                                            break;
                                        case "N":
                                            System.out.println("Powrót do menu zarządzania lodówką.");
                                            break;
                                    }
                                }

                                continue;
                            case "P":
                                //Powrót do menu głównego
                                break;
                        }
                        break;
                    }
                    continue;
                case "2":
                    while (choice != "P") {
                        //Operacje będą się wykonywać do momentu, gdy użytkownik nie wybierze opcji "Powrót"
                        System.out.println("Q - Wyświetlenie listy zakupów");
                        System.out.println("D - Dodanie produktu do listy");
                        System.out.println("U - Usunięcie produktu z listy");
                        System.out.println("W - Wyczyszczenie listy");
                        System.out.println("P - Powrót");
                        choice = scanner.nextLine().toUpperCase();
                        //wyświetla listę dostępnych opcji, czeka na odpowiedź od użytkownika
                        //i w zależności od inputu użytkownika wykonuje wcześniej opisane operacje
                        //gdy użytkownik wpisze coś z poza listy dostępnych opcji
                        //wyświetlony zostanie zadeklarowany przez nas ciąg znaków zapisany w zmiennej defaultswitch
                        switch(choice){
                            default:
                                System.out.println(defaultSwitch);
                                continue;
                            case "Q":
                                //Wyświetlenie listy zakupów
                                if (shoppingList.isEmpty()){
                                    //jeśli na naszej liście zakupów nic nie ma to wyświetla poniższy ciąg znaków
                                    System.out.println("Lista zakupów jest pusta.");
                                }
                                else{
                                    //jeśli na naszej liście zakupów jest chociaż jedna rzecz to wyświetla poniższy ciąg znaków
                                    System.out.println("Lista zakupów:");
                                    for (i = 0; i<shoppingList.size(); i++){
                                        System.out.println(shoppingList.get(i));
                                    }
                                }
                                continue;
                            case "D":
                                //Dodanie produktu do listy
                                //program prosi, by podać nazwę produktu, a następnie czeka na odpowiedź od użytkownika
                                //sprawdza czy produkt już znajduje się na liście
                                //jeśli tak to wróci z informacją do użytkownika, że taki produkt jest już na liście i wróci do menu
                                //jeśli nie to wykonują się operacje mające na celu dodanie produktu do listy
                                //wielkość liter nie ma znaczenia
                                System.out.println("Podaj nazwę produktu, który chcesz dodać do listy: ");
                                userInput = scanner.nextLine().toUpperCase();
                                if (shoppingList.contains(userInput)) {
                                    System.out.println("Ten produkt znajduje się już na liście zakupów.");
                                } else {
                                    shoppingList.add(userInput);
                                    System.out.println("Produkt dodany pomyślnie.");
                                }
                                continue;
                            case "U":
                                //Usunięcie produktu z listy
                                //program prosi, by podać nazwę produktu, a następnie czeka na odpowiedź od użytkownika
                                //sprawdza czy produkt znajduje się na liście
                                //jeśli tak to wykonują się operacje mające na celu usunięcie produktu do listy
                                //jeśli nie to wróci z informacją do użytkownika, że takiego produktu nie ma na liście i wróci do menu
                                //wielkość liter nie ma znaczenia
                                System.out.println("Podaj nazwę produktu, który chcesz usunąć z listy: ");
                                userInput = scanner.nextLine().toUpperCase();
                                if (shoppingList.contains(userInput)) {
                                    shoppingList.remove(userInput);
                                    System.out.println("Produkt usunięty pomyślnie.");
                                } else {
                                    System.out.println("Nie ma takiego produktu na liście.");
                                }
                                continue;
                            case "W":
                                //Wyczyszczenie listy
                                shoppingList.clear();
                                System.out.println("Lista wyczyszczona.");
                                continue;
                            case "P":
                                //Powrót do menu głównego
                                break;
                        }
                        break;
                    }
                    continue;
                case "K":
                    //Koniec programu
                    System.out.println("Do zobaczenia!");
                    break;
                default:
                    System.out.println(defaultSwitch);
                    continue;
            }
            break;
        }
    }
}