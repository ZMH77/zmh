public class Student {
    private  int id;
    private  String name;
    private int yu;
    private int shu;
    private int ying;
    private int wu;
    private int hua;
    private int sheng;
    private int zong;
    public Student (String s){
      String[] split = s.split(",");
      this.id= Integer.parseInt(split[0]);
      this.name=split[1];
      this.yu=Integer.parseInt(split[2]);
      this.shu=Integer.parseInt(split[3]);
      this.ying=Integer.parseInt(split[4]);
      this.wu=Integer.parseInt(split[5]);
      this.hua=Integer.parseInt(split[6]);
      this.sheng=Integer.parseInt(split[7]);
      this.zong=yu+shu+ying+wu+hua+sheng;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yu=" + yu +
                ", shu=" + shu +
                ", ying=" + ying +
                ", wu=" + wu +
                ", hua=" + hua +
                ", sheng=" + sheng +
                ", zong=" + zong +
                '}';
    }

    public Boolean toEq(Student s ){
        if (this.zong==s.zong){
            return  true;
        }else {
            return false;
        }

    }
    public Student(){

    }
    public Student(int id, String name, int yu, int shu, int ying, int wu, int hua, int sheng) {
        this.id = id;
        this.name = name;
        this.yu = yu;
        this.shu = shu;
        this.ying = ying;
        this.wu = wu;
        this.sheng = sheng;
        this.hua = hua;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYu() {
        return yu;
    }

    public void setYu(int yu) {
        this.yu = yu;
    }

    public int getShu() {
        return shu;
    }

    public void setShu(int shu) {
        this.shu = shu;
    }

    public int getYing() {
        return ying;
    }

    public void setYing(int ying) {
        this.ying = ying;
    }

    public int getWu() {
        return wu;
    }

    public void setWu(int wu) {
        this.wu = wu;
    }

    public void setSheng(int sheng){
        this.sheng =sheng;
    }
    public int getSheng(){
        return sheng;
    }

    public int getHua() {
        return hua;
    }

    public void setHua(int hua) {
        this.hua = hua;
    }

    public int getZong() {
        return zong;
    }

    public void setZong(int zong) {
        this.zong = zong;
    }
}
