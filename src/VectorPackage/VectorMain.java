package VectorPackage;

public class VectorMain {
    public static void main(String[] args) {
        Vector3d a = new Vector3d(3.4,-8.1,4.5);
        Vector3d b = new Vector3d(-7.7,9.8,0);
        System.out.println("Vector multiplication produced: "+a.scalarMultiply(b));
       Vector3d c =  a.add(b);

        System.out.println("Vector multiplication produced: "+c.scalarMultiply(b));

    }
}
