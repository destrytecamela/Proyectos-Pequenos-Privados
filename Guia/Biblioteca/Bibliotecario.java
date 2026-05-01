public class Bibliotecario extends Persona {

    private String seccion;
    private boolean esInvestigador;

    // Constructor sin parámetros
    public Bibliotecario() {
        super();
        this.seccion = "";
        this.esInvestigador = false;
    }

    // Constructor original (compatibilidad con código existente)
    public Bibliotecario(int id, String nombre, int edad, String seccion) {
        super(id, nombre, edad);
        this.seccion = seccion;
        this.esInvestigador = false;
    }

    // Constructor completo
    public Bibliotecario(int id, String nombre, int edad, String seccion, boolean esInvestigador) {
        super(id, nombre, edad);
        this.seccion = seccion;
        this.esInvestigador = esInvestigador;
    }

    // Getters y setters
    public String getSeccion() { return seccion; }
    public void setSeccion(String seccion) { this.seccion = seccion; }

    public boolean getEsInvestigador() { return esInvestigador; }
    public void setEsInvestigador(boolean esInvestigador) { this.esInvestigador = esInvestigador; }

    @Override
    public String toString() {
        return "Bibliotecario{" +
                "seccion='" + seccion + '\'' +
                ", esInvestigador=" + esInvestigador +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }

    @Override
    public boolean getSancionado() {
        return false;
    }
}
