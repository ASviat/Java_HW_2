/**
 * Дана строка sql-запроса "select * from students where ". Сформируйте часть
 * WHERE этого запроса, используя StringBuilder.
 * Данные для фильтрации приведены ниже в виде json-строки.
 * 
 * Если значение null, то параметр не должен попадать в запрос.
 * 
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
 * "city":"Moscow", "age":"null"}
 */

public class Task01 {

    public static void main(String[] args) {
        String[] myString = { "'name':'Ivanov'", "'country':'Russia'", "'city':'Moscow'", "'age':'null'" };
        System.out.printf("SELECT * FROM STUDENTS WHERE NAME = %s AND COUNTRY = %s AND CITY = %s",
                GimmeThat(0, myString), GimmeThat(1, myString), GimmeThat(2, myString));
    }

    public static String GimmeThat(int i, String[] myString) {
        int ind = myString[i].indexOf(':');
        return myString[i].substring(++ind);
    }
}
