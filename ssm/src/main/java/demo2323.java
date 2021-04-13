

public class demo2323 {
    public static boolean demo(Node node1,Node node2){
        if (node1==null && node2==null) return true;
        if ((node1==null && node2!=null)||(node1!=null && node2==null)) return false;
        Node n1 = node1;
        Node n2 = node2;
        while (n1!=null && n2!=null){
            if (n1.getValue()==n2.getValue()){
                n1 = n1.getNext();
                n2 = n2.getNext();
            }
            if (n1.getValue()!=n2.getValue()) return false;

        }
        if(n1==null && n2==null) return true;
        return false;

    }
    public void zxcdf(Node node){
        while (node!=null){
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }
}
