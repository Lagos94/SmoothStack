package assignment4.concurrency;

class DCLocking {
    private static DCLocking instance;

    private DCLocking() { //Restricted to this class itself.
    }

    private static DCLocking getDCL() {

        if (instance == null) { //1st check
            synchronized (DCLocking.class) {
                if (instance == null) { //2nd check
                    instance = new DCLocking();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println("Intiailly, Singleton is "+ DCLocking.instance +" then DCL occurs, which yields: "+
                getDCL() + " address of the double checked locked " +
                "Singleton object and the standard Singleton object " +
                "address becomes " + DCLocking.instance);
    }
}