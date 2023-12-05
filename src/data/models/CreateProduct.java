package data.models;

public class CreateProduct {
    private String name;
    private String descripcion;
    private String tipo;
    private String precio;
    public CreateProduct(String name, String descripcion, String tipo, String precio) {
        this.name = name;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.precio = precio;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getPrecio() {
        return precio;
    }
    public void setPrecio(String precio) {
        this.precio = precio;
    }
    // methods
    @Override
    public String toString() {
        return this.name + "," + this.descripcion + "," + this.tipo + "," + this.precio;
    }
}
