package T4;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner in;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        ArrayList<Data> list = new ArrayList();
        while (true) {
            System.out.println("1.Add New Name? or\n2.Search by ID?\n1 or 2?  ");
            String qo = in.next();
            if (qo.equals("1")) {
                System.out.println("\nEnter new name");
                String reqName = in.next();

                System.out.println("Do u want an auto generated id? \n\ny or n ? ");
                String qo2 = in.next();

                if (qo2.equals("y")) {

                    Data obj = new Data();
                    obj.id = auto(list);
                    list.add(obj);
                    System.out.println("New id=" + obj.id);

                } else if (qo2.equals("n")) {
                    System.out.println("\nEnter Your ID");
                    int ans = in.nextInt();
                    Data obj2 = new Data();

                    boolean qo3 = getId(list, ans) != -1;
                    if (qo3) {
                        int index = getId(list, ans);
                        obj2 = list.get(index);
                        obj2.name = reqName;
                        obj2.id = ans;
                        list.set(index, obj2);

                    } else {
                        obj2.id = ans;
                        obj2.name = reqName;
                        list.add(obj2);

                    }
                    System.out.println(obj2.id);
                    System.out.println(obj2.name);
                }
            }
                else if (qo.equals("2")) {
                    Data obj = new Data();
                    System.out.println("Enter ID");
                    int idd = in.nextInt();
                    int index = getId(list, idd);
                   if(index!=-1) {
                       obj = list.get(index);
                       System.out.println(obj.name);
                   }
                   else System.out.println("User doesn't exist");
                }



            }
        }

    public static int getId(ArrayList<Data> list, int ans) {
        for (int i = 0; i < list.size(); i++) {
            if (ans == list.get(i).id) {
                return i;
            }
        }

        return -1;
    }
//1 2 3 4
    //5
    private static int auto(ArrayList<Data> list) {
        int autoId = 0;
        for (int counter2 =0; counter2 < list.size(); counter2++) {
                for (int counter3 = 1; counter3 < list.size() + 1; counter3++) {
                    if (list.get(counter2).id == autoId) {
                        continue;
                    }
                    else break;

                }
            autoId++;
        }
        return autoId;
    }
}




