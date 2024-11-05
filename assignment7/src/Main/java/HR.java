package Main.java;

public class HR extends Employee {

    public HR(String name, int id,  String deptName, String role) {
        super(name,id,deptName,role);
    }
    @Override
    public double getBasicSalary() {
    return 35000;   
    }

    @Override
    public double getBonus() {
      return 4000;
    }

    @Override
    public double getCompensation() {
       return 1500;
    }

}
