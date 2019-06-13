package kata1;

import java.time.LocalDate;

public class Kata1 {

    public static void main(String[] args) {
        Person person = new Person ("Kevin", LocalDate.of(1998, 11, 26));
        System.out.println("El usuario " + person.getName() + " tiene " + person.getAge() + " años.");
    }
}
