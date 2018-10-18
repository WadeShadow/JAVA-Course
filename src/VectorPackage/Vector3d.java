package VectorPackage;

public class Vector3d {
    public double[] coordinates = new double[3];

    public Vector3d(double c1, double c2, double c3){
        this.coordinates[0]=c1;
        this.coordinates[1]=c2;
        this.coordinates[2]=c3;
    }
    public Vector3d add(Vector3d vector){
        Vector3d a = new Vector3d(this.coordinates[0],this.coordinates[1],this.coordinates[2]);
        for(int i =0; i<3;++i){
            a.coordinates[i]+=vector.coordinates[i];
        }
        return  a;
    }
    public double scalarMultiply(Vector3d vector){
        double[] a = new double[3];
        double[] b = new double[3];
        a = this.coordinates;
        b=vector.coordinates;
        return a[0]*b[0]+a[1]*b[1]+a[2]*b[2];
    }
}
