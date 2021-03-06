public class Student extends Person implements Cloneable {

  private String previousOrganization;
  private int skippedDays;

  public Student(String name, int age, String gender, String previousOrganization) throws CloneNotSupportedException {
    super(name, age, gender);
    this.previousOrganization = previousOrganization;
    this.skippedDays = 0;
  }

  public Student() {
    super();
    previousOrganization = "The School of Life";
    skippedDays = 0;
  }

  public void introduce() {
    System.out.println("Hi, I'm " + getName() + " , a " + getAge() + " year old " + getGender() + " from "
            + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
  }

  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  public int skipDays(int numberOfDays) {
    return skippedDays + numberOfDays;
  }


  @Override
  public Object clone()throws CloneNotSupportedException{
    return super.clone();
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + getName() + '\'' +
            ", previousOrganization='" + previousOrganization + '\'' +
            ", skippedDays=" + skippedDays +
            '}';
  }
}
