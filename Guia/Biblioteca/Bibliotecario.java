/**
 * Representa a un bibliotecario del sistema.
 * Hereda de Persona e incluye la sección en la que trabaja.
 * Si la sección es "Investigador", puede gestionar préstamos de investigadores.
 */
public class Bibliotecario extends Persona {

    private String seccion;
    private boolean esInvestigador;

    /** Constructor por defecto. */
    public Bibliotecario() {
        super();
        this.seccion        = "";
        this.esInvestigador = false;
    }

    /**
     * Constructor parametrizado.
     * @param i Identificador único.
     * @param n Nombre.
     * @param e Edad.
     * @param s Sección en la que trabaja.
     * @param a true si puede gestionar préstamos de investigadores.
     */
    public Bibliotecario(int i, String n, int e, String s, boolean a) {
        super(i, n, e);
        this.seccion        = s;
        this.esInvestigador = a;
    }

    // Getters y setters
    public String getSeccion()              { return seccion; }
    public boolean getEsInvestigador()      { return esInvestigador; }
    public void setSeccion(String s)        { this.seccion = s; }
    public void setEsInvestigador(boolean a){ this.esInvestigador = a; }

    @Override
    public boolean getSancionado() { return false; }

    /**
     * Devuelve información del bibliotecario.
     * @return Cadena con datos del bibliotecario.
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", Sección: " + seccion;
    }

    @Override
    public String toString() {
        return "Bibliotecario{seccion=" + seccion + ", esInvestigador=" + esInvestigador
               + ", id=" + id + ", nombre=" + nombre + ", edad=" + edad + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bibliotecario)) return false;
        return super.equals(o);
    }
}