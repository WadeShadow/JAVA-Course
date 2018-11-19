import Comparators.ComparatorFactory;

import java.io.*;
import java.util.*;

public class Group implements  Serializable {
    private static final int groupCapacity = 10;

    private String groupName;
    private List<Student> students = new LinkedList<>();

    public Group(String groupName) {
        this.groupName = groupName;
    }


    public void add(Student newStudent) throws GroupOverflowException, AlreadyRegisteredStudentException {
        if (newStudent == null) return;
        if(newStudent.getAge()==0) return;
        for (Student groupStudent : students) {
            if (groupStudent.equals(newStudent))
                throw new AlreadyRegisteredStudentException();      //If we try to add an already present student
        }
        if (this.hasFreePlaces()) {
            students.add(newStudent);

            return;
        }
        throw new GroupOverflowException();
    }


    public void delete(Student student) {        //Deletes the first student with specified parameters ( We assume that there are no more than 1 equal students )
        if (student == null) return;

        if(!students.remove(student))
            System.out.println("No such student");

    }

    /**
     * @param lastName describes required last name to look for
     * @return GenTasks.Student whose last name equals to lastName argument, otherwise returns null
     */
    public Student findStudent(String lastName) {
        for (Student student : students) {
            if (student.getLastName().equalsIgnoreCase(lastName)) return student;
        }
        return null;
    }

    public void sortByLastName() {
        Arrays.sort(students, (Student student1, Student student2) -> {             //Sorting structure that sorts according to last name
            if (student1.getLastName().compareTo(student2.getLastName()) < 0) return -1;
            if (student1.getLastName().compareTo(student2.getLastName()) > 0) return 1;
            return 0;
        });
    }

    /**
     * @param parameter represents names of the fields in GenTasks.Student or GenTasks.Person
     */
    public void sortBy(String parameter) {
        Comparator comparator = ComparatorFactory.getComparator(parameter);      //ComparatorFactory creates a comparator for any suitable parameter name that corresponds to field names

        students.sort(comparator);
    }



    public boolean hasFreePlaces() {
        if (students.size() < groupCapacity) return true;
        return false;
    }

    public void groupFileOutput(String destFile) {

        String path = destFile + groupName + ".txt";
        File groupFile = new File(path);
        if (groupFile.exists()) {
            System.out.println("File " + groupName + ".txt" + " already exists");
            return;
        }
        try (Scanner stringScanner = new Scanner(this.toString());
             BufferedWriter groupWriter = new BufferedWriter(new FileWriter(path))) {
            String str;
            while (stringScanner.hasNext()) {
                str = stringScanner.nextLine();
                groupWriter.write(str + '\n');
            }
        } catch (IOException ex) {
            System.out.println("I/O Exception " + ex);
        }

    }

    public static Group readGroupFrom(String fileSource) {
        Group newGroup= null;
        File groupFile = new File(fileSource);
        if (!groupFile.exists() || !groupFile.isFile()) {
            System.out.println("It is impossible to read from this source");
        }
        try (BufferedReader groupReader = new BufferedReader(new FileReader(groupFile))) {
            String str;
            newGroup = new Group(groupReader.readLine());
            try {
                while ((str = groupReader.readLine()) != null) {
                    parseStudent(newGroup,str);
                }
            }catch (GroupOverflowException|AlreadyRegisteredStudentException ex){
                System.out.println("Cannot load all these students: "+ex);
            }
        }catch (IOException ex){
            System.out.println("I/O Exception happened "+ex);
        }
        return newGroup;
    }

    private static void parseStudent(Group group, String studentLine) throws GroupOverflowException, AlreadyRegisteredStudentException{
        //String firstName, String lastName, int height, int age, String gender, String degree, String specialization
        String lastname ="", firstname="", gender="", degree="", specialization="";
        int height=0, age=0;
        String[] groupParams = studentLine.split(",");                  //Dividing the line by commas into pieces like "lastname = 'Oswald'"
        for (String param : groupParams) {
            String[] variableAndValue = param.split("=");        //Then dividing into two strings like [0]=lastname, [1]='Oswald'
            variableAndValue[1] = variableAndValue[1].replace("'", "").trim();
            variableAndValue[0] = variableAndValue[0].trim();
            if (variableAndValue[0].equalsIgnoreCase("lastname")) {
                lastname = variableAndValue[1];
            }
            if (variableAndValue[0].equalsIgnoreCase("firstname")) {
                firstname = variableAndValue[1];
            }
            if (variableAndValue[0].equalsIgnoreCase("height")) {
                height = Integer.parseInt(variableAndValue[1]);
            }
            if (variableAndValue[0].equalsIgnoreCase("age")) {
                age = Integer.parseInt(variableAndValue[1]);
            }
            if(variableAndValue[0].equalsIgnoreCase("gender")){
                gender = variableAndValue[1];
            }
            if (variableAndValue[0].equalsIgnoreCase("degree")) {
                degree = variableAndValue[1];
            }
            if (variableAndValue[0].equalsIgnoreCase("specialization")) {
                specialization = variableAndValue[1];
            }
        }

        group.add(new Student(firstname, lastname, height, age, gender, degree, specialization));


    }

    @Override
    public String toString() {
        if (students != null) {
            LinkedList<Student> tempStudents = new LinkedList<>();
            tempStudents.addAll(students);
            tempStudents.sort((Student student1, Student student2) -> {             //Sorting structure that sorts according to last name, first name lexicographic order
                if (student1.getLastName().compareTo(student2.getLastName()) < 0) return -1;
                if (student1.getLastName().compareTo(student2.getLastName()) > 0) return 1;
                if (student1.getFirstName().compareTo(student2.getLastName()) < 0) return -1;
                if (student1.getFirstName().compareTo(student2.getFirstName()) > 0) return 1;
                return 0;
            });

            StringBuilder result = new StringBuilder(groupName + '\n');
            for (Student student : tempStudents) {
                result.append(student.toString());
                result.append('\n');
            }
            return new String(result);
        }
        return groupName + '\n';
            

            
    }

    class GroupOverflowException extends Exception {
        @Override
        public String getMessage() {
            return "GenTasks.Group cannot contain more than " + groupCapacity + " students ";
        }

        @Override
        public String toString() {
            return "Exception: " + getMessage();
        }
    }

    class AlreadyRegisteredStudentException extends Exception {
        @Override
        public String getMessage() {
            return "Such a student is already present in this group";
        }

        @Override
        public String toString() {
            return "Exception: " + getMessage();
        }
    }

}
