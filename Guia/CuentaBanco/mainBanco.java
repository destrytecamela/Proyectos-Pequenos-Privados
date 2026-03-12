public class mainBanco {
    //main para probar las clases
    public static void main(String[] args) {
        //creamos 2 bancos con un maximo de 1000 cuentas
        Banco b1=new Banco("Banco de Extremadura",1000);
        Banco b2=new Banco("Sucursales de Extremadura",1000);

        //creamos 2 cuentas una joven y otra de ahorros
        Cuenta c1=new CuentaJoven(1,1000,new TitularCuenta("Carlos Gomez",12345678,16),0.05F);
        Cuenta c2=new CuentaAhorros(990,2000,new TitularCuenta("Maria Perez",87654321,30),0.03F);
        //añadimos las cuentas al banco b1
        b1.anadirCuenta(c1);
        b1.anadirCuenta(c2);
}
}
