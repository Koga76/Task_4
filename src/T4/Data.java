package T4;

public class Data extends Print {

    public String name;
    public int id;

    @Override
    public void printUser(String name) {
        System.out.println(name+" "+id);
    }
}

