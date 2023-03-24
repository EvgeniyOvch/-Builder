public class PersonBuilder {
    private String address;
    private String name;
    private String surname;
    private int age;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (age < 0) {
            throw new IllegalArgumentException("Не допустимый возраст");
        }
        if (name == null) {
            throw new IllegalStateException("Нет имени");
        }
        if (surname == null) {
            throw new IllegalStateException("Нет фамилии");
        }
        if (address == null) {
            throw new IllegalStateException("Нет адреса");
        }
        return new Person(name, surname, age, address);
    }
}
