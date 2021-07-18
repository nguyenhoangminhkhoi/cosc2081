public class BasicOOP {
  public static void main(String[] args) {
    Course c1 = new Course();
    c1.setCode("COSC2081");
    c1.setName("Programming 1");
    c1.setCredit(3);
    System.out.printf("\nCourse obj %s - %s - %d", c1.getCode(), c1.getName(), c1.getCredit());

    Course c2 = new Course("COSC2030", "Web Programming", 3);
    System.out.printf("\nCourse obj %s - %s - %d", c2.getCode(), c2.getName(), c2.getCredit());

    RMITStudent s = new RMITStudent();
    s.name = "Tri";
    s.transcript = new Course[2];
    s.transcript[0] = c1;
    s.transcript[1] = c2;
  }
}

class RMITStudent {
  String name;
  Course[] transcript;
}

class Course {
  private String code;
  private String name;
  private int credits;

  public Course() {

  }

  public Course(String code, String name, int credits) {
    this.code = code;
    this.name = name;
    this.credits = credits;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setCredit(int credits) {
    if (credits <= 0) {
      return;
    }
    this.credits = credits;
  }

  public int getCredit() {
    return credits;
  }
}