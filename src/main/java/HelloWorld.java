public class HelloWorld {

    public static void main(String[] args) {

        Student s = new Student("hero");

        Student s1 = new Student("prav");

        Student.colg = "DEF corp";

        System.out.println(s.name + " " + Student.colg);
        System.out.println(s1.name + " " + Student.colg);

        Student.InnerClass inn = new Student().new InnerClass();

        Student.StaticClass sc = new Student.StaticClass();

        sc.staticDisplayName();
        inn.displayName();


        if(Float.NaN == Float.NaN){
            System.out.println("float true");
        }else{
            System.out.println("float false");
        }


//        System.out.println("address s +" + s + "  address of s1 "+ s1 + " colg "+ Student.colg + s.colg);
    }

}

class Student{
    String name;
    static String colg = "ABC corp";

    public static Student getIns(){
        return new Student();
    }

    Student(){
    }

    Student(String n){
        this.name = n;
    }

    public void print(){
        System.out.println(name);
    }
    public static void printStatic(){
        System.out.println(":: printStatic :: "+colg);
    }


    class InnerClass{
        public void displayName(){
            System.out.println("Display name from inner class :::"+name);
        }
    }

    static class StaticClass {
        public void staticDisplayName(){
            // Only static variables can be accessed in Static class
            System.out.println("From static class ::" + colg);
            Student.printStatic();
            new Student().print();
        }
    }

}

