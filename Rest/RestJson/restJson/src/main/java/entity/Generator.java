package entity;

public class Generator {

    public static String generatePerson(int amount, int startID) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < amount; i++) {
            int tempAge = (int) ((Math.random() * 53) + 17);
            if (i == amount - 1) {
                sb.append("{\"fname\": \"Henrik\", \"lname\": \"Peterson\", \"id\": " + (startID + i) + ", \"age\":" + tempAge + "}]");
            } else {
                sb.append("{\"fname\": \"Janne\", \"lname\": \"Peterson\", \"id\": " + (startID + i) + ", \"age\":" + tempAge + "},");
            }
        }
        return sb.toString();
    }
}

//Hvis du har lettere ved at forholde dig til entity klasser, er JSON objekterne her, 
//svarende til Person klassen i entity packagen. 
//Men person bliver ikke brugt i Generatoren eller har noget med rest at gøre.

