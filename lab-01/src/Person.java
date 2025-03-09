public class Person {
    private String name;
    private int age;

    public Person()
    {
        this.name = "No name";
        this.age = -1;
    }

    public Person(String name)
    {
        this.name = name;
        this.age = -1;
    }

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String toString()
    {
        String noName = "No name";
        if(noName.equals(this.name))
        {
            return "I am John Doe";
        }
        if(this.age == -1)
        {
            return "Hello, I am " + this.name;
        }

        return "Hello, I am " + this.name + ". I am " + this.age + " years old";
    }
}
