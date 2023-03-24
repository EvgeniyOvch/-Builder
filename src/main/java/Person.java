import java.util.NoSuchElementException;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setSurname(surname)
                .setAddress(address)
                .setAge(0);
    }

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
        this.address = address;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void happyBirthday() {
        if (hasAge() == true) {
            age = OptionalInt.of(age.getAsInt() + 1);
        } else
            System.out.println("Ошибка. Установите сначала возраст!");
    }

    public void setAddress(String address) {
        if (hasAddress() == true) {
            this.address = address;
        } else {
            System.out.println("Задать адрес нельзя, он уже указан.");
        }
    }

    public void setAge(int age) {
        if (hasAge() == true) {
            this.age = OptionalInt.of(age);
        } else {
            System.out.println("Возраст задан, менять нельзя!");
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        try {
            return age.getAsInt();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    public String getAddress() {
        return address;
    }

    public boolean hasAge() {
        if (age.isPresent() == false) {
            return false;
        } else {
            return true;
        }
    }

    public boolean hasAddress() {
        return !address.equals(null);
    }

    @Override
    public String toString() {
        return getName() + " "
                + getSurname() + " возраст "
                + getAge() + " лет, проживает в "
                + getAddress();
    }

}


