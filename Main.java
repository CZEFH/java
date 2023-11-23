6-1 sdut-oop-list-1 学生集合（类、集合）
class Student {
    String id, name;
    int age;
    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return id + " " + name + " " + age;
    }
}

6-2 根据要求，使用泛型和LinkedList编写StringList类，实现QQ号码查找的功能。
class StringList {
    LinkedList<String> constructList(String[] strs) {
        LinkedList<String> list = new LinkedList<>();
        Collections.addAll(list, strs);
        return list;
    }

    String search(LinkedList<String> list) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (String it : list)
            if (it.length() == n)
                return it;
        return "not exist";
    }
}

6-3 根据要求，使用泛型和LinkedList编写StringList类，统计某个指定位数(长度)的QQ号码的数量。
class StringList {
    LinkedList<String> constructList(String[] strs) {
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < strs.length; i ++)
            list.add(strs[i]);
        return list;
    }

    String search(LinkedList<String> list) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 0;
        for (String it : list)
            if (it.length() == n)
                cnt ++;
        if(cnt != 0) return String.valueOf(cnt);
        else return "-1";
    }
}

6-4 jmu-Java-05集合-List中指定元素的删除
public static List<String> convertStringToList(String line) {
    String[] ss = line.split("\\s+");
    List<String> list = new ArrayList<String>(Arrays.asList(ss));
    return list;
}

public static void remove(List<String> list, String str) {
    while(true)
    {
        ArrayList<String> l = new ArrayList<>();
        l.add(str);
        if(list.removeAll(l) == false) break;
    }
}

6-5 教师、学生排序
class Student extends Person{
    int sno;
    String major;
    public void setSno(int sno){
        this.sno = sno;
    }

    public int getSno(){
        return sno;
    }

    public void setMajor(String major){
        this.major = major;
    }

    public String getMajor(){
        return major;
    }

    public Student(int sno, String name, String gender, int age, String major){
        super(name,gender,age);
        this.sno = sno;
        this.major = major;
    }

    public int compareTo(Object a){
        Student o = (Student)a;
        return o.sno - this.sno;
    }
}

class Teacher extends Person{
    int tno;
    String subject;
    Teacher(int tno, String name, String gender, int age, String subject) {
        super(name, gender, age);
        this.tno = tno;
        this.subject = subject;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int compareTo(Object a) {
        Teacher o = (Teacher)a;
        return this.getAge() - o.getAge();
    }
}

class MyTool {
    public static void separateStu_T(List persons, List teachers, List students) {
        for(int i = 0; i < persons.size(); i ++)
        {
            if(persons.get(i) instanceof Student) students.add(persons.get(i));
            else teachers.add(persons.get(i));
        }
    }
}

6-6 Duplicated Numbers
public static ArrayList<Integer> pick(ArrayList<Integer> a) {
        HashSet<Integer> set = new HashSet<>(a);//用 Hashset 去重, 将结果转回ArrayList
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());//降序排序使用Collections.reverseOrder()
        return list;
}

6-7 Duplicated Words
public static ArrayList<String> pick(ArrayList<String> a) {
        ArrayList<String> list = new ArrayList<String>();
        for(int i = 0; i < a.size(); i ++)
        if(list.contains(a.get(i)) == false)
        list.add(a.get(i));
        Collections.sort(list);
        Collections.reverse(list);
        return list;
        }

6-8 根据已有类Worker，使用LinkedList编写一个WorkerList类，实现计算所有工人总工资的功能。
class WorkerList {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    public List<Worker> constructWorkerList() {
        List<Worker> list = new LinkedList<Worker>();
        for (int i = 0; i < num; i ++)
            list.add(readInWorker());
        return list;
    }

    public Worker readInWorker() {
        Worker wk = new Worker(sc.next(), sc.nextDouble());
        return wk;
    }

    public double computeTotalSalary(List<Worker> list) {
        double sum = 0;
        for (int i = 0; i < num; i ++)
            sum += list.get(i).getSalary();
        return sum;
    }
}